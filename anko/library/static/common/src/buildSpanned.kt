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

package org.jetbrains.anko

import android.graphics.*
import android.text.*
import android.text.style.*
import org.jetbrains.anko.collections.forEachByIndex

inline fun buildSpanned(f: SpannableStringBuilder.() -> Unit): Spanned {
    return SpannableStringBuilder().apply(f)
}

val SpannableStringBuilder.Bold: StyleSpan
    get() = StyleSpan(Typeface.BOLD)

val SpannableStringBuilder.Italic: StyleSpan
    get() = StyleSpan(Typeface.ITALIC)

val SpannableStringBuilder.Underline: UnderlineSpan
    get() = UnderlineSpan()

val SpannableStringBuilder.Strikethrough: StrikethroughSpan
    get() = StrikethroughSpan()

fun SpannableStringBuilder.foregroundColor(color: Int): ForegroundColorSpan {
    return ForegroundColorSpan(color)
}

fun SpannableStringBuilder.backgroundColor(color: Int): BackgroundColorSpan {
    return BackgroundColorSpan(color)
}

fun SpannableStringBuilder.append(text: CharSequence, vararg spans: Any) {
    val textLength = text.length
    append(text)
    spans.forEachByIndex { span ->
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

fun SpannableStringBuilder.appendln(text: CharSequence, vararg spans: Any) {
    append(text, *spans)
    appendln()
}

fun SpannableStringBuilder.appendln(text: CharSequence, span: Any) {
    append(text, span)
    appendln()
}