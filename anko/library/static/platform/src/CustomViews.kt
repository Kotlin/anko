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

@file:Suppress("NOTHING_TO_INLINE")
package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import org.jetbrains.anko.custom.ankoView

object `$$Anko$Factories$CustomViews` {
    val VERTICAL_LAYOUT_FACTORY = { ctx: Context ->
        val view = _LinearLayout(ctx)
        view.orientation = LinearLayout.VERTICAL
        view
    }
}

inline fun ViewManager.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun ViewManager.verticalLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun Context.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun Context.verticalLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun Activity.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun Activity.verticalLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun <T: View> ViewManager.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> ViewManager.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}

inline fun <T: View> Context.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> Context.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}

inline fun <T: View> Activity.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> Activity.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}