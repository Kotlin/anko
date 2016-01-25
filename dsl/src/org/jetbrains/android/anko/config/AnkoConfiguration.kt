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

package org.jetbrains.android.anko.config

import org.jetbrains.android.anko.annotations.AnnotationManager
import org.jetbrains.android.anko.config.TargetArtifactType.COMMON
import org.jetbrains.android.anko.config.TargetArtifactType.SQLITE
import org.jetbrains.android.anko.config.TargetArtifactType.PLATFORM
import org.jetbrains.android.anko.config.TargetArtifactType.SUPPORT_V4
import org.jetbrains.android.anko.config.TargetArtifactType.TOOLKIT
import org.jetbrains.android.anko.sources.SourceManager
import org.jetbrains.android.anko.templates.TemplateManager
import java.io.File

abstract class AnkoConfiguration {
    open val indent: String = "    "

    open val files: MutableSet<AnkoFile> = hashSetOf(*AnkoFile.values())
    open val tunes: MutableSet<ConfigurationTune> = hashSetOf(*ConfigurationTune.values())

    open val generateStaticFiles: Boolean = true

    open var generateImports: Boolean = true
    open var generatePackage: Boolean = true
    open var generateMavenArtifact: Boolean = true

    abstract val version: String

    abstract val generatorOptions: Set<GeneratorOption>

    abstract val outputPackage: String

    abstract val outputDirectory: File
    abstract val sourceOutputDirectory: File

    abstract val excludedClasses: Set<String>
    abstract val excludedMethods: Set<String>
    abstract val excludedProperties: Set<String>
    abstract val propertiesWithoutGetters: Set<String>

    abstract val annotationManager: AnnotationManager
    abstract val sourceManager: SourceManager
    abstract val templateManager: TemplateManager
    abstract val logManager: LogManager

    operator fun get(option: ConfigurationOption): Boolean = tunes.contains(option) || files.contains(option)

    abstract fun getOutputFile(ankoFile: AnkoFile): File

    fun getTargetArtifactType(): TargetArtifactType {
        return when {
            "common" == version -> COMMON
            "sqlite" == version -> SQLITE
            "support-v4" == version -> SUPPORT_V4
            version.matches("sdk\\d{2}".toRegex()) -> PLATFORM
            else -> TOOLKIT
        }
    }
}