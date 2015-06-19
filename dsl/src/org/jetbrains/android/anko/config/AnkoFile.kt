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
import org.jetbrains.android.anko.config.AnkoFileType.*

public enum class AnkoFileType {
    COMMON, PLATFORM, SUPPORT
}

public enum class AnkoFile(
        type: Set<AnkoFileType>,
        val shouldBeWritten: (AnkoConfiguration) -> Boolean = { true }
) : ConfigurationOption {
    ASYNC(setOf(COMMON)),
    CONTEXT_UTILS(setOf(COMMON)),
    CUSTOM(setOf(COMMON)),
    DATABASE(setOf(COMMON)),
    DIALOGS(setOf(COMMON)),
    HELPERS(setOf(COMMON)),
    INTERFACE_WORKAROUNDS_JAVA(setOf(PLATFORM)),
    INTERNALS(setOf(COMMON)),
    LAYOUTS(setOf(PLATFORM)),
    LISTENERS(setOf(PLATFORM, AnkoFileType.SUPPORT)),
    LOGGER(setOf(COMMON)),
    OTHER(setOf(PLATFORM)),
    OTHER_WIDGETS(setOf(PLATFORM)),
    PROPERTIES(setOf(PLATFORM, AnkoFileType.SUPPORT)),
    SERVICES(setOf(PLATFORM, AnkoFileType.SUPPORT)),
    SQL_PARSER_HELPERS(setOf(COMMON)),
    SQL_PARSERS(setOf(COMMON)),
    SUPPORT(setOf(AnkoFileType.SUPPORT), { "support-v4" in it.version }),
    UI(setOf(COMMON)),
    VIEWS(setOf(PLATFORM, AnkoFileType.SUPPORT), { it[VIEWS] || it[ConfigurationTune.HELPER_CONSTRUCTORS] });

    public val types: Set<AnkoFileType> = type.toSet()

    public val filename: String by Delegates.lazy {
        val name = name()
        val extension = if (name.endsWith("_JAVA")) ".java" else ".kt"
        name.substringBeforeLast("_JAVA").toCamelCase() + extension
    }
}