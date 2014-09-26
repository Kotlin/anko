package org.jetbrains.android.dsl.xmlconverter

import java.util.Properties;
import java.io.File
import java.io.FileInputStream
import java.util.HashMap
import java.util.ArrayList
import java.util.HashSet
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

open class ConverterSettings : BaseConverterSettings() {

	private val cfgFile = File("converter.properties")
	private val props = Properties();

	{
		try {
			props.load(FileInputStream(cfgFile))
		} catch (e: Exception) {
			println(e.getMessage())
		}
	}

	override val ignoredProperties: Set<String> = readIgnoredProps()
	override val helperConProps: HashMap<String, ArrayList<Set<String>>> = readHelperConProps()
	override val quotedKeys: Set<String> = props.getProperty("quoted_keys", "")!!.split(",").toSet()

	override val dslPackage: String = props.getProperty("dsl_package") ?: "com.example.dsl"
	override val className: String = props.getProperty("class_name") ?: "Foo"

	private fun readIgnoredProps(): Set<String> {
		return props.getProperty("ignored_props", "")!!.split(",").toSet()
	}

	private fun readHelperConProps(): HashMap<String, ArrayList<Set<String>>> {
    val res = HashMap<String, ArrayList<Set<String>>>()
    for (line in readLines("props/helper_constructors.txt").filter { it.isNotEmpty() && !it.startsWith('#') }) {
      try {
        val separator = line.indexOf(' ')
        val className = line.substring(0, separator)
        val props = line.substring(separator+1).split(',').map {
          val nameType = it.split(":")
          nameType[0].trim()
        }.toSet()
        val constructors = res.getOrElse(className, { ArrayList<Set<String>>() })
        constructors.add(props)
        res.put(className, constructors)
      } catch (e: ArrayIndexOutOfBoundsException) {
        throw RuntimeException("Failed to tokenize string, malformed helper_constructors.txt")
      }
    }
    return res
	}

	private fun readLines(fileName: String): MutableList<String> {
		return Files.readAllLines(Paths.get(fileName)!!, StandardCharsets.UTF_8)
	}
}