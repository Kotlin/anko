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

import org.jetbrains.android.anko.annotations.*
import org.jetbrains.android.anko.sources.AndroidHomeSourceProvider
import org.jetbrains.android.anko.sources.SourceManager
import org.jetbrains.android.anko.templates.MustacheTemplateProvider
import org.jetbrains.android.anko.templates.TemplateManager
import java.io.File

open class DefaultAnkoConfiguration(
        override val outputDirectory: File,
        override val artifactName: String,
        override val generatorOptions: Set<GeneratorOption>
) : AnkoConfiguration() {
    override val outputPackage: String

    override val excludedClasses = File("anko/props/excluded_classes.txt").readLines().toSet()

    override val excludedMethods = File("anko/props/excluded_methods.txt").readLines().toSet()

    override val excludedProperties = File("anko/props/excluded_properties.txt").readLines().toSet()

    override val propertiesWithoutGetters = File("anko/props/properties_without_getters.txt").readLines().toSet()

    override val annotationManager: AnnotationManager
    override val sourceManager: SourceManager
    override val templateManager: TemplateManager
    override val logManager: LogManager

    init {
        val zipFileProvider = ZipFileAnnotationProvider(File("anko/props/kotlin-android-sdk-annotations-1.0.0.jar"))
        val directoryProvider = DirectoryAnnotationProvider(File("anko/props/annotations"))

        annotationManager = AnnotationManager(CompoundAnnotationProvider(
                CachingAnnotationProvider(zipFileProvider), CachingAnnotationProvider(directoryProvider)))

        sourceManager = SourceManager(AndroidHomeSourceProvider(23))

        templateManager = TemplateManager(MustacheTemplateProvider(File("anko/props/templates")))

        logManager = LogManager(this)

        val artifactType = getTargetArtifactType()
        outputPackage = "org.jetbrains.anko" + when (artifactType) {
            TargetArtifactType.COMMON, TargetArtifactType.PLATFORM -> ""
            else -> "." + artifactName.replace('-', '.').toLowerCase()
        }

        for (line in propertiesWithoutGetters) {
            if (!line.matches("[A-Za-z0-9]+(\\.((?!set)[A-Za-z0-9]+))*".toRegex())) {
                logManager.e("Invalid line in properties_without_getters.txt: $line")
            }
        }
    }

    override val sourceOutputDirectory = File(outputDirectory, "src/main/kotlin/" + outputPackage.replace('.', '/'))

    override fun getOutputFile(ankoFile: AnkoFile): File {
        return File(sourceOutputDirectory, ankoFile.filename)
    }
}