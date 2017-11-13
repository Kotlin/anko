@file:JvmName("RecyclerviewV7ViewsKt")
package org.jetbrains.anko.recyclerview.v7

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
internal object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    val RECYCLER_VIEW = { ctx: Context -> _RecyclerView(ctx) }
}

inline fun ViewManager.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView() {}
inline fun ViewManager.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedRecyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = themedRecyclerView(theme) {}
inline fun ViewManager.themedRecyclerView(theme: Int = 0, init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

inline fun Context.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView() {}
inline fun Context.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

inline fun Context.themedRecyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = themedRecyclerView(theme) {}
inline fun Context.themedRecyclerView(theme: Int = 0, init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

inline fun Activity.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView() {}
inline fun Activity.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

inline fun Activity.themedRecyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = themedRecyclerView(theme) {}
inline fun Activity.themedRecyclerView(theme: Int = 0, init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView {
return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

