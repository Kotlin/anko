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