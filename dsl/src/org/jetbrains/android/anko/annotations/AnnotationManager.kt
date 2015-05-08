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