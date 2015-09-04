private val defaultInit: Any.() -> Unit = {}

public open class _FragmentTabHostSupport(ctx: Context): android.support.v4.app.FragmentTabHost(ctx) {
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

public open class _ViewPagerSupport(ctx: Context): android.support.v4.view.ViewPager(ctx) {
    public fun <T: View> T.layoutParams(
            init: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            context: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _DrawerLayoutSupport(ctx: Context): android.support.v4.widget.DrawerLayout(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v4.widget.DrawerLayout.LayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _NestedScrollViewSupport(ctx: Context): android.support.v4.widget.NestedScrollView(ctx) {
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

public open class _SlidingPaneLayoutSupport(ctx: Context): android.support.v4.widget.SlidingPaneLayout(ctx) {
    public fun <T: View> T.layoutParams(
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v4.widget.SlidingPaneLayout.LayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}