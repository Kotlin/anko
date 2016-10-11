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

import java.io.File

open class DefaultAnkoConfiguration(
        final override val outputDirectory: File,
        final override val artifactName: String,
        override val options: Options
) : AnkoConfiguration() {
    final override val outputPackage: String

    final override val excludedClasses = File("anko/props/excluded_classes.txt").readLines().toSet()

    final override val excludedMethods = File("anko/props/excluded_methods.txt").readLines().toSet()

    final override val excludedProperties = File("anko/props/excluded_properties.txt").readLines().toSet()

    final override val propertiesWithoutGetters = File("anko/props/properties_without_getters.txt").readLines().toSet()

    init {
        val artifactType = getTargetArtifactType()
        outputPackage = "org.jetbrains.anko" + when (artifactType) {
            TargetArtifactType.COMMON, TargetArtifactType.PLATFORM -> ""
            else -> "." + artifactName.replace('-', '.').toLowerCase()
        }

        for (line in propertiesWithoutGetters) {
            if (!line.matches("[A-Za-z0-9]+(\\.((?!set)[A-Za-z0-9]+))*".toRegex())) {
                error("Invalid line in properties_without_getters.txt: $line")
            }
        }
    }

    override val sourceOutputDirectory = File(outputDirectory, "src/main/kotlin/" + outputPackage.replace('.', '/'))

    override fun getOutputFile(ankoFile: AnkoFile): File {
        return File(sourceOutputDirectory, ankoFile.filename)
    }
}