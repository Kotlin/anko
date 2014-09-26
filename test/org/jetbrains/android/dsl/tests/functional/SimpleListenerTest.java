package org.jetbrains.android.dsl.tests.functional;

import org.jetbrains.android.dsl.BaseGeneratorProps;
import org.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleListenerTest extends BaseFunctionalTest {

    private final String testDataFile = "org/jetbrains/android/dsl/tests/functional/SimpleListenerTest.kt";

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

