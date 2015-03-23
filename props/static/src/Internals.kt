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

package kotlinx.android.anko.internals

import android.content.Context
import android.app.Activity
import android.content.Intent
import java.io.Serializable
import android.os.Bundle
import kotlinx.android.anko.*
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor

public fun Context.__internalStartActivity(activity: Class<out Activity>, params: Array<out Pair<String, Any>>) {
    val intent = Intent(this, activity)
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
    startActivity(intent)
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