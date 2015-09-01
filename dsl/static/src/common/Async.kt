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

import android.app.Fragment
import android.content.Context
import android.os.Handler
import android.os.Looper
import org.jetbrains.anko.internals.noBinding
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

public class AnkoAsyncContext(val ctxReference: WeakReference<Context>)

public fun AnkoAsyncContext.uiThread(f: Context.() -> Unit) {
    ctxReference.get()?.uiThread(f)
}

// Fragment.uiThread() has a different argument list (because of inline)
public noBinding fun Context.uiThread(f: Context.() -> Unit) {
    if (ContextHelper.uiThread == Thread.currentThread()) f() else ContextHelper.handler.post { f() }
}

public inline noBinding fun Fragment.uiThread(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) f: () -> Unit) {
    activity?.uiThread { f() }
}

public fun Fragment.async(task: AnkoAsyncContext.() -> Unit): Future<Unit> {
    return activity.async(task)
}

public fun Fragment.async(executorService: ExecutorService, task: AnkoAsyncContext.() -> Unit): Future<Unit> {
    return activity.async(executorService, task)
}

public fun Context.async(task: AnkoAsyncContext.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return BackgroundExecutor.submit { context.task() }
}

public fun Context.async(executorService: ExecutorService, task: AnkoAsyncContext.() -> Unit): Future<Unit> {
    val context = AnkoAsyncContext(WeakReference(this))
    return executorService.submit<Unit> { context.task() }
}

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> {
    return activity.asyncResult(task)
}

public fun <T> Fragment.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> {
    return executorService.submit(task)
}

public fun <T> Context.asyncResult(task: () -> T): Future<T> {
    return BackgroundExecutor.submit(task)
}

public fun <T> Context.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> {
    return executorService.submit(task)
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
    val uiThread = Looper.getMainLooper().thread
}