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
package org.jetbrains.anko

import android.app.AlertDialog
import android.app.Fragment
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface

inline fun AnkoContext<*>.alert(
        message: CharSequence,
        title: CharSequence? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = ctx.alert(message, title, init)

inline fun Fragment.alert(
        message: CharSequence,
        title: CharSequence? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = activity.alert(message, title, init)

fun Context.alert(
        message: CharSequence,
        title: CharSequence? = null,
        init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
): AlertBuilder<AlertDialog> {
    return AndroidAlertBuilder(this).apply {
        if (title != null) {
            this.title = title
        }
        this.message = message
        if (init != null) init()
    }
}

inline fun AnkoContext<*>.alert(
        message: Int,
        title: Int? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = ctx.alert(message, title, init)

inline fun Fragment.alert(
        message: Int,
        title: Int? = null,
        noinline init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
) = activity.alert(message, title, init)

fun Context.alert(
        messageResource: Int,
        titleResource: Int? = null,
        init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
): AlertBuilder<DialogInterface> {
    return AndroidAlertBuilder(this).apply {
        if (titleResource != null) {
            this.titleResource = titleResource
        }
        this.messageResource = messageResource
        if (init != null) init()
    }
}


inline fun AnkoContext<*>.alert(noinline init: AlertBuilder<DialogInterface>.() -> Unit) = ctx.alert(init)
inline fun Fragment.alert(noinline init: AlertBuilder<DialogInterface>.() -> Unit) = activity.alert(init)

fun Context.alert(init: AlertBuilder<DialogInterface>.() -> Unit): AlertBuilder<DialogInterface> =
        AndroidAlertBuilder(this).apply { init() }

inline fun AnkoContext<*>.progressDialog(
        message: Int? = null,
        title: Int? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = ctx.progressDialog(message, title, init)

inline fun Fragment.progressDialog(
        message: Int? = null,
        title: Int? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

fun Context.progressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(false, message?.let { getString(it) }, title?.let { getString(it) }, init)


inline fun AnkoContext<*>.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = ctx.indeterminateProgressDialog(message, title, init)

inline fun Fragment.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = activity.indeterminateProgressDialog(message, title, init)

fun Context.indeterminateProgressDialog(
        message: Int? = null,
        title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)


inline fun AnkoContext<*>.progressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = ctx.progressDialog(message, title, init)

inline fun Fragment.progressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

fun Context.progressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(false, message, title, init)


inline fun AnkoContext<*>.indeterminateProgressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = ctx.indeterminateProgressDialog(message, title, init)

inline fun Fragment.indeterminateProgressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        noinline init: (ProgressDialog.() -> Unit)? = null
) = activity.indeterminateProgressDialog(message, title, init)

fun Context.indeterminateProgressDialog(
        message: CharSequence? = null,
        title: CharSequence? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message, title, init)


private fun Context.progressDialog(
        indeterminate: Boolean,
        message: CharSequence? = null,
        title: CharSequence? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = ProgressDialog(this).apply {
    isIndeterminate = indeterminate
    if (!indeterminate) setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    if (message != null) setMessage(message)
    if (title != null) setTitle(title)
    if (init != null) init()
    show()
}
