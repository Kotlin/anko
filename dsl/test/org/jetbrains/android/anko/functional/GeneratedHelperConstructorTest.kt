package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class HelperConstructorTest : AbstractFunctionalTest() {
    private val testDataFile = "HelperConstructorTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
    }
    [Test] public fun testHelperConstructorTestFor15() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "15")
    }
    [Test] public fun testHelperConstructorTestFor15s() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "15s")
    }
    [Test] public fun testHelperConstructorTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "21")
    }
    [Test] public fun testHelperConstructorTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "21s")
    }
}
