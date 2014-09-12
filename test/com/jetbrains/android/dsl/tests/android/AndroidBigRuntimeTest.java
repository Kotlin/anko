package com.jetbrains.android.dsl.tests.android;

import com.jetbrains.android.dsl.DSLGenerator;
import com.jetbrains.android.dsl.GeneratorProps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class AndroidBigRuntimeTest extends BaseCompileTest {

    private final File testLayoutsDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidLayoutsTest.kt");
    private final File testPropertiesDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidPropertiesTest.kt");
    private final File testSimpleDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidSimpleTest.kt");
    private final File testWidgetsDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidWidgetTest.kt");
    private final File testLayoutParamsDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidLayoutParamsTest.kt");
    private final File testListenerHelpersDataFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidListenerHelpersTest.kt");
    private final File testMultiMethodListenersFile = new File("testdata/com/jetbrains/android/dsl/tests/android/AndroidMultiMethodListeners.kt");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();

        DSLGenerator generator = new DSLGenerator(new String[]{inputJarFile}, new AndroidTestGeneratorProps());
        generator.run();
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
