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

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, appWidgetHostViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.appWidgetHostViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _GestureOverlayView(ctx: Context): android.gesture.GestureOverlayView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, gestureOverlayViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.gestureOverlayViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _FragmentTabHost(ctx: Context): android.support.v4.app.FragmentTabHost(ctx) {
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

public open class _NestedScrollView(ctx: Context): android.support.v4.widget.NestedScrollView(ctx) {
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

public open class _SearchViewSupport(ctx: Context): android.support.v7.widget.SearchView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.support.v7.widget.LinearLayoutCompat.LayoutParams?, searchViewInit: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.searchViewInit()
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

public open class _ActionMenuView(ctx: Context): android.widget.ActionMenuView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, actionMenuViewInit: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(other: android.view.ViewGroup.LayoutParams?, actionMenuViewInit: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(other: android.widget.ActionMenuView.LayoutParams?, actionMenuViewInit: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, actionMenuViewInit: android.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.ActionMenuView.LayoutParams(width, height)
        layoutParams.actionMenuViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _CalendarView(ctx: Context): android.widget.CalendarView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, calendarViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.calendarViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _DatePicker(ctx: Context): android.widget.DatePicker(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, datePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.datePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _DialerFilter(ctx: Context): android.widget.DialerFilter(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, dialerFilterInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.dialerFilterInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, dialerFilterInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(width, height)
        layoutParams.dialerFilterInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, dialerFilterInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.dialerFilterInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, dialerFilterInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.dialerFilterInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.RelativeLayout.LayoutParams?, dialerFilterInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.dialerFilterInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _FrameLayout(ctx: Context): android.widget.FrameLayout(ctx) {
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

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, frameLayoutInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.frameLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _GridLayout(ctx: Context): android.widget.GridLayout(ctx) {
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

    public fun <T: View> T.layoutParams(source: android.widget.GridLayout.LayoutParams?, gridLayoutInit: android.widget.GridLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.GridLayout.LayoutParams(source!!)
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

public open class _HorizontalScrollView(ctx: Context): android.widget.HorizontalScrollView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, horizontalScrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.horizontalScrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ImageSwitcher(ctx: Context): android.widget.ImageSwitcher(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, imageSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.imageSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _LinearLayout(ctx: Context): android.widget.LinearLayout(ctx) {
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

    public fun <T: View> T.layoutParams(source: android.widget.LinearLayout.LayoutParams?, linearLayoutInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.linearLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _NumberPicker(ctx: Context): android.widget.NumberPicker(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.numberPickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.numberPickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.numberPickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.numberPickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.numberPickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.LinearLayout.LayoutParams?, numberPickerInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.numberPickerInit()
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

public open class _RelativeLayout(ctx: Context): android.widget.RelativeLayout(ctx) {
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

    public fun <T: View> T.layoutParams(source: android.widget.RelativeLayout.LayoutParams?, relativeLayoutInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.relativeLayoutInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ScrollView(ctx: Context): android.widget.ScrollView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, scrollViewInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.scrollViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _SearchView(ctx: Context): android.widget.SearchView(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.LinearLayout.LayoutParams?, searchViewInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.searchViewInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TabHost(ctx: Context): android.widget.TabHost(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, tabHostInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.tabHostInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TabWidget(ctx: Context): android.widget.TabWidget(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.tabWidgetInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.tabWidgetInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.tabWidgetInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.tabWidgetInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.tabWidgetInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.LinearLayout.LayoutParams?, tabWidgetInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.tabWidgetInit()
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
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, textSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.textSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TimePicker(ctx: Context): android.widget.TimePicker(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, timePickerInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.timePickerInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _Toolbar(ctx: Context): android.widget.Toolbar(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(width, height)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(width, height, gravity)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(gravity: Int, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(gravity)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.Toolbar.LayoutParams?, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.app.ActionBar.LayoutParams?, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, toolbarInit: android.widget.Toolbar.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.Toolbar.LayoutParams(source!!)
        layoutParams.toolbarInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _TwoLineListItem(ctx: Context): android.widget.TwoLineListItem(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, twoLineListItemInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.twoLineListItemInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, twoLineListItemInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(width, height)
        layoutParams.twoLineListItemInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, twoLineListItemInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.twoLineListItemInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, twoLineListItemInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.twoLineListItemInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.RelativeLayout.LayoutParams?, twoLineListItemInit: android.widget.RelativeLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.RelativeLayout.LayoutParams(source!!)
        layoutParams.twoLineListItemInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewAnimator(ctx: Context): android.widget.ViewAnimator(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, viewAnimatorInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewAnimatorInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewFlipper(ctx: Context): android.widget.ViewFlipper(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, viewFlipperInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewFlipperInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ViewSwitcher(ctx: Context): android.widget.ViewSwitcher(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, gravity: Int, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.LayoutParams?, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.FrameLayout.LayoutParams?, viewSwitcherInit: android.widget.FrameLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.FrameLayout.LayoutParams(source!!)
        layoutParams.viewSwitcherInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

public open class _ZoomControls(ctx: Context): android.widget.ZoomControls(ctx) {
    public fun <T: View> T.layoutParams(c: android.content.Context?, attrs: android.util.AttributeSet?, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT, weight: Float, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(width, height, weight)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(p: android.view.ViewGroup.LayoutParams?, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(p!!)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.view.ViewGroup.MarginLayoutParams?, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

    public fun <T: View> T.layoutParams(source: android.widget.LinearLayout.LayoutParams?, zoomControlsInit: android.widget.LinearLayout.LayoutParams.() -> Unit = defaultInit): T {
        val layoutParams = android.widget.LinearLayout.LayoutParams(source!!)
        layoutParams.zoomControlsInit()
        this@layoutParams.setLayoutParams(layoutParams)
        return this
    }

}

