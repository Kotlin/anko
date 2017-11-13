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

package org.jetbrains.android.anko.render

import org.jetbrains.android.anko.utils.fqName
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

interface ViewConstructorUtils {
    companion object {
        private val CONSTRUCTOR1 = arrayOf(Type.getObjectType("android/content/Context"))
        private val CONSTRUCTOR2 = arrayOf(Type.getObjectType("android/content/Context"), Type.getObjectType("android/util/AttributeSet"))
        val AVAILABLE_VIEW_CONSTRUCTORS: List<Array<Type>> = listOf(CONSTRUCTOR1, CONSTRUCTOR2)
    }

    fun renderConstructorArgs(
            view: ClassNode,
            constructors: List<MethodNode?>,
            ctxName: String,
            argumentNames: Boolean = false
    ): String {
        if (constructors.size != AVAILABLE_VIEW_CONSTRUCTORS.size) throw IllegalArgumentException("Invalid constructors list")

        return if (argumentNames) {
            when {
                constructors[0] != null -> "$ctxName: Context"
                constructors[1] != null -> "$ctxName: Context, attrs: AttributeSet?"
                else -> throw IllegalArgumentException("No available constructors for ${view.fqName}.")
            }
        } else {
            when {
                constructors[0] != null -> ctxName
                constructors[1] != null -> "$ctxName, null"
                else -> throw IllegalArgumentException("No available constructors for ${view.fqName}.")
            }
        }
    }

}