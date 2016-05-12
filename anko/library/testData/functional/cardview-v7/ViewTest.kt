object `$$Anko$Factories$CardviewV7View` {
    val CARD_VIEW = { ctx: Context -> android.support.v7.widget.CardView(ctx) }
}

inline fun ViewManager.cardView(theme: Int = 0): android.support.v7.widget.CardView = cardView(theme) {}
inline fun ViewManager.cardView(theme: Int = 0, init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}

inline fun Context.cardView(theme: Int = 0): android.support.v7.widget.CardView = cardView(theme) {}
inline fun Context.cardView(theme: Int = 0, init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}

inline fun Activity.cardView(theme: Int = 0): android.support.v7.widget.CardView = cardView(theme) {}
inline fun Activity.cardView(theme: Int = 0, init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW, theme) { init() }
}