@file:JvmName("ConstraintlayoutAndroidxViewsKt")
package org.jetbrains.anko.constraintlayout.androidx

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
internal object `$$Anko$Factories$ConstraintlayoutAndroidxView` {
    val BARRIER = { ctx: Context -> androidx.constraintlayout.widget.Barrier(ctx) }
    val GROUP = { ctx: Context -> androidx.constraintlayout.widget.Group(ctx) }
    val GUIDELINE = { ctx: Context -> androidx.constraintlayout.widget.Guideline(ctx) }
    val PLACEHOLDER = { ctx: Context -> androidx.constraintlayout.widget.Placeholder(ctx) }
}

inline fun ViewManager.barrier(): androidx.constraintlayout.widget.Barrier = barrier() {}
inline fun ViewManager.barrier(init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Barrier).() -> Unit): androidx.constraintlayout.widget.Barrier {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.BARRIER, theme = 0) { init() }
}

inline fun ViewManager.themedBarrier(theme: Int = 0): androidx.constraintlayout.widget.Barrier = themedBarrier(theme) {}
inline fun ViewManager.themedBarrier(theme: Int = 0, init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Barrier).() -> Unit): androidx.constraintlayout.widget.Barrier {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.BARRIER, theme) { init() }
}

inline fun ViewManager.group(): androidx.constraintlayout.widget.Group = group() {}
inline fun ViewManager.group(init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Group).() -> Unit): androidx.constraintlayout.widget.Group {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.GROUP, theme = 0) { init() }
}

inline fun ViewManager.themedGroup(theme: Int = 0): androidx.constraintlayout.widget.Group = themedGroup(theme) {}
inline fun ViewManager.themedGroup(theme: Int = 0, init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Group).() -> Unit): androidx.constraintlayout.widget.Group {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.GROUP, theme) { init() }
}

inline fun ViewManager.guideline(): androidx.constraintlayout.widget.Guideline = guideline() {}
inline fun ViewManager.guideline(init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Guideline).() -> Unit): androidx.constraintlayout.widget.Guideline {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.GUIDELINE, theme = 0) { init() }
}

inline fun ViewManager.themedGuideline(theme: Int = 0): androidx.constraintlayout.widget.Guideline = themedGuideline(theme) {}
inline fun ViewManager.themedGuideline(theme: Int = 0, init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Guideline).() -> Unit): androidx.constraintlayout.widget.Guideline {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.GUIDELINE, theme) { init() }
}

inline fun ViewManager.placeholder(): androidx.constraintlayout.widget.Placeholder = placeholder() {}
inline fun ViewManager.placeholder(init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Placeholder).() -> Unit): androidx.constraintlayout.widget.Placeholder {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.PLACEHOLDER, theme = 0) { init() }
}

inline fun ViewManager.themedPlaceholder(theme: Int = 0): androidx.constraintlayout.widget.Placeholder = themedPlaceholder(theme) {}
inline fun ViewManager.themedPlaceholder(theme: Int = 0, init: (@AnkoViewDslMarker androidx.constraintlayout.widget.Placeholder).() -> Unit): androidx.constraintlayout.widget.Placeholder {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxView`.PLACEHOLDER, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$ConstraintlayoutAndroidxViewGroup` {
    val CONSTRAINT_LAYOUT = { ctx: Context -> _ConstraintLayout(ctx) }
    val CONSTRAINTS = { ctx: Context -> _Constraints(ctx) }
}

inline fun ViewManager.constraintLayout(): androidx.constraintlayout.widget.ConstraintLayout = constraintLayout() {}
inline fun ViewManager.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedConstraintLayout(theme: Int = 0): androidx.constraintlayout.widget.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun ViewManager.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

inline fun Context.constraintLayout(): androidx.constraintlayout.widget.ConstraintLayout = constraintLayout() {}
inline fun Context.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedConstraintLayout(theme: Int = 0): androidx.constraintlayout.widget.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun Context.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

inline fun Activity.constraintLayout(): androidx.constraintlayout.widget.ConstraintLayout = constraintLayout() {}
inline fun Activity.constraintLayout(init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedConstraintLayout(theme: Int = 0): androidx.constraintlayout.widget.ConstraintLayout = themedConstraintLayout(theme) {}
inline fun Activity.themedConstraintLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ConstraintLayout).() -> Unit): androidx.constraintlayout.widget.ConstraintLayout {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINT_LAYOUT, theme) { init() }
}

inline fun ViewManager.constraints(): androidx.constraintlayout.widget.Constraints = constraints() {}
inline fun ViewManager.constraints(init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme = 0) { init() }
}

inline fun ViewManager.themedConstraints(theme: Int = 0): androidx.constraintlayout.widget.Constraints = themedConstraints(theme) {}
inline fun ViewManager.themedConstraints(theme: Int = 0, init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme) { init() }
}

inline fun Context.constraints(): androidx.constraintlayout.widget.Constraints = constraints() {}
inline fun Context.constraints(init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme = 0) { init() }
}

inline fun Context.themedConstraints(theme: Int = 0): androidx.constraintlayout.widget.Constraints = themedConstraints(theme) {}
inline fun Context.themedConstraints(theme: Int = 0, init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme) { init() }
}

inline fun Activity.constraints(): androidx.constraintlayout.widget.Constraints = constraints() {}
inline fun Activity.constraints(init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
    return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme = 0) { init() }
}

inline fun Activity.themedConstraints(theme: Int = 0): androidx.constraintlayout.widget.Constraints = themedConstraints(theme) {}
inline fun Activity.themedConstraints(theme: Int = 0, init: (@AnkoViewDslMarker _Constraints).() -> Unit): androidx.constraintlayout.widget.Constraints {
return ankoView(`$$Anko$Factories$ConstraintlayoutAndroidxViewGroup`.CONSTRAINTS, theme) { init() }
}

