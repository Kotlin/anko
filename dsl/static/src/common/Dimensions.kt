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

@file:suppress("NOTHING_TO_INLINE")

package org.jetbrains.anko

import android.app.Fragment
import android.content.Context

public val LDPI: Int = android.util.DisplayMetrics.DENSITY_LOW
public val MDPI: Int = android.util.DisplayMetrics.DENSITY_MEDIUM
public val HDPI: Int = android.util.DisplayMetrics.DENSITY_HIGH

//May not be available on older Android versions
public val TVDPI: Int = 213
public val XHDPI: Int = 320
public val XXHDPI: Int = 480
public val XXXHDPI: Int = 640

public val MAXDPI: Int = 0xfffe

//returns dip(dp) dimension value in pixels
public fun Context.dip(value: Int): Int = (value * (resources?.displayMetrics?.density ?: 0f)).toInt()
public fun Context.dip(value: Float): Int = (value * (resources?.displayMetrics?.density ?: 0f)).toInt()

//return sp dimension value in pixels
public fun Context.sp(value: Int): Int = (value * (resources?.displayMetrics?.scaledDensity ?: 0f)).toInt()
public fun Context.sp(value: Float): Int = (value * (resources?.displayMetrics?.scaledDensity ?: 0f)).toInt()

//converts px value into dip or sp
public fun Context.px2dip(px: Int): Float = (px.toFloat() / (resources?.displayMetrics?.density ?: 1f)).toFloat()
public fun Context.px2sp(px: Int): Float = (px.toFloat() / (resources?.displayMetrics?.scaledDensity ?: 1f)).toFloat()

public fun Context.dimen(resource: Int): Int = resources.getDimensionPixelSize(resource)


//the same for nested DSL components
public inline fun UiHelper.dip(value: Int): Int = ctx.dip(value)
public inline fun UiHelper.dip(value: Float): Int = ctx.dip(value)
public inline fun UiHelper.sp(value: Int): Int = ctx.sp(value)
public inline fun UiHelper.sp(value: Float): Int = ctx.sp(value)
public inline fun UiHelper.px2dip(px: Int): Float = ctx.px2dip(px)
public inline fun UiHelper.px2sp(px: Int): Float = ctx.px2sp(px)
public inline fun UiHelper.dimen(resource: Int): Int = ctx.dimen(resource)

//the same for Fragments
public inline fun Fragment.dip(value: Int): Int = activity.dip(value)
public inline fun Fragment.dip(value: Float): Int = activity.dip(value)
public inline fun Fragment.sp(value: Int): Int = activity.sp(value)
public inline fun Fragment.sp(value: Float): Int = activity.sp(value)
public inline fun Fragment.px2dip(px: Int): Float = activity.px2dip(px)
public inline fun Fragment.px2sp(px: Int): Float = activity.px2sp(px)
public inline fun Fragment.dimen(resource: Int): Int = activity.dimen(resource)