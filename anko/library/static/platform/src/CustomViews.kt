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

@file:Suppress("NOTHING_TO_INLINE", "unused")
package org.jetbrains.anko

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import org.jetbrains.anko.custom.ankoView

@PublishedApi
internal object `$$Anko$Factories$CustomViews` {
    val VERTICAL_LAYOUT_FACTORY = { ctx: Context ->
        val view = _LinearLayout(ctx)
        view.orientation = LinearLayout.VERTICAL
        view
    }

    val EDIT_TEXT = { ctx: Context -> EditText(ctx) }

    val HORIZONTAL_PROGRESS_BAR_FACTORY = { ctx: Context ->
        ProgressBar(ctx, null, android.R.attr.progressBarStyleHorizontal)
    }
}

inline fun ViewManager.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun ViewManager.verticalLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun Context.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun Context.verticalLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun Activity.verticalLayout(theme: Int = 0): LinearLayout = verticalLayout(theme) {}
inline fun Activity.verticalLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, theme, init)
}

inline fun ViewManager.editText(constraints: InputConstraints, theme: Int = 0): EditText = editText(constraints, theme) {}
inline fun ViewManager.editText(constraints: InputConstraints, theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    val v = ankoView(`$$Anko$Factories$CustomViews`.EDIT_TEXT, theme, init)
    v.inputType = constraints.value
    return v
}

inline fun Context.editText(constraints: InputConstraints, theme: Int = 0): EditText = editText(constraints, theme) {}
inline fun Context.editText(constraints: InputConstraints, theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    val v = ankoView(`$$Anko$Factories$CustomViews`.EDIT_TEXT, theme, init)
    v.inputType = constraints.value
    return v
}

inline fun Activity.editText(constraints: InputConstraints, theme: Int = 0): EditText = editText(constraints, theme) {}
inline fun Activity.editText(constraints: InputConstraints, theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    val v = ankoView(`$$Anko$Factories$CustomViews`.EDIT_TEXT, theme, init)
    v.inputType = constraints.value
    return v
}

inline fun ViewManager.horizontalProgressBar(theme: Int = 0): ProgressBar = horizontalProgressBar(theme) {}
inline fun ViewManager.horizontalProgressBar(theme: Int = 0, init: (@AnkoViewDslMarker ProgressBar).() -> Unit): ProgressBar {
    return ankoView(`$$Anko$Factories$CustomViews`.HORIZONTAL_PROGRESS_BAR_FACTORY, theme, init)
}

inline fun Context.horizontalProgressBar(theme: Int = 0): ProgressBar = horizontalProgressBar(theme) {}
inline fun Context.horizontalProgressBar(theme: Int = 0, init: (@AnkoViewDslMarker ProgressBar).() -> Unit): ProgressBar {
    return ankoView(`$$Anko$Factories$CustomViews`.HORIZONTAL_PROGRESS_BAR_FACTORY, theme, init)
}

inline fun Activity.horizontalProgressBar(theme: Int = 0): ProgressBar = horizontalProgressBar(theme) {}
inline fun Activity.horizontalProgressBar(theme: Int = 0, init: (@AnkoViewDslMarker ProgressBar).() -> Unit): ProgressBar {
    return ankoView(`$$Anko$Factories$CustomViews`.HORIZONTAL_PROGRESS_BAR_FACTORY, theme, init)
}

inline fun <T: View> ViewManager.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> ViewManager.include(layoutId: Int, init: (@AnkoViewDslMarker T).() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}

inline fun <T: View> ViewGroup.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> ViewGroup.include(layoutId: Int, init: (@AnkoViewDslMarker T).() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, this, false) as T }, 0) { init() }
}

inline fun <T: View> Context.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> Context.include(layoutId: Int, init: (@AnkoViewDslMarker T).() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}

inline fun <T: View> Activity.include(layoutId: Int): T = include(layoutId, {})
inline fun <T: View> Activity.include(layoutId: Int, init: (@AnkoViewDslMarker T).() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }, 0) { init() }
}