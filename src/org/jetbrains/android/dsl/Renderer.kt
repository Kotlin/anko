/*
 * Copyright 2014 JetBrains s.r.o.
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

class Renderer(private val generator: Generator) {

  val props = generator.props

  private fun buffer(init: Buffer.() -> Unit) = Buffer(props.indent, 0, init)
  private fun buffer(indent: Int, init: Buffer.() -> Unit) = Buffer(props.indent, indent, init)

  /*generate functions for making views. example:
    public fun ViewManager.textView(init: TextView.() -> Unit): TextView =
      addView(TextView(dslContext), init, this)
  */
  val views = if (!props.generateViewExtensionMethods) listOf() else
    generateViews(generator.viewClasses) { cleanInternalName(it) }

  /*generate functions for making view groups (containers). example:
    public fun ViewManager.linearLayout(init: _LinearLayout.() -> Unit): LinearLayout
      = addView(_LinearLayout(dslContext), init, this)
  */
  val viewGroups = if (!props.generateViewGroupExtensionMethods) listOf() else
    generateViews(generator.viewGroupClasses) { "_" + stripClassName(cleanInternalName(it)) }

  //helper constructors for views
  val helperConstructors =
    if (!props.generateViewHelperConstructors) listOf<String>() else genHelperConstructors()

  /*generate properties for views. example:
    var android.widget.TextView.text: CharSequence?
      get() = getText()
      set(v) = setText(v)
   */
  val properties = if (!props.generateProperties) listOf() else
    generator.properies.map {
      val getter = it.getter
      val className = cleanInternalName(getter.clazz.name!!)
      val propertyName = it.name
      val fullPropertyName = "$className.$propertyName"
      val bestSetter = it.setters.head
      val mutability = if (bestSetter != null) "var" else "val"
      val returnType = getter.method.renderReturnType()
      val otherSetters = if (it.setters.size>1) it.setters.tail else listOf()

      buffer {
        line("public $mutability $fullPropertyName: $returnType")
        indent.line("get() = ${getter.method.name!!}()")
        if (bestSetter != null) {
          val arg = if (returnType.endsWith("?")) "v!!" else "v"
          indent.line("set(v) = ${bestSetter.method.name}($arg)")
        }

        if (otherSetters.notEmpty && supportsResourceSetter(returnType)) {
          val resourceSetter = otherSetters.firstOrNull {
            (it.method.arguments?.size ?: 0) == 1 &&
              (it.method.arguments?.get(0)?.getClassName() == "int")
          }
          if (resourceSetter != null) {
            line("public var ${fullPropertyName}Resource: Int")
            indent.line("get() = throw KoanException(\"'${fullPropertyName}Resource' property doesn't have a getter\")")
            indent.line("set(v) = ${resourceSetter.method.name}(v)")
          }
        }
      }.toString()
    }

  //render listeners
  /*simple listener (interface with one method) contains only an extension method, like this:
      fun android.view.View.onClick(l: (android.view.View?) -> Unit) = setOnClickListener(l)
    complex listener (with bunch of methods) contains helper class and an extension method fot each listener method.
   */
  val simpleListeners = if (!props.generateSimpleListeners) listOf() else
    generator.listeners.filter { it is SimpleListener }.map { renderSimpleListener(it as SimpleListener) }

  private val complexListeners =
    if (!props.generateComplexListenerClasses && !props.generateComplexListenerSetters)
      listOf()
    else generator.listeners.filter { it is ComplexListener }

  //setters for complex listeners
  val listenerSetters = if (!props.generateComplexListenerSetters) listOf() else
    complexListeners.map { renderComplexListenerSetters(it as ComplexListener) }

  val listenerHelperClasses = if (!props.generateComplexListenerClasses) listOf() else
    complexListeners.map { renderComplexListenerClass(it as ComplexListener) }

  //generated layout classes with custom LayoutParams
  val layouts = if (!props.generateLayoutParamsHelperClasses) listOf() else
    generator.layouts.map { renderLayout(it) }

  val services = generator.services.map {
    val propertyName = it.second!!.data.cleanNameDecap()
    val className = it.second!!.data.cleanInternalName()
    "public val Context.$propertyName: $className\n"+
        "${props.indent}get() = getSystemService(Context.${it.first}) as $className"
  }

  private fun generateViews(
      views: List<ClassNode>,
      nameResolver: (String) -> String): List<String>
  {
    return views.filter { !it.isAbstract() && it.hasSimpleConstructor() }.map { clazz ->
      val typeName = cleanInternalName(clazz.name!!)
      val className = nameResolver(clazz.name!!)
      val funcName = decapitalize(stripClassName(cleanInternalName(clazz.name!!)))

      buffer {
        line("public fun ViewManager.$funcName(init: $className.() -> Unit = defaultInit): $typeName =")
        line("addView($className(dslContext), init, this)")
        if (props.generateTopLevelExtensionMethods) {
          fun add(extendFor: String, ctx: String) {
            line("public fun $extendFor.$funcName(init: $className.() -> Unit = defaultInit): $typeName =")
            line("add${extendFor}TopLevelView($className($ctx), init)")
          }
          add("Fragment", "getActivity()!!")
          add("Context", "this")
        }
      }.toString()
    }
  }

  //render a simple listener (extension function)
  //example: fun android.view.View.onClick(l: (android.view.View?) -> Unit) = setOnClickListener(l)
  private fun renderSimpleListener(listener: SimpleListener): String {
    val obj = listener.setter.clazz.cleanInternalName()
    val argumentTypes = listener.method.argumentTypes
    val returnType = listener.method.returnType

    return buffer {
      line("public fun $obj.${listener.method.name}(l: ($argumentTypes) -> $returnType): Unit =")
      line("${listener.setter.method.name}(l)")
    }.toString()
  }

  fun genHelperConstructors(): List<String> {
    fun addMethods(node: ClassTreeNode, writeTo: ArrayList<MethodNode>): ArrayList<MethodNode> {
      writeTo.addAll(node.data.methods!!)
      if (node.parent != null)
        addMethods(node.parent!!, writeTo)
      return writeTo
    }

    fun resolveAllMethods(clazz: ClassNode): List<MethodNode> {
      return addMethods(generator.classTree.findNode(clazz)!!, ArrayList<MethodNode>())
    }

    fun collectProperties(clazz: ClassNode, needed: List<Variable>): List<MethodNode> {
      val ret = arrayListOf<MethodNode>()
      needed.forEach { neededProp ->
        val propList = resolveAllMethods(clazz)
        val found = propList.firstOrNull {
          it.name.equals("set${neededProp.name.capitalize()}") && it.arguments?.size == 1 &&
            cleanInternalName(it.arguments?.get(0)?.getClassName() ?: "").endsWith(neededProp.typ)
        }
        if (found == null)
          throw RuntimeException("Property $neededProp for helper constructor ${clazz.cleanInternalName()}.<init>$needed not found.")
        ret.add(found)
      }
      return ret
    }

    val ret = arrayListOf<String>()
    generator.viewClasses.filter { props.helperConstructors.contains(it.cleanInternalName()) }.forEach { view ->
      val viewClassName = view.cleanInternalName()
      val helperConstructors = props.helperConstructors.get(view.cleanInternalName())!!

      for (constructor in helperConstructors) {
        val functionName = view.cleanName().decapitalize()
        val collected = constructor.zip(collectProperties(view, constructor))
        val helperArguments = collected.map {
          val argumentType = it.second.arguments!![0].toStr()
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
    val basename = stripClassName(listener.clazz.name!!).replace("$", "_")
    val setterClassName = listener.setter.clazz.cleanName()
    val setterName = setterClassName.replace(".", "_") + "_" + listener.setter.method.name!!
    return "__" + setterName + "_" + basename.substring(basename.lastIndexOf("/") + 1)
  }

  private fun renderComplexListenerSetters(listener: ComplexListener): String {
    //ListenerHelper class name (helper mutable class, generates real listener)
    val helperClassName = getHelperClassName(listener)
    val setterClass = listener.setter.clazz.cleanInternalName()
    //key for storing ListenerHelper (local to this setter)
    val hashKey = "${setterClass}_${listener.setter.method.name}"

    fun renderExtensionMethods() = listener.methods.map { method ->
      val varName = method.name.decapitalize()
      val argumentType = "(${method.argumentTypes}) -> ${method.returnType}"
      
      buffer {
        line("public fun $setterClass.${decapitalize(method.name)}(act: $argumentType) {")
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
    val listenerClassName = listener.clazz.cleanInternalName()
    //ListenerHelper class name (helper mutable class, generates real listener)
    val helperClassName = getHelperClassName(listener)
    val setterClass = listener.setter.clazz.cleanInternalName()

    //field list (already with indentation)
    val fields = listener.methods.map { method ->
      val varName = method.name.decapitalize()
      val argumentNames = method.method.fmtArgumentsNames()
      val lambdaType = "((${method.argumentTypes}) -> ${method.returnType})"
      val returnValue = method.method.getReturnType().getDefaultValue()
      val initializer = "{ $argumentNames -> $returnValue }"
      val simplifiedInitializer = if (initializer == "{  ->  }") "{}" else initializer
      "var _$varName: $lambdaType = $simplifiedInitializer "
    }
    //listener methods (for produced anonymous class, already with indentation)
    val listenerMethods = listener.methods.map { method ->
      val varName = method.name.decapitalize()
      val customArgumentsKey = "$listenerClassName#${method.name}"
      val customArguments = props.customMethodParameters.get(customArgumentsKey)
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
    val layoutClassName = lp.layout.cleanInternalName()
    val layoutParamsClassName = lp.layoutParams.cleanInternalName()
    val helperClassName = "_${lp.layout.cleanName()}"

    fun renderExtensionFunction(constructor: MethodNode): String {
      val arguments = constructor.fmtLayoutParamsArguments()
      val substituded = constructor.fmtLayoutParamsArgumentsInvoke()
      val initArgumentName = "${decapitalize(lp.layout.cleanName())}Init"
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
    return "public class $helperClassName(ctx: Context): $layoutClassName(ctx) {\n" +
      layoutParamsFunc.joinToString("\n") + "\n}"
  }

  private fun supportsResourceSetter(typ: String): Boolean {
    return (
      typ.matches("^CharSequence\\??$")
      || (typ.matches("^android.graphics.drawable.Drawable\\??$"))
    )
  }

  //only <init>(Context) View constructors now supported
  private fun ClassNode.hasSimpleConstructor() = getConstructors().any { it.arguments?.size == 1 }

}