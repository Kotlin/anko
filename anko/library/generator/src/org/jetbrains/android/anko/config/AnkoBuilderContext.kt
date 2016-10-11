package org.jetbrains.android.anko.config

import org.jetbrains.android.anko.annotations.*
import org.jetbrains.android.anko.sources.AndroidHomeSourceProvider
import org.jetbrains.android.anko.sources.SourceManager
import org.jetbrains.android.anko.templates.MustacheTemplateProvider
import org.jetbrains.android.anko.templates.TemplateManager
import java.io.File

class AnkoBuilderContext(
        val annotationManager: AnnotationManager,
        val sourceManager: SourceManager,
        val templateManager: TemplateManager,
        val logManager: LogManager,
        val configuration: AnkoConfiguration
) {
    companion object {
        fun create(propsDir: File, logLevel: LogManager.LogLevel, config: AnkoConfiguration): AnkoBuilderContext {
            val zipFileProvider = ZipFileAnnotationProvider(File(propsDir, "kotlin-android-sdk-annotations-1.0.0.jar"))
            val directoryProvider = DirectoryAnnotationProvider(File(propsDir, "annotations"))

            val annotationManager = AnnotationManager(CompoundAnnotationProvider(
                    CachingAnnotationProvider(zipFileProvider), CachingAnnotationProvider(directoryProvider)))
            val sourceManager = SourceManager(AndroidHomeSourceProvider(23))
            val templateManager = TemplateManager(MustacheTemplateProvider(File(propsDir, "templates")))
            val logManager = LogManager(logLevel)

            return AnkoBuilderContext(annotationManager, sourceManager, templateManager, logManager, config)
        }
    }
}

interface WithContext {
    val context: AnkoBuilderContext

    val annotationManager: AnnotationManager
        get() = context.annotationManager

    val sourceManager: SourceManager
        get() = context.sourceManager

    val templateManager: TemplateManager
        get() = context.templateManager

    val log: LogManager
        get() = context.logManager

    val config: AnkoConfiguration
        get() = context.configuration
}