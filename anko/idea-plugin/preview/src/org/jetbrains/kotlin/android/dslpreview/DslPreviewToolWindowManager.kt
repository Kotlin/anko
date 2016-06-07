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

package org.jetbrains.kotlin.android.dslpreview

import com.android.tools.idea.configurations.ConfigurationListener
import com.android.tools.idea.gradle.invoker.GradleInvoker
import com.android.tools.idea.gradle.project.BuildSettings
import com.android.tools.idea.gradle.util.BuildMode
import com.android.tools.idea.gradle.util.GradleUtil
import com.android.tools.idea.rendering.*
import com.android.tools.idea.rendering.multi.RenderPreviewMode
import com.intellij.facet.Facet
import com.intellij.facet.FacetManager
import com.intellij.icons.AllIcons
import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.compiler.CompileStatusNotification
import com.intellij.openapi.compiler.CompilerManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.util.Computable
import com.intellij.openapi.wm.WindowManager
import com.intellij.psi.*
import com.intellij.psi.impl.PsiTreeChangePreprocessor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.xml.XmlFile
import com.intellij.ui.awt.RelativePoint
import com.intellij.uiDesigner.core.GridConstraints
import com.intellij.uiDesigner.core.GridLayoutManager
import com.intellij.util.Alarm.ThreadToUse.SWING_THREAD
import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.android.sdk.AndroidTargetData
import org.jetbrains.android.uipreview.AndroidLayoutPreviewToolWindowManager
import org.jetbrains.kotlin.idea.internal.Location
import org.jetbrains.kotlin.idea.util.InfinitePeriodicalTask
import org.jetbrains.kotlin.idea.util.LongRunningReadTask
import org.jetbrains.kotlin.idea.util.ProjectRootsUtil
import org.jetbrains.kotlin.psi.KtClass
import javax.swing.DefaultComboBoxModel
import javax.swing.JPanel
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskType
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.util.ProgressIndicatorBase
import com.intellij.openapi.project.DumbService
import com.intellij.util.ui.update.MergingUpdateQueue
import com.intellij.util.ui.update.Update
import org.jetbrains.android.uipreview.ViewLoader
import org.jetbrains.kotlin.asJava.KtLightElement
import org.jetbrains.kotlin.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.codegen.ClassBuilderMode
import org.jetbrains.kotlin.codegen.CodegenFileClassesProvider
import org.jetbrains.kotlin.codegen.state.IncompatibleClassTracker
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.lazy.ResolveSession
import java.util.*

class DslPreviewToolWindowManager(
        private val myProject: Project,
        fileEditorManager: FileEditorManager
) : AndroidLayoutPreviewToolWindowManager(myProject, fileEditorManager), Disposable {
    private companion object {
        private val GRADLE_ID = ProjectSystemId("GRADLE")
    }

    private var myActivityListModel: DefaultComboBoxModel<Any>? = null

    private var myLastFile: PsiFile? = null
    private var myLastAndroidFacet: AndroidFacet? = null

    private val sourceFileModificationTracker by lazy {
        myProject.getExtensions(PsiTreeChangePreprocessor.EP_NAME)
                .first { it is SourceFileModificationTracker } as SourceFileModificationTracker
    }

    @Volatile
    private var lastSourceFileModification = -1L

    private val RENDERING_LOCK = Object()

    init {
        ApplicationManager.getApplication().invokeLater {
            val task = Computable { UpdateActivityNameTask() }
            InfinitePeriodicalTask(1000, SWING_THREAD, this@DslPreviewToolWindowManager, task).start()
        }
    }

    override fun initToolWindow() {
        super.initToolWindow()

        val panel = toolWindowForm.contentPanel.getComponent(1)

        if (panel is JPanel) {
            val firstToolbar = panel.getComponent(0)
            val secondToolbar = panel.getComponent(1)

            panel.remove(firstToolbar)
            panel.remove(secondToolbar)
            val manager = GridLayoutManager(3, 1)
            panel.layout = manager

            myActivityListModel = DefaultComboBoxModel()
            val comboBox = ComboBox(myActivityListModel)

            fun constraints(row: Int, column: Int, init: GridConstraints.() -> Unit): GridConstraints {
                return with(GridConstraints()) {
                    setRow(row)
                    setColumn(column)
                    init()
                    this
                }
            }

            panel.add(firstToolbar, constraints(0, 0) {
                fill = GridConstraints.FILL_BOTH
            })

            panel.add(secondToolbar, constraints(1, 0) {
                fill = GridConstraints.FILL_VERTICAL
                anchor = GridConstraints.ANCHOR_EAST
            })

            panel.add(comboBox, constraints(2, 0) {
                fill = GridConstraints.FILL_BOTH
            })
        }

        resolveAvailableClasses()
    }

    override fun getCustomRefreshRenderAction(): AnAction? {
        return RefreshDslAction()
    }

    override fun getComponentName(): String {
        return "LayoutPreviewToolWindowManager"
    }

    override fun isUseInteractiveSelector(): Boolean {
        return false
    }

    override fun getToolWindowId(): String {
        return "Anko DSL Preview"
    }

    override fun isRenderAutomatically(): Boolean {
        return false
    }

    override fun isForceHideOnStart(): Boolean {
        return true
    }

    private fun renderXml(content: String, description: PreviewClassDescription) {
        val filename = "anko_preview.xml"
        val psiFile = PsiFileFactory.getInstance(myProject).createFileFromText(filename, XmlFileType.INSTANCE, content)
        val wrappedPsiFile = LayoutPsiFile(psiFile as XmlFile)
        render(wrappedPsiFile, description.androidFacet, false)
    }

    override fun render(): Boolean {
        val file = myLastFile
        val facet = myLastAndroidFacet

        if (file == null || facet == null) {
            return false
        }
        return render(file, facet, false)
    }

    private fun getOnCursorPreviewClassDescription(): PreviewClassDescription? {
        val editor = FileEditorManager.getInstance(myProject).selectedTextEditor ?: return null
        val psiFile = PsiDocumentManager.getInstance(myProject).getPsiFile(editor.document)

        if (psiFile !is KtFile || editor !is EditorEx) return null

        val selectionStart = editor.caretModel.primaryCaret.selectionStart
        val psiElement = psiFile.findElementAt(selectionStart) ?: return null

        val cacheService = KotlinCacheService.getInstance(myProject)
        return resolveClassDescription(psiElement, cacheService)
    }

    override fun render(psiFile: PsiFile?, facet: AndroidFacet?, forceFullRender: Boolean): Boolean {
        val description = myActivityListModel?.selectedItem as? PreviewClassDescription
                ?: getOnCursorPreviewClassDescription()
                ?: return false

        if (!forceFullRender) {
            val result = subrender(psiFile!!, facet!!, description, false)
            if (result) {
                myLastFile = psiFile
                myLastAndroidFacet = facet
            }
            else {
                myLastFile = null
                myLastAndroidFacet = null
            }
            return result
        }

        fun renderIt(description: PreviewClassDescription) {
            val content = """<?xml version="1.0" encoding="utf-8"?>
                <__anko.preview.View xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>"""

            renderXml(content, description)
        }

        val actualSourceFileModification = sourceFileModificationTracker.modificationCount
        if (actualSourceFileModification != lastSourceFileModification) {
            val notification = CompileStatusNotification { aborted, errors, warnings, compileContext ->
                if (!aborted && errors == 0) {
                    lastSourceFileModification = actualSourceFileModification
                    renderIt(description)
                } else if (errors > 0) {
                    showNotification("Build completed with errors.", MessageType.ERROR)
                }
            }

            fun compileWithCompileManager() {
                BuildSettings.getInstance(myProject).buildMode = BuildMode.COMPILE_JAVA
                CompilerManager.getInstance(myProject).make(notification)
            }

            fun compileWithGradle() {
                val modules = ModuleManager.getInstance(myProject).modules
                val gradleInvoker = GradleInvoker.getInstance(myProject)
                val buildMode = BuildMode.COMPILE_JAVA
                BuildSettings.getInstance(myProject).buildMode = buildMode
                val tasks = GradleInvoker.findTasksToExecute(modules, buildMode, GradleInvoker.TestCompileType.NONE)

                val id = ExternalSystemTaskId.create(GradleUtil.GRADLE_SYSTEM_ID, ExternalSystemTaskType.EXECUTE_TASK, myProject)
                gradleInvoker.addAfterGradleInvocationTask { result ->
                    if (result.isBuildSuccessful) {
                        ApplicationManager.getApplication().invokeLater {
                            lastSourceFileModification = actualSourceFileModification
                            renderIt(description)
                        }
                    }
                }

                try {
                    val newMethod = GradleInvoker::class.java.getDeclaredMethod("executeTasks",
                            List::class.java,
                            List::class.java,
                            List::class.java,
                            ExternalSystemTaskId::class.java,
                            ExternalSystemTaskNotificationListener::class.java,
                            Boolean::class.java)
                    newMethod(gradleInvoker, tasks, emptyList<Any>(), emptyList<Any>(), id, null, false)
                } catch (e: Exception) {
                    gradleInvoker.executeTasks(tasks, emptyList(), emptyList(), id, null, false)
                }
            }

            if (facet?.isGradleModule() ?: true) {
                compileWithGradle()
            } else {
                compileWithCompileManager()
            }
        }
        else {
            renderIt(description)
        }

        return true
    }

    private fun Facet<*>?.isGradleModule(): Boolean {
        val module = this?.module ?: return false
        return ExternalSystemApiUtil.isExternalSystemAwareModule(GRADLE_ID, module)
    }

    override fun initListeners(project: Project) {}
    override fun update(event: PsiTreeChangeEvent) {}
    override fun dispose() {}

    override fun getToolWindow() = super.getToolWindow()
    override fun getToolWindowForm() = super.getToolWindowForm()

    private fun resolveAvailableClasses() {
        val activityClasses = getAncestors("org.jetbrains.anko.AnkoComponent")

        if (myActivityListModel != null) {
            with(myActivityListModel!!) {
                selectedItem = null
                removeAllElements()
                val items = activityClasses
                items.sortedBy { it.toString() }.forEach { addElement(it) }
            }
        }
    }

    private fun getKtClass(psiElement: PsiElement?): KtClass? {
        return if (psiElement is KtLightElement<*, *>) {
            getKtClass(psiElement.kotlinOrigin)
        } else if (psiElement is KtClass && !psiElement.isEnum() && !psiElement.isInterface() &&
                !psiElement.isAnnotation() && !psiElement.isSealed()) {
            psiElement
        } else {
            val parent = psiElement?.parent ?: return null
            return getKtClass(parent)
        }
    }

    private fun getAncestors(baseClassName: String): Collection<PreviewClassDescription> {
        if (DumbService.isDumb(myProject)) return emptyList()
        val baseClasses = JavaPsiFacade.getInstance(myProject)
                .findClasses(baseClassName, GlobalSearchScope.allScope(myProject))
        if (baseClasses.size == 0) return listOf()

        try {
            val cacheService = KotlinCacheService.getInstance(myProject)

            val previewClasses = ArrayList<PreviewClassDescription>(0)
            for (element in ClassInheritorsSearch.search(baseClasses[0]).findAll()) {
                resolveClassDescription(element, cacheService)?.let { previewClasses += it }
            }

            return previewClasses
        }
        catch (e: IndexNotReadyException) {
            return listOf()
        }
    }

    private fun resolveClassDescription(element: PsiElement, cacheService: KotlinCacheService): PreviewClassDescription? {
        if (DumbService.isDumb(element.project)) return null
        val ktClass = getKtClass(element) ?: return null
        val androidFacet = ProjectRootManager.getInstance(myProject).fileIndex
                .getModuleForFile(element.containingFile.virtualFile)?.resolveAndroidFacet() ?: return null
        val resolveSession = cacheService.getResolutionFacade(listOf(ktClass))
                .getFrontendService(ResolveSession::class.java)
        val classDescriptor = resolveSession.getClassDescriptor(ktClass, NoLookupLocation.FROM_IDE)
        val typeMapper = KotlinTypeMapper(resolveSession.bindingContext,
                ClassBuilderMode.LIGHT_CLASSES, CodegenFileClassesProvider(), null,
                IncompatibleClassTracker.DoNothing, "main")

        return PreviewClassDescription(classDescriptor.fqNameSafe.asString(),
                typeMapper.mapType(classDescriptor).internalName, androidFacet)
    }

    override fun isApplicableEditor(textEditor: TextEditor) = true

    private fun Module.resolveAndroidFacet(): AndroidFacet? {
        val facetManager = FacetManager.getInstance(this)
        for (facet in facetManager.allFacets) {
            if (facet is AndroidFacet) {
                return facet
            }
        }
        return null
    }

    private fun showNotification(text: String, messageType: MessageType) {
        val statusBar = WindowManager.getInstance().getStatusBar(myProject) ?: return

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(text, messageType, null)
                .setFadeoutTime(3000)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.component), Balloon.Position.atRight)
    }

    protected fun subrender(psiFile: PsiFile, facet: AndroidFacet, description: PreviewClassDescription,
                            @Suppress("UNUSED_PARAMETER") forceFullRender: Boolean): Boolean {
        callSuperMethod<MergingUpdateQueue>("getRenderingQueue").queue(object : Update("render") {
            override fun run() {
                ProgressManager.getInstance().runProcess({
                    DumbService.getInstance(myProject).waitForSmartMode()
                    try {
                        doRender(facet, psiFile, description)
                    } catch (e: Throwable) {
                        e.printStackTrace()
//                        LOG.error(e)
                    }

                    synchronized (getSuperField("PROGRESS_LOCK")) {
                        val myCurrentIndicator = getSuperField<ProgressIndicatorBase?>("myCurrentIndicator")
                        if (myCurrentIndicator != null) {
                            myCurrentIndicator.stop()
                            setSuperField("myCurrentIndicator", null)
                        }
                    }
                }, AnkoPreviewProgressIndicator(toolWindowForm, 100))
            }

            override fun canEat(update: Update?): Boolean {
                return true
            }
        })
        return true
    }

    private fun doRender(facet: AndroidFacet, psiFile: PsiFile, description: PreviewClassDescription) {
        if (myProject.isDisposed) {
            return
        }

        val myToolWindowForm = toolWindowForm

        val configuration = myToolWindowForm.configuration ?: return

        // Some types of files must be saved to disk first, because layoutlib doesn't
        // delegate XML parsers for non-layout files (meaning layoutlib will read the
        // disk contents, so we have to push any edits to disk before rendering)
        LayoutPullParserFactory.saveFileIfNecessary(psiFile)

        var result: RenderResult? = null

        synchronized (RENDERING_LOCK) {
            val renderService = RenderService.get(facet)
            val logger = renderService.createLogger()
            val task = renderService.createTask(psiFile, configuration, logger, myToolWindowForm)

            if (task != null) {
                val callback = task.getField<LayoutlibCallbackImpl>("myLayoutlibCallback")
                val originalViewLoader = callback.getField<ViewLoader>("myClassLoader")
                val ankoViewLoader = AnkoViewLoader(facet, originalViewLoader, description)
                callback.setField("myClassLoader", ankoViewLoader)

                task.useDesignMode(psiFile)
                result = task.render()
                task.dispose()
            }
            if (result == null) {
                result = RenderResult.createBlank(psiFile, logger)
            }
        }

        if (!callSuperMethod<MergingUpdateQueue>("getRenderingQueue").isEmpty) {
            return
        }

        val renderResult = result
        ApplicationManager.getApplication().invokeLater(Runnable {
            if (!getSuperBooleanField("myToolWindowReady") || getSuperBooleanField("myToolWindowDisposed")) {
                return@Runnable
            }
            val editor = callSuperMethod<TextEditor>("getActiveLayoutXmlEditor") // Must be run from read thread
            myToolWindowForm.setRenderResult(renderResult!!, editor)
            myToolWindowForm.updatePreviewPanel()

            if (RenderPreviewMode.getCurrent() != RenderPreviewMode.NONE) {
                val previewManager = myToolWindowForm.previewPanel.getPreviewManager(myToolWindowForm, true)
                previewManager?.renderPreviews()
            }
        })
    }

    private inner class RefreshDslAction : AnAction("Refresh", null, AllIcons.Actions.Refresh) {

        override fun actionPerformed(e: AnActionEvent) {
            val configuration = toolWindowForm.configuration

            if (configuration != null) {
                // Clear layoutlib bitmap cache (in case files have been modified externally)
                val target = configuration.target
                val module = configuration.module
                if (target != null && module != null) {
                    AndroidTargetData.getTargetData(target, module)?.clearLayoutBitmapCache(module)
                }

                AndroidFacet.getInstance(configuration.module)?.refreshResources()
                configuration.updated(ConfigurationListener.MASK_RENDERING)
            }

            render(null, null, true)
        }
    }

    inner class UpdateActivityNameTask : LongRunningReadTask<PsiElement, PreviewClassDescription>() {
        override fun prepareRequestInfo(): PsiElement? {
            val toolWindow = toolWindow ?: return null
            if (!toolWindow.isVisible) return null

            val editor = FileEditorManager.getInstance(myProject).selectedTextEditor
            val location = Location.fromEditor(editor, myProject)
            if (location.editor == null) return null

            val file = location.kFile
            if (file == null || !ProjectRootsUtil.isInProjectSource(file)) return null


            val psiElement = file.findElementAt(location.startOffset) ?: return null
            return psiElement
        }

        override fun cloneRequestInfo(requestInfo: PsiElement): PsiElement {
            val newRequestInfo = super.cloneRequestInfo(requestInfo)
            assert(requestInfo == newRequestInfo) { "cloneRequestInfo should generate same location object" }
            return newRequestInfo
        }

        override fun hideResultOnInvalidLocation() {

        }

        override fun processRequest(element: PsiElement): PreviewClassDescription? {
            val cacheService = KotlinCacheService.getInstance(myProject)
            return resolveClassDescription(element, cacheService)
        }

        private fun indexOf(model: DefaultComboBoxModel<Any>, description: PreviewClassDescription): Int? {
            for (i in 0..(model.size - 1)) {
                val item = model.getElementAt(i) as? PreviewClassDescription ?: continue
                if (item == description) return i
            }
            return null
        }

        private fun setSelection(model: DefaultComboBoxModel<Any>, description: PreviewClassDescription): Boolean {
            val index = indexOf(model, description) ?: return false
            model.selectedItem = model.getElementAt(index)
            return true
        }

        override fun onResultReady(requestInfo: PsiElement, description: PreviewClassDescription?) {
            if (description == null) return
            val model = myActivityListModel ?: return

            if (!setSelection(model, description)) {
                resolveAvailableClasses()
                setSelection(model, description)
            }
        }
    }
}
