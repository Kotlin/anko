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

package org.jetbrains.android.anko.robolectric

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.compile.CompileTestFixture
import org.testng.annotations.*
import kotlin.platform.platformStatic

public class GeneratedRobolectricTest : AbstractRobolectricTest() {
    companion object {
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
