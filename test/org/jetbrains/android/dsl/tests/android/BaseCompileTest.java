/*
 * Copyright 2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.android.dsl.tests.android;

import org.jetbrains.android.dsl.DSLGenerator;
import org.jetbrains.android.dsl.utils.DirectoryFilter;
import org.jetbrains.android.dsl.utils.JarFilter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseCompileTest extends Assert {
    private final String kotlincFilename = "lib/kotlinc/bin/kotlinc-jvm";
    final String tmpJarFile = /*this.getClass() + */ "out.jar";

    private static final FileFilter directoryFilter = new DirectoryFilter();
    private static final FileFilter jarFilter = new JarFilter();

    @BeforeMethod
    public void setUp() throws Exception {
        assertTrue(new File("props/imports_layouts.txt").exists());
        assertTrue(new File("props/imports_views.txt").exists());
        assertTrue(new File("props/custom_method_parameters.txt").exists());
        assertTrue(new File("props/excluded_classes.txt").exists());
        assertTrue(new File("props/excluded_methods.txt").exists());
        assertTrue(new File("props/helper_constructors.txt").exists());
        assertTrue(new File("props/static/src/Helpers.kt").exists());
        assertTrue(new File("props/static/src/Support.kt").exists());
        assertTrue(new File("props/static/src/Custom.kt").exists());
        assertTrue(new File("props/static/src/Async.kt").exists());
        assertTrue(new File("props/static/src/ContextUtils.kt").exists());
        assertTrue(new File("props/static/src/Dialogs.kt").exists());
        assertTrue(new File(kotlincFilename).exists());
    }

    protected void runCompileTest(File testData) throws IOException, InterruptedException {
        assertTrue(testData.exists());

        File[] versions = new File("original/").listFiles(directoryFilter);
        for (File ver: versions) {
            AndroidTestGeneratorProps props = compile(testData, ver);
            for (File file : props.tmpFiles.values()) {
                file.delete();
            }
        }
    }

    private AndroidTestGeneratorProps compile(File testData, File ver) throws IOException, InterruptedException {
        String fVersion = ver.getName();
        int version = Integer.parseInt(fVersion.replaceAll("[^0-9]", ""));

        List<File> jarFiles = Arrays.asList(ver.listFiles(jarFilter));
        List<String> jarFilesString = new ArrayList<>();
        StringBuilder classpath = new StringBuilder();
        for (File f: jarFiles) {
            jarFilesString.add(f.getAbsolutePath());
            if (classpath.length()>0) {
                classpath.append(File.pathSeparatorChar);
            }
            classpath.append(f.getPath());
        }
        AndroidTestGeneratorProps props = new AndroidTestGeneratorProps();
        DSLGenerator gen = new DSLGenerator(version, fVersion, jarFilesString, props);
        gen.run();
        String kotlincArgs[] = {
          kotlincFilename,
          "-d", tmpJarFile,
          "-classpath", classpath.toString(),
          testData.getPath()
        };
        ArrayList<String> args = new ArrayList<>(Arrays.asList(kotlincArgs));
        for (File file : props.tmpFiles.values()) {
            args.add(file.getAbsolutePath());
        }
        ProcResult res = runCompiler(args.toArray(new String[args.size()]));
        assertEquals(res.stderr, "");
        assertEquals(res.exitCode, 0);
        return props;
    }

    protected ProcResult runCompiler(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(args);
        BufferedReader brInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader brError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        StringBuilder output = new StringBuilder();
        String str;

        while ((str = brInput.readLine()) != null) {
            if (str.startsWith("ERROR"))
                errors.append(str).append("\n");
            else
                output.append(str).append("\n");
        }
        while ((str = brError.readLine()) != null) {
            if (str.startsWith("ERROR"))
                errors.append(str).append("\n");
            else
                output.append(str).append("\n");
        }

        p.waitFor();
        return new ProcResult(output.toString(), errors.toString(), p.exitValue());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        new File(tmpJarFile).delete();
    }

    class ProcResult {
        public String stderr;
        public String stdout;
        public int exitCode;

        ProcResult(String stdout, String stderr, int exitCode) {
            this.stderr = stderr;
            this.stdout = stdout;
            this.exitCode = exitCode;
        }
    }
}
