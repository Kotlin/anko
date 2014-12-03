package kotlinx.android.koan.db

import android.database.Cursor
import android.database.sqlite.SQLiteException
import java.util.ArrayList
import java.lang.reflect.Modifier
import kotlinx.android.koan.KoanException

public trait RowParser<T> {
    fun parseRow(columns: Array<Any>): T
}

public trait RichRowParser<T> {
    fun parseRow(columns: Map<String, Any>): T
}

public class SingleColumnParser<T> : RowParser<T> {
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
        [suppress("UNCHECKED_CAST")]
        return if (modifier != null)
            modifier!!(columns[0] as R)
        else
            columns[0] as T
    }
}

public val ShortParser: RowParser<Short> = ScalarColumnParser<Long, Short> { it.toShort() }
public val IntParser: RowParser<Int> = ScalarColumnParser<Long, Int>  { it.toInt() }
public val LongParser: RowParser<Long> = SingleColumnParser()
public val FloatParser: RowParser<Float> = ScalarColumnParser<Double, Float> { it.toFloat() }
public val DoubleParser: RowParser<Double> = SingleColumnParser()
public val StringParser: RowParser<String> = SingleColumnParser()
public val BlobParser: RowParser<ByteArray> = SingleColumnParser()

public fun <T> Cursor.parseSingle(parser: RowParser<T>): T = withCursor {
    if (getCount() != 1)
        throw SQLiteException("parseSingle accepts only cursors with a single entry")
    moveToFirst()
    return parser.parseRow(readColumnsArray(this))
}

public fun <T> Cursor.parseOpt(parser: RowParser<T>): T? = withCursor {
    if (getCount() > 1)
        throw SQLiteException("parseSingle accepts only cursors with a single entry or empty cursors")
    if (getCount() == 0)
        return null
    moveToFirst()
    return parser.parseRow(readColumnsArray(this))
}

public fun <T> Cursor.parseList(parser: RowParser<T>): List<T> = withCursor {
    val list = ArrayList<T>(getCount())
    moveToFirst()
    while (!isAfterLast()) {
        list.add(parser.parseRow(readColumnsArray(this)))
        moveToNext()
    }
    return list
}

public fun <T> Cursor.parseSingle(parser: RichRowParser<T>): T = withCursor {
    if (getCount() != 1)
        throw SQLiteException("parseSingle accepts only cursors with getCount() == 1")
    moveToFirst()
    return parser.parseRow(readColumnsMap(this))
}

public fun <T> Cursor.parseOpt(parser: RichRowParser<T>): T? = withCursor {
    if (getCount() > 1)
        throw SQLiteException("parseSingle accepts only cursors with getCount() == 1 or empty cursors")
    if (getCount() == 0)
        return null
    moveToFirst()
    return parser.parseRow(readColumnsMap(this))
}

public fun <T> Cursor.parseList(parser: RichRowParser<T>): List<T> = withCursor {
    val list = ArrayList<T>(getCount())
    moveToFirst()
    while (!isAfterLast()) {
        list.add(parser.parseRow(readColumnsMap(this)))
        moveToNext()
    }
    return list
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T> rowParser(): RowParser<T> {
    val clazz = javaClass<T>()
    val constructors = clazz.getDeclaredConstructors().filter {
        val types = it.getParameterTypes()
        it.isAccessible() && !it.isVarArgs() && Modifier.isPublic(it.getModifiers()) &&
            types != null && types.size() > 0
    }
    if (constructors.isEmpty())
        throw KoanException(
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
            throw KoanException(
                "Invalid argument type ${type.getCanonicalName()} in ${clazz.getCanonicalName()} constructor." +
                "Supported types are: Long, Double, String, Array<Byte>.")
    }

    return object : RowParser<T> {
        override fun parseRow(columns: Array<Any>): T {
            return c.newInstance(columns) as T
        }
    }
}

private inline fun <T> Cursor.withCursor(init: Cursor.() -> T): T {
    try {
        return init()
    } finally {
        if (!isClosed()) {
            close()
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