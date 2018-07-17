@file:JvmName("PercentViewsKt")
package org.jetbrains.anko.percent

import org.jetbrains.anko.custom.*
import org.jetbrains.anko.AnkoViewDslMarker
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.widget.*

@PublishedApi
internal object `$$Anko$Factories$PercentViewGroup` {
    val PERCENT_FRAME_LAYOUT = { ctx: Context -> _PercentFrameLayout(ctx) }
    val PERCENT_RELATIVE_LAYOUT = { ctx: Context -> _PercentRelativeLayout(ctx) }
}

inline fun ViewManager.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout() {}
inline fun ViewManager.percentFrameLayout(init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedPercentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = themedPercentFrameLayout(theme) {}
inline fun ViewManager.themedPercentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout() {}
inline fun Context.percentFrameLayout(init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedPercentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = themedPercentFrameLayout(theme) {}
inline fun Context.themedPercentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout() {}
inline fun Activity.percentFrameLayout(init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedPercentFrameLayout(theme: Int = 0): android.support.percent.PercentFrameLayout = themedPercentFrameLayout(theme) {}
inline fun Activity.themedPercentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentFrameLayout).() -> Unit): android.support.percent.PercentFrameLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout() {}
inline fun ViewManager.percentRelativeLayout(init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedPercentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = themedPercentRelativeLayout(theme) {}
inline fun ViewManager.themedPercentRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

inline fun Context.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout() {}
inline fun Context.percentRelativeLayout(init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedPercentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = themedPercentRelativeLayout(theme) {}
inline fun Context.themedPercentRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

inline fun Activity.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout() {}
inline fun Activity.percentRelativeLayout(init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedPercentRelativeLayout(theme: Int = 0): android.support.percent.PercentRelativeLayout = themedPercentRelativeLayout(theme) {}
inline fun Activity.themedPercentRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _PercentRelativeLayout).() -> Unit): android.support.percent.PercentRelativeLayout {
return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT, theme) { init() }
}

