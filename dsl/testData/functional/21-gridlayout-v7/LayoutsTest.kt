public open class _GridLayoutSupport(ctx: Context): android.support.v7.widget.GridLayout(ctx) {
    public fun <T: View> T.layoutParams(rowSpec: android.support.v7.widget.GridLayout.Spec?, columnSpec: android.support.v7.widget.GridLayout.Spec?, gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams()
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(params: android.view.ViewGroup.LayoutParams?, gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(params: android.view.ViewGroup.MarginLayoutParams?, gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.widget.GridLayout.LayoutParams?, gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(source!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(context: android.content.Context?, attrs: android.util.AttributeSet?, gridLayoutInit: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.gridLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}