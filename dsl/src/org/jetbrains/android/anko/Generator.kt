/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.android.anko

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.InnerClassNode
import java.util.TreeMap
import java.util.Arrays
import org.jetbrains.android.anko.AnkoFile.*
import org.jetbrains.android.anko.utils.toProperty
import org.objectweb.asm.tree.FieldNode

data class ListenerMethod(val method: MethodNode, val name: String, val argumentTypes: String, val returnType: String)

abstract class Listener(val setter: MethodNodeWithClass, val clazz: ClassNode)

data class SimpleListener(
        setter: MethodNodeWithClass,
        clazz: ClassNode,
        val method: ListenerMethod
): Listener(setter, clazz)

data class ComplexListener(
        setter: MethodNodeWithClass,
        clazz: ClassNode,
        val name: String,
        val methods: List<ListenerMethod>
): Listener(setter, clazz)

data class ViewProperty(val name: String, val getter: MethodNodeWithClass?, val setters: List<MethodNodeWithClass>)

data class LayoutParamsNode(val layout: ClassNode, val layoutParams: ClassNode, val constructors: List<MethodNode>)

class Generator(val classTree: ClassTree, config: BaseGeneratorConfiguration): Configurable(config) {

    private val availableClasses = classTree.filter { !it.isExcluded() }

    private val availableMethods = availableClasses.flatMap { clazz ->
        clazz.methods
                ?.map { MethodNodeWithClass(clazz, it) }
                ?.filter { !it.isExcluded() }
                ?: listOf()
    }

    // Views and viewGroups without custom LayoutParams
    val viewClasses = availableClasses
        .filter { it.isView && !it.isViewGroupWithParams }
        .sortBy { it.name }

    val viewGroupClasses = availableClasses
        .filter { it.isViewGroupWithParams }
        .sortBy { it.name }

    val listeners = availableMethods
            .filter { it.clazz.isView && it.method.isPublic && it.method.isListenerSetter }
            .map { makeListener(it) }
            .sortBy { it.setter.identifier }

    private val propertyGetters = generate(PROPERTIES) {
        availableMethods
                .filter { it.clazz.isView && !(it.clazz.isViewGroup && it.clazz.isAbstract) &&
                        it.method.isGetter() && !it.method.isOverridden && !it.method.isListenerGetter &&
                        !config.excludedProperties.contains(it.clazz.fqName + "#" + it.method.name) &&
                        !config.excludedProperties.contains(it.clazz.fqName + "#*")
                }
                .sortBy { it.identifier }
    }

    private val propertySetters = availableMethods
            .filter { it.clazz.isView && it.method.isNonListenerSetter() && !it.method.isOverridden }
            .groupBy { it.identifier }

    val properties = genProperties(propertyGetters, propertySetters)

    // Find all ancestors of ViewGroup.LayoutParams in classes that extends ViewGroup.
    val layoutParams = viewGroupClasses
            .map { extractLayoutParams(it) }
            .filterNotNull()
            .sortBy { it.layout.name }

    val services = generate(SERVICES) {
        classTree.findNode("android/content/Context")?.data?.fields
            ?.filter { it.name.endsWith("_SERVICE") }
            ?.map { it.name to classTree.findNode("android", it.toServiceClassName()) }
            ?.filter { it.second != null }
            ?.sortBy { it.first }
            ?: listOf()
    }

    val interfaceWorkarounds = generate(INTERFACE_WORKAROUNDS) {
        availableClasses.filter { clazz ->
            clazz.isPublic && clazz.innerClasses != null && clazz.fields.isNotEmpty() &&
                clazz.innerClasses.any { inner -> inner.isProtected && inner.isInterface && inner.name == clazz.name }
        }.map { clazz ->
            // We're looking for a public ancestor for this interface, but ancestor also may be protected
            val ancestor = classTree.filter { clazz ->
                clazz.isPublic && clazz.interfaces.any { interface -> interface == clazz.name } &&
                !clazz.innerClasses.any { it.name == clazz.name && it.isProtected }
            }
            val innerClass = clazz.innerClasses.firstOrNull {
                inner -> inner.isProtected && inner.isInterface && inner.name == clazz.name
            }
            Triple(clazz, ancestor.firstOrNull(), innerClass)
        }.filter { it.second != null && it.third != null }
    }

    //Convert list of getters and map of setters to property list
    private fun genProperties(
            getters: Collection<MethodNodeWithClass>,
            setters: Map<String, List<MethodNodeWithClass>>) : List<ViewProperty> {
        val existingProperties = hashSetOf<String>()

        val propertyWithGetters = getters.map { getter ->
            val property = getter.toProperty()
            val settersList = setters.get(property.setterIdentifier) ?: listOf()

            val (best, others) = settersList.partition {
                it.method.args.size() == 1 && it.method.args[0] == getter.method.returnType
            }

            existingProperties.add(property.setterIdentifier)
            ViewProperty(property.name, getter, best + others)
        }
        val propertyWithoutGetters = setters.values().map { setters ->
            val property = setters.first().toProperty()

            val id = property.setterIdentifier
            if (property.propertyFqName in config.propertiesWithoutGetters && id !in existingProperties) {
                ViewProperty(property.name, null, setters)
            } else null
        }.filterNotNull()
        return propertyWithGetters + propertyWithoutGetters
    }

    //suppose "setter" is a correct setOn*Listener method
    private fun makeListener(setter: MethodNodeWithClass) : Listener {
        val listener = classTree.findNode(setter.method.args[0].internalName)!!.data

        val methods = listener.methods?.filter { !it.isConstructor }

        val rawName = setter.method.name
        //delete "set" ("add") end "Listener" parts of String
        val name = rawName.substring("set".length()).dropLast("Listener".length()).decapitalize()

        return when (methods?.size() ?: 0) {
            1 -> { // It is a simple listener, with just one method
                val method = methods!![0]
                val argumentTypes = method.fmtArgumentsTypes()
                val returnType = method.returnType.asString()
                SimpleListener(setter, listener, ListenerMethod(method, name, argumentTypes, returnType))
            }
            0 -> // Something weird
                throw RuntimeException("Listener ${listener.name} contains no methods.")
            else -> { // A complex listener (with more than one method)
                val listenerMethods = methods?.map { method ->
                    val methodName = method.name
                    val argumentTypes = method.fmtArgumentsTypes()
                    val returnType = method.returnType.asString()
                    ListenerMethod(method, methodName, argumentTypes, returnType)
                }!!
                ComplexListener(setter, listener, name, listenerMethods)
            }
        }
    }

    //return a pair<viewGroup, layoutParams> or null if the viewGroup doesn't contain custom LayoutParams
    private fun extractLayoutParams(viewGroup: ClassNode): LayoutParamsNode? {
        if (viewGroup.innerClasses == null) return null

        val innerClasses = viewGroup.innerClasses
        val lp = innerClasses.firstOrNull { it.name.contains("LayoutParams") }
        if (lp == null) return null

        val lpNode = classTree.findNode(lp.name)?.data

        return if (lpNode != null) {
            LayoutParamsNode(viewGroup, lpNode, lpNode.getConstructors().filter { it.isPublic })
        } else null
    }

    //returns true if the viewGroup contains custom LayoutParams class
    private fun hasLayoutParams(viewGroup: ClassNode): Boolean {
        return !viewGroup.isAbstract && extractLayoutParams(viewGroup) != null
    }

    private val MethodNode.isListenerGetter: Boolean
        get() = name.startsWith("get") && name.endsWith("Listener")

    private val ClassNode.isView: Boolean
        get() = isView(classTree)

    private val ClassNode.isViewGroup: Boolean
        get() = isViewGroup(classTree)

    private val ClassNode.isViewGroupWithParams: Boolean
        get() = isViewGroup(classTree) && hasLayoutParams(this)

    private fun ClassNode.isExcluded() =
        fqName in config.excludedClasses || "$packageName.*" in config.excludedClasses

    private fun MethodNodeWithClass.isExcluded() =
        (this.clazz.fqName + "#" + this.method.name) in config.excludedMethods

    private fun FieldNode.toServiceClassName(): String {
        var nextCapital = true
        val builder = StringBuilder()
        for (char in name.replace("_SERVICE", "_MANAGER").toCharArray()) when (char) {
            '_' -> nextCapital = true
            else -> builder.append(
                    if (nextCapital) { nextCapital = false; char } else Character.toLowerCase(char)
            )
        }
        return builder.toString()
    }

    private fun String.dropLast(n: Int) = if (n >= length()) "" else substring(0, length() - n)

}