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

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.support.v4.app.Fragment
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.share

fun Fragment.browse(url: String, newTask: Boolean = false): Boolean = requireActivity().browse(url, newTask)

fun Fragment.share(text: String, subject: String = ""): Boolean = requireActivity().share(text, subject)

fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean =
        requireActivity().email(email, subject, text)

fun Fragment.makeCall(number: String): Boolean = requireActivity().makeCall(number)

fun Fragment.sendSMS(number: String, text: String = ""): Boolean = requireActivity().sendSMS(number, text)

inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) {
    AnkoInternals.internalStartActivity(requireActivity(), T::class.java, params)
}

inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) {
    startActivityForResult(AnkoInternals.createIntent(requireActivity(), T::class.java, params), requestCode)
}

inline fun <reified T: Service> Fragment.startService(vararg params: Pair<String, Any?>) {
    AnkoInternals.internalStartService(requireActivity(), T::class.java, params)
}

inline fun <reified T : Service> Fragment.stopService(vararg params: Pair<String, Any?>) {
    AnkoInternals.internalStopService(requireActivity(), T::class.java, params)
}

inline fun <reified T: Any> Fragment.intentFor(vararg params: Pair<String, Any?>): Intent =
        AnkoInternals.createIntent(requireActivity(), T::class.java, params)
