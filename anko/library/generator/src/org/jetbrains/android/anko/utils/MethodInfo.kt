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

package org.jetbrains.android.anko

import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.config.AnkoBuilderContext
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.utils.*
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodNode

private val specialLayoutParamsArguments = mapOf(
        "width" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "height" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "w" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "h" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT"
)

private val specialLayoutParamsNames = mapOf(
        "w" to "width", "h" to "height"
)

internal val MethodNode.args: Array<Type>
    get() = Type.getArgumentTypes(desc)

internal fun buildKotlinSignature(node: MethodNode): List<String> {
    if (node.signature == null) return emptyList()

    val parsed = parseGenericMethodSignature(node.signature)
    return parsed.valueParameters.map { genericTypeToStr(it.genericType) }
}

internal fun MethodNodeWithClass.processArguments(
        context: AnkoBuilderContext,
        template: (argName: String, argType: String, explicitNotNull: String) -> String
): String {
    if (method.args.isEmpty()) return ""

    val locals = method.localVariables?.map { it.index to it }?.toMap() ?: hashMapOf()
    val buffer = StringBuffer()
    var argNum = 0
    var nameIndex = if (method.isStatic) 0 else 1
    val genericArgs = buildKotlinSignature(method)

    val javaArgs = method.args.map(Type::asJavaString)
    val argNames = context.sourceManager.getArgumentNames(clazz.fqName, method.name, javaArgs)
    val javaArgsString = javaArgs.joinToString()

    for ((index, arg) in method.args.withIndex()) {
        val rawArgType = arg.asString(false)

        val annotationSignature = "${clazz.fqName} ${method.returnType.asJavaString()} ${method.name}($javaArgsString) $index"
        val nullable = !arg.isSimpleType &&
                ExternalAnnotation.NotNull !in context.annotationManager.findExternalAnnotations(annotationSignature)
        val argType = if (nullable) rawArgType + "?" else rawArgType

        val explicitNotNull = if (argType.endsWith("?")) "!!" else ""
        val argName = argNames?.get(index) ?: locals[nameIndex]?.name ?: "p$argNum"
        if (argType.isNotEmpty()) {
            buffer.append(template(argName,
                    if (method.signature != null) genericArgs[argNum] else argType, explicitNotNull))
        }
        argNum++
        nameIndex += arg.size
    }

    if ( buffer.length >= 2) buffer.delete(buffer.length - 2, buffer.length)
    return buffer.toString()
}

internal fun MethodNodeWithClass.formatArguments(context: AnkoBuilderContext): String {
    return processArguments(context) { name, type, nul -> "$name: $type, " }
}

internal fun MethodNodeWithClass.formatLayoutParamsArguments(context: AnkoBuilderContext): List<String> {
    val args = arrayListOf<String>()
    processArguments(context) { name, type, nul ->
        val defaultValue = specialLayoutParamsArguments[name]
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        val arg = if (defaultValue == null)
            "$realName: $type"
        else
            "$realName: $type = $defaultValue"
        args += arg
        arg
    }
    return args
}

internal fun MethodNodeWithClass.formatLayoutParamsArgumentsInvoke(context: AnkoBuilderContext): String {
    return processArguments(context) { name, type, nul ->
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        "$realName$nul, "
    }
}

internal fun MethodNodeWithClass.formatArgumentsTypes(context: AnkoBuilderContext): String {
    return processArguments(context) { name, type, nul -> "$type, " }
}

internal fun MethodNodeWithClass.formatArgumentsNames(context: AnkoBuilderContext): String {
    return processArguments(context) { name, type, nul -> "$name, " }
}


fun MethodNode.isGetter(): Boolean {
    val isNonBooleanGetter = name.startsWith("get") && name.length > 3 && Character.isUpperCase(name[3])
    val isBooleanGetter = name.startsWith("is") && name.length > 2 && Character.isUpperCase(name[2])

    return (isNonBooleanGetter || isBooleanGetter) && args.isEmpty() && !returnType.isVoid && isPublic
}

internal fun MethodNode.isNonListenerSetter(): Boolean {
    val isSetter = name.startsWith("set") && name.length > 3 && Character.isUpperCase(name[3])
    return isSetter && !(isListenerSetter() || name.endsWith("Listener")) && args.size == 1 && isPublic
}

internal val MethodNode.isConstructor: Boolean
    get() = name == "<init>"

internal fun MethodNode.isListenerSetter(set: Boolean = true, add: Boolean = true): Boolean {
    return ((set && name.startsWith("setOn")) || (add && name.startsWith("add"))) && name.endsWith("Listener")
}

internal val MethodNode.isPublic: Boolean
    get() = (access and Opcodes.ACC_PUBLIC) != 0

internal val MethodNode.isOverridden: Boolean
    get() = (access and Opcodes.ACC_BRIDGE) != 0

internal val MethodNode.isStatic: Boolean
    get() = (access and Opcodes.ACC_STATIC) != 0

internal val MethodNode.returnType: Type
    get() = Type.getReturnType(desc)

internal fun MethodNode.renderReturnType(nullable: Boolean = true): String {
    return if (signature != null) {
        genericTypeToStr(parseGenericMethodSignature(signature).returnType, nullable)
    } else {
        returnType.asString(nullable)
    }
}