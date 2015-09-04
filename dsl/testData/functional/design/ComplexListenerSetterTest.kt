public fun android.support.design.widget.TabLayout.onTabSelectedListener(init: __TabLayoutSupport_OnTabSelectedListener.() -> Unit) {
    val listener = __TabLayoutSupport_OnTabSelectedListener()
    listener.init()
    setOnTabSelectedListener(listener)
}