package org.jetbrains.android.generator.android_jar

import java.io.*
import org.jetbrains.android.anko.utils.*
import java.util.zip.*
import java.util.regex.*

public fun main(args: Array<String>): Unit = AndroidJarCollector.collect()

object AndroidJarCollector {
    private val ANDROID_HOME = System.getenv().get("ANDROID_HOME") ?: ""

    private val REQUIRED_VERSIONS = array("15", "15s", "19", "19s", "21", "21s")
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
                array("support-v4", "appcompat-v7").forEach { filename ->
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

        val platformsDir = File(ANDROID_HOME, "platforms")
        val supportV4Dir = File(ANDROID_HOME, "extras/android/m2repository/com/android/support/support-v4/")
        val lastSupportV4Dir = getLastSupportDirectory(supportV4Dir)
        val lastSupportV4Aar = lastSupportV4Dir?.listFiles { it.extension == "aar" }?.firstOrNull()

        val appCompatV7Dir = File(ANDROID_HOME, "extras/android/m2repository/com/android/support/appcompat-v7/")
        val lastAppCompatV7Dir = getLastSupportDirectory(appCompatV7Dir)
        val lastAppCompatV7Aar = lastAppCompatV7Dir?.listFiles { it.extension == "aar" }?.firstOrNull()

        if (!platformsDir.exists()) throw RuntimeException("Platform directory was not found")
        if (lastSupportV4Aar == null || !lastSupportV4Aar.exists()) throw RuntimeException("support-v4 directory was not found")
        if (lastAppCompatV7Aar == null || !lastAppCompatV7Aar.exists()) throw RuntimeException("appcompat-v7 directory was not found")

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
                array(lastSupportV4Aar, lastAppCompatV7Aar).forEach { aarFile ->
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