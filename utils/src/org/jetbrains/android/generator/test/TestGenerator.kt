package org.jetbrains.android.generator.test

import java.io.File
import org.jetbrains.android.anko.AnkoFile
import org.jetbrains.android.anko.ConfigurationTune
import org.jetbrains.android.anko.utils.Buffer

public fun Context.generate() {

    functionalTest("ComplexListenerClassTest", AnkoFile.LISTENERS) {
        file(AnkoFile.LISTENERS)
        tune(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
    }

    functionalTest("ComplexListenerSetterTest", AnkoFile.LISTENERS) {
        file(AnkoFile.LISTENERS)
        tune(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
    }

    functionalTest("HelperConstructorTest", AnkoFile.VIEWS) {
        tune(ConfigurationTune.HELPER_CONSTRUCTORS)
    }

    functionalTest("LayoutsTest", AnkoFile.LAYOUTS) {
        file(AnkoFile.LAYOUTS)
    }

    functionalTest("ViewTest", AnkoFile.VIEWS) {
        file(AnkoFile.VIEWS)
        tune(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
    }

    functionalTest("PropertyTest", AnkoFile.PROPERTIES) {
        file(AnkoFile.PROPERTIES)
    }

    functionalTest("ServicesTest", AnkoFile.SERVICES) {
        file(AnkoFile.SERVICES)
    }

    functionalTest("SimpleListenerTest", AnkoFile.LISTENERS) {
        file(AnkoFile.LISTENERS)
        tune(ConfigurationTune.SIMPLE_LISTENERS)
    }

    compileTests(ktFiles("robolectric"), "Robolectric")

    compileTests(ktFiles("compile"), "Compile")
}

private fun ktFiles(category: String) = File("dsl/testData/$category")
        .listFiles { it.name.endsWith(".kt") }?.map { it.name.replace(".kt", "") } ?: listOf()