package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class ComplexListenerClassTest : AbstractFunctionalTest() {
    private val testDataFile = "ComplexListenerClassTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
    }
    [Test] public fun testComplexListenerClassTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21")
    }
    [Test] public fun testComplexListenerClassTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21s")
    }
}
