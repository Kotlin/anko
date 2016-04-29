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
package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Handler
import android.os.Looper
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun Context.runOnUiThread(f: Context.() -> Unit) {
    if (ContextHelper.mainThread == Thread.currentThread()) f() else ContextHelper.handler.post { f() }
}

inline fun Fragment.runOnUiThread(crossinline f: () -> Unit) {
    activity?.runOnUiThread { f() }
}

class AnkoAsyncContext<T>(val weakRef: WeakReference<T>)

fun <T> AnkoAsyncContext<T>.uiThread(f: (T) -> Unit) {
    val ref = weakRef.get() ?: return
    if (ContextHelper.mainThread == Thread.currentThread()) {
        f(ref)
    } else {
        ContextHelper.handler.post { f(ref) }
    }
}

fun <T: Activity> AnkoAsyncContext<T>.activityUiThread(f: (T) -> Unit) {
    val activity = weakRef.get() ?: return
    if (activity.isFinishing) return
    activity.runOnUiThread { f(activity) }
}

fun <T: Activity> AnkoAsyncContext<T>.activityUiThreadWithContext(f: Context.(T) -> Unit) {
    val activity = weakRef.get() ?: return
    if (activity.isFinishing) return
    activity.runOnUiThread { activity.f(activity) }
}

@JvmName("activityContextUiThread")
fun <T: Activity> AnkoAsyncContext<AnkoContext<T>>.activityUiThread(f: (T) -> Unit) {
    val activity = weakRef.get()?.owner ?: return
    if (activity.isFinishing) return
    activity.runOnUiThread { f(activity) }
}

@JvmName("activityContextUiThreadWithContext")
fun <T: Activity> AnkoAsyncContext<AnkoContext<T>>.activityUiThreadWithContext(f: Context.(T) -> Unit) {
    val activity = weakRef.get()?.owner ?: return
    if (activity.isFinishing) return
    activity.runOnUiThread { activity.f(activity) }
}

fun <T: Fragment> AnkoAsyncContext<T>.fragmentUiThread(f: (T) -> Unit) {
    val fragment = weakRef.get() ?: return
    if (fragment.isDetached) return
    val activity = fragment.activity ?: return
    activity.runOnUiThread { f(fragment) }
}

fun <T: Fragment> AnkoAsyncContext<T>.fragmentUiThreadWithContext(f: Context.(T) -> Unit) {
    val fragment = weakRef.get() ?: return
    if (fragment.isDetached) return
    val activity = fragment.activity ?: return
    activity.runOnUiThread { activity.f(fragment) }
}

fun <T> T.doAsync(task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

fun <T> T.doAsync(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<Unit> { context.task() }
}

fun <T, R> T.doAsyncResult(task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

fun <T, R> T.doAsyncResult(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<R> { context.task() }
}

internal object BackgroundExecutor {
    var executor: ExecutorService =
        Executors.newScheduledThreadPool(2 * Runtime.getRuntime().availableProcessors())

    fun execute(task: () -> Unit): Future<Unit> {
        return executor.submit<Unit> { task() }
    }

    fun <T> submit(task: () -> T): Future<T> {
        return executor.submit(task)
    }

}

private object ContextHelper {
    val handler = Handler(Looper.getMainLooper())
    val mainThread = Looper.getMainLooper().thread
}