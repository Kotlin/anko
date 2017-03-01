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

import kotlinx.coroutines.experimental.*
import java.util.concurrent.Executor
import kotlin.coroutines.experimental.*

fun <C : Any> C.async(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend AnkoCoroutineScope<C>.() -> Unit
): Job {
    return async(DEFAULT_EXECUTOR, context, block)
}

@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
fun <C : Any> C.async(
        executor: Executor,
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend AnkoCoroutineScope<C>.() -> Unit
): Job {
    val newContext = newCoroutineContext(context) +
            AsyncCaller(this) + AsyncExecutor(executor) + AnkoCoroutineDispatcher

    val coroutine = AnkoCoroutine<C>(newContext)
    coroutine.initParentJob(context[Job])
    block.startCoroutine(coroutine, coroutine)

    return coroutine
}

interface AnkoCoroutineScope<out C : Any> : CoroutineScope {
    val caller: C
}

suspend fun <R> AnkoCoroutineScope<*>.bg(f: () -> R): R {
    val executor = context[AsyncExecutor]?.executor ?: DEFAULT_EXECUTOR
    return suspendCoroutine { c ->
        executor.execute {
            c.resume(f())
        }
    }
}

class CallerDisposedException : RuntimeException()