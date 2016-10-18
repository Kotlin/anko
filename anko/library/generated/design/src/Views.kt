@file:JvmName("DesignViewsKt")
package org.jetbrains.anko.design

import org.jetbrains.anko.custom.*
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.widget.*

object `$$Anko$Factories$DesignView` {
    val NAVIGATION_MENU_ITEM_VIEW = { ctx: Context -> android.support.design.internal.NavigationMenuItemView(ctx) }
    val NAVIGATION_MENU_VIEW = { ctx: Context -> android.support.design.internal.NavigationMenuView(ctx) }
    val SCRIM_INSETS_FRAME_LAYOUT = { ctx: Context -> android.support.design.internal.ScrimInsetsFrameLayout(ctx) }
    val FLOATING_ACTION_BUTTON = { ctx: Context -> android.support.design.widget.FloatingActionButton(ctx) }
    val NAVIGATION_VIEW = { ctx: Context -> android.support.design.widget.NavigationView(ctx) }
}

inline fun ViewManager.navigationMenuItemView(theme: Int = 0): android.support.design.internal.NavigationMenuItemView = navigationMenuItemView(theme) {}
inline fun ViewManager.navigationMenuItemView(theme: Int = 0, init: android.support.design.internal.NavigationMenuItemView.() -> Unit): android.support.design.internal.NavigationMenuItemView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_ITEM_VIEW, theme) { init() }
}

inline fun ViewManager.navigationMenuView(theme: Int = 0): android.support.design.internal.NavigationMenuView = navigationMenuView(theme) {}
inline fun ViewManager.navigationMenuView(theme: Int = 0, init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun Context.navigationMenuView(theme: Int = 0): android.support.design.internal.NavigationMenuView = navigationMenuView(theme) {}
inline fun Context.navigationMenuView(theme: Int = 0, init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun Activity.navigationMenuView(theme: Int = 0): android.support.design.internal.NavigationMenuView = navigationMenuView(theme) {}
inline fun Activity.navigationMenuView(theme: Int = 0, init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW, theme) { init() }
}

inline fun ViewManager.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun ViewManager.scrimInsetsFrameLayout(theme: Int = 0, init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun Context.scrimInsetsFrameLayout(theme: Int = 0, init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.scrimInsetsFrameLayout(theme: Int = 0): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout(theme) {}
inline fun Activity.scrimInsetsFrameLayout(theme: Int = 0, init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.floatingActionButton(theme: Int = 0): android.support.design.widget.FloatingActionButton = floatingActionButton(theme) {}
inline fun ViewManager.floatingActionButton(theme: Int = 0, init: android.support.design.widget.FloatingActionButton.() -> Unit): android.support.design.widget.FloatingActionButton {
    return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON, theme) { init() }
}

inline fun ViewManager.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun ViewManager.navigationView(theme: Int = 0, init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Context.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun Context.navigationView(theme: Int = 0, init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Activity.navigationView(theme: Int = 0): android.support.design.widget.NavigationView = navigationView(theme) {}
inline fun Activity.navigationView(theme: Int = 0, init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

object `$$Anko$Factories$DesignViewGroup` {
    val APP_BAR_LAYOUT = { ctx: Context -> _AppBarLayout(ctx) }
    val COLLAPSING_TOOLBAR_LAYOUT = { ctx: Context -> _CollapsingToolbarLayout(ctx) }
    val COORDINATOR_LAYOUT = { ctx: Context -> _CoordinatorLayout(ctx) }
    val TAB_LAYOUT = { ctx: Context -> _TabLayout(ctx) }
    val TEXT_INPUT_LAYOUT = { ctx: Context -> _TextInputLayout(ctx) }
}

inline fun ViewManager.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun ViewManager.appBarLayout(theme: Int = 0, init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Context.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun Context.appBarLayout(theme: Int = 0, init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Activity.appBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = appBarLayout(theme) {}
inline fun Activity.appBarLayout(theme: Int = 0, init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun ViewManager.collapsingToolbarLayout(theme: Int = 0, init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Context.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun Context.collapsingToolbarLayout(theme: Int = 0, init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Activity.collapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout(theme) {}
inline fun Activity.collapsingToolbarLayout(theme: Int = 0, init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun ViewManager.coordinatorLayout(theme: Int = 0, init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Context.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun Context.coordinatorLayout(theme: Int = 0, init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Activity.coordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = coordinatorLayout(theme) {}
inline fun Activity.coordinatorLayout(theme: Int = 0, init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun ViewManager.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun ViewManager.tabLayout(theme: Int = 0, init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Context.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun Context.tabLayout(theme: Int = 0, init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Activity.tabLayout(theme: Int = 0): android.support.design.widget.TabLayout = tabLayout(theme) {}
inline fun Activity.tabLayout(theme: Int = 0, init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun ViewManager.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun ViewManager.textInputLayout(theme: Int = 0, init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Context.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun Context.textInputLayout(theme: Int = 0, init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Activity.textInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = textInputLayout(theme) {}
inline fun Activity.textInputLayout(theme: Int = 0, init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

