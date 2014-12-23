package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class ComplexListenerSetterTest : AbstractFunctionalTest() {
    private val testDataFile = "ComplexListenerSetterTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
    }
    [Test] public fun testComplexListenerSetterTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21")
    }
    [Test] public fun testComplexListenerSetterTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21s")
    }
}
