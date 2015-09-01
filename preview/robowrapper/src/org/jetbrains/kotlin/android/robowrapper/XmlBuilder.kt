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
import org.jetbrains.kotlin.android.attrs.Attr
import java.util.regex.Pattern

// Serialize a ViewNode to xml
fun toXml(v: ViewNode): String {
    val sb = Buffer().append(XML_HEADER)

    fun ViewNode.invoke(indent: Int) {
        val name = getXmlName()
        // Insert schema if top-level node
        val schema = if (indent == 0) XML_SCHEMA else ""
        val props = schema + genAttributes(view, name, attrs, indent == 0)
        val delim = if (props.isEmpty()) "" else " "
        val I = "\t".repeat(indent)
        sb.append("$I<$name$delim$props")
        if (children.isEmpty()) {
            sb.append("/>\n")
        } else {
            sb.append(">\n")
            children.forEach { it(indent + 1) }
            sb.append("$I</$name>\n")
        }
    }

    v(0)
    return sb.toString()
}

// Render attributes
// @param v used for resolving dimensions (and some Robolectric-related work)
// @param attrs set of attrs that should be parsed
fun genAttributes(v: View, className: String, attrs: Set<Pair<String, Pair<Attr?, Any>>>, topLevel: Boolean): String {
    val present = hashSetOf<String>()
    var layoutParamsPresent = false
    val sb = Buffer()

    for (attr in attrs) {
        val key = attr.first
        if (key in present) continue
        val value = renderAttribute(v, attr.second.first, attr.first, attr.second.second, topLevel)
        if (value == null || ignoreAttribute(className, key, value)) continue
        if (attr.first == "layoutParams") {
            // LayoutParams is already rendered
            sb.append(value)
            layoutParamsPresent = true
        } else
            sb.append("android:").append(attr.first).append("=\"").append(value).append("\" ")
        present.add(attr.first)
    }
    if (!layoutParamsPresent) {
        sb.append(""" android:layout_width="wrap_content" android:layout_height="wrap_content" """)
    }

    return sb.toString()
}

private fun ignoreAttribute(className: String, key: String, value: String): Boolean {
    val def = defaultValues.get(key)
    val classDef = defaultValues.get(className + "#" + key)
    fun match(s: String, pattern: Any) = when(pattern) {
        is Pattern -> pattern.matcher(s).matches()
        is String -> pattern == s
        else -> false
    }
    return (classDef?.any { match(value, it) } ?: false) || (def?.any { match(value, it) } ?: false)
}