package org.jetbrains.anko.idea.intentions

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.findModuleDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.caches.resolve.resolveImportReference
import org.jetbrains.kotlin.idea.imports.importableFqName
import org.jetbrains.kotlin.idea.intentions.SelfTargetingIntention
import org.jetbrains.kotlin.idea.util.ImportInsertHelper
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.*
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.descriptorUtil.resolveTopLevelClass
import org.jetbrains.kotlin.types.lowerIfFlexible

abstract class AnkoIntention<TElement : KtElement>(
        elementType: Class<TElement>,
        text: String,
        familyName: String = text
) : SelfTargetingIntention<TElement>(elementType, text, familyName) {

    final override fun isApplicableTo(element: TElement, caretOffset: Int): Boolean {
        val file = element.containingFile as? KtFile ?: return false
        val moduleDescriptor = file.findModuleDescriptor()
        moduleDescriptor.resolveTopLevelClass(ANKO_INTERNALS_FQNAME, NoLookupLocation.FROM_IDE) ?: return false
        return isApplicable(element, caretOffset)
    }

    abstract fun isApplicable(element: TElement, caretOffset: Int): Boolean

    private fun isTypeOf(descriptor: ClassifierDescriptor, vararg fqName: String): Boolean {
        val resolvedName = DescriptorUtils.getFqNameSafe(descriptor).asString()
        return fqName.any { it == resolvedName }
    }

    protected fun KtCallExpression.isValueParameterTypeOf(
            parameterIndex: Int,
            resolvedCall: ResolvedCall<*>?,
            vararg fqName: String
    ): Boolean {
        val ctxArgumentDescriptor = (resolvedCall ?: getResolvedCall(analyze()))?.resultingDescriptor
                ?.valueParameters?.get(parameterIndex)?.type?.lowerIfFlexible()
                ?.constructor?.declarationDescriptor ?: return false
        return isTypeOf(ctxArgumentDescriptor, *fqName)
    }

    protected fun KtCallExpression.isReceiverParameterTypeOf(
            resolvedCall: ResolvedCall<*>?,
            vararg fqName: String
    ): Boolean {
        val receiverDescriptor = (resolvedCall ?: getResolvedCall(analyze()))?.resultingDescriptor
                ?.dispatchReceiverParameter?.type?.lowerIfFlexible()
                ?.constructor?.declarationDescriptor ?: return false
        return isTypeOf(receiverDescriptor, *fqName)
    }

    protected val KtDotQualifiedExpression.receiver: KtExpression?
        get() = receiverExpression

    protected val KtDotQualifiedExpression.selector: KtExpression?
        get() = selectorExpression

    protected val KtBinaryExpressionWithTypeRHS.operation: KtSimpleNameExpression
        get() = operationReference

    protected inline fun <reified E : PsiElement> PsiElement?.require(name: String? = null, sub: E.() -> Boolean): Boolean {
        return require<E>(name) && (this as E).sub()
    }

    inline fun require(cond: Boolean, sub: () -> Boolean): Boolean {
        if (cond) sub()
        return cond
    }

    protected inline fun <reified E : PsiElement> PsiElement?.require(name: String? = null): Boolean {
        if (this !is E) return false
        if (name != null && name != this.text) return false
        return true
    }

    protected inline fun PsiElement?.requireCall(
            functionName: String? = null,
            argCount: Int? = null,
            sub: KtCallExpression.() -> Boolean
    ): Boolean {
        return requireCall(functionName, argCount) && (this as KtCallExpression).sub()
    }

    @Suppress("NOTHING_TO_INLINE")
    protected inline fun PsiElement?.requireCall(functionName: String? = null, argCount: Int? = null): Boolean {
        if (this !is KtCallExpression) return false
        if (functionName != null && functionName != calleeExpression?.text) return false
        if (argCount != null && argCount != valueArguments.size) return false
        return true
    }

    abstract fun replaceWith(element: TElement, psiFactory: KtPsiFactory): NewElement?

    final override fun applyTo(element: TElement, editor: Editor?) {
        val project = editor?.project ?: return
        val file = element.containingFile as? KtFile ?: return
        val moduleDescriptor = file.findModuleDescriptor()
        val resolutionFacade = file.getResolutionFacade()

        val psiFactory = KtPsiFactory(project)
        val (newElement, fqNamesToImport) = replaceWith(element, psiFactory) ?: return

        val newExpression = newElement

        ImportInsertHelper.getInstance(project).apply {
            fqNamesToImport
                    .flatMap {
                        val fqName = FqName(if ('.' in it) it else "$ANKO_PACKAGE$it")
                        resolutionFacade.resolveImportReference(moduleDescriptor, fqName)
                    }
                    .forEach { if (it.importableFqName != null) importDescriptor(file, it) }
        }

        element.replace(newExpression)
    }

    private companion object {
        private val ANKO_PACKAGE = "org.jetbrains.anko."
        private val ANKO_INTERNALS_FQNAME = FqName("org.jetbrains.anko.internals.AnkoInternals")
    }
}

object FqNames {
    val ACTIVITY_FQNAME = "android.app.Activity"
    val CONTEXT_FQNAME = "android.content.Context"
    val VIEW_FQNAME = "android.view.View"
}

class NewElement(val element: KtExpression, vararg val newNames: String) {
    operator fun component1() = element
    operator fun component2() = newNames //fqName or name in anko package
}

abstract class A {
    open fun test(a: CharSequence) {}
}

class B : A() {
    override fun test(a: CharSequence) {}
}