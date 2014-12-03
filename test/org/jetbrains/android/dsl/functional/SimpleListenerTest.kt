package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class SimpleListenerTest : AbstractFunctionalTest() {
    private val testDataFile = "SimpleListenerTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
    }
    [Test] public fun testSimpleListenerTestFor19() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "19")
    }
    [Test] public fun testSimpleListenerTestFor19s() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "19s")
    }
}
