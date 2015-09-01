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

import com.google.gson.Gson
import org.jetbrains.kotlin.android.attrs.Attrs
import org.jetbrains.kotlin.android.attrs.readResource
import java.util.regex.Pattern

private val XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n"
private val XML_SCHEMA = """ xmlns:android="http://schemas.android.com/apk/res/android" """

/*
    Key-value pairs that won't be present in result xml. Usually default values for attrs (or convert fixes).
    Line format: [<CLASSNAME>#]<PROPNAME>:<VALUE1>:<VALUE2>:...:<VALUEn>
 */
private val defaultValues = readResource("default_values.txt")
        .split('\n').filter { it.length() > 2 }.fold(hashMapOf<String, List<Any>>()) { hmap, value ->
    val delimiter = value.indexOf(' ')
    val key = value.substring(0, delimiter)
    val values = value.substring(delimiter + 1)
    hmap.put(key, values.split(' ').map {
        if (it.contains("*") || it.contains("?")) {
            Pattern.compile(wildcardToRegex(it))
        } else it
    })
    hmap
}

private val attrs = Gson().fromJson(readResource("attrs.json"), Attrs::class.java)

private val ignoredMethods = setOf(
        "getX", "getY", "getInputType", "getTextScaleX", "getTextScaleY",
        "isImportantForAccessibility", "getImportantForAccessibility",
        "getImeOptions", "getPersistentDrawingCache", "getDescendantFocusability"
)

private val ignoreChildrenOf = setOf(
        "android.widget.CalendarView", "android.widget.TimePicker", "android.widget.DatePicker",
        "android.support.v4.view.PagerTabStrip", "android.widget.NumberPicker", "android.widget.SearchView"
)

private val androidViewPaths = setOf(
        "android.view.",
        "android.widget.",
        "android.appwidget.",
        "android.support.v4.app.",
        "android.support.v4.view.",
        "android.support.v4.widget.",
        "android.support.v7.",
        "android.support.v13.app."
)

val dimensionProperties = setOf(
        "maxWidth",
        "maxHeight",
        "minWidth",
        "minHeight",
        "dropDownVerticalOffset",
        "dropDownHorizontalOffset"
)