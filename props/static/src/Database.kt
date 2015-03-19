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

package kotlinx.android.koan.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.Cursor
import java.util.regex.Pattern
import kotlinx.android.koan.*
import android.database.sqlite.SQLiteOpenHelper
import kotlinx.android.koan.internals.useDatabase
import kotlinx.android.koan.internals.useCursor
import java.util.concurrent.atomic.AtomicInteger
import android.content.Context

public val NULL: SqlType = SqlTypeImpl("NULL")
public val INT: SqlType = SqlTypeImpl("INT")
public val REAL: SqlType = SqlTypeImpl("REAL")
public val TEXT: SqlType = SqlTypeImpl("TEXT")
public val BLOB: SqlType = SqlTypeImpl("BLOB")

public fun FOREIGN_KEY(columnName: String, referenceTable: String, referenceColumn: String): SqlType {
    return SqlTypeImpl("FOREIGN KEY($columnName) REFERENCES $referenceTable($referenceColumn)")
}

public val PRIMARY_KEY: SqlTypeModifier = SqlTypeModifierImpl("PRIMARY KEY")
public val NOT_NULL: SqlTypeModifier = SqlTypeModifierImpl("NOT_NULL")
public val AUTOINCREMENT: SqlTypeModifier = SqlTypeModifierImpl("AUTOINCREMENT")
public val UNIQUE: SqlTypeModifier = SqlTypeModifierImpl("UNIQUE")
public fun DEFAULT(value: String): SqlTypeModifier = SqlTypeModifierImpl("DEFAULT $value")

public class TransactionAbortException : RuntimeException()

public trait SqlType {
    open val name: String
    open val modifier: String?
}

public trait SqlTypeModifier {
    open val modifier: String
}

private open class SqlTypeImpl(name: String, modifier: String? = null) : SqlType {
    override val name: String = name
    override val modifier: String? = modifier

    public override fun toString(): String {
        return if (modifier == null) name else "$name $modifier"
    }
}

private open class SqlTypeModifierImpl(modifier: String) : SqlTypeModifier {
    override val modifier: String = modifier
    public override fun toString(): String = modifier
}

public fun SqlType.plus(m: SqlTypeModifier) : SqlType {
    return SqlTypeImpl(name, if (modifier == null) m.toString() else "$modifier $m")
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

public fun SQLiteDatabase.transaction(code: SQLiteDatabase.() -> Unit) {
    try {
        beginTransaction()
        code()
        setTransactionSuccessful()
    } catch (e: TransactionAbortException) {
        // Do nothing, just stop the transaction
    } finally {
        endTransaction()
    }
}

public fun SQLiteDatabase.select(tableName: String): SelectQueryBuilder {
    return SelectQueryBuilder(this, tableName)
}

public fun SQLiteDatabase.select(tableName: String, vararg columns: String): SelectQueryBuilder {
    val builder = SelectQueryBuilder(this, tableName)
    builder.columns(*columns)
    return builder
}

public fun SQLiteDatabase.update(tableName: String, vararg values: Pair<String, Any>): UpdateQueryBuilder {
    return UpdateQueryBuilder(this, tableName, values)
}

public fun SQLiteDatabase.delete(tableName: String, whereClause: String = "", vararg args: Pair<String, Any>): Int {
    return delete(tableName, applyArguments(whereClause, *args), null)
}

public fun SQLiteDatabase.createTable(tableName: String, ifNotExists: Boolean = false, vararg columns: Pair<String, SqlType>) {
    val escapedTableName = tableName.replace("`", "``")
    val ifNotExistsText = if (ifNotExists) "IF NOT EXISTS" else ""
    execSQL(
        columns.map { col ->
            "${col.first} ${col.second}"
        }.joinToString(", ", prefix = "CREATE TABLE $ifNotExistsText `$escapedTableName`(", postfix = ");")
    )
}

public fun SQLiteDatabase.dropTable(tableName: String, ifNotExists: Boolean = false) {
    val escapedTableName = tableName.replace("`", "``")
    val ifNotExistsText = if (ifNotExists) "IF NOT EXISTS" else ""
    execSQL("DROP TABLE $ifNotExistsText `$escapedTableName`;")
}

private fun escape(s: String): String {
    return '\''+s.replace("'", "''")+'\''
}

private val ARG_PATTERN: Pattern = Pattern.compile("([^\\\\])\\{([^\\{}]+)\\}")

private fun applyArguments(whereClause: String, vararg args: Pair<String, Any>): String {
    val argsMap = args.fold(hashMapOf<String, Any>()) { map, arg ->
        map.put(arg.first, arg.second)
        map
    }
    return applyArguments(whereClause, argsMap)
}

private fun applyArguments(whereClause: String, args: Map<String, Any>): String {
    val matcher = ARG_PATTERN.matcher(whereClause)
    val buffer = StringBuffer(whereClause.length())
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

private fun Array<out Pair<String, Any>>.toContentValues(): ContentValues {
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

public abstract class ManagedSQLiteOpenHelper(
    ctx: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
): SQLiteOpenHelper(ctx, name, factory, version) {

    private val counter = AtomicInteger()
    private var db: SQLiteDatabase? = null

    public fun <T> use(f: SQLiteDatabase.() -> T): T {
        try {
            return openDatabase().f()
        } finally {
            closeDatabase()
        }
    }

    private synchronized fun openDatabase(): SQLiteDatabase {
        if (counter.incrementAndGet() == 1) {
            db = getWritableDatabase()
        }
        return db!!
    }

    private synchronized fun closeDatabase() {
        if (counter.decrementAndGet() == 0) {
            db?.close()
        }
    }
}

public class UpdateQueryBuilder(val db: SQLiteDatabase, val tableName: String, val values: Array<out Pair<String, Any>>) {

    private var selectionApplied = false
    private var useNativeSelection = false
    private var selection: String? = null
    private var nativeSelectionArgs: Array<out String>? = null

    public fun where(select: String, vararg args: Pair<String, Any>): UpdateQueryBuilder {
        if (selectionApplied) {
            throw KoanException("Query selection was already applied.")
        }

        selectionApplied = true
        useNativeSelection = false
        val argsMap = args.fold(hashMapOf<String, Any>()) { map, arg ->
            map.put(arg.first, arg.second)
            map
        }
        selection = applyArguments(select, argsMap)
        return this
    }

    public fun where(select: String): UpdateQueryBuilder {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        selection = select
        return this
    }

    public fun whereSupport(select: String, vararg args: String): UpdateQueryBuilder {
        if (selectionApplied)
            throw KoanException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
        return this
    }

    public fun exec(): Int {
        val finalSelection = if (selectionApplied) selection else null
        val finalSelectionArgs = if (selectionApplied && useNativeSelection) nativeSelectionArgs else null
        return db.update(tableName, values.toContentValues(), finalSelection, finalSelectionArgs)
    }
}

public class SelectQueryBuilder(val db: SQLiteDatabase, val tableName: String) {
    private val columns = arrayListOf<String>()
    private val groupBy = arrayListOf<String>()
    private val orderBy = arrayListOf<String>()

    private var distinct: Boolean = false

    private var havingApplied = false
    private var having: String? = null
    private var limit: String? = null

    private var selectionApplied = false
    private var useNativeSelection = false
    private var selection: String? = null
    private var nativeSelectionArgs: Array<out String>? = null

    public fun <T> exec(f: Cursor.() -> T): T {
        val cursor = execInternal()
        return cursor.useCursor {
            cursor.f()
        }
    }

    public fun <T: Any> parseSingle(parser: RowParser<T>): T = execInternal().useCursor {
        it.parseSingle(parser)
    }

    public fun <T: Any> parseOpt(parser: RowParser<T>): T? = execInternal().useCursor {
        it.parseOpt(parser)
    }

    public fun <T: Any> parseList(parser: RowParser<T>): List<T> = execInternal().useCursor {
        it.parseList(parser)
    }

    public fun <T: Any> parseSingle(parser: MapRowParser<T>): T = execInternal().useCursor {
        it.parseSingle(parser)
    }

    public fun <T: Any> parseOpt(parser: MapRowParser<T>): T? = execInternal().useCursor {
        it.parseOpt(parser)
    }

    public fun <T: Any> parseList(parser: MapRowParser<T>): List<T> = execInternal().useCursor {
        it.parseList(parser)
    }

    private fun execInternal(): Cursor {
        val finalSelection = if (selectionApplied) selection else null
        val finalSelectionArgs = if (selectionApplied && useNativeSelection) nativeSelectionArgs else null
        return db.query(distinct, tableName, columns.copyToArray(),
            finalSelection, finalSelectionArgs,
            groupBy.joinToString(", "), having, orderBy.joinToString(", "), limit)
    }

    fun distinct(): SelectQueryBuilder {
        this.distinct = true
        return this
    }

    public fun column(name: String): SelectQueryBuilder {
        columns.add(name)
        return this
    }

    public fun groupBy(value: String): SelectQueryBuilder {
        groupBy.add(value)
        return this
    }

    public fun orderBy(value: String, direction: SqlOrderDirection = SqlOrderDirection.ASC): SelectQueryBuilder {
        if (direction == SqlOrderDirection.DESC) {
            orderBy.add("$value DESC")
        } else {
            orderBy.add(value)
        }
        return this
    }

    public fun limit(count: Int): SelectQueryBuilder {
        limit = count.toString()
        return this
    }

    public fun limit(offset: Int, count: Int): SelectQueryBuilder {
        limit = "$offset, $count"
        return this
    }

    public fun columns(vararg names: String): SelectQueryBuilder {
        columns.addAll(names)
        return this
    }

    public fun having(having: String): SelectQueryBuilder {
        if (havingApplied) {
            throw KoanException("Query having was already applied.")
        }

        havingApplied = true
        this.having = having
        return this
    }

    public fun having(having: String, vararg args: Pair<String, Any>): SelectQueryBuilder {
        if (selectionApplied) {
            throw KoanException("Query having was already applied.")
        }

        havingApplied = true
        this.having = applyArguments(having, *args)
        return this
    }

    public fun where(select: String, vararg args: Pair<String, Any>): SelectQueryBuilder {
        if (selectionApplied) {
            throw KoanException("Query selection was already applied.")
        }

        selectionApplied = true
        useNativeSelection = false
        selection = applyArguments(select, *args)
        return this
    }

    public fun where(select: String): SelectQueryBuilder {
        if (selectionApplied) {
            throw KoanException("Query selection was already applied.")
        }

        selectionApplied = true
        useNativeSelection = false
        selection = select
        return this
    }

    public fun whereSupport(select: String, vararg args: String): SelectQueryBuilder {
        if (selectionApplied) {
            throw KoanException("Query selection was already applied.")
        }

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
        return this
    }
}