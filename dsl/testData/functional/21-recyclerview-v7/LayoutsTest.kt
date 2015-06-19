public open class _RecyclerViewSupport(ctx: Context): android.support.v7.widget.RecyclerView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, recyclerViewInit: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(c!!, attrs!!)
        layoutParams.recyclerViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, recyclerViewInit: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(width, height)
        layoutParams.recyclerViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, recyclerViewInit: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.recyclerViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, recyclerViewInit: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.recyclerViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.widget.RecyclerView.LayoutParams?, recyclerViewInit: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.recyclerViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}