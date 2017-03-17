@file:JvmName("DesignCoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.design.coroutines


import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch

fun android.support.design.widget.AppBarLayout.onOffsetChanged(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(appBarLayout: android.support.design.widget.AppBarLayout?, verticalOffset: Int) -> Unit
) {
    addOnOffsetChangedListener { appBarLayout, verticalOffset ->
        launch(context) {
            handler(appBarLayout, verticalOffset)
        }
    }
}

fun android.support.design.widget.TabLayout.onTabSelectedListener(
        context: CoroutineContext = UI,
        init: __TabLayout_OnTabSelectedListener.() -> Unit
) {
    val listener = __TabLayout_OnTabSelectedListener(context)
    listener.init()
    addOnTabSelectedListener(listener)
}

class __TabLayout_OnTabSelectedListener(private val context: CoroutineContext) : android.support.design.widget.TabLayout.OnTabSelectedListener {

    private var _onTabSelected: (suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    

    override fun onTabSelected(tab: android.support.design.widget.TabLayout.Tab?) {
        val handler = _onTabSelected ?: return
        launch(context) {
            handler(tab)
        }
    }

    fun onTabSelected(
            listener: suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit
    ) {
        _onTabSelected = listener
    }

    private var _onTabUnselected: (suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    

    override fun onTabUnselected(tab: android.support.design.widget.TabLayout.Tab?) {
        val handler = _onTabUnselected ?: return
        launch(context) {
            handler(tab)
        }
    }

    fun onTabUnselected(
            listener: suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit
    ) {
        _onTabUnselected = listener
    }

    private var _onTabReselected: (suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    

    override fun onTabReselected(tab: android.support.design.widget.TabLayout.Tab?) {
        val handler = _onTabReselected ?: return
        launch(context) {
            handler(tab)
        }
    }

    fun onTabReselected(
            listener: suspend CoroutineScope.(android.support.design.widget.TabLayout.Tab?) -> Unit
    ) {
        _onTabReselected = listener
    }

}fun android.support.design.widget.BottomNavigationView.onNavigationItemSelected(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnNavigationItemSelectedListener { item ->
        launch(context) {
            handler(item)
        }
        returnValue
    }
}

fun android.support.design.widget.CoordinatorLayout.onHierarchyChangeListener(
        context: CoroutineContext = UI,
        init: __ViewGroup_OnHierarchyChangeListener.() -> Unit
) {
    val listener = __ViewGroup_OnHierarchyChangeListener(context)
    listener.init()
    setOnHierarchyChangeListener(listener)
}

class __ViewGroup_OnHierarchyChangeListener(private val context: CoroutineContext) : android.view.ViewGroup.OnHierarchyChangeListener {

    private var _onChildViewAdded: (suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit)? = null
    

    override fun onChildViewAdded(parent: android.view.View?, child: android.view.View?) {
        val handler = _onChildViewAdded ?: return
        launch(context) {
            handler(parent, child)
        }
    }

    fun onChildViewAdded(
            listener: suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit
    ) {
        _onChildViewAdded = listener
    }

    private var _onChildViewRemoved: (suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit)? = null
    

    override fun onChildViewRemoved(parent: android.view.View?, child: android.view.View?) {
        val handler = _onChildViewRemoved ?: return
        launch(context) {
            handler(parent, child)
        }
    }

    fun onChildViewRemoved(
            listener: suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit
    ) {
        _onChildViewRemoved = listener
    }

}