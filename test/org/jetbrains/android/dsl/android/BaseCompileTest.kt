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
import org.jetbrains.android.dsl.utils.DirectoryFilter
import org.jetbrains.android.dsl.utils.JarFilter
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

import java.io.*
import java.util.ArrayList
import java.util.Arrays

public open class BaseCompileTest : Assert() {
    private val kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm"
    private val tmpJarFile = javaClass.getName() + "_out.jar"

    BeforeMethod
    public open fun setUp() {
        Assert.assertTrue(File(kotlincFilename).exists())
    }

    protected fun runCompileTest(testData: File) {
        Assert.assertTrue(testData.exists())

        val versions = File("original/").listFiles(directoryFilter)
        for (ver in versions) {
            val props = compile(testData, ver)
            for (file in props.tmpFiles.values()) {
                file.delete()
            }
        }
    }

    private fun compile(testData: File, ver: File): AndroidTestGeneratorConfiguration {
        val version = ver.getName()
        val intVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""))

        val jarFiles = ver.listFiles(jarFilter)
        val jarFilesString = jarFiles.map { it.getAbsolutePath() }
        val classpath = jarFiles.map { it.getPath() }.joinToString(File.pathSeparator)

        val props = AndroidTestGeneratorConfiguration()
        DSLGenerator(intVersion, version, jarFilesString, props).run()

        val kotlincArgs = array(kotlincFilename, "-d", tmpJarFile, "-classpath", classpath.toString(), testData.getPath())
        val args = arrayListOf(*kotlincArgs)
        for (file in props.tmpFiles.values()) {
            args.add(file.getAbsolutePath())
        }
        val res = runCompiler(args.copyToArray())

        Assert.assertEquals(res.stderr, "")
        Assert.assertEquals(res.exitCode, 0)
        return props
    }

    protected fun runCompiler(args: Array<String>): ProcResult {
        val p = Runtime.getRuntime().exec(args)
        val brInput = BufferedReader(InputStreamReader(p.getInputStream()))
        val brError = BufferedReader(InputStreamReader(p.getErrorStream()))
        val errors = StringBuilder()
        val output = StringBuilder()

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
    public open fun tearDown() {
        File(tmpJarFile).delete()
    }

    class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    class object {
        private val directoryFilter = DirectoryFilter()
        private val jarFilter = JarFilter()
    }
}
