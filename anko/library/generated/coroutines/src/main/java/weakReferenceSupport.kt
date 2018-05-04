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

package org.jetbrains.anko.coroutines.experimental

import java.lang.ref.WeakReference
import java.util.concurrent.CancellationException
import kotlin.coroutines.experimental.intrinsics.suspendCoroutineOrReturn

class Ref<out T : Any> internal constructor(obj: T) {
    private val weakRef = WeakReference(obj)

    suspend operator fun invoke(): T {
        return suspendCoroutineOrReturn {
            val ref = weakRef.get() ?: throw CancellationException()
            ref
        }
    }
}

fun <T : Any> T.asReference() = Ref(this)