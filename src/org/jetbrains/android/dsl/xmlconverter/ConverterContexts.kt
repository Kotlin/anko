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

package org.jetbrains.android.dsl.xmlconverter

import java.util.ArrayList
import org.jetbrains.android.dsl.Context

open class WidgetContext(): Context() {
    val layoutParams = ArrayList<String>()

    private fun layoutFunc(key: String, value: String) {
        layoutParams.add(value.toUpperCase())
    }

    public open fun addProperty(key: String, value: String, keyPrefix: String = "") {
        when (key) {
            "layout_width" -> layoutFunc(key, value)
            "layout_height" -> layoutFunc(key, value)
            "text" -> writeln("$keyPrefix$key = \"$value\"")
            "caption" -> writeln("$keyPrefix$key = \"$value\"")
            else -> writeln("$keyPrefix$key = $value")
        }
    }

    public open fun setId(id: String) {
    writeln("id = R.id.$id")
    }

    public override fun toString(): String {
        if (!layoutParams.isEmpty())
            writeln("layoutParams(${layoutParams.joinToString()})")
        return buffer.toString()
    }
}

class LayoutContext(): WidgetContext() {

    public override fun setId(id: String) {
        writeln("id = R.id.$id")
    }

    public override fun addProperty(key: String, value: String, keyPrefix: String) {
        super<WidgetContext>.addProperty(key, value, "")
    }
}