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

package org.jetbrains.android.dsl

import java.util.ArrayList
import org.objectweb.asm.tree.ClassNode
import java.util.Queue
import java.util.ArrayDeque

class NoSuchClassException : Exception()

class ClassTreeNode(parent: ClassTreeNode?, data: ClassNode) {
    var parent = parent
    var children: MutableList<ClassTreeNode> = ArrayList()
    var data = data
}

class ClassTree : Iterable<ClassNode>{
    private val root = ClassTreeNode(null, ClassNode())

    override fun iterator(): ClassTreeIterator {
        return ClassTreeIterator(root)
    }

    public fun add(clazz: ClassNode) {
        val parent = findNode(root, clazz.superName)
        val newNode: ClassTreeNode
        val orphans = getOrphansOf(clazz.name)
        if (parent != null) {
            newNode = ClassTreeNode(parent, clazz)
            parent.children.add(newNode)
        } else {
            newNode = ClassTreeNode(root, clazz)
            root.children.add(newNode)
        }
        newNode.children.addAll(orphans)
        orphans.forEach { it.parent = newNode }
    }

    public fun isChildOf(clazz: ClassNode, ancestorName: String): Boolean {
        val treeNode = findNode(root, clazz)
        if (treeNode == null) throw NoSuchClassException()

        return treeNode.parent?.data?.name == ancestorName
    }

    public fun isSuccessorOf(clazz: ClassNode, ancestorName: String): Boolean {
        val parent = findNode(ancestorName)
        if (parent == null) throw NoSuchClassException()

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

    public fun findNode(parentPackage: String, className: String): ClassTreeNode? {
        return findNode(root, parentPackage + '/', '/' + className)
    }

    public fun findNode(name: String): ClassTreeNode? {
        return findNode(root, name)
    }

    public fun findNode(clazz: ClassNode): ClassTreeNode? {
        return findNode(root, clazz.name)
    }

    private fun findNode(node: ClassTreeNode, clazz: ClassNode): ClassTreeNode? {
        return findNode(node, clazz.name)
    }
}

class ClassTreeIterator(var next: ClassTreeNode) : Iterator<ClassNode> {

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