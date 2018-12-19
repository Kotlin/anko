@file:JvmName("AppcompatV7CoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.appcompat.v7.coroutines


import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineStart

fun android.support.v7.widget.ActionMenuView.onMenuItemClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(item)
        }
        returnValue
    }
}

fun android.support.v7.widget.ActivityChooserView.onDismiss(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDismissListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
    }
}

fun android.support.v7.widget.FitWindowsFrameLayout.onFitSystemWindows(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(insets: android.graphics.Rect?) -> Unit
) {
    setOnFitSystemWindowsListener { insets ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(insets)
        }
    }
}

fun android.support.v7.widget.SearchView.onClose(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnCloseListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
        returnValue
    }
}

fun android.support.v7.widget.SearchView.onQueryTextFocusChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnQueryTextFocusChangeListener { v, hasFocus ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, hasFocus)
        }
    }
}

fun android.support.v7.widget.SearchView.onQueryTextListener(
        context: CoroutineContext = Dispatchers.Main,
        init: __SearchView_OnQueryTextListener.() -> Unit
) {
    val listener = __SearchView_OnQueryTextListener(context)
    listener.init()
    setOnQueryTextListener(listener)
}

class __SearchView_OnQueryTextListener(private val context: CoroutineContext) : android.support.v7.widget.SearchView.OnQueryTextListener {

    private var _onQueryTextSubmit: (suspend CoroutineScope.(String?) -> Boolean)? = null
    private var _onQueryTextSubmit_returnValue: Boolean = false

    override fun onQueryTextSubmit(query: String?) : Boolean {
        val returnValue = _onQueryTextSubmit_returnValue
        val handler = _onQueryTextSubmit ?: return returnValue
        GlobalScope.launch(context) {
            handler(query)
        }
        return returnValue
    }

    fun onQueryTextSubmit(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(String?) -> Boolean
    ) {
        _onQueryTextSubmit = listener
        _onQueryTextSubmit_returnValue = returnValue
    }

    private var _onQueryTextChange: (suspend CoroutineScope.(String?) -> Boolean)? = null
    private var _onQueryTextChange_returnValue: Boolean = false

    override fun onQueryTextChange(newText: String?) : Boolean {
        val returnValue = _onQueryTextChange_returnValue
        val handler = _onQueryTextChange ?: return returnValue
        GlobalScope.launch(context) {
            handler(newText)
        }
        return returnValue
    }

    fun onQueryTextChange(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(String?) -> Boolean
    ) {
        _onQueryTextChange = listener
        _onQueryTextChange_returnValue = returnValue
    }

}fun android.support.v7.widget.SearchView.onSearchClick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnSearchClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
    }
}

fun android.support.v7.widget.SearchView.onSuggestionListener(
        context: CoroutineContext = Dispatchers.Main,
        init: __SearchView_OnSuggestionListener.() -> Unit
) {
    val listener = __SearchView_OnSuggestionListener(context)
    listener.init()
    setOnSuggestionListener(listener)
}

class __SearchView_OnSuggestionListener(private val context: CoroutineContext) : android.support.v7.widget.SearchView.OnSuggestionListener {

    private var _onSuggestionSelect: (suspend CoroutineScope.(Int) -> Boolean)? = null
    private var _onSuggestionSelect_returnValue: Boolean = false

    override fun onSuggestionSelect(position: Int) : Boolean {
        val returnValue = _onSuggestionSelect_returnValue
        val handler = _onSuggestionSelect ?: return returnValue
        GlobalScope.launch(context) {
            handler(position)
        }
        return returnValue
    }

    fun onSuggestionSelect(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(Int) -> Boolean
    ) {
        _onSuggestionSelect = listener
        _onSuggestionSelect_returnValue = returnValue
    }

    private var _onSuggestionClick: (suspend CoroutineScope.(Int) -> Boolean)? = null
    private var _onSuggestionClick_returnValue: Boolean = false

    override fun onSuggestionClick(position: Int) : Boolean {
        val returnValue = _onSuggestionClick_returnValue
        val handler = _onSuggestionClick ?: return returnValue
        GlobalScope.launch(context) {
            handler(position)
        }
        return returnValue
    }

    fun onSuggestionClick(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(Int) -> Boolean
    ) {
        _onSuggestionClick = listener
        _onSuggestionClick_returnValue = returnValue
    }

}fun android.support.v7.widget.Toolbar.onMenuItemClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(item)
        }
        returnValue
    }
}

fun android.support.v7.widget.ViewStubCompat.onInflate(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(stub: android.support.v7.widget.ViewStubCompat?, inflated: android.view.View?) -> Unit
) {
    setOnInflateListener { stub, inflated ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(stub, inflated)
        }
    }
}

