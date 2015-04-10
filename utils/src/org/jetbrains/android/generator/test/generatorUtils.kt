package org.jetbrains.android.generator.test

import java.io.File
import org.jetbrains.android.anko.utils.Buffer
import org.jetbrains.android.anko.AnkoFile
import org.jetbrains.android.anko.ConfigurationTune

private fun Context.functionalDslTests(init: Buffer.(version: String) -> Unit) {
    val dir = File("./dsl/test/" + basePackage.replace('.', '/'), "/functional")

    for (version in testVersions) {
        val testFile = File(dir, "FunctionalTestsFor$version.kt")

        if (!testFile.exists()) {
            testFile.writeText(buffer {
                line("package $basePackage.functional\n")
                line("import $basePackage.*")
                line("import org.junit.Test\n")
                line("public class FunctionalTestsFor$version : AbstractFunctionalTest() {")
                line("val version = \"$version\"\n").nl()
                init(version)
                line("}")
            }.toString())
            println("File $testFile written")
        }
    }
}

private fun Buffer.functionalDslTest(name: String, mainAnkoFile: AnkoFile, configInit: TestConfiguration.() -> Unit = {}) {
    val testConfiguration = TestConfiguration()
    testConfiguration.configInit()

    line("[Test] public fun test$name() {")

    line("runFunctionalTest(\"$name.kt\", AnkoFile.${mainAnkoFile.name()}, version) {")
    for (file in testConfiguration.files) {
        line("files.add(AnkoFile.${file.name()})")
    }
    for (tune in testConfiguration.tunes) {
        line("tunes.add(ConfigurationTune.${tune.name()})")
    }
    line("}")
    line("}").nl()
}

private fun Context.dslCompileTests(files: List<String>, category: String) {
    val dir = File("./dsl/test/" + basePackage.replace('.', '/'), "/${category.toLowerCase()}")
    val testFile = File(dir, "Generated${category}Test.kt")

    if (!testFile.exists()) {
        testFile.writeText(buffer {
            line("package $basePackage.${category.toLowerCase()}\n").nl()
            line("import $basePackage.*")
            line("import $basePackage.compile.CompileTestFixture")
            line("import org.junit.*\n")
            line("import kotlin.platform.platformStatic").nl()
            line("public class Generated${category}Test : Abstract${category}Test() {")
            line("companion object {")
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
    val versions = File("./workdir/original/")
            .listFiles { it.isDirectory() && it.name.matches("\\d+s?") }
            ?.map { it.name }
            ?: listOf()

    val testVersions = File("./dsl/testData/functional/")
        .listFiles { it.isDirectory() && it.name.matches("\\d+s?") }
        ?.map { it.name }
        ?: listOf()

    Context(versions, testVersions, "org.jetbrains.android.anko").generate()
}

private fun buffer(init: Buffer.() -> Unit) = Buffer("    ", 0, init)

private class Context(val versions: List<String>, val testVersions: List<String>, val basePackage: String)

private class TestConfiguration {
    val files = hashSetOf<AnkoFile>()
    val tunes = hashSetOf<ConfigurationTune>()

    fun tune(tune: ConfigurationTune) {
        tunes.add(tune)
    }

    fun file(file: AnkoFile) {
        files.add(file)
    }

}