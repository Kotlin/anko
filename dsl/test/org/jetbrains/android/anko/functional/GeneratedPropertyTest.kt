package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class PropertyTest : AbstractFunctionalTest() {
    private val testDataFile = "PropertyTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.PROPERTIES)
    }
    [Test] public fun testPropertyTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "21")
    }
    [Test] public fun testPropertyTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.PROPERTIES, "21s")
    }
}
