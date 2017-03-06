package org.jetbrains.kotlin.android.dslpreview

import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.openapi.project.Project
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ClassInheritorsSearch
import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.kotlin.asJava.elements.KtLightElement
import org.jetbrains.kotlin.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.codegen.ClassBuilderMode
import org.jetbrains.kotlin.codegen.CodegenFileClassesProvider
import org.jetbrains.kotlin.codegen.state.IncompatibleClassTracker
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.lazy.ResolveSession
import java.util.ArrayList

internal class DslPreviewClassResolver(val project: Project) {
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

    fun getOnCursorPreviewClassDescription(): PreviewClassDescription? {
        val editor = FileEditorManager.getInstance(project).selectedTextEditor ?: return null
        val psiFile = PsiDocumentManager.getInstance(project).getPsiFile(editor.document)

        if (psiFile !is KtFile || editor !is EditorEx) return null

        val selectionStart = editor.caretModel.primaryCaret.selectionStart
        val psiElement = psiFile.findElementAt(selectionStart) ?: return null

        val cacheService = KotlinCacheService.getInstance(project)
        return resolveClassDescription(psiElement, cacheService)
    }

    fun getAncestors(baseClassName: String): Collection<PreviewClassDescription> {
        if (DumbService.isDumb(project)) return emptyList()
        val baseClasses = JavaPsiFacade.getInstance(project)
                .findClasses(baseClassName, GlobalSearchScope.allScope(project))

        if (baseClasses.isEmpty()) return emptyList()

        try {
            val cacheService = KotlinCacheService.getInstance(project)

            val previewClasses = ArrayList<PreviewClassDescription>(0)
            for (element in ClassInheritorsSearch.search(baseClasses[0]).findAll()) {
                resolveClassDescription(element, cacheService)?.let { previewClasses += it }
            }

            return previewClasses
        }
        catch (e: IndexNotReadyException) {
            return emptyList()
        }
    }

    fun resolveClassDescription(element: PsiElement, cacheService: KotlinCacheService): PreviewClassDescription? {
        if (DumbService.isDumb(element.project)) return null
        val ktClass = getKtClass(element) ?: return null
        val androidFacet = AndroidFacet.getInstance(element) ?: return null
        val resolveSession = cacheService.getResolutionFacade(listOf(ktClass))
                .getFrontendService(ResolveSession::class.java)
        val classDescriptor = resolveSession.getClassDescriptor(ktClass, NoLookupLocation.FROM_IDE)
        val typeMapper = KotlinTypeMapper(resolveSession.bindingContext,
                ClassBuilderMode.LIGHT_CLASSES, CodegenFileClassesProvider(), IncompatibleClassTracker.DoNothing, "main",
                false, false)

        return PreviewClassDescription(ktClass, classDescriptor.fqNameSafe.asString(),
                typeMapper.mapType(classDescriptor).internalName)
    }


}