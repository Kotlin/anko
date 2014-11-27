/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl.tests.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class AndroidBigRuntimeTest extends BaseCompileTest {

    private final File testLayoutsDataFile = new File("testdata/compile/AndroidLayoutsTest.kt");
    private final File testPropertiesDataFile = new File("testdata/compile/AndroidPropertiesTest.kt");
    private final File testSimpleDataFile = new File("testdata/compile/AndroidSimpleTest.kt");
    private final File testWidgetsDataFile = new File("testdata/compile/AndroidWidgetTest.kt");
    private final File testLayoutParamsDataFile = new File("testdata/compile/AndroidLayoutParamsTest.kt");
    private final File testListenerHelpersDataFile = new File("testdata/compile/AndroidListenerHelpersTest.kt");
    private final File testMultiMethodListenersFile = new File("testdata/compile/AndroidMultiMethodListeners.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testProperties() throws Exception {
        runCompileTest(testPropertiesDataFile);
    }

    @Test
    public void testSimple() throws Exception {
        runCompileTest(testSimpleDataFile);
    }

    @Test
    public void testWidgets() throws Exception {
        runCompileTest(testWidgetsDataFile);
    }

    @Test
    public void testLayouts() throws Exception {
        runCompileTest(testLayoutsDataFile);
    }

    @Test
    public void testLayoutParams() throws Exception {
        runCompileTest(testLayoutParamsDataFile);
    }

    @Test
    public void testListenerHelpers() throws Exception {
        runCompileTest(testListenerHelpersDataFile);
    }

    @Test
    public void testMultiMethodListeners() throws Exception {
        runCompileTest(testMultiMethodListenersFile);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
