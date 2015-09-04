private val defaultInit: Any.() -> Unit = {}

public open class _AppWidgetHostView(ctx: Context): android.appwidget.AppWidgetHostView(ctx) {
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

public open class _WebView(ctx: Context): android.webkit.WebView(ctx) {
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

public open class _AbsoluteLayout(ctx: Context): android.widget.AbsoluteLayout(ctx) {
    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            x: Int,
            y: Int,
            init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(width, height, x, y)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ActionMenuView(ctx: Context): android.widget.ActionMenuView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            other: android.view.ViewGroup.LayoutParams?,
            init: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            other: android.widget.ActionMenuView.LayoutParams?,
            init: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _FrameLayout(ctx: Context): android.widget.FrameLayout(ctx) {
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

public open class _Gallery(ctx: Context): android.widget.Gallery(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Gallery.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Gallery.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Gallery.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _GridLayout(ctx: Context): android.widget.GridLayout(ctx) {
    public fun <T: View> T.layoutParams(
            rowSpec: android.widget.GridLayout.Spec?,
            columnSpec: android.widget.GridLayout.Spec?,
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            params: android.view.ViewGroup.LayoutParams?,
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            params: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.GridLayout.LayoutParams?,
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            context: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _GridView(ctx: Context): android.widget.GridView(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsListView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsListView.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            viewType: Int,
            init: android.widget.AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsListView.LayoutParams(width, height, viewType)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.AbsListView.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _HorizontalScrollView(ctx: Context): android.widget.HorizontalScrollView(ctx) {
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

public open class _ImageSwitcher(ctx: Context): android.widget.ImageSwitcher(ctx) {
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

public open class _LinearLayout(ctx: Context): android.widget.LinearLayout(ctx) {
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

public open class _RadioGroup(ctx: Context): android.widget.RadioGroup(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            initWeight: Float,
            init: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(width, height, initWeight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _RelativeLayout(ctx: Context): android.widget.RelativeLayout(ctx) {
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

public open class _ScrollView(ctx: Context): android.widget.ScrollView(ctx) {
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

public open class _TableLayout(ctx: Context): android.widget.TableLayout(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            initWeight: Float,
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(width, height, initWeight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _TableRow(ctx: Context): android.widget.TableRow(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            initWeight: Float,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(width, height, initWeight)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            column: Int,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(column)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(p!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.TableRow.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _TextSwitcher(ctx: Context): android.widget.TextSwitcher(ctx) {
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

public open class _Toolbar(ctx: Context): android.widget.Toolbar(ctx) {
    public fun <T: View> T.layoutParams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(width, height)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            gravity: Int,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(gravity)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.widget.Toolbar.LayoutParams?,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.app.ActionBar.LayoutParams?,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}

public open class _ViewAnimator(ctx: Context): android.widget.ViewAnimator(ctx) {
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

public open class _ViewSwitcher(ctx: Context): android.widget.ViewSwitcher(ctx) {
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