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

package org.jetbrains.anko.db

import android.database.Cursor
import android.database.sqlite.SQLiteException
import java.util.ArrayList
import java.lang.reflect.Modifier
import org.jetbrains.anko.AnkoException
import org.jetbrains.anko.internals.useDatabase
import org.jetbrains.anko.internals.useCursor

public trait RowParser<T> {
    fun parseRow(columns: Array<Any>): T
}

public trait MapRowParser<T> {
    fun parseRow(columns: Map<String, Any>): T
}

private class SingleColumnParser<T> : RowParser<T> {
    override fun parseRow(columns: Array<Any>): T {
        if (columns.size() != 0)
            throw SQLiteException("Invalid row: row for SingleColumnParser must contain exactly one column")
        [suppress("UNCHECKED_CAST")]
        return columns[0] as T
    }
}

private class ScalarColumnParser<R, T>(val modifier: ((R) -> T)? = null) : RowParser<T> {
    override fun parseRow(columns: Array<Any>): T {
        if (columns.size() != 0)
            throw SQLiteException("Invalid row: row for SingleColumnParser must contain exactly one column")
        [suppress("UNCHECKED_CAST", "UNNECESSARY_NOT_NULL_ASSERTION")]
        return if (modifier != null)
            modifier!!(columns[0] as R)
        else
            columns[0] as T
    }
}

public val ShortParser: RowParser<Short> = ScalarColumnParser<Long, Short> { it.toShort() }
public val IntParser: RowParser<Int> = ScalarColumnParser<Long, Int> { it.toInt() }
public val LongParser: RowParser<Long> = SingleColumnParser()
public val FloatParser: RowParser<Float> = ScalarColumnParser<Double, Float> { it.toFloat() }
public val DoubleParser: RowParser<Double> = SingleColumnParser()
public val StringParser: RowParser<String> = SingleColumnParser()
public val BlobParser: RowParser<ByteArray> = SingleColumnParser()

public fun <T: Any> Cursor.parseSingle(parser: RowParser<T>): T = useCursor {
    if (getCount() != 1)
        throw SQLiteException("parseSingle accepts only cursors with a single entry")
    moveToFirst()
    return parser.parseRow(readColumnsArray(this))
}

public fun <T: Any> Cursor.parseOpt(parser: RowParser<T>): T? = useCursor {
    if (getCount() > 1)
        throw SQLiteException("parseSingle accepts only cursors with a single entry or empty cursors")
    if (getCount() == 0)
        return null
    moveToFirst()
    return parser.parseRow(readColumnsArray(this))
}

public fun <T: Any> Cursor.parseList(parser: RowParser<T>): List<T> = useCursor {
    val list = ArrayList<T>(getCount())
    moveToFirst()
    while (!isAfterLast()) {
        list.add(parser.parseRow(readColumnsArray(this)))
        moveToNext()
    }
    return list
}

public fun <T: Any> Cursor.parseSingle(parser: MapRowParser<T>): T = useCursor {
    if (getCount() != 1)
        throw SQLiteException("parseSingle accepts only cursors with getCount() == 1")
    moveToFirst()
    return parser.parseRow(readColumnsMap(this))
}

public fun <T: Any> Cursor.parseOpt(parser: MapRowParser<T>): T? = useCursor {
    if (getCount() > 1)
        throw SQLiteException("parseSingle accepts only cursors with getCount() == 1 or empty cursors")
    if (getCount() == 0)
        return null
    moveToFirst()
    return parser.parseRow(readColumnsMap(this))
}

public fun <T: Any> Cursor.parseList(parser: MapRowParser<T>): List<T> = useCursor {
    val list = ArrayList<T>(getCount())
    moveToFirst()
    while (!isAfterLast()) {
        list.add(parser.parseRow(readColumnsMap(this)))
        moveToNext()
    }
    return list
}

public fun Cursor.stream(): Stream<Array<Any>> {
    return CursorStream(this)
}

public fun Cursor.mapStream(): Stream<Map<String, Any>> {
    return CursorMapStream(this)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T> classParser(): RowParser<T> {
    val clazz = javaClass<T>()
    val constructors = clazz.getDeclaredConstructors().filter {
        val types = it.getParameterTypes()
        it.isAccessible() && !it.isVarArgs() && Modifier.isPublic(it.getModifiers()) &&
            types != null && types.size() > 0
    }
    if (constructors.isEmpty())
        throw AnkoException(
            "Can't initialize object parser for ${clazz.getCanonicalName()}, no acceptable constructors found")

    val c = constructors[0]

    for (type in c.getParameterTypes()) {
        [suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")]
        val valid = when (type) {
            javaClass<Long>(), javaClass<java.lang.Long>() -> true
            javaClass<Double>(), javaClass<java.lang.Double>() -> true
            javaClass<String>(), javaClass<ByteArray>() -> true
            else -> false
        }
        if (!valid)
            throw AnkoException(
                "Invalid argument type ${type.getCanonicalName()} in ${clazz.getCanonicalName()} constructor." +
                "Supported types are: Long, Double, String, Array<Byte>.")
    }

    return object : RowParser<T> {
        override fun parseRow(columns: Array<Any>): T {
            return c.newInstance(columns) as T
        }
    }
}

private fun readColumnsArray(cursor: Cursor): Array<Any> {
    val count = cursor.getColumnCount()
    val arr = arrayOfNulls<Any>(count)
    for (i in 0..(count - 1)) {
        arr[i] = when (cursor.getType(i)) {
            Cursor.FIELD_TYPE_INTEGER -> cursor.getLong(i)
            Cursor.FIELD_TYPE_FLOAT -> cursor.getDouble(i)
            Cursor.FIELD_TYPE_STRING -> cursor.getString(i)
            Cursor.FIELD_TYPE_BLOB -> cursor.getBlob(i)
            else -> Unit
        }
    }
    [suppress("CAST_NEVER_SUCCEEDS")]
    return arr as Array<Any>
}

private fun readColumnsMap(cursor: Cursor): Map<String, Any> {
    val count = cursor.getColumnCount()
    val map = hashMapOf<String, Any>()
    for (i in 0..(count - 1)) {
        map.put(cursor.getColumnName(i), when (cursor.getType(i)) {
            Cursor.FIELD_TYPE_INTEGER -> cursor.getLong(i)
            Cursor.FIELD_TYPE_FLOAT -> cursor.getDouble(i)
            Cursor.FIELD_TYPE_STRING -> cursor.getString(i)
            Cursor.FIELD_TYPE_BLOB -> cursor.getBlob(i)
            else -> Unit
        })
    }
    return map
}

private class CursorMapStream(val cursor: Cursor) : Stream<Map<String, Any>> {
    override fun iterator(): Iterator<Map<String, Any>> {
        return CursorMapIterator(cursor)
    }
}

private class CursorStream(val cursor: Cursor) : Stream<Array<Any>> {
    override fun iterator(): Iterator<Array<Any>> {
        return CursorIterator(cursor)
    }
}

private class CursorIterator(val cursor: Cursor) : Iterator<Array<Any>> {
    override fun next(): Array<Any> {
        cursor.moveToNext()
        return readColumnsArray(cursor)
    }

    override fun hasNext(): Boolean {
        return cursor.getPosition() < cursor.getCount() - 1
    }
}

private class CursorMapIterator(val cursor: Cursor) : Iterator<Map<String, Any>> {
    override fun next(): Map<String, Any> {
        cursor.moveToNext()
        return readColumnsMap(cursor)
    }

    override fun hasNext(): Boolean {
        return cursor.getPosition() < cursor.getCount() - 1
    }
}