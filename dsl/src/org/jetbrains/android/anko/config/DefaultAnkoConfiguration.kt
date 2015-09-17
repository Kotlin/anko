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

import org.jetbrains.android.anko.annotations.*
import org.jetbrains.android.anko.sources.AndroidHomeSourceProvider
import org.jetbrains.android.anko.sources.SourceManager
import org.jetbrains.android.anko.templates.MustacheTemplateProvider
import org.jetbrains.android.anko.templates.TemplateManager
import java.io.File

open class DefaultAnkoConfiguration(
        outputDirectory: File,
        override val version: String
) : AnkoConfiguration() {
    override val outputPackage: String

    override val excludedClasses = File("dsl/props/excluded_classes.txt").readLines().toSet()

    override val excludedMethods = File("dsl/props/excluded_methods.txt").readLines().toSet()

    override val excludedProperties = File("dsl/props/excluded_properties.txt").readLines().toSet()

    override val propertiesWithoutGetters = File("dsl/props/properties_without_getters.txt").readLines().toSet()

    override val annotationManager: AnnotationManager
    override val sourceManager: SourceManager
    override val templateManager: TemplateManager

    init {
        val zipFileProvider = ZipFileAnnotationProvider(File("lib/Kotlin/kotlinc/lib/kotlin-android-sdk-annotations.jar"))
        val directoryProvider = DirectoryAnnotationProvider(File("dsl/props/annotations"))

        annotationManager = AnnotationManager(CompoundAnnotationProvider(
                CachingAnnotationProvider(zipFileProvider), CachingAnnotationProvider(directoryProvider)))

        sourceManager = SourceManager(AndroidHomeSourceProvider(23))

        templateManager = TemplateManager(MustacheTemplateProvider(File("dsl/props/templates")))

        val artifactType = getTargetArtifactType()
        outputPackage = "org.jetbrains.anko" + when (artifactType) {
            TargetArtifactType.COMMON, TargetArtifactType.PLATFORM -> ""
            else -> "." + version.replace('-', '.').toLowerCase()
        }
    }

    override val outputDirectory = outputDirectory
    override val sourceOutputDirectory = File(outputDirectory, "src/main/kotlin/" + outputPackage.replace('.', '/'))

    override fun getOutputFile(ankoFile: AnkoFile): File {
        return File(sourceOutputDirectory, ankoFile.filename)
    }
}