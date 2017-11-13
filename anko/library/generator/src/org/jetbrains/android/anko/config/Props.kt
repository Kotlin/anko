/*
 * Copyright 2016 JetBrains s.r.o.
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

package org.jetbrains.android.anko.config

import java.io.File
import java.util.*

class Variable(val name: String, val type: String) {
    override fun toString(): String {
        return "$name:$type"
    }
}

object Props {
    val imports: Map<String, String> by lazy {
        val map = hashMapOf<String, String>()
        File("anko/props")
                .listFiles { file -> file.name.startsWith("imports_") && file.name.endsWith(".txt") }
                ?.forEach {
                    val name = it.name.replace(".txt", "")
                    map.put(name.substring(name.indexOf('_') + 1), it.readText())
                }
        map
    }

    val helperConstructors: Map<String, List<List<Variable>>> by lazy {
        val res = HashMap<String, ArrayList<List<Variable>>>()
        val lines = File("anko/props/helper_constructors.txt").readLines()
        for (line in lines.filter { it.isNotEmpty() && !it.startsWith('#') }) {
            try {
                val separator = line.indexOf(' ')
                val className = line.substring(0, separator)
                val props = line.substring(separator + 1).split(',').map {
                    val nameType = it.split(":".toRegex()).toTypedArray()
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