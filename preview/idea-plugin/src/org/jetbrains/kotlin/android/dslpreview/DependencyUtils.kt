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

package org.jetbrains.kotlin.android.dslpreview

import com.intellij.openapi.application.PathManager

import java.io.File

object DependencyUtils {
    private val defaultVersion = 18
    private val versions = mapOf(18 to "4.3_r2")

    private val dependencies = listOf(
        "http://central.maven.org/maven2/org/ccil/cowan/tagsoup/tagsoup/1.2/tagsoup-1.2.jar" to getDependencyPath("tagsoup-1.2.jar"),
        "http://central.maven.org/maven2/org/json/json/20080701/json-20080701.jar" to getDependencyPath("json-20080701.jar")
    )

    public fun getRobowrapperDependencies(): List<Pair<String, String>> {
        return dependencies
    }

    public fun getDependencyDirectory(): File {
        return File(PathManager.getSystemPath(), "dsl-plugin/deps/")
    }

    private fun getDependencyPath(filename: String): String {
        return File(getDependencyDirectory(), filename).getAbsolutePath()
    }

    public fun getAndroidAllVersionPath(version: Int): String {
        val ver = versions.get(version) ?: versions.get(defaultVersion)

        val dependencyDirectory = getDependencyDirectory()
        if (!dependencyDirectory.exists()) {
            dependencyDirectory.mkdirs()
        }
        return File(dependencyDirectory, "android-all-" + ver + "-robolectric-0.jar").getAbsolutePath()
    }

    public fun getAndroidAllVersionUrl(version: Int): String {
        val ver = versions.get(version) ?: versions.get(defaultVersion)
        return "http://central.maven.org/maven2/org/robolectric/android-all/$ver-robolectric-0/android-all-$ver-robolectric-0.jar"
    }

}
