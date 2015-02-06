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
import org.jetbrains.android.dsl.KoanFile
import org.testng.annotations.BeforeClass
import org.testng.annotations.AfterClass

public open class BaseCompileTest : Assert() {
    private val kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm"
    private val tmpJarFile = javaClass.getName() + "_out.jar"

    private val versions = File("original/").listFiles(directoryFilter)

    private val File.libraryJar: String
        get() = "lib-$name.jar"

    BeforeClass
    public open fun setUpClass() {
        Assert.assertTrue(File(kotlincFilename).exists())

        for (ver in versions) {
            compileLibrary(ver)
        }
    }

    protected fun runCompileTest(testData: File) {
        Assert.assertTrue(testData.exists())

        for (ver in versions) {
            compile(testData, ver)
        }
    }

    private fun compile(testData: File, ver: File) {
        val jarFiles = ver.listFiles(jarFilter)
        val classpath = (jarFiles.map { it.getPath() } + listOf(ver.libraryJar)).joinToString(File.pathSeparator)

        val kotlincArgs = array(kotlincFilename, "-d", tmpJarFile, "-classpath", classpath.toString(), testData.getPath())
        val args = arrayListOf(*kotlincArgs)
        val res = runCompiler(args.copyToArray())

        Assert.assertEquals(res.stderr, "")
        Assert.assertEquals(res.exitCode, 0)
    }

    private fun compileLibrary(ver: File): AndroidTestGeneratorConfiguration {
        val version = ver.getName()
        val intVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""))

        val jarFiles = ver.listFiles(jarFilter)
        val jarFilesString = jarFiles.map { it.getAbsolutePath() }
        val classpath = jarFiles.map { it.getPath() }.joinToString(File.pathSeparator)

        val props = AndroidTestGeneratorConfiguration()
        props.files.remove(KoanFile.INTERFACE_WORKAROUNDS)
        DSLGenerator(intVersion, version, jarFilesString, props).run()

        val kotlincArgs = array(kotlincFilename, "-d", ver.libraryJar, "-classpath", classpath.toString())
        val args = arrayListOf(*kotlincArgs)
        for (file in props.tmpFiles.values()) {
            args.add(file.getAbsolutePath())
        }
        val res = runCompiler(args.copyToArray())

        for (file in props.tmpFiles.values()) {
            file.delete()
        }

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

        (brInput.lines() + brError.lines()).forEach { line ->
            if (line.startsWith("ERROR")) {
                errors.append(line).append("\n")
            } else {
                output.append(line).append("\n")
            }
        }

        p.waitFor()
        return ProcResult(output.toString(), errors.toString(), p.exitValue())
    }

    AfterMethod
    public open fun tearDown() {
        File(tmpJarFile).delete()
    }

    AfterClass
    public open fun tearDownClass() {
        for (ver in versions) {
            File(ver.libraryJar).delete()
        }
    }

    class ProcResult(val stdout: String, val stderr: String, val exitCode: Int)

    class object {
        private val directoryFilter = DirectoryFilter()
        private val jarFilter = JarFilter()
    }
}
