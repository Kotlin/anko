package com.jetbrains.android.dsl

import java.io.InputStream
import java.util.jar.JarFile
import java.util.Collections
import java.util.Enumeration
import java.util.jar.JarEntry
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.ClassReader
import java.io.File
import java.io.Writer
import java.io.PrintWriter

fun main(args: Array<String>) {
  val classTree = ClassProcessor(args).genClassTree()
  val props = GeneratorProps()

  props.helperConstructors

  val generator = Generator(classTree, props)
  val renderer = Renderer(generator)
  Writer(renderer).write()
}