//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.intellij.rt.execution.junit;

import junit.framework.ComparisonFailure;

public class FileComparisonFailure extends ComparisonFailure implements KnownException {
    private final String myExpected;
    private final String myActual;
    private final String myFilePath;
    private final String myActualFilePath;

    public FileComparisonFailure(String message, String expected, String actual, String filePath) {
        this(message, expected, actual, filePath, (String)null);
    }

    public FileComparisonFailure(String message, String expected, String actual, String expectedFilePath, String actualFilePath) {
        super(message, expected, actual);
        this.myExpected = expected;
        this.myActual = actual;
        this.myFilePath = expectedFilePath;
        this.myActualFilePath = actualFilePath;
    }

    public String getFilePath() {
        return this.myFilePath;
    }

    public String getActualFilePath() {
        return this.myActualFilePath;
    }

    public String getExpected() {
        return this.myExpected;
    }

    public String getActual() {
        return this.myActual;
    }
}
