package com.jetbrains.android.dsl

import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer

open class GeneratorProps() : BaseGeneratorProps() {

	override fun getOutputFile(subsystem: Subsystem): File {
		return when (subsystem) {
			Subsystem.PROPERTIES -> File(outputDirectory + "Properties.kt")
			Subsystem.VIEWS -> File(outputDirectory + "Views.kt")
			Subsystem.LISTENERS -> File(outputDirectory + "Listeners.kt")
			Subsystem.LAYOUTS -> File(outputDirectory + "Layouts.kt")
			Subsystem.HELPER -> File(outputDirectory + "Helpers.kt")
			else -> throw RuntimeException("Unable to get output file for non-existing subsystem $subsystem")
		}
	}

	override val indent = "\t"

	override val outputDirectory = "dsl_out/"
	override val outputPackage = "kotlinx.android.dsl"

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

	protected fun readFile(name: String): String {
		var data = Files.readAllBytes(Paths.get(name) as Path)
		return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
	}

	protected fun readLines(fileName: String): MutableList<String> {
		return Files.readAllLines(Paths.get(fileName)!!, StandardCharsets.UTF_8)
	}
}