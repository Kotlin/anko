package org.jetbrains.android.dsl

import java.io.PrintWriter
import java.io.File
import java.util.ArrayList
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

class Writer(private val renderer: Renderer) {

  val props = renderer.props

  fun write() {
    val properties = writeProperties()
    val layouts = writeLayouts()
    val views = writeViews()
    val listeners = writeListeners()
    if (properties || layouts || views || listeners) {
      writeHelpers()
      if (props.generateSupport && props.generateStatic) {
        writeSupport()
      }
      if (props.generateStatic) {
        writeCustom()
        writeAsync()
        writeContextUtils()
        writeDialogs()
      }
    }
  }

  private fun writeCustom() = writeStatic(Subsystem.CUSTOM, "props/Custom.kt")
  private fun writeAsync() = writeStatic(Subsystem.ASYNC, "props/Async.kt")
  private fun writeContextUtils() = writeStatic(Subsystem.CONTEXT_UTILS, "props/ContextUtils.kt")
  private fun writeDialogs() = writeStatic(Subsystem.DIALOGS, "props/Dialogs.kt")

  private fun writeHelpers() = writeStatic(Subsystem.HELPERS, "props/Helpers.kt")
  private fun writeSupport() = writeStatic(Subsystem.SUPPORT, "props/Support.kt")

  private fun writeStatic(subsystem: Subsystem, filename: String) {
    val support = Files.readAllLines(Paths.get(filename)!!, StandardCharsets.UTF_8)
    writeToFile(props.getOutputFile(subsystem), support)
  }

  private fun writeProperties(): Boolean {
    return if (props.generateProperties) {
      writeToFile(props.getOutputFile(Subsystem.PROPERTIES), renderer.properties)
      true
    } else false
  }

  private fun writeLayouts(): Boolean {
    return if (props.generateLayoutParamsHelperClasses) {
      val imports = props.imports["layouts"] ?: ""
      writeToFile(props.getOutputFile(Subsystem.LAYOUTS), renderer.layouts, imports)
      true
    } else false
  }

  private fun writeViews(): Boolean {
    return if (props.generateViewExtensionMethods || props.generateViewGroupExtensionMethods
        || props.generateViewHelperConstructors) {
      val allViews = arrayListOf<String>()
      if (props.generateViewExtensionMethods)
        allViews.addAll(renderer.views)
      if (props.generateViewGroupExtensionMethods)
        allViews.addAll(renderer.viewGroups)
      if (props.generateViewHelperConstructors)
        allViews.addAll(renderer.helperConstructors)
      val imports = props.imports["views"] ?: ""
      writeToFile(props.getOutputFile(Subsystem.VIEWS), allViews, imports)
      imports.length>0 || allViews.isNotEmpty()
    } else false
  }

  private fun writeListeners(): Boolean {
    val generate = props.generateSimpleListeners
      || props.generateComplexListenerClasses || props.generateComplexListenerSetters
    return if (generate) {
      val allListeners = ArrayList<String>()
      if (props.generateSimpleListeners)
        allListeners.addAll(renderer.simpleListeners)
      if (props.generateComplexListenerClasses)
        allListeners.addAll(renderer.listenerHelperClasses)
      if (props.generateComplexListenerSetters)
        allListeners.addAll(renderer.listenerSetters)
      writeToFile(props.getOutputFile(Subsystem.LISTENERS), allListeners)
      return allListeners.isNotEmpty()
    } else false
  }

  private fun writeToFile(file: File, text: List<String>, imports: String = "") {
    val writer = PrintWriter(file)
    if (props.generatePackage) {
      writer.println("package ${props.outputPackage}\n")
    }
    if (props.generateImports && imports.isNotEmpty()) {
      writer.println(imports)
      writer.println()
    }
    for (line in text) {
      writer.println(line)
    }
    writer.close()
  }

}