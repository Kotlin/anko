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

object RobowrapperDependencies {
    val DEPENDENCIES_DIRECTORY: File = File(PathManager.getSystemPath(), "dsl-plugin/deps")

    val ANDROID_ALL_DEPENDENCY = Dependency("org.robolectric", "android-all", "5.0.0_r2-robolectric-1")

    val DEPENDENCIES: List<Dependency> = listOf(
        ANDROID_ALL_DEPENDENCY,
        Dependency("org.robolectric", "shadows-core", "3.0-rc3", postfix = "-21"),
        Dependency("org.robolectric", "shadows-support-v4", "3.0-rc3", postfix = "-21"),
        Dependency("org.json", "json", "20080701"),
        Dependency("org.ccil.cowan.tagsoup", "tagsoup", "1.2")
    )
}

private class Dependency(
        group: String,
        artifact: String,
        version: String,
        extension: String = "jar",
        postfix: String? = ""
) {
    val downloadUrl = "http://central.maven.org/maven2/${group.replace('.', '/')}/" +
            "$artifact/$version/$artifact-$version.$extension"

    val file = File(RobowrapperDependencies.DEPENDENCIES_DIRECTORY, "$artifact-$version$postfix.$extension")
}