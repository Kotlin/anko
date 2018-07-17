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
    val FLOATING_ACTION_BUTTON = { ctx: Context -> android.support.design.widget.FloatingActionButton(ctx) }
    val NAVIGATION_VIEW = { ctx: Context -> android.support.design.widget.NavigationView(ctx) }
    val TAB_ITEM = { ctx: Context -> android.support.design.widget.TabItem(ctx) }
    val TEXT_INPUT_EDIT_TEXT = { ctx: Context -> android.support.design.widget.TextInputEditText(ctx) }
}

inline fun ViewManager.floatingActionButton(): android.support.design.widget.FloatingActionButton = floatingActionButton() {}
inline fun ViewManager.floatingActionButton(init: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit): android.support.design.widget.FloatingActionButton {
    return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedFloatingActionButton(theme: Int = 0): android.support.design.widget.FloatingActionButton = themedFloatingActionButton(theme) {}
inline fun ViewManager.themedFloatingActionButton(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit): android.support.design.widget.FloatingActionButton {
return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON, theme) { init() }
}

inline fun ViewManager.navigationView(): android.support.design.widget.NavigationView = navigationView() {}
inline fun ViewManager.navigationView(init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedNavigationView(theme: Int = 0): android.support.design.widget.NavigationView = themedNavigationView(theme) {}
inline fun ViewManager.themedNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Context.navigationView(): android.support.design.widget.NavigationView = navigationView() {}
inline fun Context.navigationView(init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun Context.themedNavigationView(theme: Int = 0): android.support.design.widget.NavigationView = themedNavigationView(theme) {}
inline fun Context.themedNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun Activity.navigationView(): android.support.design.widget.NavigationView = navigationView() {}
inline fun Activity.navigationView(init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun Activity.themedNavigationView(theme: Int = 0): android.support.design.widget.NavigationView = themedNavigationView(theme) {}
inline fun Activity.themedNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit): android.support.design.widget.NavigationView {
return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW, theme) { init() }
}

inline fun ViewManager.tabItem(): android.support.design.widget.TabItem = tabItem() {}
inline fun ViewManager.tabItem(init: (@AnkoViewDslMarker android.support.design.widget.TabItem).() -> Unit): android.support.design.widget.TabItem {
    return ankoView(`$$Anko$Factories$DesignView`.TAB_ITEM, theme = 0) { init() }
}

inline fun ViewManager.themedTabItem(theme: Int = 0): android.support.design.widget.TabItem = themedTabItem(theme) {}
inline fun ViewManager.themedTabItem(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.TabItem).() -> Unit): android.support.design.widget.TabItem {
return ankoView(`$$Anko$Factories$DesignView`.TAB_ITEM, theme) { init() }
}

inline fun ViewManager.textInputEditText(): android.support.design.widget.TextInputEditText = textInputEditText() {}
inline fun ViewManager.textInputEditText(init: (@AnkoViewDslMarker android.support.design.widget.TextInputEditText).() -> Unit): android.support.design.widget.TextInputEditText {
    return ankoView(`$$Anko$Factories$DesignView`.TEXT_INPUT_EDIT_TEXT, theme = 0) { init() }
}

inline fun ViewManager.themedTextInputEditText(theme: Int = 0): android.support.design.widget.TextInputEditText = themedTextInputEditText(theme) {}
inline fun ViewManager.themedTextInputEditText(theme: Int = 0, init: (@AnkoViewDslMarker android.support.design.widget.TextInputEditText).() -> Unit): android.support.design.widget.TextInputEditText {
return ankoView(`$$Anko$Factories$DesignView`.TEXT_INPUT_EDIT_TEXT, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$DesignViewGroup` {
    val APP_BAR_LAYOUT = { ctx: Context -> _AppBarLayout(ctx) }
    val BOTTOM_NAVIGATION_VIEW = { ctx: Context -> _BottomNavigationView(ctx) }
    val COLLAPSING_TOOLBAR_LAYOUT = { ctx: Context -> _CollapsingToolbarLayout(ctx) }
    val COORDINATOR_LAYOUT = { ctx: Context -> _CoordinatorLayout(ctx) }
    val TAB_LAYOUT = { ctx: Context -> _TabLayout(ctx) }
    val TEXT_INPUT_LAYOUT = { ctx: Context -> _TextInputLayout(ctx) }
}

inline fun ViewManager.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout() {}
inline fun ViewManager.appBarLayout(init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedAppBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = themedAppBarLayout(theme) {}
inline fun ViewManager.themedAppBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Context.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout() {}
inline fun Context.appBarLayout(init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedAppBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = themedAppBarLayout(theme) {}
inline fun Context.themedAppBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun Activity.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout() {}
inline fun Activity.appBarLayout(init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedAppBarLayout(theme: Int = 0): android.support.design.widget.AppBarLayout = themedAppBarLayout(theme) {}
inline fun Activity.themedAppBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AppBarLayout).() -> Unit): android.support.design.widget.AppBarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.bottomNavigationView(): android.support.design.widget.BottomNavigationView = bottomNavigationView() {}
inline fun ViewManager.bottomNavigationView(init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedBottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = themedBottomNavigationView(theme) {}
inline fun ViewManager.themedBottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun Context.bottomNavigationView(): android.support.design.widget.BottomNavigationView = bottomNavigationView() {}
inline fun Context.bottomNavigationView(init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun Context.themedBottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = themedBottomNavigationView(theme) {}
inline fun Context.themedBottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun Activity.bottomNavigationView(): android.support.design.widget.BottomNavigationView = bottomNavigationView() {}
inline fun Activity.bottomNavigationView(init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme = 0) { init() }
}

inline fun Activity.themedBottomNavigationView(theme: Int = 0): android.support.design.widget.BottomNavigationView = themedBottomNavigationView(theme) {}
inline fun Activity.themedBottomNavigationView(theme: Int = 0, init: (@AnkoViewDslMarker _BottomNavigationView).() -> Unit): android.support.design.widget.BottomNavigationView {
return ankoView(`$$Anko$Factories$DesignViewGroup`.BOTTOM_NAVIGATION_VIEW, theme) { init() }
}

inline fun ViewManager.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout() {}
inline fun ViewManager.collapsingToolbarLayout(init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedCollapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = themedCollapsingToolbarLayout(theme) {}
inline fun ViewManager.themedCollapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Context.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout() {}
inline fun Context.collapsingToolbarLayout(init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedCollapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = themedCollapsingToolbarLayout(theme) {}
inline fun Context.themedCollapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun Activity.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout() {}
inline fun Activity.collapsingToolbarLayout(init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedCollapsingToolbarLayout(theme: Int = 0): android.support.design.widget.CollapsingToolbarLayout = themedCollapsingToolbarLayout(theme) {}
inline fun Activity.themedCollapsingToolbarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CollapsingToolbarLayout).() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout() {}
inline fun ViewManager.coordinatorLayout(init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedCoordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = themedCoordinatorLayout(theme) {}
inline fun ViewManager.themedCoordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Context.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout() {}
inline fun Context.coordinatorLayout(init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedCoordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = themedCoordinatorLayout(theme) {}
inline fun Context.themedCoordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun Activity.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout() {}
inline fun Activity.coordinatorLayout(init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedCoordinatorLayout(theme: Int = 0): android.support.design.widget.CoordinatorLayout = themedCoordinatorLayout(theme) {}
inline fun Activity.themedCoordinatorLayout(theme: Int = 0, init: (@AnkoViewDslMarker _CoordinatorLayout).() -> Unit): android.support.design.widget.CoordinatorLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT, theme) { init() }
}

inline fun ViewManager.tabLayout(): android.support.design.widget.TabLayout = tabLayout() {}
inline fun ViewManager.tabLayout(init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedTabLayout(theme: Int = 0): android.support.design.widget.TabLayout = themedTabLayout(theme) {}
inline fun ViewManager.themedTabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Context.tabLayout(): android.support.design.widget.TabLayout = tabLayout() {}
inline fun Context.tabLayout(init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedTabLayout(theme: Int = 0): android.support.design.widget.TabLayout = themedTabLayout(theme) {}
inline fun Context.themedTabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun Activity.tabLayout(): android.support.design.widget.TabLayout = tabLayout() {}
inline fun Activity.tabLayout(init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedTabLayout(theme: Int = 0): android.support.design.widget.TabLayout = themedTabLayout(theme) {}
inline fun Activity.themedTabLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TabLayout).() -> Unit): android.support.design.widget.TabLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT, theme) { init() }
}

inline fun ViewManager.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout() {}
inline fun ViewManager.textInputLayout(init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedTextInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = themedTextInputLayout(theme) {}
inline fun ViewManager.themedTextInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Context.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout() {}
inline fun Context.textInputLayout(init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedTextInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = themedTextInputLayout(theme) {}
inline fun Context.themedTextInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

inline fun Activity.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout() {}
inline fun Activity.textInputLayout(init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedTextInputLayout(theme: Int = 0): android.support.design.widget.TextInputLayout = themedTextInputLayout(theme) {}
inline fun Activity.themedTextInputLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TextInputLayout).() -> Unit): android.support.design.widget.TextInputLayout {
return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT, theme) { init() }
}

