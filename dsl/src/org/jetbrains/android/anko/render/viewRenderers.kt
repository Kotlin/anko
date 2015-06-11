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
import org.jetbrains.android.anko.generator.ViewGenerator
import org.jetbrains.android.anko.generator.ViewElement
import org.jetbrains.android.anko.generator.ViewGroupGenerator
import org.jetbrains.android.anko.utils.Buffer
import org.jetbrains.android.anko.utils.buffer
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.util.*

public class ViewRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(state: GenerationState) =
            renderViews(state[javaClass<ViewGenerator>()]) { it.fqName }
}

public class ViewGroupRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(state: GenerationState) =
            renderViews(state[javaClass<ViewGroupGenerator>()]) { "_" + it.simpleName + it.supportSuffix }
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

            if (renderHelperConstructors && Props.helperConstructors.contains(view.fqName)) {
                append(renderHelperConstructors(view))
            }
        }
    }.toString()

    private fun StringBuilder.renderView(view: ClassNode, isContainer: Boolean, className: String) {
        val constructors = ViewConstructorUtils.AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
            view.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
        }

        fun renderView(receiver: String) = render("view") {
            "receiver" % receiver
            "functionName" % (view.simpleName.decapitalize() + view.supportSuffix)
            "className" % className
            "returnType" % view.fqName
            "additionalArgs" % ""
            "constructorArgs" % renderConstructorArgs(view, constructors, "ctx")
        }

        append(renderView("ViewManager"))
        if (config[ConfigurationTune.TOP_LEVEL_DSL_ITEMS] && isContainer) {
            append(renderView("Context"))
            append(renderView("Activity"))
        }
    }

    private fun renderHelperConstructors(view: ViewElement) = StringBuilder {
        val className = view.fqName
        val helperConstructors = Props.helperConstructors[view.fqName]!!

        for (constructor in helperConstructors) {
            val funcName = view.clazz.simpleName.decapitalize()
            val collected = constructor.zip(collectProperties(view, constructor))
            val helperArguments = collected.map {
                val argumentType = it.second.args[0].asString()
                "${it.first.name}: $argumentType"
            }.joinToString(", ")
            val setters = collected.map { "view.${it.second.name}(${it.first.name})" }

            fun add(extendFor: String) = buffer {
                line(NOTHING_TO_INLINE)
                line("public inline fun $extendFor.$funcName($helperArguments): $className = addView<$className> {")
                line("ctx ->")
                line("val view = $className(ctx)")
                lines(setters)
                line("view")
                line("}")

                line("public inline fun $extendFor.$funcName($helperArguments, $ONLY_LOCAL_RETURN init: $className.() -> Unit): $className = addView<$className> {")
                line("ctx ->")
                line("val view = $className(ctx)")
                lines(setters)
                line("view.init()")
                line("view")
                line("}")
                nl()
            }.toString()

            val asd = add("ViewManager")
            append(asd)
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

    private companion object {
        val NOTHING_TO_INLINE = "@suppress(\"NOTHING_TO_INLINE\")"
        val ONLY_LOCAL_RETURN = "inlineOptions(InlineOption.ONLY_LOCAL_RETURN)"
    }

}