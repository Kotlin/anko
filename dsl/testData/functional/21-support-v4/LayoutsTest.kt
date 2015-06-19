public open class _FragmentTabHostSupport(ctx: Context): android.support.v4.app.FragmentTabHost(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, fragmentTabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.fragmentTabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewPagerSupport(ctx: Context): android.support.v4.view.ViewPager(ctx) {
    public fun <T: View> T.layoutParams(viewPagerInit: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams()
        layoutParams.viewPagerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(context: android.content.Context?, attrs: android.util.AttributeSet?, viewPagerInit: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams(context!!, attrs!!)
        layoutParams.viewPagerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _DrawerLayoutSupport(ctx: Context): android.support.v4.widget.DrawerLayout(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(c!!, attrs!!)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height, gravity)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v4.widget.DrawerLayout.LayoutParams?, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, drawerLayoutInit: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.drawerLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _NestedScrollViewSupport(ctx: Context): android.support.v4.widget.NestedScrollView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, nestedScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.nestedScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _SlidingPaneLayoutSupport(ctx: Context): android.support.v4.widget.SlidingPaneLayout(ctx) {
    public fun <T: View> T.layoutParams(slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams()
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(width, height)
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v4.widget.SlidingPaneLayout.LayoutParams?, slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, slidingPaneLayoutInit: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(c!!, attrs!!)
        layoutParams.slidingPaneLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}