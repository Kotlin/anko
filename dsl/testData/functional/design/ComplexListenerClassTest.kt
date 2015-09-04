class __TabLayoutSupport_OnTabSelectedListener : android.support.design.widget.TabLayout.OnTabSelectedListener {
    private var _onTabSelected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabUnselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabReselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null

    override fun onTabSelected(p0: android.support.design.widget.TabLayout.Tab?) {
        _onTabSelected?.invoke(p0)
    }

    public fun onTabSelected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabSelected = listener
    }

    override fun onTabUnselected(p0: android.support.design.widget.TabLayout.Tab?) {
        _onTabUnselected?.invoke(p0)
    }

    public fun onTabUnselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabUnselected = listener
    }

    override fun onTabReselected(p0: android.support.design.widget.TabLayout.Tab?) {
        _onTabReselected?.invoke(p0)
    }

    public fun onTabReselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabReselected = listener
    }

}