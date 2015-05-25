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

package org.jetbrains.anko

import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import android.app.Fragment
import android.app.Activity
import android.content.BroadcastReceiver
import android.graphics.drawable.Drawable
import android.widget.EditText
import android.widget.RelativeLayout
import android.text.*
import android.util.TypedValue
import org.jetbrains.anko.custom.*
import org.jetbrains.anko.internals.noBinding

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun ViewManager.verticalLayout(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.setOrientation(LinearLayout.VERTICAL)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun Context.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Context.verticalLayout(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.setOrientation(LinearLayout.VERTICAL)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun Activity.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Activity.verticalLayout(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.setOrientation(LinearLayout.VERTICAL)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Fragment.verticalLayout(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.setOrientation(LinearLayout.VERTICAL)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <T: View> ViewManager.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> ViewManager.include(layoutId: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit): T = addView { ctx ->
    [suppress("UNCHECKED_CAST")]
    val view = ctx.layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <T: View> Activity.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> Activity.include(layoutId: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit): T = addView { ctx ->
    [suppress("UNCHECKED_CAST")]
    val view = ctx.layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <T: View> Fragment.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> Fragment.include(layoutId: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit): T = addView { ctx ->
    [suppress("UNCHECKED_CAST")]
    val view = ctx.layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <T: View> Context.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> Context.include(layoutId: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit): T = addView { ctx ->
    [suppress("UNCHECKED_CAST")]
    val view = ctx.layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}