package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class LayoutsTest : AbstractFunctionalTest() {
    private val testDataFile = "LayoutsTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.LAYOUTS)
    }
    [Test] public fun testLayoutsTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.LAYOUTS, "21")
    }
    [Test] public fun testLayoutsTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.LAYOUTS, "21s")
    }
}
