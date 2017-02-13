@file:JvmName("DesignViewsKt")
package org.jetbrains.anko.design

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
internal object `$$Anko$Factories$DesignView` {
    val BASELINE_LAYOUT = { ctx: Context -> android.support.design.internal.BaselineLayout(ctx) }
    val SCRIM_INSETS_FRAME_LAYOUT = { ctx: Context -> android.support.design.internal.ScrimInsetsFrameLayout(ctx) }
    val SNACKBAR_CONTENT_LAYOUT = { ctx: Context -> android.support.design.internal.SnackbarContentLayout(ctx) }
    val FLOATING_ACTION_BUTTON = { ctx: Context -> android.support.design.widget.FloatingActionButton(ctx) }
    val NAVIGATION_VIEW = { ctx: Context -> android.support.design.widget.NavigationView(ctx) }
    val TAB_ITEM = { ctx: Context -> android.support.design.widget.TabItem(ctx) }
}

inline fun ViewManager.baselineLayout(theme: Int = 0): android.support.design.internal.BaselineLayout = baselineLayout(theme) {}
inline fun ViewManager.baselineLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.BaselineLayout).() -> Unit): android.support.design.internal.BaselineLayout {
    return ankoView(`$$Anko$Factories$DesignView`.BASELINE_LAYOUT, theme) { init() }
}

inline fun Context.baselineLayout(theme: Int = 0): android.support.design.internal.BaselineLayout = baselineLayout(theme) {}
inline fun Context.baselineLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.BaselineLayout).() -> Unit): android.support.design.internal.BaselineLayout {
    return ankoView(`$$Anko$Factories$DesignView`.BASELINE_LAYOUT, theme) { init() }
}

inline fun Activity.baselineLayout(theme: Int = 0): android.support.design.internal.BaselineLayout = baselineLayout(theme) {}
inline fun Activity.baselineLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.BaselineLayout).() -> Unit): android.support.design.internal.BaselineLayout {
    return ankoView(`$$Anko$Factories$DesignView`.BASELINE_LAYOUT, theme) { init() }
}

inline fun ViewManager.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun ViewManager.scrimInsetsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.ScrimInsetsFrameLayout).() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun Context.scrimInsetsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.ScrimInsetsFrameLayout).() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun Activity.scrimInsetsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.ScrimInsetsFrameLayout).() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.snackbarContentLayout(theme: Int = 0): android.support.design.internal.SnackbarContentLayout = snackbarContentLayout(theme) {}
inline fun ViewManager.snackbarContentLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.SnackbarContentLayout).() -> Unit): android.support.design.internal.SnackbarContentLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SNACKBAR_CONTENT_LAYOUT, theme) { init() }
}

inline fun Context.snackbarContentLayout(theme: Int = 0): android.support.design.internal.SnackbarContentLayout = snackbarContentLayout(theme) {}
inline fun Context.snackbarContentLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.SnackbarContentLayout).() -> Unit): android.support.design.internal.SnackbarContentLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SNACKBAR_CONTENT_LAYOUT, theme) { init() }
}

inline fun Activity.snackbarContentLayout(theme: Int = 0): android.support.design.internal.SnackbarContentLayout = snackbarContentLayout(theme) {}
inline fun Activity.snackbarContentLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.internal.SnackbarContentLayout).() -> Unit): android.support.design.internal.SnackbarContentLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SNACKBAR_CONTENT_LAYOUT, theme) { init() }
}

inline fun ViewManager.floatingActionButton(theme: Int = 0): android.support.design.widget.FloatingActionButton = floatingActionButton(theme) {}
inline fun ViewManager.floatingActionButton(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit): android.support.design.widget.FloatingActionButton {
    return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON, theme) { init() }
}

inline fun ViewManager.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun ViewManager.navigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Context.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun Context.navigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Activity.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun Activity.navigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun ViewManager.tabItem(theme: Int = 0): android.support.design.widget.TabItem = tabItem(theme) {}
inline fun ViewManager.tabItem(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.TabItem).() -> Unit): android.support.design.widget.TabItem {
    return ankoView(`$$Anko$Factories$DesignView`.TAB_ITEM, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$DesignViewGroup` {
    val BOTTOM_NAVIGATION_ITEM_VIEW = { ctx: Context -> _BottomNavigationItemView(ctx) }
    val BOTTOM_NAVIGATION_MENU_VIEW = { ctx: Context -> _BottomNavigationMenuView(ctx) }
    val APP_BAR_LAYOUT = { ctx: Context -> _AppBarLayout(ctx) }
    val BOTTOM_NAVIGATION_VIEW = { ctx: Context -> _BottomNavigationView(ctx) }
    val COLLAPSING_TOOLBAR_LAYOUT = { ctx: Context -> _CollapsingToolbarLayout(ctx) }
    val COORDINATOR_LAYOUT = { ctx: Context -> _CoordinatorLayout(ctx) }
    val TAB_LAYOUT = { ctx: Context -> _TabLayout(ctx) }
    val TEXT_INPUT_LAYOUT = { ctx: Context -> _TextInputLayout(ctx) }
}

inline fun ViewManager.bottomNavigationItemView(theme: Int = 0): android.support.design.internal.BottomNavigationItemView = bottomNavigationItemView(theme) {}
inline fun ViewManager.bottomNavigationItemView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationItemView).() -> Unit): android.support.design.internal.BottomNavigationItemView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_ITEM_VIEW, theme) { init() }
}

inline fun Context.bottomNavigationItemView(theme: Int = 0): android.support.design.internal.BottomNavigationItemView = bottomNavigationItemView(theme) {}
inline fun Context.bottomNavigationItemView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationItemView).() -> Unit): android.support.design.internal.BottomNavigationItemView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_ITEM_VIEW, theme) { init() }
}

inline fun Activity.bottomNavigationItemView(theme: Int = 0): android.support.design.internal.BottomNavigationItemView = bottomNavigationItemView(theme) {}
inline fun Activity.bottomNavigationItemView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationItemView).() -> Unit): android.support.design.internal.BottomNavigationItemView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_ITEM_VIEW, theme) { init() }
}

inline fun ViewManager.bottomNavigationMenuView(theme: Int = 0): android.support.design.internal.BottomNavigationMenuView = bottomNavigationMenuView(theme) {}
inline fun ViewManager.bottomNavigationMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationMenuView).() -> Unit): android.support.design.internal.BottomNavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun Context.bottomNavigationMenuView(theme: Int = 0): android.support.design.internal.BottomNavigationMenuView = bottomNavigationMenuView(theme) {}
inline fun Context.bottomNavigationMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationMenuView).() -> Unit): android.support.design.internal.BottomNavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun Activity.bottomNavigationMenuView(theme: Int = 0): android.support.design.internal.BottomNavigationMenuView = bottomNavigationMenuView(theme) {}
inline fun Activity.bottomNavigationMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationMenuView).() -> Unit): android.support.design.internal.BottomNavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun ViewManager.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun ViewManager.appBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Context.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun Context.appBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Activity.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun Activity.appBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.bottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = bottomNavigationView(theme) {}
inline fun ViewManager.bottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun Context.bottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = bottomNavigationView(theme) {}
inline fun Context.bottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun Activity.bottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = bottomNavigationView(theme) {}
inline fun Activity.bottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun ViewManager.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun ViewManager.collapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Context.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun Context.collapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Activity.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun Activity.collapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun ViewManager.coordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Context.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun Context.coordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Activity.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun Activity.coordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun ViewManager.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun ViewManager.tabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Context.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun Context.tabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Activity.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun Activity.tabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun ViewManager.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun ViewManager.textInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Context.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun Context.textInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Activity.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun Activity.textInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

