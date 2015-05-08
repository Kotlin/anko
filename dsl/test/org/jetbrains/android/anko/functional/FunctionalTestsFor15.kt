package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationTune
import org.junit.Test
public class FunctionalTestsFor15 : AbstractFunctionalTest() {
    val version = "15"

    [Test] public fun testComplexListenerClassTest() {
        runFunctionalTest("ComplexListenerClassTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
        }
    }

    [Test] public fun testComplexListenerSetterTest() {
        runFunctionalTest("ComplexListenerSetterTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
        }
    }

    [Test] public fun testHelperConstructorTest() {
        runFunctionalTest("HelperConstructorTest.kt", AnkoFile.VIEWS, version) {
            tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
        }
    }

    [Test] public fun testLayoutsTest() {
        runFunctionalTest("LayoutsTest.kt", AnkoFile.LAYOUTS, version) {
            files.add(AnkoFile.LAYOUTS)
        }
    }

    [Test] public fun testViewTest() {
        runFunctionalTest("ViewTest.kt", AnkoFile.VIEWS, version) {
            files.add(AnkoFile.VIEWS)
            tunes.add(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
        }
    }

    [Test] public fun testPropertyTest() {
        runFunctionalTest("PropertyTest.kt", AnkoFile.PROPERTIES, version) {
            files.add(AnkoFile.PROPERTIES)
        }
    }

    [Test] public fun testServicesTest() {
        runFunctionalTest("ServicesTest.kt", AnkoFile.SERVICES, version) {
            files.add(AnkoFile.SERVICES)
        }
    }

    [Test] public fun testSimpleListenerTest() {
        runFunctionalTest("SimpleListenerTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
        }
    }

}
