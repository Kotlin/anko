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

import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.objectweb.asm.*
import org.objectweb.asm.tree.MethodNode
import java.util.ArrayList
import org.objectweb.asm.tree.LocalVariableNode
import java.util.HashMap

private val specialLayoutParamsArguments = mapOf(
        "width" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "height" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "w" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT",
        "h" to "android.view.ViewGroup.LayoutParams.WRAP_CONTENT"
)

private val specialLayoutParamsNames = mapOf(
        "w" to "width", "h" to "height"
)

val MethodNode.args: Array<Type>
    get() = Type.getArgumentTypes(desc)

fun buildKotlinSignature(node: MethodNode): List<String> {
    if (node.signature == null) return listOf()

    val parsed = parseGenericMethodSignature(node.signature)
    return parsed.valueParameters.map { genericTypeToStr(it.genericType) }
}

fun MethodNodeWithClass.processArguments(
        config: AnkoConfiguration,
        template: (argName: String, argType: String, explicitNotNull: String) -> String
): String {
    if (method.args.isEmpty()) return ""

    val locals = method.localVariables?.map { it.index to it }?.toMap() ?: hashMapOf()
    val buffer = StringBuffer()
    var argNum = 0
    var nameIndex = if (method.isStatic) 0 else 1
    val genericArgs = buildKotlinSignature(method)

    val javaArgs = method.args.map { it.asJavaString() }
    val argNames = config.sourceManager.getArgumentNames(clazz.fqName, method.name, javaArgs)
    val javaArgsString = javaArgs.joinToString()

    for ((index, arg) in method.args.withIndex()) {
        val rawArgType = arg.asString(false)

        val annotationSignature = "${clazz.fqName} ${method.returnType.asJavaString()} ${method.name}($javaArgsString) $index"
        val nullable = !arg.isSimpleType &&
                ExternalAnnotation.NotNull !in config.annotationManager.findAnnotationsFor(annotationSignature)
        val argType = if (nullable) rawArgType + "?" else rawArgType

        val explicitNotNull = if (argType.endsWith("?")) "!!" else ""
        val argName = argNames?.get(index) ?: locals[nameIndex]?.name ?: "p$argNum"
        if (argType.isNotEmpty()) {
            buffer.append(template(argName,
                    if (method.signature != null) genericArgs[argNum] else argType, explicitNotNull))
        }
        argNum++
        nameIndex += arg.getSize()
    }

    if ( buffer.length() >= 2) buffer.delete(buffer.length() - 2, buffer.length())
    return buffer.toString()
}

fun MethodNodeWithClass.formatArguments(config: AnkoConfiguration): String {
    return processArguments(config) { name, type, nul -> "$name: $type, " }
}

fun MethodNodeWithClass.formatLayoutParamsArguments(config: AnkoConfiguration): String {
    return processArguments(config) { name, type, nul ->
        val defaultValue = specialLayoutParamsArguments.get(name)
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        if (defaultValue == null)
            "$realName: $type, "
        else
            "$realName: $type = $defaultValue, "
    }
}

fun MethodNodeWithClass.formatLayoutParamsArgumentsInvoke(config: AnkoConfiguration): String {
    return processArguments(config) { name, type, nul ->
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        "$realName$nul, "
    }
}

fun MethodNodeWithClass.formatArgumentsTypes(config: AnkoConfiguration): String {
    return processArguments(config) { name, type, nul -> "$type, " }
}

fun MethodNodeWithClass.formatArgumentsNames(config: AnkoConfiguration): String {
    return processArguments(config) { name, type, nul -> "$name, " }
}


fun MethodNode.isGetter(): Boolean {
    val isNonBooleanGetter = name.startsWith("get") && name.length() > 3 && Character.isUpperCase(name.charAt(3))
    val isBooleanGetter = name.startsWith("is") && name.length() > 2 && Character.isUpperCase(name.charAt(2))

    return (isNonBooleanGetter || isBooleanGetter) && args.isEmpty() && !returnType.isVoid && isPublic
}

fun MethodNode.isNonListenerSetter(): Boolean {
    val isSetter = name.startsWith("set") && name.length() > 3 && Character.isUpperCase(name.charAt(3))
    return isSetter && !(isListenerSetter || name.endsWith("Listener")) && args.size() == 1 && isPublic
}

val MethodNode.isConstructor: Boolean
    get() = name == "<init>"

val MethodNode.isDeprecated: Boolean
    get() = (access and Opcodes.ACC_DEPRECATED) != 0

val MethodNode.isListenerSetter: Boolean
    get() = (name.startsWith("setOn") || name.startsWith("add")) && name.endsWith("Listener")

val MethodNode.isPublic: Boolean
    get() = (access and Opcodes.ACC_PUBLIC) != 0

val MethodNode.isOverridden: Boolean
    get() = (access and Opcodes.ACC_BRIDGE) != 0

val MethodNode.isStatic: Boolean
    get() = (access and Opcodes.ACC_STATIC) != 0

val MethodNode.returnType: Type
    get() = Type.getReturnType(desc)

fun MethodNode.renderReturnType(nullable: Boolean = true): String {
    return if (signature != null) {
        genericTypeToStr(parseGenericMethodSignature(signature).returnType, nullable)
    } else {
        returnType.asString(nullable)
    }
}
