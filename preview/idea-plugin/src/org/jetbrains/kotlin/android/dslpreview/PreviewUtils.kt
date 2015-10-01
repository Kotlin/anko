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

import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.kotlin.asJava.KotlinLightElement
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.ClassifierDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassDescriptor
import org.jetbrains.kotlin.psi.JetClass
import org.jetbrains.kotlin.psi.JetClassBody
import org.jetbrains.kotlin.psi.JetClassOrObject
import org.jetbrains.kotlin.psi.JetFile
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.lazy.ResolveSession
import org.jetbrains.kotlin.resolve.source.KotlinSourceElement
import java.util.*

internal val DEBUG = true

class AndroidFacetNotFoundException : RuntimeException()

class CantCreateDependencyDirectoryException : RuntimeException()

class UnsupportedClassException : RuntimeException()

fun getQualifiedName(clazz: JetClass): String? {
    val parts = arrayListOf<String>()

    var current: Any? = clazz
    while (current != null) {
        val name = (current as JetClassOrObject).name ?: return null
        parts.add(name)
        current = PsiTreeUtil.getParentOfType<JetClassOrObject>(current as PsiElement, JetClassOrObject::class.java)
    }

    val file = clazz.containingFile
    return if (file is JetFile) {
        val fileQualifiedName = file.packageFqName.asString()
        if (!fileQualifiedName.isEmpty()) {
            parts.add(fileQualifiedName)
        }

        Collections.reverse(parts)
        StringUtil.join(parts, ".")
    } else null
}

internal fun resolveJetClass(prob: PsiElement, cacheService: KotlinCacheService): JetClass? {
    fun isClassSupported(descriptor: ClassifierDescriptor): Boolean {
        if (descriptor !is ClassDescriptor)
            return false

        if (descriptor is LazyJavaClassDescriptor) {
            val name = DescriptorUtils.getFqName(descriptor).asString()
            when (name) {
                // Currently unsupported classes
                "android.support.v7.app.ActionBarActivity" -> return false
                "com.actionbarsherlock.app.SherlockActivity",
                    "com.actionbarsherlock.app.SherlockListActivity",
                    "com.actionbarsherlock.app.SherlockFragmentActivity" -> return false

                "android.app.Activity" -> return true
                "android.app.Fragment", "android.support.v4.app.Fragment" -> return true
                else -> {}
            }
        }

        for (type in descriptor.typeConstructor.supertypes) {
            val superTypeDescriptor = type.constructor.declarationDescriptor ?: return false
            if (isClassSupported(superTypeDescriptor)) return true
        }
        return false
    }

    if (prob is KotlinLightElement<*, *>) {
        return resolveJetClass(prob.getOrigin(), cacheService)
    }

    if (prob is JetClass && (prob.parent !is JetClassBody) &&
            !prob.isEnum() && !prob.isInterface() && !prob.isAnnotation() && !prob.isInner()) {
        try {
            val session = cacheService.getResolutionFacade(listOf(prob)).getFrontendService(ResolveSession::class.java)
            val memberDescriptor = session.getClassDescriptor(prob, NoLookupLocation.FROM_IDE)

            if (memberDescriptor.source !is KotlinSourceElement) return null

            val constructor = memberDescriptor.typeConstructor
            for (type in constructor.supertypes) {
                val descriptor = type.constructor.declarationDescriptor
                if (descriptor != null) {
                    if (isClassSupported(descriptor)) {
                        return prob
                    }
                }
            }
        } catch (e: Exception) {
            return null
        }
    }

    val parent = prob.parent
    return if (parent != null) resolveJetClass(prob.parent, cacheService) else null
}