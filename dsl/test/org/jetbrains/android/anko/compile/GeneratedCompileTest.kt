/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.android.anko.compile

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.compile.CompileTestFixture
import org.testng.annotations.*
import kotlin.platform.platformStatic

public class GeneratedCompileTest : AbstractCompileTest() {
    companion object {
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
