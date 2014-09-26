package org.jetbrains.android.dsl.tests.functional;

import org.jetbrains.android.dsl.BaseGeneratorProps;
import org.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertyTest extends BaseFunctionalTest {
    private final String testDataFile = "org/jetbrains/android/dsl/tests/functional/PropertyTest.kt";

    @Override
    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
    }

    protected void initSettings(BaseGeneratorProps settings) {
        settings.setGenerateProperties(true);
        settings.setGeneratePropertySetters(true);
    }

    @Test
    public void testProperties() throws Exception {
        runFunctionalTest(testDataFile, Subsystem.PROPERTIES);
    }
}
