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

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class UnsupportedClassException : RuntimeException()

internal val DEBUG = false

internal fun Float.prettifyNumber() = toDouble().prettifyNumber()

internal fun Double.prettifyNumber(): String {
    val df = DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH))
    df.maximumFractionDigits = 8
    var value = df.format(this)
    if (value.startsWith(".")) value = "0$value"
    return if (value.endsWith(".0")) value.replace(".0", "") else value
}

internal fun isNumeric(value: Any): Boolean {
    if (value is Float) {
        return (!java.lang.Float.isInfinite(value) && !value.isNaN())
    }
    if (value is Double) {
        return (!java.lang.Double.isInfinite(value) && !value.isNaN())
    }
    return (value is Int) || (value is Long)
}

internal fun decapitalize(s: String): String {
    if (s.isEmpty()) return s
    return Character.toLowerCase(s[0]) + s.substring(1)
}

internal fun wildcardToRegex(wildcard: String): String {
    val b = Buffer().append('^')
    wildcard.forEach { c -> when (c) {
        '*' -> b.append(".*")
        '?' -> b.append(".")
        '(', ')', '[', ']', '$', '^', '.', '{', '}', '|', '\\' -> b.append('\\').append(c)
        else -> b.append(c)
    }}
    return b.append('$').toString()
}