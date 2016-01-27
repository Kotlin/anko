package org.jetbrains.android.anko.uniformity

import org.junit.Test
import java.io.File

class ContextButNotFragmentUniformityTest {

    private var failFlag: Boolean = false

    private fun compare(
            func1: List<Pair<String, String>>,
            func2: List<Pair<String, String>>,
            receiver1: List<String>,
            receiver2: List<String>,
            declarationName: String
    ) {
        for (func in func1) {
            if (!func2.any { it == func }) {
                val args = if (declarationName == "fun") "(${func.second})" else ""
                System.err.println("There is no $declarationName for $receiver2: $receiver1.${func.first}$args")
                failFlag = true
            }
        }
    }

    @Test
    fun fragmentFunctionsExistTest() {
        val receiver1 = listOf("Fragment")
        val receiver2 = listOf("Activity", "Context")

        val files = File("dsl/static/src").listFiles { file -> file.extension == "kt" && !file.name.contains("Support") }!!

        listOf("fun", "val", "var").forEach { declarationName ->
            fun getDeclarations(rs: List<String>) =
                    rs.flatMap { r -> files.flatMap { getAllDeclarations(it, r, declarationName, "@NoBinding") } }

            val receiver1Functions = getDeclarations(receiver1)
            val receiver2Functions = getDeclarations(receiver2)

            compare(receiver1Functions, receiver2Functions, receiver1, receiver2, declarationName)
            compare(receiver2Functions, receiver1Functions, receiver2, receiver1, declarationName)
        }

        if (failFlag) throw RuntimeException("See messages above.")
    }

}