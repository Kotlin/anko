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

import com.android.tools.idea.rendering.LayoutlibCallbackImpl
import com.android.tools.idea.rendering.RenderTask
import org.jetbrains.android.uipreview.AndroidLayoutPreviewToolWindowManager

fun DslPreviewToolWindowManager.getSuperBooleanField(name: String): Boolean {
    val field = AndroidLayoutPreviewToolWindowManager::class.java.getDeclaredField(name)
    field.isAccessible = true
    return field.getBoolean(this)
}

fun <T> DslPreviewToolWindowManager.getSuperField(name: String): T {
    val field = AndroidLayoutPreviewToolWindowManager::class.java.getDeclaredField(name)
    field.isAccessible = true
    @Suppress("UNCHECKED_CAST")
    return field.get(this) as T
}

fun DslPreviewToolWindowManager.setSuperField(name: String, value: Any?) {
    val field = AndroidLayoutPreviewToolWindowManager::class.java.getDeclaredField(name)
    field.isAccessible = true
    return field.set(this, value)
}

fun <T> DslPreviewToolWindowManager.callSuperMethod(name: String): T {
    val method = AndroidLayoutPreviewToolWindowManager::class.java.getDeclaredMethod(name)
    method.isAccessible = true
    @Suppress("UNCHECKED_CAST")
    return method(this) as T
}

fun <T> RenderTask.getField(name: String): T {
    val field = RenderTask::class.java.getDeclaredField(name)
    field.isAccessible = true
    @Suppress("UNCHECKED_CAST")
    return field.get(this) as T
}

fun <T> LayoutlibCallbackImpl.getField(name: String): T {
    val field = LayoutlibCallbackImpl::class.java.getDeclaredField(name)
    field.isAccessible = true
    @Suppress("UNCHECKED_CAST")
    return field.get(this) as T
}


fun LayoutlibCallbackImpl.setField(name: String, value: Any?) {
    val field = LayoutlibCallbackImpl::class.java.getDeclaredField(name)
    field.isAccessible = true
    return field.set(this, value)
}
