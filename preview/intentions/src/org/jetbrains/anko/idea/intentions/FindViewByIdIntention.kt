package org.jetbrains.anko.idea.intentions

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall

class FindViewByIdIntention : AnkoIntention<KtExpression>(
        KtExpression::class.java,
        "Simplify findViewById() with Anko"
) {
    override fun isApplicable(element: KtExpression, caretOffset: Int): Boolean {
        fun PsiElement?.requireFindViewByIdCall() = requireCall(FIND_VIEW_BY_ID, 1) {
            val resolvedCall = getResolvedCall(analyze())
            isValueParameterTypeOf(0, resolvedCall, "kotlin.Int")
                    && isReceiverParameterTypeOf(resolvedCall, FqNames.ACTIVITY_FQNAME, FqNames.VIEW_FQNAME)
        }

        return element.require<KtBinaryExpressionWithTypeRHS>() {
            operation.require<KtSimpleNameExpression>("as")
            && (left.requireFindViewByIdCall() || left.require<KtDotQualifiedExpression> {
                selector.requireFindViewByIdCall()
            })
        }
    }

    override fun replaceWith(element: KtExpression, psiFactory: KtPsiFactory): NewElement? {
        fun KtCallExpression.createElement(type: String, receiver: String? = null): NewElement {
            val id = valueArguments[0].text
            val receiverWithDot = if (receiver == null) "" else "$receiver."
            val newExpression = psiFactory.createExpression("${receiverWithDot}find<$type>($id)")
            return NewElement(newExpression, "find")
        }

        element.require<KtBinaryExpressionWithTypeRHS>() {
            val type = right?.text ?: return null

            left.requireCall(FIND_VIEW_BY_ID) {
                return createElement(type)
            }
            left.require<KtDotQualifiedExpression> {
                selector.requireCall(FIND_VIEW_BY_ID) {
                    return createElement(type, receiver?.text)
                }
            }
        }
        return null
    }

    private companion object {
        val FIND_VIEW_BY_ID = "findViewById"
    }

}
