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

package org.jetbrains.android.anko

import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.DefaultAnkoConfiguration
import org.jetbrains.android.anko.config.Options
import java.io.File

open class TestAnkoConfiguration(
        version: String
) : DefaultAnkoConfiguration(File("workdir/temp"), version, Options.create()) {
    val tmpFiles: Map<AnkoFile, File> =
        AnkoFile.values().map { it to createTempTestFile(it.filename, ".kt") }.toMap()

    override val generateMavenArtifact = false
    override val generateStaticFiles = false

    override val generateImports = false
    override val generatePackage = false

    override fun getOutputFile(ankoFile: AnkoFile): File {
        return tmpFiles[ankoFile]!!
    }
}
