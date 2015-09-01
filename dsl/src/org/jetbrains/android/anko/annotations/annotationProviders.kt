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

package org.jetbrains.android.anko.annotations

import java.io.File
import java.util.zip.ZipFile

public enum class ExternalAnnotation {
    NotNull,
    GenerateLayout
}

public interface AnnotationProvider {
    fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>>
}

public interface BulkAnnotationProvider : AnnotationProvider {
    override fun getExternalAnnotations(packageName: String): Map<String, Set<ExternalAnnotation>> {
        return mapOf()
    }
}

public class ZipFileAnnotationProvider(val zipFile: File) : AnnotationProvider {
    private val archive: ZipFile by lazy { ZipFile(zipFile) }

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