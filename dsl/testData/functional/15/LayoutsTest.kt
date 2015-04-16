public open class _AppWidgetHostView(ctx: Context): android.appwidget.AppWidgetHostView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _WebView(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.webkit.WebView(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, webViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.webViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, webViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.webViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, webViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.webViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _AbsoluteLayout(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.AbsoluteLayout(ctx, null, 0) {
    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, x: Int, y: Int, absoluteLayoutInit: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(width, height, x, y)
        layoutParams.absoluteLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, absoluteLayoutInit: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(c!!, attrs!!)
        layoutParams.absoluteLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, absoluteLayoutInit: android.widget.AbsoluteLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.AbsoluteLayout.LayoutParams(source!!)
        layoutParams.absoluteLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _FrameLayout(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.FrameLayout(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _Gallery(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.Gallery(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, galleryInit: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Gallery.LayoutParams(c!!, attrs!!)
        layoutParams.galleryInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, galleryInit: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Gallery.LayoutParams(width, height)
        layoutParams.galleryInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, galleryInit: android.widget.Gallery.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Gallery.LayoutParams(source!!)
        layoutParams.galleryInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _GridLayout(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.GridLayout(ctx, null, 0) {
    public fun <T: View> T.layoutParams(rowSpec: android.widget.GridLayout.Spec?, columnSpec: android.widget.GridLayout.Spec?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams( gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams()
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(params: android.view.ViewGroup.LayoutParams?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(params!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(params: android.view.ViewGroup.MarginLayoutParams?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(params!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(that: android.widget.GridLayout.LayoutParams?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(that!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(context: android.content.Context?, attrs: android.util.AttributeSet?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _GridView(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.GridView(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, gridViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.gridViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gridViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.gridViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, gridViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.gridViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _HorizontalScrollView(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.HorizontalScrollView(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, horizontalScrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, horizontalScrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, horizontalScrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _LinearLayout(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.LinearLayout(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _RadioGroup(ctx: Context): android.widget.RadioGroup(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, radioGroupInit: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(c!!, attrs!!)
        layoutParams.radioGroupInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, radioGroupInit: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(width, height)
        layoutParams.radioGroupInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, initWeight: Float, radioGroupInit: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(width, height, initWeight)
        layoutParams.radioGroupInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, radioGroupInit: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(p!!)
        layoutParams.radioGroupInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, radioGroupInit: android.widget.RadioGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RadioGroup.LayoutParams(source!!)
        layoutParams.radioGroupInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _RelativeLayout(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.RelativeLayout(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, relativeLayoutInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.relativeLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, relativeLayoutInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(width, height)
        layoutParams.relativeLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, relativeLayoutInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.relativeLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, relativeLayoutInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.relativeLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ScrollView(ctx: Context, attrs: AttributeSet?, defStyle: Int): android.widget.ScrollView(ctx, null, 0) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, scrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, scrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, scrollViewInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TableLayout(ctx: Context): android.widget.TableLayout(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(c!!, attrs!!)
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(width, height)
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, initWeight: Float, tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(width, height, initWeight)
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams( tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams()
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(p!!)
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, tableLayoutInit: android.widget.TableLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableLayout.LayoutParams(source!!)
        layoutParams.tableLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TableRow(ctx: Context): android.widget.TableRow(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(c!!, attrs!!)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(width, height)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, initWeight: Float, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(width, height, initWeight)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams( tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams()
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(column: Int, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(column)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(p!!)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, tableRowInit: android.widget.TableRow.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.TableRow.LayoutParams(source!!)
        layoutParams.tableRowInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TextSwitcher(ctx: Context): android.widget.TextSwitcher(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, textSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, textSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, textSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewAnimator(ctx: Context): android.widget.ViewAnimator(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, viewAnimatorInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, viewAnimatorInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, viewAnimatorInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewSwitcher(ctx: Context): android.widget.ViewSwitcher(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, viewSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, viewSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(width, height)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, viewSwitcherInit: android.view.ViewGroup.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.view.ViewGroup.LayoutParams(source!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

