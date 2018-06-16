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
inline fun View.snackbar(@StringRes message: Int) = Snackbar
    .make(this, message, Snackbar.LENGTH_SHORT)
    .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun View.longSnackbar(@StringRes message: Int) = Snackbar
    .make(this, message, Snackbar.LENGTH_LONG)
    .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
inline fun View.indefiniteSnackbar(@StringRes message: Int) = Snackbar
    .make(this, message, Snackbar.LENGTH_INDEFINITE)
    .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun View.snackbar(message: String) = Snackbar
    .make(this, message, Snackbar.LENGTH_SHORT)
    .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun View.longSnackbar(message: String) = Snackbar
    .make(this, message, Snackbar.LENGTH_LONG)
    .apply { show() }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
inline fun View.indefiniteSnackbar(message: String) = Snackbar
    .make(this, message, Snackbar.LENGTH_INDEFINITE)
    .apply { show() }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
inline fun View.snackbar(message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_SHORT)
    .apply {
        setAction(actionText, action)
        show()
    }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
inline fun View.longSnackbar(@StringRes message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_LONG)
    .apply {
        setAction(actionText, action)
        show()
    }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text resource.
 */
inline fun View.indefiniteSnackbar(@StringRes message: Int, @StringRes actionText: Int, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_INDEFINITE)
    .apply {
        setAction(actionText, action)
        show()
    }

/**
 * Display the Snackbar with the [Snackbar.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun View.snackbar(message: String, actionText: String, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_SHORT)
    .apply {
        setAction(actionText, action)
        show()
    }

/**
 * Display Snackbar with the [Snackbar.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
inline fun View.longSnackbar(message: String, actionText: String, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_LONG)
    .apply {
        setAction(actionText, action)
        show()
    }

/**
 * Display Snackbar with the [Snackbar.LENGTH_INDEFINITE] duration.
 *
 * @param message the message text.
 */
inline fun View.indefiniteSnackbar(message: String, actionText: String, noinline action: (View) -> Unit) = Snackbar
    .make(this, message, Snackbar.LENGTH_INDEFINITE)
    .apply {
        setAction(actionText, action)
        show()
    }