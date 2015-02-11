package org.jetbrains.android.dsl.robolectric

import org.jetbrains.android.dsl.*
import org.jetbrains.android.dsl.compile.CompileTestFixture
import org.testng.annotations.*
import kotlin.platform.platformStatic

public class GeneratedRobolectricTest : AbstractRobolectricTest() {
    class object {
        BeforeClass platformStatic fun setUpClass() = CompileTestFixture.setUpClass()
        AfterClass platformStatic fun tearDownClass() = CompileTestFixture.tearDownClass()
    }

    [Test] public fun testFindViewTestFor15() {
        runRobolectricTest("FindViewTest.kt", "15")
    }

    [Test] public fun testFindViewTestFor15s() {
        runRobolectricTest("FindViewTest.kt", "15s")
    }

    [Test] public fun testFindViewTestFor19() {
        runRobolectricTest("FindViewTest.kt", "19")
    }

    [Test] public fun testFindViewTestFor19s() {
        runRobolectricTest("FindViewTest.kt", "19s")
    }

    [Test] public fun testFindViewTestFor21() {
        runRobolectricTest("FindViewTest.kt", "21")
    }

    [Test] public fun testFindViewTestFor21s() {
        runRobolectricTest("FindViewTest.kt", "21s")
    }

    [Test] public fun testServiceTestFor15() {
        runRobolectricTest("ServiceTest.kt", "15")
    }

    [Test] public fun testServiceTestFor15s() {
        runRobolectricTest("ServiceTest.kt", "15s")
    }

    [Test] public fun testServiceTestFor19() {
        runRobolectricTest("ServiceTest.kt", "19")
    }

    [Test] public fun testServiceTestFor19s() {
        runRobolectricTest("ServiceTest.kt", "19s")
    }

    [Test] public fun testServiceTestFor21() {
        runRobolectricTest("ServiceTest.kt", "21")
    }

    [Test] public fun testServiceTestFor21s() {
        runRobolectricTest("ServiceTest.kt", "21s")
    }

    [Test] public fun testSimpleTestFor15() {
        runRobolectricTest("SimpleTest.kt", "15")
    }

    [Test] public fun testSimpleTestFor15s() {
        runRobolectricTest("SimpleTest.kt", "15s")
    }

    [Test] public fun testSimpleTestFor19() {
        runRobolectricTest("SimpleTest.kt", "19")
    }

    [Test] public fun testSimpleTestFor19s() {
        runRobolectricTest("SimpleTest.kt", "19s")
    }

    [Test] public fun testSimpleTestFor21() {
        runRobolectricTest("SimpleTest.kt", "21")
    }

    [Test] public fun testSimpleTestFor21s() {
        runRobolectricTest("SimpleTest.kt", "21s")
    }

}
