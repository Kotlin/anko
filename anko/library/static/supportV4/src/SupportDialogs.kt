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

@file:Suppress("NOTHING_TO_INLINE", "unused")
package org.jetbrains.anko.support.v4

import android.app.ProgressDialog
import android.content.DialogInterface
import android.support.v4.app.Fragment
import org.jetbrains.anko.*

inline fun Fragment.toast(textResource: Int) = activity.toast(textResource)

inline fun Fragment.toast(text: CharSequence) = activity.toast(text)

inline fun Fragment.longToast(textResource: Int) = activity.longToast(textResource)

inline fun Fragment.longToast(text: CharSequence) = activity.longToast(text)

inline fun Fragment.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        noinline onClick: (DialogInterface, Int) -> Unit
): Unit = activity.selector(title, items, onClick)

inline fun Fragment.alert(
        message: String,
        title: String? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = activity.alert(message, title, init)

inline fun Fragment.alert(
        message: Int,
        title: Int? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = activity.alert(message, title, init)

inline fun Fragment.alert(noinline init: AlertBuilder<DialogInterface>.() -> Unit) = activity.alert(init)

inline fun Fragment.progressDialog(
        message: String? = null,
        title: String? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

inline fun Fragment.indeterminateProgressDialog(message: String? = null, title: String? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.indeterminateProgressDialog(message, title, init)
}

inline fun Fragment.progressDialog(message: Int? = null, title: Int? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}

inline fun Fragment.indeterminateProgressDialog(message: Int? = null, title: Int? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.indeterminateProgressDialog(message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}