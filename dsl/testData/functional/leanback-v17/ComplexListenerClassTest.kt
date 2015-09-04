class __BrowseFrameLayoutSupport_OnChildFocusListener : android.support.v17.leanback.widget.BrowseFrameLayout.OnChildFocusListener {
    private var _onRequestFocusInDescendants: ((Int, android.graphics.Rect?) -> Boolean)? = null
    private var _onRequestChildFocus: ((android.view.View?, android.view.View?) -> Unit)? = null

    override fun onRequestFocusInDescendants(p0: Int, p1: android.graphics.Rect?) = _onRequestFocusInDescendants?.invoke(p0, p1) ?: false

    public fun onRequestFocusInDescendants(listener: (Int, android.graphics.Rect?) -> Boolean) {
        _onRequestFocusInDescendants = listener
    }

    override fun onRequestChildFocus(p0: android.view.View?, p1: android.view.View?) {
        _onRequestChildFocus?.invoke(p0, p1)
    }

    public fun onRequestChildFocus(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onRequestChildFocus = listener
    }

}