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
import org.jetbrains.android.anko.config.GeneratorOption
import org.jetbrains.android.anko.utils.AndroidVersionDirectoryFilter
import org.jetbrains.android.anko.utils.JarFileFilter
import java.io.File

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        val generatorOptions = System.getProperty("gen.options", "")
                .split(',')
                .map { GeneratorOption.parse(it) }
                .filterNotNull()
                .toSet()

        if (args.isNotEmpty()) {
            args.forEach { taskName ->
                println(":: $taskName")
                when (taskName) {
                    "gen", "generate" -> gen(generatorOptions)
                    "clean" -> clean()
                    "versions" -> versions()
                    else -> {
                        println("Invalid task $taskName")
                        return
                    }
                }
            }
            println("Done.")
        } else gen(generatorOptions)
    }
}

private fun clean() {
    deleteDirectory(File("workdir/gen/"))
}

private fun versions() {
    for (version in getVersionDirs()) {
        val (platformJars, versionJars) = getJars(version)
        println("${version.name}")
        (platformJars + versionJars).forEach { println("  ${it.name}") }
    }
}

private fun deleteDirectory(f: File) {
    if (!f.exists()) return

    if (f.isDirectory) {
        f.listFiles()?.forEach { deleteDirectory(it) }
    }
    if (!f.delete()) {
        throw RuntimeException("Failed to delete ${f.absolutePath}")
    }
}

private fun getVersionDirs(): Array<File> {
    val original = File("workdir/original/")
    if (!original.exists() || !original.isDirectory) {
        throw RuntimeException("\"workdir/original\" directory does not exist.")
    }
    return original.listFiles(AndroidVersionDirectoryFilter()) ?: arrayOf<File>()
}

private fun getJars(version: File) = version.listFiles(JarFileFilter()).partition { it.name.startsWith("platform.") }

private fun gen(generatorOptions: Set<GeneratorOption>) {
    copyStubs()

    for (versionDir in getVersionDirs()) {
        val (platformJars, versionJars) = getJars(versionDir)
        val versionName = versionDir.name

        if (platformJars.isNotEmpty()) {
            println("Processing version $versionName")
            println("  Platform jars: ${platformJars.joinToString()}")
            if (versionJars.isNotEmpty()) println("  Version jars: ${versionJars.joinToString()}")

            val outputDirectory = File("workdir/gen/$versionName/")
            val fileOutputDirectory = File(outputDirectory, "src/main/kotlin/")
            if (!fileOutputDirectory.exists()) {
                fileOutputDirectory.mkdirs()
            }

            DSLGenerator(versionDir, platformJars, versionJars,
                    DefaultAnkoConfiguration(outputDirectory, versionName, generatorOptions)).run()
        }
    }
}

private fun copyStubs() {
    val sourceDir = File("anko/library/stubs/src")
    val artifactDir = File("workdir/gen/stubs")
    val sourcesDir = File(artifactDir, "src/main/kotlin")
    sourcesDir.mkdirs()
    sourceDir.copyRecursively(sourcesDir)
    generateMavenArtifact(artifactDir, "stubs", "21")
}