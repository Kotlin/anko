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
@file:JvmMultifileClass
@file:JvmName("AsyncKt")
package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Handler
import android.os.Looper
import org.jetbrains.anko.internals.NoBinding
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

@Deprecated("Use onUiThread() instead", ReplaceWith("onUiThread(f)"))
@NoBinding
public fun Context.uiThread(f: Context.() -> Unit) {
    if (ContextHelper.mainThread == Thread.currentThread()) f() else ContextHelper.handler.post { f() }
}

@Deprecated("Use onUiThread() instead", ReplaceWith("onUiThread(f)"))
@NoBinding
public inline fun Fragment.uiThread(crossinline f: () -> Unit) {
    activity?.onUiThread { f() }
}

// Fragment.uiThread() has a different argument list (because of inline)
@NoBinding
public fun Context.onUiThread(f: Context.() -> Unit) {
    if (ContextHelper.mainThread == Thread.currentThread()) f() else ContextHelper.handler.post { f() }
}

@NoBinding
public inline fun Fragment.onUiThread(crossinline f: () -> Unit) {
    activity?.onUiThread { f() }
}

public class AnkoAsyncContext<T>(val weakRef: WeakReference<T>)

public fun <T> AnkoAsyncContext<T>.uiThread(f: (T) -> Unit) {
    val ref = weakRef.get() ?: return
    if (ContextHelper.mainThread == Thread.currentThread()) {
        f(ref)
    } else {
        ContextHelper.handler.post { f(ref) }
    }
}

public fun <T: Activity> AnkoAsyncContext<T>.activityUiThread(f: (T) -> Unit) {
    val activity = weakRef.get() ?: return
    if (activity.isFinishing) return
    activity.runOnUiThread { f(activity) }
}

public fun <T: Fragment> AnkoAsyncContext<T>.fragmentUiThread(f: (T) -> Unit) {
    val fragment = weakRef.get() ?: return
    if (fragment.isDetached) return
    val activity = fragment.activity ?: return
    activity.runOnUiThread { f(fragment) }
}

public fun <T> T.async(task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

public fun <T> T.async(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<Unit> { context.task() }
}

public fun <T, R> T.asyncResult(task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

public fun <T, R> T.asyncResult(executorService: ExecutorService, task: AnkoAsyncContext<T>.() -> R): Future<R> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<R> { context.task() }
}

object BackgroundExecutor {

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