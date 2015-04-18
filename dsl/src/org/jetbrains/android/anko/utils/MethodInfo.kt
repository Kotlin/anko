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

fun MethodNode.processArguments(template: (argName: String, argType: String, explicitNotNull: String) -> String): String {
    if (args.isEmpty()) return ""

    val locals = localVariables?.map { it.index to it }?.toMap() ?: hashMapOf()
    val buffer = StringBuffer()
    var argNum = 0
    var nameIndex = if (isStatic) 0 else 1
    val genericArgs = buildKotlinSignature(this)

    for (arg in args) {
        val argType = arg.asString()
        val explicitNotNull = if (argType.endsWith("?")) "!!" else ""
        val local = locals[nameIndex]
        val argName = local?.name ?: "p$argNum"
        if (argType.isNotEmpty()) {
            buffer.append(template(argName, if (signature != null) genericArgs[argNum] else argType, explicitNotNull))
        }
        argNum++
        nameIndex += arg.getSize()
    }

    if ( buffer.length() >= 2) buffer.delete(buffer.length() - 2, buffer.length())
    return buffer.toString()
}

fun MethodNode.fmtArguments(): String {
    return processArguments { name, _type, nul -> "$name: $_type, " }
}

fun MethodNode.fmtLayoutParamsArguments(): String {
    return processArguments { name, _type, nul ->
        val defaultValue = specialLayoutParamsArguments.get(name)
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        if (defaultValue == null)
            "$realName: $_type, "
        else
            "$realName: $_type = $defaultValue, "
    }
}

fun MethodNode.fmtLayoutParamsArgumentsInvoke(): String {
    return processArguments { name, _type, nul ->
        val realName = specialLayoutParamsNames.getOrElse(name, {name})
        "$realName$nul, "
    }
}

fun MethodNode.fmtArgumentsTypes(): String {
    return processArguments { name, _type, nul -> "$_type, " }
}

fun MethodNode.fmtArgumentsNames(): String {
    return processArguments { name, _type, nul -> "$name, " }
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

fun MethodNode.renderReturnType(): String {
    return if (signature != null) {
        genericTypeToStr(parseGenericMethodSignature(signature).returnType)
    } else {
        returnType.asString()
    }
}