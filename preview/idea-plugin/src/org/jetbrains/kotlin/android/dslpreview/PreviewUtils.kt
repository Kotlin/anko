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

import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.PsiElement
import java.util.Collections
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiClass
import com.intellij.psi.impl.light.AbstractLightClass
import org.jetbrains.kotlin.asJava.KotlinLightElement
import org.jetbrains.kotlin.asJava.LightClassUtil
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.ClassifierDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.KotlinCacheService
import org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.source.KotlinSourceElement

private val DEBUG = true

public class AndroidFacetNotFoundException : RuntimeException()

public class CantCreateDependencyDirectoryException : RuntimeException()

public class UnsupportedClassException : RuntimeException()

public fun getQualifiedName(clazz: JetClass): String? {
    val parts = arrayListOf<String>()

    var current: Any? = clazz
    while (current != null) {
        parts.add((current as JetClassOrObject).getName())
        current = PsiTreeUtil.getParentOfType<JetClassOrObject>(current as PsiElement, javaClass<JetClassOrObject>())
    }

    val file = clazz.getContainingFile()
    return if (file is JetFile) {
        val fileQualifiedName = file.getPackageFqName().asString()
        if (!fileQualifiedName.isEmpty()) {
            parts.add(fileQualifiedName)
        }

        Collections.reverse(parts)
        StringUtil.join(parts, ".")
    } else null
}

fun resolveJetClass(prob: PsiElement, cacheService: KotlinCacheService): JetClass? {
    fun isClassSupported(descriptor: ClassifierDescriptor): Boolean {
        if (descriptor !is ClassDescriptor)
            return false

        if (descriptor is LazyJavaClassDescriptor) {
            val name = descriptor.fqName.asString()
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

        for (type in descriptor.getTypeConstructor().getSupertypes()) {
            val superTypeDescriptor = type.getConstructor().getDeclarationDescriptor() ?: return false
            if (isClassSupported(superTypeDescriptor)) return true
        }
        return false
    }

    if (prob is KotlinLightElement<*, *>) {
        return resolveJetClass(prob.getOrigin(), cacheService)
    }

    if (prob is JetClass && (prob.getParent() !is JetClassBody) &&
            !prob.isEnum() && !prob.isInterface() && !prob.isAnnotation() && !prob.isInner()) {
        try {
            val session = cacheService.getLazyResolveSession(prob)
            val memberDescriptor = session.getClassDescriptor(prob)

            if (memberDescriptor.getSource() !is KotlinSourceElement) return null

            val constructor = memberDescriptor.getTypeConstructor()
            for (type in constructor.getSupertypes()) {
                val descriptor = type.getConstructor().getDeclarationDescriptor()
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

    val parent = prob.getParent()
    return if (parent != null) resolveJetClass(prob.getParent(), cacheService) else null
}