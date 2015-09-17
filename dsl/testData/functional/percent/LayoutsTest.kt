private val defaultInit: Any.() -> Unit = {}

public open class _PercentFrameLayoutSupport(ctx: Context): android.support.percent.PercentFrameLayout(ctx) {
    public fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.widget.FrameLayout.LayoutParams?,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.support.percent.PercentFrameLayout.LayoutParams?,
            init: android.support.percent.PercentFrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _PercentRelativeLayoutSupport(ctx: Context): android.support.percent.PercentRelativeLayout(ctx) {
    public fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.percent.PercentRelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentRelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.percent.PercentRelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentRelativeLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.percent.PercentRelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentRelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.percent.PercentRelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.percent.PercentRelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}