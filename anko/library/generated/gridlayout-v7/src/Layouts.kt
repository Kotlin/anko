@file:JvmName("GridlayoutV7LayoutsKt")
package org.jetbrains.anko.gridlayout.v7


import android.support.v7.widget.GridLayout
import android.view.ViewGroup
import android.content.Context
import android.util.AttributeSet
import android.view.View

open class _GridLayout(ctx: Context): GridLayout(ctx) {

    inline fun <T: View> T.lparams(
            rowSpec: GridLayout.Spec?,
            columnSpec: GridLayout.Spec?,
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            rowSpec: GridLayout.Spec?,
            columnSpec: GridLayout.Spec?
    ): T {
        val layoutParams = GridLayout.LayoutParams(rowSpec!!, columnSpec!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams()
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            
    ): T {
        val layoutParams = GridLayout.LayoutParams()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            params: ViewGroup.LayoutParams?,
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            params: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = GridLayout.LayoutParams(params!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            params: ViewGroup.MarginLayoutParams?,
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams(params!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            params: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = GridLayout.LayoutParams(params!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: GridLayout.LayoutParams?,
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: GridLayout.LayoutParams?
    ): T {
        val layoutParams = GridLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            context: Context?,
            attrs: AttributeSet?,
            init: GridLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = GridLayout.LayoutParams(context!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            context: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = GridLayout.LayoutParams(context!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

