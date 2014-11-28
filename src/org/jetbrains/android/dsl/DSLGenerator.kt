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

class DSLGenerator(
    val version: Int,
    val fVersion: String,
    val jars: List<String>,
    val config: BaseGeneratorConfiguration): Runnable
{

    private val sVersion = version.toString()

    private val mvnManifest: String
        get() = readFile("props/mvn/AndroidManifest.xml")

    private fun copy(original: String) {
        val originalFile = File("props/mvn/$original")
        val toCreateFile = File((config.outputDirectory + original))
        originalFile.copyTo(toCreateFile)
    }

    private fun copy(original: String, process: (String) -> String) {
        val contents = process(readFile("props/mvn/$original"))
        writeFile(config.outputDirectory + original, contents)
    }

    override fun run() {
        if (fVersion.contains("s"))
            config.files.add(KoanFile.SUPPORT)
        else
            config.files.remove(KoanFile.SUPPORT)

        val classTree = ClassProcessor(jars).genClassTree()
        val generator = Generator(classTree, config)
        val renderer = Renderer(generator)
        Writer(renderer).write()

        if (config.generateMavenArtifact) {
            //create res directory
            val resDirectory = File(config.outputDirectory + "src/main/res/")
            if (!resDirectory.exists()) {
                resDirectory.mkdirs()
            }

            //write manifest
            val manifest = mvnManifest.replace("%VERSION%", sVersion)
            writeFile(config.outputDirectory + "src/main/AndroidManifest.xml", manifest)

            //copy gradle wrapper
            copy("gradlew")
            copy("gradlew.bat")
            copy("gradle/wrapper/gradle-wrapper.jar")
            copy("gradle/wrapper/gradle-wrapper.properties")

            //copy gradle build files
            copy("gradle.properties") { it.replace("%FVERSION%", fVersion) }
            copy("build.gradle") { it.replace("%VERSION%", sVersion) }
        }
    }
}