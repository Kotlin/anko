private val defaultInit: Any.() -> Unit = {}

public open class _ActionMenuViewSupport(ctx: Context): android.support.v7.widget.ActionMenuView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            other: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            other: android.support.v7.widget.ActionMenuView.LayoutParams?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _LinearLayoutCompatSupport(ctx: Context): android.support.v7.widget.LinearLayoutCompat(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v7.widget.LinearLayoutCompat.LayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ToolbarSupport(ctx: Context): android.support.v7.widget.Toolbar(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            gravity: Int,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v7.widget.Toolbar.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v7.app.ActionBar.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}