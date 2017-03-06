package org.jetbrains.kotlin.android.dslpreview

import com.android.tools.idea.gradle.invoker.GradleInvoker
import com.android.tools.idea.gradle.project.BuildSettings
import com.android.tools.idea.gradle.util.BuildMode
import com.android.tools.idea.gradle.util.Projects
import com.android.tools.idea.uibuilder.editor.NlPreviewManager
import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.ThreeComponentsSplitter
import com.intellij.openapi.util.Computable
import com.intellij.psi.*
import com.intellij.psi.impl.PsiTreeChangePreprocessor
import com.intellij.psi.xml.XmlFile
import com.intellij.uiDesigner.core.GridConstraints
import com.intellij.uiDesigner.core.GridLayoutManager
import com.intellij.util.Alarm
import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.android.uipreview.ViewLoaderExtension
import org.jetbrains.kotlin.idea.util.InfinitePeriodicalTask
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import java.awt.event.ItemEvent
import javax.swing.DefaultComboBoxModel
import javax.swing.JPanel

class AnkoNlPreviewManager(
        project: Project,
        fileEditorManager: FileEditorManager?
) : NlPreviewManager(project, fileEditorManager), Disposable {
    internal val classResolver = DslPreviewClassResolver(project)

    @Volatile
    private var lastSourceFileModification = -1L

    internal var myActivityListModel: DefaultComboBoxModel<Any>? = null

    private val sourceFileModificationTracker by lazy {
        project.getExtensions(PsiTreeChangePreprocessor.EP_NAME)
                .first { it is SourceFileModificationTracker } as SourceFileModificationTracker
    }

    private val viewLoaderExtension by lazy {
        val area = Extensions.getArea(project)

        if (area.hasExtensionPoint(ViewLoaderExtension.EP_NAME.name)) {
            area.getExtensionPoint(ViewLoaderExtension.EP_NAME).extensions.firstIsInstanceOrNull<AnkoViewLoaderExtension>()
        } else {
            null
        }
    }

    init {
        ApplicationManager.getApplication().invokeLater {
            val task = Computable { UpdateActivityNameTask(this) }
            InfinitePeriodicalTask(1000, Alarm.ThreadToUse.SWING_THREAD, this@AnkoNlPreviewManager, task).start()
        }
    }

    override fun getToolWindowId() = "Anko DSL Preview"
    override fun getComponentName() = "AnkoNlPreviewManager"
    public override fun getToolWindow() = super.getToolWindow()

    override fun getBoundXmlFile(file: PsiFile?): XmlFile? {
        if (file is XmlFile) {
            return file
        } else if (file !is KtFile) {
            return null
        }

        requestCompileIfNeeded()
        refresh()

        return generateStubXmlFile()
    }

    fun getActiveTextEditor(): TextEditor? {
        if (!ApplicationManager.getApplication().isReadAccessAllowed) {
            return ApplicationManager.getApplication().runReadAction(Computable<TextEditor> { getActiveTextEditor() })
        }
        ApplicationManager.getApplication().assertReadAccessAllowed()
        val fileEditors = fileEditorManager.selectedEditors
        if (fileEditors.isNotEmpty() && fileEditors[0] is TextEditor) {
            val textEditor = fileEditors[0] as TextEditor
            if (isApplicableEditor(textEditor)) {
                return textEditor
            }
        }
        return null
    }

    internal fun generateStubXmlFile(): LayoutPsiFile {
        val filename = "anko_preview.xml"
        val content = """<?xml version="1.0" encoding="utf-8"?>
                <__anko.preview.View xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>"""

        val psiFile = PsiFileFactory.getInstance(project).createFileFromText(filename, XmlFileType.INSTANCE, content)
        return LayoutPsiFile(psiFile as XmlFile)
    }

    private fun refresh() {
        val viewLoaderExtension = this.viewLoaderExtension ?: return
        val description = myActivityListModel?.selectedItem as? PreviewClassDescription
                ?: classResolver.getOnCursorPreviewClassDescription()

        if (description != null && viewLoaderExtension.description != description) {
            viewLoaderExtension.description = description
        }
    }

    override fun isApplicableEditor(textEditor: TextEditor?): Boolean {
        val document = textEditor?.editor?.document ?: return false
        val psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document) ?: return false

        val facet = AndroidFacet.getInstance(psiFile) ?: return false
        if (!Projects.isBuildWithGradle(facet.module) && !Projects.isLegacyIdeaAndroidModule(facet.module)) {
            return false
        }

        return psiFile is KtFile
    }

    override fun initToolWindow() {
        super.initToolWindow()

        val panel = (previewForm.contentPanel as? ThreeComponentsSplitter)?.innerComponent?.getComponent(0)

        if (panel is JPanel) {
            val firstToolbar = panel.getComponent(0)
            val secondToolbar = panel.getComponent(1)

            panel.remove(firstToolbar)
            panel.remove(secondToolbar)
            val manager = GridLayoutManager(2, 1)
            panel.layout = manager

            myActivityListModel = DefaultComboBoxModel()
            val comboBox = ComboBox(myActivityListModel)

            comboBox.addItemListener { itemEvent ->
                if (itemEvent.stateChange == ItemEvent.SELECTED) {
                    updatePreview()
                }
            }

            fun constraints(row: Int, column: Int, init: GridConstraints.() -> Unit): GridConstraints {
                return with(GridConstraints()) {
                    setRow(row)
                    setColumn(column)
                    init()
                    this
                }
            }

            // Hide the action panel
//            panel.add(firstToolbar, constraints(0, 0) {
//                fill = GridConstraints.FILL_BOTH
//            })

            panel.add(secondToolbar, constraints(0, 0) {
                fill = GridConstraints.FILL_VERTICAL
                anchor = GridConstraints.ANCHOR_EAST
            })

            panel.add(comboBox, constraints(1, 0) {
                fill = GridConstraints.FILL_BOTH
            })
        }

        resolveAvailableClasses()
    }

    private fun updatePreview() {
        getActiveTextEditor()?.let { notifyFileShown(it, true) }
    }

    fun resolveAvailableClasses() {
        fun isZeroParameterConstructor(constructor: KtConstructor<*>?): Boolean {
            if (constructor == null) return false
            val parameters = constructor.getValueParameters()
            return parameters.isEmpty() || parameters.all { it.hasDefaultValue() }
        }

        val activityClasses = classResolver.getAncestors("org.jetbrains.anko.AnkoComponent").filter { description ->
            val clazz = description.ktClass
            val primaryConstructor = clazz.primaryConstructor
            val secondaryConstructors = clazz.secondaryConstructors

            (primaryConstructor == null && secondaryConstructors.isEmpty())
                    || isZeroParameterConstructor(primaryConstructor)
                    || secondaryConstructors.any(::isZeroParameterConstructor)
        }

        if (myActivityListModel != null) {
            with(myActivityListModel!!) {
                selectedItem = null
                removeAllElements()
                val items = activityClasses
                items.sortedBy { it.toString() }.forEach { addElement(it) }
            }
        }
    }

    override fun isUseInteractiveSelector() = false

    private fun requestCompileIfNeeded() {
        val actualSourceFileModification = sourceFileModificationTracker.modificationCount
        if (actualSourceFileModification == lastSourceFileModification) return

        val modules = ModuleManager.getInstance(project).modules
        val gradleInvoker = GradleInvoker.getInstance(project)
        val buildMode = BuildMode.COMPILE_JAVA
        BuildSettings.getInstance(project).buildMode = buildMode
        val tasks = GradleInvoker.findTasksToExecute(modules, buildMode, GradleInvoker.TestCompileType.NONE)

        gradleInvoker.addAfterGradleInvocationTask { result ->
            if (result.isBuildSuccessful) {
                ApplicationManager.getApplication().invokeLater {
                    lastSourceFileModification = actualSourceFileModification
                    refresh()
                }
            }
        }

        gradleInvoker.executeTasks(tasks)
    }

    override fun dispose() {}
}