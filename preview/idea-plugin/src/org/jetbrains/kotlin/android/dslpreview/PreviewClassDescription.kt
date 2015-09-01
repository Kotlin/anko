/*
 * Copyright 2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.android.dslpreview

import com.intellij.psi.PsiClass
import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.kotlin.psi.JetClass

public abstract class PreviewClassDescription(val androidFacet: AndroidFacet) {
    abstract val name: String
    abstract val qualifiedName: String
    abstract val packageName: String
}

public class PreviewPsiClassDescription(val psiClass: PsiClass, androidFacet: AndroidFacet): PreviewClassDescription(androidFacet) {
    override val qualifiedName: String = psiClass.qualifiedName ?: ""
    override val packageName: String
    override val name: String

    init {
        val finalDotIndex = qualifiedName.lastIndexOf('.')
        packageName = if (finalDotIndex <= 0) "" else qualifiedName.substring(0, finalDotIndex)
        name = if (finalDotIndex <= 0) qualifiedName else qualifiedName.substring(finalDotIndex + 1)
    }

    override fun toString(): String {
        return if (packageName.isNotEmpty())
                "<html>$packageName.<b>$name</b></html>"
            else
                "<html><b>$name</b></html>"
    }
}

public class PreviewJetClassDescription(val jetClass: JetClass, androidFacet: AndroidFacet): PreviewClassDescription(androidFacet) {
    override val packageName: String = jetClass.getContainingJetFile().packageFqName.asString()
    override val name: String = jetClass.name!!
    override val qualifiedName: String = "$packageName.$name"

    override fun toString(): String {
        return if (packageName.isNotEmpty())
            "<html>$packageName.<b>$name</b></html>"
        else
            "<html><b>$name</b></html>"
    }
}