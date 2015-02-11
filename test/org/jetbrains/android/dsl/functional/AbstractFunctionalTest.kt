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

package org.jetbrains.android.dsl.functional

import org.jetbrains.android.dsl.*
import org.jetbrains.android.dsl.utils.JarFilter
import java.io.File
import java.io.FileFilter
import java.io.FileWriter
import java.io.IOException
import java.util.ArrayList
import java.util.Arrays
import org.testng.Assert.*

public abstract class AbstractFunctionalTest {

    protected fun loadOrCreate(file: File, data: String): String {
        try {
            return readFile(file.getAbsolutePath())
        } catch (e: Exception) {
            file.createNewFile()
            val fileWriter = FileWriter(file)
            fileWriter.write(data)
            fileWriter.close()
            fail("Empty expected data, creating from actual")
            return data
        }
    }

    protected fun runFunctionalTest(version: String,
                                    intVersion: Int,
                                    inputJarFiles: List<String>,
                                    testDataFile: String,
                                    subsystem: KoanFile,
                                    settings: TestGeneratorConfiguration) {
        initSettings(settings)

        val generator = DSLGenerator(intVersion, version, inputJarFiles, settings)
        generator.run()

        val actual = settings.getOutputFile(subsystem).readText()
        val expectedPath = ("testData/functional/$version/$testDataFile")
        val expected = loadOrCreate(File(expectedPath), actual)

        assertTrue(expected.length() > 0)
        assertTrue(actual.length() > 0)
        assertEquals(actual, expected)
    }

    protected fun runFunctionalTest(testDataFile: String, subsystem: KoanFile, version: String) {
        val settings = TestGeneratorConfiguration()

        settings.generateImports = false
        settings.generatePackage = false
        settings.generateMavenArtifact = false

        settings.files.clear()
        settings.tunes.clear()

        val versionDir = File("original", version)
        val intVersion = version.replaceAll("[^0-9]", "").toInt()

        val jarFiles = versionDir.listFiles(JarFilter()).map { it.getAbsolutePath() }

        runFunctionalTest(version, intVersion, jarFiles, testDataFile, subsystem, settings)

    }

    protected abstract fun initSettings(settings: BaseGeneratorConfiguration)

}
