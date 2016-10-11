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
import org.jetbrains.android.anko.config.ConfigurationKey
import org.jetbrains.android.anko.config.WithContext
import org.jetbrains.android.anko.config.get
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.templates.TemplateContext
import org.jetbrains.android.anko.utils.ReflectionUtils

abstract class Renderer(override val context: AnkoBuilderContext): WithContext {
    protected abstract fun processElements(state: GenerationState): String
    abstract val renderIf: Array<ConfigurationKey<Boolean>>

    fun process(state: GenerationState): String = generate(*renderIf) {
        processElements(state)
    }

    private fun generate(vararg option: ConfigurationKey<Boolean>, init: () -> String) : String {
        return if (option.any { config[it] }) init() else ""
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return templateManager.render(templateName, body)
    }
}

class RenderFacade(
        val generationState: GenerationState
) : ViewConstructorUtils, ReflectionUtils {
    private val cachedResults: MutableMap<Class<out Renderer>, String> = hashMapOf()

    operator fun get(clazz: Class<out Renderer>): String = cachedResults.getOrPut(clazz) {
        initializeClassWithArgs(clazz, generationState.context to AnkoBuilderContext::class.java).process(generationState)
    }
}