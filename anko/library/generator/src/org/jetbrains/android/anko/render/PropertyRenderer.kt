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

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.config.GeneratorContext
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationKey
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.PropertyElement
import org.jetbrains.android.anko.generator.PropertyGenerator
import org.jetbrains.android.anko.utils.*

class PropertyRenderer(context: GeneratorContext) : Renderer(context) {
    override val renderIf: Array<ConfigurationKey<Boolean>> = arrayOf(AnkoFile.PROPERTIES)

    override fun processElements(state: GenerationState) = generatedFile { importList ->
        state[PropertyGenerator::class.java].forEach {
            append(renderProperty(it, importList))
        }
    }

    private fun renderProperty(property: PropertyElement, importList: ImportList): String {
        val getter = property.getter
        val className = (getter ?: property.setters.first()).clazz.fqNameWithTypeArguments
        val fullPropertyName = "$className.${property.name}"
        val bestSetter = property.setters.firstOrNull()
        val mutability = if (bestSetter != null) "var" else "val"

        val returnType = getter?.toKMethod(context)?.returnType
                ?: bestSetter?.toKMethod(context)?.parameters?.firstOrNull()?.type
                ?: KType.ANY_TYPE

        val otherSetters = if (property.setters.size > 1) property.setters.drop(1) else emptyList()

        if (property.getter != null) {
            return buffer {
                renderResourceProperty(otherSetters, fullPropertyName, returnType, importList)
            }.toString()
        }

        return buffer {
            line("$mutability $fullPropertyName: $returnType")
            if (getter != null) {
                indent.line("get() = ${getter.method.name}()")
            } else {
                renderNoGetter(importList)
            }
            if (bestSetter != null) indent.line("set(v) = ${bestSetter.method.name}(v)")
            nl()
        }.toString()
    }

    private fun Buffer.renderNoGetter(importList: ImportList) {
        val NO_GETTER = importList["org.jetbrains.anko.internals.AnkoInternals.NO_GETTER"]
        val noGetter = importList["org.jetbrains.anko.internals.AnkoInternals.noGetter"]
        val ERROR = importList["kotlin.DeprecationLevel.ERROR"]
        indent.line("@Deprecated($NO_GETTER, level = $ERROR) get() = $noGetter()")
    }

    private fun Buffer.renderResourceProperty(
            otherSetters: List<MethodNodeWithClass>,
            fullPropertyName: String,
            returnType: KType,
            importList: ImportList
    ) {
        if (otherSetters.isNotEmpty() && supportsResourceSetter(returnType)) {
            val resourceSetter = otherSetters.firstOrNull { it.method.parameterRawTypes.unique?.className == "int" }

            if (resourceSetter != null) {
                line("var ${fullPropertyName}Resource: Int")
                renderNoGetter(importList)
                indent.line("set(v) = ${resourceSetter.method.name}(v)")
                nl()
            }
        }
    }

    private fun supportsResourceSetter(type: KType): Boolean {
        return type.className == "CharSequence" || type.fqName == "android.graphics.drawable.Drawable"
    }
}