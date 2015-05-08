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

package org.jetbrains.android.anko.utils

import org.jetbrains.android.anko.config.Configurable

fun Configurable.buffer(init: Buffer.() -> Unit) = Buffer(config.indent, 0, init)
fun Configurable.buffer(indent: Int, init: Buffer.() -> Unit) = Buffer(config.indent, indent, init)

public class Buffer(private val indentString: String, indent: Int = 0, val init: Buffer.() -> Unit) {

    private val builder = StringBuilder();
    private var mainIndent = indent;
    private var tempIndent = 0

    init { init() }

    public fun line(s: String): Buffer {
        if (mainIndent > 0 && s.startsWith('}')) mainIndent = mainIndent - 1

        if (s.isNotEmpty()) {
            builder.append(indentString.repeat(mainIndent + tempIndent)).append(s.trim()).append('\n')
        } else {
            builder.append('\n')
        }

        if (tempIndent > 0) tempIndent = tempIndent - 1

        if (s.endsWith('{')) {
            mainIndent = mainIndent + 1
        } else if (s.endsWith('=')) {
            tempIndent = tempIndent + 1
        }

        return this
    }

    public fun nl(): Buffer = line("")

    public val indent: Buffer
        get() {
            tempIndent = tempIndent + 1
            return this
        }

    public fun lines(lines: List<String>): Buffer {
        for (line in lines) {
            line(line)
        }
        return this
    }

    public fun lines(lines: Array<String>): Buffer {
        for (line in lines) {
            line(line)
        }
        return this
    }

    public val size: Int
        get() = builder.length()

    public val isEmpty: Boolean
        get() = builder.length() == 0

    override fun toString(): String {
        return builder.toString()
    }

    fun getLines(): List<String> {
        return toString().split('\n').toList()
    }
}