package org.jetbrains.android.generator.test

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

    compileTests(ktFiles("robolectric"), "Robolectric")

    compileTests(ktFiles("compile"), "Compile")
}

private fun ktFiles(category: String) = File("testData/$category")
        .listFiles { it.name.endsWith(".kt") }?.map { it.name.replace(".kt", "") } ?: listOf()