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

package org.jetbrains.android.anko.utils

import org.jetbrains.android.anko.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

public interface ClassTreeUtils {

    protected val classTree: ClassTree

    protected fun isExcluded(node: ClassNode): Boolean
    protected fun isExcluded(node: MethodNodeWithClass): Boolean

    protected fun findAvailableClasses(): List<ClassNode> = classTree.filter { !isExcluded(it) }

    protected fun findAvailableMethods(availableClasses: List<ClassNode>): List<MethodNodeWithClass> {
        return availableClasses.flatMap { classNode ->
            classNode.methods
                    ?.map { MethodNodeWithClass(classNode, it) }
                    ?.filter { !isExcluded(it) }
                    ?: listOf()
        }
    }

    protected val ClassNode.isView: Boolean
        get() {
            val isSuccessor = classTree.isSuccessorOf(this, "android/view/View") || this.name == "android/view/View"
            return isSuccessor && !isInner
        }

    protected val ClassNode.isLayoutParams: Boolean
        get() {
            return isInner && (classTree.isSuccessorOf(this, "android/view/ViewGroup\$LayoutParams") || this.name == "android/view/ViewGroup\$LayoutParams")
        }

    protected val ClassNode.isViewGroup: Boolean
        get() {
            return !isInner && (classTree.isSuccessorOf(this, "android/view/ViewGroup") || this.name == "android/view/ViewGroup")
        }

    protected fun ClassNode.resolveAllMethods(): List<MethodNode> {
        val node = classTree.findNode(this)

        fun allMethodsTo(node: ClassTreeNode?, list: MutableList<MethodNode>) {
            if (node == null) return
            list.addAll(node.data.methods)
            allMethodsTo(node.parent, list)
        }

        val list = arrayListOf<MethodNode>()
        allMethodsTo(node, list)
        return list
    }

}