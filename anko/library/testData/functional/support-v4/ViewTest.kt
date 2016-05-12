object `$$Anko$Factories$SupportV4View` {
    val PAGER_TAB_STRIP = { ctx: Context -> android.support.v4.view.PagerTabStrip(ctx) }
    val PAGER_TITLE_STRIP = { ctx: Context -> android.support.v4.view.PagerTitleStrip(ctx) }
    val CONTENT_LOADING_PROGRESS_BAR = { ctx: Context -> android.support.v4.widget.ContentLoadingProgressBar(ctx) }
    val SPACE = { ctx: Context -> android.support.v4.widget.Space(ctx) }
    val SWIPE_REFRESH_LAYOUT = { ctx: Context -> android.support.v4.widget.SwipeRefreshLayout(ctx) }
}

inline fun ViewManager.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun ViewManager.pagerTabStrip(theme: Int = 0, init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun Context.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun Context.pagerTabStrip(theme: Int = 0, init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun Activity.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun Activity.pagerTabStrip(theme: Int = 0, init: android.support.v4.view.PagerTabStrip.() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun ViewManager.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun ViewManager.pagerTitleStrip(theme: Int = 0, init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun Context.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun Context.pagerTitleStrip(theme: Int = 0, init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun Activity.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun Activity.pagerTitleStrip(theme: Int = 0, init: android.support.v4.view.PagerTitleStrip.() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportV4View`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun ViewManager.contentLoadingProgressBar(theme: Int = 0): android.support.v4.widget.ContentLoadingProgressBar = contentLoadingProgressBar(theme) {}
inline fun ViewManager.contentLoadingProgressBar(theme: Int = 0, init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit): android.support.v4.widget.ContentLoadingProgressBar {
    return ankoView(`$$Anko$Factories$SupportV4View`.CONTENT_LOADING_PROGRESS_BAR, theme) { init() }
}

inline fun ViewManager.space(theme: Int = 0): android.support.v4.widget.Space = space(theme) {}
inline fun ViewManager.space(theme: Int = 0, init: android.support.v4.widget.Space.() -> Unit): android.support.v4.widget.Space {
    return ankoView(`$$Anko$Factories$SupportV4View`.SPACE, theme) { init() }
}

inline fun ViewManager.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun ViewManager.swipeRefreshLayout(theme: Int = 0, init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

inline fun Context.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun Context.swipeRefreshLayout(theme: Int = 0, init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

inline fun Activity.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun Activity.swipeRefreshLayout(theme: Int = 0, init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportV4View`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

object `$$Anko$Factories$SupportV4ViewGroup` {
    val FRAGMENT_TAB_HOST = { ctx: Context -> _FragmentTabHost(ctx) }
    val VIEW_PAGER = { ctx: Context -> _ViewPager(ctx) }
    val DRAWER_LAYOUT = { ctx: Context -> _DrawerLayout(ctx) }
    val NESTED_SCROLL_VIEW = { ctx: Context -> _NestedScrollView(ctx) }
    val SLIDING_PANE_LAYOUT = { ctx: Context -> _SlidingPaneLayout(ctx) }
}

inline fun ViewManager.fragmentTabHost(theme: Int = 0): android.support.v4.app.FragmentTabHost = fragmentTabHost(theme) {}
inline fun ViewManager.fragmentTabHost(theme: Int = 0, init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST, theme) { init() }
}

inline fun Context.fragmentTabHost(theme: Int = 0): android.support.v4.app.FragmentTabHost = fragmentTabHost(theme) {}
inline fun Context.fragmentTabHost(theme: Int = 0, init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST, theme) { init() }
}

inline fun Activity.fragmentTabHost(theme: Int = 0): android.support.v4.app.FragmentTabHost = fragmentTabHost(theme) {}
inline fun Activity.fragmentTabHost(theme: Int = 0, init: _FragmentTabHost.() -> Unit): android.support.v4.app.FragmentTabHost {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.FRAGMENT_TAB_HOST, theme) { init() }
}

inline fun ViewManager.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun ViewManager.viewPager(theme: Int = 0, init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun Context.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun Context.viewPager(theme: Int = 0, init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun Activity.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun Activity.viewPager(theme: Int = 0, init: _ViewPager.() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun ViewManager.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun ViewManager.drawerLayout(theme: Int = 0, init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun Context.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun Context.drawerLayout(theme: Int = 0, init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun Activity.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun Activity.drawerLayout(theme: Int = 0, init: _DrawerLayout.() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun ViewManager.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun ViewManager.nestedScrollView(theme: Int = 0, init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun Context.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun Context.nestedScrollView(theme: Int = 0, init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun Activity.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun Activity.nestedScrollView(theme: Int = 0, init: _NestedScrollView.() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun ViewManager.slidingPaneLayout(theme: Int = 0, init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}

inline fun Context.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun Context.slidingPaneLayout(theme: Int = 0, init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}

inline fun Activity.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun Activity.slidingPaneLayout(theme: Int = 0, init: _SlidingPaneLayout.() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportV4ViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}