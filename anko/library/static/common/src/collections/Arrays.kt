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

import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import java.util.*

/**
 * Iterate the receiver [Array] using an index.
 *
 * @f an action to invoke on each array element.
 */
inline fun <T> Array<T>.forEachByIndex(f: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(get(i))
    }
}

/**
 * Iterate the receiver [Array] using an index.
 *
 * @f an action to invoke on each array element (index, element).
 */
inline fun <T> Array<T>.forEachWithIndex(f: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(i, get(i))
    }
}

/**
 * Iterate the receiver [Array] backwards using an index.
 *
 * @f an action to invoke on each array element.
 */
inline fun <T> Array<T>.forEachReversedByIndex(f: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(get(i))
        i--
    }
}

/**
 * Iterate the receiver [Array] backwards using an index.
 *
 * @f an action to invoke on each array element (index, element).
 */
inline fun <T> Array<T>.forEachReversedWithIndex(f: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(i, get(i))
        i--
    }
}

/**
 * Create a [Sequence] instance that wraps the original [SparseArray] returning its elements when being iterated.
 */
inline fun <T> SparseArray<T>.asSequence(): Sequence<T> = SparseArraySequence(this)

/**
 * Create a [Sequence] instance that wraps the original [SparseBooleanArray] returning its elements when being iterated.
 */
inline fun <T> SparseBooleanArray.asSequence(): Sequence<Boolean> = SparseBooleanArraySequence(this)

/**
 * Create a [Sequence] instance that wraps the original [SparseIntArray] returning its elements when being iterated.
 */
inline fun <T> SparseIntArray.asSequence(): Sequence<Int> = SparseIntArraySequence(this)

@PublishedApi
internal class SparseArraySequence<T>(private val a: SparseArray<T>) : Sequence<T> {
    override fun iterator(): Iterator<T> = SparseArrayIterator()

    private inner class SparseArrayIterator : Iterator<T> {
        private var index = 0
        private val size = a.size()

        override fun hasNext() = size > index

        override fun next(): T {
            if (a.size() != size) throw ConcurrentModificationException()
            return a.valueAt(index++)
        }
    }
}

@PublishedApi
internal class SparseBooleanArraySequence(private val a: SparseBooleanArray) : Sequence<Boolean> {
    override fun iterator(): Iterator<Boolean> = SparseIntArrayIterator()

    private inner class SparseIntArrayIterator : Iterator<Boolean> {
        private var index = 0
        private val size = a.size()

        override fun hasNext() = size > index

        override fun next(): Boolean {
            if (a.size() != size) throw ConcurrentModificationException()
            return a.get(index++)
        }
    }
}

@PublishedApi
internal class SparseIntArraySequence(private val a: SparseIntArray) : Sequence<Int> {
    override fun iterator(): Iterator<Int> = SparseIntArrayIterator()

    private inner class SparseIntArrayIterator : Iterator<Int> {
        private var index = 0
        private val size = a.size()

        override fun hasNext() = size > index

        override fun next(): Int {
            if (a.size() != size) throw ConcurrentModificationException()
            return a.get(index++)
        }
    }
}
