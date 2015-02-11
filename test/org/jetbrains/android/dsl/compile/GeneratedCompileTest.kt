package org.jetbrains.android.dsl.compile

import org.jetbrains.android.dsl.*
import org.jetbrains.android.dsl.compile.CompileTestFixture
import org.testng.annotations.*
import kotlin.platform.platformStatic

public class GeneratedCompileTest : AbstractCompileTest() {
    class object {
        BeforeClass platformStatic fun setUpClass() = CompileTestFixture.setUpClass()
        AfterClass platformStatic fun tearDownClass() = CompileTestFixture.tearDownClass()
    }

    [Test] public fun testAndroidLayoutParamsTestFor15() {
        runCompileTest("AndroidLayoutParamsTest.kt", "15")
    }

    [Test] public fun testAndroidLayoutParamsTestFor15s() {
        runCompileTest("AndroidLayoutParamsTest.kt", "15s")
    }

    [Test] public fun testAndroidLayoutParamsTestFor19() {
        runCompileTest("AndroidLayoutParamsTest.kt", "19")
    }

    [Test] public fun testAndroidLayoutParamsTestFor19s() {
        runCompileTest("AndroidLayoutParamsTest.kt", "19s")
    }

    [Test] public fun testAndroidLayoutParamsTestFor21() {
        runCompileTest("AndroidLayoutParamsTest.kt", "21")
    }

    [Test] public fun testAndroidLayoutParamsTestFor21s() {
        runCompileTest("AndroidLayoutParamsTest.kt", "21s")
    }

    [Test] public fun testAndroidLayoutsTestFor15() {
        runCompileTest("AndroidLayoutsTest.kt", "15")
    }

    [Test] public fun testAndroidLayoutsTestFor15s() {
        runCompileTest("AndroidLayoutsTest.kt", "15s")
    }

    [Test] public fun testAndroidLayoutsTestFor19() {
        runCompileTest("AndroidLayoutsTest.kt", "19")
    }

    [Test] public fun testAndroidLayoutsTestFor19s() {
        runCompileTest("AndroidLayoutsTest.kt", "19s")
    }

    [Test] public fun testAndroidLayoutsTestFor21() {
        runCompileTest("AndroidLayoutsTest.kt", "21")
    }

    [Test] public fun testAndroidLayoutsTestFor21s() {
        runCompileTest("AndroidLayoutsTest.kt", "21s")
    }

    [Test] public fun testAndroidListenerHelpersTestFor15() {
        runCompileTest("AndroidListenerHelpersTest.kt", "15")
    }

    [Test] public fun testAndroidListenerHelpersTestFor15s() {
        runCompileTest("AndroidListenerHelpersTest.kt", "15s")
    }

    [Test] public fun testAndroidListenerHelpersTestFor19() {
        runCompileTest("AndroidListenerHelpersTest.kt", "19")
    }

    [Test] public fun testAndroidListenerHelpersTestFor19s() {
        runCompileTest("AndroidListenerHelpersTest.kt", "19s")
    }

    [Test] public fun testAndroidListenerHelpersTestFor21() {
        runCompileTest("AndroidListenerHelpersTest.kt", "21")
    }

    [Test] public fun testAndroidListenerHelpersTestFor21s() {
        runCompileTest("AndroidListenerHelpersTest.kt", "21s")
    }

    [Test] public fun testAndroidMultiMethodListenersFor15() {
        runCompileTest("AndroidMultiMethodListeners.kt", "15")
    }

    [Test] public fun testAndroidMultiMethodListenersFor15s() {
        runCompileTest("AndroidMultiMethodListeners.kt", "15s")
    }

    [Test] public fun testAndroidMultiMethodListenersFor19() {
        runCompileTest("AndroidMultiMethodListeners.kt", "19")
    }

    [Test] public fun testAndroidMultiMethodListenersFor19s() {
        runCompileTest("AndroidMultiMethodListeners.kt", "19s")
    }

    [Test] public fun testAndroidMultiMethodListenersFor21() {
        runCompileTest("AndroidMultiMethodListeners.kt", "21")
    }

    [Test] public fun testAndroidMultiMethodListenersFor21s() {
        runCompileTest("AndroidMultiMethodListeners.kt", "21s")
    }

    [Test] public fun testAndroidPropertiesTestFor15() {
        runCompileTest("AndroidPropertiesTest.kt", "15")
    }

    [Test] public fun testAndroidPropertiesTestFor15s() {
        runCompileTest("AndroidPropertiesTest.kt", "15s")
    }

    [Test] public fun testAndroidPropertiesTestFor19() {
        runCompileTest("AndroidPropertiesTest.kt", "19")
    }

    [Test] public fun testAndroidPropertiesTestFor19s() {
        runCompileTest("AndroidPropertiesTest.kt", "19s")
    }

    [Test] public fun testAndroidPropertiesTestFor21() {
        runCompileTest("AndroidPropertiesTest.kt", "21")
    }

    [Test] public fun testAndroidPropertiesTestFor21s() {
        runCompileTest("AndroidPropertiesTest.kt", "21s")
    }

    [Test] public fun testAndroidSimpleTestFor15() {
        runCompileTest("AndroidSimpleTest.kt", "15")
    }

    [Test] public fun testAndroidSimpleTestFor15s() {
        runCompileTest("AndroidSimpleTest.kt", "15s")
    }

    [Test] public fun testAndroidSimpleTestFor19() {
        runCompileTest("AndroidSimpleTest.kt", "19")
    }

    [Test] public fun testAndroidSimpleTestFor19s() {
        runCompileTest("AndroidSimpleTest.kt", "19s")
    }

    [Test] public fun testAndroidSimpleTestFor21() {
        runCompileTest("AndroidSimpleTest.kt", "21")
    }

    [Test] public fun testAndroidSimpleTestFor21s() {
        runCompileTest("AndroidSimpleTest.kt", "21s")
    }

    [Test] public fun testAndroidWidgetTestFor15() {
        runCompileTest("AndroidWidgetTest.kt", "15")
    }

    [Test] public fun testAndroidWidgetTestFor15s() {
        runCompileTest("AndroidWidgetTest.kt", "15s")
    }

    [Test] public fun testAndroidWidgetTestFor19() {
        runCompileTest("AndroidWidgetTest.kt", "19")
    }

    [Test] public fun testAndroidWidgetTestFor19s() {
        runCompileTest("AndroidWidgetTest.kt", "19s")
    }

    [Test] public fun testAndroidWidgetTestFor21() {
        runCompileTest("AndroidWidgetTest.kt", "21")
    }

    [Test] public fun testAndroidWidgetTestFor21s() {
        runCompileTest("AndroidWidgetTest.kt", "21s")
    }

}
