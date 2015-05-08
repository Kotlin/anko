package org.jetbrains.android.generator.test

import java.io.File
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationTune
import org.jetbrains.android.anko.utils.Buffer

public fun Context.generate() {

    functionalDslTests {
        functionalDslTest("ComplexListenerClassTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
        }

        functionalDslTest("ComplexListenerSetterTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
        }

        functionalDslTest("HelperConstructorTest", AnkoFile.VIEWS) {
            tune(ConfigurationTune.HELPER_CONSTRUCTORS)
        }

        functionalDslTest("LayoutsTest", AnkoFile.LAYOUTS) {
            file(AnkoFile.LAYOUTS)
        }

        functionalDslTest("ViewTest", AnkoFile.VIEWS) {
            file(AnkoFile.VIEWS)
            tune(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
        }

        functionalDslTest("PropertyTest", AnkoFile.PROPERTIES) {
            file(AnkoFile.PROPERTIES)
        }

        functionalDslTest("ServicesTest", AnkoFile.SERVICES) {
            file(AnkoFile.SERVICES)
        }

        functionalDslTest("SimpleListenerTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.SIMPLE_LISTENERS)
        }
    }

    dslCompileTests(ktFiles("robolectric"), "Robolectric")

    dslCompileTests(ktFiles("compile"), "Compile")
}

private fun ktFiles(category: String) = File("dsl/testData/$category")
        .listFiles { it.name.endsWith(".kt") }?.map { it.name.replace(".kt", "") } ?: listOf()