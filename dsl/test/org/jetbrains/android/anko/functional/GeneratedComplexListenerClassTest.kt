package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class ComplexListenerClassTest : AbstractFunctionalTest() {
    private val testDataFile = "ComplexListenerClassTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
    }
    [Test] public fun testComplexListenerClassTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21")
    }
    [Test] public fun testComplexListenerClassTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21s")
    }
}
