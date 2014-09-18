package com.jetbrains.android.dsl.tests.functional;

import com.jetbrains.android.dsl.BaseGeneratorProps;
import com.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleListenerTest extends BaseFunctionalTest {

    private final String testDataFile = "com/jetbrains/android/dsl/tests/functional/SimpleListenerTest.kt";

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorProps settings) {
        settings.setGenerateSimpleListeners(true);
    }

    @Test
    public void testSimpleListeners() throws Exception {
        runFunctionalTest(testDataFile, Subsystem.LISTENERS);
    }
}

