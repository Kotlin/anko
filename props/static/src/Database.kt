package kotlinx.android.koan

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import java.util.regex.Pattern

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

public fun SQLiteDatabase.select(tableName: String, init: SelectQueryBuilder.() -> Unit): Cursor {
    val builder = SelectQueryBuilderImpl(tableName)
    builder.init()
    return builder.exec(this)
}

public fun SQLiteDatabase.select(tableName: String, vararg columns: String, init: SelectQueryBuilder.() -> Unit): Cursor {
    val builder = SelectQueryBuilderImpl(tableName)
    builder.columns(*columns)
    builder.init()
    return builder.exec(this)
}

public fun SQLiteDatabase.update(tableName: String, vararg values: Pair<String, Any>, init: UpdateQueryBuilder.() -> Unit): Int {
    val builder = UpdateQueryBuilderImpl(this, tableName, values)
    builder.init()
    return builder.exec()
}

public fun SQLiteDatabase.createTable(tableName: String, ifNotExists: Boolean = false, vararg columns: Pair<String, SqlOrderDirection>) {
    val escapedTableName = tableName.replace("`", "``")
    val ifNotExistsText = if (ifNotExists) "IF NOT EXISTS" else ""
    execSQL(
        columns.map { col ->
            "${col.first} ${col.second}"
        }.joinToString(", ", prefix = "CREATE TABLE $ifNotExistsText `$escapedTableName`(", postfix = ");")
    )
}

private fun SQLiteDatabase.dropTable(tableName: String, ifNotExists: Boolean = false) {
    val escapedTableName = tableName.replace("`", "``")
    val ifNotExistsText = if (ifNotExists) "IF NOT EXISTS" else ""
    execSQL("DROP TABLE $ifNotExistsText `$escapedTableName`;")
}

private fun escape(s: String): String {
    return '\''+s.replace("'", "''")+'\''
}

private val ARG_PATTERN: Pattern = Pattern.compile("([^\\\\])\\{([^\\{}]+)\\}")

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

public enum class SqlOrderDirection {
    ASC
    DESC
}

public enum class SqlType(val text: String) {
    NULL : SqlType("NULL")
    INTEGER : SqlType("INT")
    REAL : SqlType("REAL")
    TEXT : SqlType("TEXT")
    BLOB : SqlType("BLOB")
}

public trait UpdateQueryBuilder {
    public fun where(select: String, vararg args: Pair<String, Any>)
    public fun where(select: String)
    public fun where(select: String, vararg args: String)
}

private class UpdateQueryBuilderImpl(val db: SQLiteDatabase, val tableName: String, val values: Array<Pair<String, Any>>) : UpdateQueryBuilder {

    private var selectionApplied = false
    private var useNativeSelection = false
    private var selection: String? = null
    private var nativeSelectionArgs: Array<String>? = null

    public override fun where(select: String, vararg args: Pair<String, Any>) {
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

    public override fun where(select: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        selection = select
    }

    public override fun where(select: String, vararg args: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
    }

    public fun exec(): Int {
        val finalSelection = if (selectionApplied) selection else null
        val finalSelectionArgs = if (selectionApplied && useNativeSelection) nativeSelectionArgs else null
        return db.update(tableName, values.toContentValues(), finalSelection, finalSelectionArgs)
    }
}

public trait SelectQueryBuilder {
    public var distinct: Boolean

    public fun column(name: String)
    public fun groupBy(value: String)
    public fun orderBy(value: String)
    public fun orderBy(value: String, direction: SqlOrderDirection)
    public fun limit(count: Int)
    public fun limit(offset: Int, count: Int)
    public fun columns(vararg names: String)
    public fun having(having: String)
    public fun having(having: String, vararg args: Pair<String, Any>)
    public fun where(select: String, vararg args: Pair<String, Any>)
    public fun where(select: String)
    public fun where(select: String, vararg args: String)
}

private class SelectQueryBuilderImpl(val tableName: String) : SelectQueryBuilder {
    public override var distinct: Boolean = false

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

    public override fun column(name: String) {
        columns.add(name)
    }

    public override fun groupBy(value: String) {
        groupBy.add(value)
    }

    public override fun orderBy(value: String) {
        orderBy.add(value)
    }

    public override fun orderBy(value: String, direction: SqlOrderDirection) {
        if (direction == SqlOrderDirection.DESC) {
            orderBy.add("$value DESC")
        } else {
            orderBy.add(value)
        }
    }

    public override fun limit(count: Int) {
        limit = count.toString()
    }

    public override fun limit(offset: Int, count: Int) {
        limit = "$offset, $count"
    }

    public override fun columns(vararg names: String) {
        columns.addAll(names)
    }

    public override fun having(having: String) {
        if (havingApplied)
            throw KoanException("Query having was already applied.")

        havingApplied = true
        this.having = having
    }

    public override fun having(having: String, vararg args: Pair<String, Any>) {
        if (selectionApplied)
            throw KoanException("Query having was already applied.")

        havingApplied = true
        val argsMap = args.fold(hashMapOf<String, Any>()) { (map, arg) ->
            map.put(arg.first, arg.second)
            map
        }
        this.having = applyArguments(having, argsMap)
    }

    public override fun where(select: String, vararg args: Pair<String, Any>) {
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

    public override fun where(select: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        selection = select
    }

    public override fun where(select: String, vararg args: String) {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
    }
}