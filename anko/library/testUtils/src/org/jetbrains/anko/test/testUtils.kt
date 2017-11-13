package org.jetbrains.anko.test

import com.intellij.rt.execution.junit.FileComparisonFailure
import junit.framework.TestCase
import java.io.File

private fun String.trimTrailingWhitespacesAndAddNewlineAtEOF(): String =
        this.split('\n').map(String::trimEnd).joinToString(separator = "\n").let {
            result -> if (result.endsWith("\n")) result else result + "\n"
        }

fun assertEqualsToFile(description: String, expected: File, actual: String) {
    if (!expected.exists()) {
        expected.writeText(actual)
        TestCase.fail("File didn't exist. New file was created (${expected.canonicalPath}).")
    }

    val expectedText =
            convertLineSeparators(expected.readText().trim()).trimTrailingWhitespacesAndAddNewlineAtEOF()
    val actualText =
            convertLineSeparators(actual.trim()).trimTrailingWhitespacesAndAddNewlineAtEOF()
    if (expectedText != actualText) {
        throw FileComparisonFailure(description, expectedText, actualText, expected.absolutePath)
    }
}

private val IS_WINDOWS = System.getProperty("os.name").startsWith("Windows")

private fun convertLineSeparators(text: String): String {
    val n = text.replace("\r", "")
    if (!IS_WINDOWS) return n
    return n.replace("\n", System.getProperty("line.separator") ?: "\r\n")
}