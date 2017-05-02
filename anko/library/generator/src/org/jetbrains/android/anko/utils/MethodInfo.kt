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

import org.jetbrains.android.anko.annotations.ExternalAnnotation.*
import org.jetbrains.android.anko.config.GeneratorContext
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

internal val MethodNode.parameterRawTypes: Array<Type>
    get() = Type.getArgumentTypes(desc)

internal fun getParameterKTypes(node: MethodNode): List<KType> {
    if (node.signature == null) {
        return node.parameterRawTypes.map { KType(it.asString(false), isNullable = false) }
    }

    val parsed = parseGenericMethodSignature(node.signature)
    return parsed.valueParameters.map { genericTypeToKType(it.genericType) }
}

internal fun MethodNodeWithClass.toKMethod(context: GeneratorContext): KMethod {
    val parameterTypes = getParameterKTypes(this.method)
    val localVariables = method.localVariables?.map { it.index to it }?.toMap() ?: emptyMap()

    val parameterRawTypes = this.method.parameterRawTypes
    val javaArgs = parameterRawTypes.map(Type::asJavaString)
    val parameterNames = context.sourceManager.getParameterNames(clazz.fqName, method.name, javaArgs)
    val javaArgsString = javaArgs.joinToString()
    val methodAnnotationSignature = "${clazz.fqName} ${method.returnType.asJavaString()} ${method.name}($javaArgsString)"

    var nameIndex = if (method.isStatic) 0 else 1
    val parameters = parameterTypes.mapIndexed { index, type ->
        val parameterAnnotationSignature = "$methodAnnotationSignature $index"
        val isSimpleType = parameterRawTypes[index].isSimpleType
        val isNullable = !isSimpleType && !context.annotationManager.hasAnnotation(parameterAnnotationSignature, NotNull)

        val parameterName = parameterNames?.get(index) ?: localVariables[nameIndex]?.name ?: "p$index"
        nameIndex += parameterRawTypes[index].size
        KVariable(parameterName, type.copy(isNullable = isNullable))
    }

    return KMethod(method.name, parameters, method.returnType.toKType())
}

internal fun MethodNodeWithClass.formatArguments(context: GeneratorContext): String {
    return toKMethod(context).parameters.joinToString { "${it.name}: ${it.type}" }
}

internal fun MethodNodeWithClass.formatLayoutParamsArguments(
        context: GeneratorContext,
        importList: ImportList
): List<String> {
    return toKMethod(context).parameters.map { param ->
        val renderType = importList.let { it[param.type] }

        val defaultValue = specialLayoutParamsArguments[param.name]
        val realName = specialLayoutParamsNames.getOrElse(param.name, { param.name })

        if (defaultValue == null)
            "$realName: $renderType"
        else
            "$realName: $renderType = $defaultValue"
    }
}

internal fun MethodNodeWithClass.formatLayoutParamsArgumentsInvoke(context: GeneratorContext): String {
    return toKMethod(context).parameters.joinToString { param ->
        val realName = specialLayoutParamsNames.getOrElse(param.name, { param.name })
        val explicitNotNull = if (param.type.isNullable) "!!" else ""
        "$realName$explicitNotNull"
    }
}

internal fun MethodNodeWithClass.formatArgumentsTypes(context: GeneratorContext): String {
    return toKMethod(context).parameters.joinToString { it.type.toString() }
}

internal fun MethodNodeWithClass.formatArgumentsNames(context: GeneratorContext): String {
    return toKMethod(context).parameters.joinToString { it.name }
}

fun MethodNode.isGetter(): Boolean {
    val isNonBooleanGetter = name.startsWith("get") && name.length > 3 && Character.isUpperCase(name[3])
    val isBooleanGetter = name.startsWith("is") && name.length > 2 && Character.isUpperCase(name[2])

    return (isNonBooleanGetter || isBooleanGetter) && parameterRawTypes.isEmpty() && !returnType.isVoid && isPublic
}

internal fun MethodNode.isNonListenerSetter(): Boolean {
    val isSetter = name.startsWith("set") && name.length > 3 && Character.isUpperCase(name[3])
    return isSetter && !(isListenerSetter() || name.endsWith("Listener")) && parameterRawTypes.size == 1 && isPublic
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