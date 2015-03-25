package org.jetbrains.kotlin.android.dslpreview

import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.components.ServiceManager
import com.intellij.psi.impl.*
import com.intellij.openapi.util.*
import com.intellij.openapi.roots.*
import com.intellij.openapi.module.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiJavaFile
import org.jetbrains.kotlin.psi.JetFile
import java.util.concurrent.atomic.AtomicLong

public class SourceFileModificationTracker : PsiTreeChangePreprocessor, ModificationTracker {

    private val counter = AtomicLong()

    companion object {
        private val HANDLED_EVENTS = setOf(
                PsiTreeChangeEventImpl.PsiEventType.CHILD_ADDED,
                PsiTreeChangeEventImpl.PsiEventType.CHILD_MOVED,
                PsiTreeChangeEventImpl.PsiEventType.CHILD_REMOVED,
                PsiTreeChangeEventImpl.PsiEventType.CHILD_REPLACED,
                PsiTreeChangeEventImpl.PsiEventType.CHILDREN_CHANGED)
    }

    override fun treeChanged(event: PsiTreeChangeEventImpl) {
        if (event.getCode() in HANDLED_EVENTS) {
            val file = event.getFile()
            if (file is JetFile || file is PsiJavaFile) counter.incrementAndGet()
        }
    }

    override fun getModificationCount() = counter.get()
}