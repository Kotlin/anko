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

@file:JvmName("DesignSnackbarKt")
@file:Suppress("NOTHING_TO_INLINE")
package org.jetbrains.anko.design

import android.R
import android.app.Activity
import android.app.Fragment
import android.support.design.widget.Snackbar
import android.view.View
import org.jetbrains.anko.find


/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun snackbar(view: View, message: Int) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun longSnackbar(view: View, message: Int) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun snackbar(view: View, message: String) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun longSnackbar(view: View, message: String) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun snackbar(view: View, message: Int, actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply {
            setAction(actionText, action)
            show()
        }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun longSnackbar(view: View, message: Int, actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply {
            setAction(actionText, action)
            show()
        }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun snackbar(view: View, message: String, actionText: String, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply {
            setAction(actionText, action)
            show()
        }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun longSnackbar(view: View, message: String, actionText: String, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply {
            setAction(actionText, action)
            show()
        }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun Activity.snackbar(message: Int) = snackbar(find(R.id.content), message)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun Activity.longSnackbar(message: Int) = longSnackbar(find(R.id.content), message)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun Activity.snackbar(message: String) = snackbar(find(R.id.content), message)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun Activity.longSnackbar(message: String) = longSnackbar(find(R.id.content), message)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun Activity.snackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) =
        snackbar(find(R.id.content), message, actionText, action)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun Activity.longSnackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) =
        longSnackbar(find(R.id.content), message, actionText, action)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun Activity.snackbar(message: String, actionText: String, noinline action: (View) -> Unit) =
        snackbar(find(R.id.content), message, actionText, action)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun Activity.longSnackbar(message: String, actionText: String, noinline action: (View) -> Unit) =
        longSnackbar(find(R.id.content), message, actionText, action)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.snackbar(message: Int) = snackbar(activity.find(R.id.content), message)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.longSnackbar(message: Int) = longSnackbar(activity.find(R.id.content), message)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun Fragment.snackbar(message: String) = snackbar(activity.find(R.id.content), message)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun Fragment.longSnackbar(message: String) = longSnackbar(activity.find(R.id.content), message)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.snackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) =
        snackbar(activity.find(R.id.content), message, actionText, action)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.longSnackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) =
        longSnackbar(activity.find(R.id.content), message, actionText, action)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun Fragment.snackbar(message: String, actionText: String, noinline action: (View) -> Unit) =
        snackbar(activity.find(R.id.content), message, actionText, action)

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun Fragment.longSnackbar(message: String, actionText: String, noinline action: (View) -> Unit) =
        longSnackbar(activity.find(R.id.content), message, actionText, action)

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun View.snackbar(message: Int) {
    val activity = context
    if (activity is Activity) snackbar(activity.find(android.R.id.content), message)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun View.longSnackbar(message: Int) {
    val activity = context
    if (activity is Activity) longSnackbar(activity.find(android.R.id.content), message)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun View.snackbar(message: String) {
    val activity = context
    if (activity is Activity) snackbar(activity.find(android.R.id.content), message)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun View.longSnackbar(message: String) {
    val activity = context
    if (activity is Activity) longSnackbar(activity.find(android.R.id.content), message)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun View.snackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) {
    val activity = context
    if (activity is Activity) snackbar(activity.find(android.R.id.content), message, actionText, action)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun View.longSnackbar(message: Int, actionText: Int, noinline action: (View) -> Unit) {
    val activity = context
    if (activity is Activity) longSnackbar(activity.find(android.R.id.content), message, actionText, action)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun View.snackbar(message: String, actionText: String, noinline action: (View) -> Unit) {
    val activity = context
    if (activity is Activity) snackbar(activity.find(android.R.id.content), message, actionText, action)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun View.longSnackbar(message: String, actionText: String, noinline action: (View) -> Unit) {
    val activity = context
    if (activity is Activity) longSnackbar(activity.find(android.R.id.content), message, actionText, action)
    else throw IllegalStateException("Context is not an Activity, can't show Snackbar")
}
