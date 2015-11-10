package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import org.jetbrains.anko.internals.AnkoInternals

interface AnkoContext : ViewManager {
    val ctx: Context
    val view: View

    override fun updateViewLayout(view: View, params: ViewGroup.LayoutParams) {
        throw UnsupportedOperationException()
    }

    override fun removeView(view: View) {
        throw UnsupportedOperationException()
    }
}

class AnkoContextImpl(override val ctx: Context, private val setContentView: Boolean = true) : AnkoContext {
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
fun Context.UI(setContentView: Boolean, init: AnkoContext.() -> Unit): AnkoContext {
    val dsl = AnkoContextImpl(this, setContentView)
    dsl.init()
    return dsl
}

fun Context.UI(init: AnkoContext.() -> Unit): AnkoContext {
    val dsl = AnkoContextImpl(this, false)
    dsl.init()
    return dsl
}

fun Activity.UI(init: AnkoContext.() -> Unit): AnkoContext = UI(true, init)

fun Fragment.UI(init: AnkoContext.() -> Unit): AnkoContext = activity.UI(false, init)

interface AnkoComponent {
    fun createView(ui: AnkoContext): View
}

fun AnkoComponent.setContentView(activity: Activity) = createView(AnkoContextImpl(activity))