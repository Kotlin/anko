public open class _ActionMenuViewSupport(ctx: Context): android.support.v7.widget.ActionMenuView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, actionMenuViewInit: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(other: android.view.ViewGroup.LayoutParams?, actionMenuViewInit: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(other: android.support.v7.widget.ActionMenuView.LayoutParams?, actionMenuViewInit: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, actionMenuViewInit: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(width, height)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _LinearLayoutCompatSupport(ctx: Context): android.support.v7.widget.LinearLayoutCompat(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.widget.LinearLayoutCompat.LayoutParams?, linearLayoutCompatInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.linearLayoutCompatInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ToolbarSupport(ctx: Context): android.support.v7.widget.Toolbar(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height, gravity)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(gravity: Int, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(gravity)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.widget.Toolbar.LayoutParams?, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.app.ActionBar.LayoutParams?, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, toolbarInit: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}