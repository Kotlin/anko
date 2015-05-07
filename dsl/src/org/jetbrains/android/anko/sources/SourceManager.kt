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

public class SourceManager(private val provider: SourceProvider) {

    public fun getArgumentNames(classFqName: String, methodName: String, argumentJavaTypes: List<String>): List<String>? {
        val parsed = provider.parse(classFqName) ?: return null
        val className = getJavaClassName(classFqName)

        val argumentNames = arrayListOf<String>()
        var done = false

        object : VoidVisitorAdapter<Any>() {
            override fun visit(method: MethodDeclaration, arg: Any?) {
                if (done) return
                if (methodName != method.getName() || argumentJavaTypes.size() != method.getParameters().size()) return
                if (method.getParentClassName() != className) return

                val parameters = method.getParameters()
                for ((argumentFqType, param) in argumentJavaTypes.zip(parameters)) {
                    if (argumentFqType.substringAfterLast('.') != param.getType().toString()) return
                }

                parameters.forEach { argumentNames.add(it.getId().getName()) }
                done = true
            }
        }.visit(parsed, null)

        return if (done) argumentNames else null
    }

    private fun Node.getParentClassName(): String {
        val parent = getParentNode()
        return if (parent is TypeDeclaration) {
            val outerName = parent.getParentClassName()
            if (outerName.isNotEmpty()) "$outerName.${parent.getName()}" else parent.getName()
        } else ""
    }

}