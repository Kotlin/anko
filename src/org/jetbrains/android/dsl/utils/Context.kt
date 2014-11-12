/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl

import java.util.ArrayList

open class InvalidIndent(num: Int) : RuntimeException("Indentation level < 0: $num")
open data class Indent(): CharSequence {
    override val length: Int = 0
    override fun get(index: Int): Char {
        throw UnsupportedOperationException()
    }
}

object IncIndent : Indent()
object DecIndent : Indent()

open class Context(val buffer: StringBuffer = StringBuffer(), var indentDepth: Int = 0) {
    private val INDENT_UNIT = "    "

    private val children = ArrayList<Context>()
    protected var currentIndent: String = INDENT_UNIT.repeat(indentDepth)

    public fun write(contents: List<CharSequence>) {
        val indentOnStart = indentDepth
        contents.forEach {
            when(it) {
                is IncIndent -> incIndent()
                is DecIndent -> decIndent()
                else -> writeln(it)
            }
        }
        if (indentOnStart < indentDepth) {
            indentDepth = indentOnStart
            currentIndent = INDENT_UNIT.repeat(indentDepth)
        }
    }

    public fun incIndent() {
        indentDepth++
        currentIndent += INDENT_UNIT
    }

    public fun decIndent() {
        indentDepth--
        if(indentDepth < 0)
            throw InvalidIndent(indentDepth)
        currentIndent = currentIndent.substring(0, currentIndent.length - INDENT_UNIT.length)
    }

    public open fun write(what: CharSequence) {
        writeNoIndent(currentIndent)
        writeNoIndent(what)
    }

    public fun writeNoIndent(what: CharSequence) {
        buffer.append(what)
    }

    public fun writeln(what: CharSequence) {
        write(what)
        newLine()
    }

    public fun newLine() {
        writeNoIndent("\n")
    }

    public fun trim(num: Int) {
        buffer.delete(buffer.length - num, buffer.length)
    }

    public fun fork(newBuffer: StringBuffer = StringBuffer(),
                    newIndentDepth: Int = indentDepth
    ): Context {
        val child = Context(newBuffer, newIndentDepth)
        children.add(child)
        return child
    }

    public fun adopt<T: Context>(c: T, inheritIndent: Boolean = true): T {
        children.add(c)
        if (inheritIndent) {
            c.currentIndent = currentIndent
        }
        return c
    }

    public fun absorbChildren(noIndent: Boolean = true) {
        for (child in children) {
            child.absorbChildren()
            if (noIndent)
                writeNoIndent(child.toString())
            else
                write(child.toString())
        }
        children.clear()
    }
}

