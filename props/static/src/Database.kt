package kotlinx.android.koan

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import java.util.regex.Pattern

private fun Array<Pair<String, Any>>.toContentValues(): ContentValues {
    val values = ContentValues()
    for ((key, value) in this) {
        when(value) {
            is Boolean -> values.put(key, value)
            is Byte -> values.put(key, value)
            is ByteArray -> values.put(key, value)
            is Double -> values.put(key, value)
            is Float -> values.put(key, value)
            is Int -> values.put(key, value)
            is Long -> values.put(key, value)
            is Short -> values.put(key, value)
            is String -> values.put(key, value)
            else -> throw IllegalArgumentException("Non-supported value type: ${value.javaClass.getName()}")
        }
    }
    return values
}

public fun SQLiteDatabase.insert(tableName: String, vararg values: Pair<String, Any>): Long {
    return insert(tableName, null, values.toContentValues())
}

public fun SQLiteDatabase.insertOrThrow(tableName: String, vararg values: Pair<String, Any>): Long {
    return insertOrThrow(tableName, null, values.toContentValues())
}

public fun SQLiteDatabase.replace(tableName: String, vararg values: Pair<String, Any>): Long {
    return replace(tableName, null, values.toContentValues())
}

public fun SQLiteDatabase.replaceOrThrow(tableName: String, vararg values: Pair<String, Any>): Long {
    return replaceOrThrow(tableName, null, values.toContentValues())
}

public fun SQLiteDatabase.query(tableName: String, init: QueryBuilder.() -> Unit): Cursor {
    val builder = QueryBuilder(tableName)
    builder.init()
    return builder.exec(this)
}

public fun SQLiteDatabase.query(tableName: String, vararg columns: String, init: QueryBuilder.() -> Unit): Cursor {
    val builder = QueryBuilder(tableName)
    builder.columns(*columns)
    builder.init()
    return builder.exec(this)
}

public enum class SqlOrderDirection {
    ASC
    DESC
}

public class QueryBuilder(val tableName: String) {
    public var distinct: Boolean = false

    private val columns = arrayListOf<String>()
    private val groupBy = arrayListOf<String>()
    private val orderBy = arrayListOf<String>()

    private var havingApplied = false
    private var having: String? = null
    private var limit: String? = null

    private var selectionApplied = false
    private var useNativeSelection = false
    private var selection: String? = null
    private var nativeSelectionArgs: Array<String>? = null

    fun exec(db: SQLiteDatabase): Cursor {
        val finalSelection = if (selectionApplied) selection else null
        val finalSelectionArgs = if (selectionApplied && useNativeSelection) nativeSelectionArgs else null
        return db.query(distinct, tableName, columns.copyToArray(),
            finalSelection, finalSelectionArgs,
            groupBy.joinToString(", "), having, orderBy.joinToString(", "), limit)
    }

    public fun column(name: String) {
        columns.add(name)
    }

    public fun groupBy(value: String) {
        groupBy.add(value)
    }

    public fun orderBy(value: String) {
        orderBy.add(value)
    }

    public fun orderBy(value: String, direction: SqlOrderDirection) {
        if (direction == SqlOrderDirection.DESC) {
            orderBy.add("$value DESC")
        } else {
            orderBy.add(value)
        }
    }

    public fun limit(count: Int) {
        limit = count.toString()
    }

    public fun limit(offset: Int, count: Int) {
        limit = "$offset, $count"
    }

    public fun columns(vararg names: String) {
        columns.addAll(names)
    }

    public fun having(having: String) {
        if (havingApplied)
            throw KoanException("Query having was already applied.")

        havingApplied = true
        this.having = having
    }

    public fun having(having: String, vararg args: Pair<String, Any>) {
        if (selectionApplied)
            throw KoanException("Query having was already applied.")

        havingApplied = true
        val argsMap = args.fold(hashMapOf<String, Any>()) { (map, arg) ->
            map.put(arg.first, arg.second)
            map
        }
        this.having = applyArguments(having, argsMap)
    }

    public fun where(select: String, vararg args: Pair<String, Any>) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        val argsMap = args.fold(hashMapOf<String, Any>()) { (map, arg) ->
            map.put(arg.first, arg.second)
            map
        }
        selection = applyArguments(select, argsMap)
    }

    public fun where(select: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        selection = select
    }

    public fun where(select: String, vararg args: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
    }

    private fun escape(s: String): String {
        return '\''+s.replace("'", "''")+'\''
    }

    private fun applyArguments(select: String, args: Map<String, Any>): String {
        val matcher = ARG_PATTERN.matcher(select)
        val buffer = StringBuffer(select.length())
        while (matcher.find()) {
            val key = matcher.group(2)
            val value = args.get(key)
            if (value == null)
                throw IllegalStateException("Can't find a value for key " + key)

            val valueString = if (value is Int || value is Long || value is Byte || value is Short) {
                value.toString()
            } else if (value is Boolean) {
                if (value) "1" else "0"
            } else if (value is Float || value is Double) {
                value.toString()
            } else {
                escape(value.toString())
            }
            matcher.appendReplacement(buffer, matcher.group(1) + valueString)
        }
        matcher.appendTail(buffer)
        return buffer.toString()
    }

    class object {
        private val ARG_PATTERN: Pattern = Pattern.compile("([^\\\\])\\{([^\\{}]+)\\}")
    }
}