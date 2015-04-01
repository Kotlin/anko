package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class PropertyTest : AbstractFunctionalTest() {
    private val testDataFile = "PropertyTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.PROPERTIES)
    }
    [Test] public fun testPropertyTestFor15() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "15")
    }
    [Test] public fun testPropertyTestFor15s() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "15s")
    }
    [Test] public fun testPropertyTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "21")
    }
    [Test] public fun testPropertyTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "21s")
    }
}
