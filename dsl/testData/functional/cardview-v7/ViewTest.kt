object `$$Anko$Factories$CardviewV7View` {
    val CARD_VIEW = { ctx: Context -> android.support.v7.widget.CardView(ctx) }
}

inline fun ViewManager.cardView(): android.support.v7.widget.CardView = cardView({})
inline fun ViewManager.cardView(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW) { init() }
}

inline fun Context.cardView(): android.support.v7.widget.CardView = cardView({})
inline fun Context.cardView(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW) { init() }
}

inline fun Activity.cardView(): android.support.v7.widget.CardView = cardView({})
inline fun Activity.cardView(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW) { init() }
}