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
import org.jetbrains.anko.AlertBuilder
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.longToast
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

inline fun Fragment.toast(textResource: Int) = requireActivity().toast(textResource)

inline fun Fragment.toast(text: CharSequence) = requireActivity().toast(text)

inline fun Fragment.longToast(textResource: Int) = requireActivity().longToast(textResource)

inline fun Fragment.longToast(text: CharSequence) = requireActivity().longToast(text)

inline fun Fragment.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        noinline onClick: (DialogInterface, Int) -> Unit
): Unit = requireActivity().selector(title, items, onClick)

inline fun Fragment.alert(
        message: String,
        title: String? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = requireActivity().alert(message, title, init)

inline fun Fragment.alert(
        message: Int,
        title: Int? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = requireActivity().alert(message, title, init)

inline fun Fragment.alert(noinline init: AlertBuilder<DialogInterface>.() -> Unit) = requireActivity().alert(init)

@Deprecated(message = "Android progress dialogs are deprecated")
inline fun Fragment.progressDialog(
        message: String? = null,
        title: String? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = requireActivity().progressDialog(message, title, init)

@Deprecated(message = "Android progress dialogs are deprecated")
inline fun Fragment.indeterminateProgressDialog(message: String? = null, title: String? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return requireActivity().indeterminateProgressDialog(message, title, init)
}

@Deprecated(message = "Android progress dialogs are deprecated")
inline fun Fragment.progressDialog(message: Int? = null, title: Int? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return requireActivity().progressDialog(message?.let { requireActivity().getString(it) }, title?.let { requireActivity().getString(it) }, init)
}

@Deprecated(message = "Android progress dialogs are deprecated")
inline fun Fragment.indeterminateProgressDialog(message: Int? = null, title: Int? = null, noinline init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return requireActivity().indeterminateProgressDialog(message?.let { requireActivity().getString(it) }, title?.let { requireActivity().getString(it) }, init)
}
