@file:JvmName("RecyclerviewV7LayoutsKt")
package org.jetbrains.anko.recyclerview.v7

import android.content.Context
import android.widget.*
import android.view.*
import android.util.AttributeSet

private val defaultInit: Any.() -> Unit = {}

open class _RecyclerView(ctx: Context): android.support.v7.widget.RecyclerView(ctx) {
    fun <T: View> T.lparams(
            c: android.content.Context?,
            attrs: android.util.AttributeSet?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.MarginLayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.view.ViewGroup.LayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: android.support.v7.widget.RecyclerView.LayoutParams?,
            init: android.support.v7.widget.RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = android.support.v7.widget.RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

