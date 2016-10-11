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
import org.jetbrains.android.anko.utils.toCamelCase

enum class TargetArtifactType {
    COMMON, // Common stuff (does not contain platform-dependent functions)
    SQLITE, // SqLite Database helpers
    PLATFORM, // Artifacts for the specific Android SDK version (eg. 15, 19, 21 etc.)
    SUPPORT_V4, // Artifact for Android support-v4 library (contains some helpers for support.v4 Fragments)
    TOOLKIT; // Helpers for any other Android libraries
}

enum class AnkoFile(
        type: Set<TargetArtifactType>,
        val shouldBeWritten: (AnkoConfiguration) -> Boolean = { true },
        override val defaultValue: Boolean = true
) : ConfigurationKey<Boolean> {
    LAYOUTS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    LISTENERS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    PROPERTIES(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    SERVICES(setOf(PLATFORM, SUPPORT_V4, TOOLKIT)),
    SQL_PARSER_HELPERS(setOf(SQLITE)),
    VIEWS(setOf(PLATFORM, SUPPORT_V4, TOOLKIT), { it[VIEWS] || it[Tune.HELPER_CONSTRUCTORS] });

    val types: Set<TargetArtifactType> = type.toSet()

    val filename: String by lazy {
        val extension = if (name.endsWith("_JAVA")) ".java" else ".kt"
        name.substringBeforeLast("_JAVA").toCamelCase() + extension
    }
}