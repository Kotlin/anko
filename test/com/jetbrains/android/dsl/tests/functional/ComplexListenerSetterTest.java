package com.jetbrains.android.dsl.tests.functional;

import com.jetbrains.android.dsl.BaseGeneratorProps;
import com.jetbrains.android.dsl.Subsystem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ComplexListenerSetterTest extends BaseFunctionalTest {
	private final String testDataFile = "com/jetbrains/android/dsl/tests/functional/ComplexListenerSetterTest.kt";

	@Override
	@BeforeMethod
	public void setUp() throws Exception {
		super.setUp();
	}

	protected void initSettings(BaseGeneratorProps settings) {
		settings.setGenerateImports(false);
		settings.setGeneratePackage(false);

		settings.setGenerateProperties(false);
		settings.setGeneratePropertySetters(false);
		settings.setGenerateLayoutParamsHelperClasses(false);
		settings.setGenerateViewExtensionMethods(false);
		settings.setGenerateViewHelperConstructors(false);
		settings.setGenerateViewGroupExtensionMethods(false);
		settings.setGenerateSimpleListeners(false);
		settings.setGenerateComplexListenerClasses(false);
		settings.setGenerateComplexListenerSetters(true);
	}

	@Test
	public void testComplexListenerSetters() throws Exception {
		runFunctionalTest(testDataFile, Subsystem.LISTENERS);
	}
}

