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

@file:Suppress("unused", "NOTHING_TO_INLINE")
package org.jetbrains.anko.collections

/**
 * Iterate the receiver [List] using an index.
 *
 * @f an action to invoke on each list element.
 */
inline fun <T> List<T>.forEachByIndex(f: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(get(i))
    }
}

/**
 * Iterate the receiver [List] using an index.
 *
 * @f an action to invoke on each list element (index, element).
 */
inline fun <T> List<T>.forEachWithIndex(f: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(i, get(i))
    }
}

/**
 * Iterate the receiver [List] backwards using an index.
 *
 * @f an action to invoke on each list element.
 */
inline fun <T> List<T>.forEachReversedByIndex(f: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(get(i))
        i--
    }
}

/**
 * Iterate the receiver [List] backwards using an index.
 *
 * @f an action to invoke on each list element (index, element).
 */
inline fun <T> List<T>.forEachReversedWithIndex(f: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(i, get(i))
        i--
    }
}

/**
 * Convert the Android pair to a Kotlin one.
 *
 * @see [toAndroidPair].
 */
inline fun <F, S> android.util.Pair<F, S>.toKotlinPair(): Pair<F, S> = first to second

/**
 * Convert the Kotlin pair to an Android one.
 *
 * @see [toKotlinPair].
 */
inline fun <F, S> Pair<F, S>.toAndroidPair(): android.util.Pair<F, S> = android.util.Pair(first, second)