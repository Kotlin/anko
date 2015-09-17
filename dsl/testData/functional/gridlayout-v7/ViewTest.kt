public object `$$Anko$Factories$GridlayoutV7View` {
    public val SPACE = { ctx: Context -> android.support.v7.widget.Space(ctx) }
}

public inline fun ViewManager.space(): android.support.v7.widget.Space = space({})
public inline fun ViewManager.space(init: android.support.v7.widget.Space.() -> Unit): android.support.v7.widget.Space {
    return ankoView(`$$Anko$Factories$GridlayoutV7View`.SPACE) { init() }
}

public object `$$Anko$Factories$GridlayoutV7ViewGroup` {
    public val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
}

public inline fun ViewManager.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
public inline fun ViewManager.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}

public inline fun Context.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
public inline fun Context.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}

public inline fun Activity.gridLayout(): android.support.v7.widget.GridLayout = gridLayout({})
public inline fun Activity.gridLayout(init: _GridLayout.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT) { init() }
}