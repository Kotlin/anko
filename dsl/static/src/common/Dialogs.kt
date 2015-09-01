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

import android.app.Fragment
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import org.jetbrains.anko.internals.noBinding

public fun Fragment.toast(textResource: Int): Unit = activity.toast(textResource)

public fun Context.toast(textResource: Int) {
    Toast.makeText(this, textResource, Toast.LENGTH_SHORT).show()
}

public fun Fragment.toast(text: CharSequence): Unit = activity.toast(text)

public fun Context.toast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

public fun Fragment.longToast(textResource: Int): Unit = activity.longToast(textResource)

public fun Context.longToast(textResource: Int) {
    Toast.makeText(this, textResource, Toast.LENGTH_LONG).show()
}

public fun Fragment.longToast(text: CharSequence): Unit = activity.longToast(text)

public fun Context.longToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

public fun Fragment.alert(
        message: String,
        title: String? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null
): AlertDialogBuilder = activity.alert(message, title, init)

public fun Context.alert(
        message: String,
        title: String? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null
): AlertDialogBuilder {
    return AlertDialogBuilder(this).apply {
        if (title != null) title(title)
        message(message)
        if (init != null) init()
    }
}

public fun Fragment.alert(
        message: Int,
        title: Int? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null
): AlertDialogBuilder = activity.alert(message, title, init)

public fun Context.alert(
        message: Int,
        title: Int? = null,
        init: (AlertDialogBuilder.() -> Unit)? = null
): AlertDialogBuilder {
    return AlertDialogBuilder(this).apply {
        if (title != null) title(title)
        message(message)
        if (init != null) init()
    }
}

public fun Fragment.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder = activity.alert(init)

public fun Context.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder {
    return AlertDialogBuilder(this).apply { init() }
}

public fun Fragment.progressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return activity.progressDialog(false, message?.let { getString(it) }, title?.let { getString(it) }, init)
}

public fun Context.progressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return progressDialog(false, message?.let { getString(it) }, title?.let { getString(it) }, init)
}

public fun Fragment.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return activity.progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)
}

public fun Context.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)
}

public fun Fragment.progressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return activity.progressDialog(false, message, title, init)
}

public fun Context.progressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return progressDialog(false, message, title, init)
}

public fun Fragment.indeterminateProgressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return activity.progressDialog(true, message, title, init)
}

public fun Context.indeterminateProgressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    return progressDialog(true, message, title, init)
}

private noBinding fun Context.progressDialog(
        indeterminate: Boolean,
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
): ProgressDialog {
    val dialog = ProgressDialog(this)
    dialog.isIndeterminate = indeterminate
    if (!indeterminate) dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    if (message != null) dialog.setMessage(message)
    if (title != null) dialog.setTitle(title)
    if (init != null) dialog.init()
    dialog.show()
    return dialog
}

public fun Fragment.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        onClick: (Int) -> Unit
): Unit = activity.selector(title, items, onClick)


public fun Context.selector(
    title: CharSequence? = null,
    items: List<CharSequence>,
    onClick: (Int) -> Unit
) {
    with(AlertDialogBuilder(this)) {
        if (title != null) title(title)
        items(items, onClick)
        show()
    }
}