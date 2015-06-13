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

import kotlin.properties.Delegates

public enum class AnkoFile : ConfigurationOption {
    ASYNC,
    CONTEXT_UTILS,
    CUSTOM,
    DATABASE,
    DIALOGS,
    HELPERS,
    INTERFACE_WORKAROUNDS_JAVA,
    INTERNALS,
    LAYOUTS,
    LISTENERS,
    LOGGER,
    OTHER,
    OTHER_WIDGETS,
    PROPERTIES,
    SERVICES,
    SQL_PARSER_HELPERS,
    SQL_PARSERS,
    SUPPORT,
    VIEWS;

    public val filename: String by Delegates.lazy {
        val name = name()
        val extension = if (name.endsWith("_JAVA")) ".java" else ".kt"
        name.substringBeforeLast("_JAVA").toCamelCase() + extension
    }

    private companion object {
        private fun String.toCamelCase(): String {
            val builder = StringBuilder()
            var capitalFlag = true
            for (c in this) {
                when (c) {
                    '_' -> capitalFlag = true
                    else -> {
                        builder.append(if (capitalFlag) Character.toUpperCase(c) else Character.toLowerCase(c))
                        capitalFlag = false
                    }
                }
            }
            return builder.toString()
        }
    }
}