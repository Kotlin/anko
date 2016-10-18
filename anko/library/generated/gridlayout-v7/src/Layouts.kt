@file:JvmName("GridlayoutV7LayoutsKt")
package org.jetbrains.anko.gridlayout.v7

import android.content.Context
import android.widget.*
import android.view.*
import android.util.AttributeSet

private val defaultInit: Any.() -> Unit = {}

open class _GridLayout(ctx: Context): android.support.v7.widget.GridLayout(ctx) {
    fun <T: View> T.lparams(
            rowSpec: android.support.v7.widget.GridLayout.Spec?,
            columnSpec: android.support.v7.widget.GridLayout.Spec?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams()
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            params: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            params: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v7.widget.GridLayout.LayoutParams?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            context: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.GridLayout.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

