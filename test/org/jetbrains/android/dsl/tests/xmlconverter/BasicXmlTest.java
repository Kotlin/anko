package org.jetbrains.android.dsl.tests.xmlconverter;

import org.jetbrains.android.dsl.DslPackage;
import org.jetbrains.android.dsl.xmlconverter.Converter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BasicXmlTest extends Assert {

    private Converter c = new Converter();

    public BasicXmlTest() {
        c.run("testdata/org/jetbrains/android/dsl/tests/xmlconverter/BasicXml.xml.in");
    }

    @Test
    public void testUI() throws Exception {
        String convertedActual = c.toString();
        String convertedExpected = loadOrCreate(new File("testdata/org/jetbrains/android/dsl/tests/xmlconverter/BasicXml.xml.out"),
                convertedActual);
        assertEquals(convertedActual, convertedExpected);

    }

    @Test
    public void testResourceIds() throws Exception {
        String resourcesActual = c.getControlsXmlBuffer().toString();
        String resourcesExpected = loadOrCreate(new File("testdata/org/jetbrains/android/dsl/tests/xmlconverter/BasicXml.res.xml.out"),
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
