/*
 * Copyright 2016 JetBrains s.r.o.
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

package org.jetbrains.kotlin.android.xmlconverter

import org.jetbrains.kotlin.android.attrs.Attr
import org.jetbrains.kotlin.android.attrs.NoAttr
import java.util.regex.Pattern

internal fun renderLayoutAttributes(attributes: List<KeyValuePair>, parentName: String): String {
    val map = attributes.map { it.key.replace("android:layout_", "") to it.value }.toMap()

    fun renderLayoutDimension(s: String) = when {
        s == "wrap_content" -> "wrapContent"
        s == "match_parent" || s == "fill_parent" -> "matchParent"
        s.isDimension() -> {
            val dimension = s.parseDimension()
            "${dimension.second}(${dimension.first})"
        }
        else -> s
    }

    val width = renderLayoutDimension(map["width"] ?: "wrap_content")
    val height = renderLayoutDimension(map["height"] ?: "wrap_content")

    val options = (layoutAttributeRenderers.findFirst { it(parentName, map) } ?: emptyList()).filterNotNull()
    val optionsString = if (options.isNotEmpty()) {
        options.map { it.toString().indent(1) }.joinToString("\n", " {\n", "\n}")
    } else ""

    return ".lparams(width = $width, height = $height)$optionsString"
}

internal fun transformAttribute(widgetName: String, name: String, value: String): KeyValuePair? {
    return when {
        name.startsWith("xmlns:") -> null
        name.startsWith("tools:") -> null
        name == "style" -> null
        name.startsWith("android:") -> {
            val shortName = name.substring("android:".length)
            // Search for attribute in `widgetName` styleable, then in superclass styleables,
            // then in `View` styleable, then in free attributes
            val attr = attrs.free.firstOrNull { it.name == shortName } ?:
                attrs.styleables[widgetName]?.attrs?.firstOrNull { it.name == shortName } ?:
                viewHierarchy[widgetName]?.findFirst { attrs.styleables[it]?.attrs?.firstOrNull { it.name == shortName } }
                attrs.styleables["View"]?.attrs?.firstOrNull { it.name == shortName }

            return if (attr != null) {
                renderAttribute(attr, shortName, value)
            } else renderAttribute(NoAttr, shortName, value)
        }
        else -> name * value
    }
}

internal fun renderAttribute(attr: Attr, p: KeyValuePair) = renderAttribute(attr, p.key, p.value)

private fun renderAttribute(attr: Attr, key: String, value: String): KeyValuePair? {
    for (renderer in viewAttributeRenderers) {
        val v = renderer(attr, key, value)
        if (v != null) return v
    }

    return null
}

fun String.parseReference(): XmlReference? {
    val matcher = Pattern.compile("@((([A-Za-z0-9._]+)\\:)?)([+A-Za-z0-9_]+)\\/([A-Za-z0-9_]+)").matcher(this)
    if (!matcher.matches()) {
        return null
    }
    return XmlReference(matcher.group(3) ?: "", matcher.group(4), matcher.group(5))
}

fun String.parseFlagValue(): Int {
    return if (startsWith("0x")) Integer.parseInt(this.substring(2), 16) else this.toInt()
}

fun String.isReference(): Boolean {
    return startsWith("@")
}

fun String.isSpecialReferenceAttribute() = when (this) {
    "text" -> true
    "background" -> true
    else -> false
}

fun String.isDimension(): Boolean {
    return endsWith("sp") || endsWith("dp") || endsWith("px") || endsWith("dip")
}

fun String.isColor(): Boolean {
    return toLowerCase().matches("#[0-9a-f]+".toRegex())
}

fun String.parseDimension(): Pair<String, String> {
    val matcher = Pattern.compile("([0-9\\.]+)(dip|dp|px|sp)").matcher(this)
    if (!matcher.matches()) {
        throw RuntimeException("Invalid dimension: $this")
    }
    val numericValue = matcher.group(1)
    val dimensionUnit = matcher.group(2).let { if (it == "dp") "dip" else it }
    return (if ("." in numericValue) "${numericValue}f" else numericValue) to dimensionUnit
}