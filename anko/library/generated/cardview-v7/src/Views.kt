@file:JvmName("CardviewV7ViewsKt")
package org.jetbrains.anko.cardview.v7

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

@PublishedApi
internal object `$$Anko$Factories$CardviewV7View` {
    val CARD_VIEW = { ctx: Context -> _CardView(ctx) }
}

inline fun ViewManager.cardView(): android.support.v7.widget.CardView = cardView() {}
inline fun ViewManager.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedCardView(theme: Int = 0): android.support.v7.widget.CardView = themedCardView(theme) {}
inline fun ViewManager.themedCardView(theme: Int = 0, init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}

inline fun Context.cardView(): android.support.v7.widget.CardView = cardView() {}
inline fun Context.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme = 0) { init() }
}

inline fun Context.themedCardView(theme: Int = 0): android.support.v7.widget.CardView = themedCardView(theme) {}
inline fun Context.themedCardView(theme: Int = 0, init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}

inline fun Activity.cardView(): android.support.v7.widget.CardView = cardView() {}
inline fun Activity.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme = 0) { init() }
}

inline fun Activity.themedCardView(theme: Int = 0): android.support.v7.widget.CardView = themedCardView(theme) {}
inline fun Activity.themedCardView(theme: Int = 0, init: (@AnkoViewDslMarker _CardView).() -> Unit): android.support.v7.widget.CardView {
return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}

