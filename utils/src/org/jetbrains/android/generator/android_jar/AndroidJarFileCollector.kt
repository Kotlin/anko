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

import java.io.*
import org.jetbrains.android.anko.utils.*
import java.util.zip.*
import java.util.regex.*

public fun main(args: Array<String>): Unit = AndroidJarCollector.collect()

object AndroidJarCollector {
    private val REQUIRED_VERSIONS = arrayOf("15", "15s", "19", "19s", "21", "21s")
    private val SUPPORT_VERSION = "22.1.1"
    private val VERSIONS = File("workdir/original").listFiles(AndroidVersionDirectoryFilter())

    fun check(): Boolean {
        if (VERSIONS == null || VERSIONS.isEmpty()) return false

        for (version in REQUIRED_VERSIONS) {
            if (!VERSIONS.any { it.name == version }) return false
        }

        for (version in VERSIONS) {
            val androidJarFile = File(version, "android.jar")
            val support = version.name.endsWith("s")

            fun hasSupport(): Boolean {
                arrayOf("support-v4", "appcompat-v7").forEach { filename ->
                    if (version.listFiles { it.name.startsWith(filename) }?.isEmpty() ?: true) return false
                }
                return true
            }

            if (!androidJarFile.exists()) return false
            if (support && !hasSupport()) return false
        }

        return true
    }

    fun collect() {
        if (check()) {
            println("All required files exist. Aborting")
            return
        }

        REQUIRED_VERSIONS.forEach { File("workdir/original/$it/").mkdirs() }
        File("workdir/temp").mkdirs()

        val androidSdk = File("lib/android-sdk")
        val platformsDir = File(androidSdk, "platforms")
        val supportV4Dir = File(androidSdk, "extras/android/m2repository/com/android/support/support-v4/$SUPPORT_VERSION")
        val supportV4Aar = supportV4Dir.listFiles { it.extension == "aar" }?.firstOrNull()

        val appCompatV7Dir = File(androidSdk, "extras/android/m2repository/com/android/support/appcompat-v7/$SUPPORT_VERSION")
        val appCompatV7Aar = appCompatV7Dir.listFiles { it.extension == "aar" }?.firstOrNull()

        if (!platformsDir.exists()) throw RuntimeException("Platform directory was not found")
        if (supportV4Aar == null || !supportV4Aar.exists()) throw RuntimeException("support-v4 directory was not found")
        if (appCompatV7Aar == null || !appCompatV7Aar.exists()) throw RuntimeException("appcompat-v7 directory was not found")

        for (version in REQUIRED_VERSIONS) {
            print("Processing version ${version}:")
            val versionDir = File("workdir/original", version)

            val support = version.endsWith("s")
            val versionNumber = version.replace("s", "")

            val platformN = File(platformsDir, "android-$versionNumber")
            if (!platformN.exists() || !platformN.isDirectory()) {
                throw RuntimeException("Android SDK platform $versionNumber not found")
            }

            print(" android...")
            val androidJar = File(platformN, "android.jar")
            assert(androidJar.exists())
            androidJar.copyTo(File(versionDir, androidJar.name))

            if (support) {
                print(" support-v4...")
                arrayOf(supportV4Aar, appCompatV7Aar).forEach { aarFile ->
                    val aarName = aarFile.name.substringBeforeLast('.')
                    ZipFile(aarFile).use { zip ->
                        val entries = zip.entries()
                        var entry = entries.nextElement()
                        while (entry != null) {
                            if (entry.getName().toLowerCase().endsWith(".jar")) {
                                val rawName = entry.getName().substringAfterLast('/')
                                val name = if (rawName == "classes.jar") "$aarName.jar" else "$aarName-$rawName"

                                FileOutputStream(File(versionDir, name)).use { fos ->
                                    zip.getInputStream(entry).copyTo(fos)
                                }
                            }
                            entry = if (entries.hasMoreElements()) entries.nextElement() else null
                        }
                    }
                }
            }

            println(" done.")
        }
        println("Complete.")
    }

    private inline fun <R> ZipFile.use(block: (ZipFile) -> R): R {
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