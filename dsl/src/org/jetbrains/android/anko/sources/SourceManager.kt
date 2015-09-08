/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.android.anko.sources

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import com.github.javaparser.ast.visitor.VoidVisitorAdapter
import org.jetbrains.android.anko.utils.getJavaClassName

public class SourceManager(private val provider: SourceProvider) {

    public fun getArgumentNames(classFqName: String, methodName: String, argumentJavaTypes: List<String>): List<String>? {
        val parsed = provider.parse(classFqName) ?: return null
        val className = getJavaClassName(classFqName)

        val argumentNames = arrayListOf<String>()
        var done = false

        object : VoidVisitorAdapter<Any>() {
            override fun visit(method: MethodDeclaration, arg: Any?) {
                if (done) return
                if (methodName != method.name || argumentJavaTypes.size() != method.parameters.size()) return
                if (method.getParentClassName() != className) return

                val parameters = method.parameters
                for ((argumentFqType, param) in argumentJavaTypes.zip(parameters)) {
                    if (argumentFqType.substringAfterLast('.') != param.type.toString()) return
                }

                parameters.forEach { argumentNames.add(it.id.name) }
                done = true
            }
        }.visit(parsed, null)

        return if (done) argumentNames else null
    }

    private fun Node.getParentClassName(): String {
        val parent = parentNode
        return if (parent is TypeDeclaration) {
            val outerName = parent.getParentClassName()
            if (outerName.isNotEmpty()) "$outerName.${parent.name}" else parent.name
        } else ""
    }

}