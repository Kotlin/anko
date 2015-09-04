private val defaultInit: Any.() -> Unit = {}

public open class _AppBarLayoutSupport(ctx: Context): android.support.design.widget.AppBarLayout(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.LinearLayout.LayoutParams?,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.design.widget.AppBarLayout.LayoutParams?,
            init: android.support.design.widget.AppBarLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.AppBarLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _CollapsingToolbarLayoutSupport(ctx: Context): android.support.design.widget.CollapsingToolbarLayout(ctx) {
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

public open class _CoordinatorLayoutSupport(ctx: Context): android.support.design.widget.CoordinatorLayout(ctx) {
    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.design.widget.CoordinatorLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.CoordinatorLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.support.design.widget.CoordinatorLayout.LayoutParams?,
            init: android.support.design.widget.CoordinatorLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.CoordinatorLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.design.widget.CoordinatorLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.CoordinatorLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.design.widget.CoordinatorLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.design.widget.CoordinatorLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _TabLayoutSupport(ctx: Context): android.support.design.widget.TabLayout(ctx) {
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

public open class _TextInputLayoutSupport(ctx: Context): android.support.design.widget.TextInputLayout(ctx) {
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