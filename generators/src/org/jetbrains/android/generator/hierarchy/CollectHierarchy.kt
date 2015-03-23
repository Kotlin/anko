package org.jetbrains.android.generator.hierarchy

import java.io.File
import org.jetbrains.android.anko.ClassProcessor
import org.jetbrains.android.anko.isInner
import org.jetbrains.android.anko.isView
import org.objectweb.asm.tree.ClassNode
import org.jetbrains.android.anko.ClassTree
import org.jetbrains.android.anko.ClassTreeNode
import kotlin.platform.platformStatic
import com.google.gson.Gson

public fun main(args: Array<String>): Unit = HierarchyCollector.collect()

object HierarchyCollector {

    platformStatic
    public fun collect() {
        val ver = File("original").listFiles { it.name.matches("[0-9]+") }!!
                .first { it.listFiles { it.name == "android.jar" }?.isNotEmpty() ?: false }
        val androidJar = ver.listFiles { it.name == "android.jar" }!!.first().getAbsolutePath()

        val classTree = ClassProcessor(listOf(androidJar)).genClassTree()
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

}