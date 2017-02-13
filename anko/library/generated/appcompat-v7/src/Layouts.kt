@file:JvmName("AppcompatV7LayoutsKt")
package org.jetbrains.anko.appcompat.v7


import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import android.support.v7.view.menu.ListMenuItemView
import android.view.View
import android.widget.FrameLayout
import android.support.v7.widget.ActionBarContainer
import android.support.v7.widget.ActionBarContextView
import android.support.v7.widget.ActionBarOverlayLayout
import android.support.v7.widget.ActionMenuView
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.AlertDialogLayout
import android.support.v7.widget.ButtonBarLayout
import android.support.v7.widget.ListViewCompat
import android.widget.AbsListView
import android.support.v7.widget.ScrollingTabContainerView
import android.support.v7.widget.Toolbar
import android.support.v7.app.ActionBar

private val defaultInit: Any.() -> Unit = {}

open class _ListMenuItemView(ctx: Context, attrs: AttributeSet?): ListMenuItemView(ctx, null) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionBarContainer(ctx: Context): ActionBarContainer(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionBarContextView(ctx: Context): ActionBarContextView(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ViewGroup.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ViewGroup.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: ViewGroup.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ViewGroup.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionBarOverlayLayout(ctx: Context): ActionBarOverlayLayout(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionMenuView(ctx: Context): ActionMenuView(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            other: ViewGroup.LayoutParams?,
            init: ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            other: ActionMenuView.LayoutParams?,
            init: ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _AlertDialogLayout(ctx: Context): AlertDialogLayout(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ButtonBarLayout(ctx: Context, attrs: AttributeSet?): ButtonBarLayout(ctx, null) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _LinearLayoutCompat(ctx: Context): LinearLayoutCompat(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ListViewCompat(ctx: Context): ListViewCompat(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = AbsListView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            viewType: Int,
            init: AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height, viewType)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: AbsListView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = AbsListView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ScrollingTabContainerView(ctx: Context): ScrollingTabContainerView(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _Toolbar(ctx: Context): Toolbar(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            gravity: Int,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: Toolbar.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ActionBar.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

