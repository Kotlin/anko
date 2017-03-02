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

package org.jetbrains.android.generator.hierarchy

import com.google.gson.Gson
import org.jetbrains.android.anko.ClassProcessor
import org.jetbrains.android.anko.artifact.Artifact
import org.jetbrains.android.anko.utils.ClassTree
import org.jetbrains.android.anko.utils.ClassTreeNode
import org.jetbrains.android.anko.utils.isInner
import org.objectweb.asm.tree.ClassNode
import java.io.File

fun main(args: Array<String>): Unit = HierarchyCollector.collect()

object HierarchyCollector {

    @JvmStatic
    fun collect() {
        val artifacts = Artifact.parseArtifacts(File("anko/props/artifacts.json"))
        val classTree = ClassProcessor(artifacts.first { it.name.matches("sdk[0-9]+".toRegex()) }).genClassTree()
        val viewClasses = classTree.filter { it.isView(classTree) && !it.isInner && it.name.startsWith("android/widget/") }

        val hierarchy = viewClasses.map {
            it.name.prettify() to getSuperViews(it, classTree)
        }.filter { it.second.isNotEmpty() }.toMap()

        File("views.json").writeText(Gson().toJson(hierarchy))
    }

    private fun getSuperViews(node: ClassNode, tree: ClassTree): List<String> {
        val list = arrayListOf<String>()

        fun getSuperViews(node: ClassTreeNode) {
            val parent = node.parent
            if (parent != null && parent.data.isView(tree) && parent.data.name != "android/view/View") {
                list.add(parent.data.name.prettify())
                getSuperViews(parent)
            }
        }

        val treeNode = tree.findNode(node)

        if (treeNode != null) {
            getSuperViews(treeNode)
        }

        return list
    }

    private fun String.prettify(): String = replace("android/view/", "").replace("android/widget/", "")

    private fun ClassNode.isView(classTree: ClassTree): Boolean {
        val isSuccessor = classTree.isSuccessorOf(this, "android/view/View") || this.name == "android/view/View"
        return isSuccessor && !isInner
    }
}