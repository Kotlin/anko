package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class HelperConstructorTest : AbstractFunctionalTest() {
    private val testDataFile = "HelperConstructorTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.tunes.add(ConfigurationTune.HELPER_CONSTRUCTORS)
    }
    [Test] public fun testHelperConstructorTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.VIEWS, "21")
    }
    [Test] public fun testHelperConstructorTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.VIEWS, "21s")
    }
}
