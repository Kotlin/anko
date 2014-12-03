package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class PropertyTest : AbstractFunctionalTest() {
    private val testDataFile = "PropertyTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.PROPERTIES)
    }
    [Test] public fun testPropertyTestFor19() {
        runFunctionalTest(testDataFile, KoanFile.PROPERTIES, "19")
    }
    [Test] public fun testPropertyTestFor19s() {
        runFunctionalTest(testDataFile, KoanFile.PROPERTIES, "19s")
    }
}
