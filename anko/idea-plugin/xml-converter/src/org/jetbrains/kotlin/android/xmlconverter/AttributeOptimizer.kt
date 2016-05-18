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

internal val attributeOptimizations = listOf(
        ::optimizeInclude,
        ::optimizeHelperConstructors
)

internal fun optimizeInclude(name: String, attrs: List<KeyValuePair>): Pair<String, List<KeyValuePair>>? {
    val layout = attrs.firstOrNull { it.key == "layout" }?.value
    return if (name == "include" && layout != null) {
        val rendered = renderReference(NoAttr, "layout", layout)
        "$name<View>(${rendered?.value ?: layout})" to attrs.filter { it.key != "layout" }
    } else null
}

internal fun optimizeHelperConstructors(name: String, attrs: List<KeyValuePair>): Pair<String, List<KeyValuePair>>? {
    val helpers = listOf(
            attrs.firstOrNull { it.key == "text" },
            attrs.firstOrNull { it.key == "textResource" }
    ).filterNotNull()
    return if (helpers.isNotEmpty()) {
        val helper = helpers.first()
        "$name(${helper.value})" to attrs.filter { it.key != helper.key }
    } else null
}