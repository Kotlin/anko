@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun ViewManager.gridLayoutSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout = addView<android.support.v7.widget.GridLayout> {
    ctx ->
    val view = _GridLayoutSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun Context.gridLayoutSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout = addView<android.support.v7.widget.GridLayout> {
    ctx ->
    val view = _GridLayoutSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun Activity.gridLayoutSupport(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout = addView<android.support.v7.widget.GridLayout> {
    ctx ->
    val view = _GridLayoutSupport(ctx)
    view.init()
    view
}