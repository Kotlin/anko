package org.jetbrains.android.anko.sources

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import com.github.javaparser.ast.visitor.VoidVisitorAdapter
import org.jetbrains.android.anko.getJavaClassName
import org.jetbrains.android.anko.getPackageName
import sun.plugin.dom.exception.InvalidStateException
import java.io.File
import java.util.HashMap

public trait SourceProvider {
    fun parse(fqName: String): CompilationUnit?
}

public class CachingSourceProvider(private val underlyingProvider: SourceProvider) : SourceProvider {
    private val cache = hashMapOf<String, CompilationUnit>()

    override fun parse(fqName: String) = cache.getOrPut(fqName) {
        underlyingProvider.parse(fqName)
    }
}

public class AndroidHomeSourceProvider(version: Int) : SourceProvider {
    private val baseDir: File

    init {
        val androidHome = System.getenv("ANDROID_HOME")
                ?: throw InvalidStateException("ANDROID_HOME environment variable is not defined")
        baseDir = File(androidHome, "sources/android-$version")
        if (!baseDir.exists()) throw InvalidStateException("${baseDir.getAbsolutePath()} does not exist")
    }

    override fun parse(fqName: String): CompilationUnit? {
        val packageName = getPackageName(fqName)
        val packageDir = File(baseDir, packageName.replace('.', '/'))
        if (!packageDir.exists()) return null

        val filename = fqName.substring(packageName.length() + 1).substringBefore('.') + ".java"
        val file = File(packageDir, filename)
        if (!file.exists()) return null

        return JavaParser.parse(file)
    }
}