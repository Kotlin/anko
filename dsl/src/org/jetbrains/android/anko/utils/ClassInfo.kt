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
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.InnerClassNode

data class MethodNodeWithClass(var clazz: ClassNode, val method: MethodNode) {
    val identifier = "${clazz.fqName}#${method.name}"
}

val ClassNode.fqName: String
    get() = name.replace('/', '.').replace('$', '.')

val ClassNode.packageName: String
    get() = fqName.substringBeforeLast('.')

val ClassNode.fqNameWithTypeArguments: String
    get() = fqName + buildTypeParams()

val ClassNode.simpleName: String
    get() {
        val name = fqName
        return if (name.indexOf('$') >= 0) name.substringAfterLast('$') else name.substringAfterLast('.')
    }

fun ClassNode.buildTypeParams(): String {
    return if (signature != null) {
        val genericMethodSignature = parseGenericMethodSignature(signature)
        if (genericMethodSignature.typeParameters.isEmpty()) return ""

        genericMethodSignature.typeParameters
                .map { it.upperBounds.fold("") { s, bound -> s + "out " + genericTypeToStr(bound) } }
                .joinToString(prefix = "<", postfix = ">")
    } else ""
}

val ClassNode.isInner: Boolean
    get() = name.contains("$")

val ClassNode.isAbstract: Boolean
    get() = ((access and Opcodes.ACC_ABSTRACT) != 0)

val ClassNode.isPublic: Boolean
    get() = ((access and Opcodes.ACC_PUBLIC) != 0)

val InnerClassNode.isPublic: Boolean
    get() = ((access and Opcodes.ACC_PUBLIC) != 0)

val InnerClassNode.isProtected: Boolean
    get() = ((access and Opcodes.ACC_PROTECTED) != 0)

val InnerClassNode.isInterface: Boolean
    get() = ((access and Opcodes.ACC_INTERFACE) != 0)

fun ClassNode.getConstructors(): List<MethodNode> {
    return (methods as List<MethodNode>).filter { it.isConstructor }
}

fun ClassNode.isView(classTree: ClassTree): Boolean {
    val isSuccessor = classTree.isSuccessorOf(this, "android/view/View") || this.name == "android/view/View"
    return isSuccessor && !isInner
}

fun ClassNode.isViewGroup(classTree: ClassTree): Boolean {
    val isSuccessor = classTree.isSuccessorOf(this, "android/view/ViewGroup") || this.name == "android/view/ViewGroup"
    return isSuccessor && !isInner
}