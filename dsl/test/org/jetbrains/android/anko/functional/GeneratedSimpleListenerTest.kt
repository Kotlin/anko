package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class SimpleListenerTest : AbstractFunctionalTest() {
    private val testDataFile = "SimpleListenerTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
    }
    [Test] public fun testSimpleListenerTestFor15() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "15")
    }
    [Test] public fun testSimpleListenerTestFor15s() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "15s")
    }
    [Test] public fun testSimpleListenerTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21")
    }
    [Test] public fun testSimpleListenerTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.LISTENERS, "21s")
    }
}
