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

package org.jetbrains.android.anko

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.jetbrains.android.anko.utils.Buffer
import org.jetbrains.android.anko.AnkoFile.*
import org.jetbrains.android.anko.ConfigurationTune.*
import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.utils.buffer
import org.objectweb.asm.Type
import java.util.*

class Renderer(private val generator: Generator) : Configurable(generator.config) {
    companion object {
        val NOTHING_TO_INLINE = "[suppress(\"NOTHING_TO_INLINE\")]"
        val ONLY_LOCAL_RETURN = "inlineOptions(InlineOption.ONLY_LOCAL_RETURN)"

        val CONSTRUCTOR1 = array(Type.getObjectType("android/content/Context"))
        val CONSTRUCTOR2 = array(Type.getObjectType("android/content/Context"), Type.getObjectType("android/util/AttributeSet"))
        val AVAILABLE_VIEW_CONSTRUCTORS = listOf(CONSTRUCTOR1, CONSTRUCTOR2)

        fun renderConstructor(
                view: ClassNode,
                constructors: List<MethodNode?>,
                ctxName: String,
                argumentNames: Boolean = false
        ): String {
            if (constructors.size() != AVAILABLE_VIEW_CONSTRUCTORS.size()) throw IllegalArgumentException("Invalid constructors list")

            return if (argumentNames) {
                when {
                    constructors[0] != null -> "$ctxName: Context"
                    constructors[1] != null -> "$ctxName: Context, attrs: AttributeSet?"
                    else -> throw IllegalArgumentException("No available constructors for ${view.fqName}.")
                }
            } else {
                when {
                    constructors[0] != null -> "$ctxName"
                    constructors[1] != null -> "$ctxName, null"
                    else -> throw IllegalArgumentException("No available constructors for ${view.fqName}.")
                }
            }
        }
    }

    val views = generate(VIEWS) {
        generateViews(generator.viewClasses) { it.fqName }
    }

    val viewGroups = generate(VIEWS) {
        generateViews(generator.viewGroupClasses) { "_" + it.simpleName + it.supportSuffix }
    }

    val helperConstructors = generate(HELPER_CONSTRUCTORS) {
        genHelperConstructors()
    }

    // Generate View extension properties (with "best" setter)
    val properties = generate(PROPERTIES) {
        generator.properties.map { property ->
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
                val foundAnnotations = config.annotationManager.findAnnotationsFor(annotationSignature)
                ExternalAnnotation.NotNull !in foundAnnotations
            } else true // Default is nullable

            val nullability = if (nullable) "?" else ""

            val otherSetters = if (property.setters.size() > 1) property.setters.drop(1) else listOf()

            buffer {
                line("public $mutability $fullPropertyName: $rawReturnType$nullability")
                if (getter != null) {
                    indent.line("get() = ${getter.method.name}()")
                } else {
                    indent.line("get() = throw AnkoException(\"'${fullPropertyName}' property does not have a getter\")")
                }
                if (bestSetter != null) indent.line("set(v) = ${bestSetter.method.name}(v)")

                renderResourceProperty(otherSetters, fullPropertyName, rawReturnType)
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
                indent.line("get() = throw AnkoException(\"'${fullPropertyName}Resource' property does not have a getter\")")
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
    [suppress("UNCHECKED_CAST")]
    private val complexListeners = generate(COMPLEX_LISTENER_CLASSES, COMPLEX_LISTENER_SETTERS) {
        generator.listeners.filter { it is ComplexListener } as List<ComplexListener>
    }

    val complexListenerSetters = generate(COMPLEX_LISTENER_SETTERS) {
        complexListeners.map { renderComplexListenerSetter(it) }
    }

    val complexListenerClasses = generate(COMPLEX_LISTENER_CLASSES) {
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
    val layouts = generate(LAYOUTS) {
        generator.layoutParams.map { renderLayout(it) }
    }

    val services = generator.services.map {
        val propertyName = it.second!!.data.simpleName.decapitalize()
        val className = it.second!!.data.fqName
        "public val Context.$propertyName: $className\n"+
                "${config.indent}get() = getSystemService(Context.${it.first}) as $className\n"
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

    fun generateViews(
            views: List<ClassNode>,
            nameResolver: (ClassNode) -> String
    ): List<String> {
        return views.filter { !it.isAbstract }.map { view ->
            val typeName = view.fqName
            val className = nameResolver(view)
            val funcName = view.simpleName.decapitalize() + view.supportSuffix

            val constructors = AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
                view.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
            }

            buffer {
                fun Buffer.add(extendFor: String) {
                    line(NOTHING_TO_INLINE)
                    line("public inline fun $extendFor.$funcName(): $typeName = $funcName({})")
                    line("public inline fun $extendFor.$funcName($ONLY_LOCAL_RETURN init: $className.() -> Unit): $typeName = addView {")
                        line("ctx ->")
                        line("val view = $className(${renderConstructor(view, constructors, "ctx")})")
                        line("view.init()")
                        line("view")
                    line("}")
                }

                add("ViewManager")
                if (config[TOP_LEVEL_DSL_ITEMS] && view.isViewGroup(generator.classTree)) {
                    nl().add("Context")
                    nl().add("Activity")
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
            line("public fun $className.${listener.method.name}(l: ($argumentTypes) -> $returnType): Unit = ${listener.setter.method.name}(l)")
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
                    line("public inline fun $extendFor.$funcName($helperArguments): $className = addView {")
                        line("ctx ->")
                        line("val view = $className(ctx)")
                        lines(setters)
                        line("view")
                    line("}")

                    line("public inline fun $extendFor.$funcName($helperArguments, $ONLY_LOCAL_RETURN init: $className.() -> Unit): $className = addView {")
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
        val helperClassName = getHelperClassName(listener)
        val setterClass = listener.setter.clazz.fqNameWithTypeArguments

        return buffer {
            line("public fun $setterClass.${listener.name}Listener(init: $helperClassName.() -> Unit) {")
            line("val listener = $helperClassName()")
            line("listener.init()")
            line("${listener.setter.method.name}(listener)")
            line("}")
        }.toString()
    }

    //render a complex listener
    private fun renderComplexListenerClass(listener: ComplexListener): String {
        val listenerClassName = listener.clazz.fqName
        //ListenerHelper class name (helper mutable class, generates real listener)
        val helperClassName = getHelperClassName(listener)

        //field list (already with indentation)
        val fields = listener.methods.map { method ->
            val varName = method.name.decapitalize()
            val lambdaType = "((${method.argumentTypes}) -> ${method.returnType})"
            "private var _$varName: $lambdaType? = null"
        }

        val listenerMethods = listener.methods.flatMap { method ->
            val varName = method.name.decapitalize()
            val customArgumentsKey = "$listenerClassName#${method.name}"
            val customArguments = Props.customMethodParameters.get(customArgumentsKey)
            val arguments = customArguments ?: method.methodWithClass.formatArguments(config)
            val substitution = method.methodWithClass.formatArgumentsNames(config)
            buffer {
                val defaultValue = method.methodWithClass.method.returnType.getDefaultValue()
                val returnDefaultValue = if (defaultValue.isNotEmpty()) " ?: $defaultValue" else ""

                line("override fun ${method.name}($arguments) = _$varName?.invoke($substitution)$returnDefaultValue").nl()
                line("public fun ${method.name}(listener: (${method.argumentTypes}) -> ${method.returnType}) {")
                line("_$varName = listener")
                line("}").nl()
            }.getLines()
        }

        return buffer {
            line("class $helperClassName : $listenerClassName {")
            lines(fields).nl()
            lines(listenerMethods)
            line("}")
        }.toString()
    }

    //render a layout class (only those with custom LayoutParams)
    fun renderLayout(lp: LayoutParamsNode): String {
        val layoutClassName = lp.layout.fqName
        val layoutParamsClassName = lp.layoutParams.fqName
        val helperClassName = "_${lp.layout.simpleName}${lp.layout.supportSuffix}"

        fun renderExtensionFunction(constructor: MethodNodeWithClass): String {
            val arguments = constructor.formatLayoutParamsArguments(config)
            val substituted = constructor.formatLayoutParamsArgumentsInvoke(config)
            val initArgumentName = "${lp.layout.simpleName.decapitalize()}Init"
            val separator = if (arguments == "") "" else ","
            return buffer(indent = 1) {
                line("public fun <T: View> T.layoutParams($arguments$separator $initArgumentName: $layoutParamsClassName.() -> Unit = defaultInit): T {")
                line("val layoutParams = $layoutParamsClassName($substituted)")
                line("layoutParams.$initArgumentName()")
                line("this@layoutParams.setLayoutParams(layoutParams)")
                line("return this")
                line("}")
            }.toString()
        }

        val layoutParamsFunc = lp.constructors.map { renderExtensionFunction(MethodNodeWithClass(lp.layoutParams, it)) }
        val constructors = AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
            lp.layout.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
        }

        val constructorArguments = renderConstructor(lp.layout, constructors, "ctx", argumentNames = true)
        val constructor = renderConstructor(lp.layout, constructors, "ctx")
        return "public open class $helperClassName($constructorArguments): $layoutClassName($constructor) {\n" +
            layoutParamsFunc.joinToString("\n") + "\n}\n"
    }

    private fun supportsResourceSetter(typ: String): Boolean {
        return (
            typ.matches("^CharSequence\\??$") ||
                (typ.matches("^android.graphics.drawable.Drawable\\??$"))
        )
    }

    private val ClassNode.fromSupportV7: Boolean
        get() = fqName.startsWith("android.support.v7")

    private val ClassNode.supportSuffix: String
        get() = if (fromSupportV7) "Support" else ""

}