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

package org.jetbrains.anko.collections

import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import java.util.ConcurrentModificationException

/**
 *  Iterate the receiver [SparseArray]
 *  @action an action to invoke on each key value pair
 *  @throws [ConcurrentModificationException] if modified while iterating
 */
@Deprecated(message = "Use the Android KTX version", replaceWith = ReplaceWith("forEach(action)", "androidx.core.util.forEach"))
inline fun <E> SparseArray<E>.forEach(action: (Int, E) -> Unit) {
    val size = this.size()
    for (i in 0..size - 1) {
        if (size != this.size()) throw ConcurrentModificationException()
        action(this.keyAt(i), this.valueAt(i))
    }
}

/**
 *  Iterate the receiver [SparseBooleanArray]
 *  @action an action to invoke on each key value pair
 *  @throws [ConcurrentModificationException] if modified while iterating
 */
@Deprecated(message = "Use the Android KTX version", replaceWith = ReplaceWith("forEach(action)", "androidx.core.util.forEach"))
inline fun SparseBooleanArray.forEach(action: (Int, Boolean) -> Unit) {
    val size = this.size()
    for (i in 0..size - 1) {
        if (size != this.size()) throw ConcurrentModificationException()
        action(this.keyAt(i), this.valueAt(i))
    }
}

/**
 *  Iterate the receiver [SparseIntArray]
 *  @action an action to invoke on each key value pair
 *  @throws [ConcurrentModificationException] if modified while iterating
 */
@Deprecated(message = "Use the Android KTX version", replaceWith = ReplaceWith("forEach(action)", "androidx.core.util.forEach"))
inline fun SparseIntArray.forEach(action: (Int, Int) -> Unit) {
    val size = this.size()
    for (i in 0..size - 1) {
        if (size != this.size()) throw ConcurrentModificationException()
        action(this.keyAt(i), this.valueAt(i))
    }
}
