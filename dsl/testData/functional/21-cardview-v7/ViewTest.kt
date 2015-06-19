@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun ViewManager.cardViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView = addView<android.support.v7.widget.CardView> {
    ctx ->
    val view = android.support.v7.widget.CardView(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun Context.cardViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView = addView<android.support.v7.widget.CardView> {
    ctx ->
    val view = android.support.v7.widget.CardView(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.cardViewSupport(): android.support.v7.widget.CardView = cardViewSupport({})
public inline fun Activity.cardViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.CardView.() -> Unit): android.support.v7.widget.CardView = addView<android.support.v7.widget.CardView> {
    ctx ->
    val view = android.support.v7.widget.CardView(ctx)
    view.init()
    view
}