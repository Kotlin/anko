@file:JvmName("SupportCoreUiViewsKt")
package org.jetbrains.anko.support.core.ui

import org.jetbrains.anko.custom.*
import org.jetbrains.anko.AnkoViewDslMarker
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.widget.*

@PublishedApi
internal object `$$Anko$Factories$SupportCoreUiView` {
    val PAGER_TAB_STRIP = { ctx: Context -> android.support.v4.view.PagerTabStrip(ctx) }
    val CONTENT_LOADING_PROGRESS_BAR = { ctx: Context -> android.support.v4.widget.ContentLoadingProgressBar(ctx) }
    val SPACE = { ctx: Context -> android.support.v4.widget.Space(ctx) }
    val SWIPE_REFRESH_LAYOUT = { ctx: Context -> android.support.v4.widget.SwipeRefreshLayout(ctx) }
}

inline fun ViewManager.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun ViewManager.pagerTabStrip(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.view.PagerTabStrip).() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun Context.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun Context.pagerTabStrip(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.view.PagerTabStrip).() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun Activity.pagerTabStrip(theme: Int = 0): android.support.v4.view.PagerTabStrip = pagerTabStrip(theme) {}
inline fun Activity.pagerTabStrip(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.view.PagerTabStrip).() -> Unit): android.support.v4.view.PagerTabStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.PAGER_TAB_STRIP, theme) { init() }
}

inline fun ViewManager.contentLoadingProgressBar(theme: Int = 0): android.support.v4.widget.ContentLoadingProgressBar = contentLoadingProgressBar(theme) {}
inline fun ViewManager.contentLoadingProgressBar(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.widget.ContentLoadingProgressBar).() -> Unit): android.support.v4.widget.ContentLoadingProgressBar {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.CONTENT_LOADING_PROGRESS_BAR, theme) { init() }
}

inline fun ViewManager.space(theme: Int = 0): android.support.v4.widget.Space = space(theme) {}
inline fun ViewManager.space(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.widget.Space).() -> Unit): android.support.v4.widget.Space {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.SPACE, theme) { init() }
}

inline fun ViewManager.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun ViewManager.swipeRefreshLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.widget.SwipeRefreshLayout).() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

inline fun Context.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun Context.swipeRefreshLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.widget.SwipeRefreshLayout).() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

inline fun Activity.swipeRefreshLayout(theme: Int = 0): android.support.v4.widget.SwipeRefreshLayout = swipeRefreshLayout(theme) {}
inline fun Activity.swipeRefreshLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v4.widget.SwipeRefreshLayout).() -> Unit): android.support.v4.widget.SwipeRefreshLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiView`.SWIPE_REFRESH_LAYOUT, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$SupportCoreUiViewGroup` {
    val PAGER_TITLE_STRIP = { ctx: Context -> _PagerTitleStrip(ctx) }
    val VIEW_PAGER = { ctx: Context -> _ViewPager(ctx) }
    val DRAWER_LAYOUT = { ctx: Context -> _DrawerLayout(ctx) }
    val NESTED_SCROLL_VIEW = { ctx: Context -> _NestedScrollView(ctx) }
    val SLIDING_PANE_LAYOUT = { ctx: Context -> _SlidingPaneLayout(ctx) }
}

inline fun ViewManager.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun ViewManager.pagerTitleStrip(theme: Int = 0, init: (@AnkoViewDslMarker _PagerTitleStrip).() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun Context.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun Context.pagerTitleStrip(theme: Int = 0, init: (@AnkoViewDslMarker _PagerTitleStrip).() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun Activity.pagerTitleStrip(theme: Int = 0): android.support.v4.view.PagerTitleStrip = pagerTitleStrip(theme) {}
inline fun Activity.pagerTitleStrip(theme: Int = 0, init: (@AnkoViewDslMarker _PagerTitleStrip).() -> Unit): android.support.v4.view.PagerTitleStrip {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.PAGER_TITLE_STRIP, theme) { init() }
}

inline fun ViewManager.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun ViewManager.viewPager(theme: Int = 0, init: (@AnkoViewDslMarker _ViewPager).() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun Context.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun Context.viewPager(theme: Int = 0, init: (@AnkoViewDslMarker _ViewPager).() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun Activity.viewPager(theme: Int = 0): android.support.v4.view.ViewPager = viewPager(theme) {}
inline fun Activity.viewPager(theme: Int = 0, init: (@AnkoViewDslMarker _ViewPager).() -> Unit): android.support.v4.view.ViewPager {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.VIEW_PAGER, theme) { init() }
}

inline fun ViewManager.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun ViewManager.drawerLayout(theme: Int = 0, init: (@AnkoViewDslMarker _DrawerLayout).() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun Context.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun Context.drawerLayout(theme: Int = 0, init: (@AnkoViewDslMarker _DrawerLayout).() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun Activity.drawerLayout(theme: Int = 0): android.support.v4.widget.DrawerLayout = drawerLayout(theme) {}
inline fun Activity.drawerLayout(theme: Int = 0, init: (@AnkoViewDslMarker _DrawerLayout).() -> Unit): android.support.v4.widget.DrawerLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.DRAWER_LAYOUT, theme) { init() }
}

inline fun ViewManager.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun ViewManager.nestedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _NestedScrollView).() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun Context.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun Context.nestedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _NestedScrollView).() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun Activity.nestedScrollView(theme: Int = 0): android.support.v4.widget.NestedScrollView = nestedScrollView(theme) {}
inline fun Activity.nestedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _NestedScrollView).() -> Unit): android.support.v4.widget.NestedScrollView {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.NESTED_SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun ViewManager.slidingPaneLayout(theme: Int = 0, init: (@AnkoViewDslMarker _SlidingPaneLayout).() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}

inline fun Context.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun Context.slidingPaneLayout(theme: Int = 0, init: (@AnkoViewDslMarker _SlidingPaneLayout).() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}

inline fun Activity.slidingPaneLayout(theme: Int = 0): android.support.v4.widget.SlidingPaneLayout = slidingPaneLayout(theme) {}
inline fun Activity.slidingPaneLayout(theme: Int = 0, init: (@AnkoViewDslMarker _SlidingPaneLayout).() -> Unit): android.support.v4.widget.SlidingPaneLayout {
    return ankoView(`$$Anko$Factories$SupportCoreUiViewGroup`.SLIDING_PANE_LAYOUT, theme) { init() }
}

