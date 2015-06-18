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

package org.jetbrains.android.anko

import org.jetbrains.android.anko.config.DefaultAnkoConfiguration
import org.jetbrains.android.anko.utils.AndroidVersionDirectoryFilter
import org.jetbrains.android.anko.utils.JarFileFilter
import java.io.File

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        args.forEach { taskName ->
            println(":: $taskName")
            when (taskName) {
                "gen", "generate" -> gen()
                "clean" -> clean()
                "versions" -> versions()
                else -> {
                    println("Invalid task $taskName")
                    return
                }
            }
        }
        println("Done.")
    } else gen()
}

private fun clean() {
    deleteDirectory(File("workdir/gen/"))
}

private fun versions() {
    for (version in getVersions()) {
        val (platformJars, versionJars) = getJars(version)
        println("${version.getName()}")
        (platformJars + versionJars).forEach { println("  ${it.name}") }
    }
}

private fun deleteDirectory(f: File) {
    if (!f.exists()) return

    if (f.isDirectory()) {
        f.listFiles()?.forEach { deleteDirectory(it) }
    }
    if (!f.delete()) {
        throw RuntimeException("Failed to delete ${f.getAbsolutePath()}")
    }
}

private fun getVersions(): Array<File> {
    val original = File("workdir/original/")
    if (!original.exists() || !original.isDirectory()) {
        throw RuntimeException("\"workdir/original\" directory does not exist.")
    }
    return original.listFiles(AndroidVersionDirectoryFilter()) ?: arrayOf<File>()
}

private fun getJars(version: File) = version.listFiles(JarFileFilter()).partition { it.name.startsWith("platform.") }

private fun gen() {
    for (version in getVersions()) {
        val (platformJars, versionJars) = getJars(version)
        val versionName = version.name

        val intVersion = parseVersion(versionName)
        if (platformJars.isNotEmpty()) {
            println("Processing version $versionName")
            println("  Platform jars: ${platformJars.joinToString()}")
            if (versionJars.isNotEmpty()) println("  Version jars: ${versionJars.joinToString()}")

            val outputDirectory = "workdir/gen/$versionName/"
            val fileOutputDirectory = File("$outputDirectory/src/main/kotlin/")
            if (!fileOutputDirectory.exists()) {
                fileOutputDirectory.mkdirs()
            }

            DSLGenerator(intVersion, versionName, platformJars, versionJars,
                    DefaultAnkoConfiguration(outputDirectory, versionName)).run()
        }
    }
}

private fun parseVersion(name: String) = name.substringBefore('-').toInt()