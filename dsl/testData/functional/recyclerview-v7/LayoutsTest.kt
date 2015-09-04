private val defaultInit: Any.() -> Unit = {}

public open class _RecyclerViewSupport(ctx: Context): android.support.v7.widget.RecyclerView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v7.widget.RecyclerView.LayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}