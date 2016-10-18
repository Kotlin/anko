@file:JvmName("PercentViewsKt")
package org.jetbrains.anko.percent

import org.jetbrains.anko.custom.*
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.widget.*

object `$$Anko$Factories$PercentViewGroup` {
    val PERCENT_FRAME_LAYOUT = { ctx: Context -> _PercentFrameLayout(ctx) }
    val PERCENT_RELATIVE_LAYOUT = { ctx: Context -> _PercentRelativeLayout(ctx) }
}

inline fun ViewManager.percentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = percentFrameLayout(theme) {}
inline fun ViewManager.percentFrameLayout(theme: Int = 0, init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.percentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = percentFrameLayout(theme) {}
inline fun Context.percentFrameLayout(theme: Int = 0, init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.percentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = percentFrameLayout(theme) {}
inline fun Activity.percentFrameLayout(theme: Int = 0, init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.percentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = percentRelativeLayout(theme) {}
inline fun ViewManager.percentRelativeLayout(theme: Int = 0, init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

inline fun Context.percentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = percentRelativeLayout(theme) {}
inline fun Context.percentRelativeLayout(theme: Int = 0, init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

inline fun Activity.percentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = percentRelativeLayout(theme) {}
inline fun Activity.percentRelativeLayout(theme: Int = 0, init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

