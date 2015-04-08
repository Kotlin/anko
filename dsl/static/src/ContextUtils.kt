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

package kotlinx.android.anko

import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.content.ActivityNotFoundException
import android.preference.PreferenceManager
import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.net.Uri
import java.io.Serializable
import kotlinx.android.anko.internals.__internalStartActivity
import android.os.Parcelable
import kotlinx.android.anko.internals.__internalStartActivityForResult

public val LDPI: Int = android.util.DisplayMetrics.DENSITY_LOW
public val MDPI: Int = android.util.DisplayMetrics.DENSITY_MEDIUM
public val HDPI: Int = android.util.DisplayMetrics.DENSITY_HIGH

//May not be available on older Android versions
public val TVDPI: Int = 213
public val XHDPI: Int = 320
public val XXHDPI: Int = 480
public val XXXHDPI: Int = 640

public val Activity.intent: Intent
    get() = getIntent()

public val Context.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

public val Fragment.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(getActivity())

public val Fragment.act: Activity
    get() = getActivity()

public val Fragment.ctx: Context
    get() = getActivity()

public val Context.ctx: Context
    get() = this

public val Activity.act: Activity
    get() = this

[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.browse(url: String): Boolean = ctx.browse(url)

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

[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.share(text: String, subject: String = ""): Boolean = ctx.share(text, subject)

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

[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean = ctx.email(email, subject, text)

public fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/html")
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        if (subject.length() > 0)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        if (text.length() > 0)
            intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, null))
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}

[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.makeCall(number: String): Boolean = ctx.makeCall(number)

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

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any>) {
    __internalStartActivity(javaClass<T>(), params)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Activity.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    __internalStartActivityForResult(javaClass<T>(), requestCode, params)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    getActivity().__internalStartActivity(javaClass<T>(), params)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    getActivity().__internalStartActivityForResult(javaClass<T>(), requestCode, params)
}

public fun <T: Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    setArguments(Bundle(*params))
    return this
}

private fun Bundle(vararg params: Pair<String, Any>): Bundle {
    val b = Bundle()
    for (p in params) {
        val (k, v) = p
        when (v) {
            is Boolean -> b.putBoolean(k, v)
            is Byte -> b.putByte(k, v)
            is Char -> b.putChar(k, v)
            is Short -> b.putShort(k, v)
            is Int -> b.putInt(k, v)
            is Long -> b.putLong(k, v)
            is Float -> b.putFloat(k, v)
            is Double -> b.putDouble(k, v)
            is String -> b.putString(k, v)
            is CharSequence -> b.putCharSequence(k, v)
            is Parcelable -> b.putParcelable(k, v)
            is Serializable -> b.putSerializable(k, v)
            is BooleanArray -> b.putBooleanArray(k, v)
            is ByteArray -> b.putByteArray(k, v)
            is CharArray -> b.putCharArray(k, v)
            is DoubleArray -> b.putDoubleArray(k, v)
            is FloatArray -> b.putFloatArray(k, v)
            is IntArray -> b.putIntArray(k, v)
            is LongArray -> b.putLongArray(k, v)
            is Array<Parcelable> -> b.putParcelableArray(k, v)
            is ShortArray -> b.putShortArray(k, v)
            is Array<CharSequence> -> b.putCharSequenceArray(k, v)
            is Array<String> -> b.putStringArray(k, v)
            is Bundle -> b.putBundle(k, v)
            else -> throw AnkoException("Unsupported bundle component (${v.javaClass})")
        }
    }

    return b
}

public val Context.displayMetrics: android.util.DisplayMetrics
    get() = getResources().getDisplayMetrics()

public val Context.configuration: android.content.res.Configuration
    get() = getResources().getConfiguration()

public val android.content.res.Configuration.portrait: Boolean
    get() = orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

public val android.content.res.Configuration.landscape: Boolean
    get() = orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

public val android.content.res.Configuration.long: Boolean
    get() = (screenLayout and android.content.res.Configuration.SCREENLAYOUT_LONG_YES) != 0

public inline fun <reified T: Any> Context.intentFor(): Intent = Intent(this, javaClass<T>())

public inline fun <reified T: Any> Fragment.intentFor(): Intent = Intent(getActivity(), javaClass<T>())

[suppress("NOTHING_TO_INLINE")]
private inline fun Intent.setFlag(flag: Int): Intent {
    setFlags(flag)
    return this
}

public fun Intent.clearTask(): Intent = setFlag(Intent.FLAG_ACTIVITY_CLEAR_TASK)
public fun Intent.clearTop(): Intent = setFlag(Intent.FLAG_ACTIVITY_CLEAR_TOP)
public fun Intent.clearWhenTaskReset(): Intent = setFlag(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
public fun Intent.excludeFromRecents(): Intent = setFlag(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
public fun Intent.multipleTask(): Intent = setFlag(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
public fun Intent.newTask(): Intent = setFlag(Intent.FLAG_ACTIVITY_NEW_TASK)
public fun Intent.noAnimation(): Intent = setFlag(Intent.FLAG_ACTIVITY_NO_ANIMATION)
public fun Intent.noHistory(): Intent = setFlag(Intent.FLAG_ACTIVITY_NO_HISTORY)
public fun Intent.singleTop(): Intent = setFlag(Intent.FLAG_ACTIVITY_SINGLE_TOP)
