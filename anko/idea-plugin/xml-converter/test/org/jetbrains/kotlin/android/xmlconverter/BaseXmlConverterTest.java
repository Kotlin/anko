package org.jetbrains.kotlin.android.xmlconverter;

import kotlin.text.Charsets;
import org.junit.Rule;
import org.junit.rules.TestName;
import java.io.File;

import static kotlin.collections.SetsKt.*;
import static kotlin.io.FilesKt.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseXmlConverterTest {

    @Rule
    public TestName name = new TestName();

    protected void doLayoutTest() {
        File testDataDir = new File("xml-converter/testData");
        String testName = name.getMethodName();
        if (!testName.startsWith("test")) {
            throw new IllegalStateException("Test name must start with a 'test' preffix");
        }

        File testDir = new File(testDataDir, decapitalize(testName.substring("test".length())));
        File inputFile = new File(testDir, "layout.xml");
        File outputFile = new File(testDir, "layout.kt");

        assertTrue(inputFile + " does not exist", inputFile.exists());
        assertTrue(outputFile + " does not exist", outputFile.exists());

        String actual = XmlConverter.INSTANCE.convert(readText(inputFile, Charsets.UTF_8), setOf("raw"));
        String expected = readText(outputFile, Charsets.UTF_8);

        assertEquals(expected, actual);
    }

    private String decapitalize(String original) {
        if (original.isEmpty()) return original;
        return Character.toLowerCase(original.charAt(0)) + original.substring(1);
    }

}
