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

import org.jetbrains.android.anko.config.TargetArtifactType.*
import java.io.File

abstract class AnkoConfiguration {
    open val indent: String = "    "

    open val generateStaticFiles: Boolean = true

    open val generateImports: Boolean = true
    open val generatePackage: Boolean = true
    open val generateMavenArtifact: Boolean = true

    abstract val artifactName: String

    abstract val options: Options

    abstract val outputPackage: String

    abstract val outputDirectory: File
    abstract val sourceOutputDirectory: File

    abstract val excludedClasses: Set<String>
    abstract val excludedMethods: Set<String>
    abstract val excludedProperties: Set<String>
    abstract val propertiesWithoutGetters: Set<String>

    abstract fun getOutputFile(ankoFile: AnkoFile): File

    fun getTargetArtifactType(): TargetArtifactType {
        return when {
            "common" == artifactName -> COMMON
            "sqlite" == artifactName -> SQLITE
            "support-v4" == artifactName -> SUPPORT_V4
            artifactName.matches("sdk\\d{2}".toRegex()) -> PLATFORM
            else -> TOOLKIT
        }
    }
}

operator fun <T : Any> AnkoConfiguration.get(key: ConfigurationKey<T>) = options[key]