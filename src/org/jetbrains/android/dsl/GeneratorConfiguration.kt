/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl

import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList
import java.io.File

open class GeneratorConfiguration(outputDirectory: String = "gen/") : BaseGeneratorConfiguration() {

    override val outputDirectory = outputDirectory
    override val outputPackage = "kotlinx.android.koan"

    override val excludedClasses = HashSet(readLines("props/excluded_classes.txt"))

    override val excludedMethods = HashSet(readLines("props/excluded_methods.txt"))

    override fun getOutputFile(subsystem: KoanFile): File {
        return File(outputDirectory + "src/main/kotlin/", subsystem.filename)
    }


}