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

@file:Suppress("NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("IntentsKt")
package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.app.Service
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import org.jetbrains.anko.internals.AnkoInternals

public inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivity(this, T::class.java, params)
}

public inline fun <reified T: Activity> Activity.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivityForResult(this, T::class.java, requestCode, params)
}

public inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivity(activity, T::class.java, params)
}

public inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivityForResult(activity, T::class.java, requestCode, params)
}

public inline fun <reified T: Service> Context.startService(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartService(this, T::class.java, params)
}

public inline fun <reified T: Service> Fragment.startService(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartService(activity, T::class.java, params)
}

public inline fun <reified T: Any> Context.intentFor(vararg params: Pair<String, Any>): Intent {
    return AnkoInternals.createIntent(this, T::class.java, params)
}

public inline fun <reified T: Any> Fragment.intentFor(vararg params: Pair<String, Any>): Intent {
    return AnkoInternals.createIntent(activity, T::class.java, params)
}

public inline fun Intent.clearTask(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) }

public inline fun Intent.clearTop(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) }

public inline fun Intent.clearWhenTaskReset(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET) }

public inline fun Intent.excludeFromRecents(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS) }

public inline fun Intent.multipleTask(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK) }

public inline fun Intent.newTask(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }

public inline fun Intent.noAnimation(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION) }

public inline fun Intent.noHistory(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY) }

public inline fun Intent.singleTop(): Intent = apply { setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP) }

public inline fun Fragment.browse(url: String): Boolean = activity.browse(url)

public fun Context.browse(url: String): Boolean {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}

public inline fun Fragment.share(text: String, subject: String = ""): Boolean = activity.share(text, subject)

public fun Context.share(text: String, subject: String = ""): Boolean {
    try {
        val intent = Intent(android.content.Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(android.content.Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, null))
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}

public inline fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean =
        activity.email(email, subject, text)

public fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.setData(Uri.parse("mailto:"))
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.length() > 0)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.length() > 0)
        intent.putExtra(Intent.EXTRA_TEXT, text)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }
    return false

}

public inline fun Fragment.makeCall(number: String): Boolean = activity.makeCall(number)

public fun Context.makeCall(number: String): Boolean {
    try {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
        startActivity(intent)
        return true
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}