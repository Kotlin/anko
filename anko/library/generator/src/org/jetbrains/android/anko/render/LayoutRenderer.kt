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
import org.jetbrains.android.anko.formatLayoutParamsArguments
import org.jetbrains.android.anko.formatLayoutParamsArgumentsInvoke
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.LayoutElement
import org.jetbrains.android.anko.generator.LayoutGenerator
import org.jetbrains.android.anko.parameterRawTypes
import org.jetbrains.android.anko.utils.*
import java.util.*

class LayoutRenderer(context: GeneratorContext) : Renderer(context), ViewConstructorUtils {
    override val renderIf: Array<ConfigurationKey<Boolean>> = arrayOf(AnkoFile.LAYOUTS)

    override fun processElements(state: GenerationState) = generatedFile { importList ->
        state[LayoutGenerator::class.java].forEach { append(renderLayout(it, importList)) }
    }

    private fun renderLayout(node: LayoutElement, importList: ImportList): String {
        val constructors = ViewConstructorUtils.AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
            node.layout.getConstructors().firstOrNull { Arrays.equals(it.parameterRawTypes, constructor) }
        }

        val layoutParamsClass = node.layoutParams.fqName

        return render("layout", importList) {
            "layoutName" % "_${node.layout.simpleName}"
            "layoutConstructorArgs" % renderConstructorArgs(node.layout, constructors, "ctx", argumentNames = true)

            "baseClassName" % node.layout.fqName
            "baseClassConstructorArgs" % renderConstructorArgs(node.layout, constructors, "ctx")

            "lparamsFunctions" % seq(node.constructors) { item ->
                val function = MethodNodeWithClass(node.layoutParams, item)
                "params" % function.formatLayoutParamsArguments(context, importList)
                "substituted" % function.formatLayoutParamsArgumentsInvoke(context)
                "layoutParamsClass" % layoutParamsClass
            }
        }
    }
}