/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.anko.idea.intentions

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import org.jetbrains.kotlin.analyzer.analyzeInContext
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.caches.resolve.getResolutionFacade
import org.jetbrains.kotlin.idea.core.replaced
import org.jetbrains.kotlin.idea.intentions.JetSelfTargetingIntention
import org.jetbrains.kotlin.idea.intentions.description
import org.jetbrains.kotlin.idea.quickfix.ReplaceWithAnnotationAnalyzer
import org.jetbrains.kotlin.idea.quickfix.moveCaret
import org.jetbrains.kotlin.idea.util.ImportInsertHelper
import org.jetbrains.kotlin.j2k.getContainingMethod
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.FqNameUnsafe
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.DescriptorToSourceUtils
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.FunctionDescriptorUtil
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.descriptorUtil.getSuperClassNotAny
import org.jetbrains.kotlin.resolve.descriptorUtil.getSuperClassOrAny
import org.jetbrains.kotlin.resolve.scopes.*
import org.jetbrains.kotlin.resolve.scopes.receivers.ClassReceiver
import org.jetbrains.kotlin.types.lowerIfFlexible
import org.jetbrains.kotlin.utils.Printer
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import kotlin.properties.Delegates

public class ToastMakeTextShowIntention : AnkoIntention<JetExpression>(javaClass(), "Simplify Toast.makeText().show() with Anko") {

    override fun isApplicableTo(element: JetExpression, caretOffset: Int): Boolean {
        return element.require<JetDotQualifiedExpression> {
            receiver.require<JetDotQualifiedExpression> {
                receiver.require<JetReferenceExpression>("Toast")
                && selector.requireCall("makeText", 3) {
                    isLongToast() != null && isValueParameterTypeOf(0, null, FqNames.CONTEXT_FQNAME)
                }
            }
            && selector.requireCall("show", 0)
        }
    }

    private fun JetCallExpression.isLongToast(): Boolean? {
        return when (getValueArguments()[2].getText()) {
            "Toast.LENGTH_SHORT", "LENGTH_SHORT" -> false
            "Toast.LENGTH_LONG", "LENGTH_LONG" -> true
            else -> null
        }
    }

    override fun replaceWith(element: JetExpression, psiFactory: JetPsiFactory): NewElement? {
        element.require<JetDotQualifiedExpression> {
            receiver.require<JetDotQualifiedExpression> {
                selector.requireCall("makeText") {
                    val args = getValueArguments()
                    val ctxArg = args[0].text
                    val textArg = args[1].text

                    val funName = if (isLongToast()!!) "longToast" else "toast"
                    val receiver = if (ctxArg == "this") "" else ".$ctxArg"

                    val newExpression = psiFactory.createExpression("$receiver$funName($textArg)")
                    return NewElement(newExpression, funName)
                }
            }
        }
        return null
    }

}
