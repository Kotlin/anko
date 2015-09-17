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
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationOption
import org.jetbrains.android.anko.config.ConfigurationTune.COMPLEX_LISTENER_CLASSES
import org.jetbrains.android.anko.config.ConfigurationTune.COMPLEX_LISTENER_SETTERS
import org.jetbrains.android.anko.config.ConfigurationTune.SIMPLE_LISTENERS
import org.jetbrains.android.anko.generator.ComplexListenerElement
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.ListenerGenerator
import org.jetbrains.android.anko.generator.SimpleListenerElement
import org.jetbrains.android.anko.utils.*

public class ListenerRenderer(config: AnkoConfiguration) : Renderer(config) {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.LISTENERS)

    override fun processElements(state: GenerationState) = StringBuilder {
        val renderedClasses = hashSetOf<String>()

        for (listener in state[ListenerGenerator::class.java]) {
            when (listener) {
                is SimpleListenerElement -> if (config[SIMPLE_LISTENERS]) append(listener.render())
                is ComplexListenerElement -> {
                    if (config[COMPLEX_LISTENER_SETTERS]) append(listener.renderSetter())
                    if (config[COMPLEX_LISTENER_CLASSES] && !renderedClasses.contains(listener.id)) {
                        append(listener.renderClass())
                        renderedClasses.add(listener.id)
                    }
                }
                else -> throw RuntimeException("Invalid listener type: ${listener.javaClass.name}")
            }
        }
    }.toString()

    private fun SimpleListenerElement.render() = render("simple_listener") {
        "receiver" % setter.clazz.fqNameWithTypeArguments
        "name" % method.name
        "args" % method.methodWithClass.formatArguments(config)
        "returnType" % method.returnType.asString()
        "setter" % setter.method.name
    }

    private fun ComplexListenerElement.renderSetter(): String {
        return render("complex_listener_setter") {
            "receiver" % setter.clazz.fqNameWithTypeArguments
            "methodName" % name
            "listener" % getHelperClassName(this@renderSetter)
            "setter" % setter.method.name
        }
    }

    private fun ComplexListenerElement.renderClass(): String {
        val listenerClassName = clazz.fqName
        //ListenerHelper class name (helper mutable class, generates real listener)
        val helperClassName = getHelperClassName(this)

        //field list (already with indentation)
        val fields = methods.map { method ->
            val varName = method.name.decapitalize()
            val argumentTypes = method.methodWithClass.formatArgumentsTypes(config)
            val lambdaType = "(($argumentTypes) -> ${method.returnType.asString()})"
            "private var _$varName: $lambdaType? = null"
        }

        val listenerMethods = methods.flatMap { method ->
            val varName = method.name.decapitalize()
            val methodWithClass = method.methodWithClass

            val arguments = methodWithClass.formatArguments(config)
            val argumentNames = methodWithClass.formatArgumentsNames(config)
            val argumentTypes = methodWithClass.formatArgumentsTypes(config)

            buffer {
                val defaultValue = methodWithClass.method.returnType.getDefaultValue()
                val returnDefaultValue = if (defaultValue.isNotEmpty()) " ?: $defaultValue" else ""

                if (!method.returnType.isVoid) {
                    line("override fun ${method.name}($arguments) = _$varName?.invoke($argumentNames)$returnDefaultValue").nl()
                } else {
                    line("override fun ${method.name}($arguments) {")
                    line("_$varName?.invoke($argumentNames)$returnDefaultValue")
                    line("}").nl()
                }

                line("public fun ${method.name}(listener: ($argumentTypes) -> ${method.returnType.asString()}) {")
                line("_$varName = listener")
                line("}")
            }.getLines()
        }

        return buffer {
            val superConstructorCall = if (clazz.getConstructors().isNotEmpty()) "()" else ""
            line("class $helperClassName : $listenerClassName$superConstructorCall {")
            lines(fields).nl()
            lines(listenerMethods)
            line("}")
            nl()
        }.toString()
    }

    // Get a name for helper class. Listener interfaces are often inner so we'll separate the base class name with "_"
    // For example, for class android.widget.SearchView.OnSuggestionListener it would be SearchView_OnSuggessionListener
    fun getHelperClassName(listener: ComplexListenerElement): String {
        val internalName = listener.clazz.name
        val nestedClassName = internalName.substringAfter('$', "")
        val topLevelClassName = internalName.substringBefore('$').substringAfterLast('/')

        return "__$topLevelClassName" + (if (nestedClassName.isNotEmpty()) "_$nestedClassName" else "")
    }
}