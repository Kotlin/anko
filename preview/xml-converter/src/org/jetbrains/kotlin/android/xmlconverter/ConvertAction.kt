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

package org.jetbrains.kotlin.android.xmlconverter

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import java.io.File
import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.ModuleFileIndex
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.module.Module
import org.jetbrains.android.facet.AndroidFacet
import com.intellij.facet.FacetManager
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import java.io.IOException
import com.intellij.openapi.ui.ex.MessagesEx
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.fileEditor.*
import com.intellij.openapi.vfs.*
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.refactoring.fqName.getKotlinFqName

public class ConvertAction : AnAction() {

    private class FileToConvert(val xmlFile: VirtualFile, val ktFile: File)

    override fun actionPerformed(e: AnActionEvent) {
        val virtualFiles = e.getData(CommonDataKeys.VIRTUAL_FILE_ARRAY)
        val project = CommonDataKeys.PROJECT.getData(e.getDataContext())

        val files = allFilesToConvert(virtualFiles, project)
        if (files.isEmpty()) return

        ApplicationManager.getApplication().runWriteAction {
            var lastConvertedFile: VirtualFile? = null

            for (file in files) {
                System.err.println("Converting file " + file.xmlFile.getPath())
                file.convert(project)
                lastConvertedFile = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(file.ktFile)
            }

            if (lastConvertedFile != null) {
                FileEditorManager.getInstance(project).openFile(lastConvertedFile!!, true)
            }
        }
    }

    private fun VirtualFile.getFileToConvert(project: Project): FileToConvert? {
        if (getFileType() !is XmlFileType) return null
        if (!getParent().getName().startsWith("layout")) return null

        val androidFacet = resolveAndroidFacet(project)
        if (androidFacet == null) return null

        val probResourceDirectory = getParent()?.getParent()?.getPath()
        val resourceDirectories = androidFacet.getAllResourceDirectories()
        if (!resourceDirectories.any { it.getCanonicalPath() == probResourceDirectory }) return null

        val targetDirectory = getActivityDirectory(androidFacet) ?: getMainAndroidSourceRoot(androidFacet)
        val ktFileNameBase = getNameWithoutExtension().firstCapital()

        var candidateKtFile = File(targetDirectory, ktFileNameBase + "LayoutActivity.kt")
        var counter = 0
        while (candidateKtFile.exists()) {
            candidateKtFile = File(targetDirectory, ktFileNameBase + "LayoutActivity$counter.kt")
            counter = counter + 1
        }

        return FileToConvert(this, candidateKtFile)
    }

    private fun getActivityDirectory(androidFacet: AndroidFacet): String? {
        val manifest = androidFacet.getManifest()
        val appPackage = manifest?.getPackage()?.getValue()
        val activities = manifest?.getApplication()?.getActivities()

        if (appPackage == null || activities == null) return null

        val activityClasses = activities.map { it.getActivityClass().getValue() }
        val activity = activityClasses.filter { it.getKotlinFqName()?.asString()?.startsWith(appPackage) ?: false }.firstOrNull()
        return activity?.getContainingFile()?.getContainingDirectory()?.getVirtualFile()?.getCanonicalPath()
    }

    private fun getMainAndroidSourceRoot(androidFacet: AndroidFacet): String? {
        return ModuleRootManager.getInstance(androidFacet.getModule())
                .getContentRoots().filter { !it.getCanonicalPath()!!.endsWith("/gen") }.first().getCanonicalPath()
    }

    override fun update(e: AnActionEvent) {
        e.getPresentation().setEnabled(selectedLayoutFiles(e).any())
    }

    private fun selectedLayoutFiles(e: AnActionEvent): List<FileToConvert> {
        val virtualFiles = e.getData(CommonDataKeys.VIRTUAL_FILE_ARRAY) ?: return listOf()
        val project = CommonDataKeys.PROJECT.getData(e.getDataContext()) ?: return listOf()
        return allFilesToConvert(virtualFiles, project)
    }

    private fun allFilesToConvert(filesOrDirs: Array<VirtualFile>, project: Project): List<FileToConvert> {
        val result = arrayListOf<FileToConvert>()
        for (file in filesOrDirs) {
            VfsUtilCore.visitChildrenRecursively(file, object : VirtualFileVisitor<Unit>() {
                override fun visitFile(file: VirtualFile): Boolean {
                    val fileToConvert = file.getFileToConvert(project)
                    if (fileToConvert != null) result.add(fileToConvert)
                    return true
                }
            })
        }
        return result
    }

    private fun VirtualFile.resolveAndroidFacet(project: Project): AndroidFacet? {
        return ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(this)?.resolveAndroidFacet()
    }

    private fun Module.resolveAndroidFacet(): AndroidFacet? {
        val facetManager = FacetManager.getInstance(this)
        for (facet in facetManager.getAllFacets()) {
            if (facet is AndroidFacet) {
                return facet
            }
        }
        return null
    }

    private fun FileToConvert.convert(project: Project) {
        try {
            ktFile.writeText(XmlConverter.convert(xmlFile.contentsToByteArray().toString("UTF-8")))
        }
        catch (e: IOException) {
            MessagesEx.error(project, e.getMessage()).showLater()
        }
    }

    private fun String.firstCapital() = if (isEmpty()) "" else Character.toUpperCase(this[0]) + substring(1)

}