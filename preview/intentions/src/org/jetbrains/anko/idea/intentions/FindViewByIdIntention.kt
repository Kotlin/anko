package org.jetbrains.anko.idea.intentions

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall

public class FindViewByIdIntention : AnkoIntention<JetExpression>(JetExpression::class.java, "Simplify findViewById() with Anko") {
    override fun isApplicableTo(element: JetExpression, caretOffset: Int): Boolean {
        fun PsiElement?.requireFindViewByIdCall() = requireCall(FIND_VIEW_BY_ID, 1) {
            val resolvedCall = getResolvedCall(analyze())
            isValueParameterTypeOf(0, resolvedCall, "kotlin.Int")
                    && isReceiverParameterTypeOf(resolvedCall, FqNames.ACTIVITY_FQNAME, FqNames.VIEW_FQNAME)
        }

        return element.require<JetBinaryExpressionWithTypeRHS>() {
            operation.require<JetSimpleNameExpression>("as")
            && (left.requireFindViewByIdCall() || left.require<JetDotQualifiedExpression> {
                selector.requireFindViewByIdCall()
            })
        }
    }

    override fun replaceWith(element: JetExpression, psiFactory: JetPsiFactory): NewElement? {
        fun JetCallExpression.createElement(type: String, receiver: String? = null): NewElement {
            val id = valueArguments[0].getText()
            val receiverWithDot = if (receiver == null) "" else "$receiver."
            val newExpression = psiFactory.createExpression("${receiverWithDot}find<$type>($id)")
            return NewElement(newExpression, "find")
        }

        element.require<JetBinaryExpressionWithTypeRHS>() {
            val type = right?.getText() ?: return null

            left.requireCall(FIND_VIEW_BY_ID) {
                return createElement(type)
            }
            left.require<JetDotQualifiedExpression> {
                selector.requireCall(FIND_VIEW_BY_ID) {
                    return createElement(type, receiver?.getText())
                }
            }
        }
        return null
    }

    private companion object {
        val FIND_VIEW_BY_ID = "findViewById"
    }

}
