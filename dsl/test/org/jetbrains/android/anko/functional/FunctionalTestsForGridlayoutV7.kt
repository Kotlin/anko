package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.config.*
import org.junit.Test
class FunctionalTestsForGridlayoutV7 : AbstractFunctionalTest() {
    val version = "gridlayout-v7"

    @Test
    fun testComplexListenerClassTest() {
        runFunctionalTest("ComplexListenerClassTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
        }
    }

    @Test
    fun testComplexListenerSetterTest() {
        runFunctionalTest("ComplexListenerSetterTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
        }
    }

    @Test
    fun testLayoutsTest() {
        runFunctionalTest("LayoutsTest.kt", AnkoFile.LAYOUTS, version) {
            files.add(AnkoFile.LAYOUTS)
        }
    }

    @Test
    fun testViewTest() {
        runFunctionalTest("ViewTest.kt", AnkoFile.VIEWS, version) {
            files.add(AnkoFile.VIEWS)
            tunes.add(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
            tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
        }
    }

    @Test
    fun testPropertyTest() {
        runFunctionalTest("PropertyTest.kt", AnkoFile.PROPERTIES, version) {
            files.add(AnkoFile.PROPERTIES)
        }
    }

    @Test
    fun testServicesTest() {
        runFunctionalTest("ServicesTest.kt", AnkoFile.SERVICES, version) {
            files.add(AnkoFile.SERVICES)
        }
    }

    @Test
    fun testSimpleListenerTest() {
        runFunctionalTest("SimpleListenerTest.kt", AnkoFile.LISTENERS, version) {
            files.add(AnkoFile.LISTENERS)
            tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
        }
    }

    @Test
    fun testSqlParserHelpersTest() {
        runFunctionalTest("SqlParserHelpersTest.kt", AnkoFile.SQL_PARSER_HELPERS, version) {
            files.add(AnkoFile.SQL_PARSER_HELPERS)
        }
    }

}
