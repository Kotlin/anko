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

package org.jetbrains.android.dsl.functional;

import org.jetbrains.android.dsl.BaseGeneratorConfiguration;
import org.jetbrains.android.dsl.DSLGenerator;
import org.jetbrains.android.dsl.DslPackage;
import org.jetbrains.android.dsl.KoanFile;
import org.jetbrains.android.dsl.utils.DirectoryFilter;
import org.jetbrains.android.dsl.utils.JarFilter;
import org.jetbrains.android.dsl.TestGeneratorConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFunctionalTest extends Assert {
    protected DSLGenerator generator;

    private static final FileFilter jarFilter = new JarFilter();

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

    protected void runFunctionalTest(
        int version,
        String fVersion,
        List<String> inputJarFiles,
        String testDataFile,
        KoanFile subsystem,
        TestGeneratorConfiguration settings) throws IOException
    {
        initSettings(settings);
        generator = new DSLGenerator(version, fVersion, inputJarFiles, settings);
        generator.run();

        String actual = DslPackage.readFile(settings.tmpFiles.get(subsystem).getAbsolutePath());
        String expectedPath = ("testdata/" + fVersion + "/" + testDataFile);
        String expected = loadOrCreate(new File(expectedPath), actual);

        assertEquals(actual, expected);
        assertTrue(actual.length() > 0);
        assertTrue(expected.length() > 0);
    }

    protected void runFunctionalTest(String testDataFile, KoanFile subsystem, String version) throws IOException {
        TestGeneratorConfiguration settings = new TestGeneratorConfiguration();

        settings.setGenerateImports(false);
        settings.setGeneratePackage(false);
        settings.setGenerateMavenArtifact(false);

        settings.getFiles().clear();
        settings.getTunes().clear();

        File versionDir = new File("original", version);
        int intVersion = Integer.parseInt(version.replaceAll("[^0-9]", ""));

        List<File> jarFiles = Arrays.asList(versionDir.listFiles(jarFilter));
        List<String> jarFilesString = new ArrayList<>();
        for (File f: jarFiles) {
            jarFilesString.add(f.getAbsolutePath());
        }
        runFunctionalTest(intVersion, version, jarFilesString, testDataFile, subsystem, settings);

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    protected abstract void initSettings(BaseGeneratorConfiguration settings);

}
