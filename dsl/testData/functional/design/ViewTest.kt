public object `$$Anko$Factories$DesignView` {
    public val NAVIGATION_MENU_ITEM_VIEW_SUPPORT = { ctx: Context -> android.support.design.internal.NavigationMenuItemView(ctx) }
    public val NAVIGATION_MENU_VIEW_SUPPORT = { ctx: Context -> android.support.design.internal.NavigationMenuView(ctx) }
    public val SCRIM_INSETS_FRAME_LAYOUT_SUPPORT = { ctx: Context -> android.support.design.internal.ScrimInsetsFrameLayout(ctx) }
    public val FLOATING_ACTION_BUTTON_SUPPORT = { ctx: Context -> android.support.design.widget.FloatingActionButton(ctx) }
    public val NAVIGATION_VIEW_SUPPORT = { ctx: Context -> android.support.design.widget.NavigationView(ctx) }
}

public inline fun ViewManager.navigationMenuItemViewSupport(): android.support.design.internal.NavigationMenuItemView = navigationMenuItemViewSupport({})
public inline fun ViewManager.navigationMenuItemViewSupport(init: android.support.design.internal.NavigationMenuItemView.() -> Unit): android.support.design.internal.NavigationMenuItemView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_ITEM_VIEW_SUPPORT) { init() }
}

public inline fun ViewManager.navigationMenuViewSupport(): android.support.design.internal.NavigationMenuView = navigationMenuViewSupport({})
public inline fun ViewManager.navigationMenuViewSupport(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW_SUPPORT) { init() }
}

public inline fun Context.navigationMenuViewSupport(): android.support.design.internal.NavigationMenuView = navigationMenuViewSupport({})
public inline fun Context.navigationMenuViewSupport(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW_SUPPORT) { init() }
}

public inline fun Activity.navigationMenuViewSupport(): android.support.design.internal.NavigationMenuView = navigationMenuViewSupport({})
public inline fun Activity.navigationMenuViewSupport(init: android.support.design.internal.NavigationMenuView.() -> Unit): android.support.design.internal.NavigationMenuView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_MENU_VIEW_SUPPORT) { init() }
}

public inline fun ViewManager.scrimInsetsFrameLayoutSupport(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayoutSupport({})
public inline fun ViewManager.scrimInsetsFrameLayoutSupport(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.scrimInsetsFrameLayoutSupport(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayoutSupport({})
public inline fun Context.scrimInsetsFrameLayoutSupport(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.scrimInsetsFrameLayoutSupport(): android.support.design.internal.ScrimInsetsFrameLayout = scrimInsetsFrameLayoutSupport({})
public inline fun Activity.scrimInsetsFrameLayoutSupport(init: android.support.design.internal.ScrimInsetsFrameLayout.() -> Unit): android.support.design.internal.ScrimInsetsFrameLayout {
    return ankoView(`$$Anko$Factories$DesignView`.SCRIM_INSETS_FRAME_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.floatingActionButtonSupport(): android.support.design.widget.FloatingActionButton = floatingActionButtonSupport({})
public inline fun ViewManager.floatingActionButtonSupport(init: android.support.design.widget.FloatingActionButton.() -> Unit): android.support.design.widget.FloatingActionButton {
    return ankoView(`$$Anko$Factories$DesignView`.FLOATING_ACTION_BUTTON_SUPPORT) { init() }
}

public inline fun ViewManager.navigationViewSupport(): android.support.design.widget.NavigationView = navigationViewSupport({})
public inline fun ViewManager.navigationViewSupport(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW_SUPPORT) { init() }
}

public inline fun Context.navigationViewSupport(): android.support.design.widget.NavigationView = navigationViewSupport({})
public inline fun Context.navigationViewSupport(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW_SUPPORT) { init() }
}

public inline fun Activity.navigationViewSupport(): android.support.design.widget.NavigationView = navigationViewSupport({})
public inline fun Activity.navigationViewSupport(init: android.support.design.widget.NavigationView.() -> Unit): android.support.design.widget.NavigationView {
    return ankoView(`$$Anko$Factories$DesignView`.NAVIGATION_VIEW_SUPPORT) { init() }
}

public object `$$Anko$Factories$DesignViewGroup` {
    public val APP_BAR_LAYOUT_SUPPORT = { ctx: Context -> _AppBarLayoutSupport(ctx) }
    public val COLLAPSING_TOOLBAR_LAYOUT_SUPPORT = { ctx: Context -> _CollapsingToolbarLayoutSupport(ctx) }
    public val COORDINATOR_LAYOUT_SUPPORT = { ctx: Context -> _CoordinatorLayoutSupport(ctx) }
    public val TAB_LAYOUT_SUPPORT = { ctx: Context -> _TabLayoutSupport(ctx) }
    public val TEXT_INPUT_LAYOUT_SUPPORT = { ctx: Context -> _TextInputLayoutSupport(ctx) }
}

public inline fun ViewManager.appBarLayoutSupport(): android.support.design.widget.AppBarLayout = appBarLayoutSupport({})
public inline fun ViewManager.appBarLayoutSupport(init: _AppBarLayoutSupport.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.appBarLayoutSupport(): android.support.design.widget.AppBarLayout = appBarLayoutSupport({})
public inline fun Context.appBarLayoutSupport(init: _AppBarLayoutSupport.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.appBarLayoutSupport(): android.support.design.widget.AppBarLayout = appBarLayoutSupport({})
public inline fun Activity.appBarLayoutSupport(init: _AppBarLayoutSupport.() -> Unit): android.support.design.widget.AppBarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.APP_BAR_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.collapsingToolbarLayoutSupport(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayoutSupport({})
public inline fun ViewManager.collapsingToolbarLayoutSupport(init: _CollapsingToolbarLayoutSupport.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.collapsingToolbarLayoutSupport(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayoutSupport({})
public inline fun Context.collapsingToolbarLayoutSupport(init: _CollapsingToolbarLayoutSupport.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.collapsingToolbarLayoutSupport(): android.support.design.widget.CollapsingToolbarLayout = collapsingToolbarLayoutSupport({})
public inline fun Activity.collapsingToolbarLayoutSupport(init: _CollapsingToolbarLayoutSupport.() -> Unit): android.support.design.widget.CollapsingToolbarLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COLLAPSING_TOOLBAR_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.coordinatorLayoutSupport(): android.support.design.widget.CoordinatorLayout = coordinatorLayoutSupport({})
public inline fun ViewManager.coordinatorLayoutSupport(init: _CoordinatorLayoutSupport.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.coordinatorLayoutSupport(): android.support.design.widget.CoordinatorLayout = coordinatorLayoutSupport({})
public inline fun Context.coordinatorLayoutSupport(init: _CoordinatorLayoutSupport.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.coordinatorLayoutSupport(): android.support.design.widget.CoordinatorLayout = coordinatorLayoutSupport({})
public inline fun Activity.coordinatorLayoutSupport(init: _CoordinatorLayoutSupport.() -> Unit): android.support.design.widget.CoordinatorLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.COORDINATOR_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.tabLayoutSupport(): android.support.design.widget.TabLayout = tabLayoutSupport({})
public inline fun ViewManager.tabLayoutSupport(init: _TabLayoutSupport.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.tabLayoutSupport(): android.support.design.widget.TabLayout = tabLayoutSupport({})
public inline fun Context.tabLayoutSupport(init: _TabLayoutSupport.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.tabLayoutSupport(): android.support.design.widget.TabLayout = tabLayoutSupport({})
public inline fun Activity.tabLayoutSupport(init: _TabLayoutSupport.() -> Unit): android.support.design.widget.TabLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TAB_LAYOUT_SUPPORT) { init() }
}

public inline fun ViewManager.textInputLayoutSupport(): android.support.design.widget.TextInputLayout = textInputLayoutSupport({})
public inline fun ViewManager.textInputLayoutSupport(init: _TextInputLayoutSupport.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT_SUPPORT) { init() }
}

public inline fun Context.textInputLayoutSupport(): android.support.design.widget.TextInputLayout = textInputLayoutSupport({})
public inline fun Context.textInputLayoutSupport(init: _TextInputLayoutSupport.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT_SUPPORT) { init() }
}

public inline fun Activity.textInputLayoutSupport(): android.support.design.widget.TextInputLayout = textInputLayoutSupport({})
public inline fun Activity.textInputLayoutSupport(init: _TextInputLayoutSupport.() -> Unit): android.support.design.widget.TextInputLayout {
    return ankoView(`$$Anko$Factories$DesignViewGroup`.TEXT_INPUT_LAYOUT_SUPPORT) { init() }
}