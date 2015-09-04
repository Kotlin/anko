class __RecyclerViewSupport_OnChildAttachStateChangeListener : android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener {
    private var _onChildViewAttachedToWindow: ((android.view.View?) -> Unit)? = null
    private var _onChildViewDetachedFromWindow: ((android.view.View?) -> Unit)? = null

    override fun onChildViewAttachedToWindow(p0: android.view.View?) {
        _onChildViewAttachedToWindow?.invoke(p0)
    }

    public fun onChildViewAttachedToWindow(listener: (android.view.View?) -> Unit) {
        _onChildViewAttachedToWindow = listener
    }

    override fun onChildViewDetachedFromWindow(p0: android.view.View?) {
        _onChildViewDetachedFromWindow?.invoke(p0)
    }

    public fun onChildViewDetachedFromWindow(listener: (android.view.View?) -> Unit) {
        _onChildViewDetachedFromWindow = listener
    }

}

class __RecyclerViewSupport_OnScrollListener : android.support.v7.widget.RecyclerView.OnScrollListener() {
    private var _onScrollStateChanged: ((android.support.v7.widget.RecyclerView?, Int) -> Unit)? = null
    private var _onScrolled: ((android.support.v7.widget.RecyclerView?, Int, Int) -> Unit)? = null

    override fun onScrollStateChanged(recyclerView: android.support.v7.widget.RecyclerView?, newState: Int) {
        _onScrollStateChanged?.invoke(recyclerView, newState)
    }

    public fun onScrollStateChanged(listener: (android.support.v7.widget.RecyclerView?, Int) -> Unit) {
        _onScrollStateChanged = listener
    }

    override fun onScrolled(recyclerView: android.support.v7.widget.RecyclerView?, dx: Int, dy: Int) {
        _onScrolled?.invoke(recyclerView, dx, dy)
    }

    public fun onScrolled(listener: (android.support.v7.widget.RecyclerView?, Int, Int) -> Unit) {
        _onScrolled = listener
    }

}

class __RecyclerViewSupport_OnItemTouchListener : android.support.v7.widget.RecyclerView.OnItemTouchListener {
    private var _onInterceptTouchEvent: ((android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean)? = null
    private var _onTouchEvent: ((android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onRequestDisallowInterceptTouchEvent: ((Boolean) -> Unit)? = null

    override fun onInterceptTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) = _onInterceptTouchEvent?.invoke(rv, e) ?: false

    public fun onInterceptTouchEvent(listener: (android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean) {
        _onInterceptTouchEvent = listener
    }

    override fun onTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) {
        _onTouchEvent?.invoke(rv, e)
    }

    public fun onTouchEvent(listener: (android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit) {
        _onTouchEvent = listener
    }

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
        _onRequestDisallowInterceptTouchEvent?.invoke(p0)
    }

    public fun onRequestDisallowInterceptTouchEvent(listener: (Boolean) -> Unit) {
        _onRequestDisallowInterceptTouchEvent = listener
    }

}