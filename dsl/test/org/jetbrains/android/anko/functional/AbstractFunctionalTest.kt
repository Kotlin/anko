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

package org.jetbrains.android.anko.functional

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.utils.JarFileFilter
import java.io.File
import java.io.FileFilter
import java.io.FileWriter
import java.io.IOException
import java.util.ArrayList
import java.util.Arrays
import org.junit.Assert.*
import org.junit.Test

public abstract class AbstractFunctionalTest {
    val config = TestGeneratorConfiguration()
    var classTree: ClassTree? = null

    protected fun loadOrCreate(file: File, data: String): String {
        try {
            return file.readText()
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
                                    subsystem: AnkoFile,
                                    config: TestGeneratorConfiguration) {
        if (classTree == null) {
            classTree = ClassProcessor(inputJarFiles).genClassTree()
        }

        val generator = DSLGenerator(intVersion, version, inputJarFiles, config, classTree)
        generator.run()

        val actual = config.getOutputFile(subsystem).readText().replace("\r", "")
        val expectedPath = ("dsl/testData/functional/$version/$testDataFile").replace("\r", "")
        val expected = loadOrCreate(File(expectedPath), actual)

        assertTrue(expected.length() > 0)
        assertTrue(actual.length() > 0)
        assertEquals(expected, actual)
    }

    protected fun runFunctionalTest(
            testDataFile: String,
            subsystem: AnkoFile,
            version: String,
            settings: BaseGeneratorConfiguration.() -> Unit
    ) {
        config.generateImports = false
        config.generatePackage = false
        config.generateMavenArtifact = false

        config.files.clear()
        config.tunes.clear()

        config.settings()

        val versionDir = File("workdir/original", version)
        val intVersion = version.replaceAll("[^0-9]", "").toInt()

        val jarFiles = versionDir.listFiles(JarFileFilter()).map { it.getAbsolutePath() }

        runFunctionalTest(version, intVersion, jarFiles, testDataFile, subsystem, config)
    }

}
