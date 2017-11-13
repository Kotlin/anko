/*
 * Copyright 2016 JetBrains s.r.o.
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
import org.jetbrains.android.anko.utils.getPackageName
import java.io.File

interface SourceProvider {
    fun parse(fqName: String): CompilationUnit?
}

class AndroidHomeSourceProvider(androidSdkLocation: File, version: Int) : SourceProvider {
    private val baseDir = File(androidSdkLocation, "sources/android-$version")

    init {
        if (!baseDir.exists()) throw IllegalStateException("${baseDir.absolutePath} does not exist")
    }

    override fun parse(fqName: String): CompilationUnit? {
        val packageName = getPackageName(fqName)
        val packageDir = File(baseDir, packageName.replace('.', '/'))
        if (!packageDir.exists()) return null

        val filename = fqName.substring(packageName.length + 1).substringBefore('.') + ".java"
        val file = File(packageDir, filename)
        if (!file.exists()) return null

        return JavaParser.parse(file)
    }
}