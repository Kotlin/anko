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

import org.jetbrains.kotlin.psi.*

class ToastMakeTextShowIntention : AnkoIntention<JetExpression>(
        JetExpression::class.java,
        "Simplify Toast.makeText().show() with Anko"
) {

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
        return when (valueArguments[2].text) {
            "Toast.LENGTH_SHORT", "LENGTH_SHORT" -> false
            "Toast.LENGTH_LONG", "LENGTH_LONG" -> true
            else -> null
        }
    }

    override fun replaceWith(element: JetExpression, psiFactory: JetPsiFactory): NewElement? {
        element.require<JetDotQualifiedExpression> {
            receiver.require<JetDotQualifiedExpression> {
                selector.requireCall("makeText") {
                    val args = valueArguments
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
