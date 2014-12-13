/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.InnerClassNode
import java.util.TreeMap
import java.util.Arrays
import org.jetbrains.android.dsl.KoanFile.*

data class ListenerMethod(val method: MethodNode, val name: String, val argumentTypes: String, val returnType: String)

// Pair(listener setter, listener class)
abstract class Listener(val setter: MethodNodeWithClass, val listener: ClassNode)

data class SimpleListener(setter: MethodNodeWithClass, val clazz: ClassNode, val method: ListenerMethod):
    Listener(setter, clazz) {
    override fun toString(): String {
        return "SimpleListener{${setter.toStringCompact()} <- ${clazz.name}: ${method.name}}"
    }
}

data class ComplexListener(setter: MethodNodeWithClass, val clazz: ClassNode, val methods: List<ListenerMethod>):
    Listener(setter, clazz) {
    override fun toString(): String {
        return "ComplexListener{${setter.toStringCompact()} <- ${clazz.name}: ${methods.toString()}}"
    }
}

data class ViewProperty(val name: String, val getter: MethodNodeWithClass, val setters: List<MethodNodeWithClass>)
data class LayoutParamsNode(val layout: ClassNode, val layoutParams: ClassNode, val constructors: List<MethodNode>) {
    override fun toString(): String {
        return "LayoutParams{${layout.cleanInternalName()}, ${layoutParams.cleanInternalName()}, constructors.len=${constructors.size}}"
    }
}

class Generator(val classTree: ClassTree, config: BaseGeneratorConfiguration): Configurable(config) {

    private val availableClasses = classTree.filter { !it.isExcluded() }
    private val availableMethods = availableClasses.flatMap { clazz ->
        clazz.methods?.map { MethodNodeWithClass(clazz, it) }?.filter { !it.isExcluded() } ?: listOf()
    }

    // Views and viewGroups without custom LayoutParams
    val viewClasses = availableClasses
        .filter { it.isView() && !it.isViewGroupWithParams() && !it.isInner() }
        .sortBy { it.name }

    val viewGroupClasses = availableClasses
        .filter { it.isViewGroupWithParams() && !it.isInner() && !it.isAbstract }
        .sortBy { it.name }

    val listeners = availableMethods.filter {
        val name = it.method.name ?: ""
        name.startsWith("setOn") && name.endsWith("Listener") && it.clazz.isView() && it.method.isPublic()
    }.map {
        val name = it.method.arguments!![0].getInternalName()
        val node = classTree.findNode(name)!!
        makeListener(it, node.data)
    }.sortBy { it.setter.clazz.name + "#" + it.setter.method.name }

    // Find get* methods on View classes, like getText() or getVisibility()
    private val propertyGetters = generate(PROPERTIES) {
        availableMethods.filter {
            val (clazz, method) = it
            clazz.isView() && !(clazz.isAbstract && clazz.isViewGroup()) &&
                method.isGetter() && method.isPublic() &&
                method.arguments?.size() == 0 && !method.getReturnType().isVoid()
        }.fold(TreeMap<String, MethodNodeWithClass>(), { map, cam ->
            val key = cam.clazz.name + "#" + cam.method.name
            if (!map.contains(key)) {
                map.put(key, cam)
            }
            map
        }).values()
    }

    /* Find set* methods on View classes, like setText() or setVisibility() grouped by className_methodName
       because there can be several setter methods like setText(Int) and setText(String) */
    private val propertySetters = availableMethods.filter {
            val name = it.method.name ?: ""
            val (clazz, method) = it
            /* Find all methods named "set*", with uppercase letter after "set" in a View ancestor class
               Such methods must be public and have only one argument */
            name.size > 3 && name.startsWith("set") && Character.isUpperCase(name.charAt(3)) &&
                clazz.isView() && method.isPublic() && it.method.arguments?.size() == 1 &&
                !(it.method.name.startsWith("setOn") && it.method.name.endsWith("Listener"))
        }.groupBy { it.clazz.name + "#" + it.method.name }

    val properties = genProperties(propertyGetters, propertySetters)

    //find all ancestors of ViewGroup.LayoutParams in classes that extends ViewGroup.
    //a helper class will be created for each layout. For example,
    //for the class LinearLayout, _LinearLayout class will be generated
    val layouts = viewGroupClasses.map { extractLayoutParams(it) }
            .filter { it != null }.map {
            val layoutClass = it!!.first //null items are already filtered
            val layoutParamsClass = it.second
            LayoutParamsNode(layoutClass, layoutParamsClass, layoutParamsClass.getConstructors())
        }.sortBy { it.layout.name }

    val services = generate(SERVICES) {
        classTree.findNode("android/content/Context")?.data?.fields
            ?.filter { it.name.endsWith("_SERVICE") }
            ?.map { it.name to classTree.findNode("android", it.name.toServiceClassName()) }
            ?.filter { it.second != null }
            ?.sortBy { it.first }
            ?: listOf()
    }

    val interfaceWorkarounds = generate(INTERFACE_WORKAROUNDS) {
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
            }
            val innerClass = it.innerClasses.firstOrNull {
                inner -> inner.isProtected && inner.isInterface && inner.name == it.name
            }
            Triple(it, ancestor.head, innerClass)
        }.filter { it.second != null && it.third != null }
    }

    //Convert list of getters and map of setters to property list
    private fun genProperties(
            getters: Collection<MethodNodeWithClass>,
            setters: Map<String, List<MethodNodeWithClass>>) : List<ViewProperty> {
        return getters.map { getter ->
            val name = decapitalize(getter.method.toProperty())
            val settersKey = getter.clazz.name + "#set${getter.method.toCapitalizedProperty()}"
            val settersList = setters.get(settersKey) ?: listOf()
            if (settersList.isNotEmpty()) {
                val splittedSetters = settersList.partition { Arrays.equals(it.method.arguments, getter.method.arguments) }
                if (splittedSetters.first.isNotEmpty()) {
                    ViewProperty(name, getter, splittedSetters.first.join(splittedSetters.second))
                } else ViewProperty(name, getter, settersList)
            } else ViewProperty(name, getter, settersList)
        }
    }

    //suppose "setter" is a correct setOn*Listener method
    private fun makeListener(setter: MethodNodeWithClass, listener: ClassNode) : Listener {
        val methods = listener.methods?.filter { it.name != "<init>" }
        return when (methods?.size ?: 0) {
            1 -> {
                //if it's a simple listener, with just one method
                val rawName = setter.method.name
                //delete "setOn" end "Listener" parts of String
                val name = decapitalize(rawName.substring("set".size).dropLast("Listener".size))
                val method = methods!![0]
                val argumentTypes = method.fmtArgumentsTypes()
                val returnType = method.getReturnType().toStr()
                SimpleListener(setter, listener, ListenerMethod(method, name, argumentTypes, returnType))
            }
            0 -> //if something weird
                throw RuntimeException("Listener ${listener.name} contains no methods.")
            else -> {
                //if a complex listener
                val listenerMethods = methods?.map { method ->
                    val methodName = method.name
                    val argumentTypes = method.fmtArgumentsTypes()
                    val returnType = method.getReturnType().toStr()
                    ListenerMethod(method, methodName, argumentTypes, returnType)
                }!!
                ComplexListener(setter, listener, listenerMethods)
            }
        }
    }

    //return a pair<viewGroup, layoutParams> or null if the viewGroup doesn't contain custom LayoutParams
    private fun extractLayoutParams(viewGroup: ClassNode): Pair<ClassNode, ClassNode>? {
        if (viewGroup.innerClasses == null)
            return null
        val innerClasses = (viewGroup.innerClasses : List<InnerClassNode>)
        val lp = innerClasses.firstOrNull { it.name?.contains("LayoutParams") ?: false }
        val lpNode = classTree.findNode(lp?.name)?.data
        return if (lpNode != null)
            Pair(viewGroup, classTree.findNode(lp?.name)?.data!!)
        else null
    }

    //returns true if the viewGroup contains custom LayoutParams class
    private fun hasLayoutParams(viewGroup: ClassNode): Boolean {
        return extractLayoutParams(viewGroup) != null
    }

    private fun ClassNode.isView() = isView(classTree)
    private fun ClassNode.isViewGroup() = isViewGroup(classTree)
    private fun ClassNode.isViewGroupWithParams(): Boolean {
        return isViewGroup(classTree) && hasLayoutParams(this)
    }

    private fun ClassNode.isExcluded() =
        this.cleanInternalName() in config.excludedClasses
    private fun MethodNodeWithClass.isExcluded() =
        (this.clazz.cleanInternalName() + "#" + this.method.name) in config.excludedMethods

    private fun String.toServiceClassName(): String {
        var nextCapital = true
        val builder = StringBuilder()
        for (char in replace("_SERVICE", "_MANAGER").toCharArray()) when (char) {
            '_' -> nextCapital = true
            else -> builder.append(
                    if (nextCapital) { nextCapital = false; char } else Character.toLowerCase(char)
            )
        }
        return builder.toString()
    }

}