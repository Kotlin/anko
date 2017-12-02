/*
 * Copyright 2016 JetBrains s.r.o.
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

package org.jetbrains.android.anko.generator

import org.jetbrains.android.anko.annotations.ExternalAnnotation
import org.jetbrains.android.anko.isPublic
import org.jetbrains.android.anko.parameterRawTypes
import org.jetbrains.android.anko.returnType
import org.jetbrains.android.anko.utils.fqName
import org.jetbrains.android.anko.utils.getConstructors
import org.jetbrains.android.anko.utils.unique
import org.objectweb.asm.tree.ClassNode

//return a pair<viewGroup, layoutParams> or null if the viewGroup doesn't contain custom LayoutParams
fun GenerationState.extractLayoutParams(viewGroup: ClassNode): LayoutElement? {
    fun findActualLayoutParamsClass(viewGroup: ClassNode): ClassNode? {
        fun findForParent() = findActualLayoutParamsClass(classTree.findNode(viewGroup)!!.parent!!.data)

        val generateMethod = viewGroup.methods.firstOrNull { method ->
            method.name == "generateLayoutParams"
                    && method.parameterRawTypes.unique?.internalName == "android/util/AttributeSet"
        } ?: return findForParent()

        val returnTypeClass = classTree.findNode(generateMethod.returnType.internalName)!!.data
        if (!returnTypeClass.fqName.startsWith(viewGroup.fqName)) return findForParent()
        return if (returnTypeClass.isLayoutParams) returnTypeClass else findForParent()
    }

    val lpInnerClassName = viewGroup.innerClasses?.firstOrNull { it.name.contains("LayoutParams") }
    val lpInnerClass = lpInnerClassName?.let { classTree.findNode(it.name)!!.data }

    val externalAnnotations = annotationManager.findExternalAnnotations(viewGroup.fqName)
    val hasGenerateLayoutAnnotation = ExternalAnnotation.GenerateLayout in externalAnnotations
    val hasGenerateViewAnnotation = ExternalAnnotation.GenerateView in externalAnnotations
    if (hasGenerateViewAnnotation || (lpInnerClass == null && !hasGenerateLayoutAnnotation)) return null

    val layoutParams = lpInnerClass?.takeIf { it.name.startsWith(viewGroup.name) }
            ?: findActualLayoutParamsClass(viewGroup)?.takeIf { it.name != "android/view/ViewGroup\$LayoutParams" }

    return layoutParams?.let { classNode ->
        LayoutElement(viewGroup, classNode, classNode.getConstructors().filter { it.isPublic })
    }
}