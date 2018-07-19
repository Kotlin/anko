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

@file:Suppress("unused", "NOTHING_TO_INLINE")
package org.jetbrains.anko

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.view.View

inline fun buildSpanned(f: SpannableStringBuilder.() -> Unit): Spanned =
        SpannableStringBuilder().apply(f)

inline val SpannableStringBuilder.Bold: StyleSpan
    get() = StyleSpan(Typeface.BOLD)

inline val SpannableStringBuilder.Italic: StyleSpan
    get() = StyleSpan(Typeface.ITALIC)

inline val SpannableStringBuilder.Underline: UnderlineSpan
    get() = UnderlineSpan()

inline val SpannableStringBuilder.Strikethrough: StrikethroughSpan
    get() = StrikethroughSpan()

inline fun SpannableStringBuilder.foregroundColor(color: Int): ForegroundColorSpan =
        ForegroundColorSpan(color)

inline fun SpannableStringBuilder.backgroundColor(color: Int): BackgroundColorSpan =
        BackgroundColorSpan(color)

inline fun SpannableStringBuilder.clickable(crossinline onClick: (View) -> Unit): ClickableSpan {
    return object : ClickableSpan() {
        override fun onClick(widget: View) {
            onClick(widget)
        }
    }
}

inline fun SpannableStringBuilder.link(url: String): URLSpan {
    return URLSpan(url)
}

fun SpannableStringBuilder.append(text: CharSequence, vararg spans: Any) {
    val textLength = text.length
    append(text)
    spans.forEach { span ->
        setSpan(span, this.length - textLength, length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    }
}

fun SpannableStringBuilder.append(text: CharSequence, span: Any) {
    val textLength = text.length
    append(text)
    setSpan(span, this.length - textLength, length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
}

inline fun SpannableStringBuilder.append(span: Any, f: SpannableStringBuilder.() -> Unit) = apply {
    val start = length
    f()
    setSpan(span, start, length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
}

inline fun SpannableStringBuilder.appendln(text: CharSequence, vararg spans: Any) {
    append(text, *spans)
    appendln()
}

inline fun SpannableStringBuilder.appendln(text: CharSequence, span: Any) {
    append(text, span)
    appendln()
}
