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

import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.formatArguments
import org.jetbrains.android.anko.formatArgumentsNames
import org.jetbrains.android.anko.formatArgumentsTypes
import org.jetbrains.android.anko.generator.*
import org.jetbrains.android.anko.returnType
import org.jetbrains.android.anko.utils.*
import org.objectweb.asm.Type

class ListenerRenderer(context: GeneratorContext) : AbstractListenerRenderer(context) {
    override val simpleListenerTemplateName = "simple_listener"
    override val complexListenerTemplateName = "complex_listener"
}

class CoroutineListenerRenderer(context: GeneratorContext) : AbstractListenerRenderer(context) {
    override val simpleListenerTemplateName = "simple_listener_coroutines"
    override val complexListenerTemplateName = "complex_listener_coroutines"
}

abstract class AbstractListenerRenderer(context: GeneratorContext) : Renderer(context) {
    abstract val simpleListenerTemplateName: String
    abstract val complexListenerTemplateName: String

    override val renderIf: Array<ConfigurationKey<Boolean>> = arrayOf(AnkoFile.LISTENERS)

    override fun processElements(state: GenerationState) = generatedFile { importList ->
        for (listener in state[ListenerGenerator::class.java]) {
            when (listener) {
                is SimpleListenerElement -> append(listener.render(importList))
                is ComplexListenerElement -> append(listener.render(importList))
                else -> throw RuntimeException("Invalid listener type: ${listener.javaClass.name}")
            }
        }
    }

    private fun SimpleListenerElement.render(importList: ImportList) = render(simpleListenerTemplateName, importList) {
        "receiver" % setter.clazz.fqNameWithTypeArguments
        "name" % method.name
        "args" % method.methodWithClass.formatArguments(context)
        "argNames" % method.methodWithClass.formatArgumentsNames(context)
        "hasArgs" % Type.getType(method.methodWithClass.method.desc).argumentTypes.isNotEmpty()
        "returnType" % method.returnType.asString()
        "returnDefaultValue" % method.returnType.getDefaultValue(onlyPrimitive = true)
        "setter" % setter.method.name
    }

    private fun ComplexListenerElement.render(importList: ImportList): String {
        return render(complexListenerTemplateName, importList) {
            "helperClassName" % getHelperClassName(this@render)
            "listenerClassName" % clazz.fqName
            "superConstructorCall" % (if (clazz.getConstructors().isNotEmpty()) "()" else "")

            "setter" % mapOf(
                "receiver" to setter.clazz.fqNameWithTypeArguments,
                "methodName" to name,
                "listener" to getHelperClassName(this@render),
                "setter" to setter.method.name
            )

            "methods" % seq(methods) { method ->
                val methodWithClass = method.methodWithClass

                "methodName" % method.name
                "args" % methodWithClass.formatArguments(context)
                "hasArgs" % Type.getType(method.methodWithClass.method.desc).argumentTypes.isNotEmpty()
                "argNames" % methodWithClass.formatArgumentsNames(context)
                "argTypes" % methodWithClass.formatArgumentsTypes(context)
                "returnDefaultValue" % methodWithClass.method.returnType.getDefaultValue(onlyPrimitive = true)
                "varName" % method.name.decapitalize()
                "returnType" % method.returnType.asString()
                "possiblyNullableReturnType" % method.returnType.asString(isNullable = true)
            }
        }
    }

    // Get a name for helper class. Listener interfaces are often inner so we'll separate the base class name with "_"
    // For example, for class android.widget.SearchView.OnSuggestionListener it would be SearchView_OnSuggestionListener
    fun getHelperClassName(listener: ComplexListenerElement): String {
        val internalName = listener.clazz.name
        val nestedClassName = internalName.substringAfter('$', "")
        val topLevelClassName = internalName.substringBefore('$').substringAfterLast('/')

        return "__$topLevelClassName" + (if (nestedClassName.isNotEmpty()) "_$nestedClassName" else "")
    }
}