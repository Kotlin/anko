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