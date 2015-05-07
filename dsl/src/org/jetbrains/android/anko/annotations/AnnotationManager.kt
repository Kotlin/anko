package org.jetbrains.android.anko.annotations

import org.jetbrains.android.anko.getPackageName
import org.w3c.dom.Document
import org.xml.sax.InputSource
import java.io.File
import java.io.StringReader
import java.util.zip.ZipFile
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.dom.childElements
import kotlin.dom.childNodes
import kotlin.dom.documentElement
import kotlin.properties.Delegates

public enum class ExternalAnnotation {
    NotNull
}

public trait AnnotationProvider {
    fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>>
}

public trait BulkAnnotationProvider : AnnotationProvider {
    override fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>> {
        return mapOf()
    }
}

public class ZipFileAnnotationProvider(val zipFile: File) : AnnotationProvider {
    private val archive: ZipFile by Delegates.lazy { ZipFile(zipFile) }

    override fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>> {
        val entryName = packageName.replace('.', '/') + "/annotations.xml"
        val entry = archive.getEntry(entryName) ?: return mapOf()

        return archive.getInputStream(entry).reader().use {
            parseAnnotations(parseXml(it.readText()))
        }
    }
}

public class DirectoryAnnotationProvider(val directory: File) : AnnotationProvider {

    override fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>> {
        val annotationFile = File(directory, packageName.replace('.', '/') + "/annotations.xml")
        if (!annotationFile.exists()) return mapOf()
        return parseAnnotations(parseXml(annotationFile.readText()))
    }

}

public class CachingAnnotationProvider(val underlyingProvider: AnnotationProvider) : AnnotationProvider {
    private val cache = hashMapOf<String, Map<String, Set<ExternalAnnotation>>>()

    override fun getExternalAnnotations(packageName: String) = cache.getOrPut(packageName) {
        underlyingProvider.getExternalAnnotations(packageName)
    }
}

public class CompoundAnnotationProvider(vararg providers: AnnotationProvider) : AnnotationProvider {

    private val providers = providers

    override fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>> {
        val providerAnnotations = providers.map { it.getExternalAnnotations(packageName) }

        val map = hashMapOf<String, Set<ExternalAnnotation>>()

        for (providerAnnotationMap in providerAnnotations) {
            for ((key, value) in providerAnnotationMap) {
                val existingAnnotations = map.get(key)

                if (existingAnnotations == null) map.put(key, value)
                else map.put(key, (value + existingAnnotations).toSet())
            }
        }

        return map
    }
}

public class AnnotationManager(private val provider: AnnotationProvider) {
    public fun findAnnotationsFor(q: String): Set<ExternalAnnotation> {
        var packageName = getPackageName(q.substringBefore(' '))
        val annotations = provider.getExternalAnnotations(packageName)
        return annotations.get(q) ?: setOf()
    }
}

public fun parseAnnotations(doc: Document): Map<String, Set<ExternalAnnotation>> {
    val map = hashMapOf<String, Set<ExternalAnnotation>>()

    for (element in doc.documentElement.childElements("item")) {
        val annotations = element.childElements("annotation")
                .map { parseAnnotation(it.getAttribute("name")) }
                .filterNotNull()
                .toSet()

        map.put(element.getAttribute("name"), annotations)
    }

    return map
}

private fun parseAnnotation(fqName: String): ExternalAnnotation? {
    return when (fqName) {
        "org.jetbrains.annotations.NotNull" -> ExternalAnnotation.NotNull
        else -> null
    }
}

private fun parseXml(xmlText: String): Document {
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    val inputSource = InputSource(StringReader(xmlText))
    return builder.parse(inputSource)
}