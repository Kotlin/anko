@file:JvmName("AppcompatV7CoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.appcompat.v7.coroutines


import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch

fun android.support.v7.widget.ActionMenuView.onMenuItemClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        launch(context) {
            handler(item)
        }
        returnValue
    }
}

fun android.support.v7.widget.ActivityChooserView.onDismiss(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDismissListener {  ->
        launch(context, block = handler)
    }
}

fun android.support.v7.widget.FitWindowsFrameLayout.onFitSystemWindows(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(insets: android.graphics.Rect?) -> Unit
) {
    setOnFitSystemWindowsListener { insets ->
        launch(context) {
            handler(insets)
        }
    }
}

fun android.support.v7.widget.SearchView.onClose(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnCloseListener {  ->
        launch(context, block = handler)
        returnValue
    }
}

fun android.support.v7.widget.SearchView.onQueryTextFocusChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnQueryTextFocusChangeListener { v, hasFocus ->
        launch(context) {
            handler(v, hasFocus)
        }
    }
}

fun android.support.v7.widget.SearchView.onQueryTextListener(
        context: CoroutineContext = UI,
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
        launch(context) {
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
        launch(context) {
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
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnSearchClickListener { v ->
        launch(context) {
            handler(v)
        }
    }
}

fun android.support.v7.widget.SearchView.onSuggestionListener(
        context: CoroutineContext = UI,
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
        launch(context) {
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
        launch(context) {
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
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        launch(context) {
            handler(item)
        }
        returnValue
    }
}

fun android.support.v7.widget.ViewStubCompat.onInflate(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(stub: android.support.v7.widget.ViewStubCompat?, inflated: android.view.View?) -> Unit
) {
    setOnInflateListener { stub, inflated ->
        launch(context) {
            handler(stub, inflated)
        }
    }
}

