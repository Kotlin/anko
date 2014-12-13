/*
 * Copyright 2014 JetBrains s.r.o.
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

import java.io.File
import org.jetbrains.android.dsl.utils.DirectoryFilter
import org.jetbrains.android.dsl.utils.JarFilter

fun main(args: Array<String>) {
    if (args.size()>0) {
        args.forEach {
            arg -> when (arg) {
                "gen", "generate" -> gen()
                "clean" -> clean()
                "versions" -> versions()
            }
        }
    } else gen()
}

private fun clean() {
    deleteDirectory(File("gen/"))
}

private fun versions() {
    for (version in getVersions()) {
        val jars = getJars(version)
        println("${version.getName()}")
        jars?.forEach { println("  ${it.name}") }
    }
}

private fun deleteDirectory(f: File) {
    if (!f.exists()) {
        return;
    }

    if (f.isDirectory()) {
        f.listFiles()?.forEach { deleteDirectory(it) }
    }
    if (!f.delete()) {
        throw RuntimeException("Failed to delete ${f.getAbsolutePath()}")
    }
}

private fun getVersions(): Array<File> {
    val original = File("original/")
    if (!original.exists() || !original.isDirectory()) {
        throw RuntimeException("\"original\" directory does not exist.")
    }
    return original.listFiles(DirectoryFilter()) ?: array<File>()
}

private fun getJars(version: File) = version.listFiles(JarFilter())

private fun gen() {
    for (version in getVersions()) {
        val jars = getJars(version)?.map { it.getAbsolutePath() } ?: listOf<String>()
        val intVersion = parseVersion(version.getName())
        if (intVersion != null && jars.isNotEmpty()) {
            println("Processing version=${version.getName()}, jars: ${jars.joinToString(",")}")

            val outputDirectory = "gen/${version.getName()}/"
            val fileOutputDirectory = File("$outputDirectory/src/main/kotlin/")
            if (!fileOutputDirectory.exists()) {
                fileOutputDirectory.mkdirs()
            }

            DSLGenerator(intVersion, version.getName(), jars, GeneratorConfiguration(outputDirectory)).run()
        }
    }
}

private fun parseVersion(name: String): Int? {
    val prob = name.filter { it.isDigit() }
    return if (prob.isNotEmpty())
        prob.toInt()
    else null
}