/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlinx.android.anko

import android.content.Context
import android.view.ViewGroup
import android.view.ViewManager
import android.view.View
import android.app.Activity
import android.app.Fragment
import kotlinx.android.anko.custom.addView
import kotlinx.android.anko.internals.UiHelper
import java.util.HashMap

public class AnkoException(message: String = "") : RuntimeException(message)

private val defaultInit: Any.() -> Unit = {}

public fun <T : View> T.style(style: (View) -> Unit): T {
    applyStyle(this, style)
    return this
}

deprecated("Use ViewManager.addView() instead")
public fun <T : View> __dslAddView(view: (ctx: Context) -> T, init: T.() -> Unit, manager: ViewManager): T {
    return manager.addView { ctx ->
        val v = view(ctx)
        v.init()
        v
    }
}

deprecated("Use Context.addView() instead")
public fun <T : View> __dslAddView(view: (ctx: Context) -> T, init: T.() -> Unit, ctx: Context): T {
    return ctx.addView { ctx ->
        val v = view(ctx)
        v.init()
        v
    }
}

deprecated("Use Activity.addView() instead")
public fun <T : View> __dslAddView(view: (ctx: Context) -> T, init: T.() -> Unit, act: Activity): T {
    return act.addView { ctx ->
        val v = view(ctx)
        v.init()
        v
    }
}

deprecated("Use Fragment.addView() instead")
public fun <T : View> __dslAddView(view: (ctx: Context) -> T, init: T.() -> Unit, fragment: Fragment): T {
    return fragment.addView { ctx ->
        val v = view(ctx)
        v.init()
        v
    }
}

private fun applyStyle(v: View, style: (View) -> Unit) {
    style(v)
    if (v is ViewGroup) {
        val maxId = v.getChildCount() - 1
        for (i in 0..maxId) {
            val maybeChild = v.getChildAt(i)
            if (maybeChild != null) applyStyle(maybeChild, style)
        }
    }
}

public fun Context.UI(setContentView: Boolean, init: UiHelper.() -> Unit): UiHelper {
    val dsl = UiHelper(this, setContentView)
    dsl.init()
    return dsl
}

public fun Context.UI(init: UiHelper.() -> Unit): UiHelper {
    val dsl = UiHelper(this, false)
    dsl.init()
    return dsl
}

public fun Activity.UI(init: UiHelper.() -> Unit): UiHelper = UI(true, init)

public fun Fragment.UI(init: UiHelper.() -> Unit): UiHelper = getActivity().UI(false, init)

