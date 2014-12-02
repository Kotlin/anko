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

import java.io.PrintWriter
import java.io.File
import java.util.ArrayList
import java.nio.charset.StandardCharsets
import org.jetbrains.android.dsl.KoanFile.*
import org.jetbrains.android.dsl.ConfigurationTune.*

class Writer(private val renderer: Renderer) {

    val config = renderer.config

    fun write() {
        sortedSetOf(
            ASYNC,
            CONTEXT_UTILS,
            CUSTOM,
            DATABASE,
            DIALOGS,
            HELPERS,
            INTERNALS,
            SUPPORT
        ).forEach { if (config[it]) writeStatic(it) }

        setOf(
            LAYOUTS to ::writeLayouts,
            LISTENERS to ::writeListeners,
            PROPERTIES to ::writeProperties,
            SERVICES to ::writeServices
        ).forEach { if (config[it.first]) it.second() }

        if (config[VIEWS] || config[HELPER_CONSTRUCTORS])
            writeViews()
    }

    private fun writeLayouts() {
        val imports = Props.imports["layouts"] ?: ""
        writeToFile(config.getOutputFile(KoanFile.LAYOUTS), renderer.layouts, imports)
    }

    private fun writeListeners() {
        val allListeners = ArrayList<String>()

        array(
            SIMPLE_LISTENERS to renderer.simpleListeners,
            COMPLEX_LISTENER_CLASSES to renderer.complexListenerClasses,
            COMPLEX_LISTENER_SETTERS to renderer.complexListenerSetters
        ).forEach { if (config[it.first]) allListeners.addAll(it.second) }

        if (allListeners.isNotEmpty())
            writeToFile(config.getOutputFile(KoanFile.LISTENERS), allListeners)
    }

    private fun writeProperties() {
        writeToFile(config.getOutputFile(KoanFile.PROPERTIES), renderer.properties)
    }

    private fun writeServices() {
        val imports = Props.imports["services"] ?: ""
        writeToFile(config.getOutputFile(KoanFile.SERVICES), renderer.services, imports)
    }

    private fun writeViews() {
        val allViews = arrayListOf<String>()

        if (config[VIEWS]) {
            allViews.addAll(renderer.views)
            allViews.addAll(renderer.viewGroups)
        }

        if (config[HELPER_CONSTRUCTORS])
            allViews.addAll(renderer.helperConstructors)

        val imports = Props.imports["views"] ?: ""
        writeToFile(config.getOutputFile(KoanFile.VIEWS), allViews, imports)
    }

    private fun writeStatic(subsystem: KoanFile) {
        val file = File("props/static/src/${subsystem.filename}")
        val contents = file.readLines("UTF-8")
        writeToFile(config.getOutputFile(subsystem), contents, "", false)
    }

    private fun writeToFile(file: File, text: Collection<String>, imports: String = "", generatePackage: Boolean = true) {
        val writer = PrintWriter(file)
        if (config.generatePackage && generatePackage) {
            writer.println("package ${config.outputPackage}\n")
        }
        if (config.generateImports && imports.isNotEmpty()) {
            writer.println(imports)
            writer.println()
        }
        for (line in text) {
            writer.println(line)
        }
        writer.close()
    }

}