public fun android.support.v4.view.ViewPager.onPageChangeListener(init: __ViewPagerSupport_OnPageChangeListener.() -> Unit) {
    val listener = __ViewPagerSupport_OnPageChangeListener()
    listener.init()
    addOnPageChangeListener(listener)
}