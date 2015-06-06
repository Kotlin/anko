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
import org.jetbrains.android.anko.generator.ComplexListenerElement
import org.jetbrains.android.anko.generator.LayoutElement
import org.jetbrains.android.anko.generator.SimpleListenerElement
import org.jetbrains.android.anko.templates.TemplateContext
import org.jetbrains.android.anko.utils.buffer
import org.objectweb.asm.Type
import java.util.*

abstract class Renderer<T>(config: AnkoConfiguration): Configurable(config) {
    protected abstract fun processElements(elements: Iterable<T>): String
    abstract val renderIf: Array<ConfigurationOption>

    public fun process(elements: Iterable<T>): String = generate(*renderIf) {
        processElements(elements)
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return config.templateManager.render(templateName, body)
    }
}

class DSLRenderer(private val generator: Generator) : Configurable(generator.config), ViewConstructorUtils, SupportUtils {
    companion object {
        val NOTHING_TO_INLINE = "@suppress(\"NOTHING_TO_INLINE\")"
        val ONLY_LOCAL_RETURN = "inlineOptions(InlineOption.ONLY_LOCAL_RETURN)"
    }

    val views = ViewRenderer(config).process(generator.viewClasses)
    val viewGroups = ViewGroupRenderer(config).process(generator.viewGroupClasses)

    val helperConstructors = generateList(HELPER_CONSTRUCTORS) {
        genHelperConstructors()
    }

    val properties = PropertyRenderer(config).process(generator.properties)

    val listeners = ListenerRenderer(config).process(generator.listeners)

    val layouts = LayoutRenderer(config).process(generator.layoutParams)

    val services = ServiceRenderer(config).process(generator.services)

    val sqLiteParserHelpers = SqlParserHelperRenderer(config).process(1..22)

    val interfaceWorkarounds = InterfaceWorkaroundsRenderer(config).process(generator.interfaceWorkarounds)

    fun genHelperConstructors(): List<String> {
        fun addMethods(node: ClassTreeNode, writeTo: ArrayList<MethodNode>): ArrayList<MethodNode> {
            writeTo.addAll(node.data.methods)
            if (node.parent != null)
                addMethods(node.parent!!, writeTo)
            return writeTo
        }

        fun resolveAllMethods(clazz: ClassNode): List<MethodNode> {
            return addMethods(generator.classTree.findNode(clazz)!!, arrayListOf())
        }

        fun collectProperties(clazz: ClassNode, needed: List<Variable>): List<MethodNode> {
            val ret = arrayListOf<MethodNode>()
            needed.forEach { neededProp ->
                val propList = resolveAllMethods(clazz)
                val found = propList.firstOrNull {
                    it.name.equals("set${neededProp.name.capitalize()}") && it.args.size() == 1 &&
                            it.args[0].fqName.endsWith(neededProp.type)
                } ?: throw RuntimeException("Property $neededProp for helper constructor ${clazz.fqName}.<init>$needed not found.")
                ret.add(found)
            }
            return ret
        }

        val ret = arrayListOf<String>()

        val classesWithHelperConstructors = generator.viewClasses.filter { Props.helperConstructors.contains(it.view.fqName) }

        for ((view, isContainer) in classesWithHelperConstructors) {
            val className = view.fqName
            val helperConstructors = Props.helperConstructors[view.fqName]!!

            for (constructor in helperConstructors) {
                val funcName = view.simpleName.decapitalize()
                val collected = constructor.zip(collectProperties(view, constructor))
                val helperArguments = collected.map {
                    val argumentType = it.second.args[0].asString()
                    "${it.first.name}: $argumentType"
                }.joinToString(", ")
                val setters = collected.map { "view.${it.second.name}(${it.first.name})" }

                fun Buffer.add(extendFor: String) {
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
                }

                ret.add(buffer {
                    add("ViewManager")
                }.toString())
            }
        }
        return ret
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return config.templateManager.render(templateName, body)
    }

}