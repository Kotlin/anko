package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class LayoutsTest : AbstractFunctionalTest() {
    private val testDataFile = "LayoutsTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LAYOUTS)
    }
    [Test] public fun testLayoutsTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.LAYOUTS, "21")
    }
    [Test] public fun testLayoutsTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.LAYOUTS, "21s")
    }
}
