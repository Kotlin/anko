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

package org.jetbrains.anko.collections

inline fun <T> List<T>.forEachByIndex(f: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(get(i))
    }
}

inline fun <T> List<T>.forEachWithIndex(f: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(i, get(i))
    }
}

inline fun <T> List<T>.forEachReversed(f: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(get(i))
        i--
    }
}

inline fun <T> List<T>.forEachReversedWithIndex(f: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(i, get(i))
        i--
    }
}

fun <F, S> android.util.Pair<F, S>.toKotlinPair(): Pair<F, S> {
    return first to second
}

fun <F, S> Pair<F, S>.toAndroidPair(): android.util.Pair<F, S> {
    return android.util.Pair(first, second)
}