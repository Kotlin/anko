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

package kotlinx.android.koan

import android.content.Context
import android.app.Fragment
import android.util.Log

public trait KoanLogger {
    protected val loggerTag: String
        get() = javaClass.getName()

    protected fun verbose(message: Any?): Int = Log.v(loggerTag, message?.toString() ?: "null")
    protected fun debug(message: Any?): Int = Log.d(loggerTag, message?.toString() ?: "null")
    protected fun info(message: Any?): Int = Log.i(loggerTag, message?.toString() ?: "null")
    protected fun warn(message: Any?): Int = Log.w(loggerTag, message?.toString() ?: "null")
    protected fun error(message: Any?): Int = Log.e(loggerTag, message?.toString() ?: "null")
    protected fun wtf(message: Any?): Int = Log.wtf(loggerTag, message?.toString() ?: "null")
}

public fun Throwable.getStackTraceString(): String = Log.getStackTraceString(this)