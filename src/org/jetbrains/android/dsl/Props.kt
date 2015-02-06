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

package org.jetbrains.android.dsl

import java.util.HashMap
import java.util.ArrayList
import kotlin.properties.Delegates
import java.io.File

object Props {

    val imports: Map<String, String> by Delegates.lazy {
        val map = hashMapOf<String, String>()
        File("props")
            .listFiles { it.name.startsWith("imports_") && it.name.endsWith(".txt") }
            ?.forEach {
                val name = it.name.replace(".txt", "")
                map.put(name.substring(name.indexOf('_') + 1), it.readText())
            }
        map
    }

    val helperConstructors: Map<String, List<List<Variable>>> by Delegates.lazy {
        val res = HashMap<String, ArrayList<List<Variable>>>()
        val lines = File("props/helper_constructors.txt").readLines()
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

    val customMethodParameters: Map<String, String> by Delegates.lazy {
        fun parseLine(s: String): Pair<String, String>? {
            val trimmed = s.trim()
            if (trimmed.size == 0)
                return null
            val paren = trimmed.indexOf('(')
            return Pair(trimmed.substring(0, paren), trimmed.substring(paren + 1, trimmed.size - 1))
        }

        val lines = File("props/custom_method_parameters.txt").readLines()
        lines.fold(hashMapOf<String, String>()) { map, line ->
            val parsed = parseLine(line)
            if (parsed != null)
                map.put(parsed.first, parsed.second)
            map
        }
    }

}