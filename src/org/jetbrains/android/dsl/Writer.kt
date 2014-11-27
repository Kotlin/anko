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
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import org.jetbrains.android.dsl.KoanFile.*
import org.jetbrains.android.dsl.ConfigurationTune.*

class Writer(private val renderer: Renderer) {

    val props = renderer.props

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
        ).forEach { if (props[it]) writeStatic(it) }

        setOf(
            LAYOUTS to ::writeLayouts,
            LISTENERS to ::writeListeners,
            PROPERTIES to ::writeProperties,
            SERVICES to ::writeServices
        ).forEach { if (props[it.first]) it.second() }

        if (props[VIEWS] || props[HELPER_CONSTRUCTORS])
            writeViews()
    }

    private fun writeLayouts() {
        val imports = props.imports["layouts"] ?: ""
        writeToFile(props.getOutputFile(KoanFile.LAYOUTS), renderer.layouts, imports)
    }

    private fun writeListeners() {
        val allListeners = ArrayList<String>()

        array(
            SIMPLE_LISTENERS to renderer.simpleListeners,
            COMPLEX_LISTENER_CLASSES to renderer.complexListenerClasses,
            COMPLEX_LISTENER_SETTERS to renderer.complexListenerSetters
        ).forEach { if (props[it.first]) allListeners.addAll(it.second) }

        if (allListeners.isNotEmpty())
            writeToFile(props.getOutputFile(KoanFile.LISTENERS), allListeners)
    }

    private fun writeProperties() {
        writeToFile(props.getOutputFile(KoanFile.PROPERTIES), renderer.properties)
    }

    private fun writeServices() {
        val imports = props.imports["services"] ?: ""
        writeToFile(props.getOutputFile(KoanFile.SERVICES), renderer.services, imports)
    }

    private fun writeViews() {
        val allViews = arrayListOf<String>()

        if (props[VIEWS]) {
            allViews.addAll(renderer.views)
            allViews.addAll(renderer.viewGroups)
        }

        if (props[HELPER_CONSTRUCTORS])
            allViews.addAll(renderer.helperConstructors)

        val imports = props.imports["views"] ?: ""
        writeToFile(props.getOutputFile(KoanFile.VIEWS), allViews, imports)
    }

    private fun writeStatic(subsystem: KoanFile) {
        val filename = "props/static/src/${subsystem.filename}"
        val contents = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8)
        writeToFile(props.getOutputFile(subsystem), contents, "", false)
    }

    private fun writeToFile(file: File, text: List<String>, imports: String = "", generatePackage: Boolean = true) {
        val writer = PrintWriter(file)
        if (props.generatePackage && generatePackage) {
            writer.println("package ${props.outputPackage}\n")
        }
        if (props.generateImports && imports.isNotEmpty()) {
            writer.println(imports)
            writer.println()
        }
        for (line in text) {
            writer.println(line)
        }
        writer.close()
    }

}