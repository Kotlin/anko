/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl

import java.io.File
import java.util.HashMap

class Variable(val name: String, val typ: String) {
    override fun toString(): String {
        return "$name:$typ"
    }
}

public enum class KoanFile(val filename: String) {
    ASYNC : KoanFile("Async.kt")
    CONTEXT_UTILS : KoanFile("ContextUtils.kt")
    CUSTOM : KoanFile("Custom.kt")
    DATABASE : KoanFile("Database.kt")
    DIALOGS : KoanFile("Dialogs.kt")
    HELPERS : KoanFile("Helpers.kt")
    INTERNALS : KoanFile("Internals.kt")
    LAYOUTS : KoanFile("Layouts.kt")
    LISTENERS : KoanFile("Listeners.kt")
    PROPERTIES : KoanFile("Properties.kt")
    SERVICES : KoanFile("Services.kt")
    SUPPORT : KoanFile("Support.kt")
    VIEWS : KoanFile("Views.kt")
}

public enum class ConfigurationTune {
    HELPER_CONSTRUCTORS
    TOP_LEVEL_DSL_ITEMS
    SIMPLE_LISTENERS
    COMPLEX_LISTENER_SETTERS
    COMPLEX_LISTENER_CLASSES
}

abstract class BaseGeneratorConfiguration {
    open val indent: String = "  "

    open val files: MutableSet<KoanFile> = hashSetOf(*KoanFile.values())
    open val tunes: MutableSet<ConfigurationTune> = hashSetOf(*ConfigurationTune.values())

    open var generateImports: Boolean = true
    open var generatePackage: Boolean = true
    open var generateMavenArtifact: Boolean = true

    abstract val outputDirectory: String
    abstract val outputPackage: String

    abstract val imports: HashMap<String, String>

    abstract val excludedClasses: Set<String>
    abstract val excludedMethods: Set<String>
    abstract val helperConstructors: Map<String, List<List<Variable>>>
    abstract val customMethodParameters: Map<String, String>

    public fun get(file: KoanFile): Boolean = files.contains(file)

    public fun get(tune: ConfigurationTune): Boolean = tunes.contains(tune)

    public abstract fun getOutputFile(subsystem: KoanFile): File
}