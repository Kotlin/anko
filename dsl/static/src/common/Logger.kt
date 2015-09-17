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
@file:JvmName("LoggerKt")
package org.jetbrains.anko

import android.util.Log

public interface AnkoLogger {
    public val loggerTag: String
        get() {
            val tag = javaClass.simpleName
            return if (tag.length() <= 23) {
                tag
            } else {
                tag.substring(0, 23)
            }
        }
}

public fun AnkoLogger.verbose(message: Any?, thr: Throwable? = null) {
    log(this, message, thr, Log.VERBOSE,
            { tag, msg -> Log.v(tag, msg) },
            { tag, msg, thr -> Log.v(tag, msg, thr) })
}

public fun AnkoLogger.debug(message: Any?, thr: Throwable? = null) {
    log(this, message, thr, Log.DEBUG,
            { tag, msg -> Log.d(tag, msg) },
            { tag, msg, thr -> Log.d(tag, msg, thr) })
}

public fun AnkoLogger.info(message: Any?, thr: Throwable? = null) {
    log(this, message, thr, Log.INFO,
            { tag, msg -> Log.i(tag, msg) },
            { tag, msg, thr -> Log.i(tag, msg, thr) })
}

public fun AnkoLogger.warn(message: Any?, thr: Throwable? = null) {
    log(this, message, thr, Log.WARN,
            { tag, msg -> Log.w(tag, msg) },
            { tag, msg, thr -> Log.w(tag, msg, thr) })
}

public fun AnkoLogger.error(message: Any?, thr: Throwable? = null) {
    log(this, message, thr, Log.ERROR,
            { tag, msg -> Log.e(tag, msg) },
            { tag, msg, thr -> Log.e(tag, msg, thr) })
}

private inline fun log(
        logger: AnkoLogger,
        message: Any?,
        thr: Throwable?,
        level: Int,
        f: (String, String) -> Unit,
        fThrowable: (String, String, Throwable) -> Unit) {
    val tag = logger.loggerTag
    if (Log.isLoggable(tag, level)) {
        if (thr != null) {
            fThrowable(tag, message?.toString() ?: "null", thr)
        } else {
            f(tag, message?.toString() ?: "null")
        }
    }
}

public fun AnkoLogger.wtf(message: Any?, thr: Throwable? = null) {
    if (thr != null) {
        Log.wtf(loggerTag, message?.toString() ?: "null", thr)
    } else {
        Log.wtf(loggerTag, message?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.verbose(message: () -> Any?) {
    val tag = loggerTag
    if (Log.isLoggable(tag, Log.VERBOSE)) {
        Log.v(tag, message()?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.debug(message: () -> Any?) {
    val tag = loggerTag
    if (Log.isLoggable(tag, Log.DEBUG)) {
        Log.d(tag, message()?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.info(message: () -> Any?) {
    val tag = loggerTag
    if (Log.isLoggable(tag, Log.INFO)) {
        Log.i(tag, message()?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.warn(message: () -> Any?) {
    val tag = loggerTag
    if (Log.isLoggable(tag, Log.WARN)) {
        Log.w(tag, message()?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.error(message: () -> Any?) {
    val tag = loggerTag
    if (Log.isLoggable(tag, Log.ERROR)) {
        Log.e(tag, message()?.toString() ?: "null")
    }
}

public inline fun AnkoLogger.wtf(message: () -> Any?) {
    Log.v(loggerTag, message()?.toString() ?: "null")
}

public fun Throwable.getStackTraceString(): String = Log.getStackTraceString(this)