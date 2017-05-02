package org.jetbrains.android.anko.writer

import org.jetbrains.android.anko.config.*
import org.jetbrains.android.anko.config.AnkoFile.*
import org.jetbrains.android.anko.render.*
import org.jetbrains.android.anko.utils.toCamelCase
import java.io.File

abstract class AbstractWriter(private val renderFacade: RenderFacade): WithGeneratorContext {
    override val context: GeneratorContext
        get() = renderFacade.generationState.context

    fun write() {
        val versionType = config.artifact.type
        values().forEach { file ->
            if (config[file] && versionType in file.types) {
                write(file)
            }
        }
    }

    private fun write(file: AnkoFile): Unit = when (file) {
        AnkoFile.LAYOUTS -> writeLayouts()
        AnkoFile.LISTENERS -> writeListeners()
        AnkoFile.LISTENERS_WITH_COROUTINES -> writeCoroutineListeners()
        AnkoFile.PROPERTIES -> writeProperties()
        AnkoFile.SERVICES -> writeServices()
        AnkoFile.SQL_PARSER_HELPERS -> writeSqlParserHelpers()
        AnkoFile.VIEWS -> writeViews()
    }

    private fun writeCoroutineListeners() {
        write(AnkoFile.LISTENERS_WITH_COROUTINES, CoroutineListenerRenderer::class.java)
    }

    private fun writeLayouts() {
        val imports = Props.imports["layouts"] ?: ""
        write(AnkoFile.LAYOUTS, LayoutRenderer::class.java, imports)
    }

    private fun writeListeners() {
        write(AnkoFile.LISTENERS, ListenerRenderer::class.java)
    }

    private fun writeProperties() {
        val imports = Props.imports["properties"] ?: ""
        write(AnkoFile.PROPERTIES, PropertyRenderer::class.java, imports)
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
        val allViews = if (config[AnkoFile.VIEWS]) {
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

        val outputText = buildString {
            if (config.generatePackage && generatePackage) {
                val facadeFilename = config.artifact.name.toCamelCase('-') + subsystem.name.toLowerCase().toCamelCase()
                appendln("@file:JvmName(\"${facadeFilename}Kt\")")
                appendln("package ${config.outputPackage}\n")
            }

            if (config.generateImports) {
                if (imports.isNotEmpty()) appendln(imports)
            }

            appendln()
            append(text)
        }

        write(file, outputText)
    }

    protected abstract fun write(file: File, text: String)
}