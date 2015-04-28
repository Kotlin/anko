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

package org.jetbrains.anko.internals

import android.content.Context
import android.app.Activity
import android.app.UiModeManager
import android.content.Intent
import android.content.res.Configuration
import java.io.Serializable
import android.os.Bundle
import org.jetbrains.anko.*
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import java.util.*

public fun Context.internalStartActivity(activity: Class<out Activity>, params: Array<out Pair<String, Any>>) {
    val intent = Intent(this, activity)
    fillIntentArguments(intent, params)
    startActivity(intent)
}

public fun Activity.internalStartActivityForResult(activity: Class<out Activity>, requestCode: Int, params: Array<out Pair<String, Any>>) {
    val intent = Intent(this, activity)
    fillIntentArguments(intent, params)
    startActivityForResult(intent, requestCode)
}

private fun fillIntentArguments(intent: Intent, params: Array<out Pair<String, Any>>) {
    params.forEach {
        when (it.second) {
            is Int -> intent.putExtra(it.first, it.second as Int)
            is Long -> intent.putExtra(it.first, it.second as Long)
            is CharSequence -> intent.putExtra(it.first, it.second as CharSequence)
            is String -> intent.putExtra(it.first, it.second as String)
            is Float -> intent.putExtra(it.first, it.second as Float)
            is Double -> intent.putExtra(it.first, it.second as Double)
            is Char -> intent.putExtra(it.first, it.second as Char)
            is Short -> intent.putExtra(it.first, it.second as Short)
            is Boolean -> intent.putExtra(it.first, it.second as Boolean)
            is Long -> intent.putExtra(it.first, it.second as Long)
            is Serializable -> intent.putExtra(it.first, it.second as Serializable)
            is Bundle -> intent.putExtra(it.first, it.second as Bundle)
            else -> throw AnkoException("Intent extra ${it.first} has wrong type ${it.second.javaClass.getName()}")
        }
    }
}

// SQLiteDatabase is not closeable in older versions of Android
public inline fun <T> SQLiteDatabase.useDatabase(f: (SQLiteDatabase) -> T) : T {
    try {
        return f(this)
    } finally {
        try {
            close()
        } catch (e: Exception) {
            // Do nothing
        }
    }
}

// Cursor is not closeable in older versions of Android
public inline fun <T> Cursor.useCursor(f: (Cursor) -> T) : T {
    try {
        return f(this)
    } finally {
        try {
            close()
        } catch (e: Exception) {
            // Do nothing
        }
    }
}

public fun <T : View> initiateView(ctx: Context, viewClass: Class<T>): T {
    fun getConstructor1() = viewClass.getConstructor(javaClass<Context>())
    fun getConstructor2() = viewClass.getConstructor(javaClass<Context>(), javaClass<AttributeSet>())
    fun getConstructor3() = viewClass.getConstructor(javaClass<Context>(), javaClass<AttributeSet>(), javaClass<Int>())

    try {
        return getConstructor1().newInstance(ctx)
    } catch (e: NoSuchMethodException) {
        try {
            return getConstructor2().newInstance(ctx, null)
        }
        catch (e: NoSuchMethodException) {
            try {
                return getConstructor3().newInstance(ctx, null, 0)
            }
            catch (e: NoSuchMethodException) {
                throw AnkoException("Can't initiate View of class ${viewClass.getName()}: can't find proper constructor")
            }
        }
    }

}

public fun Context.testConfiguration(
        screenSize: ScreenSize?,
        density: Range<Int>?,
        language: String?,
        long: Boolean?,
        fromSdk: Int?,
        sdk: Int?,
        uiMode: UiMode?,
        nightMode: Boolean?,
        rightToLeft: Boolean?,
        smallestWidth: Int?
): Boolean {
    val config = getResources().getConfiguration()

    if (screenSize != null) {
        val currentScreenSize = config.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
        when (currentScreenSize) {
            Configuration.SCREENLAYOUT_SIZE_UNDEFINED -> {}
            Configuration.SCREENLAYOUT_SIZE_SMALL -> if (screenSize != ScreenSize.SMALL) return false
            Configuration.SCREENLAYOUT_SIZE_NORMAL -> if (screenSize != ScreenSize.NORMAL) return false
            Configuration.SCREENLAYOUT_SIZE_LARGE -> if (screenSize != ScreenSize.LARGE) return false
            Configuration.SCREENLAYOUT_SIZE_XLARGE -> if (screenSize != ScreenSize.XLARGE) return false
        }
    }

    if (density != null) {
        val currentDensityDpi = getResources().getDisplayMetrics().densityDpi
        if (currentDensityDpi !in density || currentDensityDpi == density.end) return false
    }

    if (language != null) {
        val locale = Locale.getDefault()
        val currentLanguage = if (language.indexOf('_') >= 0) locale.toString() else locale.getLanguage()
        if (currentLanguage != language) return false
    }

    if (long != null) {
        val currentLong = config.screenLayout and Configuration.SCREENLAYOUT_LONG_MASK
        if (currentLong == Configuration.SCREENLAYOUT_LONG_YES && !long) return false
        if (currentLong == Configuration.SCREENLAYOUT_LONG_NO && long) return false
    }

    if (fromSdk != null) {
        if (Build.VERSION.SDK_INT < fromSdk) return false
    }

    if (sdk != null) {
        if (Build.VERSION.SDK_INT != fromSdk) return false
    }

    if (uiMode != null) {
        when (config.uiMode and Configuration.UI_MODE_TYPE_MASK) {
            Configuration.UI_MODE_TYPE_NORMAL -> if (uiMode != UiMode.NORMAL) return false
            Configuration.UI_MODE_TYPE_DESK -> if (uiMode != UiMode.DESK) return false
            Configuration.UI_MODE_TYPE_CAR -> if (uiMode != UiMode.CAR) return false
            Configuration.UI_MODE_TYPE_TELEVISION -> if (uiMode != UiMode.TELEVISION) return false
            InternalConfiguration.UI_MODE_TYPE_APPLIANCE -> if (uiMode != UiMode.APPLIANCE) return false
            InternalConfiguration.UI_MODE_TYPE_WATCH -> if (uiMode != UiMode.WATCH) return false
        }
    }

    if (nightMode != null) {
        val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as? UiModeManager
        if (uiModeManager != null) {
            val currentMode = uiModeManager.getNightMode()
            if (currentMode == UiModeManager.MODE_NIGHT_YES && !nightMode) return false
            if (currentMode == UiModeManager.MODE_NIGHT_NO && nightMode) return false
        }
    }

    if (rightToLeft != null) {
        val rtlMode = (config.screenLayout and InternalConfiguration.SCREENLAYOUT_LAYOUTDIR_MASK) == InternalConfiguration.SCREENLAYOUT_LAYOUTDIR_RTL
        if (rtlMode != rightToLeft) return false
    }

    if (smallestWidth != null) {
        if (configuration.smallestScreenWidthDp == Configuration.SMALLEST_SCREEN_WIDTH_DP_UNDEFINED) {
            if (smallestWidth != Configuration.SMALLEST_SCREEN_WIDTH_DP_UNDEFINED) return false
        }
        else if (configuration.smallestScreenWidthDp < smallestWidth) return false
    }

    return true
}

// Some constants not present in Android SDK v.15
private object InternalConfiguration {
    val SCREENLAYOUT_LAYOUTDIR_MASK = 0xC0
    val SCREENLAYOUT_LAYOUTDIR_SHIFT = 6
    val SCREENLAYOUT_LAYOUTDIR_RTL = 0x02 shl SCREENLAYOUT_LAYOUTDIR_SHIFT

    val UI_MODE_TYPE_APPLIANCE = 0x05
    val UI_MODE_TYPE_WATCH = 0x06

    val DENSITY_DPI_NONE = 0xffff
}