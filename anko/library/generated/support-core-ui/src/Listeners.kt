@file:JvmName("SupportCoreUiListenersKt")
package org.jetbrains.anko.support.core.ui


fun android.support.v4.widget.DrawerLayout.drawerListener(init: __DrawerLayout_DrawerListener.() -> Unit) {
    val listener = __DrawerLayout_DrawerListener()
    listener.init()
    addDrawerListener(listener)
}

class __DrawerLayout_DrawerListener : android.support.v4.widget.DrawerLayout.DrawerListener {
    private var _onDrawerSlide: ((android.view.View?, Float) -> Unit)? = null
    private var _onDrawerOpened: ((android.view.View?) -> Unit)? = null
    private var _onDrawerClosed: ((android.view.View?) -> Unit)? = null
    private var _onDrawerStateChanged: ((Int) -> Unit)? = null

    override fun onDrawerSlide(p0: android.view.View?, p1: Float) {
        _onDrawerSlide?.invoke(p0, p1)
    }

    fun onDrawerSlide(listener: (android.view.View?, Float) -> Unit) {
        _onDrawerSlide = listener
    }

    override fun onDrawerOpened(p0: android.view.View?) {
        _onDrawerOpened?.invoke(p0)
    }

    fun onDrawerOpened(listener: (android.view.View?) -> Unit) {
        _onDrawerOpened = listener
    }

    override fun onDrawerClosed(p0: android.view.View?) {
        _onDrawerClosed?.invoke(p0)
    }

    fun onDrawerClosed(listener: (android.view.View?) -> Unit) {
        _onDrawerClosed = listener
    }

    override fun onDrawerStateChanged(p0: Int) {
        _onDrawerStateChanged?.invoke(p0)
    }

    fun onDrawerStateChanged(listener: (Int) -> Unit) {
        _onDrawerStateChanged = listener
    }

}

inline fun android.support.v4.view.ViewPager.onAdapterChange(noinline l: (p0: android.support.v4.view.ViewPager?, p1: android.support.v4.view.PagerAdapter?, p2: android.support.v4.view.PagerAdapter?) -> Unit) {
    addOnAdapterChangeListener(l)
}

fun android.support.v4.view.ViewPager.onPageChangeListener(init: __ViewPager_OnPageChangeListener.() -> Unit) {
    val listener = __ViewPager_OnPageChangeListener()
    listener.init()
    addOnPageChangeListener(listener)
}

class __ViewPager_OnPageChangeListener : android.support.v4.view.ViewPager.OnPageChangeListener {
    private var _onPageScrolled: ((Int, Float, Int) -> Unit)? = null
    private var _onPageSelected: ((Int) -> Unit)? = null
    private var _onPageScrollStateChanged: ((Int) -> Unit)? = null

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        _onPageScrolled?.invoke(p0, p1, p2)
    }

    fun onPageScrolled(listener: (Int, Float, Int) -> Unit) {
        _onPageScrolled = listener
    }

    override fun onPageSelected(p0: Int) {
        _onPageSelected?.invoke(p0)
    }

    fun onPageSelected(listener: (Int) -> Unit) {
        _onPageSelected = listener
    }

    override fun onPageScrollStateChanged(p0: Int) {
        _onPageScrollStateChanged?.invoke(p0)
    }

    fun onPageScrollStateChanged(listener: (Int) -> Unit) {
        _onPageScrollStateChanged = listener
    }

}

inline fun android.support.v4.widget.NestedScrollView.onScrollChange(noinline l: (p0: android.support.v4.widget.NestedScrollView?, p1: Int, p2: Int, p3: Int, p4: Int) -> Unit) {
    setOnScrollChangeListener(l)
}

inline fun android.support.v4.widget.SwipeRefreshLayout.onRefresh(noinline l: () -> Unit) {
    setOnRefreshListener(l)
}

