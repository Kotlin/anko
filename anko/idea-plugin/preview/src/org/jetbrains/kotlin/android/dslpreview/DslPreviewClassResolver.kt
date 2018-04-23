package org.jetbrains.kotlin.android.dslpreview

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.IndexNotReadyException
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Computable
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ClassInheritorsSearch
import org.jetbrains.kotlin.asJava.elements.KtLightElement
import org.jetbrains.kotlin.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.codegen.ClassBuilderMode
import org.jetbrains.kotlin.codegen.state.IncompatibleClassTracker
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtConstructor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameUnsafe
import org.jetbrains.kotlin.resolve.lazy.ResolveSession
import org.jetbrains.kotlin.types.typeUtil.supertypes
import java.util.ArrayList

internal class DslPreviewClassResolver(private val project: Project) {

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
        val editor = ApplicationManager.getApplication().runReadAction(Computable {
            FileEditorManager.getInstance(project).selectedTextEditor
        }) ?: return null

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

        return try {
            val cacheService = KotlinCacheService.getInstance(project)

            val previewClasses = ArrayList<PreviewClassDescription>(0)
            for (element in ClassInheritorsSearch.search(baseClasses[0]).findAll()) {
                resolveClassDescription(element, cacheService)?.let { previewClasses += it }
            }

            previewClasses
        }
        catch (e: IndexNotReadyException) {
            emptyList()
        }
    }

    private fun isZeroParameterConstructor(constructor: KtConstructor<*>?): Boolean {
        if (constructor == null) return false
        val parameters = constructor.getValueParameters()
        return parameters.isEmpty() || parameters.all { it.hasDefaultValue() }
    }


    fun isClassApplicableForPreview(clazz: KtClass): Boolean {
        val primaryConstructor = clazz.primaryConstructor
        val secondaryConstructors = clazz.secondaryConstructors

        return (primaryConstructor == null && secondaryConstructors.isEmpty())
                || isZeroParameterConstructor(primaryConstructor)
                || secondaryConstructors.any(this::isZeroParameterConstructor)
    }

    fun resolveClassDescription(element: PsiElement, cacheService: KotlinCacheService): PreviewClassDescription? {
        if (DumbService.isDumb(element.project)) return null
        val ktClass = getKtClass(element) ?: return null
        if (!isClassApplicableForPreview(ktClass)) return null

        val resolveSession = cacheService.getResolutionFacade(listOf(ktClass))
                .getFrontendService(ResolveSession::class.java)
        val classDescriptor = resolveSession.getClassDescriptor(ktClass, NoLookupLocation.FROM_IDE)

        if (!classDescriptor.defaultType.supertypes().any {
            val fqName = it.constructor.declarationDescriptor?.fqNameUnsafe?.asString() ?: ""
            fqName == ANKO_COMPONENT_CLASS_NAME
        }) {
            return null
        }

        val typeMapper = createTypeMapper(resolveSession.bindingContext)

        return PreviewClassDescription(ktClass, classDescriptor.fqNameSafe.asString(),
                typeMapper.mapType(classDescriptor).internalName)
    }

    companion object {
        val ANKO_COMPONENT_CLASS_NAME = "org.jetbrains.anko.AnkoComponent"

        private fun createTypeMapper(bindingContext: BindingContext): KotlinTypeMapper {
            return KotlinTypeMapper(
                    bindingContext,
                    ClassBuilderMode.LIGHT_CLASSES,
                    IncompatibleClassTracker.DoNothing,
                    "main",
                    false,
                    false
            )
        }
    }
}