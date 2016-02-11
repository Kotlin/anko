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

@file:Suppress("NOTHING_TO_INLINE")
package org.jetbrains.anko

import android.app.Fragment
import android.content.Context
import android.os.Build
import android.util.TypedValue
import android.view.View

val LDPI: Int = android.util.DisplayMetrics.DENSITY_LOW
val MDPI: Int = android.util.DisplayMetrics.DENSITY_MEDIUM
val HDPI: Int = android.util.DisplayMetrics.DENSITY_HIGH

//May not be available on older Android versions
val TVDPI: Int = 213
val XHDPI: Int = 320
val XXHDPI: Int = 480
val XXXHDPI: Int = 640

val MAXDPI: Int = 0xfffe

//returns dip(dp) dimension value in pixels
fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()
fun Context.dip(value: Float): Int = (value * resources.displayMetrics.density).toInt()

//return sp dimension value in pixels
fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()
fun Context.sp(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()

//converts px value into dip or sp
fun Context.px2dip(px: Int): Float = (px.toFloat() / resources.displayMetrics.density).toFloat()
fun Context.px2sp(px: Int): Float = (px.toFloat() / resources.displayMetrics.scaledDensity).toFloat()

fun Context.dimen(resource: Int): Int = resources.getDimensionPixelSize(resource)

fun Context.attr(attribute: Int): TypedValue {
    var typed = TypedValue()
    ctx.theme.resolveAttribute(attribute, typed, true)
    return typed
}

//returns px
fun Context.dimenAttr(attribute: Int): Int = TypedValue.complexToDimensionPixelSize(attr(attribute).data, resources.displayMetrics)

//returns color
fun Context.colorAttr(attribute: Int): Int {
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        resources.getColor(attr(attribute).resourceId, ctx.theme)
    } else {
        resources.getColor(attr(attribute).resourceId)
    }
}



//the same for nested DSL components
inline fun AnkoContext<*>.dip(value: Int): Int = ctx.dip(value)
inline fun AnkoContext<*>.dip(value: Float): Int = ctx.dip(value)
inline fun AnkoContext<*>.sp(value: Int): Int = ctx.sp(value)
inline fun AnkoContext<*>.sp(value: Float): Int = ctx.sp(value)
inline fun AnkoContext<*>.px2dip(px: Int): Float = ctx.px2dip(px)
inline fun AnkoContext<*>.px2sp(px: Int): Float = ctx.px2sp(px)
inline fun AnkoContext<*>.dimen(resource: Int): Int = ctx.dimen(resource)
inline fun AnkoContext<*>.dimenAttr(attribute: Int): Int = ctx.dimenAttr(attribute)
inline fun AnkoContext<*>.colorAttr(attribute: Int): Int = ctx.colorAttr(attribute)
inline fun AnkoContext<*>.attribute(attribute: Int): TypedValue = ctx.attr(attribute)

//the same for the views
inline fun View.dip(value: Int): Int = context.dip(value)
inline fun View.dip(value: Float): Int = context.dip(value)
inline fun View.sp(value: Int): Int = context.sp(value)
inline fun View.sp(value: Float): Int = context.sp(value)
inline fun View.px2dip(px: Int): Float = context.px2dip(px)
inline fun View.px2sp(px: Int): Float = context.px2sp(px)
inline fun View.dimen(resource: Int): Int = context.dimen(resource)
inline fun View.dimenAttr(attribute: Int): Int = context.dimenAttr(attribute)
inline fun View.colorAttr(attribute: Int): Int = context.colorAttr(attribute)
inline fun View.attr(attribute: Int): TypedValue = context.attr(attribute)

//the same for Fragments
inline fun Fragment.dip(value: Int): Int = activity.dip(value)
inline fun Fragment.dip(value: Float): Int = activity.dip(value)
inline fun Fragment.sp(value: Int): Int = activity.sp(value)
inline fun Fragment.sp(value: Float): Int = activity.sp(value)
inline fun Fragment.px2dip(px: Int): Float = activity.px2dip(px)
inline fun Fragment.px2sp(px: Int): Float = activity.px2sp(px)
inline fun Fragment.dimen(resource: Int): Int = activity.dimen(resource)
inline fun Fragment.dimenAttr(attribute: Int): Int = activity.dimenAttr(attribute)
inline fun Fragment.colorAttr(attribute: Int): Int = activity.colorAttr(attribute)
inline fun Fragment.attr(attribute: Int): TypedValue = activity.attr(attribute)