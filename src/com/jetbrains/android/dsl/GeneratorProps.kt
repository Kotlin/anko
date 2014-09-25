package com.jetbrains.android.dsl

import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList
import java.io.File

open class GeneratorProps(outputDirectory: String = "gen/") : BaseGeneratorProps() {

  override fun getOutputFile(subsystem: Subsystem): File {
    val parentDirectory = outputDirectory+"src/main/kotlin/"
    return when (subsystem) {
      Subsystem.PROPERTIES -> File(parentDirectory + "Properties.kt")
      Subsystem.VIEWS -> File(parentDirectory + "Views.kt")
      Subsystem.LISTENERS -> File(parentDirectory + "Listeners.kt")
      Subsystem.LAYOUTS -> File(parentDirectory + "Layouts.kt")
      Subsystem.HELPERS -> File(parentDirectory + "Helpers.kt")
      Subsystem.SUPPORT -> File(parentDirectory + "Support.kt")
      Subsystem.CUSTOM -> File(parentDirectory + "Custom.kt")
      Subsystem.ASYNC -> File(parentDirectory + "Async.kt")
      Subsystem.CONTEXT_UTILS -> File(parentDirectory + "ContextUtils.kt")
      Subsystem.DIALOGS -> File(parentDirectory + "Dialogs.kt")
      else -> throw RuntimeException("Unable to get output file for non-existing subsystem $subsystem")
    }
  }

  override val indent = "  "

  override val outputDirectory = outputDirectory
  override val outputPackage = "kotlinx.android.koan"

  override val viewGroupBaseClass = "android/view/ViewGroup"
  override val viewBaseClass = "android/view/View"

  override val excludedClasses = HashSet(readLines("props/excluded_classes.txt"))
  override val excludedMethods = HashSet(readLines("props/excluded_methods.txt"))

  override val imports = listOf(
    "layouts" to "props/imports_layouts.txt",
    "views" to "props/imports_views.txt"
  ).fold(HashMap<String, String>()) { hashMap, t ->
    hashMap.put(t.first, readFile(t.second)); hashMap
  }

  override val helperConstructors: Map<String, List<List<Variable>>>
    get() {
      val res = HashMap<String, ArrayList<List<Variable>>>()
      for (line in readLines("props/helper_constructors.txt").filter { it.isNotEmpty() && !it.startsWith('#') }) {
        try {
          val separator = line.indexOf(' ')
          val className = line.substring(0, separator)
          val props = line.substring(separator+1).split(',').map {
            val nameType = it.split(":")
            Variable(nameType[0].trim(), nameType[1].trim())
          }.toList()
          val constructors = res.getOrElse(className, { ArrayList<List<Variable>>() })
          constructors.add(props)
          res.put(className, constructors)
        } catch (e: ArrayIndexOutOfBoundsException) {
          throw RuntimeException("Failed to tokenize string, malformed helper_constructors.txt")
        }
      }
      return res
    }

  override val customMethodParameters: Map<String, String>
    get() {
      fun parseLine(s: String): Pair<String, String>? {
        val trimmed = s.trim()
        if (trimmed.length==0) return null
        val paren = trimmed.indexOf('(')
        return Pair(trimmed.substring(0, paren), trimmed.substring(paren+1, trimmed.length-1))
      }
      return readLines("props/custom_method_parameters.txt").fold(HashMap<String, String>()) { r, t ->
        val parsed = parseLine(t)
        if (parsed != null) r.put(parsed.first, parsed.second)
        r
      }
    }
}