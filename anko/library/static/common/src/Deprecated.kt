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

@file:Suppress("unused")
package org.jetbrains.anko.custom

import android.app.Fragment
import android.content.Context
import android.view.View
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.BackgroundExecutor
import org.jetbrains.anko.applyRecursively
import org.jetbrains.anko.collections.forEachReversedByIndex
import org.jetbrains.anko.runOnUiThread
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

@Deprecated("Use forEachReversedByIndex(f) instead.",
        ReplaceWith("forEachReversedByIndex(f)", "org.jetbrains.anko.collections.forEachReversedByIndex"))
inline fun <T> Array<T>.forEachReversed(f: (T) -> Unit) = forEachReversedByIndex(f)

@Deprecated("Use forEachReversedByIndex(f) instead.",
        ReplaceWith("forEachReversedByIndex(f)", "org.jetbrains.anko.collections.forEachReversedByIndex"))
inline fun <T> List<T>.forEachReversed(f: (T) -> Unit) = forEachReversedByIndex(f)

@Deprecated("Use runOnUiThread(f) instead.", ReplaceWith("runOnUiThread(f)"))
inline fun Fragment.onUiThread(crossinline f: () -> Unit) = runOnUiThread(f)

@Deprecated("Use runOnUiThread(f) instead.", ReplaceWith("runOnUiThread(f)"))
fun Context.onUiThread(f: Context.() -> Unit) = runOnUiThread(f)

@Deprecated("Use doAsync(task) instead.", ReplaceWith("doAsync(task)"))
fun <T> T.async(task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

@Deprecated("Use doAsync(executorService, task) instead.", ReplaceWith("doAsync(executorService, task)"))
fun <T> T.async(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<Unit> { context.task() }
}

@Deprecated("Use doAsyncResult(task) instead.", ReplaceWith("doAsyncResult(task)"))
fun <T, R> T.asyncResult(task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

@Deprecated("Use doAsyncResult(executorService, task) instead.", ReplaceWith("doAsyncResult(executorService, task)"))
fun <T, R> T.asyncResult(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<R> { context.task() }
}


@Deprecated("Use applyRecursively(block) instead.", ReplaceWith("applyRecursively(style)"))
fun <T : View> T.style(style: (View) -> Unit): T = applyRecursively(style)