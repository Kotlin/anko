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

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.kotlin.android.attrs.Attrs
import org.jetbrains.kotlin.android.attrs.readResource

private val INTENT = "    "

internal val attrs = Gson().fromJson(readResource("attrs.json"), Attrs::class.java)

internal val viewHierarchy = Gson().fromJson<Map<String, List<String>>>(readResource("views.json"),
        (object : TypeToken<Map<String, List<String>>>() {}).type)

internal data class KeyValuePair(val key: String, val value: String) {
    override fun toString() = if (value.isNotEmpty()) "$key = $value" else key
}

internal operator fun String.times(value: String) = KeyValuePair(this, value)

internal fun <T: Any, R: Any> List<T>.findFirst(transformer: (T) -> R?): R? {
    for (item in this) {
        val r = transformer(item)
        if (r != null) return r
    }
    return null
}

internal fun String.indent(width: Int): String {
    if (isEmpty()) return this
    val intent = INTENT.repeat(width)
    return split('\n').map { intent + it }.joinToString("\n")
}

internal fun String.swapCamelCase(): String {
    val ch = withIndex().firstOrNull { Character.isUpperCase(it.value) }
    return if (ch == null) this else substring(ch.index).toLowerCase() + substring(0, ch.index).firstCapital()
}

internal fun String.firstCapital(): String = if (isEmpty()) this else Character.toUpperCase(this[0]) + substring(1)