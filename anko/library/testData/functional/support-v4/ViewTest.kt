object `$$Anko$Factories$SupportV4View` {
    val PAGER_TAB_STRIP = { ctx: Context -> android.support.v4.view.PagerTabStrip(ctx) }
    val PAGER_TITLE_STRIP = { ctx: Context -> android.support.v4.view.PagerTitleStrip(ctx) }
    val CONTENT_LOADING_PROGRESS_BAR = { ctx: Context -> android.support.v4.widget.ContentLoadingProgressBar(ctx) }
    val SPACE = { ctx: Context -> android.support.v4.widget.Space(ctx) }
    val SWIPE_REFRESH_LAYOUT = { ctx: Context -> android.support.v4.widget.SwipeRefreshLayout(ctx) }
}

inline fun ViewManager.pagerTabStrip(): android.support.v4.view.PagerTabStrip = pagerTabStrip({})
inline fun ViewManager.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP) { init() }
}

inline fun Context.pagerTabStrip(): android.support.v4.view.PagerTabStrip = pagerTabStrip({})
inline fun Context.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP) { init() }
}

inline fun Activity.pagerTabStrip(): android.support.v4.view.PagerTabStrip = pagerTabStrip({})
inline fun Activity.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP) { init() }
}

inline fun ViewManager.pagerTitleStrip(): android.support.v4.view.PagerTitleStrip = pagerTitleStrip({})
inline fun ViewManager.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP) { init() }
}

inline fun Context.pagerTitleStrip(): android.support.v4.view.PagerTitleStrip = pagerTitleStrip({})
inline fun Context.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP) { init() }
}

inline fun Activity.pagerTitleStrip(): android.support.v4.view.PagerTitleStrip = pagerTitleStrip({})
inline fun Activity.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP) { init() }
}

inline fun ViewManager.contentLoadingProgressBar(): android.support.v4.widget.ContentLoadingProgressBar = contentLoadingProgressBar({})
inline fun ViewManager.contentLoadingProgressBar(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit): android.support.v4.widget.ContentLoadingProgressBar {
    return ankoView(`$$Anko$Factories$SupportV4View`.CONTENT_LOADING_PROGRESS_BAR) { init() }
}

inline fun ViewManager.space(): android.support.v4.widget.Space = space({})
inline fun ViewManager.space(init: android.support.v4.widget.Space.() -> Unit): android.support.v4.widget.Space {
    return ankoView(`$$Anko$Factories$SupportV4View`.SPACE) { init() }
}

inline fun ViewManager.swipeRefreshLayout(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout({})
inline fun ViewManager.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT) { init() }
}

inline fun Context.swipeRefreshLayout(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout({})
inline fun Context.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT) { init() }
}

inline fun Activity.swipeRefreshLayout(): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout({})
inline fun Activity.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT) { init() }
}

object `$$Anko$Factories$SupportV4ViewGroup` {
    val FRAGMENT_TAB_HOST = { ctx: Context -> _FragmentTabHost(ctx) }
    val VIEW_PAGER = { ctx: Context -> _ViewPager(ctx) }
    val DRAWER_LAYOUT = { ctx: Context -> _DrawerLayout(ctx) }
    val NESTED_SCROLL_VIEW = { ctx: Context -> _NestedScrollView(ctx) }
    val SLIDING_PANE_LAYOUT = { ctx: Context -> _SlidingPaneLayout(ctx) }
}

inline fun ViewManager.fragmentTabHost(): android.support.v4.app.FragmentTabHost = fragmentTabHost({})
inline fun ViewManager.fragmentTabHost(init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST) { init() }
}

inline fun Context.fragmentTabHost(): android.support.v4.app.FragmentTabHost = fragmentTabHost({})
inline fun Context.fragmentTabHost(init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST) { init() }
}

inline fun Activity.fragmentTabHost(): android.support.v4.app.FragmentTabHost = fragmentTabHost({})
inline fun Activity.fragmentTabHost(init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST) { init() }
}

inline fun ViewManager.viewPager(): android.support.v4.view.ViewPager = viewPager({})
inline fun ViewManager.viewPager(init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER) { init() }
}

inline fun Context.viewPager(): android.support.v4.view.ViewPager = viewPager({})
inline fun Context.viewPager(init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER) { init() }
}

inline fun Activity.viewPager(): android.support.v4.view.ViewPager = viewPager({})
inline fun Activity.viewPager(init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER) { init() }
}

inline fun ViewManager.drawerLayout(): android.support.v4.widget.DrawerLayout = drawerLayout({})
inline fun ViewManager.drawerLayout(init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT) { init() }
}

inline fun Context.drawerLayout(): android.support.v4.widget.DrawerLayout = drawerLayout({})
inline fun Context.drawerLayout(init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT) { init() }
}

inline fun Activity.drawerLayout(): android.support.v4.widget.DrawerLayout = drawerLayout({})
inline fun Activity.drawerLayout(init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT) { init() }
}

inline fun ViewManager.nestedScrollView(): android.support.v4.widget.NestedScrollView = nestedScrollView({})
inline fun ViewManager.nestedScrollView(init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW) { init() }
}

inline fun Context.nestedScrollView(): android.support.v4.widget.NestedScrollView = nestedScrollView({})
inline fun Context.nestedScrollView(init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW) { init() }
}

inline fun Activity.nestedScrollView(): android.support.v4.widget.NestedScrollView = nestedScrollView({})
inline fun Activity.nestedScrollView(init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW) { init() }
}

inline fun ViewManager.slidingPaneLayout(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout({})
inline fun ViewManager.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT) { init() }
}

inline fun Context.slidingPaneLayout(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout({})
inline fun Context.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT) { init() }
}

inline fun Activity.slidingPaneLayout(): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout({})
inline fun Activity.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT) { init() }
}