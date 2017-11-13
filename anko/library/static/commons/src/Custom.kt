/*
 * Copyright 2016 JetBrains s.r.o.
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

@file:Suppress("unused")
package org.jetbrains.anko.custom

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.internals.AnkoInternals


inline fun <T : View> ViewManager.ankoView(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(AnkoInternals.getContext(this), theme)
    val view = factory(ctx)
    view.init()
    AnkoInternals.addView(this, view)
    return view
}

inline fun <T : View> Context.ankoView(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(this, theme)
    val view = factory(ctx)
    view.init()
    AnkoInternals.addView(this, view)
    return view
}

inline fun <T : View> Activity.ankoView(factory: (ctx: Context) -> T, theme: Int, init: T.() -> Unit): T {
    val ctx = AnkoInternals.wrapContextIfNeeded(this, theme)
    val view = factory(ctx)
    view.init()
    AnkoInternals.addView(this, view)
    return view
}

inline fun <reified T : View> ViewManager.customView(theme: Int = 0, init: T.() -> Unit): T =
        ankoView({ ctx -> AnkoInternals.initiateView(ctx, T::class.java) }, theme) { init() }

inline fun <reified T : View> Context.customView(theme: Int = 0, init: T.() -> Unit): T =
        ankoView({ ctx -> AnkoInternals.initiateView(ctx, T::class.java) }, theme) { init() }

inline fun <reified T : View> Activity.customView(theme: Int = 0, init: T.() -> Unit): T =
        ankoView({ ctx -> AnkoInternals.initiateView(ctx, T::class.java) }, theme) { init() }