package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.config.*
import org.junit.Test
class FunctionalTestsForSdk23 : AbstractFunctionalTest() {
    val version = "sdk23"

    @Test
    fun testComplexListenerClassTest() {
        runFunctionalTest("ComplexListenerClassTest.kt", AnkoFile.LISTENERS, version) {
            options[AnkoFile.LISTENERS] = true
            options[Tune.COMPLEX_LISTENER_CLASSES] = true
        }
    }

    @Test
    fun testComplexListenerSetterTest() {
        runFunctionalTest("ComplexListenerSetterTest.kt", AnkoFile.LISTENERS, version) {
            options[AnkoFile.LISTENERS] = true
            options[Tune.COMPLEX_LISTENER_SETTERS] = true
        }
    }

    @Test
    fun testLayoutsTest() {
        runFunctionalTest("LayoutsTest.kt", AnkoFile.LAYOUTS, version) {
            options[AnkoFile.LAYOUTS] = true
        }
    }

    @Test
    fun testViewTest() {
        runFunctionalTest("ViewTest.kt", AnkoFile.VIEWS, version) {
            options[AnkoFile.VIEWS] = true
            options[Tune.HELPER_CONSTRUCTORS] = true
            options[Tune.TOP_LEVEL_DSL_ITEMS] = true
        }
    }

    @Test
    fun testPropertyTest() {
        runFunctionalTest("PropertyTest.kt", AnkoFile.PROPERTIES, version) {
            options[AnkoFile.PROPERTIES] = true
        }
    }

    @Test
    fun testServicesTest() {
        runFunctionalTest("ServicesTest.kt", AnkoFile.SERVICES, version) {
            options[AnkoFile.SERVICES] = true
        }
    }

    @Test
    fun testSimpleListenerTest() {
        runFunctionalTest("SimpleListenerTest.kt", AnkoFile.LISTENERS, version) {
            options[AnkoFile.LISTENERS] = true
            options[Tune.SIMPLE_LISTENERS] = true
        }
    }

    @Test
    fun testSqlParserHelpersTest() {
        runFunctionalTest("SqlParserHelpersTest.kt", AnkoFile.SQL_PARSER_HELPERS, version) {
            options[AnkoFile.SQL_PARSER_HELPERS] = true
        }
    }

}
