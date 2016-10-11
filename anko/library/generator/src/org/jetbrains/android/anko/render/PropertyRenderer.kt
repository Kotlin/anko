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

import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.args
import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.PropertyElement
import org.jetbrains.android.anko.generator.PropertyGenerator
import org.jetbrains.android.anko.renderReturnType
import org.jetbrains.android.anko.returnType
import org.jetbrains.android.anko.utils.*

class PropertyRenderer(context: AnkoBuilderContext) : Renderer(context) {

    override val renderIf: Array<ConfigurationKey<Boolean>> = arrayOf(AnkoFile.PROPERTIES)

    override fun processElements(state: GenerationState) = StringBuilder().apply {
        state[PropertyGenerator::class.java].forEach {
            append(renderProperty(it))
        }
    }.toString()

    private fun renderProperty(property: PropertyElement): String {
        val getter = property.getter
        val className = (getter ?: property.setters.first()).clazz.fqNameWithTypeArguments
        val fullPropertyName = "$className.${property.name}"
        val bestSetter = property.setters.firstOrNull()
        val mutability = if (bestSetter != null) "var" else "val"

        val javaReturnType = getter?.method?.returnType?.asJavaString()
                ?: bestSetter?.method?.args?.get(0)?.asJavaString()
                ?: "java.lang.Object"

        val rawReturnType = getter?.method?.renderReturnType(false)
                ?: bestSetter?.method?.args?.get(0)?.asString(false)
                ?: "Any"

        val nullable = if (javaReturnType.indexOf('.') < 0) {
            false // Do not look up annotations for simple types
        } else if (getter != null) {
            val annotationSignature = "${getter.clazz.fqName} $javaReturnType ${getter.method.name}()"
            val foundAnnotations = annotationManager.findExternalAnnotations(annotationSignature)
            ExternalAnnotation.NotNull !in foundAnnotations
        } else true // Default is nullable

        val nullability = if (nullable) "?" else ""

        val otherSetters = if (property.setters.size > 1) property.setters.drop(1) else emptyList()

        if (property.getter != null) {
            return buffer {
                renderResourceProperty(otherSetters, fullPropertyName, rawReturnType)
            }.toString()
        }

        return buffer {
            line("$mutability $fullPropertyName: $rawReturnType$nullability")
            if (getter != null) {
                indent.line("get() = ${getter.method.name}()")
            } else {
                indent.line("get() = throw AnkoException(\"'$fullPropertyName' property does not have a getter\")")
            }
            if (bestSetter != null) indent.line("set(v) = ${bestSetter.method.name}(v)")
            nl()
        }.toString()
    }

    private fun Buffer.renderResourceProperty(
            otherSetters: List<MethodNodeWithClass>,
            fullPropertyName: String,
            returnType: String)
    {
        if (otherSetters.isNotEmpty() && supportsResourceSetter(returnType)) {
            val resourceSetter = otherSetters.firstOrNull {
                it.method.args.size == 1 && (it.method.args[0].className == "int")
            }

            if (resourceSetter != null) {
                line("var ${fullPropertyName}Resource: Int")
                indent.line("get() = throw AnkoException(\"'${fullPropertyName}Resource' property does not have a getter\")")
                indent.line("set(v) = ${resourceSetter.method.name}(v)")
                nl()
            }
        }
    }

    private fun supportsResourceSetter(typ: String): Boolean {
        return (
                typ.matches("^CharSequence\\??$".toRegex()) ||
                        (typ.matches("^android.graphics.drawable.Drawable\\??$".toRegex()))
                )
    }
}