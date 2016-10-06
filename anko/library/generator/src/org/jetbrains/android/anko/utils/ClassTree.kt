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

import org.objectweb.asm.tree.ClassNode
import java.util.*

internal class NoSuchClassException : Exception()

class ClassTreeNode(var parent: ClassTreeNode?, val data: ClassNode, val fromPlatformJar: Boolean) {
    var children: MutableList<ClassTreeNode> = ArrayList()
}

class ClassTree : Iterable<ClassNode>{
    private val root = ClassTreeNode(null, ClassNode(), true)

    override fun iterator(): ClassTreeIterator {
        return ClassTreeIterator(root)
    }

    fun add(clazz: ClassNode, fromMainJar: Boolean) {
        val parent = findNode(root, clazz.superName)
        val orphans = getOrphansOf(clazz.name)

        val newNode: ClassTreeNode
        if (parent != null) {
            newNode = ClassTreeNode(parent, clazz, fromMainJar)
            parent.children.add(newNode)
        } else {
            newNode = ClassTreeNode(root, clazz, fromMainJar)
            root.children.add(newNode)
        }

        newNode.children.addAll(orphans)
        orphans.forEach { it.parent = newNode }
    }

    fun isChildOf(clazz: ClassNode, ancestorName: String): Boolean {
        val treeNode = findNode(root, clazz) ?: throw NoSuchClassException()
        return treeNode.parent?.data?.name == ancestorName
    }

    fun isSuccessorOf(clazz: ClassNode, ancestorName: String): Boolean {
        val parent = findNode(ancestorName) ?: throw NoSuchClassException()

        val child = findNode(parent, clazz.name)
        return child != null && child != parent
    }

    private fun getOrphansOf(parentClassName: String): List<ClassTreeNode> {
        val res = root.children.partition { it.data.superName == parentClassName }
        root.children = res.second as MutableList<ClassTreeNode>
        return res.first
    }

    private fun findNode(node: ClassTreeNode, name: String?): ClassTreeNode? {
        for (child in node.children) {
            if (child.data.name == name) {
                return child
            } else {
                val ret = findNode(child, name)
                if (ret != null) return ret
            }
        }
        return null
    }

    private fun findNode(node: ClassTreeNode, parentPackage: String, className: String): ClassTreeNode? {
        for (child in node.children) {
            val childName = child.data.name
            if (childName.startsWith(parentPackage) && childName.endsWith(className)) {
                return child
            } else {
                val ret = findNode(child, parentPackage, className)
                if (ret != null) return ret
            }
        }
        return null
    }

    fun findNode(parentPackage: String, className: String): ClassTreeNode? {
        return findNode(root, "$parentPackage/", "/$className")
    }

    fun findNode(name: String): ClassTreeNode? {
        return findNode(root, name)
    }

    fun findNode(clazz: ClassNode): ClassTreeNode? {
        return findNode(root, clazz.name)
    }

    private fun findNode(node: ClassTreeNode, clazz: ClassNode): ClassTreeNode? {
        return findNode(node, clazz.name)
    }
}

class ClassTreeIterator(next: ClassTreeNode) : Iterator<ClassNode> {

    var nodeQueue: Queue<ClassTreeNode> = ArrayDeque(next.children)

    override fun next(): ClassNode {
        val node: ClassTreeNode = nodeQueue.element()
        nodeQueue.remove()
        nodeQueue.addAll(node.children)
        return node.data
    }

    override fun hasNext(): Boolean {
        return !nodeQueue.isEmpty()
    }

}