package org.jetbrains.android.dsl.tests.functional;

import org.jetbrains.android.dsl.BaseGeneratorProps;
import org.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComplexListenerClassTest extends BaseFunctionalTest {
    private final String testDataFile = "org/jetbrains/android/dsl/tests/functional/ComplexListenerClassTest.kt";

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorProps settings) {
        settings.setGenerateComplexListenerClasses(true);
    }

    @Test
    public void testComplexListeners() throws Exception {
        runFunctionalTest(testDataFile, Subsystem.LISTENERS);
    }
}

