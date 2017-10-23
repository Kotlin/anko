@file:JvmName("ConstraintLayoutViewsKt")
package org.jetbrains.anko.constraint.layout

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
internal object `$$Anko$Factories$ConstraintLayoutView` {
    val GUIDELINE = { ctx: Context -> android.support.constraint.Guideline(ctx) }
}

inline fun ViewManager.guideline(): android.support.constraint.Guideline = guideline() {}
inline fun ViewManager.guideline(init: (@AnkoViewDslMarker android.support.constraint.Guideline).() -> Unit): android.support.constraint.Guideline {
    return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GUIDELINE, theme = 0) { init() }
}

inline fun ViewManager.themedGuideline(theme: Int = 0): android.support.constraint.Guideline = themedGuideline(theme) {}
inline fun ViewManager.themedGuideline(theme: Int = 0, init: (@AnkoViewDslMarker android.support.constraint.Guideline).() -> Unit): android.support.constraint.Guideline {
return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GUIDELINE, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$ConstraintLayoutViewGroup` {
    val CONSTRAINT_LAYOUT = { ctx: Context -> _ConstraintLayout(ctx) }
}

inline fun ViewManager.constraintLayout(): android.support.constraint.ConstraintLayout = constraintLayout() {}
inline fun ViewManager.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedConstraintLayout(theme: Int = 0): android.support.constraint.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun ViewManager.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

inline fun Context.constraintLayout(): android.support.constraint.ConstraintLayout = constraintLayout() {}
inline fun Context.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedConstraintLayout(theme: Int = 0): android.support.constraint.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun Context.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

inline fun Activity.constraintLayout(): android.support.constraint.ConstraintLayout = constraintLayout() {}
inline fun Activity.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedConstraintLayout(theme: Int = 0): android.support.constraint.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun Activity.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): android.support.constraint.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintLayoutViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

