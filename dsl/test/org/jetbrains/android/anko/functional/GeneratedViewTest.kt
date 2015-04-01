package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class ViewTest : AbstractFunctionalTest() {
    private val testDataFile = "ViewTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.VIEWS)
        settings.tunes.add(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
    }
    [Test] public fun testViewTestFor15() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "15")
    }
    [Test] public fun testViewTestFor15s() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "15s")
    }
    [Test] public fun testViewTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "21")
    }
    [Test] public fun testViewTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.VIEWS, "21s")
    }
}
