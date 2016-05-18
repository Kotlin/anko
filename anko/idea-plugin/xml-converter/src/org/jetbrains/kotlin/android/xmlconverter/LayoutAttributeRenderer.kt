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

import org.jetbrains.kotlin.android.attrs.NoAttr

internal val layoutAttributeRenderers = listOf(
        ::linearLayoutRenderer,
        ::relativeLayoutRenderer
)

internal fun linearLayoutRenderer(parentName: String, attrs: Map<String, String>) = if (parentName == "LinearLayout") listOf(
        attrs.prop("gravity") { renderAttribute(NoAttr, it) },
        attrs.prop("weight")
) + marginLayoutRenderer(parentName, attrs) else null

internal fun relativeLayoutRenderer(parentName: String, attrs: Map<String, String>) = if (parentName == "RelativeLayout") listOf(
        attrs.func("above") { renderReference(NoAttr, it.key, it.value) },
        attrs.func("below") { renderReference(NoAttr, it.key, it.value) },
        attrs.func("toRightOf") { renderReference(NoAttr, "toRightOf", it.value) },
        attrs.func("toLeftOf") { renderReference(NoAttr, "toLeftOf", it.value) },
        attrs.func("alignLeft") { renderReference(NoAttr, "sameLeft", it.value) },
        attrs.func("alignTop") { renderReference(NoAttr, "sameTop", it.value) },
        attrs.func("alignRight") { renderReference(NoAttr, "sameRight", it.value) },
        attrs.func("alignBottom") { renderReference(NoAttr, "sameBottom", it.value) },
        attrs.func("alignParentLeft") { "alignParentLeft" * "" },
        attrs.func("alignParentTop") { "alignParentTop" * "" },
        attrs.func("alignParentRight") { "alignParentRight" * "" },
        attrs.func("alignParentBottom") { "alignParentBottom" * "" },
        attrs.func("alignParentStart") { "alignParentStart" * "" },
        attrs.func("alignParentEnd") { "alignParentEnd" * "" },
        attrs.func("centerInParent") { "centerInParent" * "" },
        attrs.func("centerHorizontal") { "centerHorizontally" * "" },
        attrs.func("centerVertical") { "centerVertically" * "" }

) + marginLayoutRenderer(parentName, attrs) else null

@Suppress("UNUSED_PARAMETER")
internal fun marginLayoutRenderer(parentName: String, attrs: Map<String, String>) =
        listOf("margin", "marginLeft", "marginTop", "marginRight", "marginBottom").map {
            attrs.prop(it) { renderDimension(NoAttr, it.key.swapCamelCase(), it.value) }
        }

private fun Map<String, String>.func(key: String, transformer: ((KeyValuePair) -> KeyValuePair?)? = null): KeyValuePair? {
    val value = get(key)
    return if (value != null) {
        if (transformer != null) {
            val result = transformer(key * value)
            return if (result != null) (result.key + "(" + result.value + ")") * "" else null
        } else "$key($value)" * ""
    } else null
}

private fun Map<String, String>.prop(key: String, transformer: ((KeyValuePair) -> KeyValuePair?)? = null): KeyValuePair? {
    val value = get(key)
    return if (value != null) {
        if (transformer != null) transformer(key * value) else key * value
    } else null
}