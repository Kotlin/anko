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

package org.jetbrains.anko.support.v4

import android.support.v4.app.Fragment
import org.jetbrains.anko.*

public fun <T: Fragment> AnkoAsyncContext<T>.supportFragmentUiThread(f: (T) -> Unit) {
    val fragment = weakRef.get() ?: return
    if (fragment.isDetached) return
    val activity = fragment.getActivity() ?: return
    activity.runOnUiThread { f(fragment) }
}

@deprecated("Use onUiThread() instead", ReplaceWith("onUiThread(f)"))
public inline fun Fragment.uiThread(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) f: () -> Unit) {
    activity.onUiThread { f() }
}

public inline fun Fragment.onUiThread(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) f: () -> Unit) {
    activity.onUiThread { f() }
}