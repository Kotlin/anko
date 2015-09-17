class __ViewGroup_OnHierarchyChangeListener : android.view.ViewGroup.OnHierarchyChangeListener {
    private var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit)? = null
    private var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit)? = null

    override fun onChildViewAdded(parent: android.view.View?, child: android.view.View?) {
        _onChildViewAdded?.invoke(parent, child)
    }

    public fun onChildViewAdded(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewAdded = listener
    }

    override fun onChildViewRemoved(parent: android.view.View?, child: android.view.View?) {
        _onChildViewRemoved?.invoke(parent, child)
    }

    public fun onChildViewRemoved(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewRemoved = listener
    }

}

class __TabLayout_OnTabSelectedListener : android.support.design.widget.TabLayout.OnTabSelectedListener {
    private var _onTabSelected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabUnselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabReselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null

    override fun onTabSelected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabSelected?.invoke(tab)
    }

    public fun onTabSelected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabSelected = listener
    }

    override fun onTabUnselected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabUnselected?.invoke(tab)
    }

    public fun onTabUnselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabUnselected = listener
    }

    override fun onTabReselected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabReselected?.invoke(tab)
    }

    public fun onTabReselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabReselected = listener
    }

}