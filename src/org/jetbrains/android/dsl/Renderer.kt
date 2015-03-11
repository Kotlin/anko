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

package org.jetbrains.android.dsl

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.util.ArrayList
import org.jetbrains.android.dsl.utils.Buffer
import org.jetbrains.android.dsl.KoanFile.*
import org.jetbrains.android.dsl.ConfigurationTune.*
import org.jetbrains.android.dsl.utils.buffer
import org.objectweb.asm.Type

class Renderer(private val generator: Generator) : Configurable(generator.config) {

    val views = generate(VIEWS) {
        generateViews(generator.viewClasses) { it.fqName }
    }

    val viewGroups = generate(VIEWS) {
        generateViews(generator.viewGroupClasses) { "_" + it.simpleName }
    }

    val helperConstructors = generate(HELPER_CONSTRUCTORS) {
        genHelperConstructors()
    }

    // Generate View extension properties (with "best" setter)
    val properties = generate(PROPERTIES) {
        generator.properties.map { property ->
            val getter = property.getter
            val fullPropertyName = "${getter.clazz.fqName}.${property.name}"
            val bestSetter = property.setters.firstOrNull()
            val mutability = if (bestSetter != null) "var" else "val"
            val returnType = getter.method.renderReturnType()
            val otherSetters = if (property.setters.size() > 1) property.setters.drop(1) else listOf()

            buffer {
                line("public $mutability $fullPropertyName: $returnType")
                indent.line("get() = ${getter.method.name}()")
                if (bestSetter != null) indent.line("set(v) = ${bestSetter.method.name}(v)")

                renderResourceProperty(otherSetters, fullPropertyName, returnType)
            }.toString()
        }
    }

    private fun Buffer.renderResourceProperty(
        otherSetters: List<MethodNodeWithClass>,
        fullPropertyName: String,
        returnType: String)
    {
        if (otherSetters.isNotEmpty() && supportsResourceSetter(returnType)) {
            val resourceSetter = otherSetters.firstOrNull {
                it.method.args.size() == 1 && (it.method.args[0].getClassName() == "int")
            }

            if (resourceSetter != null) {
                line("public var ${fullPropertyName}Resource: Int")
                indent.line("get() = throw KoanException(\"'${fullPropertyName}Resource' property doesn't have a getter\")")
                indent.line("set(v) = ${resourceSetter.method.name}(v)")
            }
        }
    }

    // Render simple listeners (interfaces with one method)
    val simpleListeners = generate(SIMPLE_LISTENERS) {
        generator.listeners
            .filter { it is SimpleListener }
            .map { renderSimpleListener(it as SimpleListener) }
    }

    // Render complex listeners (interfaces with more than one method)
    private val complexListeners = generate(COMPLEX_LISTENER_CLASSES, COMPLEX_LISTENER_SETTERS) {
        generator.listeners.filter { it is ComplexListener }
    }

    val complexListenerSetters = generate(COMPLEX_LISTENER_SETTERS) {
        complexListeners.map { renderComplexListenerSetters(it as ComplexListener) }
    }

    val complexListenerClasses = generate(COMPLEX_LISTENER_CLASSES) {
        complexListeners.map { renderComplexListenerClass(it as ComplexListener) }
    }

    //generated layout classes with custom LayoutParams
    val layouts = generate(LAYOUTS) {
        generator.layoutParams.map { renderLayout(it) }
    }

    val services = generator.services.map {
        val propertyName = it.second!!.data.simpleName.decapitalize()
        val className = it.second!!.data.fqName
        "public val Context.$propertyName: $className\n"+
                "${config.indent}get() = getSystemService(Context.${it.first}) as $className"
    }

    val sqLiteParserHelpers = generate(SQL_PARSER_HELPERS) {
        val list = arrayListOf<String>()
        for (i in 1..22) {
            val types = (1..i).map { "T$it" }.joinToString(", ")
            val args = (1..i).map { "columns[${it - 1}] as T$it" }.joinToString(", ")

            list.add(buffer {
                line("public fun <$types, R> rowParser(parser: ($types) -> R): RowParser<R> {")
                    line("return object : RowParser<R> {")
                        line("override fun parseRow(columns: Array<Any>): R {")
                        line("if (columns.size() != $i)")
                        val s = if (i == 1) "" else "s"
                        indent.line("throw SQLiteException(\"Invalid row: $i column$s required\")")
                        line("[suppress(\"UNCHECKED_CAST\")]")
                        line("return parser($args)")
                        line("}")
                    line("}")
                line("}")
            }.toString())
        }
        list
    }

    val interfaceWorkarounds = if (!config[INTERFACE_WORKAROUNDS]) "" else
        generator.interfaceWorkarounds.map {
            val (mainClass, ancestor, innerClass) = it
            val probInterfaceName = innerClass!!.innerName
            val conflict = generator.interfaceWorkarounds.count { it.third!!.innerName == probInterfaceName } > 1
            val interfaceName = (if (conflict) innerClass.outerName.substringAfterLast("/") + "_" else "") + probInterfaceName
            val ancestorName = ancestor!!.fqName

            buffer(1) {
                line("public static interface $interfaceName {")
                for (field in mainClass.fields.filter { it.isPublic && it.isStatic && it.isFinal }) {
                    val name = field.name
                    val type = Type.getType(field.desc).asJavaString()
                    line("public static final $type $name = $ancestorName.$name;")
                }
                line("}")
            }.toString()
        }.joinToString("\n", "public final class InterfaceWorkarounds {\n\n", "\n\n}")

    private fun generateViews(views: List<ClassNode>, nameResolver: (ClassNode) -> String): List<String> {
        return views.filter { !it.isAbstract && it.hasSimpleConstructor() }.map { clazz ->
            val typeName = clazz.fqName
            val className = nameResolver(clazz)
            val funcName = clazz.simpleName.decapitalize()

            buffer {
                line("public fun ViewManager.$funcName(init: $className.() -> Unit = defaultInit): $typeName =")
                line("addView($className(dslContext), init, this)")
                if (config[TOP_LEVEL_DSL_ITEMS]) {
                    fun add(extendFor: String, ctx: String) {
                        line("public fun $extendFor.$funcName(init: $className.() -> Unit = defaultInit): $typeName =")
                        line("add${extendFor}TopLevelView($className($ctx), init)")
                    }
                    add("Fragment", "getActivity()!!")
                    add("Context", "this")
                    add("Activity", "this")
                }
            }.toString()
        }
    }

    //render a simple listener (extension function)
    //example: fun android.view.View.onClick(l: (android.view.View?) -> Unit) = setOnClickListener(l)
    private fun renderSimpleListener(listener: SimpleListener): String {
        val className = listener.setter.clazz.fqNameWithTypeArguments
        val argumentTypes = listener.method.argumentTypes
        val returnType = listener.method.returnType

        return buffer {
            line("public fun $className.${listener.method.name}(l: ($argumentTypes) -> $returnType): Unit =")
            line("${listener.setter.method.name}(l)")
        }.toString()
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
                }
                if (found == null)
                    throw RuntimeException("Property $neededProp for helper constructor ${clazz.fqName}.<init>$needed not found.")
                ret.add(found)
            }
            return ret
        }

        val ret = arrayListOf<String>()
        generator.viewClasses.filter { Props.helperConstructors.contains(it.fqName) }.forEach { view ->
            val viewClassName = view.fqName
            val helperConstructors = Props.helperConstructors[view.fqName]!!

            for (constructor in helperConstructors) {
                val functionName = view.simpleName.decapitalize()
                val collected = constructor.zip(collectProperties(view, constructor))
                val helperArguments = collected.map {
                    val argumentType = it.second.args[0].asString()
                    "${it.first.name}: $argumentType"
                }.joinToString(", ")
                val arguments = "$helperArguments, init: $viewClassName.() -> Unit = defaultInit"
                val setters = collected.map { "v.${it.second.name}(${it.first.name})" }

                ret.add(buffer {
                    line("public fun ViewManager.$functionName($arguments): $viewClassName {")
                    line("val v = $viewClassName(dslContext)")
                    lines(setters)
                    line("return addView(v, init, this)")
                    line("}")
                }.toString())
            }
        }
        return ret
    }

    //get a name for helper class. Listener interfaces are often inner so we'll separate the base class name with "_"
    //For example, for class android.widget.SearchView.OnSuggestionListener it would be SearchView_OnSuggessionListener
    fun getHelperClassName(listener: ComplexListener): String {
        val basename = listener.clazz.name.substringAfter('.').replace("$", "_")
        val setterClassName = listener.setter.clazz.simpleName
        val setterName = setterClassName.replace(".", "_") + "_" + listener.setter.method.name
        return "__" + setterName + "_" + basename.substring(basename.lastIndexOf("/") + 1)
    }

    private fun renderComplexListenerSetters(listener: ComplexListener): String {
        //ListenerHelper class name (helper mutable class, generates real listener)
        val helperClassName = getHelperClassName(listener)
        val setterClass = listener.setter.clazz.fqNameWithTypeArguments
        //key for storing ListenerHelper (local to this setter)
        val hashKey = "${setterClass}_${listener.setter.method.name}"

        fun renderExtensionMethods() = listener.methods.map { method ->
            val varName = method.name.decapitalize()
            val argumentType = "(${method.argumentTypes}) -> ${method.returnType}"

            buffer {
                line("public fun $setterClass.${method.name.decapitalize()}(act: $argumentType) {")
                line("val props = getTag() as? ViewProps")
                line("if (props != null) {")
                    line("var l: $helperClassName? =")
                    line("props.listeners.get(\"$hashKey\") as? $helperClassName")
                    line("if (l == null) {")
                    line("l = $helperClassName(this)")
                    line("props.listeners.put(\"$hashKey\", l!!)")
                line("}")
                line("l!!._$varName = act")
                line("l!!.apply()")
                line("}").line("}")

            }.toString()
        }
        return renderExtensionMethods().joinToString("\n")
    }

    //render a complex listener
    private fun renderComplexListenerClass(listener: ComplexListener): String {
        val listenerClassName = listener.clazz.fqName
        //ListenerHelper class name (helper mutable class, generates real listener)
        val helperClassName = getHelperClassName(listener)
        val setterClass = listener.setter.clazz.fqNameWithTypeArguments

        //field list (already with indentation)
        val fields = listener.methods.map { method ->
            val varName = method.name.decapitalize()
            val argumentNames = method.method.fmtArgumentsNames()
            val lambdaType = "((${method.argumentTypes}) -> ${method.returnType})"
            val returnValue = method.method.returnType.getDefaultValue()
            val initializer = "{ $argumentNames -> $returnValue }"
            val simplifiedInitializer = if (initializer == "{  ->  }") "{}" else initializer
            "var _$varName: $lambdaType = $simplifiedInitializer "
        }
        //listener methods (for produced anonymous class, already with indentation)
        val listenerMethods = listener.methods.map { method ->
            val varName = method.name.decapitalize()
            val customArgumentsKey = "$listenerClassName#${method.name}"
            val customArguments = Props.customMethodParameters.get(customArgumentsKey)
            val arguments = customArguments ?: method.method.fmtArguments()
            val substitution = method.method.fmtArgumentsNames()
            "override fun ${method.name}($arguments) = _$varName($substitution)"
        }

        return buffer {
            line("class $helperClassName(val v: $setterClass): ListenerHelper {")
            lines(fields).nl()
            line("override fun apply() {")
            line("v.${listener.setter.method.name}(object: $listenerClassName {")
            lines(listenerMethods)
            line("})").line("}").line("}")
        }.toString()
    }

    //render a layout class (only those with custom LayoutParams)
    fun renderLayout(lp: LayoutParamsNode): String {
        val layoutClassName = lp.layout.fqName
        val layoutParamsClassName = lp.layoutParams.fqName
        val helperClassName = "_${lp.layout.simpleName}"

        fun renderExtensionFunction(constructor: MethodNode): String {
            val arguments = constructor.fmtLayoutParamsArguments()
            val substituded = constructor.fmtLayoutParamsArgumentsInvoke()
            val initArgumentName = "${lp.layout.simpleName.decapitalize()}Init"
            val separator = if (arguments == "") "" else ","
            return buffer(indent = 1) {
                line("public fun <T: View> T.layoutParams($arguments$separator $initArgumentName: $layoutParamsClassName.() -> Unit = defaultInit): T {")
                line("val layoutParams = $layoutParamsClassName($substituded)")
                line("layoutParams.$initArgumentName()")
                line("this@layoutParams.setLayoutParams(layoutParams)")
                line("return this")
                line("}")
            }.toString()
        }

        val layoutParamsFunc = lp.constructors.map { renderExtensionFunction(it) }
        return "public open class $helperClassName(ctx: Context): $layoutClassName(ctx) {\n" +
            layoutParamsFunc.joinToString("\n") + "\n}"
    }

    private fun supportsResourceSetter(typ: String): Boolean {
        return (
            typ.matches("^CharSequence\\??$") ||
                (typ.matches("^android.graphics.drawable.Drawable\\??$"))
        )
    }

    // Only one-argument (typically <init>(Context)) View constructors are now supported
    private fun ClassNode.hasSimpleConstructor() = getConstructors().any { it.args.size() == 1 }

}