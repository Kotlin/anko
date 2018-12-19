@file:JvmName("RecyclerviewV7CoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.recyclerview.v7.coroutines


import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun android.support.v7.widget.RecyclerView.onChildAttachStateChangeListener(
        context: CoroutineContext = Dispatchers.Main,
        init: __RecyclerView_OnChildAttachStateChangeListener.() -> Unit
) {
    val listener = __RecyclerView_OnChildAttachStateChangeListener(context)
    listener.init()
    addOnChildAttachStateChangeListener(listener)
}

class __RecyclerView_OnChildAttachStateChangeListener(private val context: CoroutineContext) : android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener {

    private var _onChildViewAttachedToWindow: (suspend CoroutineScope.(android.view.View?) -> Unit)? = null
    

    override fun onChildViewAttachedToWindow(view: android.view.View?) {
        val handler = _onChildViewAttachedToWindow ?: return
        GlobalScope.launch(context) {
            handler(view)
        }
    }

    fun onChildViewAttachedToWindow(
            listener: suspend CoroutineScope.(android.view.View?) -> Unit
    ) {
        _onChildViewAttachedToWindow = listener
    }

    private var _onChildViewDetachedFromWindow: (suspend CoroutineScope.(android.view.View?) -> Unit)? = null
    

    override fun onChildViewDetachedFromWindow(view: android.view.View?) {
        val handler = _onChildViewDetachedFromWindow ?: return
        GlobalScope.launch(context) {
            handler(view)
        }
    }

    fun onChildViewDetachedFromWindow(
            listener: suspend CoroutineScope.(android.view.View?) -> Unit
    ) {
        _onChildViewDetachedFromWindow = listener
    }

}fun android.support.v7.widget.RecyclerView.onItemTouchListener(
        context: CoroutineContext = Dispatchers.Main,
        init: __RecyclerView_OnItemTouchListener.() -> Unit
) {
    val listener = __RecyclerView_OnItemTouchListener(context)
    listener.init()
    addOnItemTouchListener(listener)
}

class __RecyclerView_OnItemTouchListener(private val context: CoroutineContext) : android.support.v7.widget.RecyclerView.OnItemTouchListener {

    private var _onInterceptTouchEvent: (suspend CoroutineScope.(android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean)? = null
    private var _onInterceptTouchEvent_returnValue: Boolean = false

    override fun onInterceptTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) : Boolean {
        val returnValue = _onInterceptTouchEvent_returnValue
        val handler = _onInterceptTouchEvent ?: return returnValue
        GlobalScope.launch(context) {
            handler(rv, e)
        }
        return returnValue
    }

    fun onInterceptTouchEvent(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean
    ) {
        _onInterceptTouchEvent = listener
        _onInterceptTouchEvent_returnValue = returnValue
    }

    private var _onTouchEvent: (suspend CoroutineScope.(android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit)? = null
    

    override fun onTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) {
        val handler = _onTouchEvent ?: return
        GlobalScope.launch(context) {
            handler(rv, e)
        }
    }

    fun onTouchEvent(
            listener: suspend CoroutineScope.(android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit
    ) {
        _onTouchEvent = listener
    }

    private var _onRequestDisallowInterceptTouchEvent: (suspend CoroutineScope.(Boolean) -> Unit)? = null
    

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        val handler = _onRequestDisallowInterceptTouchEvent ?: return
        GlobalScope.launch(context) {
            handler(disallowIntercept)
        }
    }

    fun onRequestDisallowInterceptTouchEvent(
            listener: suspend CoroutineScope.(Boolean) -> Unit
    ) {
        _onRequestDisallowInterceptTouchEvent = listener
    }

}