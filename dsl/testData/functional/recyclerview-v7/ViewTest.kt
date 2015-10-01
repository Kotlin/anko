object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    val RECYCLER_VIEW = { ctx: Context -> _RecyclerView(ctx) }
}

inline fun ViewManager.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
inline fun ViewManager.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}

inline fun Context.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
inline fun Context.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}

inline fun Activity.recyclerView(): android.support.v7.widget.RecyclerView = recyclerView({})
inline fun Activity.recyclerView(init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW) { init() }
}