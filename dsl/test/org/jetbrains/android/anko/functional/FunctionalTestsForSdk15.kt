package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.config.*
import org.junit.Test
public class FunctionalTestsForSdk15 : AbstractFunctionalTest() {
    val version = "sdk15"

    @Test public fun testComplexListenerClassTest() {
        runFunctionalTest("ComplexListenerClassTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
        }
    }

    @Test public fun testComplexListenerSetterTest() {
        runFunctionalTest("ComplexListenerSetterTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
        }
    }

    @Test public fun testHelperConstructorTest() {
        runFunctionalTest("HelperConstructorTest.kt", AnkoFile.VIEWS, version) {
            tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
        }
    }

    @Test public fun testLayoutsTest() {
        runFunctionalTest("LayoutsTest.kt", AnkoFile.LAYOUTS, version) {
            files.add(AnkoFile.LAYOUTS)
        }
    }

    @Test public fun testViewTest() {
        runFunctionalTest("ViewTest.kt", AnkoFile.VIEWS, version) {
            files.add(AnkoFile.VIEWS)
            tunes.add(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
        }
    }

    @Test public fun testPropertyTest() {
        runFunctionalTest("PropertyTest.kt", AnkoFile.PROPERTIES, version) {
            files.add(AnkoFile.PROPERTIES)
        }
    }

    @Test public fun testServicesTest() {
        runFunctionalTest("ServicesTest.kt", AnkoFile.SERVICES, version) {
            files.add(AnkoFile.SERVICES)
        }
    }

    @Test public fun testSimpleListenerTest() {
        runFunctionalTest("SimpleListenerTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
        }
    }

    @Test public fun testInterfaceWorkaroundsTest() {
        runFunctionalTest("InterfaceWorkaroundsTest.kt", AnkoFile.INTERFACE_WORKAROUNDS_JAVA, version) {
            files.add(AnkoFile.INTERFACE_WORKAROUNDS_JAVA)
        }
    }

    @Test public fun testSqlParserHelpersTest() {
        runFunctionalTest("SqlParserHelpersTest.kt", AnkoFile.SQL_PARSER_HELPERS, version) {
            files.add(AnkoFile.SQL_PARSER_HELPERS)
        }
    }

}
