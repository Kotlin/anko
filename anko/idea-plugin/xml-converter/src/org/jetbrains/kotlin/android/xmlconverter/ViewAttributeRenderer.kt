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

internal val viewAttributeRenderers = listOf(
        ::renderGravity,
        ::renderBackground,
        ::renderLinearLayoutOrientation,
        ::renderTextSize,
        ::renderTag,
        ::renderVisibility,
        ::renderSingleLine,
        ::renderOrientation,
        ::renderColor,
        ::renderReference,
        ::renderDimension,
        ::renderString,
        ::renderBoolean,
        ::renderInteger,
        ::renderFloat,
        ::renderEnum,
        ::renderFlags
)

@Suppress("UNUSED_PARAMETER")
internal fun renderGravity(attr: Attr, key: String, value: String) = if (key == "gravity") {
        val values = value.split('|').map { "Gravity.${it.toUpperCase()}" }
        key * values.joinToString(" or ")
    } else null

@Suppress("UNUSED_PARAMETER")
internal fun renderBackground(attr: Attr, key: String, value: String) = if (key == "background") {
    if (value.isReference()) renderReference(NoAttr, "${key}Resource", value)
    else if (value.isColor()) renderColor(NoAttr, "${key}Color", value)
    else null
} else null

internal fun renderLinearLayoutOrientation(attr: Attr, key: String, value: String) =
    if (key == "orientation" && attr.name == "LinearLayout")
        key * "android.widget.LinearLayout.${value.toUpperCase()}" else null

@Suppress("UNUSED_PARAMETER")
internal fun renderTextSize(attr: Attr, key: String, value: String) = if (key == "textSize") {
        val dimension = value.parseDimension()
        key * "${dimension.first}f"
    } else null

@Suppress("UNUSED_PARAMETER")
internal fun renderTag(attr: Attr, key: String, value: String) = if (key == "tag") {
    renderString(NoAttr, key, value)
} else null

@Suppress("UNUSED_PARAMETER")
internal fun renderVisibility(attr: Attr, key: String, value: String) = if (key == "visibility") {
    "visibility" * "View.${value.toUpperCase()}"
} else null

@Suppress("UNUSED_PARAMETER")
internal fun renderSingleLine(attr: Attr, key: String, value: String) = if (key == "singleLine") {
        "setSingleLine($value)" * ""
    } else null

@Suppress("UNUSED_PARAMETER")
internal fun renderOrientation(attr: Attr, key: String, value: String) = if (key == "orientation") {
    "orientation" * "LinearLayout.${value.toUpperCase()}"
} else null

internal fun renderBoolean(attr: Attr, key: String, value: String) =
        if (attr accepts "boolean" && (value == "true" || value == "false")) key * value else null

internal fun renderInteger(attr: Attr, key: String, value: String) =
        if (attr accepts "integer" && value.matches("\\-?[0-9]+".toRegex())) key * value else null

internal fun renderFloat(attr: Attr, key: String, value: String) = if (attr accepts "float") key * "${value}f" else null

internal fun renderString(attr: Attr, key: String, value: String) =
        if (attr accepts "string") {
            if (value.isReference() && key.isSpecialReferenceAttribute())
                renderReference(NoAttr, key + "Resource", value)
            else
                key * ("\"" + value.replace("\"", "\\\"") + "\"")
        } else null

internal fun renderColor(attr: Attr, key: String, value: String) = if (attr accepts "color" && value.isColor()) {
        val color = value.replace("#", "").toLowerCase()
        val displayColor = if (color.length > 6 && !color.startsWith("ff"))
            "0x$color.toInt()" else "0x${color}.opaque"
        key * displayColor
    } else null

internal fun renderReference(attr: Attr, key: String, value: String): KeyValuePair? {
    if (attr accepts "reference" && value.isReference()) {
        val reference = value.parseReference() ?: return null
        val packageName = if (reference.packageName.isNotEmpty()) "${reference.packageName}." else ""
        return when (reference.type) {
            "+id" -> key * "${packageName}Ids.${reference.value}"
            else -> key * "${packageName}R.${reference.type}.${reference.value}"
        }
    }
    else
        return null
}

internal fun renderEnum(attr: Attr, key: String, value: String) = if (attr accepts "enum" && attr.enum != null) {
        val enumEntry = attr.enum?.firstOrNull { it.name == value }
        if (enumEntry != null) key * enumEntry.value else key * value
    } else null

internal fun renderFlags(attr: Attr, key: String, value: String) = if (attr accepts "flags" && attr.flags != null) {
        val sum = value.split('|').fold(0) { sum, flag ->
            val entry = attr.flags?.firstOrNull { it.name == flag }
            sum + (entry?.value?.parseFlagValue() ?: 0)
        }
        key * sum.toString()
    } else null

internal fun renderDimension(attr: Attr, key: String, value: String) = if (attr accepts "dimension" && value.isDimension()) {
    val dimension = value.parseDimension()
    key * "${dimension.second}(${dimension.first})"
} else null

private infix fun Attr.accepts(f: String) = this == NoAttr || f in this.format