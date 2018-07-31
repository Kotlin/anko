@file:JvmName("RecyclerviewAndroidxCoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.recyclerview.androidx.coroutines


import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch

fun androidx.recyclerview.widget.RecyclerView.onChildAttachStateChangeListener(
        context: CoroutineContext = UI,
        init: __RecyclerView_OnChildAttachStateChangeListener.() -> Unit
) {
    val listener = __RecyclerView_OnChildAttachStateChangeListener(context)
    listener.init()
    addOnChildAttachStateChangeListener(listener)
}

class __RecyclerView_OnChildAttachStateChangeListener(private val context: CoroutineContext) : androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener {

    private var _onChildViewAttachedToWindow: (suspend CoroutineScope.(android.view.View) -> Unit)? = null
    

    override fun onChildViewAttachedToWindow(p0: android.view.View) {
        val handler = _onChildViewAttachedToWindow ?: return
        launch(context) {
            handler(p0)
        }
    }

    fun onChildViewAttachedToWindow(
            listener: suspend CoroutineScope.(android.view.View) -> Unit
    ) {
        _onChildViewAttachedToWindow = listener
    }

    private var _onChildViewDetachedFromWindow: (suspend CoroutineScope.(android.view.View) -> Unit)? = null
    

    override fun onChildViewDetachedFromWindow(p0: android.view.View) {
        val handler = _onChildViewDetachedFromWindow ?: return
        launch(context) {
            handler(p0)
        }
    }

    fun onChildViewDetachedFromWindow(
            listener: suspend CoroutineScope.(android.view.View) -> Unit
    ) {
        _onChildViewDetachedFromWindow = listener
    }

}fun androidx.recyclerview.widget.RecyclerView.onItemTouchListener(
        context: CoroutineContext = UI,
        init: __RecyclerView_OnItemTouchListener.() -> Unit
) {
    val listener = __RecyclerView_OnItemTouchListener(context)
    listener.init()
    addOnItemTouchListener(listener)
}

class __RecyclerView_OnItemTouchListener(private val context: CoroutineContext) : androidx.recyclerview.widget.RecyclerView.OnItemTouchListener {

    private var _onInterceptTouchEvent: (suspend CoroutineScope.(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Boolean)? = null
    private var _onInterceptTouchEvent_returnValue: Boolean = false

    override fun onInterceptTouchEvent(p0: androidx.recyclerview.widget.RecyclerView, p1: android.view.MotionEvent) : Boolean {
        val returnValue = _onInterceptTouchEvent_returnValue
        val handler = _onInterceptTouchEvent ?: return returnValue
        launch(context) {
            handler(p0, p1)
        }
        return returnValue
    }

    fun onInterceptTouchEvent(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Boolean
    ) {
        _onInterceptTouchEvent = listener
        _onInterceptTouchEvent_returnValue = returnValue
    }

    private var _onTouchEvent: (suspend CoroutineScope.(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Unit)? = null
    

    override fun onTouchEvent(p0: androidx.recyclerview.widget.RecyclerView, p1: android.view.MotionEvent) {
        val handler = _onTouchEvent ?: return
        launch(context) {
            handler(p0, p1)
        }
    }

    fun onTouchEvent(
            listener: suspend CoroutineScope.(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent) -> Unit
    ) {
        _onTouchEvent = listener
    }

    private var _onRequestDisallowInterceptTouchEvent: (suspend CoroutineScope.(Boolean) -> Unit)? = null
    

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
        val handler = _onRequestDisallowInterceptTouchEvent ?: return
        launch(context) {
            handler(p0)
        }
    }

    fun onRequestDisallowInterceptTouchEvent(
            listener: suspend CoroutineScope.(Boolean) -> Unit
    ) {
        _onRequestDisallowInterceptTouchEvent = listener
    }

}