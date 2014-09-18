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
      Subsystem.HELPER -> File(parentDirectory + "Helpers.kt")
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

  override val helperConstructors: Map<String, List<List<String>>>
    get() {
      val res = HashMap<String, ArrayList<ArrayList<String>>>()
      for (line in readLines("props/helper_constructors.txt")) {
        try {
          with (line.replaceAll("\\s", "").split(':')) {
            val className = get(0)
            val constructors = res.getOrElse(className, { ArrayList<ArrayList<String>>() })
            val props = ArrayList<String>()
            for (prop in get(1).split(',')) {
              props.add(prop)
            }
            constructors.add(props)
            res.put(className, constructors)
          }
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