package com.jetbrains.android.dsl.tests.android;

import com.jetbrains.android.dsl.DSLGenerator;
import com.jetbrains.android.dsl.tests.TestGeneratorProps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.jetbrains.android.dsl.Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseCompileTest extends Assert {
    private final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    final String inputJarFile = "android.jar";
    final String tmpJarFile = this.getClass() + "out.jar";

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File(inputJarFile).exists());
        assertTrue(new File("props/imports_layouts.txt").exists());
        assertTrue(new File("props/imports_views.txt").exists());
        assertTrue(new File("props/custom_method_parameters.txt").exists());
        assertTrue(new File("props/excluded_classes.txt").exists());
        assertTrue(new File("props/excluded_methods.txt").exists());
        assertTrue(new File("props/helper_constructors.txt").exists());
        assertTrue(new File("props/helper.txt").exists());
        assertTrue(new File(kotlincFilename).exists());
    }

    protected void runCompileTest(File testData) throws IOException, InterruptedException {
        assertTrue(testData.exists());
        TestGeneratorProps settings = new AndroidTestGeneratorProps();
        DSLGenerator gen = new DSLGenerator(new String[] {inputJarFile}, settings);
        gen.run();
        String kotlincArgs[] = {
            kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
                testData.getPath()
        };
        ArrayList<String> args = new ArrayList<>(Arrays.asList(kotlincArgs));
        for (File file: settings.tmpFiles.values()) {
            args.add(file.getAbsolutePath());
        }
        ProcResult res = compile(args.toArray(new String[args.size()]));
        assertEquals(res.stderr, "");
        for (File file: settings.tmpFiles.values()) {
            file.delete();
        }
    }

    protected ProcResult compile(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(args);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String str;
        while (((str = br1.readLine()) != null) && (br2.readLine() != null)) {
            if (str.startsWith("ERROR"))
                errors.append(str);
        }
        p.waitFor();
        return new ProcResult(errors.toString(), p.exitValue());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }

    class ProcResult {
        public String stderr;
        public int exitCode;

        ProcResult(String stderr, int exitCode) {
            this.stderr = stderr;
            this.exitCode = exitCode;
        }
    }
}
