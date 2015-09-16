public fun android.support.design.widget.CoordinatorLayout.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

public fun android.support.design.widget.TabLayout.onTabSelectedListener(init: __TabLayoutSupport_OnTabSelectedListener.() -> Unit) {
    val listener = __TabLayoutSupport_OnTabSelectedListener()
    listener.init()
    setOnTabSelectedListener(listener)
}