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

package org.jetbrains.android.generator.test

import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationTune
import org.jetbrains.android.anko.utils.AndroidVersionDirectoryFilter
import org.jetbrains.android.anko.utils.Buffer
import org.jetbrains.android.anko.utils.toCamelCase
import java.io.File

fun Context.functionalDslTests(init: Buffer.(version: String) -> Unit) {
    val dir = File("./anko/library/generator/test/" + basePackage.replace('.', '/'), "/functional")

    for (version in versions) {
        val versionName = version.toCamelCase('-').capitalize()

        val contents = buffer {
            line("package $basePackage.functional\n")
            line("import $basePackage.config.*")
            line("import org.junit.Test\n")
            line("class FunctionalTestsFor$versionName : AbstractFunctionalTest() {")
            line("val version = \"$version\"\n").nl()
            init(version)
            line("}")
        }.toString()

        writeTestFile(File(dir, "FunctionalTestsFor$versionName.kt"), contents)
    }
}

fun Buffer.functionalDslTest(name: String, mainAnkoFile: AnkoFile, configInit: TestConfiguration.() -> Unit = {}) {
    val testConfiguration = TestConfiguration()
    testConfiguration.configInit()

    line("@Test").line("fun test$name() {")

    line("runFunctionalTest(\"$name.kt\", AnkoFile.${mainAnkoFile.name}, version) {")
    for (file in testConfiguration.files) {
        line("files.add(AnkoFile.${file.name})")
    }
    for (tune in testConfiguration.tunes) {
        line("tunes.add(ConfigurationTune.${tune.name})")
    }
    line("}")
    line("}").nl()
}

private fun writeTestFile(testFile: File, contents: String) {
    if (!testFile.exists() || testFile.readText().trim() != contents.trim()) {
        testFile.writeText(contents)
        println("File $testFile written")
    }
}

fun main(args: Array<String>) {
    val versions = File("./workdir/original/")
            .listFiles(AndroidVersionDirectoryFilter())
            ?.map { it.name }
            ?: listOf()

    Context(versions, "org.jetbrains.android.anko").generate()
}

private fun buffer(init: Buffer.() -> Unit) = Buffer("    ", 0, init)

class Context(val versions: List<String>, val basePackage: String)

class TestConfiguration {
    val files = hashSetOf<AnkoFile>()
    val tunes = hashSetOf<ConfigurationTune>()

    fun tune(tune: ConfigurationTune) {
        tunes.add(tune)
    }

    fun file(file: AnkoFile) {
        files.add(file)
    }

}