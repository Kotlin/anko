public object `$$Anko$Factories$CardviewV7View` {
    public val CARD_VIEW_SUPPORT = { ctx: Context -> android.support.v7.widget.CardView(ctx) }
}

public inline fun ViewManager.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun ViewManager.cardViewSupport(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW_SUPPORT) { init() }
}

public inline fun Context.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun Context.cardViewSupport(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW_SUPPORT) { init() }
}

public inline fun Activity.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun Activity.cardViewSupport(init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView {
    return ankoView(`$$Anko$Factories$CardviewV7View`.CARD_VIEW_SUPPORT) { init() }
}