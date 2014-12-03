package org.jetbrains.android.dsl

import java.io.File
import org.jetbrains.android.dsl.KoanFile
import org.jetbrains.android.dsl.ConfigurationTune
import org.jetbrains.android.dsl.writeFile
import org.jetbrains.android.dsl.utils.Buffer

public fun Context.generate() {

    functionalTest("ComplexListenerClassTest", KoanFile.LISTENERS) {
        file(KoanFile.LISTENERS)
        tune(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
    }

    functionalTest("ComplexListenerSetterTest", KoanFile.LISTENERS) {
        file(KoanFile.LISTENERS)
        tune(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
    }

    functionalTest("HelperConstructorTest", KoanFile.VIEWS) {
        tune(ConfigurationTune.HELPER_CONSTRUCTORS)
    }

    functionalTest("LayoutsTest", KoanFile.LAYOUTS) {
        file(KoanFile.LAYOUTS)
    }

    functionalTest("PropertyTest", KoanFile.PROPERTIES) {
        file(KoanFile.PROPERTIES)
    }

    functionalTest("ServicesTest", KoanFile.SERVICES) {
        file(KoanFile.SERVICES)
    }

    functionalTest("SimpleListenerTest", KoanFile.LISTENERS) {
        file(KoanFile.LISTENERS)
        tune(ConfigurationTune.SIMPLE_LISTENERS)
    }
}

private fun Context.functionalTest(name: String, mainKoanFile: KoanFile, configInit: TestConfiguration.() -> Unit = {}) {
    val testConfiguration = TestConfiguration(name, mainKoanFile)
    testConfiguration.configInit()

    val dir = File("./test/" + basePackage.replace('.', '/'), "/functional")
    val testFile = File(dir, "$name.kt")

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
    }
}

fun main(args: Array<String>) {
    val versions = File("./testdata/")
        .listFiles { it.isDirectory() && it.name.matches("\\d+s?") }
        ?.map { it.name }
        ?: listOf()

    Context(versions, "org.jetbrains.android.dsl").generate()
}

private fun buffer(init: Buffer.() -> Unit) = Buffer("    ", 0, init)

private class Context(val testVersions: List<String>, val basePackage: String)

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