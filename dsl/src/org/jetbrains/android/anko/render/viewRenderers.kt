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
import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.ViewElement
import org.jetbrains.android.anko.generator.ViewGenerator
import org.jetbrains.android.anko.generator.ViewGroupGenerator
import org.jetbrains.android.anko.utils.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.util.*

public class ViewRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(state: GenerationState) =
            renderViews(state[ViewGenerator::class.java]) { it.fqName }
}

public class ViewGroupRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(state: GenerationState) =
            renderViews(state[ViewGroupGenerator::class.java]) { "_" + it.simpleName + it.supportSuffix }
}

private abstract class AbstractViewRenderer(
        config: AnkoConfiguration
) : Renderer(config), ViewConstructorUtils, SupportUtils {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.VIEWS, ConfigurationTune.HELPER_CONSTRUCTORS)

    protected fun renderViews(views: Iterable<ViewElement>, nameResolver: (ClassNode) -> String): String = StringBuilder {
        val renderViews = config[AnkoFile.VIEWS]
        val renderHelperConstructors = config[ConfigurationTune.HELPER_CONSTRUCTORS]

        for (view in views.filter { !it.clazz.isAbstract }) {
            if (renderViews) renderView(view.clazz, view.isContainer, nameResolver(view.clazz))

            if (renderHelperConstructors) {
                if (Props.helperConstructors.contains(view.fqName)) {
                    append(renderHelperConstructors(view))
                } else if (view.clazz.isTinted()) {
                    val (className21, _) = handleTintedView(view.clazz, nameResolver(view.clazz))
                    if (Props.helperConstructors.contains("android.widget.$className21")) {
                        append(renderHelperConstructors(view))
                    }
                }
            }
        }
    }.toString()

    private fun StringBuilder.renderView(view: ClassNode, isContainer: Boolean, className: String) {
        val constructors = ViewConstructorUtils.AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
            view.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
        }

        val (className21, functionName) = handleTintedView(view, className)
        val tinted = className21 != null

        fun renderView(receiver: String) = render("view") {
            "receiver" % receiver
            "functionName" % functionName
            "className" % className
            "lambdaArgType" % if (tinted) className21 else className
            "returnType" % if (tinted) className21 else view.fqName
            "additionalArgs" % ""
            "constructorArgs" % renderConstructorArgs(view, constructors, "ctx")

            "tinted" % tinted
            if (tinted) "className21" % className21
        }

        append(renderView("ViewManager"))
        if (config[ConfigurationTune.TOP_LEVEL_DSL_ITEMS] && isContainer) {
            append(renderView("Context"))
            append(renderView("Activity"))
        }
    }

    private fun renderHelperConstructors(view: ViewElement) = StringBuilder {
        val className = view.fqName

        val (className21, functionName) = handleTintedView(view.clazz, className)
        val tinted = className21 != null
        val lambdaArgType = if (tinted) className21 else className

        val helperConstructors = Props.helperConstructors[if (tinted) "android.widget.$className21" else view.fqName] ?:
                throw RuntimeException("Helper constructors not found for $className")

        for (constructor in helperConstructors) {
            val collected = constructor.zip(collectProperties(view, constructor))
            val helperArguments = collected.map {
                val argumentType = it.second.args[0].asString()
                "${it.first.name}: $argumentType"
            }.joinToString(", ")
            val setters = collected.map { "view.${it.second.name}(${it.first.name})" }

            fun add(extendFor: String) = buffer {
                val makeView = if (tinted) {
                    "val view = if (Build.VERSION.SDK_INT < 21) $className(ctx) else $className21(ctx)"
                } else {
                    "val view = $className(ctx)"
                }

                val returnType = if (tinted) className21 else className

                line(NOTHING_TO_INLINE)
                line("public inline fun $extendFor.$functionName($helperArguments): $returnType = addView<$returnType> {")
                line("ctx ->")
                line(makeView)
                lines(setters)
                line("view")
                line("}")

                line("public inline fun $extendFor.$functionName($helperArguments, $ONLY_LOCAL_RETURN init: $lambdaArgType.() -> Unit): $returnType = addView<$returnType> {")
                line("ctx ->")
                line(makeView)
                lines(setters)
                line("view.init()")
                line("view")
                line("}")
                nl()
            }.toString()

            append(add("ViewManager"))
        }
    }.toString()

    private fun collectProperties(view: ViewElement, properties: List<Variable>): List<MethodNode> {
        return properties.map { property ->
            val methodName = "set" + property.name.capitalize()
            val methods = view.allMethods.filter {
                it.name == methodName && it.args.size() == 1 && it.args[0].fqName.endsWith(property.type)
            }

            when (methods.size()) {
                0 -> throw RuntimeException("Can't find a method $methodName for helper constructor ${view.fqName}($properties)")
                1 -> {}
                else -> throw RuntimeException("There are several methods $methodName for helper constructor ${view.fqName}($properties)")
            }

            methods[0]
        }
    }

    private fun handleTintedView(view: ClassNode, className: String): Pair<String?, String> {
        val tinted = view.isTinted()
        val className21 = if (tinted) className.substring(APP_COMPAT_VIEW_PREFIX.length()) else null
        val functionName = if (tinted) "tinted$className21" else view.simpleName.decapitalize() + view.supportSuffix
        return className21 to functionName
    }

    private fun ClassNode.isTinted() = fqName.startsWith(APP_COMPAT_VIEW_PREFIX)

    private companion object {
        val NOTHING_TO_INLINE = "@suppress(\"NOTHING_TO_INLINE\")"
        val ONLY_LOCAL_RETURN = "inlineOptions(InlineOption.ONLY_LOCAL_RETURN)"
        val APP_COMPAT_VIEW_PREFIX = "android.support.v7.widget.AppCompat"
    }

}