public fun android.support.v7.widget.RecyclerView.onChildAttachStateChangeListener(init: __RecyclerView_OnChildAttachStateChangeListener.() -> Unit) {
    val listener = __RecyclerView_OnChildAttachStateChangeListener()
    listener.init()
    addOnChildAttachStateChangeListener(listener)
}

public fun android.support.v7.widget.RecyclerView.onScrollListener(init: __RecyclerView_OnScrollListener.() -> Unit) {
    val listener = __RecyclerView_OnScrollListener()
    listener.init()
    addOnScrollListener(listener)
}

public fun android.support.v7.widget.RecyclerView.onItemTouchListener(init: __RecyclerView_OnItemTouchListener.() -> Unit) {
    val listener = __RecyclerView_OnItemTouchListener()
    listener.init()
    addOnItemTouchListener(listener)
}