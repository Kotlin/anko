object `$$Anko$Factories$DesignView` {
    val NAVIGATION_MENU_ITEM_VIEW = { ctx: Context -> android.support.design.internal.NavigationMenuItemView(ctx) }
    val NAVIGATION_MENU_VIEW = { ctx: Context -> android.support.design.internal.NavigationMenuView(ctx) }
    val SCRIM_INSETS_FRAME_LAYOUT = { ctx: Context -> android.support.design.internal.ScrimInsetsFrameLayout(ctx) }
    val FLOATING_ACTION_BUTTON = { ctx: Context -> android.support.design.widget.FloatingActionButton(ctx) }
    val NAVIGATION_VIEW = { ctx: Context -> android.support.design.widget.NavigationView(ctx) }
}

inline fun ViewManager.navigationMenuItemView(): android.support.design.internal.NavigationMenuItemView = navigationMenuItemView({})
inline fun ViewManager.navigationMenuItemView(init: android.support.design.internal.NavigationMenuItemView.() -> Unit): android.support.design.internal.NavigationMenuItemView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_ITEM_VIEW) { init() }
}

inline fun ViewManager.navigationMenuView(): android.support.design.internal.NavigationMenuView = navigationMenuView({})
inline fun ViewManager.navigationMenuView(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW) { init() }
}

inline fun Context.navigationMenuView(): android.support.design.internal.NavigationMenuView = navigationMenuView({})
inline fun Context.navigationMenuView(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW) { init() }
}

inline fun Activity.navigationMenuView(): android.support.design.internal.NavigationMenuView = navigationMenuView({})
inline fun Activity.navigationMenuView(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW) { init() }
}

inline fun ViewManager.scrimInsetsFrameLayout(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout({})
inline fun ViewManager.scrimInsetsFrameLayout(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT) { init() }
}

inline fun Context.scrimInsetsFrameLayout(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout({})
inline fun Context.scrimInsetsFrameLayout(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT) { init() }
}

inline fun Activity.scrimInsetsFrameLayout(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayout({})
inline fun Activity.scrimInsetsFrameLayout(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT) { init() }
}

inline fun ViewManager.floatingActionButton(): android.support.design.widget.FloatingActionButton = floatingActionButton({})
inline fun ViewManager.floatingActionButton(init: android.support.design.widget.FloatingActionButton.() -> Unit): android.support.design.widget.FloatingActionButton {
    return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON) { init() }
}

inline fun ViewManager.navigationView(): android.support.design.widget.NavigationView = navigationView({})
inline fun ViewManager.navigationView(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW) { init() }
}

inline fun Context.navigationView(): android.support.design.widget.NavigationView = navigationView({})
inline fun Context.navigationView(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW) { init() }
}

inline fun Activity.navigationView(): android.support.design.widget.NavigationView = navigationView({})
inline fun Activity.navigationView(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW) { init() }
}

object `$$Anko$Factories$DesignViewGroup` {
    val APP_BAR_LAYOUT = { ctx: Context -> _AppBarLayout(ctx) }
    val COLLAPSING_TOOLBAR_LAYOUT = { ctx: Context -> _CollapsingToolbarLayout(ctx) }
    val COORDINATOR_LAYOUT = { ctx: Context -> _CoordinatorLayout(ctx) }
    val TAB_LAYOUT = { ctx: Context -> _TabLayout(ctx) }
    val TEXT_INPUT_LAYOUT = { ctx: Context -> _TextInputLayout(ctx) }
}

inline fun ViewManager.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout({})
inline fun ViewManager.appBarLayout(init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT) { init() }
}

inline fun Context.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout({})
inline fun Context.appBarLayout(init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT) { init() }
}

inline fun Activity.appBarLayout(): android.support.design.widget.AppBarLayout = appBarLayout({})
inline fun Activity.appBarLayout(init: _AppBarLayout.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT) { init() }
}

inline fun ViewManager.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout({})
inline fun ViewManager.collapsingToolbarLayout(init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT) { init() }
}

inline fun Context.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout({})
inline fun Context.collapsingToolbarLayout(init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT) { init() }
}

inline fun Activity.collapsingToolbarLayout(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayout({})
inline fun Activity.collapsingToolbarLayout(init: _CollapsingToolbarLayout.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT) { init() }
}

inline fun ViewManager.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout({})
inline fun ViewManager.coordinatorLayout(init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT) { init() }
}

inline fun Context.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout({})
inline fun Context.coordinatorLayout(init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT) { init() }
}

inline fun Activity.coordinatorLayout(): android.support.design.widget.CoordinatorLayout = coordinatorLayout({})
inline fun Activity.coordinatorLayout(init: _CoordinatorLayout.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT) { init() }
}

inline fun ViewManager.tabLayout(): android.support.design.widget.TabLayout = tabLayout({})
inline fun ViewManager.tabLayout(init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT) { init() }
}

inline fun Context.tabLayout(): android.support.design.widget.TabLayout = tabLayout({})
inline fun Context.tabLayout(init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT) { init() }
}

inline fun Activity.tabLayout(): android.support.design.widget.TabLayout = tabLayout({})
inline fun Activity.tabLayout(init: _TabLayout.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT) { init() }
}

inline fun ViewManager.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout({})
inline fun ViewManager.textInputLayout(init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT) { init() }
}

inline fun Context.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout({})
inline fun Context.textInputLayout(init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT) { init() }
}

inline fun Activity.textInputLayout(): android.support.design.widget.TextInputLayout = textInputLayout({})
inline fun Activity.textInputLayout(init: _TextInputLayout.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT) { init() }
}