package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class ComplexListenerSetterTest : AbstractFunctionalTest() {
    private val testDataFile = "ComplexListenerSetterTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
    }
    [Test] public fun testComplexListenerSetterTestFor19() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "19")
    }
    [Test] public fun testComplexListenerSetterTestFor19s() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "19s")
    }
}
