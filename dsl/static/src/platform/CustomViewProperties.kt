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

import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView

public var View.backgroundColor: Int
    get() = throw PropertyWithoutGetterException("backgroundColor")
    set(value) = setBackgroundColor(value)

public var View.backgroundResource: Int
    get() = throw PropertyWithoutGetterException("backgroundResource")
    set(value) = setBackgroundResource(value)

public var View.background: Drawable
    get() = getBackground()
    set(value) = setBackgroundDrawable(value)

public var View.paddingLeft: Int
    get() = getPaddingLeft()
    set(value) = setPadding(value, getPaddingTop(), getPaddingRight(), getPaddingBottom())

public var View.paddingTop: Int
    get() = getPaddingTop()
    set(value) = setPadding(getPaddingLeft(), value, getPaddingRight(), getPaddingBottom())

public var View.paddingRight: Int
    get() = getPaddingRight()
    set(value) = setPadding(getPaddingLeft(), getPaddingTop(), value, getPaddingBottom())

public var View.paddingBottom: Int
    get() = getPaddingBottom()
    set(value) = setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), value)

public var View.paddingHorizontal: Int
    get() = throw PropertyWithoutGetterException("paddingHorizontal")
    set(value) = setPadding(value, getPaddingTop(), value, getPaddingBottom())

public var View.paddingVertical: Int
    get() = throw PropertyWithoutGetterException("paddingVertical")
    set(value) = setPadding(getPaddingLeft(), value, getPaddingRight(), value)

public var View.padding: Int
    get() = throw PropertyWithoutGetterException("padding")
    set(value) = setPadding(value, value, value, value)

public var TextView.isSelectable: Boolean
    get() = isTextSelectable
    set(value) = setTextIsSelectable(value)

public var TextView.textSizeDimen: Int
    get() = throw PropertyWithoutGetterException("textSizeDimen")
    set(value) = setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(value))

public var ImageView.image: Drawable?
    get() = drawable
    set(value) = setImageDrawable(value)