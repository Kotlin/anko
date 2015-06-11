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
import org.jetbrains.android.anko.sources.SourceManager
import org.jetbrains.android.anko.templates.TemplateManager
import java.io.File

abstract class AnkoConfiguration {
    open val indent: String = "    "

    open val files: MutableSet<AnkoFile> = hashSetOf(*AnkoFile.values())
    open val tunes: MutableSet<ConfigurationTune> = hashSetOf(*ConfigurationTune.values())

    open var generateImports: Boolean = true
    open var generatePackage: Boolean = true
    open var generateMavenArtifact: Boolean = true

    abstract val outputDirectory: String
    abstract val outputPackage: String

    abstract val excludedClasses: Set<String>
    abstract val excludedMethods: Set<String>
    abstract val excludedProperties: Set<String>
    abstract val propertiesWithoutGetters: Set<String>

    abstract val annotationManager: AnnotationManager
    abstract val sourceManager: SourceManager
    abstract val templateManager: TemplateManager

    public fun get(option: ConfigurationOption): Boolean = tunes.contains(option) || files.contains(option)

    public abstract fun getOutputFile(ankoFile: AnkoFile): File
}