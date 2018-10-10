package org.jetbrains.kotlin.android.dslpreview

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.wm.ToolWindow
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.idea.internal.Location
import org.jetbrains.kotlin.idea.util.LongRunningReadTask
import org.jetbrains.kotlin.idea.util.ProjectRootsUtil
import javax.swing.DefaultComboBoxModel

class UpdateActivityNameTask(
        val previewManager: AnkoNlPreviewManager
) : LongRunningReadTask<PsiElement, PreviewClassDescription>() {
    override fun prepareRequestInfo(): PsiElement? = with (previewManager) {
        val toolWindow: ToolWindow = toolWindow ?: return null
        if (!toolWindow.isVisible) return null

        val editor = FileEditorManager.getInstance(project).selectedTextEditor
        val location = Location.fromEditor(editor, project)
        if (location.editor == null) return null

        val file = location.kFile
        if (file == null ||
                !ProjectRootsUtil.isInProjectSource(file))
            return null

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
        val cacheService = KotlinCacheService.getInstance(previewManager.project)
        return previewManager.classResolver.resolveClassDescription(element, cacheService)
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

    override fun onResultReady(requestInfo: PsiElement, description: PreviewClassDescription?) = with (previewManager) {
        if (description == null) return
        val model = myActivityListModel

        if (!setSelection(model, description)) {
            resolveAvailableClasses()
            setSelection(model, description)
        }
    }
}
