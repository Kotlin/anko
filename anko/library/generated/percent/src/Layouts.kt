@file:JvmName("PercentLayoutsKt")
package org.jetbrains.anko.percent


import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import android.support.percent.PercentFrameLayout
import android.view.View
import android.support.percent.PercentRelativeLayout

open class _PercentFrameLayout(ctx: Context): PercentFrameLayout(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(width, height, gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: FrameLayout.LayoutParams?
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: PercentFrameLayout.LayoutParams?,
            init: PercentFrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: PercentFrameLayout.LayoutParams?
    ): T {
        val layoutParams = PercentFrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _PercentRelativeLayout(ctx: Context): PercentRelativeLayout(ctx) {

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: PercentRelativeLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: PercentRelativeLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: PercentRelativeLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: PercentRelativeLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = PercentRelativeLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

