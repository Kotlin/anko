Anko :heart: SQLite
===========

Have you ever been tired of parsing SQLite query results using Android cursors? It required you to write lots of boilerplate code enclosed in countless try..finally blocks to close all the resources properly.

Anko provides lots of different functions to simplify communication with SQLite database.

## Contents

* [Db package](#db-package)
* [Accessing database](#accessing-database)
* [Creating and dropping tables](#creating-and-dropping-tables)
* [Inserting data](#inserting-data)
* [Querying data](#querying-data)
* [Parsing query result](#parsing-query-result)
* [Custom row parsers](#custom-row-parsers)
* [Cursor streams](#cursor-streams)
* [Updating values](#updating-values)
* [Transactions](#transactions)

## Db package

All database-related tools are in the `org.jetbrains.anko.db` package. You could just import all children in one time:

```kotlin
import org.jetbrains.anko.db.*
```

## Accessing database

If you use `SQLiteOpenHelper`, you could just call method `getReadableDatabase()` or `getWritableDatabase()` (result is actually the same in production code), but then you must be sure to call `close()` on the received `SQLiteDatabase`, and you have to cache the helper class somewhere, and if you use it from several threads, you must be aware of proper open-close concurrent access. It's tough. That's why Android developers not really keen on default SQLite API.

Anko provides a special class `ManagedSQLiteOpenHelper` that seamlessly replaces the default one. That's how you can use it:

```kotlin
class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {

    class object {
        private var instance: MyDatabaseOpenHelper? = null

        synchronized fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables (more info about that is below)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
    }
}

// Access properties for Context (you could use it in Activity, Service etc.)
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(getApplicationContext())

// Access property for Fragment
val Fragment.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(getActivity().getApplicationContext())
```

So what's the sense? Now, instead of enclosing your code into `try` blocks, you can write this:

```kotlin
database.use {
    // Now `this` is a SQLiteDatabase instance
}
```

Database will be closed for sure after executing all code in `{}`.

Asynchronous call example (please read [here](ADVANCED.md#asynchronous-tasks) about `async`):

```kotlin
class SomeActivity : Activity() {
    private fun loadAsync() {
        async {
            val result = database.use {
                // Now `this` is a SQLiteDatabase instance
            }
            uiThread { loadComplete(result) }
        }
    }
}
```

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>These and all methods mentioned below may throw <code>SQLiteException</code>. You have to handle it by yourself because it's unreasonable for library to pretend that they don't occur.</i>
</td>
</tr>
</table>

## Creating and dropping tables

With Anko you can easily create new tables and drop existing. Syntax is straightforward.

Let's create a sample `Customer` table:

```kotlin
database.use {
  createTable("Customer", ifNotExists = true, 
    "_id" to INT + PRIMARY_KEY + UNIQUE,
    "name" to TEXT,
    "photo" to BLOB
  )
}
```

`ifNotExists` argument is optional and its default value is `false`.

In SQLite there're five main types: `NULL`, `INT`, `REAL`, `TEXT` and `BLOB`. But each column may have some modificators like `PRIMARY KEY` or `UNIQUE`. You can append such modificators just "adding" them to the type name.

To drop table, use `dropTable` function:

```kotlin
dropTable("User", ifNotExists = true)
```

`ifNotExists` behave the same for `dropTable`.

## Inserting data

Usually, you need a `ContentValues` instance to insert a row. Here's a sample code:

```kotlin
val values = ContentValues()
values.put("_id", 5)
values.put("name", "John Smith")
values.put("email", "user@domain.org")
db.insert("User", null, values)
```

Anko lets you to eliminate ceremonies by writing values directly in `insert()` function:

```kotlin
db.insert("User", 
  "_id" to 42,
  "name" to "John",
  "email" to "user@domain.org"
)
```

Functions `insertOrThrow()`, `replace()`, `replaceOrThrow()` are also exist.

## Querying data

Anko provides a convenient query builder. It may be created with
`db.select(tableName, vararg columns)` where `db` is an instance of `SQLiteDatabase`.

Method                                | Description
--------------------------------------|---------- 
`column(String)`                      | Add a column to select
`distinct(Boolean)`                   | Distinct query (default is `false`)
`where(String)`                       | Specify a raw `where` query part
`where(String, args)` :star:          | Specify a `where` query part with args
`whereSupport(String, args)`          | Specify a `where` query part with (?) mark args
`orderBy(String, [ASC/DESC])`         | Order by this column
`groupBy(String)`                     | Group by this column
`limit(count: Int)`                   | Limit query results count
`limit(offset: Int, count: Int)`      | Limit query results with offset
`having(String)`                      | Specify a raw `having` query part
`having(String, args)` :star:         | Specify a `having` query part with args

Functions marked with :star: parse its arguments in a special way. They allow you to provide query arguments with no particular order and support value escaping seamlessly. The easiest way to describe the behavior is to show it by an example.

```kotlin
db.select("User", "name")
  .where("(_id > {userId}) and (name = {userName})",
    "userName" to "John",
    "userId" to 42)
```

Here, `{userId}` part will be replaced with `42` and `{userName}` — with `'John'`. Value will be escaped if its type is not numeric (`Int`, `Float` and others) or `Boolean`. For unknown types, String value will be used (this means it gets the value from `toString()` method).

`whereSupport` accepts arguments of `String` type. It works the same as [`query()`](http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#query(java.lang.String,%20java.lang.String[],%20java.lang.String,%20java.lang.String[],%20java.lang.String,%20java.lang.String,%20java.lang.String)) function from `SQLiteDatabase` (question marks `?` will be replaced with actual values from arguments).

How can we exec the query? Using `exec()` function. It accepts an extension function which type is `Cursor.() -> T`. It launches the received function and then closes `Cursor` so you don't need to close it by yourself:

```kotlin
db.select("User", "email").exec {
	// Doing some stuff with emails
}
```

## Parsing query result

So we're got some `Cursor`, how can we parse it? Fortunately, Anko provides functions `parseSingle`, `parseOpt` and `parseList`.

Method                                | Description
--------------------------------------|---------- 
`parseSingle(rowParser): T`           | Parse exactly one row
`parseOpt(rowParser): T?`             | Parse zero or one row
`parseList(rowParser): List<T>`       | Parse all rows

Note than `parseSingle()` and `parseOpt()` throw an exception if Cursor contains more than one row.

Now the question is: what is `rowParser`. Well, each function support two different types of parsers: `RowParser` and `MapRowParser`:

```kotlin
public trait RowParser<T> {
  fun parseRow(columns: Array<Any>): T
}

public trait MapRowParser<T> {
  fun parseRow(columns: Map<String, Any>): T
}
```

If you want to be very efficient, use RowParser (but then you must know the index of each column). Its `parseRow` accepts list of `Any` (the actual type of `Any` could be nothing but `Long`, `Double`, `String` or `ByteArray`).

`MapRowParser` is more convenient way to parse. Each map key is a column name.

Anko already contains parsers for single-column rows:

* `ShortParser`
* `IntParser`
* `LongParser`
* `FloatParser`
* `DoubleParser`
* `StringParser`
* `BlobParser`

Also you can create a row parser from class constructor. Assuming you have a class:

```kotlin
class Person(val firstName: String, val secondName: String, val age: Int)
```

you can create a parser of (String, String, Int) row this way:

```kotlin
val rowParser = classParser<Person>()
```

For now Anko **does not support** creating such parsers with optional arguments. Also note that constructor will be invoked using Java Reflection so writing a custom `RowParser` is more reasonable for really huge data sets.

If you're using Anko `db.select()` builder, you can directly call `parseSingle`, `parseOpt` or `parseList` on it.

## Custom row parsers

For example, you want to implement a new parser for columns (Int, String, String). You could create a new class:

```kotlin
public class MyRowParser : RowParser<Triple<Int, String, String>> {
  override fun parseRow(columns: Array<Any>): Triple<Int, String, String> {
    return Triple(columns[0] as Int, columns[1] as String, columns[2] as String)
  }
}
```

But it's easier to make use of helper function `rowParser`:

```kotlin
val parser = rowParser { (id: Int, name: String, email: String) -> 
  Triple(id, name, email)
}
```

`rowParser` makes all class casts under the hood and you can name lambda arguments as you want.

## Cursor streams

Anko provides a way to access SQLite `Cursor` in functional way. Just call `cursor.stream()` or `cursor.mapStream()` extension methods to get a `kotlin.Stream`. Also do not forget to close a `Cursor`.

## Updating values

Finally you want to update some old rows in database. It's just like this:

```kotlin
update("User", "name" to "Alice")
  .where("_id = {userId}", "userId" to 42)
  .exec()
```

Update also contains `whereSupport()` function in case you want to provide query in a traditional way:

```kotlin
update("User", "name" to "Alice")
  .whereSupport("_id = ?", 42)
  .exec()
```

## Transactions

There's a special function `transaction()` which allows you to enclose some operations in a single SQL transaction.

```kotlin
transaction {
	// Your transaction code
}
```

Transaction will succeed if no exception was thrown from the `{}` block.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>If you want to abort a transaction for some reason, throw a <code>TransactionAbortException</code> exception. You don't need to handle this exception by yourself in this case.</i>
</td>
</tr>
</table>