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

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.projectRoots.JavaSdkType
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiClass
import java.io.File
import java.util.*

class RobowrapperContext(description: PreviewClassDescription) {

    internal val androidFacet = description.androidFacet
    internal val activityClassName = description.qualifiedName

    private val mainSourceProvider = androidFacet.mainIdeaSourceProvider
    private val applicationPackage = androidFacet.manifest?.`package`?.xmlAttributeValue?.value ?: "app"

    private val assetsDirectory = mainSourceProvider.assetsDirectories.firstOrNull()
    private val resDirectory = mainSourceProvider.resDirectories.firstOrNull()

    private val activities by lazy {
        androidFacet.manifest?.application?.activities ?: listOf()
    }

    private val manifest by lazy { generateManifest() }

    private fun <T> runReadAction(action: () -> T): T {
        return ApplicationManager.getApplication().runReadAction<T>(action)
    }

    private fun generateManifest() = runReadAction {
        val activityEntries = activities.map {
            val clazz = it.activityClass
            val theme = if (clazz.value.isAppCompatActivity()) "android:theme=\"@style/Theme.AppCompat\"" else ""
            "<activity android:name=\"${clazz.toString()}\" $theme />"
        }.joinToString("\n")
        val manifestFile = File.createTempFile("AndroidManifest", ".xml")
        manifestFile.writeText(
            """<?xml version="1.0" encoding="utf-8"?>
            <manifest xmlns:android="http://schemas.android.com/apk/res/android" package="%PACKAGE%">
              <uses-sdk android:targetSdkVersion="21"/>
              <application>
                    %ACTIVITIES%
              </application>
            </manifest>""".replace("%PACKAGE%", applicationPackage).replace("%ACTIVITIES%", activityEntries))
        manifestFile
    }

    // `manifest` is already initialized at this point
    internal fun removeManifest() {
        if (manifest.exists()) {
            manifest.delete()
        }
    }

    private fun ArrayList<String>.add(name: String, value: String) = add(name + escape(value))
    private fun ArrayList<String>.add(name: String, value: VirtualFile) = add(name + escape(value.path))
    private fun ArrayList<String>.add(name: String, value: File) = add(name + escape(value.absolutePath))

    fun makeArguments(): List<String> {
        val module = androidFacet.module
        val roots = ModuleRootManager.getInstance(module).orderEntries().classes().roots
        val androidSdkDirectory = androidFacet.sdkData?.location?.path

        val pluginJarPath = PathManager.getJarPathForClass(javaClass)!!
        val pluginDirectory = File(pluginJarPath).getParent()
        val robowrapperDirectory = File(
            File(pluginJarPath).parentFile.parentFile, "robowrapper/")

        val robolectricMavenDependencies = RobowrapperDependencies.DEPENDENCIES.map { it.file.absolutePath }.joinToString(":")

        val robowrapperDependencies = listOf(
            "gson-2.3.jar",
            "jeromq-0.3.4.jar")
            .map { File(pluginDirectory, it).absolutePath }.joinToString(":", prefix = ":")

        val robolectricDependencies = robowrapperDirectory
                .listFiles { it.name.endsWith(".jar") }
                ?.map { it.absolutePath }?.joinToString(":", prefix = ":") ?: ""

        val androidDependencies = resolveAndroidDependencies(roots, androidSdkDirectory)

        val dependencyDirectory = RobowrapperDependencies.DEPENDENCIES_DIRECTORY

        val sdk = ModuleRootManager.getInstance(module).sdk
        val sdkType = sdk?.sdkType
        val pathToJava = if (sdk != null && sdkType is JavaSdkType) {
            sdkType.getVMExecutablePath(sdk)
        } else "java"

        val a = arrayListOf(escape(pathToJava), "-cp")
        with (a) {
            add(robolectricMavenDependencies + robowrapperDependencies + robolectricDependencies + androidDependencies)
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
                add("-Dandroid.assets=", File(resDirectory.parent.path, "assets"))
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
            var item = root.path
            if (androidSdkDirectory != null && item.startsWith(androidSdkDirectory)) {
                continue
            }
            if (item.endsWith("!/")) {
                item = item.substring(0, item.length - 2)
            }
            sb.append(':').append(item.replace(":", "\":"))
        }

        return sb.toString()
    }

    private fun escape(v: String?): String {
        return (v ?: "").replace("\"", "\\\"").replace(" ", "\\ ")
    }

    private fun PsiClass?.isAppCompatActivity(): Boolean {
        if (this == null) return false

        if (qualifiedName == "android.support.v7.app.AppCompatActivity") return true
        else return superClass?.isAppCompatActivity() ?: false
    }

}