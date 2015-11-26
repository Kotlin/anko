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
import android.app.Fragment
import android.content.Context
import org.jetbrains.anko.internals.AnkoInternals

open class AnkoException(message: String = "") : RuntimeException(message)
class PropertyWithoutGetterException(name: String) : AnkoException("'$name' property does not have a getter")

//returns 0xC0C0C0 for 0xC0
val Int.gray: Int
    get() = this or (this shl 8) or (this shl 16)

//returns 0xFFABCDEF for 0xABCDEF
val Int.opaque: Int
    get() = this or 0xff000000.toInt()


enum class ScreenSize {
    SMALL,
    NORMAL,
    LARGE,
    XLARGE
}

enum class UiMode {
    NORMAL,
    CAR,
    DESK,
    TELEVISION,
    APPLIANCE,
    WATCH
}

enum class Orientation {
    PORTRAIT,
    LANDSCAPE,
    SQUARE
}

inline fun <T: Any> Context.configuration(
        screenSize: ScreenSize? = null,
        density: ClosedRange<Int>? = null,
        language: String? = null,
        orientation: Orientation? = null,
        long: Boolean? = null,
        fromSdk: Int? = null,
        sdk: Int? = null,
        uiMode: UiMode? = null,
        nightMode: Boolean? = null,
        rightToLeft: Boolean? = null,
        smallestWidth: Int? = null,
        init: () -> T
): T? = if (AnkoInternals.testConfiguration(this, screenSize, density, language, orientation, long,
        fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth)) init() else null

inline fun <T: Any> Activity.configuration(
        screenSize: ScreenSize? = null,
        density: ClosedRange<Int>? = null,
        language: String? = null,
        orientation: Orientation? = null,
        long: Boolean? = null,
        fromSdk: Int? = null,
        sdk: Int? = null,
        uiMode: UiMode? = null,
        nightMode: Boolean? = null,
        rightToLeft: Boolean? = null,
        smallestWidth: Int? = null,
        init: () -> T
): T? = if (AnkoInternals.testConfiguration(this, screenSize, density, language, orientation, long,
        fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth)) init() else null

inline fun <T: Any> AnkoContext<*>.configuration(
        screenSize: ScreenSize? = null,
        density: ClosedRange<Int>? = null,
        language: String? = null,
        orientation: Orientation? = null,
        long: Boolean? = null,
        fromSdk: Int? = null,
        sdk: Int? = null,
        uiMode: UiMode? = null,
        nightMode: Boolean? = null,
        rightToLeft: Boolean? = null,
        smallestWidth: Int? = null,
        init: () -> T
): T? = if (AnkoInternals.testConfiguration(ctx, screenSize, density, language, orientation, long,
        fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth)) init() else null

inline fun <T: Any> Fragment.configuration(
        screenSize: ScreenSize? = null,
        density: ClosedRange<Int>? = null,
        language: String? = null,
        orientation: Orientation? = null,
        long: Boolean? = null,
        fromSdk: Int? = null,
        sdk: Int? = null,
        uiMode: UiMode? = null,
        nightMode: Boolean? = null,
        rightToLeft: Boolean? = null,
        smallestWidth: Int? = null,
        init: () -> T
): T? {
    val act = activity
    return if (act != null) {
        if (AnkoInternals.testConfiguration(act, screenSize, density, language, orientation, long,
                fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth)) init() else null
    }
    else null
}