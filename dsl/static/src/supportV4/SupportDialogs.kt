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

package org.jetbrains.anko

import android.app.ProgressDialog
import android.support.v4.app.Fragment

public fun Fragment.toast(textResource: Int): Unit = activity.toast(textResource)

public fun Fragment.toast(text: CharSequence): Unit = activity.toast(text)

public fun Fragment.longToast(textResource: Int): Unit = activity.longToast(textResource)

public fun Fragment.longToast(text: CharSequence): Unit = activity.longToast(text)

public fun Fragment.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        onClick: (Int) -> Unit
): Unit = activity.selector(title, items, onClick)

public fun Fragment.alert(
        message: String,
        title: String? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null): AlertDialogBuilder =
        activity.alert(message, title, init)

public fun Fragment.alert(
        message: Int,
        title: Int? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null): AlertDialogBuilder =
        activity.alert(message, title, init)

public fun Fragment.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder =
        activity.alert(init)

public fun Fragment.progressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(false, message, title, init)
}

public fun Fragment.indeterminateProgressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(true, message, title, init)
}

public fun Fragment.progressDialog(message: Int? = null, title: Int? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(false, message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}

public fun Fragment.indeterminateProgressDialog(message: Int? = null, title: Int? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(true, message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}