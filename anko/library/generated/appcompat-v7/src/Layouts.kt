@file:JvmName("AppcompatV7LayoutsKt")
package org.jetbrains.anko.appcompat.v7


import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.support.v7.widget.ActionMenuView
import android.view.View
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.Toolbar
import android.support.v7.app.ActionBar

private val defaultInit: Any.() -> Unit = {}

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

