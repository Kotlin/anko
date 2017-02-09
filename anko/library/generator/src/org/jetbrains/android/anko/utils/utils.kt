package org.jetbrains.android.anko.utils

val <T> List<T>.unique: T?
    get() = if (size == 1) this[0] else null

val <T> Array<T>.unique: T?
    get() = if (size == 1) this[0] else null