/**
 * Created by yan on 15/03/2017.
 */
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

import kotlinx.coroutines.*

@PublishedApi
@Deprecated(message = "Use the default pool")
internal var POOL = newFixedThreadPoolContext(2 * Runtime.getRuntime().availableProcessors(), "bg")

@Deprecated(message = "Use the default pool", replaceWith = ReplaceWith("async(block)", "kotlinx.coroutines.async"))
inline fun <T> bg(crossinline block: () -> T): Deferred<T> = GlobalScope.async(POOL, CoroutineStart.DEFAULT) {
    block()
}
