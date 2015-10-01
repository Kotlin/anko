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

package org.jetbrains.kotlin.android.robowrapper

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v4.widget.SlidingPaneLayout
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.TextUtils.TruncateAt
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.*
import org.jetbrains.kotlin.android.attrs.Attr
import org.robolectric.Shadows

// Render a ViewGroup.LayoutParams subclass, make a parameter list of (android:layout_...)
private fun renderLayoutParams(view: View, lp: ViewGroup.LayoutParams, topLevel: Boolean): String {
    val props = Buffer().append(" ")
    val present = hashSetOf<String>()

    fun addProperty(key: String, value: String) {
        if (key in present) return
        props.append("android:layout_").append(key).append("=\"").append(value).append("\" ")
    }
    // Add a RelativeLayout property.
    // Contains RelativeLayout.TRUE=-1 if set, 0 if unset, other possible values contains view id
    fun addRLProp(key: String, value: Int) {
        if (value == 0) return
        val v = if (value == RelativeLayout.TRUE) "true" else ("@+id/gen" + (value.toString().replace("-", "_")))
        addProperty(key, v)
    }
    // Handle some special cases for layout dimension value
    fun addDimension(key: String, value: Int, default: String? = null) {
        val dim = when(value) {
            ViewGroup.LayoutParams.MATCH_PARENT -> "match_parent"
            ViewGroup.LayoutParams.WRAP_CONTENT -> "wrap_content"
            else -> resolveDimension(view, "", value.toString())
        }
        if (default != null && dim == default) return
        addProperty(key, dim)
    }

    // These parameters are mandatory
    if (topLevel) {
        addDimension("width", ViewGroup.LayoutParams.MATCH_PARENT)
        addDimension("height", ViewGroup.LayoutParams.MATCH_PARENT)
    } else {
        addDimension("width", lp.width)
        addDimension("height", lp.height)
    }

    if (lp is LinearLayout.LayoutParams) {
        val gravity = resolveGravity(lp.gravity)
        if (gravity != null) addProperty("gravity", gravity)
        if (lp.weight != 0f) {
            val weight = lp.weight
            addProperty("weight", weight.prettifyNumber())
        }
    }
    if (lp is MarginLayoutParams) {
        addDimension("marginTop", lp.topMargin, "0dp")
        addDimension("marginLeft", lp.leftMargin, "0dp")
        addDimension("marginRight", lp.rightMargin, "0dp")
        addDimension("marginBottom", lp.bottomMargin, "0dp")
        addDimension("marginStart", lp.marginStart, "0dp")
        addDimension("marginEnd", lp.marginEnd, "0dp")
    }
    if (lp is RelativeLayout.LayoutParams) {
        val rules = lp.rules
        relativeLayoutProperties.forEach { addRLProp(it.getKey(), rules[it.getValue()]) }
    }
    if (lp is TableRow.LayoutParams) {
        if (lp.column != -1) addProperty("column", lp.column.toString())
        if (lp.span != -1) addProperty("span", lp.span.toString())
    }
    if (lp is FrameLayout.LayoutParams) {
        val gravity = resolveGravity(lp.gravity)
        if (gravity != null) addProperty("gravity", gravity)
    }
    if (lp is AbsoluteLayout.LayoutParams) {
        addDimension("x", lp.x)
        addDimension("y", lp.y)
    }
    try {
        if (lp is SlidingPaneLayout.LayoutParams) {
            addProperty("weight", lp.weight.prettifyNumber())
        }
    } catch (e: Throwable) { /* it's ok */ }

    return props.toString()
}

// Convert px value to dp (independent to screen size)
internal fun Context.px2dip(value: Int): Float {
    val metrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, value.toFloat(), metrics)
}

/**
    RenderAttr entry point.
    Handle all special cases (such as id, layoutParams or etc)
    @returns null if attr was not parsed properly
 */
internal fun renderAttribute(view: View, attr: Attr?, key: String, value: Any, topLevel: Boolean): String? {
    if (key == "gravity") {
        return resolveGravity(value.toString().toInt())
    }
    if (key == "id") {
        val id = value.toString()
        if (id == "-1") return null
        // Generate a layout-local id
        return "@+id/gen" + (value.toString().replace('-', '_'))
    }
    if (key == "layoutParams" && value is ViewGroup.LayoutParams) {
        return renderLayoutParams(view, value, topLevel)
    }
    if (value is ImageView.ScaleType) {
        return convertScaleType(value)
    }
    if (value is TruncateAt) {
        return convertEllipsize(value)
    }
    if (value is ColorDrawable) { //just return a color if value is a ColorDrawable
        val hex = Integer.toHexString(value.color)
        //omit transparency part if not transparent
        return "#" + if (hex.startsWith("ff")) hex.substring(2) else hex
    }
    // Not a color drawable
    if (value is Drawable) {
        val drawableAttributeValue = renderDrawableAttribute(value, view)
        if (drawableAttributeValue != null) return drawableAttributeValue
    }
    if (attr != null) {
        if ("color" in attr.format) {
            if (value is Int) return "#" + Integer.toHexString(value)
            if (value is Long) return "#" + java.lang.Long.toHexString(value)
        }

        if ("dimension" in attr.format || key in dimensionProperties) {
            return resolveDimension(view, key, value.toString())
        }
        val attrEnum = attr.enum
        if ("enum" in attr.format && attrEnum != null) {
            for (nv in attrEnum) {
                val enumValue = nv.value.parseEnumFlagValue()
                if (enumValue.toString().equals(basicRenderAttr(key, value))) {
                    return nv.name
                }
            }
        }
        if ("flags" in attr.format && attr.flags != null) {
            return parseFlags(value.toString().toLong(), attr)
        }
        // If our property contains nothing but enum and flags, and string representation not found, exit
        if (attr.format.size() == 1 && attr.format[0] == "enum") return null
        if (attr.format.size() == 1 && attr.format[0] == "flags") return null
    }
    // (key, value) pair is not special
    return basicRenderAttr(key, value)
}

private fun renderDrawableAttribute(value: android.graphics.drawable.Drawable, view: android.view.View): String? {
    // Actual resourceId is stored in a ShadowDrawable
    val drawable = Shadows.shadowOf(value)
    if (drawable != null) {
        val resourceId = drawable.createdFromResId
        if (resourceId != -1) {
            val resourceLoader = Shadows.shadowOf(view.context).resourceLoader
            // Convert Int id to a string representation (@package:resource)
            val resourceName = resourceLoader?.getNameForId(resourceId)
            if (resourceName != null) {
                return "@$resourceName"
            }
        }
    }
    return null
}

internal fun String.parseEnumFlagValue(): Long {
    if (startsWith("0x") && length() > 2) {
        return java.lang.Long.parseLong(substring(2), 16)
    } else return toLong()
}

// Convert several types of values to a string representation
internal fun basicRenderAttr(key: String, value: Any): String? {
    when (value) {
        is Int, is Long -> return value.toString()
        is Float -> return value.prettifyNumber()
        is Double -> return value.prettifyNumber()
        is String -> return value
        is SpannedString -> return value.toString()
        is SpannableStringBuilder -> return value.toString()
        is Boolean -> return if (value) "true" else "false"
        else -> {
            if (DEBUG) {
                System.err.println("Failed to parse property key=$key type ${value.javaClass.name}")
            }
            return null
        }
    }
}

private fun parseFlags(value: Long, attr: Attr): String {
    val present = hashSetOf<String>()
    attr.flags?.forEach { nv ->
        val flagValue = nv.value.parseEnumFlagValue()
        if ((value and flagValue) == flagValue) {
            present.add(nv.name)
        }
    }
    return present.joinToString("|")
}
