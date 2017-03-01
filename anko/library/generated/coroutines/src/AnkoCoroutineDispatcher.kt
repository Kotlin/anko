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

package org.jetbrains.anko.async

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.experimental.*
import java.util.concurrent.Executors
import kotlin.coroutines.experimental.*

internal object AnkoCoroutineDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        if (CoroutineAndroidContextHelper.mainThread == Thread.currentThread()) {
            context[AsyncCaller]?.withHardReference(
                    onExisting = { block.run() },
                    onDisposed = { context[Job]!!.cancel(CallerDisposedException()) })
        } else {
            CoroutineAndroidContextHelper.handler.post {
                context[AsyncCaller]?.withHardReference(
                        onExisting = { block.run() },
                        onDisposed = { context[Job]!!.cancel(CallerDisposedException()) })
            }
        }
    }

    override fun toString() = "AnkoCoroutineDispatcher"
}

internal object CoroutineAndroidContextHelper {
    val handler = Handler(Looper.getMainLooper())
    val mainThread: Thread = Looper.getMainLooper().thread
}

internal val DEFAULT_EXECUTOR = Executors.newScheduledThreadPool(
        2 * Runtime.getRuntime().availableProcessors())