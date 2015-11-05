package org.jetbrains.anko.idea.intentions

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.findModuleDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.caches.resolve.resolveImportReference
import org.jetbrains.kotlin.idea.intentions.JetSelfTargetingIntention
import org.jetbrains.kotlin.idea.resolve.ResolutionFacade
import org.jetbrains.kotlin.idea.util.ImportInsertHelper
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.*
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.calls.smartcasts.DataFlowInfo
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.lazy.descriptors.ClassResolutionScopesSupport
import org.jetbrains.kotlin.resolve.scopes.*
import org.jetbrains.kotlin.resolve.scopes.ExplicitImportsScope
import org.jetbrains.kotlin.resolve.scopes.utils.memberScopeAsFileScope
import org.jetbrains.kotlin.storage.LockBasedStorageManager
import org.jetbrains.kotlin.types.TypeUtils
import org.jetbrains.kotlin.types.expressions.ExpressionTypingServices
import org.jetbrains.kotlin.types.lowerIfFlexible

abstract class AnkoIntention<TElement : KtElement>(
        elementType: Class<TElement>,
        text: String,
        familyName: String = text
) : JetSelfTargetingIntention<TElement>(elementType, text, familyName) {

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

    private fun getResolutionScope(descriptor: DeclarationDescriptor): LexicalScope {
        return when (descriptor) {
            is PackageFragmentDescriptor -> {
                val moduleDescriptor = descriptor.containingDeclaration
                getResolutionScope(moduleDescriptor.getPackage(descriptor.fqName))
            }

            is PackageViewDescriptor ->
                descriptor.memberScope.memberScopeAsFileScope()

            is ClassDescriptorWithResolutionScopes ->
                descriptor.scopeForMemberDeclarationResolution

            is ClassDescriptor -> {
                val outerScope = getResolutionScope(descriptor.containingDeclaration)
                ClassResolutionScopesSupport(descriptor, LockBasedStorageManager.NO_LOCKS, { outerScope })
                        .scopeForMemberDeclarationResolution()
            }

            is FunctionDescriptor ->
                FunctionDescriptorUtil.getFunctionInnerScope(getResolutionScope(descriptor.containingDeclaration),
                        descriptor, RedeclarationHandler.DO_NOTHING)

            is PropertyDescriptor ->
                JetScopeUtils.getPropertyDeclarationInnerScope(descriptor,
                        getResolutionScope(descriptor.containingDeclaration),
                        RedeclarationHandler.DO_NOTHING)
            is LocalVariableDescriptor -> {
                val declaration = DescriptorToSourceUtils.descriptorToDeclaration(descriptor) as KtDeclaration
                declaration.analyze().get(BindingContext.LEXICAL_SCOPE, declaration)!!
            }

            else -> throw IllegalArgumentException("Cannot find resolution scope for $descriptor")
        }
    }
    abstract fun replaceWith(element: TElement, psiFactory: KtPsiFactory): NewElement?

    final override fun applyTo(element: TElement, editor: Editor) {
        val project = editor.project ?: return

        val resolutionFacade = element.getResolutionFacade()
        val containingJetDeclaration = KtStubbedPsiUtil.getContainingDeclaration(element) ?: return
        val containingDeclaration = resolutionFacade.resolveToDescriptor(containingJetDeclaration)
                as? CallableDescriptor ?: return
        val jetFile = element.getContainingJetFile()


        val psiFactory = KtPsiFactory(project)
        val newElement = replaceWith(element, psiFactory) ?: return
        val newExpression = newElement.element

        val explicitlyImportedSymbols = newElement.newFqNames.flatMap { fqName ->
            resolutionFacade.resolveImportReference(jetFile.findModuleDescriptor(), FqName("$ANKO_PACKAGE$fqName"))
        }
        val symbolScope = getResolutionScope(containingDeclaration)
        val scope = LexicalChainedScope(symbolScope, containingDeclaration,
                false, null, "ReplaceWith resolution scope", ExplicitImportsScope(explicitlyImportedSymbols))
        var bindingContext = analyzeInContext(newExpression, containingDeclaration, scope, resolutionFacade)
        val functionDescriptor = newExpression.getResolvedCall(bindingContext)?.resultingDescriptor ?: return
        ImportInsertHelper.getInstance(project).importDescriptor(element.getContainingJetFile(), functionDescriptor)

        element.replace(newExpression)
    }

    private fun analyzeInContext(
            expression: KtExpression,
            symbolDescriptor: CallableDescriptor,
            scope: LexicalScope,
            resolutionFacade: ResolutionFacade
    ): BindingContext {
        val traceContext = BindingTraceContext()
        resolutionFacade.getFrontendService(symbolDescriptor.module, ExpressionTypingServices::class.java)
                .getTypeInfo(scope, expression, TypeUtils.NO_EXPECTED_TYPE, DataFlowInfo.EMPTY, traceContext, false)
        return traceContext.bindingContext
    }

    private companion object {
        private val ANKO_PACKAGE = "org.jetbrains.anko."
    }
}

object FqNames {
    val ACTIVITY_FQNAME = "android.app.Activity"
    val CONTEXT_FQNAME = "android.content.Context"
    val VIEW_FQNAME = "android.view.View"
}

class NewElement(val element: KtExpression, vararg newFqNames: String) {
    val newFqNames = newFqNames.toList()
}