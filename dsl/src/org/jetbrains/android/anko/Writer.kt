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

import org.jetbrains.android.anko.config
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.config.ConfigurationTune.HELPER_CONSTRUCTORS
import org.jetbrains.android.anko.config.Props
import org.jetbrains.android.anko.render.*
import java.io.Closeable
import java.io.File
import java.io.PrintWriter

class Writer(private val renderFacade: RenderFacade) {

    val config = renderFacade.config

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
        write(AnkoFile.INTERFACE_WORKAROUNDS, javaClass<InterfaceWorkaroundsRenderer>(), imports, false)
    }

    private fun writeLayouts() {
        val imports = Props.imports["layouts"] ?: ""
        write(AnkoFile.LAYOUTS, javaClass<LayoutRenderer>(), imports)
    }

    private fun writeListeners() {
        write(AnkoFile.LISTENERS, javaClass<ListenerRenderer>())
    }

    private fun writeProperties() {
        write(AnkoFile.PROPERTIES, javaClass<PropertyRenderer>())
    }

    private fun writeServices() {
        val imports = Props.imports["services"] ?: ""
        write(AnkoFile.SERVICES, javaClass<ServiceRenderer>(), imports)
    }

    private fun writeSqlParserHelpers() {
        val imports = Props.imports["sqliteparserhelpers"] ?: ""
        write(AnkoFile.SQL_PARSER_HELPERS, javaClass<SqlParserHelperRenderer>(), imports, false)
    }

    private fun writeViews() {
        val allViews = if (config[VIEWS] || config[HELPER_CONSTRUCTORS]) {
            renderFacade[javaClass<ViewRenderer>()] + renderFacade[javaClass<ViewGroupRenderer>()]
        } else ""
        val imports = Props.imports["views"] ?: ""
        write(AnkoFile.VIEWS, allViews, imports)
    }

    private fun writeStatic(subsystem: config.AnkoFile) {
        val file = File("dsl/static/src/${subsystem.filename}")
        write(subsystem, file.readText(), "", false)
    }

    private fun write(
            subsystem: AnkoFile,
            renderer: Class<out Renderer>,
            imports: String = "",
            generatePackage: Boolean = true)
    {
        write(subsystem, renderFacade[renderer], imports, generatePackage)
    }

    private fun write(subsystem: AnkoFile, text: String, imports: String = "", generatePackage: Boolean = true) {
        val file = config.getOutputFile(subsystem)

        val dir = file.getParentFile()
        if (!dir.exists()) {
            dir.mkdirs()
        }

        PrintWriter(file).useIt {
            if (config.generatePackage && generatePackage) {
                println("package ${config.outputPackage}\n")
            }

            if (config.generateImports && imports.isNotEmpty()) {
                println(imports)
                println()
            }

            print(text)
        }
    }

    private inline fun <T : Closeable, R> T.useIt(block: T.() -> R) = use { it.block() }

}