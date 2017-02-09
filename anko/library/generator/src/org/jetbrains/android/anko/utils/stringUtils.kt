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

package org.jetbrains.android.anko.utils

fun String.toCamelCase(separator: Char = '_', firstCapital: Boolean = true): String {
    val builder = StringBuilder()
    var capitalFlag = firstCapital
    for (c in this) {
        when (c) {
            separator -> capitalFlag = true
            else -> {
                builder.append(if (capitalFlag) Character.toUpperCase(c) else Character.toLowerCase(c))
                capitalFlag = false
            }
        }
    }
    return builder.toString()
}

internal fun String.toUPPER_CASE(): String {
    val builder = StringBuilder()
    for (c in this) {
        if (c.isUpperCase() && builder.isNotEmpty()) builder.append('_')
        builder.append(c.toUpperCase())
    }
    return builder.toString()
}

val Char.isPackageSymbol: Boolean
    get() = isLowerCase() || isDigit() || this == '_'