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

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import java.io.File
import java.io.InputStream
import java.util.jar.JarFile
import java.util.zip.ZipFile

class ClassProcessor(jars: List<String>) {

    private val jars: List<File>

    init {
        val (mainJar, otherJars) = jars.map { File(it) }.partition { it.name == "android.jar" }
        this.jars = mainJar + otherJars
    }

    fun genClassTree(): ClassTree {
        val classTree = ClassTree()
        for (classData in extractClasses()) {
            classTree.add(processClassData(classData.first), classData.second)
        }
        return classTree
    }

    private fun extractClasses(): Sequence<Pair<InputStream, Boolean>> {
        val jarSequences = jars.withIndex().asSequence().map { jar ->
            val jarFile = ZipFile(jar.value)
            jarFile.entries().asSequence()
                    .filter { it.getName().endsWith(".class") }
                    .map { jarFile.getInputStream(it) to (jar.index == 0) }
        }

        return jarSequences.flatten()
    }

    private fun processClassData(classData: InputStream): ClassNode {
        return classData.use {
            val cn = ClassNode()
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
            cn
        }
    }

}