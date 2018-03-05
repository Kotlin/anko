@file:Suppress("NOTHING_TO_INLINE", "unused")
package org.jetbrains.anko

import android.app.Fragment
import android.content.Context
import android.os.Build
import android.support.annotation.AttrRes
import android.support.annotation.ColorInt
import android.util.TypedValue
import android.view.View


fun Context.attr(@AttrRes attribute: Int): TypedValue {
    var typed = TypedValue()
    ctx.theme.resolveAttribute(attribute, typed, true)
    return typed
}

//returns px
fun Context.dimenAttr(@AttrRes attribute: Int): Int =
        TypedValue.complexToDimensionPixelSize(attr(attribute).data, resources.displayMetrics)

//returns color
@ColorInt
fun Context.colorAttr(@AttrRes attribute: Int): Int {
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        resources.getColor(attr(attribute).resourceId, ctx.theme)
    } else {
        resources.getColor(attr(attribute).resourceId)
    }
}

inline fun AnkoContext<*>.dimenAttr(@AttrRes attribute: Int): Int = ctx.dimenAttr(attribute)
@ColorInt
inline fun AnkoContext<*>.colorAttr(@AttrRes attribute: Int): Int = ctx.colorAttr(attribute)
inline fun AnkoContext<*>.attribute(@AttrRes attribute: Int): TypedValue = ctx.attr(attribute)

inline fun View.dimenAttr(@AttrRes attribute: Int): Int = context.dimenAttr(attribute)
@ColorInt
inline fun View.colorAttr(@AttrRes attribute: Int): Int = context.colorAttr(attribute)
inline fun View.attr(@AttrRes attribute: Int): TypedValue = context.attr(attribute)

inline fun Fragment.dimenAttr(@AttrRes attribute: Int): Int = activity.dimenAttr(attribute)
@ColorInt
inline fun Fragment.colorAttr(@AttrRes attribute: Int): Int = activity.colorAttr(attribute)
inline fun Fragment.attr(@AttrRes attribute: Int): TypedValue = activity.attr(attribute)