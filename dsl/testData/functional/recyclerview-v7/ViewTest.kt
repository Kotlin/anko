public object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    public val RECYCLER_VIEW_SUPPORT = { ctx: Context -> _RecyclerViewSupport(ctx) }
}

public inline fun ViewManager.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun ViewManager.recyclerViewSupport(init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW_SUPPORT) { init() }
}

public inline fun Context.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun Context.recyclerViewSupport(init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW_SUPPORT) { init() }
}

public inline fun Activity.recyclerViewSupport(): android.support.v7.widget.RecyclerView = recyclerViewSupport({})
public inline fun Activity.recyclerViewSupport(init: _RecyclerViewSupport.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW_SUPPORT) { init() }
}