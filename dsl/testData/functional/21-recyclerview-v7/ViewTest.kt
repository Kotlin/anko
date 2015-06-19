@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun ViewManager.recyclerViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView = addView<android.support.v7.widget.RecyclerView> {
    ctx ->
    val view = _RecyclerViewSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun Context.recyclerViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView = addView<android.support.v7.widget.RecyclerView> {
    ctx ->
    val view = _RecyclerViewSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun Activity.recyclerViewSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView = addView<android.support.v7.widget.RecyclerView> {
    ctx ->
    val view = _RecyclerViewSupport(ctx)
    view.init()
    view
}