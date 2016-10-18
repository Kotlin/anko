@file:JvmName("AppcompatV7LayoutsKt")
package org.jetbrains.anko.appcompat.v7

import android.content.Context
import android.widget.*
import android.view.*
import android.util.AttributeSet

private val defaultInit: Any.() -> Unit = {}

open class _ActionMenuView(ctx: Context): android.support.v7.widget.ActionMenuView(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            other: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            other: android.support.v7.widget.ActionMenuView.LayoutParams?,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(other!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.ActionMenuView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.ActionMenuView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _LinearLayoutCompat(ctx: Context): android.support.v7.widget.LinearLayoutCompat(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            weight: Float,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(width, height, weight)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            p: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(p!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v7.widget.LinearLayoutCompat.LayoutParams?,
            init: android.support.v7.widget.LinearLayoutCompat.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.LinearLayoutCompat.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _Toolbar(ctx: Context): android.support.v7.widget.Toolbar(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            gravity: Int,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v7.widget.Toolbar.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v7.app.ActionBar.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.Toolbar.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.Toolbar.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

