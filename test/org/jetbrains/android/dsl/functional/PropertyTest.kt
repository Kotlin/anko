package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class PropertyTest : AbstractFunctionalTest() {
    private val testDataFile = "PropertyTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.PROPERTIES)
    }
    [Test] public fun testPropertyTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.PROPERTIES, "21")
    }
    [Test] public fun testPropertyTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.PROPERTIES, "21s")
    }
}
