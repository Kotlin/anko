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

package org.jetbrains.android.anko.utils

import org.jetbrains.android.anko.config.WithGeneratorContext

internal fun WithGeneratorContext.buffer(init: Buffer.() -> Unit) = Buffer(config.indent, 0, init)

class Buffer(private val indentString: String, indent: Int = 0, init: Buffer.() -> Unit) {

    private val builder = StringBuilder()
    private var mainIndent = indent
    private var tempIndent = 0

    init { init() }

    fun line(s: String): Buffer {
        if (mainIndent > 0 && s.startsWith('}')) mainIndent -= 1

        if (s.isNotEmpty()) {
            builder.append(indentString.repeat(mainIndent + tempIndent)).append(s.trim()).appendln()
        } else {
            builder.appendln()
        }

        if (tempIndent > 0) tempIndent -= 1

        if (s.endsWith('{')) {
            mainIndent += 1
        } else if (s.endsWith('=')) {
            tempIndent += 1
        }

        return this
    }

    fun nl(): Buffer = line("")

    val indent: Buffer
        get() {
            tempIndent += 1
            return this
        }

    fun lines(lines: List<String>): Buffer {
        for (line in lines) {
            line(line)
        }
        return this
    }

    val size: Int
        get() = builder.length

    override fun toString() = builder.toString()

    fun getLines() = toString().split('\n').toList()
}