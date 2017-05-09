/*
 * Copyright 2016 JetBrains s.r.o.
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

package org.jetbrains.android.anko.annotations

import kotlinx.dom.childElements
import org.jetbrains.android.anko.utils.getPackageName
import org.w3c.dom.Document
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

class AnnotationManager(private val provider: AnnotationProvider) {
    fun findExternalAnnotations(declarationFqName: String): Set<ExternalAnnotation> {
        val packageName = getPackageName(declarationFqName.substringBefore(' '))
        val annotations = provider.getExternalAnnotations(packageName)
        return annotations[declarationFqName] ?: emptySet()
    }

    fun hasAnnotation(declarationFqName: String, annotation: ExternalAnnotation): Boolean {
        return annotation in findExternalAnnotations(declarationFqName)
    }
}

fun parseAnnotations(doc: Document): Map<String, Set<ExternalAnnotation>> {
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
        "org.jetbrains.anko.GenerateLayout" -> ExternalAnnotation.GenerateLayout
        "org.jetbrains.anko.GenerateView" -> ExternalAnnotation.GenerateView
        else -> null
    }
}

internal fun parseXml(xmlText: String): Document {
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    val inputSource = InputSource(StringReader(xmlText))
    return builder.parse(inputSource)
}