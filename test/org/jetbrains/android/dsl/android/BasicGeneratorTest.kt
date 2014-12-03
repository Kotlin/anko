/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl.android

import org.jetbrains.android.dsl.DSLGenerator
import org.jetbrains.android.dsl.KoanFile
import org.jetbrains.android.dsl.utils.DirectoryFilter
import org.jetbrains.android.dsl.utils.JarFilter
import org.jetbrains.android.dsl.TestGeneratorConfiguration
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.io.*
import java.util.ArrayList
import java.util.Arrays
import kotlin.test.*

public class BasicGeneratorTest {

    private val kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm"
    private val tmpJarFile = javaClass.getName() + "_out.jar"

    BeforeMethod
    public fun setUp() {
        assertTrue(File(kotlincFilename).exists())
    }

    Test
    public fun testResultExists() {
        val versions = File("original/").listFiles(directoryFilter)
        for (ver in versions) {
            val fVersion = ver.getName()
            val version = Integer.parseInt(fVersion.replaceAll("[^0-9]", ""))

            val jarFiles = ver.listFiles(jarFilter)
            val jarFilesString = jarFiles.map { it.getAbsolutePath() }

            val settings = TestGeneratorConfiguration()
            DSLGenerator(version, fVersion, jarFilesString, settings).run()

            val supportFile = settings.tmpFiles.get(KoanFile.SUPPORT)!!.getAbsolutePath()
            for (file in settings.tmpFiles.values()) {
                if (file.getAbsolutePath() == supportFile) {
                    if (settings.files.contains(KoanFile.SUPPORT)) {
                        assertTrue(file.length() > 0)
                    }
                } else {
                    assertTrue(file.length() > 0, "File ${file.name} doesn't exist or is empty")
                }
            }
            for (file in settings.tmpFiles.values()) {
                if (file.exists()) {
                    file.delete()
                }
            }
        }
    }

    Test
    public fun testResultCompiles() {
        val versions = File("original/").listFiles(directoryFilter)
        for (ver in versions) {
            val fVersion = ver.getName()
            val version = Integer.parseInt(fVersion.replaceAll("[^0-9]", ""))

            val jarFiles = Arrays.asList<File>(*ver.listFiles(jarFilter))
            val jarFilesString = ArrayList<String>()
            val classpath = StringBuilder()
            for (f in jarFiles) {
                jarFilesString.add(f.getAbsolutePath())
                if (classpath.length() > 0) {
                    classpath.append(File.pathSeparatorChar)
                }
                classpath.append(f.getPath())
            }

            val settings = TestGeneratorConfiguration()
            val gen = DSLGenerator(version, fVersion, jarFilesString, settings)
            gen.run()
            val kotlincArgs = array(kotlincFilename, "-jar", tmpJarFile, "-classpath", classpath.toString())
            val args = arrayListOf(*kotlincArgs)
            for (file in settings.tmpFiles.values()) {
                args.add(file.getAbsolutePath())
            }
            val res = compile(args.copyToArray())
            assertEquals(res.stderr, "")
            for (file in settings.tmpFiles.values()) {
                file.delete()
            }
        }
    }

    protected fun compile(args: Array<String>): ProcResult {
        val p = Runtime.getRuntime().exec(args)
        val brInput = BufferedReader(InputStreamReader(p.getInputStream()))
        val brError = BufferedReader(InputStreamReader(p.getErrorStream()))
        val output = StringBuilder()
        val errors = StringBuilder()

        var str = brInput.readLine()
        while (str != null) {
            if (str.startsWith("ERROR"))
                errors.append(str).append("\n")
            else
                output.append(str).append("\n")
            str = brInput.readLine()
        }

        str = brError.readLine()
        while (str != null) {
            if (str.startsWith("ERROR"))
                errors.append(str).append("\n")
            else
                output.append(str).append("\n")
            brError.readLine()
        }

        p.waitFor()
        return ProcResult(output.toString(), errors.toString(), p.exitValue())
    }

    AfterMethod
    public fun tearDown() {
        File(tmpJarFile).delete()
    }

    inner class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    class object {

        private val directoryFilter = DirectoryFilter()
        private val jarFilter = JarFilter()
    }
}