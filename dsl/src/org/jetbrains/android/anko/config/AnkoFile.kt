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

public enum class AnkoFile(val filename: String) : ConfigurationOption {
    ASYNC("Async.kt"),
    CONTEXT_UTILS("ContextUtils.kt"),
    CUSTOM("Custom.kt"),
    DATABASE("Database.kt"),
    DIALOGS("Dialogs.kt"),
    HELPERS("Helpers.kt"),
    INTERFACE_WORKAROUNDS("InterfaceWorkarounds.java"),
    INTERNALS("Internals.kt"),
    LAYOUTS("Layouts.kt"),
    LISTENERS("Listeners.kt"),
    LOGGER("Logger.kt"),
    OTHER("Other.kt"),
    OTHER_WIDGETS("OtherWidgets.kt"),
    PROPERTIES("Properties.kt"),
    SERVICES("Services.kt"),
    SQL_PARSER_HELPERS("SqlParserHelpers.kt"),
    SQL_PARSERS("SqlParsers.kt"),
    SUPPORT("Support.kt"),
    VIEWS("Views.kt")
}