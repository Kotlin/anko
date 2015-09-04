class __ViewPagerSupport_OnPageChangeListener : android.support.v4.view.ViewPager.OnPageChangeListener {
    private var _onPageScrolled: ((Int, Float, Int) -> Unit)? = null
    private var _onPageSelected: ((Int) -> Unit)? = null
    private var _onPageScrollStateChanged: ((Int) -> Unit)? = null

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        _onPageScrolled?.invoke(position, positionOffset, positionOffsetPixels)
    }

    public fun onPageScrolled(listener: (Int, Float, Int) -> Unit) {
        _onPageScrolled = listener
    }

    override fun onPageSelected(position: Int) {
        _onPageSelected?.invoke(position)
    }

    public fun onPageSelected(listener: (Int) -> Unit) {
        _onPageSelected = listener
    }

    override fun onPageScrollStateChanged(state: Int) {
        _onPageScrollStateChanged?.invoke(state)
    }

    public fun onPageScrollStateChanged(listener: (Int) -> Unit) {
        _onPageScrollStateChanged = listener
    }

}