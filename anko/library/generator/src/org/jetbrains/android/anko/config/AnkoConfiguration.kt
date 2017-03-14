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
import org.jetbrains.android.anko.config.TargetArtifactType.*
import java.io.File

interface AnkoConfiguration {
    val indent: String
        get() = "    "

    val generateImports: Boolean
        get() = true

    val generatePackage: Boolean
        get() = true

    val artifact: Artifact

    val options: Options

    val outputPackage: String

    val outputDirectory: File
    val sourceOutputDirectory: File

    val excludedClasses: Set<String>
    val excludedMethods: Set<String>
    val excludedProperties: Set<String>
    val propertiesWithoutGetters: Set<String>

    fun getOutputFile(ankoFile: AnkoFile): File

    fun getTargetArtifactType(): TargetArtifactType {
        val artifactName = artifact.name
        return when {
            "common" == artifactName -> COMMON
            "sqlite" == artifactName -> SQLITE
            "support-v4" == artifactName -> SUPPORT_V4
            artifactName.endsWith("-listeners") -> SIMPLE_LISTENERS
            artifactName.endsWith("-coroutines") -> COROUTINE_LISTENERS
            artifactName.matches("sdk\\d{2}".toRegex()) -> PLATFORM
            else -> TOOLKIT
        }
    }
}

operator fun <T : Any> AnkoConfiguration.get(key: ConfigurationKey<T>) = options[key]