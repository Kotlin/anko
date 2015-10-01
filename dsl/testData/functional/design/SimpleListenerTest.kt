inline fun android.support.design.widget.AppBarLayout.onOffsetChanged(noinline l: (appBarLayout: android.support.design.widget.AppBarLayout?, verticalOffset: Int) -> Unit) {
    addOnOffsetChangedListener(l)
}