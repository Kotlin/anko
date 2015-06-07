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

import org.jetbrains.android.anko.config.AnkoConfiguration
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.InnerClassNode
import java.util.TreeMap
import java.util.Arrays
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.config.Configurable
import org.jetbrains.android.anko.config.generate
import org.jetbrains.android.anko.config.generateList
import org.jetbrains.android.anko.generator.*
import org.jetbrains.android.anko.utils.ClassTreeUtils
import org.jetbrains.android.anko.utils.toProperty
import org.objectweb.asm.tree.FieldNode

class Generator(
        public override val classTree: ClassTree,
        config: AnkoConfiguration,
        isSupport: Boolean
) : Configurable(config), ClassTreeUtils {

    private val availableClasses = findAvailableClasses()
    private val availableMethods = findAvailableMethods(availableClasses)

    // Views and viewGroups without custom LayoutParams
    val viewClasses = availableClasses
            .filter { it.isView && !it.isViewGroupWithParams }
            .map { ViewElement(it, it.isViewGroup) }
            .sortBy { it.view.name }

    val viewGroupClasses = availableClasses
            .filter { it.isViewGroupWithParams }
            .map { ViewElement(it, true) }
            .sortBy { it.view.name }

    val listeners = availableMethods
            .filter { it.clazz.isView && it.method.isPublic && it.method.isListenerSetter }
            .map { makeListener(it) }
            .sortBy { it.setter.identifier }

    private val propertyGetters = generateList(PROPERTIES) {
        availableMethods
                .filter {
                    it.clazz.isView &&
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
            .map { extractLayoutParams(it.view) }
            .filterNotNull()
            .sortBy { it.layout.name }

    val services = generateList(SERVICES) {
        classTree.findNode("android/content/Context")?.data?.fields
                ?.filter { it.name.endsWith("_SERVICE") }
                ?.map {
                    val service = classTree.findNode("android", it.toServiceClassName())?.data
                    if (service != null) ServiceElement(service, it.name) else null
                }
                ?.filterNotNull()
                ?.sortBy { it.name }
                ?: listOf()
    }

    // Generate actionbar properties
    val actionbarPropertyGetters = generateList(PROPERTIES) {
        availableMethods
                .filter { ((isSupport && it.clazz.isSupportActionBar) || (!isSupport && it.clazz.isActionBar)) &&
                        it.method.isGetter() && !it.method.isOverridden && !it.method.isListenerGetter &&
                        !config.excludedProperties.contains(it.clazz.fqName + "#" + it.method.name) &&
                        !config.excludedProperties.contains(it.clazz.fqName + "#*")
                }
                .sortBy { it.identifier }
    }

    val actionbarPropertySetters = availableMethods
            .filter { ((isSupport && it.clazz.isSupportActionBar) || (!isSupport && it.clazz.isActionBar)) && it.method.isNonListenerSetter() && !it.method.isOverridden }
            .groupBy { it.identifier }

    val actionbarProperties = genProperties(actionbarPropertyGetters, actionbarPropertySetters)
    // ~~~

    val interfaceWorkarounds = generateList(INTERFACE_WORKAROUNDS) {
        availableClasses.filter {
            it.isPublic && it.innerClasses != null && it.fields != null && it.fields.notEmpty &&
                    it.innerClasses.any { inner -> inner.isProtected && inner.isInterface && inner.name == it.name }
        }.map {
            // We're looking for a public ancestor for this interface, but the ancestor also may be protected inner one
            val ancestor = classTree.filter {
                clazz -> clazz.isPublic && clazz.interfaces.any { itf -> itf == it.name } && (
                    clazz.innerClasses == null ||
                            clazz.innerClasses.isEmpty() ||
                            !clazz.innerClasses.any { it.name == clazz.name && it.isProtected }
                    )
            }.firstOrNull()
            val innerClass = it.innerClasses.firstOrNull {
                inner -> inner.isProtected && inner.isInterface && inner.name == it.name
            }

            if (ancestor != null && innerClass != null)
                InterfaceWorkaroundElement(it, ancestor, innerClass)
            else null
        }.filterNotNull()
    }

    //Convert list of getters and map of setters to property list
    private fun genProperties(
            getters: Collection<MethodNodeWithClass>,
            setters: Map<String, List<MethodNodeWithClass>>): List<PropertyElement> {
        val existingProperties = hashSetOf<String>()

        val propertyWithGetters = getters.map { getter ->
            val property = getter.toProperty()
            val settersList = setters.get(property.setterIdentifier) ?: listOf()

            val (best, others) = settersList.partition {
                it.method.args.size() == 1 && it.method.args[0] == getter.method.returnType
            }

            existingProperties.add(property.setterIdentifier)
            PropertyElement(property.name, getter, best + others)
        }
        val propertyWithoutGetters = setters.values().map { setters ->
            val property = setters.first().toProperty()

            val id = property.setterIdentifier
            if (property.propertyFqName in config.propertiesWithoutGetters && id !in existingProperties) {
                PropertyElement(property.name, null, setters)
            } else null
        }.filterNotNull()
        return propertyWithGetters + propertyWithoutGetters
    }

    //suppose "setter" is a correct setOn*Listener method
    private fun makeListener(setter: MethodNodeWithClass): ListenerElement {
        val listener = classTree.findNode(setter.method.args[0].internalName)!!.data

        val methods = listener.methods?.filter { !it.isConstructor }

        val rawName = setter.method.name
        //delete "set" ("add") end "Listener" parts of String
        val name = rawName.substring("set".length()).dropLast("Listener".length()).decapitalize()

        return when (methods?.size() ?: 0) {
            1 -> { // It is a simple listener, with just one method
                val method = methods!![0]
                val methodWithClass = MethodNodeWithClass(listener, method)
                val returnType = method.returnType.asString()
                SimpleListenerElement(setter, listener, ListenerMethod(methodWithClass, name, returnType))
            }
            0 -> // Something weird
                throw RuntimeException("Listener ${listener.name} contains no methods.")
            else -> { // A complex listener (with more than one method)
                val listenerMethods = methods?.map { method ->
                    val methodName = method.name
                    val methodWithClass = MethodNodeWithClass(listener, method)
                    val returnType = method.returnType.asString()
                    ListenerMethod(methodWithClass, methodName, returnType)
                }!!
                ComplexListenerElement(setter, listener, name, listenerMethods)
            }
        }
    }

    //return a pair<viewGroup, layoutParams> or null if the viewGroup doesn't contain custom LayoutParams
    private fun extractLayoutParams(viewGroup: ClassNode): LayoutElement? {
        fun findActualLayoutParamsClass(viewGroup: ClassNode): ClassNode? {
            fun findForParent() = findActualLayoutParamsClass(classTree.findNode(viewGroup)!!.parent!!.data)

            val generateMethod = viewGroup.methods.firstOrNull { method ->
                method.name == "generateLayoutParams"
                        && method.args.size() == 1
                        && method.args[0].internalName == "android/util/AttributeSet"
            } ?: return findForParent()

            val returnTypeClass = classTree.findNode(generateMethod.returnType.internalName)!!.data
            if (!returnTypeClass.fqName.startsWith(viewGroup.fqName)) return findForParent()
            return if (returnTypeClass.isLayoutParams) returnTypeClass else findForParent()
        }

        val lpInnerClassName = viewGroup.innerClasses?.firstOrNull { it.name.contains("LayoutParams") } ?: return null
        val lpInnerClass = classTree.findNode(lpInnerClassName.name)!!.data

        val actualLayoutParamsClass = findActualLayoutParamsClass(viewGroup).let {
            if (it != null && it.name != "android/view/ViewGroup\$LayoutParams") it else null
        }

        return (actualLayoutParamsClass ?: lpInnerClass).let { clazz ->
            LayoutElement(viewGroup, clazz, clazz.getConstructors().filter { it.isPublic })
        }
    }

    protected val ClassNode.isViewGroupWithParams: Boolean
        get() = isViewGroup && hasLayoutParams(this)

    //returns true if the viewGroup contains custom LayoutParams class
    private fun hasLayoutParams(viewGroup: ClassNode): Boolean {
        return !viewGroup.isAbstract && extractLayoutParams(viewGroup) != null
    }

    private val MethodNode.isListenerGetter: Boolean
        get() = name.startsWith("get") && name.endsWith("Listener")

    public override fun isExcluded(node: ClassNode) =
            node.fqName in config.excludedClasses || "${node.packageName}.*" in config.excludedClasses

    public override fun isExcluded(node: MethodNodeWithClass) =
            (node.clazz.fqName + "#" + node.method.name) in config.excludedMethods

    private fun FieldNode.toServiceClassName(): String {
        var nextCapital = true
        val builder = StringBuilder()
        for (char in name.replace("_SERVICE", "_MANAGER").toCharArray()) when (char) {
            '_' -> nextCapital = true
            else -> builder.append(
                    if (nextCapital) {
                        nextCapital = false; char
                    } else Character.toLowerCase(char)
            )
        }
        return builder.toString()
    }

    private fun String.dropLast(n: Int) = if (n >= length()) "" else substring(0, length() - n)

}