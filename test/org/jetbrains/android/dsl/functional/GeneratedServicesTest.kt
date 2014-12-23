package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class ServicesTest : AbstractFunctionalTest() {
    private val testDataFile = "ServicesTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.SERVICES)
    }
    [Test] public fun testServicesTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.SERVICES, "21")
    }
    [Test] public fun testServicesTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.SERVICES, "21s")
    }
}
