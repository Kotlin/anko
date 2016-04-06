fun android.support.design.widget.CoordinatorLayout.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

fun android.support.design.widget.TabLayout.onTabSelectedListener(init: __TabLayout_OnTabSelectedListener.() -> Unit) {
    val listener = __TabLayout_OnTabSelectedListener()
    listener.init()
    setOnTabSelectedListener(listener)
}