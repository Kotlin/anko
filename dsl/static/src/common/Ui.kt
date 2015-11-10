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

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager

fun <T : View> T.style(style: (View) -> Unit): T {
    applyStyle(this, style)
    return this
}

private fun applyStyle(v: View, style: (View) -> Unit) {
    style(v)
    if (v is ViewGroup) {
        val maxIndex = v.childCount - 1
        for (i in 0 .. maxIndex) {
            v.getChildAt(i)?.let { applyStyle(it, style) }
        }
    }
}

@Deprecated("Use AnkoContext instead")
class UiHelper(val ctx: Context, private val setContentView: Boolean = true) : ViewManager {
    private lateinit var view: View

    fun toView() = view

    override fun addView(view: View, params: ViewGroup.LayoutParams?) {
        this.view = view
        if (setContentView) {
            when (ctx) {
                is Activity -> ctx.setContentView(view)
                else -> {}
            }
        }
    }

    override fun updateViewLayout(view: View, params: ViewGroup.LayoutParams) {
        throw UnsupportedOperationException()
    }

    override fun removeView(view: View) {
        throw UnsupportedOperationException()
    }
}