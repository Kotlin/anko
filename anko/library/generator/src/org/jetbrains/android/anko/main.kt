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

@file:JvmName("Main")
package org.jetbrains.android.anko

import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.render.RenderFacade
import org.jetbrains.android.anko.utils.AndroidArtifactDirectoryFilter
import org.jetbrains.android.anko.utils.JarFileFilter
import org.jetbrains.android.anko.writer.VerifyWriter
import org.jetbrains.android.anko.writer.GeneratorWriter
import java.io.File

fun main(args: Array<String>) {
    val (rawOptions, tasks) = args.partition { it.startsWith("--") }

    val options = MutableOptions.create()
    rawOptions.map { it.drop(2) }.forEach { rawOption ->
        val split = rawOption.split('=', limit = 2)
        if (split.size != 2) error("Invalid option format: $rawOption")
        val key = split[0]
        val option: CliConfigurationKey<Any> =
                CLI_CONFIGURATION_KEYS.firstOrNull { it.cliName == key }
                        ?: error("Option not found: $key")

        options.setCliOption(option, split[1])
    }

    if (tasks.isNotEmpty()) {
        tasks.forEach { taskName ->
            println(":: $taskName")

            when (taskName) {
                "generate" -> launchGenerator(options, GeneratorMode.GENERATE)
                "verify" -> launchGenerator(options, GeneratorMode.VERIFY)
                "versions" -> versions(options)
                else -> {
                    println("Invalid task $taskName")
                    return
                }
            }
        }
        println("Done.")
    } else println("Please specify a task.")
}

private fun versions(options: Options) {
    for (version in getArtifactDirs(options[ORIGINAL_DIRECTORY])) {
        val (platformJars, sourceJars) = getJars(version)
        println(version.name + ": " + (platformJars + sourceJars).joinToString())
    }
}

private fun getArtifactDirs(originalDir: File): Array<File> {
    if (!originalDir.exists() || !originalDir.isDirectory) {
        throw RuntimeException("\"${originalDir.absolutePath}\" directory does not exist.")
    }
    return originalDir.listFiles(AndroidArtifactDirectoryFilter()) ?: arrayOf<File>()
}

private fun getJars(version: File) = version.listFiles(JarFileFilter()).partition { it.name.startsWith("platform.") }

private enum class GeneratorMode {
    GENERATE, VERIFY
}

private fun launchGenerator(options: Options, mode: GeneratorMode) {
    val artifactDirs = getArtifactDirs(options[ORIGINAL_DIRECTORY])
    val outputDirectory = options[OUTPUT_DIRECTORY]

    for (artifactDir in artifactDirs) {
        val (platformJars, sourceJars) = getJars(artifactDir)
        val artifactName = artifactDir.name

        if (platformJars.isNotEmpty()) {
            val outputDirectoryForArtifact = File(outputDirectory, artifactName)
            val fileOutputDirectory = File(outputDirectoryForArtifact, "src/")
            if (!fileOutputDirectory.exists()) {
                fileOutputDirectory.mkdirs()
            }

            val configuration = DefaultAnkoConfiguration(outputDirectoryForArtifact, artifactName, options)
            val context = AnkoBuilderContext.create(File("anko/props"), Logger.LogLevel.INFO, configuration)
            gen(platformJars, sourceJars, context, mode)
        }
    }
}

private fun gen(platformJars: List<File>, sourceJars: List<File>, context: AnkoBuilderContext, mode: GeneratorMode) {
    val classTree = ClassProcessor(platformJars, sourceJars).genClassTree()
    val generationState = GenerationState(classTree, context)
    val renderer = RenderFacade(generationState)

    val writer = when (mode) {
        GeneratorMode.GENERATE -> GeneratorWriter(renderer)
        GeneratorMode.VERIFY -> VerifyWriter(renderer)
    }

    writer.write()
}