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

package org.jetbrains.anko.custom

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import org.jetbrains.anko.AnkoException
import org.jetbrains.anko.UI
import org.jetbrains.anko.UiHelper
import org.jetbrains.anko.internals.initiateView

public inline fun <T: View> ViewManager.addView(factory: (ctx: Context) -> T): T {
    return when (this) {
        is ViewGroup -> {
            val view = factory(this.getContext())
            addView(view)
            view
        }
        is UiHelper -> {
            val view = factory(ctx)
            addView(view, null)
            view
        }
        else -> throw AnkoException("$this is the wrong parent")
    }
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <T: View> ViewManager.addView(view: T): T {
    when (this) {
        is ViewGroup -> {
            addView(view)
        }
        is UiHelper -> {
            addView(view, null)
        }
        else -> throw AnkoException("$this is the wrong parent")
    }
    return view
}

public inline fun <T : View> Fragment.addView(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) factory: (ctx: Context) -> T): T {
    val view = factory(getActivity())
    UI { addView(view) }
    return view
}

public inline fun <T : View> Context.addView(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) factory: (ctx: Context) -> T): T {
    val view = factory(this)
    UI { addView(view) }
    return view
}

public inline fun <T : View> Activity.addView(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) factory: (ctx: Context) -> T): T {
    val view = factory(this)
    UI { addView(view) }
    return view
}

public inline fun <reified T : View> Context.view(init: T.() -> Unit): T {
    val view = initiateView(this, javaClass<T>())
    view.init()
    return view
}