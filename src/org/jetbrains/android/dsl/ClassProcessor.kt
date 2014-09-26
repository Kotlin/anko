package org.jetbrains.android.dsl

import java.io.InputStream
import org.objectweb.asm.tree.ClassNode
import java.util.jar.JarFile
import org.objectweb.asm.ClassReader
import java.util.Enumeration
import java.util.jar.JarEntry

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
    return ComplexIterator(jarFiles.map { jarFile ->
      (jarFile.entries() as Enumeration<JarEntry>).iterator()
      .filter {
        it.getName().endsWith(".class")
      }.map {
      jarFile.getInputStream(it)!!
    }})
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