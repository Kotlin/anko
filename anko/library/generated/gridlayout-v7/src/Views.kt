@file:JvmName("GridlayoutV7ViewsKt")
package org.jetbrains.anko.gridlayout.v7

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
internal object `$$Anko$Factories$GridlayoutV7ViewGroup` {
    val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
}

inline fun ViewManager.gridLayout(): android.support.v7.widget.GridLayout = gridLayout() {}
inline fun ViewManager.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedGridLayout(theme: Int = 0): android.support.v7.widget.GridLayout = themedGridLayout(theme) {}
inline fun ViewManager.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Context.gridLayout(): android.support.v7.widget.GridLayout = gridLayout() {}
inline fun Context.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedGridLayout(theme: Int = 0): android.support.v7.widget.GridLayout = themedGridLayout(theme) {}
inline fun Context.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Activity.gridLayout(): android.support.v7.widget.GridLayout = gridLayout() {}
inline fun Activity.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedGridLayout(theme: Int = 0): android.support.v7.widget.GridLayout = themedGridLayout(theme) {}
inline fun Activity.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.support.v7.widget.GridLayout {
return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT, theme) { init() }
}

