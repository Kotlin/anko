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

package org.jetbrains.android.anko.render

import org.jetbrains.android.anko.config.AnkoBuilderContext
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationOption
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.utils.buffer

class SqlParserHelperRenderer(context: AnkoBuilderContext) : Renderer(context) {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.SQL_PARSER_HELPERS)

    override fun processElements(state: GenerationState) = StringBuilder().apply {
        for (i in 1..22) {
            val types = (1..i).map { "T$it" }.joinToString(", ")
            val args = (1..i).map { "columns[${it - 1}] as T$it" }.joinToString(", ")

            append(buffer {
                line("fun <$types, R> rowParser(parser: ($types) -> R): RowParser<R> {")
                line("return object : RowParser<R> {")
                line("override fun parseRow(columns: Array<Any?>): R {")
                line("if (columns.size != $i)")
                val s = if (i == 1) "" else "s"
                indent.line("throw SQLiteException(\"Invalid row: $i column$s required\")")
                line("@Suppress(\"UNCHECKED_CAST\")")
                line("return parser($args)")
                line("}")
                line("}")
                line("}")
                nl()
            }.toString())
        }
    }.toString()

}