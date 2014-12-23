/*
 * Copyright 2014 JetBrains s.r.o.
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

package kotlinx.android.koan

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import android.content.Context
import android.app.Fragment
import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

public fun Fragment.uiThread(f: () -> Unit) {
    getActivity().uiThread(f)
}

public fun Context.uiThread(f: () -> Unit) {
    if (ContextHelper.uiThread == Thread.currentThread()) {
        f()
    } else {
        ContextHelper.handler.post(Runnable(f))
    }
}

public fun Fragment.async(task: () -> Unit): Future<Unit> {
    return getActivity().async(task)
}

public fun Fragment.async(executorService: ExecutorService, task: () -> Unit): Future<Unit> {
    return executorService.submit<Unit> { task() }
}

public fun Context.async(task: () -> Unit): Future<Unit> {
    return BackgroundExecutor.execute(task)
}

public fun Context.async(executorService: ExecutorService, task: () -> Unit): Future<Unit> {
    return executorService.submit<Unit> { task() }
}

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> {
    return getActivity().asyncResult(task)
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
    val uiThread = Looper.getMainLooper().getThread()
}