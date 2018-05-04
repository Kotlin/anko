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

@file:Suppress("unused", "NOTHING_TO_INLINE")
package org.jetbrains.anko

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import android.os.Parcelable
import android.preference.PreferenceManager
import android.support.annotation.IdRes
import android.view.View
import android.view.ViewGroup
import java.io.Serializable

inline val AnkoContext<*>.resources: Resources
    get() = ctx.resources

inline val AnkoContext<*>.assets: AssetManager
    get() = ctx.assets

inline val AnkoContext<*>.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(ctx)

inline val Context.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

inline val Fragment.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(activity)

inline val Fragment.act: Activity
    get() = activity

inline val Fragment.ctx: Context
    get() = activity

inline val Context.ctx: Context
    get() = this

inline val Activity.act: Activity
    get() = this

/**
 * Returns the content view of this Activity if set, null otherwise.
 */
inline val Activity.contentView: View?
    get() = findOptional<ViewGroup>(android.R.id.content)?.getChildAt(0)

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T
inline fun <reified T : View> Activity.find(@IdRes id: Int): T = findViewById(id) as T
inline fun <reified T : View> Fragment.find(@IdRes id: Int): T = view?.findViewById(id) as T
inline fun <reified T : View> Dialog.find(@IdRes id: Int): T = findViewById(id) as T

inline fun <reified T : View> View.findOptional(@IdRes id: Int): T? = findViewById(id) as? T
inline fun <reified T : View> Activity.findOptional(@IdRes id: Int): T? = findViewById(id) as? T
inline fun <reified T : View> Fragment.findOptional(@IdRes id: Int): T? = view?.findViewById(id) as? T
inline fun <reified T : View> Dialog.findOptional(@IdRes id: Int): T? = findViewById(id) as? T

inline fun <T: Fragment> T.withArguments(vararg params: Pair<String, Any?>): T {
    arguments = bundleOf(*params)
    return this
}

fun bundleOf(vararg params: Pair<String, Any?>): Bundle {
    val b = Bundle()
    for (p in params) {
        val (k, v) = p
        when (v) {
            null -> b.putSerializable(k, null)
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
            is Array<*> -> {
                @Suppress("UNCHECKED_CAST")
                when {
                    v.isArrayOf<Parcelable>() -> b.putParcelableArray(k, v as Array<out Parcelable>)
                    v.isArrayOf<CharSequence>() -> b.putCharSequenceArray(k, v as Array<out CharSequence>)
                    v.isArrayOf<String>() -> b.putStringArray(k, v as Array<out String>)
                    else -> throw AnkoException("Unsupported bundle component (${v.javaClass})")
                }
            }
            is ShortArray -> b.putShortArray(k, v)
            is Bundle -> b.putBundle(k, v)
            else -> throw AnkoException("Unsupported bundle component (${v.javaClass})")
        }
    }

    return b
}

inline val Context.displayMetrics: android.util.DisplayMetrics
    get() = resources.displayMetrics

inline val Context.configuration: android.content.res.Configuration
    get() = resources.configuration

inline val AnkoContext<*>.displayMetrics: android.util.DisplayMetrics
    get() = ctx.resources.displayMetrics

inline val AnkoContext<*>.configuration: android.content.res.Configuration
    get() = ctx.resources.configuration

inline val android.content.res.Configuration.portrait: Boolean
    get() = orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

inline val android.content.res.Configuration.landscape: Boolean
    get() = orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

inline val android.content.res.Configuration.long: Boolean
    get() = (screenLayout and android.content.res.Configuration.SCREENLAYOUT_LONG_YES) != 0
