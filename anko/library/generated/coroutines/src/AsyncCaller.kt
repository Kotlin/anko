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

import java.lang.ref.WeakReference
import kotlin.coroutines.experimental.*

internal class AsyncCaller<C : Any>(ctx: C) : AbstractCoroutineContextElement(AsyncCaller) {
    companion object Key : CoroutineContext.Key<AsyncCaller<*>>

    internal val weakRef = WeakReference(ctx)
    private var hardRef: C? = null

    internal val ref: C
        get() = hardRef!!

    // This function is not thread-safe, must be called from the UI thread.
    internal inline fun withHardReference(onExisting: () -> Unit, onDisposed: () -> Unit) {
        val hardRef = this[AsyncCaller]?.weakRef?.get() ?: run {
            onDisposed()
            return
        }

        @Suppress("UNCHECKED_CAST")
        this.hardRef = hardRef as C

        onExisting()

        this.hardRef = null
    }
}