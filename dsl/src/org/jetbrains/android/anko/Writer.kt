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

import org.jetbrains.android.anko
import org.jetbrains.android.anko.config
import org.jetbrains.android.anko.config.AnkoFile
import java.io.PrintWriter
import java.io.File
import java.util.ArrayList
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.config.ConfigurationTune.*
import org.jetbrains.android.anko.config.Props
import org.jetbrains.android.anko.render.RenderFacade

class Writer(private val renderer: RenderFacade) {

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
            LOGGER,
            OTHER,
            OTHER_WIDGETS,
            SQL_PARSERS,
            SUPPORT
        ).forEach { if (config[it]) writeStatic(it) }

        setOf(
            LAYOUTS to ::writeLayouts,
            LISTENERS to ::writeListeners,
            PROPERTIES to ::writeProperties,
            SERVICES to ::writeServices,
            SQL_PARSER_HELPERS to ::writeSqlParserHelpers
        ).forEach { if (config[it.first]) it.second() }

        if (config[VIEWS] || config[HELPER_CONSTRUCTORS])
            writeViews()

        if (config[INTERFACE_WORKAROUNDS])
            writeInterfaceWorkarounds()
    }

    fun writeInterfaceWorkarounds() {
        val imports = "package ${config.outputPackage}.workarounds;"
        writeToFile(config.getOutputFile(AnkoFile.INTERFACE_WORKAROUNDS), renderer.interfaceWorkarounds, imports, false)
    }

    private fun writeLayouts() {
        val imports = Props.imports["layouts"] ?: ""
        writeToFile(config.getOutputFile(AnkoFile.LAYOUTS), renderer.layouts, imports)
    }

    private fun writeListeners() {
        writeToFile(config.getOutputFile(AnkoFile.LISTENERS), renderer.listeners)
    }

    private fun writeProperties() {
        writeToFile(config.getOutputFile(AnkoFile.PROPERTIES), renderer.properties)
    }

    private fun writeServices() {
        val imports = Props.imports["services"] ?: ""
        writeToFile(config.getOutputFile(AnkoFile.SERVICES), renderer.services, imports)
    }

    private fun writeSqlParserHelpers() {
        val imports = Props.imports["sqliteparserhelpers"] ?: ""
        writeToFile(config.getOutputFile(AnkoFile.SQL_PARSER_HELPERS), renderer.sqLiteParserHelpers, imports, false)
    }

    private fun writeViews() {
        val allViews = if (config[VIEWS] || config[HELPER_CONSTRUCTORS]) renderer.views + renderer.viewGroups else ""
        val imports = Props.imports["views"] ?: ""
        writeToFile(config.getOutputFile(AnkoFile.VIEWS), allViews, imports)
    }

    private fun writeStatic(subsystem: config.AnkoFile) {
        val file = File("dsl/static/src/${subsystem.filename}")
        writeToFile(config.getOutputFile(subsystem), file.readText(), "", false)
    }

    private fun writeToFile(file: File, text: String, imports: String = "", generatePackage: Boolean = true) {
        val dir = file.getParentFile()
        if (!dir.exists())
            dir.mkdirs()

        val writer = PrintWriter(file)
        if (config.generatePackage && generatePackage) {
            writer.println("package ${config.outputPackage}\n")
        }
        if (config.generateImports && imports.isNotEmpty()) {
            writer.println(imports)
            writer.println()
        }
        writer.println(text)
        writer.close()
    }

}