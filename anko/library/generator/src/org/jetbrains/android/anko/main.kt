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

import org.jetbrains.android.anko.artifact.Artifact
import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.render.RenderFacade
import org.jetbrains.android.anko.writer.VerifyWriter
import org.jetbrains.android.anko.writer.GeneratorWriter
import java.io.File

fun main(args: Array<String>) {
    val (rawOptions, tasks) = args.partition { it.startsWith("--") }
    val options = parseOptions(rawOptions)

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

private fun parseOptions(rawOptions: List<String>): MutableOptions {
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

    return options
}

private fun versions(options: Options) {
    Artifact.parseConfiguration(options[CONFIGURATION]).artifacts.forEach(::println)
}

private enum class GeneratorMode {
    GENERATE, VERIFY
}

private fun launchGenerator(options: Options, mode: GeneratorMode) {
    val outputDirectory = options[OUTPUT_DIRECTORY]

    val configuration = Artifact.parseConfiguration(options[CONFIGURATION])
    for (artifact in configuration.artifacts) {
        val outputDirectoryForArtifact = File(outputDirectory, artifact.name)
        val fileOutputDirectory = File(outputDirectoryForArtifact, "src/")
        if (!fileOutputDirectory.exists()) {
            fileOutputDirectory.mkdirs()
        }

        val configuration = DefaultAnkoConfiguration(outputDirectoryForArtifact, artifact, options, configuration.tunes)
        val context = GeneratorContext.create(File("anko/props"), Logger.LogLevel.INFO, configuration)
        gen(artifact, context, mode)
    }
}

private fun gen(artifact: Artifact, context: GeneratorContext, mode: GeneratorMode) {
    val classTree = ClassProcessor(artifact).genClassTree()
    val generationState = GenerationState(classTree, context)
    val renderer = RenderFacade(generationState)

    val writer = when (mode) {
        GeneratorMode.GENERATE -> GeneratorWriter(renderer)
        GeneratorMode.VERIFY -> VerifyWriter(renderer)
    }

    writer.write()
}