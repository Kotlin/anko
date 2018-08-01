@file:JvmName("ConstraintlayoutAndroidxLayoutsKt")
package org.jetbrains.anko.constraintlayout.androidx


import androidx.constraintlayout.widget.ConstraintLayout
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.View
import androidx.constraintlayout.widget.Constraints

open class _ConstraintLayout(ctx: Context): ConstraintLayout(ctx) {

    inline fun <T: View> T.lparams(
            source: ConstraintLayout.LayoutParams?,
            init: ConstraintLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(source!!)
        layoutParams.init()
        layoutParams.validate()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ConstraintLayout.LayoutParams?
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: ConstraintLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        layoutParams.validate()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: ConstraintLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(width, height)
        layoutParams.init()
        layoutParams.validate()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: ConstraintLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(source!!)
        layoutParams.init()
        layoutParams.validate()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = ConstraintLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

open class _Constraints(ctx: Context): Constraints(ctx) {

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: Constraints.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Constraints.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = Constraints.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: Constraints.LayoutParams?,
            init: Constraints.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Constraints.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            source: Constraints.LayoutParams?
    ): T {
        val layoutParams = Constraints.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: Constraints.LayoutParams.() -> Unit
    ): T {
        val layoutParams = Constraints.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T: View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = Constraints.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

