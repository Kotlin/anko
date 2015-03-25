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

import java.io.File
import kotlin.properties.Delegates
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.roots.ModuleRootManager
import java.util.ArrayList
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.JavaSdkType

class RobowrapperContext(description: PreviewClassDescription) {

    val androidFacet = description.androidFacet
    val activityClassName = description.qualifiedName

    private val mainSourceProvider = androidFacet.getMainIdeaSourceProvider()
    private val applicationPackage = androidFacet.getManifest().getPackage().getXmlAttributeValue().getValue()

    private val apiLevel = androidFacet.getAndroidModuleInfo().getTargetSdkVersion().getApiLevel()
    private val androidAll = DependencyUtils.getAndroidAllVersionPath(apiLevel)

    private val assetsDirectory = mainSourceProvider.getAssetsDirectories().firstOrNull()
    private val resDirectory = mainSourceProvider.getResDirectories().firstOrNull()

    private val activities by Delegates.lazy {
        androidFacet.getManifest().getApplication().getActivities().map { it.getActivityClass().toString() }
    }

    private val manifest by Delegates.lazy { generateManifest() }

    private fun runReadAction<T>(action: () -> T): T {
        return ApplicationManager.getApplication().runReadAction<T>(action)
    }

    private fun generateManifest() = runReadAction {
        val activityEntries = activities.map { "<activity android:name=\"$it\" />" }.joinToString("\n")
        val manifestFile = File.createTempFile("AndroidManifest", ".xml")
        manifestFile.writeText(
            """<?xml version="1.0" encoding="utf-8"?>
            <manifest xmlns:android="http://schemas.android.com/apk/res/android" package="%PACKAGE%">
              <application>
                    %ACTIVITIES%
              </application>
            </manifest>""".replace("%PACKAGE%", applicationPackage).replace("%ACTIVITIES%", activityEntries))
        manifestFile
    }

    // `manifest` is already initialized at this point
    fun removeManifest() {
        if (manifest.exists()) {
            manifest.delete()
        }
    }

    private fun ArrayList<String>.add(name: String, value: String) = add(name + escape(value))
    private fun ArrayList<String>.add(name: String, value: VirtualFile) = add(name + escape(value.getPath()))
    private fun ArrayList<String>.add(name: String, value: File) = add(name + escape(value.getAbsolutePath()))

    public fun makeArguments(): List<String> {
        val module = androidFacet.getModule()
        val roots = ModuleRootManager.getInstance(module).orderEntries().classes().getRoots()
        val androidSdkDirectory = androidFacet.getSdkData().getLocation().getPath()

        val pluginDirectory = File(PathManager.getJarPathForClass(javaClass)).getParent()
        val robowrapperDirectory = File(
            File(PathManager.getJarPathForClass(javaClass)).getParentFile().getParentFile(), "robowrapper/")

        val pluginDependencies = listOf(
            "gson-2.3.jar",
            "jeromq-0.3.4.jar")
            .map { File(pluginDirectory, it).getAbsolutePath() }.joinToString(":", prefix = ":")

        val robowrapperDependencies = listOf(
                "robowrapper.jar",
                "junit-4.11.jar",
                "robolectric-with-dependencies.jar")
            .map { File(robowrapperDirectory, it).getAbsolutePath() }.joinToString(":", prefix = ":")

        val androidDependencies = resolveAndroidDependencies(roots, androidSdkDirectory)

        val dependencyDirectory = DependencyUtils.getDependencyDirectory()

        val sdk = ModuleRootManager.getInstance(module).getSdk()
        val sdkType = sdk?.getSdkType()
        val pathToJava = if (sdk != null && sdkType is JavaSdkType) {
            sdkType.getVMExecutablePath(sdk)
        } else "java"

        val a = arrayListOf(escape(pathToJava), "-cp")
        with (a) {
            add(androidAll + pluginDependencies + robowrapperDependencies + androidDependencies)
            add("-Djava.io.tmpdir=", File(dependencyDirectory, "tmp"))
            add("-Drobolectric.offline=true")
            add("-Drobolectric.dependency.dir=", dependencyDirectory)
            add("-Drobo.activityClass=", activityClassName)
            add("-Drobo.packageName=", applicationPackage)
            add("-Dandroid.manifest=", manifest)
            add("-Dandroid.resources=", resDirectory!!)
            if (assetsDirectory != null) {
                add("-Dandroid.assets=", assetsDirectory)
            } else {
                add("-Dandroid.assets=", File(resDirectory.getParent().getPath(), "assets"))
            }
            //TODO: check policy file loading
            //add("-Djava.security.manager=default")
            //add("-Djava.security.policy=", File(dependencyDirectory, "robowrapper.policy"))
            add("org.jetbrains.kotlin.android.robowrapper.Robowrapper")
            this
        }
        return a
    }

    private fun resolveAndroidDependencies(roots: Array<VirtualFile>, androidSdkDirectory: String?): String {
        val sb = StringBuilder()

        for (root in roots) {
            var item = root.getPath()
            if (androidSdkDirectory != null && item.startsWith(androidSdkDirectory)) {
                continue
            }
            if (item.endsWith("!/")) {
                item = item.substring(0, item.length() - 2)
            }
            sb.append(':').append(item.replace(":", "\":"))
        }

        return sb.toString()
    }

    private fun escape(v: String?): String {
        return (v ?: "").replace("\"", "\\\"").replace(" ", "\\ ")
    }

}