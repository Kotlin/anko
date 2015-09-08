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

import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.render.RenderFacade
import org.jetbrains.android.anko.utils.ClassTree
import java.io.File

class DSLGenerator(
    val sourceDirectory: File,
    val platformJars: List<File>,
    val versionJars: List<File>,
    val config: AnkoConfiguration,
    val classTree: ClassTree? = null): Runnable
{
    private val mvnManifest: String
        get() = File("dsl/props/mvn/AndroidManifest.xml").readText()

    private fun copy(original: String) {
        val originalFile = File("dsl/props/mvn/$original")
        val toCreateFile = File(config.outputDirectory, original)
        originalFile.copyTo(toCreateFile)
    }

    private fun copy(original: String, process: (String) -> String) {
        val contents = process(File("dsl/props/mvn/$original").readText())
        File(config.outputDirectory, original).writeText(contents)
    }

    override fun run() {
        val classTree = this.classTree ?: ClassProcessor(platformJars, versionJars).genClassTree()
        val generationState = GenerationState(classTree, config)
        val renderer = RenderFacade(generationState)
        Writer(renderer).write()

        if (config.generateMavenArtifact) {
            // Create res directory
            val resDirectory = File(config.outputDirectory, "src/main/res/")
            if (!resDirectory.exists()) {
                resDirectory.mkdirs()
            }

            val artifactVersion = config.version
            val sdkVersion = File(sourceDirectory, "version.txt").readText()

            // Write manifest
            val manifest = mvnManifest.replace("%SDK_VERSION", sdkVersion)
            File(config.outputDirectory, "src/main/AndroidManifest.xml").writeText(manifest)

            // Copy gradle wrapper
            copy("gradlew")
            copy("gradlew.bat")
            copy("gradle/wrapper/gradle-wrapper.jar")
            copy("gradle/wrapper/gradle-wrapper.properties")

            // Copy gradle build files
            fun String.substVersions(): String {
                return replace("%SDK_VERSION", sdkVersion)
                        .replace("%ARTIFACT_VERSION", artifactVersion)
                        .replace("%ORIGINAL_VERSION", config.version)
            }
            copy("gradle.properties") { it.substVersions() }
            copy("build.gradle") { it.substVersions() }
        }
    }
}