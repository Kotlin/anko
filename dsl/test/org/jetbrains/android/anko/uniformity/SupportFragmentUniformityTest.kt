package org.jetbrains.android.anko.uniformity

import org.junit.Test
import java.io.File
import java.util.regex.Pattern

public class SupportFragmentUniformityTest {

    private var failFlag: Boolean = false

    private fun compare(
            func1: List<Pair<String, String>>,
            func2: List<Pair<String, String>>,
            text: String,
            receiver: String,
            declarationName: String
    ) {
        for (func in func1) {
            if (!func2.any { it == func }) {
                val args = if (declarationName == "fun") "(${func.second})" else ""
                System.err.println("There is no $declarationName for $text library: $receiver.${func.first}$args")
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