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
import org.jetbrains.android.anko.config.ConfigurationKey
import org.jetbrains.android.anko.config.WithGeneratorContext
import org.jetbrains.android.anko.config.get
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.templates.TemplateContext
import org.jetbrains.android.anko.utils.ImportList
import org.jetbrains.android.anko.utils.ReflectionUtils

abstract class Renderer(override val context: GeneratorContext): WithGeneratorContext {
    protected abstract fun processElements(state: GenerationState): GeneratedFile

    abstract val renderIf: Array<ConfigurationKey<Boolean>>

    fun process(state: GenerationState): String = generate(*renderIf) {
        val generatedFile = processElements(state)
        buildString {
            if (!generatedFile.importList.isEmpty()) {
                generatedFile.importList.imports.joinTo(this, "\n") { "import $it" }
                appendln().appendln()
            }

            append(generatedFile.body)
        }
    }

    private fun generate(vararg option: ConfigurationKey<Boolean>, init: () -> String) : String {
        return if (option.any { config[it] }) init() else ""
    }

    protected fun render(
            templateName: String,
            importList: ImportList = ImportList(),
            body: TemplateContext.() -> Unit
    ): String {
        return templateManager.render(templateName, importList, body)
    }
}

fun generatedFile(vararg fileAnnotations: String, builder: StringBuilder.(ImportList) -> Unit): GeneratedFile {
    val sb = StringBuilder()
    val importList = ImportList()
    sb.builder(importList)
    return GeneratedFile(sb.toString(), importList, fileAnnotations.toList())
}

class GeneratedFile(val body: String, val importList: ImportList, val fileAnnotations: List<String>)

class RenderFacade(
        val generationState: GenerationState
) : ViewConstructorUtils, ReflectionUtils {
    private val cachedResults: MutableMap<Class<out Renderer>, String> = hashMapOf()

    operator fun get(clazz: Class<out Renderer>): String = cachedResults.getOrPut(clazz) {
        initializeClassWithArgs(clazz, generationState.context to GeneratorContext::class.java).process(generationState)
    }
}