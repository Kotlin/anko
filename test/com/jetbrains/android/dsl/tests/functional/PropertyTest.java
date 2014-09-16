package com.jetbrains.android.dsl.tests.functional;

import com.jetbrains.android.dsl.BaseGeneratorProps;
import com.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class PropertyTest extends BaseFunctionalTest {
    private final String testDataFile = "com/jetbrains/android/dsl/tests/functional/PropertyTest.kt";

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
