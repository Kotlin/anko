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

open class _ListMenuItemView(ctx: Context, attrs: AttributeSet?): ListMenuItemView(ctx, null) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionBarContainer(ctx: Context): ActionBarContainer(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionBarOverlayLayout(ctx: Context): ActionBarOverlayLayout(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: ActionBarOverlayLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = ActionBarOverlayLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ActionMenuView(ctx: Context): ActionMenuView(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ActionMenuView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            other: ViewGroup.LayoutParams?,
            init: ActionMenuView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            other: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            other: ActionMenuView.LayoutParams?,
            init: ActionMenuView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            other: ActionMenuView.LayoutParams?
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(other!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ActionMenuView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = ActionMenuView.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _AlertDialogLayout(ctx: Context): AlertDialogLayout(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ButtonBarLayout(ctx: Context, attrs: AttributeSet?): ButtonBarLayout(ctx, null) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float
    ): T {
        val layoutParams = LinearLayout.LayoutParams(width, height, weight)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(p!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayout.LayoutParams?
    ): T {
        val layoutParams = LinearLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _LinearLayoutCompat(ctx: Context): LinearLayoutCompat(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(width, height, weight)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            p: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(p!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?,
            init: LinearLayoutCompat.LayoutParams.() -> Unit
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: LinearLayoutCompat.LayoutParams?
    ): T {
        val layoutParams = LinearLayoutCompat.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ListViewCompat(ctx: Context): ListViewCompat(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: AbsListView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = AbsListView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = AbsListView.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: AbsListView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            viewType: Int,
            init: AbsListView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height, viewType)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            viewType: Int
    ): T {
        val layoutParams = AbsListView.LayoutParams(width, height, viewType)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: AbsListView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = AbsListView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = AbsListView.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _ScrollingTabContainerView(ctx: Context): ScrollingTabContainerView(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _Toolbar(ctx: Context): Toolbar(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = Toolbar.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int
    ): T {
        val layoutParams = Toolbar.LayoutParams(width, height, gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            gravity: Int,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            gravity: Int
    ): T {
        val layoutParams = Toolbar.LayoutParams(gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: Toolbar.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: Toolbar.LayoutParams?
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ActionBar.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ActionBar.LayoutParams?
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: Toolbar.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = Toolbar.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

