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
import org.jetbrains.android.anko.generator.LayoutElement
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

    // Generate View extension properties (with "best" setter)
    val properties: String
        get() {
            val propertyRender = PropertyRenderer(config)
            return propertyRender.process(generator.properties) + propertyRender.process(generator.actionbarProperties)
        }

    // Render simple listeners (interfaces with one method)
    val simpleListeners = generateList(SIMPLE_LISTENERS) {
        generator.listeners.filterIsInstance<SimpleListener>().map { it.renderSimpleListener() }
    }

    // Render complex listeners (interfaces with more than one method)
    @suppress("UNCHECKED_CAST")
    private val complexListeners = generateList(COMPLEX_LISTENER_CLASSES, COMPLEX_LISTENER_SETTERS) {
        generator.listeners.filterIsInstance<ComplexListener>()
    }

    val complexListenerSetters = generateList(COMPLEX_LISTENER_SETTERS) {
        complexListeners.map { renderComplexListenerSetter(it) }
    }

    val complexListenerClasses = generateList(COMPLEX_LISTENER_CLASSES) {
        fun ComplexListener.id() = "${clazz.fqName}#$name"

        val generated = LinkedHashMap<String, String>()
        for (listener in complexListeners) {
            if (!generated.contains(listener.id())) {
                generated.put(listener.id(), renderComplexListenerClass(listener))
            }
        }
        generated.values()
    }

    //generated layout classes with custom LayoutParams
    val layouts = LayoutRenderer(config).process(generator.layoutParams)

    val services = ServiceRenderer(config).process(generator.services)

    val sqLiteParserHelpers = SqlParserHelperRenderer(config).process(1..22)

    val interfaceWorkarounds = InterfaceWorkaroundsRenderer(config).process(generator.interfaceWorkarounds)

    //render a simple listener (extension function)
    //example: fun android.view.View.onClick(l: (android.view.View?) -> Unit) = setOnClickListener(l)
    private fun SimpleListener.renderSimpleListener() = render("simple_listener") {
        "receiver" % setter.clazz.fqNameWithTypeArguments
        "name" % method.name
        "args" % method.methodWithClass.formatArguments(config)
        "returnType" % method.returnType
        "setter" % setter.method.name
    }

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

    //get a name for helper class. Listener interfaces are often inner so we'll separate the base class name with "_"
    //For example, for class android.widget.SearchView.OnSuggestionListener it would be SearchView_OnSuggessionListener
    fun getHelperClassName(listener: ComplexListener): String {
        val internalName = listener.clazz.name
        val nestedClassName = internalName.substringAfter('$', "")
        val topLevelClassName = internalName.substringBefore('$').substringAfterLast('/') + listener.clazz.supportSuffix

        return "__$topLevelClassName" + (if (nestedClassName.isNotEmpty()) "_$nestedClassName" else "")
    }

    private fun renderComplexListenerSetter(listener: ComplexListener): String {
        return render("complex_listener_setter") {
            "receiver" % listener.setter.clazz.fqNameWithTypeArguments
            "methodName" % listener.name
            "listener" % getHelperClassName(listener)
            "setter" % listener.setter.method.name
        }
    }

    //render a complex listener
    private fun renderComplexListenerClass(listener: ComplexListener): String {
        val listenerClassName = listener.clazz.fqName
        //ListenerHelper class name (helper mutable class, generates real listener)
        val helperClassName = getHelperClassName(listener)

        //field list (already with indentation)
        val fields = listener.methods.map { method ->
            val varName = method.name.decapitalize()
            val argumentTypes = method.methodWithClass.formatArgumentsTypes(config)
            val lambdaType = "(($argumentTypes) -> ${method.returnType})"
            "private var _$varName: $lambdaType? = null"
        }

        val listenerMethods = listener.methods.flatMap { method ->
            val varName = method.name.decapitalize()
            val methodWithClass = method.methodWithClass

            val arguments = methodWithClass.formatArguments(config)
            val argumentNames = methodWithClass.formatArgumentsNames(config)
            val argumentTypes = methodWithClass.formatArgumentsTypes(config)

            buffer {
                val defaultValue = methodWithClass.method.returnType.getDefaultValue()
                val returnDefaultValue = if (defaultValue.isNotEmpty()) " ?: $defaultValue" else ""

                line("override fun ${method.name}($arguments) = _$varName?.invoke($argumentNames)$returnDefaultValue").nl()
                line("public fun ${method.name}(listener: ($argumentTypes) -> ${method.returnType}) {")
                line("_$varName = listener")
                line("}")
            }.getLines()
        }

        return buffer {
            line("class $helperClassName : $listenerClassName {")
            lines(fields).nl()
            lines(listenerMethods)
            line("}")
        }.toString()
    }

    protected fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        return config.templateManager.render(templateName, body)
    }

}