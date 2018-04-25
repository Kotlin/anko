package org.jetbrains.kotlin.android.dslpreview

import com.android.tools.idea.common.model.NlModel
import com.android.tools.idea.gradle.project.GradleProjectInfo
import com.android.tools.idea.gradle.project.build.invoker.GradleBuildInvoker
import com.android.tools.idea.project.AndroidProjectInfo
import com.android.tools.idea.uibuilder.editor.NlPreviewForm
import com.android.tools.idea.uibuilder.editor.NlPreviewManager
import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.util.Computable
import com.intellij.openapi.wm.ToolWindow
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.xml.XmlFile
import com.intellij.util.Alarm
import org.jetbrains.android.uipreview.ViewLoaderExtension
import org.jetbrains.kotlin.idea.util.InfinitePeriodicalTask
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import java.awt.BorderLayout
import java.awt.event.ItemEvent
import javax.swing.ComboBoxModel
import javax.swing.DefaultComboBoxModel
import javax.swing.JPanel

class AnkoNlPreviewManager(
        project: Project,
        fileEditorManager: FileEditorManager?
) : NlPreviewManager(project, fileEditorManager), Disposable {
    internal val classResolver = DslPreviewClassResolver(project)

    internal var myActivityListModel: DefaultComboBoxModel<Any> = DefaultComboBoxModel()

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

        GradleBuildInvoker.getInstance(project).add {
            ApplicationManager.getApplication().invokeLater {
                refresh()
            }
        }
    }

    override fun getToolWindowId() = "Anko Layout Preview"
    override fun getComponentName() = "AnkoNlPreviewManager"
    public override fun getToolWindow() = super.getToolWindow()

    override fun getBoundXmlFile(file: PsiFile?): XmlFile? {
        if (file is XmlFile) {
            return file
        } else if (file !is KtFile) {
            return null
        }

        val ankoPreviewFrom = previewForm as? AnkoPreviewForm ?: return null
        val module = ModuleUtilCore.findModuleForPsiElement(file) ?: return null

        return if (refresh() || ankoPreviewFrom.xmlFile == null) {
            generateStubXmlFile(module, file).also {
                ankoPreviewFrom.xmlFile = it
            }
        } else {
            ankoPreviewFrom.xmlFile
        }
    }

    private fun getActiveTextEditor(): TextEditor? {
        if (!ApplicationManager.getApplication().isReadAccessAllowed) {
            return ApplicationManager.getApplication().runReadAction(Computable<TextEditor> { getActiveTextEditor() })
        }
        ApplicationManager.getApplication().assertReadAccessAllowed()
        val fileEditors = fileEditorManager?.selectedEditors
        if (fileEditors != null && fileEditors.isNotEmpty() && fileEditors[0] is TextEditor) {
            val textEditor = fileEditors[0] as TextEditor
            if (isApplicableEditor(textEditor, null)) {
                return textEditor
            }
        }
        return null
    }

    private fun generateStubXmlFile(module: Module, originalFile: KtFile): LayoutPsiFile {
        val filename = "anko_preview.xml"
        val content = """<?xml version="1.0" encoding="utf-8"?>
                <__anko.preview.View xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>"""

        val psiFile = PsiFileFactory.getInstance(project).createFileFromText(filename, XmlFileType.INSTANCE, content)
        return LayoutPsiFile(psiFile as XmlFile, originalFile, module)
    }

    private fun refresh(): Boolean {
        val toolWindow: ToolWindow = toolWindow ?: return false
        if (!toolWindow.isVisible) return false

        val viewLoaderExtension = this.viewLoaderExtension ?: return false
        val description = myActivityListModel.selectedItem as? PreviewClassDescription
                ?: classResolver.getOnCursorPreviewClassDescription()

        if (description != null && viewLoaderExtension.description != description) {
            viewLoaderExtension.description = description
            return true
        }

        return false
    }

    override fun isApplicableEditor(textEditor: TextEditor, file: PsiFile?): Boolean {
        val psiFile =
                file ?: PsiDocumentManager.getInstance(project).getPsiFile(textEditor.editor.document) ?: return false
        if (!GradleProjectInfo.getInstance(project).isBuildWithGradle &&
                !AndroidProjectInfo.getInstance(project).isLegacyIdeaAndroidProject) {
            return false
        }

        return psiFile is KtFile
    }

    private val fileEditorManager: FileEditorManager?
        get() = with(NlPreviewManager::class.java.getDeclaredField("myFileEditorManager")) {
            val oldAccessible = isAccessible
            try {
                isAccessible = true
                get(this@AnkoNlPreviewManager) as? FileEditorManager
            } finally {
                isAccessible = oldAccessible
            }
        }

    override fun initToolWindow() {
        super.initToolWindow()
        resolveAvailableClasses()
    }

    override fun createPreviewForm(): NlPreviewForm = AnkoPreviewForm(this)

    internal fun updatePreview() {
        getActiveTextEditor()?.let { notifyFileShown(it, true) }
    }

    fun resolveAvailableClasses() {
        val activityClasses = classResolver
                .getAncestors(DslPreviewClassResolver.ANKO_COMPONENT_CLASS_NAME)
                .filter { classResolver.isClassApplicableForPreview(it.ktClass) }

        with(myActivityListModel) {
            selectedItem = null
            removeAllElements()
            val items = activityClasses
            items.sortedBy { it.toString() }.forEach { addElement(it) }
        }
    }

    override fun isUseInteractiveSelector() = false

    override fun dispose() {}
}

class AnkoPreviewForm(private val ankoPreviewManager: AnkoNlPreviewManager) : NlPreviewForm(ankoPreviewManager) {
    var xmlFile: XmlFile? = null

    override fun setActiveModel(model: NlModel?) {
        super.setActiveModel(model)

        if (model != null) {
            (this.toolbarComponent as? JPanel)?.let { addLayoutComboBox(it) }
        }
    }

    private fun addLayoutComboBox(panel: JPanel) {
        if (panel.components.firstIsInstanceOrNull<PreviewCandidateComboBox>() != null) {
            return
        }

        val comboBox = PreviewCandidateComboBox(ankoPreviewManager.myActivityListModel)
        comboBox.addItemListener { itemEvent ->
            if (itemEvent.stateChange == ItemEvent.SELECTED) {
                ankoPreviewManager.updatePreview()
            }
        }

        panel.add(comboBox, BorderLayout.SOUTH)
    }
}

class PreviewCandidateComboBox(model: ComboBoxModel<Any>) : ComboBox<Any>(model)
