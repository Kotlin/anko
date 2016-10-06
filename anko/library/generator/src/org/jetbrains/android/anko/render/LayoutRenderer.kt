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

import org.jetbrains.android.anko.args
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationOption
import org.jetbrains.android.anko.formatLayoutParamsArguments
import org.jetbrains.android.anko.formatLayoutParamsArgumentsInvoke
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.LayoutElement
import org.jetbrains.android.anko.generator.LayoutGenerator
import org.jetbrains.android.anko.utils.MethodNodeWithClass
import org.jetbrains.android.anko.utils.fqName
import org.jetbrains.android.anko.utils.getConstructors
import org.jetbrains.android.anko.utils.simpleName
import java.util.*

class LayoutRenderer(config: AnkoConfiguration) : Renderer(config), ViewConstructorUtils {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.LAYOUTS)

    override fun processElements(state: GenerationState) = StringBuilder().apply {
        append("private val defaultInit: Any.() -> Unit = {}").appendln().appendln()
        state[LayoutGenerator::class.java].forEach { append(renderLayout(it)) }
    }.toString()

    private fun renderLayout(node: LayoutElement): String {
        val constructors = ViewConstructorUtils.AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
            node.layout.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
        }

        val layoutParamsClass = node.layoutParams.fqName

        return render("layout") {
            "name" % "_${node.layout.simpleName}"
            "constructor" % renderConstructorArgs(node.layout, constructors, "ctx", argumentNames = true)

            "baseClass" % node.layout.fqName
            "baseConstructor" % renderConstructorArgs(node.layout, constructors, "ctx")

            "functions" % seq(node.constructors) { item ->
                val function = MethodNodeWithClass(node.layoutParams, item)
                "params" % function.formatLayoutParamsArguments(config)
                "substituted" % function.formatLayoutParamsArgumentsInvoke(config)
                "layoutParamsClass" % layoutParamsClass
            }
        }
    }
}