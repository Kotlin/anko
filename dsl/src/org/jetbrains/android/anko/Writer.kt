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

import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.config.ConfigurationTune.HELPER_CONSTRUCTORS
import org.jetbrains.android.anko.config.Props
import org.jetbrains.android.anko.config.TargetArtifactType
import org.jetbrains.android.anko.render.*
import org.jetbrains.android.anko.utils.toCamelCase
import java.io.Closeable
import java.io.File
import java.io.PrintWriter

class Writer(private val renderFacade: RenderFacade) {
    private val config = renderFacade.config

    fun write() {
        val versionType = config.getTargetArtifactType()
        AnkoFile.values().forEach { file ->
            if (config[file] && versionType in file.types && file.shouldBeWritten(config)) {
                write(file)
            }
        }

        val staticFilesDir = File("dsl/static/src", when (versionType) {
            TargetArtifactType.PLATFORM -> "platform"
            else -> config.version.toCamelCase('-', firstCapital = false)
        })

        if (config.generateStaticFiles) {
            staticFilesDir.listFiles()?.forEach { file ->
                if (file.isFile) {
                    file.copyTo(File(config.sourceOutputDirectory, file.name))
                }
            }
        }
    }

    private fun write(file: AnkoFile): Unit = when (file) {
        INTERFACE_WORKAROUNDS_JAVA -> writeInterfaceWorkarounds()
        LAYOUTS -> writeLayouts()
        LISTENERS -> writeListeners()
        PROPERTIES -> writeProperties()
        SERVICES -> writeServices()
        SQL_PARSER_HELPERS -> writeSqlParserHelpers()
        VIEWS -> writeViews()
    }

    fun writeInterfaceWorkarounds() {
        val imports = "package ${config.outputPackage}.workarounds;"
        write(AnkoFile.INTERFACE_WORKAROUNDS_JAVA, InterfaceWorkaroundsRenderer::class.java, imports, false)
    }

    private fun writeLayouts() {
        val imports = Props.imports["layouts"] ?: ""
        write(AnkoFile.LAYOUTS, LayoutRenderer::class.java, imports)
    }

    private fun writeListeners() {
        write(AnkoFile.LISTENERS, ListenerRenderer::class.java)
    }

    private fun writeProperties() {
        write(AnkoFile.PROPERTIES, PropertyRenderer::class.java)
    }

    private fun writeServices() {
        val imports = Props.imports["services"] ?: ""
        write(AnkoFile.SERVICES, ServiceRenderer::class.java, imports)
    }

    private fun writeSqlParserHelpers() {
        val imports = Props.imports["sqliteparserhelpers"] ?: ""
        write(AnkoFile.SQL_PARSER_HELPERS, SqlParserHelperRenderer::class.java, imports, false)
    }

    private fun writeViews() {
        val allViews = if (config[VIEWS] || config[HELPER_CONSTRUCTORS]) {
            renderFacade[ViewRenderer::class.java] + renderFacade[ViewGroupRenderer::class.java]
        } else ""
        val imports = Props.imports["views"] ?: ""
        write(AnkoFile.VIEWS, allViews, imports)
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
        if (text.trim().isEmpty()) return

        val file = config.getOutputFile(subsystem)

        val dir = file.parentFile
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