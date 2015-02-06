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

package org.jetbrains.android.dsl.android

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import java.io.File
import org.testng.annotations.BeforeClass
import org.testng.annotations.AfterClass

public class AndroidBigRuntimeTest : BaseCompileTest() {

    private val testLayoutsDataFile = File("testData/compile/AndroidLayoutsTest.kt")
    private val testPropertiesDataFile = File("testData/compile/AndroidPropertiesTest.kt")
    private val testSimpleDataFile = File("testData/compile/AndroidSimpleTest.kt")
    private val testWidgetsDataFile = File("testData/compile/AndroidWidgetTest.kt")
    private val testLayoutParamsDataFile = File("testData/compile/AndroidLayoutParamsTest.kt")
    private val testListenerHelpersDataFile = File("testData/compile/AndroidListenerHelpersTest.kt")
    private val testMultiMethodListenersFile = File("testData/compile/AndroidMultiMethodListeners.kt")

    BeforeClass
    override fun setUpClass() {
        super.setUpClass()
    }

    Test
    public fun testProperties() {
        runCompileTest(testPropertiesDataFile)
    }

    Test
    public fun testSimple() {
        runCompileTest(testSimpleDataFile)
    }

    Test
    public fun testWidgets() {
        runCompileTest(testWidgetsDataFile)
    }

    Test
    public fun testLayouts() {
        runCompileTest(testLayoutsDataFile)
    }

    Test
    public fun testLayoutParams() {
        runCompileTest(testLayoutParamsDataFile)
    }

    Test
    public fun testListenerHelpers() {
        runCompileTest(testListenerHelpersDataFile)
    }

    Test
    public fun testMultiMethodListeners() {
        runCompileTest(testMultiMethodListenersFile)
    }

    AfterMethod
    override fun tearDown() {
        super.tearDown()
    }

    AfterClass
    override fun tearDownClass() {
        super.tearDownClass()
    }
}
