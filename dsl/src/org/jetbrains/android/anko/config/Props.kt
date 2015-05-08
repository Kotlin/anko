package org.jetbrains.android.anko.config

import java.io.File
import java.util.ArrayList
import java.util.HashMap
import kotlin.properties.Delegates

class Variable(val name: String, val type: String) {
    override fun toString(): String {
        return "$name:$type"
    }
}

object Props {

    val imports: Map<String, String> by Delegates.lazy {
        val map = hashMapOf<String, String>()
        File("dsl/props")
                .listFiles { it.name.startsWith("imports_") && it.name.endsWith(".txt") }
                ?.forEach {
                    val name = it.name.replace(".txt", "")
                    map.put(name.substring(name.indexOf('_') + 1), it.readText())
                }
        map
    }

    val helperConstructors: Map<String, List<List<Variable>>> by Delegates.lazy {
        val res = HashMap<String, ArrayList<List<Variable>>>()
        val lines = File("dsl/props/helper_constructors.txt").readLines()
        for (line in lines.filter { it.isNotEmpty() && !it.startsWith('#') }) {
            try {
                val separator = line.indexOf(' ')
                val className = line.substring(0, separator)
                val props = line.substring(separator + 1).split(',').map {
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
        res
    }

}