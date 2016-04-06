object `$$Anko$Factories$GridlayoutV7View` {
    val SPACE = { ctx: Context -> android.support.v7.widget.Space(ctx) }
}

inline fun ViewManager.space(): android.support.v7.widget.Space = space({})
inline fun ViewManager.space(init: android.support.v7.widget.Space.() -> Unit): android.support.v7.widget.Space {
    return ankoView(`$$Anko$Factories$GridlayoutV7View`.SPACE) { init() }
}

object `$$Anko$Factories$GridlayoutV7ViewGroup` {
    val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
}

inline fun ViewManager.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
inline fun ViewManager.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}

inline fun Context.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
inline fun Context.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}

inline fun Activity.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
inline fun Activity.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}