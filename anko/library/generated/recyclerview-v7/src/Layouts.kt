@file:JvmName("RecyclerviewV7LayoutsKt")
package org.jetbrains.anko.recyclerview.v7


import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.View

private val defaultInit: Any.() -> Unit = {}

open class _RecyclerView(ctx: Context): RecyclerView(ctx) {
    fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    fun <T: View> T.lparams(
            source: RecyclerView.LayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit = defaultInit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

}

