package com.jetbrains.android.dsl

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodNode
import java.util.TreeMap
import java.util.ArrayList

class Renderer(private val generator: Generator) {

	//indents
	private val I = generator.props.indent
	private val I2 = I.repeat(2)
	private val I3 = I.repeat(3)

	val props = generator.props

	//generate functions for making views
	//example: fun ViewManager.textView(init: TextView.() -> Unit) = addView(TextView(dslContext), init, this)
	val views = if (!props.generateViewExtensionMethods) listOf() else
		generator.viewClasses.filter { !it.isAbstract() && it.hasSimpleConstructor() }.map { clazz ->
			val className = cleanInternalName(clazz.name!!)
			val funcName = decapitalize(stripClassName(cleanInternalName(clazz.name!!)))
			"fun ViewManager.$funcName(init: $className.() -> Unit = {}) =\n"+
				"${I}addView($className(dslContext), init, this)\n"
		}

	//generate functions for making view groups (containers)
	//example: fun ViewManager.linearLayout(init: _LinearLayout.() -> Unit) = addView(_LinearLayout(dslContext), init, this)
	//_LinearLayout is a child of LinearLayout class with helper layoutParams() methods
	val viewGroups = if (!props.generateViewGroupExtensionMethods) listOf() else
		generator.viewGroupClasses.filter { !it.isAbstract() }.map { clazz ->
			val originalClassName = cleanInternalName(clazz.name!!)
			val className = stripClassName(cleanInternalName(clazz.name!!))
			val funcName = decapitalize(stripClassName(cleanInternalName(clazz.name!!)))
			"fun ViewManager.$funcName(init: _$className.() -> Unit = {}) =\n"+
				"${I}addView(_$className(dslContext), init, this): $originalClassName\n"
		}

	//helper constructors for views
	val helperConstructors = if (!props.generateViewHelperConstructors) listOf<String>() else genHelperConstructors()

	//generate properties for views
	/* example:
		var android.widget.TextView.text: CharSequence?
			get() = getText()
			set(v) = setText(v)
	 */
	//TODO: parse otherSetters (make additional props without a getter)
	val properties = if (!props.generateProperties) listOf() else
		generator.properies.map {
			val getter = it.getter
			val className = cleanInternalName(getter.clazz.name!!)
			val bestSetter = it.setters.head
			val propType = if (bestSetter!=null) "var" else "val"
			val returnType = getter.method.renderReturnType()
			//val otherSetters = if (it.setters.size>1) it.setters.tail else listOf()
			"$propType $className.${it.name}: $returnType\n"+
				"${I}get() = ${getter.method.name!!}()"+
				(if (bestSetter!=null) {
					val arg = if (returnType.endsWith("?")) "v!!" else "v"
					"\n${I}set(v) = ${bestSetter.method.name}($arg)"
				} else "")+"\n"
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

	//render a simple listener (extension function)
	//example: fun android.view.View.onClick(l: (android.view.View?) -> Unit) = setOnClickListener(l)
	private fun renderSimpleListener(listener: SimpleListener): String {
		val obj = listener.setter.clazz.cleanInternalName()
		val argumentTypes = listener.method.argumentTypes
		val returnType = listener.method.returnType
		return "fun $obj.${listener.method.name}(l: ($argumentTypes) -> $returnType) = ${listener.setter.method.name}(l)"
	}

	fun genHelperConstructors(): List<String> {
		fun resolveAllMethods(clazz: ClassNode): List<MethodNode> {
			fun addMethods(node: ClassTreeNode, writeTo: ArrayList<MethodNode>): ArrayList<MethodNode> {
				writeTo.addAll(node.data.methods!!)
				if (node.parent!=null)
					addMethods(node.parent!!, writeTo)
				return writeTo
			}
			return addMethods(generator.classTree.findNode(clazz)!!, ArrayList<MethodNode>())
		}

		fun collectProperties(clazz: ClassNode, needed: List<String>): List<MethodNode> {
			val ret = arrayListOf<MethodNode>()
			needed.forEach { neededProp ->
				val propList = resolveAllMethods(clazz)
				val found = propList.firstOrNull {
					it.name.equals("set${neededProp.capitalize()}") && it.arguments?.size==1
				}
				if (found==null)
					throw RuntimeException("Property $neededProp for helper constructor ${clazz.cleanInternalName()}.<init>$needed not found.")
				ret.add(found)
			}
			return ret
		}

		val ret = arrayListOf<String>()
		generator.viewClasses.filter { props.helperConstructors.contains(it.cleanInternalName()) }.forEach { view ->
			val helperConstructors = props.helperConstructors.get(view.cleanInternalName())!!

			val viewClassName = view.cleanInternalName()
			helperConstructors.forEach {
				val functionName = view.cleanName().decapitalize()
				val collected = it.zip(collectProperties(view, it))
				val arguments = collected.map {
					val argumentType = it.second.arguments!![0].toStr()
					"${it.first}: $argumentType"
				}.joinToString(", ")
				val setters = collected.map { "${I}v.${it.second.name}(${it.first})" }
				ret.add("fun ViewManager.$functionName($arguments, init: $viewClassName.() -> Unit = {}): $viewClassName {\n"+
					"${I}val v = $viewClassName(dslContext)\n"+
					setters.joinToString("\n")+"\n"+
					"${I}return addView(v, init, this)\n"+
					"}")
			}
		}
		return ret
	}

	//get a name for helper class. Listener interfaces are often inner so we'll separate the base class name with "_"
	//For example, for class android.widget.SearchView.OnSuggestionListener it would be SearchView_OnSuggessionListener
	fun getHelperClassName(listener: ComplexListener): String {
		val basename = stripClassName(listener.clazz.name!!).replace("$", "_")
		val setterClassName = listener.setter.clazz.cleanName()
		val setterName = setterClassName.replace(".", "_")+"_"+listener.setter.method.name!!
		return "__"+setterName+"_"+basename.substring(basename.lastIndexOf("/")+1)
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
			"fun $setterClass.${decapitalize(method.name)}(act: $argumentType) {\n"+
				"${I}val props = getTag() as? ViewProps\n"+
				"${I}if (props!=null) {\n"+
				"${I2}var l: $helperClassName? =\n"+
				"${I3}props.listeners.get(\"$hashKey\") as? $helperClassName\n"+
				"${I2}if (l==null) {\n"+
				"${I3}l = $helperClassName(this)\n"+
				"${I3}props.listeners.put(\"$hashKey\", l!!)\n"+
				"${I2}}\n"+
				"${I2}l!!._$varName = act\n"+
				"${I}}\n}"
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
			val simplifiedInitializer = if (initializer=="{ -> }") "{}" else initializer
			"${I}var _$varName: $lambdaType = $simplifiedInitializer\n"
		}
		//listener methods (for produced anonymous class, already with indentation)
		val listenerMethods = listener.methods.map { method ->
			val varName = method.name.decapitalize()
			val customArgumentsKey = "$listenerClassName#${method.name}"
			val customArguments = props.customMethodParameters.get(customArgumentsKey)
			val arguments = customArguments ?: method.method.fmtArguments()
			val substitution = method.method.fmtArgumentsNames()
			"${I3}override fun ${method.name}($arguments) = _$varName($substitution)\n"
		}

		return "class $helperClassName(val v: $setterClass): ListenerHelper {\n"+
			fields.joinToString("")+"\n"+
			"${I}override fun apply() {\n" +
			"${I2}v.${listener.setter.method.name}(object: $listenerClassName {\n" +
			listenerMethods.joinToString("") +
			"$I2})\n$I}\n}"
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
			return "${I}fun <T: View> T.layoutParams($arguments$separator $initArgumentName: $layoutParamsClassName.() -> Unit = {}): T {\n"+
				"${I2}val layoutParams = $layoutParamsClassName($substituded)\n"+
				"${I2}layoutParams.$initArgumentName()\n" +
				"${I2}this@layoutParams.setLayoutParams(layoutParams)\n"+
				"${I}}"
		}

		val layoutParamsFunc = lp.constructors.map { renderExtensionFunction(it) }
		return "class $helperClassName(ctx: Context): $layoutClassName(ctx) {\n"+
			layoutParamsFunc.joinToString("\n")+
			"\n}"
	}

	//only <init>(Context) View constructors now supported
	private fun ClassNode.hasSimpleConstructor() = getConstructors().any { it.arguments?.size==1 }

	//for testing purposes
	override fun toString(): String {
		val builder = StringBuilder()
		with(builder) {
			views.forEach { append("$it\n") }
			viewGroups.forEach { append("$it\n") }
			properties.forEach { append("$it\n") }
			simpleListeners.forEach { append("$it\n") }
			listenerSetters.forEach { append("$it\n") }
			listenerHelperClasses.forEach { append("$it\n") }
		}
		return builder.toString()
	}

}