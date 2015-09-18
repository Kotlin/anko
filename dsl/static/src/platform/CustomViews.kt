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
@file:JvmMultifileClass
@file:JvmName("CustomViewsKt")
package org.jetbrains.anko

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import org.jetbrains.anko.custom.ankoView

public object `$$Anko$Factories$CustomViews` {
    public val VERTICAL_LAYOUT_FACTORY = { ctx: Context ->
        val view = _LinearLayout(ctx)
        view.orientation = LinearLayout.VERTICAL
        view
    }
}

public inline fun ViewManager.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun ViewManager.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, init)
}

public inline fun Context.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Context.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, init)
}

public inline fun Activity.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Activity.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$CustomViews`.VERTICAL_LAYOUT_FACTORY, init)
}

public inline fun <T: View> ViewManager.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> ViewManager.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }) { init() }
}

public inline fun <T: View> Context.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> Context.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }) { init() }
}

public inline fun <T: View> Activity.include(layoutId: Int): T = include(layoutId, {})
public inline fun <T: View> Activity.include(layoutId: Int, init: T.() -> Unit): T {
    @Suppress("UNCHECKED_CAST")
    return ankoView({ ctx -> ctx.layoutInflater.inflate(layoutId, null) as T }) { init() }
}