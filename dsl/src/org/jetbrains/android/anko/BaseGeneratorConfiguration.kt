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

package org.jetbrains.android.anko

import java.io.File
import java.util.HashMap

abstract class Configurable(val config: BaseGeneratorConfiguration)

class Variable(val name: String, val type: String) {
    override fun toString(): String {
        return "$name:$type"
    }
}

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

public enum class ConfigurationTune {
    HELPER_CONSTRUCTORS
    TOP_LEVEL_DSL_ITEMS
    SIMPLE_LISTENERS
    COMPLEX_LISTENER_SETTERS
    COMPLEX_LISTENER_CLASSES
}

fun <T> Configurable.generate(vararg file: AnkoFile, init: () -> Collection<T>) : Collection<T> {
    return if (file.any { config[it] }) init() else listOf()
}

fun <T> Configurable.generate(vararg tune: ConfigurationTune, init: () -> Collection<T>) : Collection<T> {
    return if (tune.any { config[it] }) init() else listOf()
}

abstract class BaseGeneratorConfiguration {
    open val indent: String = "  "

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

    public fun get(file: AnkoFile): Boolean = files.contains(file)

    public fun get(tune: ConfigurationTune): Boolean = tunes.contains(tune)

    public abstract fun getOutputFile(ankoFile: AnkoFile): File
}