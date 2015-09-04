private val defaultInit: Any.() -> Unit = {}

public open class _GridLayoutSupport(ctx: Context): android.support.v7.widget.GridLayout(ctx) {
    public fun <T: View> T.layoutParams(
            rowSpec: android.support.v7.widget.GridLayout.Spec?,
            columnSpec: android.support.v7.widget.GridLayout.Spec?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams()
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            params: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            params: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            source: android.support.v7.widget.GridLayout.LayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(source!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

    public fun <T: View> T.layoutParams(
            context: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@layoutParams.layoutParams = layoutParams
        return this
    }

}