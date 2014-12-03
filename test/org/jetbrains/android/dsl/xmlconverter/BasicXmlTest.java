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

package org.jetbrains.android.dsl.xmlconverter;

import org.jetbrains.android.dsl.DslPackage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BasicXmlTest extends Assert {

    private Converter c = new Converter();

    public BasicXmlTest() {
        c.run("testData/xmlconverter/BasicXml.xml.in");
    }

    //@Test
    public void testUI() throws Exception {
        String convertedActual = c.toString();
        String convertedExpected = loadOrCreate(new File("testData/xmlconverter/BasicXml.xml.out"),
                convertedActual);
        assertEquals(convertedActual, convertedExpected);

    }

    @Test
    public void testResourceIds() throws Exception {
        String resourcesActual = c.getControlsXmlBuffer().toString();
        String resourcesExpected = loadOrCreate(new File("testData/xmlconverter/BasicXml.res.xml.out"),
                resourcesActual);
        assertEquals(resourcesActual, resourcesExpected);
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
}
