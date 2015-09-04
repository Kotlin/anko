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

@file:suppress("NOTHING_TO_INLINE")

package org.jetbrains.anko

import android.content.Context
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout

public inline fun Fragment.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Fragment.verticalLayout(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit
): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.orientation = LinearLayout.VERTICAL
    view.init()
    view
}

public inline fun <T: View> Fragment.include(layoutId: Int): LinearLayout = include(layoutId, {})
public inline fun <T: View> Fragment.include(
        layoutId: Int,
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit
): T = addView { ctx ->
    val layoutInflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater
    @suppress("UNCHECKED_CAST")
    val view = layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}