package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class ComplexListenerSetterTest : AbstractFunctionalTest() {
    private val testDataFile = "ComplexListenerSetterTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
    }
    [Test] public fun testComplexListenerSetterTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21")
    }
    [Test] public fun testComplexListenerSetterTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21s")
    }
}
