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

@file:JvmMultifileClass
@file:JvmName("ArraysKt")
package org.jetbrains.anko.collections

import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import java.util.*

inline fun <T> Array<T>.forEachByIndex(f: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(get(i))
    }
}

inline fun <T> Array<T>.forEachWithIndex(f: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        f(i, get(i))
    }
}

inline fun <T> Array<T>.forEachReversed(f: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(get(i))
        i--
    }
}

inline fun <T> Array<T>.forEachReversedWithIndex(f: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        f(i, get(i))
        i--
    }
}

fun <T> SparseArray<T>.asSequence(): Sequence<T> = SparseArraySequence(this)

fun <T> SparseBooleanArray.asSequence(): Sequence<Boolean> = SparseBooleanArraySequence(this)

fun <T> SparseIntArray.asSequence(): Sequence<Int> = SparseIntArraySequence(this)

private class SparseArraySequence<T>(private val a: SparseArray<T>) : Sequence<T> {
    override fun iterator() = SparseArrayIterator()

    private inner class SparseArrayIterator : Iterator<T> {
        private var index = 0
        private val size = a.size()

        override fun hasNext() = size > index

        override fun next(): T {
            if (a.size() != size) throw ConcurrentModificationException()
            return a.get(index++)
        }
    }
}

private class SparseBooleanArraySequence(private val a: SparseBooleanArray) : Sequence<Boolean> {
    override fun iterator() = SparseIntArrayIterator()

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

private class SparseIntArraySequence(private val a: SparseIntArray) : Sequence<Int> {
    override fun iterator() = SparseIntArrayIterator()

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