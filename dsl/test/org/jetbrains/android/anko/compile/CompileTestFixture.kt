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

import org.testng.Assert
import java.io.File
import org.testng.annotations.BeforeClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterClass
import org.jetbrains.android.anko.AnkoFile
import org.jetbrains.android.anko.DSLGenerator
import java.io.BufferedReader
import org.jetbrains.android.anko.utils.AndroidVersionDirectoryFilter
import org.jetbrains.android.anko.utils.JarFileFilter
import java.io.InputStreamReader
import kotlin.platform.platformStatic
import org.jetbrains.android.anko.TestGeneratorConfiguration

public open class CompileTestFixture : Assert() {

    class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    companion object {
        private val kotlincFilename = "lib/Kotlin/kotlinc/bin/kotlinc-jvm"

        private val versions = File("workdir/original/").listFiles(AndroidVersionDirectoryFilter())
        private val versionJars = hashMapOf<File, File>()

        platformStatic
        public open fun setUpClass() {
            Assert.assertTrue(File(kotlincFilename).exists())

            if (versionJars.isEmpty()) {
                for (ver in versions) {
                    compileLibrary(ver)
                }
            }
        }

        platformStatic
        public open fun tearDownClass() {
            versionJars.values().forEach { it.delete() }
            versionJars.clear()
        }

        private fun compileLibrary(ver: File): TestGeneratorConfiguration {
            val version = ver.getName()
            val intVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""))

            val jarFiles = ver.listFiles(JarFileFilter())
            val jarFilesString = jarFiles.map { it.getAbsolutePath() }
            val classpath = jarFiles.map { it.getPath() }.joinToString(File.pathSeparator)

            val props = TestGeneratorConfiguration()
            props.files.remove(AnkoFile.INTERFACE_WORKAROUNDS)
            DSLGenerator(intVersion, version, jarFilesString, props).run()

            val outputJarFile = File.createTempFile("lib-" + ver.getName(), ".jar")
            versionJars[ver] = outputJarFile

            val kotlincArgs = array(kotlincFilename, "-d", outputJarFile.getAbsolutePath(), "-classpath", classpath.toString())
            val args = arrayListOf(*kotlincArgs)
            for (file in props.tmpFiles.values()) {
                args.add(file.getAbsolutePath())
            }
            val res = runProcess(args.copyToArray(), compiler = true)

            for (file in props.tmpFiles.values()) {
                file.delete()
            }

            Assert.assertEquals(res.stderr, "")
            Assert.assertEquals(res.exitCode, 0)
            return props
        }

        fun runProcess(args: Array<String>, compiler: Boolean): ProcResult {
            val p = Runtime.getRuntime().exec(args)
            val brInput = BufferedReader(InputStreamReader(p.getInputStream()))
            val brError = BufferedReader(InputStreamReader(p.getErrorStream()))
            val errors = StringBuilder()
            val output = StringBuilder()

            (brInput.lines() + brError.lines()).forEach { line ->
                if (compiler && line.startsWith("ERROR")) {
                    errors.append(line).append("\n")
                } else {
                    output.append(line).append("\n")
                }
            }

            p.waitFor()
            return ProcResult(output.toString(), errors.toString(), p.exitValue())
        }
    }

    protected fun runCompileTest(testData: File, ver: File) {
        Assert.assertTrue(testData.exists())
        compile(testData, ver).delete()
    }

    protected fun runRobolectricTest(testDataFile: File, ver: File) {
        Assert.assertTrue(testDataFile.exists())

        val lib = File("lib/")
        val tmpFile = compile(testDataFile, ver, listOf(
                File(lib, "junit-4.11.jar"),
                File(lib, "robolectric-with-dependencies.jar")
        ))

        val cp = listOf(
                versionJars[ver],
                tmpFile,
                File(lib, "Kotlin/kotlinc/lib/kotlin-runtime.jar"),
                File(lib, "junit-4.11.jar"),
                File(lib, "hamcrest-all-1.3.jar"),
                File(lib, "robolectric-with-dependencies.jar"),
                File(lib, "android-all-4.1.2_r1-robolectric-0.jar")
        ).map { it.getAbsolutePath() }.join(File.pathSeparator)

        val manifest = File("dsl/testData/robolectric/AndroidManifest.xml")
        val androidRes = File("dsl/testData/robolectric/res/")
        val androidAssets = File("dsl/testData/robolectric/assets/")

        val args = array(
                "java", "-cp", cp,
                "-Dapple.awt.UIElement=true",
                "-Drobolectric.offline=true",
                "-Drobolectric.dependency.dir=" + lib.getAbsolutePath(),
                "-Dandroid.manifest=" + manifest.getAbsolutePath(),
                "-Dandroid.resources=" + androidRes.getAbsolutePath(),
                "-Dandroid.assets=" + androidAssets.getAbsolutePath(),
                "org.junit.runner.JUnitCore", "test.RobolectricTest"
        )

        val result = runProcess(args, false)
        Assert.assertTrue(result.stderr.isEmpty())
    }

    private fun compile(testData: File, ver: File, additionalLibraries: List<File>? = null): File {
        val jarFiles = ver.listFiles(JarFileFilter())
        val classpath = (
                jarFiles.map { it.getPath() } +
                        listOf(versionJars[ver]) +
                        (additionalLibraries?.map { it.getAbsolutePath() } ?: listOf()))
                .joinToString(File.pathSeparator)

        val tmpFile = File.createTempFile("compile", ".jar")
        val kotlincArgs = array(kotlincFilename, "-d", tmpFile.getAbsolutePath(),
                "-classpath", classpath.toString(), testData.getPath())
        val args = arrayListOf(*kotlincArgs)
        val res = runProcess(args.copyToArray(), compiler = true)

        Assert.assertEquals(res.stderr, "")
        Assert.assertEquals(res.exitCode, 0)

        return tmpFile
    }
}