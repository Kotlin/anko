package org.jetbrains.android.anko.uniformity

import java.io.File
import java.util.regex.Pattern

private fun String.replaceDoubledSpaces(): String {
    var ret = this
    while (true) {
        val new = ret.replace("  ", " ")
        if (new == ret) return new
        ret = new
    }
}

fun getAllDeclarations(
        file: File,
        receiver: String,
        declarationType: String,
        ignoreAnnotation: String? = null
): List<Pair<String, String>> {
    val argsIncluded = declarationType == "fun"
    val args = if (argsIncluded) "\\((.*?)\\)" else ""
    val postfix = if (argsIncluded) "[ \n\r\t]*?[\\{\\=]" else ""
    val pattern = Pattern.compile("$declarationType $receiver.([A-Za-z0-9_]+)$args( *?\\: *?.+?)?$postfix", Pattern.DOTALL)
    val text = file.readText()
    val matcher = pattern.matcher(text)

    val functions = arrayListOf<Pair<String, String>>()
    while (matcher.find()) {
        if (ignoreAnnotation != null) {
            val annotStart = matcher.start() - ignoreAnnotation.length - 1
            if (text.substring(annotStart, annotStart + ignoreAnnotation.length) == ignoreAnnotation) continue
        }
        val arguments = if (!argsIncluded) "" else matcher.group(2)
                .replace('\n', ' ').replace('\r', ' ').replace('\t', ' ').replaceDoubledSpaces().trim()
        functions.add(matcher.group(1) to arguments)
    }

    return functions
}