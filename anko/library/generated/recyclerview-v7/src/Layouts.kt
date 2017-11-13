@file:JvmName("RecyclerviewV7LayoutsKt")
package org.jetbrains.anko.recyclerview.v7


import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.View

open class _RecyclerView(ctx: Context): RecyclerView(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: RecyclerView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = RecyclerView.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: RecyclerView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = RecyclerView.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: RecyclerView.LayoutParams?,
            init: RecyclerView.LayoutParams.() -> Unit
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: RecyclerView.LayoutParams?
    ): T {
        val layoutParams = RecyclerView.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

