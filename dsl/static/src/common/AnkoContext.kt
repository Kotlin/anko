package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.internals.AnkoInternals.createAnkoContext

interface AnkoContext<T> : ViewManager {
    val ctx: Context
    val owner: T
    val view: View

    override fun updateViewLayout(view: View, params: ViewGroup.LayoutParams) {
        throw UnsupportedOperationException()
    }

    override fun removeView(view: View) {
        throw UnsupportedOperationException()
    }

    companion object {
        fun create(ctx: Context): AnkoContext<Context> = AnkoContextImpl(ctx, ctx, false)
        fun createReusable(ctx: Context): AnkoContext<Context> = ReusableAnkoContext(ctx, ctx, false)
        fun <T> create(ctx: Context, owner: T): AnkoContext<T> = AnkoContextImpl(ctx, owner, false)
        fun <T> createReusable(ctx: Context, owner: T): AnkoContext<T> = ReusableAnkoContext(ctx, owner, false)
        fun <T: ViewGroup> createDelegate(owner: T): AnkoContext<T> = DelegatingAnkoContext(owner)
    }
}

internal class DelegatingAnkoContext<T: ViewGroup>(override val owner: T): AnkoContext<T> {
    override val ctx = owner.context
    override val view: View = owner

    override fun addView(view: View?, params: ViewGroup.LayoutParams?) {
        if (view == null) return

        if (params == null) {
            owner.addView(view)
        } else {
            owner.addView(view, params)
        }
    }
}

internal class ReusableAnkoContext<T>(
        override val ctx: Context,
        override val owner: T,
        private val setContentView: Boolean
) : AnkoContextImpl<T>(ctx, owner, setContentView) {
    override fun alreadyHasView() {}
}

open class AnkoContextImpl<T>(
        override val ctx: Context,
        override val owner: T,
        private val setContentView: Boolean
) : AnkoContext<T> {
    private var myView: View? = null

    override val view: View
        get() = myView ?: throw IllegalStateException("View was not set previously")

    override fun addView(view: View?, params: ViewGroup.LayoutParams?) {
        if (view == null) return

        if (myView != null) {
            alreadyHasView()
        }

        this.myView = view

        if (setContentView) {
            val context = ctx
            when (context) {
                is Activity -> context.setContentView(view)
                else -> throw IllegalStateException("Context is not an Activity, can't set content view")
            }
        }
    }

    open protected fun alreadyHasView(): Unit = throw IllegalStateException("View is already set: $myView")
}

@AnkoInternals.NoBinding
fun Context.UI(setContentView: Boolean, init: AnkoContext<Context>.() -> Unit) =
        createAnkoContext(this, init, setContentView)

fun Context.UI(init: AnkoContext<Context>.() -> Unit) = createAnkoContext(this, init)

fun Fragment.UI(init: AnkoContext<Fragment>.() -> Unit): AnkoContext<Fragment> = createAnkoContext(activity, init)

interface AnkoComponent<T> {
    fun createView(ui: AnkoContext<T>): View
}

fun <T : Activity> AnkoComponent<T>.setContentView(activity: T) =
        createView(AnkoContextImpl(activity, activity, true))