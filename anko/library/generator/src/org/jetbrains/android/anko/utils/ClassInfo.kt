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

package org.jetbrains.android.anko.utils

import org.jetbrains.android.anko.isConstructor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

data class MethodNodeWithClass(var clazz: ClassNode, val method: MethodNode) {
    val identifier = "${clazz.fqName}#${method.name}"
}

internal val ClassNode.fqName: String
    get() = name.replace('/', '.').replace('$', '.')

internal val ClassNode.packageName: String
    get() = fqName.substringBeforeLast('.')

internal val ClassNode.fqNameWithTypeArguments: String
    get() = fqName + buildTypeParams()

internal val ClassNode.simpleName: String
    get() {
        val name = fqName
        return if (name.indexOf('$') >= 0) name.substringAfterLast('$') else name.substringAfterLast('.')
    }

internal fun ClassNode.buildTypeParams(): String {
    return if (signature != null) {
        val genericMethodSignature = parseGenericMethodSignature(signature)
        if (genericMethodSignature.typeParameters.isEmpty()) return ""

        genericMethodSignature.typeParameters
                .map { it.upperBounds.fold("") { s, bound -> s + "out " + genericTypeToKType(bound) } }
                .joinToString(prefix = "<", postfix = ">")
    } else ""
}

val ClassNode.isInner: Boolean
    get() = name.contains("$")

internal val ClassNode.isPublic: Boolean
    get() = ((access and Opcodes.ACC_PUBLIC) != 0)

internal val ClassNode.isInterface: Boolean
    get() = ((access and Opcodes.ACC_INTERFACE) != 0)

internal val ClassNode.isAbstract: Boolean
    get() = ((access and Opcodes.ACC_ABSTRACT) != 0)

internal fun ClassNode.getConstructors(): List<MethodNode> {
    return (methods as List<MethodNode>).filter { it.isConstructor }
}