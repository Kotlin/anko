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

import org.jetbrains.android.anko.artifact.Artifact
import org.jetbrains.android.anko.artifact.Tunes
import java.io.File

class DefaultAnkoConfiguration(
        override val outputDirectory: File,
        override val artifact: Artifact,
        override val options: Options,
        val tunes: Tunes
) : AnkoConfiguration {
    override val outputPackage: String

    private fun readProps(name: String) = File("anko/props/$name.txt").readLines().toSet()

    override val excludedClasses = tunes.excludedClasses
    override val excludedMethods = readProps("excluded_methods")
    override val excludedProperties = readProps("excluded_properties")
    override val propertiesWithoutGetters = readProps("properties_without_getters")

    init {
        val artifactType = artifact.type
        outputPackage = "org.jetbrains.anko" + when (artifactType) {
            ArtifactType.COMMONS, ArtifactType.PLATFORM -> ""
            else -> "." + artifact.name.replace('-', '.').toLowerCase()
        }

        for (line in propertiesWithoutGetters) {
            if (!line.matches("[A-Za-z0-9]+(\\.((?!set)[A-Za-z0-9]+))*".toRegex())) {
                error("Invalid line in properties_without_getters.txt: $line")
            }
        }
    }

    override val sourceOutputDirectory = File(outputDirectory, "src")

    override fun getOutputFile(ankoFile: AnkoFile): File {
        return File(sourceOutputDirectory, ankoFile.filename)
    }
}