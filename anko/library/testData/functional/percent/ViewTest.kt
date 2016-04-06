object `$$Anko$Factories$PercentViewGroup` {
    val PERCENT_FRAME_LAYOUT = { ctx: Context -> _PercentFrameLayout(ctx) }
    val PERCENT_RELATIVE_LAYOUT = { ctx: Context -> _PercentRelativeLayout(ctx) }
}

inline fun ViewManager.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
inline fun ViewManager.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

inline fun Context.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
inline fun Context.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

inline fun Activity.percentFrameLayout(): android.support.percent.PercentFrameLayout = percentFrameLayout({})
inline fun Activity.percentFrameLayout(init: _PercentFrameLayout.() -> Unit): android.support.percent.PercentFrameLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_FRAME_LAYOUT) { init() }
}

inline fun ViewManager.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
inline fun ViewManager.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}

inline fun Context.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
inline fun Context.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}

inline fun Activity.percentRelativeLayout(): android.support.percent.PercentRelativeLayout = percentRelativeLayout({})
inline fun Activity.percentRelativeLayout(init: _PercentRelativeLayout.() -> Unit): android.support.percent.PercentRelativeLayout {
    return ankoView(`$$Anko$Factories$PercentViewGroup`.PERCENT_RELATIVE_LAYOUT) { init() }
}