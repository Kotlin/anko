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

package org.jetbrains.android.anko.compile

import org.jetbrains.android.anko.createTempTestFile
import org.jetbrains.android.anko.utils.JarFileFilter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.logging.Logger

open class CompileTestFixture {
    class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    companion object {
        private val kotlincFilename = "dependencies/Kotlin/kotlinc/bin/kotlinc-jvm" + (if (isWindows()) ".bat" else "")

        private fun getAnkoJars(androidSdkVersion: Int): List<File> {
            val baseDir = File("workdir/zip")
            val files = listOf(
                    File(baseDir, "anko-common.jar"),
                    File(baseDir, "anko-sdk$androidSdkVersion.jar"),
                    File(baseDir, "anko-support-v4.jar"))

            files.forEach {
                assertTrue("File $it does not exist", it.exists())
            }
            return files
        }

        private fun getAnkoJars(artifactOriginalDir: File): List<File> {
            val androidSdkVer = File(artifactOriginalDir, "version.txt").readText().toInt()
            return getAnkoJars(androidSdkVer)
        }

        private val LOG = Logger.getLogger(CompileTestFixture::class.java.name)

        fun runProcess(args: Array<String>, compiler: Boolean): ProcResult {
            LOG.info("Exec process: ${args.joinToString(" ")}")

            val p = Runtime.getRuntime().exec(args)
            val brInput = BufferedReader(InputStreamReader(p.inputStream))
            val brError = BufferedReader(InputStreamReader(p.errorStream))
            val errors = StringBuilder()
            val output = StringBuilder()

            (brInput.lineSequence() + brError.lineSequence()).forEach { line ->
                if (compiler && line.startsWith("ERROR")) {
                    errors.append(line).append("\n")
                } else {
                    output.append(line).append("\n")
                }
            }

            p.waitFor()
            return ProcResult(output.toString(), errors.toString(), p.exitValue())
        }

        private fun isWindows(): Boolean {
            val osName = System.getProperty("os.name").toLowerCase()
            return osName.contains("win")
        }
    }

    protected fun runCompileTest(testData: File, artifactOriginalDir: File) {
        assertTrue(testData.exists())
        compile(testData, artifactOriginalDir).delete()
    }

    protected fun runRobolectricTest(testDataFile: File, artifactOriginalDir: File) {
        assertTrue(testDataFile.exists())

        val lib = File("dependencies/")
        val robolectricDir = File(lib, "robolectric/")

        val robolectricJars = robolectricDir.listFiles { file -> file.extension == "jar" }?.toList() ?: listOf()
        val androidAllJars = File(lib, "androidall").listFiles { file -> file.extension == "jar" }?.toList() ?: listOf()

        val compiledJarFile = compile(testDataFile, artifactOriginalDir, robolectricJars)

        val classpath = (listOf(
                compiledJarFile,
                File(lib, "Kotlin/kotlinc/lib/kotlin-runtime.jar"),
                File(lib, "hamcrest-all-1.3.jar")
        ) + getAnkoJars(artifactOriginalDir) + robolectricJars + androidAllJars)
                .map { it.absolutePath }
                .joinToString(File.pathSeparator)

        val manifest = File("anko/library/testData/robolectric/AndroidManifest.xml")
        val androidRes = File("anko/library/testData/robolectric/res/")
        val androidAssets = File("anko/library/testData/robolectric/assets/")

        val args = arrayOf("java", "-cp", classpath,
                "-Dapple.awt.UIElement=true",
                "-Drobolectric.offline=true",
                "-Drobolectric.dependency.dir=" + lib.absolutePath,
                "-Dandroid.manifest=" + manifest.absolutePath,
                "-Dandroid.resources=" + androidRes.absolutePath,
                "-Dandroid.assets=" + androidAssets.absolutePath,
                "org.junit.runner.JUnitCore", "test.RobolectricTest"
        )

        val result = runProcess(args, false)
        assertTrue(result.stderr.isEmpty())
    }

    private fun compile(testData: File, artifactOriginalDir: File, additionalJars: List<File> = emptyList()): File {
        val platformAndToolkitJars = artifactOriginalDir.listFiles(JarFileFilter())

        val classpath = (platformAndToolkitJars + getAnkoJars(artifactOriginalDir) + additionalJars)
                .map { it.absolutePath }
                .joinToString(File.pathSeparator)

        val outputJar = createTempTestFile("compile", ".jar")

        val args = arrayOf(
                File(kotlincFilename).absolutePath,
                "-d", outputJar.absolutePath,
                "-classpath", classpath.toString(),
                testData.getPath())

        val res = runProcess(args, compiler = true)

        assertEquals(res.stderr, "", res.stderr)
        assertEquals(res.stdout, 0, res.exitCode)

        return outputJar
    }
}