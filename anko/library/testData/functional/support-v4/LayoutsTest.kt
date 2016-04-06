private val defaultInit: Any.() -> Unit = {}

open class _FragmentTabHost(ctx: Context): android.support.v4.app.FragmentTabHost(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.widget.FrameLayout.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ViewPager(ctx: Context): android.support.v4.view.ViewPager(ctx) {
    fun <T: View> T.lparams(
            init: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams()
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            context: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.view.ViewPager.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.view.ViewPager.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _DrawerLayout(ctx: Context): android.support.v4.widget.DrawerLayout(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v4.widget.DrawerLayout.LayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v4.widget.DrawerLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.DrawerLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _NestedScrollView(ctx: Context): android.support.v4.widget.NestedScrollView(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.widget.FrameLayout.LayoutParams?,
            init: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _SlidingPaneLayout(ctx: Context): android.support.v4.widget.SlidingPaneLayout(ctx) {
    fun <T: View> T.lparams(
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams()
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v4.widget.SlidingPaneLayout.LayoutParams?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v4.widget.SlidingPaneLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v4.widget.SlidingPaneLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}