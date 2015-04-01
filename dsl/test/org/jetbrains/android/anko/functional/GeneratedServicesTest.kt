package org.jetbrains.android.anko.functional
import org.jetbrains.android.anko.*
import org.junit.Test
public class ServicesTest : AbstractFunctionalTest() {
    private val testDataFile = "ServicesTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(AnkoFile.SERVICES)
    }
    [Test] public fun testServicesTestFor15() {
        runFunctionalTest(testDataFile, AnkoFile.SERVICES, "15")
    }
    [Test] public fun testServicesTestFor15s() {
        runFunctionalTest(testDataFile, AnkoFile.SERVICES, "15s")
    }
    [Test] public fun testServicesTestFor21() {
        runFunctionalTest(testDataFile, AnkoFile.SERVICES, "21")
    }
    [Test] public fun testServicesTestFor21s() {
        runFunctionalTest(testDataFile, AnkoFile.SERVICES, "21s")
    }
}
