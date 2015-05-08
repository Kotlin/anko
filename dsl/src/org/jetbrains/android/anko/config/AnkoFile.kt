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

public enum class AnkoFile(val filename: String) {
    ASYNC : AnkoFile("Async.kt")
    CONTEXT_UTILS : AnkoFile("ContextUtils.kt")
    CUSTOM : AnkoFile("Custom.kt")
    DATABASE : AnkoFile("Database.kt")
    DIALOGS : AnkoFile("Dialogs.kt")
    HELPERS : AnkoFile("Helpers.kt")
    INTERFACE_WORKAROUNDS : AnkoFile("InterfaceWorkarounds.java")
    INTERNALS : AnkoFile("Internals.kt")
    LAYOUTS : AnkoFile("Layouts.kt")
    LISTENERS : AnkoFile("Listeners.kt")
    LOGGER : AnkoFile("Logger.kt")
    OTHER : AnkoFile("Other.kt")
    PROPERTIES : AnkoFile("Properties.kt")
    SERVICES : AnkoFile("Services.kt")
    SQL_PARSER_HELPERS : AnkoFile("SqlParserHelpers.kt")
    SQL_PARSERS : AnkoFile("SqlParsers.kt")
    SUPPORT : AnkoFile("Support.kt")
    VIEWS : AnkoFile("Views.kt")
}