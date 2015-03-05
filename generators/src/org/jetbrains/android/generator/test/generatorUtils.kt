package org.jetbrains.android.generator.test

import java.io.File
import org.jetbrains.android.dsl.utils.Buffer
import org.jetbrains.android.dsl.KoanFile
import org.jetbrains.android.dsl.ConfigurationTune

private fun Context.functionalTest(name: String, mainKoanFile: KoanFile, configInit: TestConfiguration.() -> Unit = {}) {
    val testConfiguration = TestConfiguration(name, mainKoanFile)
    testConfiguration.configInit()

    val dir = File("./test/" + basePackage.replace('.', '/'), "/functional")
    val testFile = File(dir, "Generated${firstCapital(name)}.kt")

    if (!testFile.exists()) {
        testFile.writeText(buffer {
            line("package $basePackage.functional\n")
            line("import $basePackage.*")
            line("import org.testng.annotations.Test\n")
            line("public class $name : AbstractFunctionalTest() {")
            line("private val testDataFile = \"$name.kt\"\n")
            line("override fun initSettings(settings: BaseGeneratorConfiguration) {")

            for (file in testConfiguration.files) {
                line("settings.files.add(KoanFile.${file.name()})")
            }
            for (tune in testConfiguration.tunes) {
                line("settings.tunes.add(ConfigurationTune.${tune.name()})")
            }

            line("}")
            for (version in testVersions) {
                line("[Test] public fun test${name}For$version() {")
                line("runFunctionalTest(testDataFile, KoanFile.${mainKoanFile.name()}, \"$version\")")
                line("}")
            }
            line("}")
        }.toString())
        println("File $testFile written")
    }
}

private fun Context.compileTests(files: List<String>, category: String) {
    val dir = File("./test/" + basePackage.replace('.', '/'), "/${category.toLowerCase()}")
    val testFile = File(dir, "Generated${category}Test.kt")

    if (!testFile.exists()) {
        testFile.writeText(buffer {
            line("package $basePackage.${category.toLowerCase()}\n").nl()
            line("import $basePackage.*")
            line("import $basePackage.compile.CompileTestFixture")
            line("import org.testng.annotations.*\n")
            line("import kotlin.platform.platformStatic").nl()
            line("public class Generated${category}Test : Abstract${category}Test() {")
            line("class object {")
            line("  BeforeClass platformStatic fun setUpClass() = CompileTestFixture.setUpClass()")
            line("  AfterClass platformStatic fun tearDownClass() = CompileTestFixture.tearDownClass()")
            line("}").nl()
            for (file in files) {
                for (version in versions) {
                    line("[Test] public fun test${file}For$version() {")
                    line("run${category}Test(\"$file.kt\", \"$version\")")
                    line("}").nl()
                }
            }
            line("}")
        }.toString())
        println("File $testFile written")
    }
}

fun main(args: Array<String>) {
    val versions = File("./original/")
            .listFiles { it.isDirectory() && it.name.matches("\\d+s?") }
            ?.map { it.name }
            ?: listOf()

    val testVersions = File("./testData/functional/")
        .listFiles { it.isDirectory() && it.name.matches("\\d+s?") }
        ?.map { it.name }
        ?: listOf()

    Context(versions, testVersions, "org.jetbrains.android.dsl").generate()
}

private fun buffer(init: Buffer.() -> Unit) = Buffer("    ", 0, init)

private fun firstCapital(s: String): String {
    return if (s.length() == 0) "" else Character.toUpperCase(s[0]) + s.substring(1)
}

private class Context(val versions: List<String>, val testVersions: List<String>, val basePackage: String)

private class TestConfiguration(val name: String, val mainKoanFile: KoanFile) {
    val files = hashSetOf<KoanFile>()
    val tunes = hashSetOf<ConfigurationTune>()

    fun tune(tune: ConfigurationTune) {
        tunes.add(tune)
    }

    fun file(file: KoanFile) {
        files.add(file)
    }

}