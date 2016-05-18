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
    override fun run() {
        val classTree = this.classTree ?: ClassProcessor(platformJars, versionJars).genClassTree()
        val generationState = GenerationState(classTree, config)
        val renderer = RenderFacade(generationState)
        Writer(renderer).write()

        if (config.generateMavenArtifact) {
            val sdkVersion = File(sourceDirectory, "version.txt").readText()
            generateMavenArtifact(config.outputDirectory, config.artifactName, sdkVersion)
        }
    }
}