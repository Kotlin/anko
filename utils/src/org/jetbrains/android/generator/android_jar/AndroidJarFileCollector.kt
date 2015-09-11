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

package org.jetbrains.android.generator.android_jar

import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipFile

public fun main(args: Array<String>): Unit = AndroidJarCollector().collect()

class AndroidJarCollector {
    private companion object {
        private val REQUIRED_PLATFORM_VERSIONS = arrayOf(15, 19, 21, 23)

        private val SUPPORT_PACKAGES_VERSION = "23.0.0"
        private val SUPPORT_LIBRARIES = arrayOf("support-v4",
                                                "appcompat-v7",
                                                "cardview-v7",
                                                "gridlayout-v7",
                                                "recyclerview-v7",
                                                "design",
                                                "percent")

        private val LIBRARY_DEPENDENCIES = mapOf(
                "gridlayout-v7" to listOf("support-v4"),
                "appcompat-v7" to listOf("support-v4"),
                "recyclerview-v7" to listOf("support-v4", "appcompat-v7"),
                "design" to listOf("support-v4", "appcompat-v7"),
                "percent" to listOf("support-v4"))

        private val ORIGINAL_DIR = File("workdir/original")
        private val ANDROID_SDK = File("lib/android-sdk")
        private val PLATFORMS_DIR = File(ANDROID_SDK, "platforms")
        private val SUPPORT_PACKAGES_DIR = File(ANDROID_SDK, "extras/android/m2repository/com/android/support")

        private val PLATFORM_PREFIX = "platform."

        private val INDENT = "    "
    }

    fun collect() {
        if (ORIGINAL_DIR.exists()) {
            println("$ORIGINAL_DIR already exist. Aborting")
            return
        }

        createDirs()

        val supportFiles = findSupportFiles()
        val supportFilesWithDependencies = supportFiles.map { supportFile ->
            val dependencies = LIBRARY_DEPENDENCIES.entrySet()
                    .firstOrNull { supportFile.name.startsWith(it.key) }?.getValue()
                    ?.mapTo(hashSetOf()) { name -> SupportFile(supportFiles.first { it.name.startsWith(name) }, true) }
                    ?: hashSetOf<SupportFile>()

            dependencies += SupportFile(supportFile, false)
            dependencies as Set<SupportFile>
        }

        for ((index, version) in REQUIRED_PLATFORM_VERSIONS.sortedByDescending { it }.withIndex()) {
            println("Processing version '${version}':")

            val versionDir = File(ORIGINAL_DIR, "sdk$version")
            processVersion(versionDir, version, false, emptySet())

            if (index == 0) {
                // Generate common artifact
                println("Processing version 'common':")
                processVersion(File(ORIGINAL_DIR, "common"), version, false, emptySet())

                // Generate toolkit artifacts for this platform
                supportFilesWithDependencies.forEach {
                    val versionSuffix = it.first { !it.platformFile }.file.name.substringBeforeLast('-')
                    println("Processing version '$version-$versionSuffix':")

                    val supportVersionDir = File(ORIGINAL_DIR, "$versionSuffix")
                    processVersion(supportVersionDir, version, true, it)
                }
            }
        }
        println("Complete.")
    }

    private fun processVersion(versionDir: File, versionNumber: Int, toolkit: Boolean, toolkitFiles: Set<SupportFile>) {
        fun log(message: String) = println("$INDENT$message")

        val platformDir = getPlatformDirectory(versionNumber)

        log("android")

        val androidJar = getAndroidJar(platformDir)
        androidJar.copyTo(File(versionDir, PLATFORM_PREFIX + androidJar.name))

        File(versionDir, "version.txt").writeText(versionNumber.toString())

        if (toolkit) {
            toolkitFiles.forEach {
                val (file, platformFile) = it
                val platformPrefix = if (platformFile) PLATFORM_PREFIX else ""

                log(file.nameWithoutExtension)

                when (file.extension.toLowerCase()) {
                    "aar" -> extractAarJars(file, versionDir, platformPrefix)
                    "jar" -> file.copyTo(File(versionDir, file.name))
                    else -> throw CollectorException("Unknown file type")
                }
            }
        }
    }
    
    private fun extractAarJars(aar: File, destinationDir: File, platformPrefix: String) {
        val aarName = aar.name.substringBeforeLast('.')
        
        ZipFile(aar).use { zip ->
            val entries = zip.entries()
            var entry = entries.nextElement()
            while (entry != null) {
                if (entry.name.toLowerCase().endsWith(".jar")) {
                    val rawName = entry.name.substringAfterLast('/')
                    val name = platformPrefix + (if (rawName == "classes.jar") "$aarName.jar" else "$aarName-$rawName")

                    FileOutputStream(File(destinationDir, name)).use { fos ->
                        zip.getInputStream(entry).copyTo(fos)
                    }
                }
                entry = if (entries.hasMoreElements()) entries.nextElement() else null
            }
        }
    }

    private fun getPlatformDirectory(versionNumber: Int): File {
        val platformDirectory = File(PLATFORMS_DIR, "android-$versionNumber")
        if (!platformDirectory.exists() || !platformDirectory.isDirectory) {
            throw CollectorException("Android SDK platform $versionNumber not found")
        }
        return platformDirectory
    }

    private fun getAndroidJar(platformDir: File): File {
        val androidJar = File(platformDir, "android.jar")
        if (!androidJar.exists()) {
            throw CollectorException("$androidJar does not exist")
        }
        return androidJar
    }

    private fun createDirs() {
        File("workdir/original").mkdirs()
        File("workdir/temp").mkdirs()
    }

    private fun findSupportFiles(): List<File> {
        return SUPPORT_LIBRARIES.map { lib ->
            val dir = File(SUPPORT_PACKAGES_DIR, "$lib/$SUPPORT_PACKAGES_VERSION")
            val aar = File(dir, "$lib-$SUPPORT_PACKAGES_VERSION.aar")
            val jar = File(dir, "$lib-$SUPPORT_PACKAGES_VERSION.jar")
            if (aar.exists()) aar else if (jar.exists()) jar else throw CollectorException("$jar not found")
        }
    }

    private fun <R> ZipFile.use(block: (ZipFile) -> R): R {
        var closed = false
        try {
            return block(this)
        } catch (e: Exception) {
            closed = true
            try {
                this.close()
            }
            catch (closeException: Exception) {}
            throw e
        } finally {
            if (!closed) {
                this.close()
            }
        }
    }
    
}

private class CollectorException(message: String) : RuntimeException(message)

private data class SupportFile(val file: File, val platformFile: Boolean)