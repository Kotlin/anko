package com.jetbrains.android.dsl.tests.functional;

import com.jetbrains.android.dsl.tests.TestGeneratorProps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.jetbrains.android.dsl.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class BaseFunctionalTest extends Assert {
    protected final String inputJarFile = "android.jar";
    protected DSLGenerator generator;

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File(inputJarFile).exists());
        assertTrue(new File("props/imports_layouts.txt").exists());
        assertTrue(new File("props/imports_views.txt").exists());
        assertTrue(new File("props/custom_method_parameters.txt").exists());
        assertTrue(new File("props/excluded_classes.txt").exists());
        assertTrue(new File("props/excluded_methods.txt").exists());
        assertTrue(new File("props/helper_constructors.txt").exists());
    }

    protected String loadOrCreate(File file, String data) throws IOException {
        try {
            return DslPackage.readFile(file.getAbsolutePath());
        } catch (Exception e) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
            fail("Empty expected data, creating from actual");
            return data;
        }
    }

    protected void runFunctionalTest(String testDataFile, Subsystem subsystem, TestGeneratorProps settings) throws IOException {
        initSettings(settings);
        generator = new DSLGenerator(new String[]{inputJarFile}, settings);
        generator.run();

        String actual = DslPackage.readFile(settings.tmpFiles.get(subsystem).getAbsolutePath());
        String expected = loadOrCreate(new File("testdata/" + testDataFile), actual);

        assertEquals(actual, expected);
        assertTrue(actual.length() > 0);
        assertTrue(expected.length() > 0);
    }

    protected void runFunctionalTest(String testDataFile, Subsystem subsystem) throws IOException {
        TestGeneratorProps settings = new TestGeneratorProps();
        runFunctionalTest(testDataFile, subsystem, settings);
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    protected abstract void initSettings(BaseGeneratorProps settings);
}
