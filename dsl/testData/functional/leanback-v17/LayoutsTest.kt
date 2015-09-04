private val defaultInit: Any.() -> Unit = {}

public open class _BaseCardViewSupport(ctx: Context): android.support.v17.leanback.widget.BaseCardView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v17.leanback.widget.BaseCardView.LayoutParams?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _BrowseRowsFrameLayoutSupport(ctx: Context): android.support.v17.leanback.widget.BrowseRowsFrameLayout(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.FrameLayout.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ControlBarSupport(ctx: Context, attrs: AttributeSet?): android.support.v17.leanback.widget.ControlBar(ctx, null) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.LinearLayout.LayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ImageCardViewSupport(ctx: Context): android.support.v17.leanback.widget.ImageCardView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v17.leanback.widget.BaseCardView.LayoutParams?,
            init: android.support.v17.leanback.widget.BaseCardView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v17.leanback.widget.BaseCardView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _RowContainerViewSupport(ctx: Context): android.support.v17.leanback.widget.RowContainerView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.LinearLayout.LayoutParams?,
            init: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ScaleFrameLayoutSupport(ctx: Context): android.support.v17.leanback.widget.ScaleFrameLayout(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.FrameLayout.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _SearchBarSupport(ctx: Context): android.support.v17.leanback.widget.SearchBar(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.RelativeLayout.LayoutParams?,
            init: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ShadowOverlayContainerSupport(ctx: Context): android.support.v17.leanback.widget.ShadowOverlayContainer(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}