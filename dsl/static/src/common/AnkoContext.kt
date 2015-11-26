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
}

class AnkoContextImpl<T>(
        override val ctx: Context,
        override val owner: T,
        private val setContentView: Boolean
) : AnkoContext<T> {
    private var myView: View? = null

    override val view: View
        get() = myView ?: throw IllegalStateException("View was not set previously")

    override fun addView(view: View, params: ViewGroup.LayoutParams?) {
        if (myView != null) {
            throw IllegalStateException("View is already set: $myView")
        }

        this.myView = view

        if (setContentView) {
            when (ctx) {
                is Activity -> ctx.setContentView(view)
                else -> throw IllegalStateException("Context is not an Activity, can't set content view")
            }
        }
    }
}

@AnkoInternals.NoBinding
fun Context.UI(setContentView: Boolean, init: AnkoContext<Context>.() -> Unit) =
        createAnkoContext(this, init, setContentView)

fun Context.UI(init: AnkoContext<Context>.() -> Unit) = createAnkoContext(this, init)

fun Fragment.UI(init: AnkoContext<Fragment>.() -> Unit): AnkoContext<Fragment> = createAnkoContext(activity, init)

interface AnkoComponent<T> {
    fun createView(ui: AnkoContext<T>): View
}

fun AnkoComponent<out Activity>.setContentView(activity: Activity) =
        createView(AnkoContextImpl(activity, activity, true))

class MyActivity : Activity() {
    fun a() {
        this.UI {

        }
    }
}