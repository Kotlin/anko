@file:JvmName("DesignListenersKt")
package org.jetbrains.anko.design

import android.view.MenuItem


fun android.support.design.widget.AppBarLayout.onOffsetChanged(l: (appBarLayout: android.support.design.widget.AppBarLayout?, verticalOffset: Int) -> Unit) {
    addOnOffsetChangedListener(l)
}

fun android.support.design.widget.CoordinatorLayout.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

class __ViewGroup_OnHierarchyChangeListener : android.view.ViewGroup.OnHierarchyChangeListener {
    private var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit)? = null
    private var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit)? = null

    override fun onChildViewAdded(parent: android.view.View?, child: android.view.View?) {
        _onChildViewAdded?.invoke(parent, child)
    }

    fun onChildViewAdded(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewAdded = listener
    }

    override fun onChildViewRemoved(parent: android.view.View?, child: android.view.View?) {
        _onChildViewRemoved?.invoke(parent, child)
    }

    fun onChildViewRemoved(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewRemoved = listener
    }

}

fun android.support.design.widget.TabLayout.onTabSelectedListener(init: __TabLayout_OnTabSelectedListener.() -> Unit) {
    val listener = __TabLayout_OnTabSelectedListener()
    listener.init()
    setOnTabSelectedListener(listener)
}

class __TabLayout_OnTabSelectedListener : android.support.design.widget.TabLayout.OnTabSelectedListener {
    private var _onTabSelected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabUnselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabReselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null

    override fun onTabSelected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabSelected?.invoke(tab)
    }

    fun onTabSelected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabSelected = listener
    }

    override fun onTabUnselected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabUnselected?.invoke(tab)
    }

    fun onTabUnselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabUnselected = listener
    }

    override fun onTabReselected(tab: android.support.design.widget.TabLayout.Tab?) {
        _onTabReselected?.invoke(tab)
    }

    fun onTabReselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabReselected = listener
    }

}

class __BottomNavigationView_OnNavigationItemSelectedListener : android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener {
    private var _onNavigationItemSelected: ((MenuItem) -> Boolean)? = null

    fun onNavigationItemSelected(listener: (MenuItem) -> Boolean) {
        _onNavigationItemSelected = listener
    }

    override fun onNavigationItemSelected(item: MenuItem) = _onNavigationItemSelected?.invoke(item) ?: false

}
