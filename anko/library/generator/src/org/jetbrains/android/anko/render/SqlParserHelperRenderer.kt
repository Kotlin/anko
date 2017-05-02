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

import org.jetbrains.android.anko.config.GeneratorContext
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationKey
import org.jetbrains.android.anko.generator.GenerationState

class SqlParserHelperRenderer(context: GeneratorContext) : Renderer(context) {
    override val renderIf: Array<ConfigurationKey<Boolean>> = arrayOf(AnkoFile.SQL_PARSER_HELPERS)

    override fun processElements(state: GenerationState) = generatedFile { importList ->
        append(render("sql_parser_helpers") {
            "count" % 22
        })
    }
}