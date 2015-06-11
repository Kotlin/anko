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

package org.jetbrains.android.anko.render

import org.jetbrains.android.anko.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.jetbrains.android.anko.utils.Buffer
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.config.ConfigurationTune.*
import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.generator.*
import org.jetbrains.android.anko.templates.TemplateContext
import org.jetbrains.android.anko.utils.ReflectionUtils
import org.jetbrains.android.anko.utils.buffer
import org.objectweb.asm.Type
import java.util.*

abstract class Renderer(config: AnkoConfiguration): Configurable(config) {
    protected abstract fun processElements(state: GenerationState): String
    abstract val renderIf: Array<ConfigurationOption>

    public fun process(state: GenerationState): String = generate(*renderIf) {
        processElements(state)
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return config.templateManager.render(templateName, body)
    }
}

class RenderFacade(
        val generationState: GenerationState
) : Configurable(generationState.config), ViewConstructorUtils, SupportUtils, ReflectionUtils {

    private val cachedResults: MutableMap<Class<out Renderer>, String> = hashMapOf()

    fun get(clazz: Class<out Renderer>): String = cachedResults.getOrPut(clazz) {
        initializeClass(clazz, config to javaClass<AnkoConfiguration>()).process(generationState)
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return config.templateManager.render(templateName, body)
    }

}