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