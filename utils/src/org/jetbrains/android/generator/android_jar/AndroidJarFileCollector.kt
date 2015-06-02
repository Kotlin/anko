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

import org.jetbrains.android.anko.utils.AndroidVersionDirectoryFilter
import java.io.File
import java.io.FileOutputStream
import java.util.*
import java.util.regex.Pattern
import java.util.zip.ZipFile

public fun main(args: Array<String>): Unit = AndroidJarCollector.collect()

object AndroidJarCollector {
    private val ANDROID_HOME = System.getenv().get("ANDROID_HOME") ?: ""

    private val REQUIRED_VERSIONS = arrayOf("15", "15s", "19", "19s", "21", "21s")
    private val VERSIONS = File("workdir/original").listFiles(AndroidVersionDirectoryFilter())

    private val SUPPORT_LIBS = arrayOf(
            "appcompat-v7",
            "cardview-v7",
            "design",
            "recyclerview-v7",
            "support-v4"
    )

    fun check(): Boolean {
        if (VERSIONS == null || VERSIONS.isEmpty()) return false

        for (version in REQUIRED_VERSIONS) {
            if (!VERSIONS.any { it.name == version }) return false
        }

        for (version in VERSIONS) {
            val androidJarFile = File(version, "android.jar")
            val support = version.name.endsWith("s")

            fun hasSupport(): Boolean {
                SUPPORT_LIBS.forEach { filename ->
                    if (version.listFiles { it.name.startsWith(filename) }?.isEmpty() ?: true) return false
                }
                return true
            }

            if (!androidJarFile.exists()) return false
            if (support && !hasSupport()) return false
        }

        return true
    }

    fun getLastSupportDirectory(supportV4: File): File? {
        val pattern = Pattern.compile("(\\d+).(\\d+).(\\d+)")
        return supportV4.listFiles()
                ?.filter { pattern.matcher(it.name).matches() }
                ?.sortDescendingBy {
                    val matcher = pattern.matcher(it.name)
                    matcher.find()
                    matcher.group(1).toInt() * 10000 + matcher.group(2).toInt() * 100 + matcher.group(3).toInt()
                }
                ?.firstOrNull()
    }

    fun collect() {
        if (check()) {
            println("All required files exist. Aborting")
            return
        }

        REQUIRED_VERSIONS.forEach { File("workdir/original/$it/").mkdirs() }
        File("workdir/temp").mkdirs()

        if (ANDROID_HOME.isEmpty()) throw RuntimeException("ANDROID_HOME environment variable is not set")

        val platformsDir = checkAarExists("Platform", File(ANDROID_HOME, "platforms"))

        val supportAars = HashMap<String, File>(SUPPORT_LIBS.size())
        for (lib in SUPPORT_LIBS) {
            val dir = File(ANDROID_HOME, "extras/android/m2repository/com/android/support/${lib}/")
            val last = getLastSupportDirectory(dir)
            val aar = checkAarExists(lib, last?.listFiles { it.extension == "aar" }?.firstOrNull())
            supportAars.put(lib, aar)
        }

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
                print(" support...")
                supportAars.values().forEach { aarFile ->
                    val aarName = aarFile!!.name.substringBeforeLast('.')
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

    suppress("nothing_to_inline")
    private inline fun checkAarExists(dir: String, file: File?): File {
        return if (!(file == null || !file.exists())) {
            file
        } else {
            throw RuntimeException("${dir} directory was not found")
        }
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
