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

package org.jetbrains.android.anko.compile

import org.jetbrains.android.anko.createTempTestFile
import org.jetbrains.android.anko.utils.JarFileFilter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.*
import java.util.logging.Logger

public open class CompileTestFixture {
    class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    companion object {
        private val kotlincFilename = "lib/Kotlin/kotlinc/bin/kotlinc-jvm" + (if (isWindows()) ".bat" else "")

        private fun getBuiltLibraryFile(fullVersion: String): File {
            return File("workdir/zip/anko-$fullVersion.jar")
        }

        private val LOG = Logger.getLogger(CompileTestFixture::class.java.name)

        fun runProcess(args: Array<String>, compiler: Boolean): ProcResult {
            LOG.info("Exec process: ${Arrays.toString(args)}")

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

    protected fun runCompileTest(testData: File, ver: File) {
        assertTrue(testData.exists())
        compile(testData, ver).delete()
    }

    protected fun runRobolectricTest(testDataFile: File, ver: File) {
        assertTrue(testDataFile.exists())

        val lib = File("lib/")
        val robolectricDir = File(lib, "robolectric/")

        val robolectricJars = robolectricDir.listFiles { it.extension == "jar" }?.toList() ?: listOf()
        val androidAllJars = File(lib, "androidall").listFiles { it.extension == "jar" }?.toList() ?: listOf()

        val tmpFile = compile(testDataFile, ver, robolectricJars)

        val cp = (listOf(
                getBuiltLibraryFile(ver.name),
                tmpFile,
                File(lib, "Kotlin/kotlinc/lib/kotlin-runtime.jar"),
                File(lib, "hamcrest-all-1.3.jar")
        ) + robolectricJars + androidAllJars).map { it.absolutePath }.join(File.pathSeparator)

        val manifest = File("dsl/testData/robolectric/AndroidManifest.xml")
        val androidRes = File("dsl/testData/robolectric/res/")
        val androidAssets = File("dsl/testData/robolectric/assets/")

        val args = arrayOf("java", "-cp", cp,
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

    private fun compile(testData: File, ver: File, additionalLibraries: List<File>? = null): File {
        val jarFiles = ver.listFiles(JarFileFilter())
        val classpath = (
                jarFiles.map { it.getPath() } +
                        listOf(getBuiltLibraryFile(ver.name)) +
                        (additionalLibraries?.map { it.absolutePath } ?: listOf()))
                .joinToString(File.pathSeparator)

        val tmpFile = createTempTestFile("compile", ".jar")
        val kotlincArgs = arrayOf(File(kotlincFilename).absolutePath, "-d", tmpFile.absolutePath,
                "-classpath", classpath.toString(), testData.getPath())
        val args = arrayListOf(*kotlincArgs)
        val res = runProcess(args.toTypedArray(), compiler = true)

        assertEquals("", res.stderr)
        assertEquals(0, res.exitCode)

        return tmpFile
    }
}