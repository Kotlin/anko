public object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    public val RECYCLER_VIEW = { ctx: Context -> _RecyclerView(ctx) }
}

public inline fun ViewManager.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
public inline fun ViewManager.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}

public inline fun Context.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
public inline fun Context.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}

public inline fun Activity.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
public inline fun Activity.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}