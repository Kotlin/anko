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
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.AnkoFileType
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.render.RenderFacade
import java.io.File

class DSLGenerator(
    val platformJars: List<File>,
    val versionJars: List<File>,
    val config: AnkoConfiguration,
    val classTree: ClassTree? = null): Runnable
{
    private val mvnManifest: String
        get() = File("dsl/props/mvn/AndroidManifest.xml").readText()

    private fun copy(original: String) {
        val originalFile = File("dsl/props/mvn/$original")
        val toCreateFile = File((config.outputDirectory + original))
        originalFile.copyTo(toCreateFile)
    }

    private fun copy(original: String, process: (String) -> String) {
        val contents = process(File("dsl/props/mvn/$original").readText())
        File(config.outputDirectory + original).writeText(contents)
    }

    override fun run() {
        val supportVersion = config.getVersionType() == AnkoFileType.SUPPORT
        if (supportVersion)
            config.files.add(AnkoFile.SUPPORT)
        else
            config.files.remove(AnkoFile.SUPPORT)

        val classTree = this.classTree ?: ClassProcessor(platformJars, versionJars).genClassTree()
        val generationState = GenerationState(classTree, config)
        val renderer = RenderFacade(generationState)
        Writer(renderer).write()

        if (config.generateMavenArtifact) {
            // Create res directory
            val resDirectory = File(config.outputDirectory + "src/main/res/")
            if (!resDirectory.exists()) {
                resDirectory.mkdirs()
            }

            val artifactVersion = if (supportVersion) config.version.substringAfter('-') else config.version
            val platformVersion = config.version.substringBefore('-')

            // Write manifest
            val manifest = mvnManifest.replace("%VERSION", platformVersion)
            File(config.outputDirectory + "src/main/AndroidManifest.xml").writeText(manifest)

            // Copy gradle wrapper
            copy("gradlew")
            copy("gradlew.bat")
            copy("gradle/wrapper/gradle-wrapper.jar")
            copy("gradle/wrapper/gradle-wrapper.properties")

            // Copy gradle build files
            fun String.substVersions() = replace("%VERSION", platformVersion).replace("%FVERSION", artifactVersion)
            copy("gradle.properties") { it.substVersions() }
            copy("build.gradle") { it.substVersions() }
        }
    }
}