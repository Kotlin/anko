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

import org.jetbrains.android.anko.utils.toCamelCase
import kotlin.properties.Delegates
import org.jetbrains.android.anko.config.TargetArtifactType.*

public enum class TargetArtifactType {
    COMMON, // Common stuff (does not contain platform-dependent functions)
    PLATFORM, // Artifacts for the specific Android SDK version (eg. 15, 19, 21 etc.)
    SUPPORT_V4, // Artifact for Android support-v4 library (contains some helpers for support.v4 Fragments)
    TOOLKIT; // Helpers for any other Android libraries
}

public enum class AnkoFile(
        type: Set<TargetArtifactType>,
        val shouldBeWritten: (AnkoConfiguration) -> Boolean = { true }
) : ConfigurationOption {
    INTERFACE_WORKAROUNDS_JAVA(setOf(PLATFORM)),
    LAYOUTS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    LISTENERS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    OTHER(setOf(PLATFORM)),
    OTHER_WIDGETS(setOf(PLATFORM)),
    PROPERTIES(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    SERVICES(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    SQL_PARSER_HELPERS(setOf(COMMON)),
    VIEWS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT), { it[VIEWS] || it[ConfigurationTune.HELPER_CONSTRUCTORS] });

    public val types: Set<TargetArtifactType> = type.toSet()

    public val filename: String by Delegates.lazy {
        val name = name()
        val extension = if (name.endsWith("_JAVA")) ".java" else ".kt"
        name.substringBeforeLast("_JAVA").toCamelCase() + extension
    }
}