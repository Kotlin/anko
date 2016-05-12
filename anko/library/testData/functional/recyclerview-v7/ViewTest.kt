object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    val RECYCLER_VIEW = { ctx: Context -> _RecyclerView(ctx) }
}

inline fun ViewManager.recyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = recyclerView(theme) {}
inline fun ViewManager.recyclerView(theme: Int = 0, init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

inline fun Context.recyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = recyclerView(theme) {}
inline fun Context.recyclerView(theme: Int = 0, init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

inline fun Activity.recyclerView(theme: Int = 0): android.support.v7.widget.RecyclerView = recyclerView(theme) {}
inline fun Activity.recyclerView(theme: Int = 0, init: _RecyclerView.() -> Unit): android.support.v7.widget.RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}