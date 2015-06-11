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
import java.io.InputStream
import java.util.jar.JarFile

class ClassProcessor(val jars: List<String>) {

    private class ComplexIterator<T>(iterators: List<Iterator<T>>): Iterator<T> {

        private val internalIterator = iterators.iterator()
        private var currentIterator: Iterator<T>? = null

        private fun fixIterator() {
            if (!(currentIterator?.hasNext() ?: false)) {
                if (internalIterator.hasNext()) {
                    currentIterator = internalIterator.next()
                }
            }
        }

        override fun next(): T {
            fixIterator()
            return currentIterator!!.next()
        }
        override fun hasNext(): Boolean {
            fixIterator()
            return (currentIterator?.hasNext() ?: false)
        }
    }

    fun genClassTree(): ClassTree {
        val classTree = ClassTree()
        for (classData in extractClasses(jars)) {
            classTree.add(processClassData(classData))
        }
        return classTree
    }

    private fun extractClasses(jars: List<String>): Iterator<InputStream> {
        val jarFiles = jars.map { JarFile(it) }
        return ComplexIterator(
                jarFiles.map { jarFile ->
                    jarFile.entries().iterator()
                    .filter { it.getName().endsWith(".class") }
                    .map { jarFile.getInputStream(it) }
                })
    }

    private fun processClassData(classData: InputStream?): ClassNode {
        val cn = ClassNode()
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: Exception) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn
    }

}