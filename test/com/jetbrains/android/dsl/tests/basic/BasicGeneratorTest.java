package com.jetbrains.android.dsl.tests.basic;

import com.jetbrains.android.dsl.tests.TestGeneratorProps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ifmo.rain.adsl.Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BasicGeneratorTest extends Assert {

    private final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    private final String inputJarFile = "android.jar";
    private final String tmpJarFile = this.getClass() + "out.jar";

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File(inputJarFile).exists());
        assertTrue(new File("imports.txt").exists());
        assertTrue(new File("cont_header.txt").exists());
        assertTrue(new File("class_blacklist.txt").exists());
        assertTrue(new File("prop_blacklist.txt").exists());
        assertTrue(new File("footer.txt").exists());
        assertTrue(new File(kotlincFilename).exists());
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

    @Test
    public void testResultCompiles() throws Exception {
        TestGeneratorProps settings = new TestGeneratorProps();
        Generator gen = new Generator(inputJarFile, "android.widget", settings);
        gen.run();
        String kotlincArgs[] = {kotlincFilename,
                "-jar", tmpJarFile,
                "-classpath", inputJarFile,
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

    @Test
    public void testResultExists() throws Exception {
        TestGeneratorProps settings = new TestGeneratorProps();
        Generator gen = new Generator(inputJarFile, "android.widget", settings);
        gen.run();
        for (File file: settings.tmpFiles.values()) {
            assertTrue(file.length() > 0);
        }
        for (File file: settings.tmpFiles.values()) {
            file.delete();
        }
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
