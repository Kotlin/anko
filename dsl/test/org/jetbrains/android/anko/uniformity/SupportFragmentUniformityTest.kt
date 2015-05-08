package org.jetbrains.android.anko.uniformity

import org.junit.Test
import java.io.File
import java.util.regex.Pattern

public class SupportFragmentUniformityTest {

    private var failFlag: Boolean = false

    private fun String.replaceDoubledSpaces(): String {
        var ret = this
        while (true) {
            val new = ret.replace("  ", " ")
            if (new == ret) return new
            ret = new
        }
    }

    private fun getAllDeclarations(file: File, receiver: String, declarationType: String): List<Pair<String, String>> {
        val argsIncluded = declarationType == "fun"
        val args = if (argsIncluded) "\\((.*?)\\)" else ""
        val postfix = if (argsIncluded) "[ \n\r\t]*?[\\{\\=]" else ""
        val pattern = Pattern.compile("$declarationType $receiver.([A-Za-z0-9_]+)$args( *?\\: *?.+?)?$postfix", Pattern.DOTALL)
        val matcher = pattern.matcher(file.readText())

        val functions = arrayListOf<Pair<String, String>>()
        while (matcher.find()) {
            val arguments = if (!argsIncluded) "" else matcher.group(2)
                    .replace('\n', ' ').replace('\r', ' ').replace('\t', ' ').replaceDoubledSpaces().trim()
            functions.add(matcher.group(1) to arguments)
        }

        return functions
    }

    private fun compare(
            func1: List<Pair<String, String>>,
            func2: List<Pair<String, String>>,
            text: String,
            receiver: String,
            declarationName: String
    ) {
        for (func in func1) {
            if (!func2.any { it == func }) {
                System.err.println("There is no $declarationName for $text library: $receiver.${func.first}(${func.second})")
                failFlag = true
            }
        }
    }

    Test
    public fun supportFragmentFunctionsExistTest() {
        val receiver = "Fragment"

        val (mainFiles, supportFiles) = File("dsl/static/src")
                .listFiles { it.extension == "kt" } !!.partition { !it.name.contains("Support")}

        listOf("fun", "val", "var").forEach { declarationName ->
            val mainFunctions = mainFiles.flatMap { getAllDeclarations(it, receiver, declarationName) }
            val supportFunctions = supportFiles.flatMap { getAllDeclarations(it, receiver, declarationName) }

            compare(mainFunctions, supportFunctions, "support", receiver, declarationName)
            compare(supportFunctions, mainFunctions, "main", receiver, declarationName)
        }

        if (failFlag) throw RuntimeException("See messages above.")
    }

}