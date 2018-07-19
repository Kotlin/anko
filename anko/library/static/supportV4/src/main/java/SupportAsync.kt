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

@file:Suppress("unused")
package org.jetbrains.anko.support.v4

import android.support.v4.app.Fragment
import org.jetbrains.anko.AnkoAsyncContext

fun <T: Fragment> AnkoAsyncContext<T>.supportFragmentUiThread(f: (T) -> Unit): Boolean {
    val fragment = weakRef.get() ?: return true
    if (fragment.isDetached) return true
    val activity = fragment.activity ?: return true
    activity.runOnUiThread { f(fragment) }
    return true
}

@Deprecated("Use onUiThread() instead", ReplaceWith("onUiThread(f)"))
inline fun Fragment.uiThread(crossinline f: () -> Unit) {
    requireActivity().runOnUiThread { f() }
}

@Deprecated(message = "Use runOnUiThread() instead", replaceWith = ReplaceWith("runOnUiThread(f)"))
inline fun Fragment.onUiThread(crossinline f: () -> Unit) {
    requireActivity().runOnUiThread { f() }
}

inline fun Fragment.runOnUiThread(crossinline f: () -> Unit) {
    requireActivity().runOnUiThread { f() }
}
