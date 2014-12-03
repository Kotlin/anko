package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class HelperConstructorTest : AbstractFunctionalTest() {
    private val testDataFile = "HelperConstructorTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
    }
    [Test] public fun testHelperConstructorTestFor19() {
        runFunctionalTest(testDataFile, KoanFile.VIEWS, "19")
    }
    [Test] public fun testHelperConstructorTestFor19s() {
        runFunctionalTest(testDataFile, KoanFile.VIEWS, "19s")
    }
}
