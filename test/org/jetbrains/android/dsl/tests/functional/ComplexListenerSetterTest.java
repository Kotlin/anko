package org.jetbrains.android.dsl.tests.functional;

import org.jetbrains.android.dsl.BaseGeneratorProps;
import org.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComplexListenerSetterTest extends BaseFunctionalTest {
    private final String testDataFile = "org/jetbrains/android/dsl/tests/functional/ComplexListenerSetterTest.kt";

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorProps settings) {
        settings.setGenerateComplexListenerSetters(true);
    }

    @Test
    public void testComplexListenerSetters() throws Exception {
        runFunctionalTest(testDataFile, Subsystem.LISTENERS);
    }
}

