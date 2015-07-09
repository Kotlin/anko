package org.jetbrains.anko.idea.intentions

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.analyzer.analyzeInContext
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.intentions.JetSelfTargetingIntention
import org.jetbrains.kotlin.idea.quickfix.moveCaret
import org.jetbrains.kotlin.idea.util.ImportInsertHelper
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.DescriptorToSourceUtils
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.FunctionDescriptorUtil
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.scopes.*
import org.jetbrains.kotlin.types.lowerIfFlexible
import org.jetbrains.kotlin.utils.Printer
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import java.io.File

abstract class AnkoIntention<TElement : JetElement>(
        elementType: Class<TElement>,
        text: String,
        familyName: String = text,
        firstElementOfTypeOnly: Boolean = false
) : JetSelfTargetingIntention<TElement>(elementType, text, familyName, firstElementOfTypeOnly) {

    private fun isTypeOf(descriptor: ClassifierDescriptor, vararg fqName: String): Boolean {
        val resolvedName = DescriptorUtils.getFqNameSafe(descriptor).asString()
        return fqName.any { it == resolvedName }
    }

    protected fun JetCallExpression.isValueParameterTypeOf(parameterIndex: Int, resolvedCall: ResolvedCall<*>?, vararg fqName: String): Boolean {
        val ctxArgumentDescriptor = (resolvedCall ?: getResolvedCall(analyze()))?.getResultingDescriptor()
                ?.getValueParameters()?.get(parameterIndex)?.getType()?.lowerIfFlexible()
                ?.getConstructor()?.getDeclarationDescriptor() ?: return false
        return isTypeOf(ctxArgumentDescriptor, *fqName)
    }

    protected fun JetCallExpression.isReceiverParameterTypeOf(resolvedCall: ResolvedCall<*>?, vararg fqName: String): Boolean {
        val receiverDescriptor = (resolvedCall ?: getResolvedCall(analyze()))?.getResultingDescriptor()
                ?.getDispatchReceiverParameter()?.getType()?.lowerIfFlexible()
                ?.getConstructor()?.getDeclarationDescriptor() ?: return false
        return isTypeOf(receiverDescriptor, *fqName)
    }

    protected val JetDotQualifiedExpression.receiver: JetExpression?
        get() = getReceiverExpression()

    protected val JetDotQualifiedExpression.selector: JetExpression?
        get() = getSelectorExpression()

    protected val PsiElement.text: String
        get() = getText()

    protected val JetBinaryExpressionWithTypeRHS.operation: JetSimpleNameExpression
        get() = getOperationReference()

    protected inline fun <reified E : PsiElement> PsiElement?.require(name: String? = null, sub: E.() -> Boolean): Boolean {
        return require<E>(name) && (this as E).sub()
    }

    protected inline fun <reified E : PsiElement> PsiElement?.require(name: String? = null): Boolean {
        if (this !is E) return false
        if (name != null && name != this.getText()) return false
        return true
    }

    protected inline fun PsiElement?.requireCall(functionName: String? = null, argCount: Int? = null, sub: JetCallExpression.() -> Boolean): Boolean {
        return requireCall(functionName, argCount) && (this as JetCallExpression).sub()
    }

    suppress("NOTHING_TO_INLINE")
    protected inline fun PsiElement?.requireCall(functionName: String? = null, argCount: Int? = null): Boolean {
        if (this !is JetCallExpression) return false
        if (functionName != null && functionName != getCalleeExpression()?.getText()) return false
        if (argCount != null && argCount != getValueArguments().size()) return false
        return true
    }

    protected fun getResolutionScope(descriptor: DeclarationDescriptor): JetScope? {
        return when (descriptor) {
            is PackageFragmentDescriptor -> {
                val moduleDescriptor = descriptor.getContainingDeclaration()
                getResolutionScope(moduleDescriptor.getPackage(descriptor.fqName)!!)
            }

            is PackageViewDescriptor ->
                descriptor.getMemberScope()

            is ClassDescriptorWithResolutionScopes ->
                descriptor.getScopeForMemberDeclarationResolution()

            is FunctionDescriptor ->
                FunctionDescriptorUtil.getFunctionInnerScope(getResolutionScope(descriptor.getContainingDeclaration()),
                        descriptor, RedeclarationHandler.DO_NOTHING)

            is PropertyDescriptor ->
                JetScopeUtils.getPropertyDeclarationInnerScope(descriptor,
                        getResolutionScope(descriptor.getContainingDeclaration()!!),
                        RedeclarationHandler.DO_NOTHING)
            is LocalVariableDescriptor -> {
                val declaration = DescriptorToSourceUtils.descriptorToDeclaration(descriptor) as JetDeclaration
                declaration.analyze()[BindingContext.RESOLUTION_SCOPE, declaration]
            }

            else -> throw IllegalArgumentException("Cannot find resolution scope for $descriptor")
        }
    }

    abstract fun replaceWith(element: TElement, psiFactory: JetPsiFactory): NewElement?

    final override fun applyTo(element: TElement, editor: Editor) {
        val project = editor.getProject() ?: return

        val resolutionFacade = element.getResolutionFacade()
        val containingJetDeclaration = JetStubbedPsiUtil.getContainingDeclaration(element) ?: return
        val containingDeclaration = resolutionFacade.resolveToDescriptor(containingJetDeclaration)
        val jetFile = element.getContainingJetFile()

        val psiFactory = JetPsiFactory(project)
        val newElement = replaceWith(element, psiFactory) ?: return
        val newExpression = newElement.element

        val explicitlyImportedSymbols = newElement.newFqNames.flatMap { fqName ->
            resolutionFacade.resolveImportReference(jetFile, FqName("$ANKO_PACKAGE$fqName"), false)
        }
        val symbolScope = getResolutionScope(containingDeclaration) ?: return
        val scope = ChainedScope(containingDeclaration, "SimplifyToastIntention resolution scope", ExplicitImportsScope(explicitlyImportedSymbols), symbolScope)
        var bindingContext = newExpression.analyzeInContext(scope)
        val functionDescriptor = newExpression.getResolvedCall(bindingContext)?.getResultingDescriptor() ?: return
        ImportInsertHelper.getInstance(project).importDescriptor(element.getContainingJetFile(), functionDescriptor)

        element.replace(newExpression)
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

class ExplicitImportsScope(val descriptors: Collection<DeclarationDescriptor>) : JetScope {
    override fun getClassifier(name: Name) = descriptors.filter { it.getName() == name }.firstIsInstanceOrNull<ClassifierDescriptor>()

    override fun getPackage(name: Name)= descriptors.filter { it.getName() == name }.firstIsInstanceOrNull<PackageViewDescriptor>()

    override fun getProperties(name: Name) = descriptors.filter { it.getName() == name }.filterIsInstance<VariableDescriptor>()

    override fun getLocalVariable(name: Name): VariableDescriptor? = null

    override fun getFunctions(name: Name) = descriptors.filter { it.getName() == name }.filterIsInstance<FunctionDescriptor>()

    override fun getContainingDeclaration() = throw UnsupportedOperationException()

    override fun getDeclarationsByLabel(labelName: Name) = emptyList<DeclarationDescriptor>()

    override fun getDescriptors(kindFilter: DescriptorKindFilter, nameFilter: (Name) -> Boolean) = descriptors

    override fun getImplicitReceiversHierarchy() = emptyList<ReceiverParameterDescriptor>()

    override fun getOwnDeclaredDescriptors() = emptyList<DeclarationDescriptor>()

    override fun printScopeStructure(p: Printer) {
        p.println(javaClass.getName())
    }
}

class NewElement(val element: JetExpression, vararg newFqNames: String) {
    val newFqNames = newFqNames.toList()
}