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
package org.jetbrains.anko

import android.os.Build
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.internals.AnkoInternals.NO_GETTER
import org.jetbrains.anko.internals.AnkoInternals.noGetter
import kotlin.DeprecationLevel.ERROR

var View.backgroundDrawable: Drawable?
    inline get() = background
    set(value) = setBackgroundDrawable(value)

var View.backgroundColorResource: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(colorId) = setBackgroundColor(context.resources.getColor(colorId))

var View.leftPadding: Int
    inline get() = paddingLeft
    set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

var View.topPadding: Int
    inline get() = paddingTop
    set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

var View.rightPadding: Int
    inline get() = paddingRight
    set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

var View.bottomPadding: Int
    inline get() = paddingBottom
    set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

@Deprecated("Use horizontalPadding instead", ReplaceWith("horizontalPadding"))
var View.paddingHorizontal: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(value, paddingTop, value, paddingBottom)

var View.horizontalPadding: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(value, paddingTop, value, paddingBottom)

@Deprecated("Use verticalPadding instead", ReplaceWith("verticalPadding"))
var View.paddingVertical: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(paddingLeft, value, paddingRight, value)

var View.verticalPadding: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setPadding(paddingLeft, value, paddingRight, value)

var View.padding: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setPadding(value, value, value, value)

var TextView.allCaps: Boolean
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setAllCaps(value)

var TextView.ems: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) = setEms(value)

inline var TextView.isSelectable: Boolean
    get() = isTextSelectable
    set(value) = setTextIsSelectable(value)

var TextView.textAppearance: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = if (Build.VERSION.SDK_INT >= 23) setTextAppearance(value) else setTextAppearance(context, value)

var TextView.textSizeDimen: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(value))

var TextView.textColorResource: Int
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(colorId) = setTextColor(context.resources.getColor(colorId))

var ImageView.image: Drawable?
    inline get() = drawable
    inline set(value) = setImageDrawable(value)
