public object `$$Anko$Factories$PercentViewGroup` {
    public val PERCENT_FRAME_LAYOUT_SUPPORT = { ctx: Context -> _PercentFrameLayoutSupport(ctx) }
    public val PERCENT_RELATIVE_LAYOUT_SUPPORT = { ctx: Context -> _PercentRelativeLayoutSupport(ctx) }
}

public inline fun ViewManager.percentFrameLayoutSupport(): android.support.percent.PercentFrameLayout = percentFrameLayoutSupport({})
public inline fun ViewManager.percentFrameLayoutSupport(init: _PercentFrameLayoutSupport.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.percentFrameLayoutSupport(): android.support.percent.PercentFrameLayout = percentFrameLayoutSupport({})
public inline fun Context.percentFrameLayoutSupport(init: _PercentFrameLayoutSupport.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.percentFrameLayoutSupport(): android.support.percent.PercentFrameLayout = percentFrameLayoutSupport({})
public inline fun Activity.percentFrameLayoutSupport(init: _PercentFrameLayoutSupport.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.percentRelativeLayoutSupport(): android.support.percent.PercentRelativeLayout = percentRelativeLayoutSupport({})
public inline fun ViewManager.percentRelativeLayoutSupport(init: _PercentRelativeLayoutSupport.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.percentRelativeLayoutSupport(): android.support.percent.PercentRelativeLayout = percentRelativeLayoutSupport({})
public inline fun Context.percentRelativeLayoutSupport(init: _PercentRelativeLayoutSupport.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.percentRelativeLayoutSupport(): android.support.percent.PercentRelativeLayout = percentRelativeLayoutSupport({})
public inline fun Activity.percentRelativeLayoutSupport(init: _PercentRelativeLayoutSupport.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT_SUPPORT) { init() }
}