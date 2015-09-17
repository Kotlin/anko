public object `$$Anko$Factories$PercentViewGroup` {
    public val PERCENT_FRAME_LAYOUT = { ctx: Context -> _PercentFrameLayout(ctx) }
    public val PERCENT_RELATIVE_LAYOUT = { ctx: Context -> _PercentRelativeLayout(ctx) }
}

public inline fun ViewManager.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
public inline fun ViewManager.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

public inline fun Context.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
public inline fun Context.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

public inline fun Activity.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
public inline fun Activity.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

public inline fun ViewManager.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
public inline fun ViewManager.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}

public inline fun Context.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
public inline fun Context.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}

public inline fun Activity.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
public inline fun Activity.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}