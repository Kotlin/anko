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
    val BARRIER = { ctx: Context -> android.support.constraint.Barrier(ctx) }
    val GROUP = { ctx: Context -> android.support.constraint.Group(ctx) }
    val GUIDELINE = { ctx: Context -> android.support.constraint.Guideline(ctx) }
    val PLACEHOLDER = { ctx: Context -> android.support.constraint.Placeholder(ctx) }
}

inline fun ViewManager.barrier(): android.support.constraint.Barrier = barrier() {}
inline fun ViewManager.barrier(init: (@AnkoViewDslMarker android.support.constraint.Barrier).() -> Unit): android.support.constraint.Barrier {
    return ankoView(`$$Anko$Factories$ConstraintLayoutView`.BARRIER, theme = 0) { init() }
}

inline fun ViewManager.themedBarrier(theme: Int = 0): android.support.constraint.Barrier = themedBarrier(theme) {}
inline fun ViewManager.themedBarrier(theme: Int = 0, init: (@AnkoViewDslMarker android.support.constraint.Barrier).() -> Unit): android.support.constraint.Barrier {
return ankoView(`$$Anko$Factories$ConstraintLayoutView`.BARRIER, theme) { init() }
}

inline fun ViewManager.group(): android.support.constraint.Group = group() {}
inline fun ViewManager.group(init: (@AnkoViewDslMarker android.support.constraint.Group).() -> Unit): android.support.constraint.Group {
    return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GROUP, theme = 0) { init() }
}

inline fun ViewManager.themedGroup(theme: Int = 0): android.support.constraint.Group = themedGroup(theme) {}
inline fun ViewManager.themedGroup(theme: Int = 0, init: (@AnkoViewDslMarker android.support.constraint.Group).() -> Unit): android.support.constraint.Group {
return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GROUP, theme) { init() }
}

inline fun ViewManager.guideline(): android.support.constraint.Guideline = guideline() {}
inline fun ViewManager.guideline(init: (@AnkoViewDslMarker android.support.constraint.Guideline).() -> Unit): android.support.constraint.Guideline {
    return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GUIDELINE, theme = 0) { init() }
}

inline fun ViewManager.themedGuideline(theme: Int = 0): android.support.constraint.Guideline = themedGuideline(theme) {}
inline fun ViewManager.themedGuideline(theme: Int = 0, init: (@AnkoViewDslMarker android.support.constraint.Guideline).() -> Unit): android.support.constraint.Guideline {
return ankoView(`$$Anko$Factories$ConstraintLayoutView`.GUIDELINE, theme) { init() }
}

inline fun ViewManager.placeholder(): android.support.constraint.Placeholder = placeholder() {}
inline fun ViewManager.placeholder(init: (@AnkoViewDslMarker android.support.constraint.Placeholder).() -> Unit): android.support.constraint.Placeholder {
    return ankoView(`$$Anko$Factories$ConstraintLayoutView`.PLACEHOLDER, theme = 0) { init() }
}

inline fun ViewManager.themedPlaceholder(theme: Int = 0): android.support.constraint.Placeholder = themedPlaceholder(theme) {}
inline fun ViewManager.themedPlaceholder(theme: Int = 0, init: (@AnkoViewDslMarker android.support.constraint.Placeholder).() -> Unit): android.support.constraint.Placeholder {
return ankoView(`$$Anko$Factories$ConstraintLayoutView`.PLACEHOLDER, theme) { init() }
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

