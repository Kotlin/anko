@file:JvmName("RecyclerviewAndroidxListenersListenersKt")
package org.jetbrains.anko.recyclerview.listeners


fun androidx.recyclerview.widget.RecyclerView.onChildAttachStateChangeListener(init: __RecyclerView_OnChildAttachStateChangeListener.() -> Unit) {
    val listener = __RecyclerView_OnChildAttachStateChangeListener()
    listener.init()
    addOnChildAttachStateChangeListener(listener)
}

class __RecyclerView_OnChildAttachStateChangeListener : androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener {

    private var _onChildViewAttachedToWindow: ((android.view.View) -> Unit)? = null

    override fun onChildViewAttachedToWindow(p0: android.view.View) {
        _onChildViewAttachedToWindow?.invoke(p0)
    }

    fun onChildViewAttachedToWindow(listener: (android.view.View) -> Unit) {
        _onChildViewAttachedToWindow = listener
    }

    private var _onChildViewDetachedFromWindow: ((android.view.View) -> Unit)? = null

    override fun onChildViewDetachedFromWindow(p0: android.view.View) {
        _onChildViewDetachedFromWindow?.invoke(p0)
    }

    fun onChildViewDetachedFromWindow(listener: (android.view.View) -> Unit) {
        _onChildViewDetachedFromWindow = listener
    }

}

fun androidx.recyclerview.widget.RecyclerView.onItemTouchListener(init: __RecyclerView_OnItemTouchListener.() -> Unit) {
    val listener = __RecyclerView_OnItemTouchListener()
    listener.init()
    addOnItemTouchListener(listener)
}

class __RecyclerView_OnItemTouchListener : androidx.recyclerview.widget.RecyclerView.OnItemTouchListener {

    private var _onInterceptTouchEvent: ((androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Boolean)? = null

    override fun onInterceptTouchEvent(p0: androidx.recyclerview.widget.RecyclerView, p1: android.view.MotionEvent) = _onInterceptTouchEvent?.invoke(p0, p1) ?: false

    fun onInterceptTouchEvent(listener: (androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Boolean) {
        _onInterceptTouchEvent = listener
    }

    private var _onTouchEvent: ((androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Unit)? = null

    override fun onTouchEvent(p0: androidx.recyclerview.widget.RecyclerView, p1: android.view.MotionEvent) {
        _onTouchEvent?.invoke(p0, p1)
    }

    fun onTouchEvent(listener: (androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Unit) {
        _onTouchEvent = listener
    }

    private var _onRequestDisallowInterceptTouchEvent: ((Boolean) -> Unit)? = null

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
        _onRequestDisallowInterceptTouchEvent?.invoke(p0)
    }

    fun onRequestDisallowInterceptTouchEvent(listener: (Boolean) -> Unit) {
        _onRequestDisallowInterceptTouchEvent = listener
    }

}

