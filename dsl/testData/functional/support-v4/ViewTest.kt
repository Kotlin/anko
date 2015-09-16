public object `$$Anko$Factories$SupportV4View` {
    public val PAGER_TAB_STRIP_SUPPORT = { ctx: Context -> android.support.v4.view.PagerTabStrip(ctx) }
    public val PAGER_TITLE_STRIP_SUPPORT = { ctx: Context -> android.support.v4.view.PagerTitleStrip(ctx) }
    public val CONTENT_LOADING_PROGRESS_BAR_SUPPORT = { ctx: Context -> android.support.v4.widget.ContentLoadingProgressBar(ctx) }
    public val SPACE_SUPPORT = { ctx: Context -> android.support.v4.widget.Space(ctx) }
    public val SWIPE_REFRESH_LAYOUT_SUPPORT = { ctx: Context -> android.support.v4.widget.SwipeRefreshLayout(ctx) }
}

public inline fun ViewManager.pagerTabStripSupport(): android.support.v4.view.PagerTabStrip = pagerTabStripSupport({})
public inline fun ViewManager.pagerTabStripSupport(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP_SUPPORT) { init() }
}

public inline fun Context.pagerTabStripSupport(): android.support.v4.view.PagerTabStrip = pagerTabStripSupport({})
public inline fun Context.pagerTabStripSupport(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP_SUPPORT) { init() }
}

public inline fun Activity.pagerTabStripSupport(): android.support.v4.view.PagerTabStrip = pagerTabStripSupport({})
public inline fun Activity.pagerTabStripSupport(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP_SUPPORT) { init() }
}

public inline fun ViewManager.pagerTitleStripSupport(): android.support.v4.view.PagerTitleStrip = pagerTitleStripSupport({})
public inline fun ViewManager.pagerTitleStripSupport(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP_SUPPORT) { init() }
}

public inline fun Context.pagerTitleStripSupport(): android.support.v4.view.PagerTitleStrip = pagerTitleStripSupport({})
public inline fun Context.pagerTitleStripSupport(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP_SUPPORT) { init() }
}

public inline fun Activity.pagerTitleStripSupport(): android.support.v4.view.PagerTitleStrip = pagerTitleStripSupport({})
public inline fun Activity.pagerTitleStripSupport(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP_SUPPORT) { init() }
}

public inline fun ViewManager.contentLoadingProgressBarSupport(): android.support.v4.widget.ContentLoadingProgressBar = contentLoadingProgressBarSupport({})
public inline fun ViewManager.contentLoadingProgressBarSupport(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit): android.support.v4.widget.ContentLoadingProgressBar {
    return ankoView(`$$Anko$Factories$SupportV4View`.CONTENT_LOADING_PROGRESS_BAR_SUPPORT) { init() }
}

public inline fun ViewManager.spaceSupport(): android.support.v4.widget.Space = spaceSupport({})
public inline fun ViewManager.spaceSupport(init: android.support.v4.widget.Space.() -> Unit): android.support.v4.widget.Space {
    return ankoView(`$$Anko$Factories$SupportV4View`.SPACE_SUPPORT) { init() }
}

public inline fun ViewManager.swipeRefreshLayoutSupport(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayoutSupport({})
public inline fun ViewManager.swipeRefreshLayoutSupport(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.swipeRefreshLayoutSupport(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayoutSupport({})
public inline fun Context.swipeRefreshLayoutSupport(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.swipeRefreshLayoutSupport(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayoutSupport({})
public inline fun Activity.swipeRefreshLayoutSupport(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT_SUPPORT) { init() }
}

public object `$$Anko$Factories$SupportV4ViewGroup` {
    public val FRAGMENT_TAB_HOST_SUPPORT = { ctx: Context -> _FragmentTabHostSupport(ctx) }
    public val VIEW_PAGER_SUPPORT = { ctx: Context -> _ViewPagerSupport(ctx) }
    public val DRAWER_LAYOUT_SUPPORT = { ctx: Context -> _DrawerLayoutSupport(ctx) }
    public val NESTED_SCROLL_VIEW_SUPPORT = { ctx: Context -> _NestedScrollViewSupport(ctx) }
    public val SLIDING_PANE_LAYOUT_SUPPORT = { ctx: Context -> _SlidingPaneLayoutSupport(ctx) }
}

public inline fun ViewManager.fragmentTabHostSupport(): android.support.v4.app.FragmentTabHost = fragmentTabHostSupport({})
public inline fun ViewManager.fragmentTabHostSupport(init: _FragmentTabHostSupport.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST_SUPPORT) { init() }
}

public inline fun Context.fragmentTabHostSupport(): android.support.v4.app.FragmentTabHost = fragmentTabHostSupport({})
public inline fun Context.fragmentTabHostSupport(init: _FragmentTabHostSupport.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST_SUPPORT) { init() }
}

public inline fun Activity.fragmentTabHostSupport(): android.support.v4.app.FragmentTabHost = fragmentTabHostSupport({})
public inline fun Activity.fragmentTabHostSupport(init: _FragmentTabHostSupport.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST_SUPPORT) { init() }
}

public inline fun ViewManager.viewPagerSupport(): android.support.v4.view.ViewPager = viewPagerSupport({})
public inline fun ViewManager.viewPagerSupport(init: _ViewPagerSupport.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER_SUPPORT) { init() }
}

public inline fun Context.viewPagerSupport(): android.support.v4.view.ViewPager = viewPagerSupport({})
public inline fun Context.viewPagerSupport(init: _ViewPagerSupport.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER_SUPPORT) { init() }
}

public inline fun Activity.viewPagerSupport(): android.support.v4.view.ViewPager = viewPagerSupport({})
public inline fun Activity.viewPagerSupport(init: _ViewPagerSupport.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER_SUPPORT) { init() }
}

public inline fun ViewManager.drawerLayoutSupport(): android.support.v4.widget.DrawerLayout = drawerLayoutSupport({})
public inline fun ViewManager.drawerLayoutSupport(init: _DrawerLayoutSupport.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.drawerLayoutSupport(): android.support.v4.widget.DrawerLayout = drawerLayoutSupport({})
public inline fun Context.drawerLayoutSupport(init: _DrawerLayoutSupport.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.drawerLayoutSupport(): android.support.v4.widget.DrawerLayout = drawerLayoutSupport({})
public inline fun Activity.drawerLayoutSupport(init: _DrawerLayoutSupport.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.nestedScrollViewSupport(): android.support.v4.widget.NestedScrollView = nestedScrollViewSupport({})
public inline fun ViewManager.nestedScrollViewSupport(init: _NestedScrollViewSupport.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW_SUPPORT) { init() }
}

public inline fun Context.nestedScrollViewSupport(): android.support.v4.widget.NestedScrollView = nestedScrollViewSupport({})
public inline fun Context.nestedScrollViewSupport(init: _NestedScrollViewSupport.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW_SUPPORT) { init() }
}

public inline fun Activity.nestedScrollViewSupport(): android.support.v4.widget.NestedScrollView = nestedScrollViewSupport({})
public inline fun Activity.nestedScrollViewSupport(init: _NestedScrollViewSupport.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW_SUPPORT) { init() }
}

public inline fun ViewManager.slidingPaneLayoutSupport(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayoutSupport({})
public inline fun ViewManager.slidingPaneLayoutSupport(init: _SlidingPaneLayoutSupport.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.slidingPaneLayoutSupport(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayoutSupport({})
public inline fun Context.slidingPaneLayoutSupport(init: _SlidingPaneLayoutSupport.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.slidingPaneLayoutSupport(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayoutSupport({})
public inline fun Activity.slidingPaneLayoutSupport(init: _SlidingPaneLayoutSupport.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT_SUPPORT) { init() }
}