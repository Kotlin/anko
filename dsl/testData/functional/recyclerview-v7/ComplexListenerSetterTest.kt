public fun android.support.v7.widget.RecyclerView.onChildAttachStateChangeListener(init: __RecyclerViewSupport_OnChildAttachStateChangeListener.() -> Unit) {
    val listener = __RecyclerViewSupport_OnChildAttachStateChangeListener()
    listener.init()
    addOnChildAttachStateChangeListener(listener)
}

public fun android.support.v7.widget.RecyclerView.onScrollListener(init: __RecyclerViewSupport_OnScrollListener.() -> Unit) {
    val listener = __RecyclerViewSupport_OnScrollListener()
    listener.init()
    addOnScrollListener(listener)
}

public fun android.support.v7.widget.RecyclerView.onItemTouchListener(init: __RecyclerViewSupport_OnItemTouchListener.() -> Unit) {
    val listener = __RecyclerViewSupport_OnItemTouchListener()
    listener.init()
    addOnItemTouchListener(listener)
}