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

package org.jetbrains.android.dsl.tests.functional;

import org.jetbrains.android.dsl.BaseGeneratorConfiguration;
import org.jetbrains.android.dsl.ConfigurationTune;
import org.jetbrains.android.dsl.KoanFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComplexListenerSetterTest extends BaseFunctionalTest {
    private final String testDataFile = "ComplexListenerSetterTest.kt";

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorConfiguration settings) {
        settings.getFiles().add(KoanFile.LISTENERS);
        settings.getTunes().add(ConfigurationTune.COMPLEX_LISTENER_SETTERS);
    }

    @Test
    public void testComplexListenerSetters() throws Exception {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS);
    }
}

