public object `$$Anko$Factories$GridlayoutV7View` {
    public val SPACE_SUPPORT = { ctx: Context -> android.support.v7.widget.Space(ctx) }
}

public inline fun ViewManager.spaceSupport(): android.support.v7.widget.Space = spaceSupport({})
public inline fun ViewManager.spaceSupport(init: android.support.v7.widget.Space.() -> Unit): android.support.v7.widget.Space {
    return ankoView(`$$Anko$Factories$GridlayoutV7View`.SPACE_SUPPORT) { init() }
}

public object `$$Anko$Factories$GridlayoutV7ViewGroup` {
    public val GRID_LAYOUT_SUPPORT = { ctx: Context -> _GridLayoutSupport(ctx) }
}

public inline fun ViewManager.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun ViewManager.gridLayoutSupport(init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun Context.gridLayoutSupport(init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.gridLayoutSupport(): android.support.v7.widget.GridLayout = gridLayoutSupport({})
public inline fun Activity.gridLayoutSupport(init: _GridLayoutSupport.() -> Unit): android.support.v7.widget.GridLayout {
    return ankoView(`$$Anko$Factories$GridlayoutV7ViewGroup`.GRID_LAYOUT_SUPPORT) { init() }
}