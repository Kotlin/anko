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

package org.jetbrains.kotlin.android.robowrapper

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import org.jetbrains.kotlin.android.attrs.Attr
import java.lang.reflect.Method

internal class ViewNode(val view: View, val children: List<ViewNode>, val attrs: Set<Pair<String, Pair<Attr?, Any>>>) {
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("${view.javaClass.name}: attrs: $attrs")
        children.map { it.toString() }.forEach { sb.append(("  " + it.replace("\n", "  "))) }
        return sb.toString()
    }
}

private val superclassResolver = SuperclassResolver()

// Parse view with it's children, get all attributes from getters and make a ViewNode
fun parseView(view: View): ViewNode {
    val children = arrayListOf<ViewNode>()
    if (view is ViewGroup &&
            (view.javaClass.name !in ignoreChildrenOf || isAdapterViewChild(view.javaClass))) {
        val childCount = view.childCount
        for (i in 0..(childCount - 1)) {
            val child = view.getChildAt(i)
            children.add(parseView(child))
        }
    }

    val unwrappedClass = unwrapClass(view.javaClass)
    return ViewNode(view, children, parseAttributes(unwrappedClass, view, unwrappedClass.getAttrs()))
}

// There're some Anko layout helpers in our DSL, so let's unwrap such views
internal fun unwrapClass(clazz: Class<*>): Class<*> {
    val superClass = superclassResolver.getSuperclass(clazz)
  val simpleName = clazz.simpleName
    return if (simpleName.startsWith("_") &&
            superClass.simpleName == simpleName.substring(1) &&
            ViewGroup::class.java.isAssignableFrom(clazz) &&
            androidViewPaths.any { superClass.name.startsWith(it) })
        superClass else clazz
}

private fun isAdapterViewChild(c: Class<*>?): Boolean {
    if (c == null || (c.javaClass.name) == "java.lang.Object")
        return false
    if ((c.javaClass.name) == "android.widget.AdapterView")
        return true
    else return isAdapterViewChild(superclassResolver.getSuperclass(c))
}

private fun Class<*>.getAttrs(): Map<String, Attr> {
    val map = hashMapOf<String, Attr>()
    attrs.free.forEach { map.put(it.name, it) }
    getStyleableNames().forEach {
        val styleable = attrs.styleables[it]
        styleable?.attrs?.forEach { map.put(it.name, it) }
    }
    map.putAll(superclassResolver.getSuperclass(this)?.getAttrs() ?: mapOf())
    return map
}

internal fun Class<*>.getStyleableNames(): List<String> {
    val name = this.name
    if (name.equals("android.view.ViewGroup\$LayoutParams")) {
        return listOf("ViewGroup_Layout", "ViewGroup_MarginLayout")
    }
    if ((name.startsWith("android.view.") || name.startsWith("android.widget.")) && name.endsWith("\$LayoutParams")) {
        return listOf(name.replace("android.view.", "").replace("android.widget.", "").replace("\$LayoutParams", "_Layout"))
    }
    if (name.startsWith("android.view.") || name.startsWith("android.widget.")) {
        return listOf(name.replace("android.view.", "").replace("android.widget.", ""))
    }
    if (name.equals("java.lang.Object")) {
        return listOf()
    }
    return listOf(name)
}

// Unwrap our layout helper classes and remove the package name if not necessary
internal fun ViewNode.getXmlName(): String {
    val unwrappedClass = unwrapClass(view.javaClass)
    val name = unwrappedClass.name
    return name.replace("android.view.", "").replace("android.widget.", "")
}

// Resolve XML property name if that name differs from setter name. ex: getDrawable() -> src=""
internal fun resolveSpecialProperty(view: View, property: String): String {
  if (view is ImageView && property == "drawable")
    return "src"
  return property
}

// Get all attributes we could get from getters via Reflection
// @param attrs attributes for this kind of View from attrs.xml
private fun parseAttributes(
        clazz: Class<*>,
        view: View,
        attrs: Map<String, Attr>
): Set<Pair<String, Pair<Attr?, Any>>> {
    val attributes = hashSetOf<Pair<String, Pair<Attr?, Any>>>()

    for (method in clazz.methods.iterator()) {
        val name = method.name

        val parameterTypes = method.parameterTypes
        if ((parameterTypes != null && parameterTypes.size() > 0) || name in ignoredMethods) {
            continue
        }

        val propertyName = method.resolveBooleanPropertyName(view)
                ?: method.resolveGenericPropertyName(view) ?: continue

        if (propertyName !in attrs && propertyName != "layoutParams") continue

        try {
            val ret = method.invoke(view)
            if (ret != null) {
                attributes.add(propertyName to (attrs[propertyName] to ret))
            }
        } catch (e: Exception) {
            // Ignore method
            System.err.println("Error while calling ${clazz.name}#$name: ")
            e.printStackTrace()
        }
    }
    // Parse also a parent (attrs already contains attributes for it)
    val superClass = superclassResolver.getSuperclass(clazz)
    if (superClass != null && View::class.java.isInstance(view)) {
        attributes.addAll(parseAttributes(superClass, view, attrs))
    }

    return attributes
}

private fun Method.resolveBooleanPropertyName(view: View): String? {
    val name = name
    return if (name.startsWith("is") && name.length() > 2 && Character.isUpperCase(name.charAt(2)))
        resolveSpecialProperty(view, decapitalize(name.substring(2)))
    else
        null
}

private fun Method.resolveGenericPropertyName(view: View): String? {
    val name = name
    return if (name.startsWith("get") && name.length() > 3 && Character.isUpperCase(name.charAt(3)))
        resolveSpecialProperty(view, decapitalize(name.substring(3)))
    else
        null
}