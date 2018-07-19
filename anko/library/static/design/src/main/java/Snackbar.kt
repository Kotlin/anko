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

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.snackbar(Int)' instead.", ReplaceWith("view.snackbar(message)"))
inline fun snackbar(view: View, message: Int) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.longSnackbar(Int)' instead.", ReplaceWith("view.longSnackbar(message)"))
inline fun longSnackbar(view: View, message: Int) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.indefiniteSnackbar(Int)' instead.", ReplaceWith("view.indefiniteSnackbar(message)"))
inline fun indefiniteSnackbar(view: View, message: Int) = Snackbar
        .make(view, message, Snackbar.LENGTH_INDEFINITE)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.snackbar(CharSequence)' instead.", ReplaceWith("view.snackbar(message)"))
inline fun snackbar(view: View, message: CharSequence) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.longSnackbar(CharSequence)' instead.", ReplaceWith("view.longSnackbar(message)"))
inline fun longSnackbar(view: View, message: CharSequence) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.indefiniteSnackbar(CharSequence)' instead.", ReplaceWith("view.indefiniteSnackbar(message)"))
inline fun indefiniteSnackbar(view: View, message: CharSequence) = Snackbar
        .make(view, message, Snackbar.LENGTH_INDEFINITE)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.snackbar(Int, Int, (View) -> Unit)' instead.", ReplaceWith("view.snackbar(message, actionText, action)"))
inline fun snackbar(view: View, message: Int, actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.longSnackbar(Int, Int, (View) -> Unit)' instead.", ReplaceWith("view.longSnackbar(message, actionText, action)"))
inline fun longSnackbar(view: View, message: Int, actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
@Deprecated("Use 'View.indefiniteSnackbar(Int, Int, (View) -> Unit)' instead.", ReplaceWith("view.indefiniteSnackbar(message, actionText, action)"))
inline fun indefiniteSnackbar(view: View, message: Int, actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.snackbar(CharSequence, CharSequence, (View) -> Unit)' instead.", ReplaceWith("view.snackbar(message, actionText, action)"))
inline fun snackbar(view: View, message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_SHORT)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.longSnackbar(CharSequence, CharSequence, (View) -> Unit)' instead.", ReplaceWith("view.longSnackbar(message, actionText, action)"))
inline fun longSnackbar(view: View, message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_LONG)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
@Deprecated("Use 'View.indefiniteSnackbar(CharSequence, CharSequence, (View) -> Unit)' instead.", ReplaceWith("view.indefiniteSnackbar(message, actionText, action)"))
inline fun indefiniteSnackbar(view: View, message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(view, message, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
@JvmName("snackbar2")
inline fun View.snackbar(@StringRes message: Int) = Snackbar
        .make(this, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
@JvmName("longSnackbar2")
inline fun View.longSnackbar(@StringRes message: Int) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
@JvmName("indefiniteSnackbar2")
inline fun View.indefiniteSnackbar(@StringRes message: Int) = Snackbar
        .make(this, message, Snackbar.LENGTH_INDEFINITE)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
@JvmName("snackbar2")
inline fun View.snackbar(message: CharSequence) = Snackbar
        .make(this, message, Snackbar.LENGTH_SHORT)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
@JvmName("longSnackbar2")
inline fun View.longSnackbar(message: CharSequence) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
@JvmName("indefiniteSnackbar2")
inline fun View.indefiniteSnackbar(message: CharSequence) = Snackbar
        .make(this, message, Snackbar.LENGTH_INDEFINITE)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
@JvmName("snackbar2")
inline fun View.snackbar(message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_SHORT)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
@JvmName("longSnackbar2")
inline fun View.longSnackbar(@StringRes message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
@JvmName("indefiniteSnackbar2")
inline fun View.indefiniteSnackbar(@StringRes message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
@JvmName("snackbar2")
inline fun View.snackbar(message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_SHORT)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
@JvmName("longSnackbar2")
inline fun View.longSnackbar(message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .setAction(actionText, action)
        .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
@JvmName("indefiniteSnackbar2")
inline fun View.indefiniteSnackbar(message: CharSequence, actionText: CharSequence, noinline action: (View) -> Unit) = Snackbar
        .make(this, message, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText, action)
        .apply { show() }
