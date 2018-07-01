package com.example.android_test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.jetbrains.anko.db.AUTOINCREMENT
import org.jetbrains.anko.db.ConstraintActions
import org.jetbrains.anko.db.FOREIGN_KEY
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.db.ON_DELETE
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.UNIQUE
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.update
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class AnkoSQliteTest {

    private var databaseHelper: DbHelper? = null

    @Before
    fun setUp() {
        databaseHelper = DbHelper(RuntimeEnvironment.application)
    }

    @After
    fun tearDown() {
        databaseHelper?.close()
        databaseHelper?.deleteDatabase()
    }

    @Test
    fun testSimpleCRUD() = databaseTest {
        createTable(
                "User",
                true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "name" to TEXT,
                "email" to TEXT
        )

        insert("User", "id" to 0, "name" to "John", "email" to "johny@domain.org")

        insert("User", "id" to 1, "name" to "Vasya", "email" to "vasiliy@domain.org")

        select("User").exec {
            moveToNext()
            assertEquals(0, getInt(0))
            assertEquals("John", getString(1))
            assertEquals("johny@domain.org", getString(2))

            moveToNext()
            assertEquals(1, getInt(0))
            assertEquals("Vasya", getString(1))
            assertEquals("vasiliy@domain.org", getString(2))
        }

        update("User", "name" to "Fedor")
                .whereArgs("id = {userId}", "userId" to 1)
                .exec()

        select("User").exec {
            moveToNext()
            assertEquals(0, getInt(0))
            assertEquals("John", getString(1))
            assertEquals("johny@domain.org", getString(2))

            moveToNext()
            assertEquals(1, getInt(0))
            assertEquals("Fedor", getString(1))
            assertEquals("vasiliy@domain.org", getString(2))
        }
    }

    @Test
    fun testAutoincrement() = databaseTest {
        createTable(
                "User",
                true,
                "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "name" to TEXT,
                "email" to TEXT
        )

        insert("User", "name" to "John", "email" to "johny@domain.org")

        insert("User", "name" to "Vasya", "email" to "vasiliy@domain.org")

        insert("User", "name" to "Fedya", "email" to "fedor@domain.org")

        select("User").exec {
            moveToNext()
            assertEquals(1, getInt(0))
            assertEquals("John", getString(1))
            assertEquals("johny@domain.org", getString(2))

            moveToNext()
            assertEquals(2, getInt(0))
            assertEquals("Vasya", getString(1))
            assertEquals("vasiliy@domain.org", getString(2))

            moveToNext()
            assertEquals(3, getInt(0))
            assertEquals("Fedya", getString(1))
            assertEquals("fedor@domain.org", getString(2))
        }
    }

    @Test
    fun testForeignKeyOnDeleteCascade() = databaseTest {

        rawQuery("PRAGMA foreign_keys = ON", emptyArray()).close()

        createTable(
                "users",
                true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "name" to TEXT
        )

        insert("users", "name" to "John")
        insert("users", "name" to "Vasya")

        createTable(
                "emails",
                true,
                "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "email" to TEXT,
                "userId" to INTEGER,
                FOREIGN_KEY("userId", "users", "id", ON_DELETE(ConstraintActions.CASCADE))
        )

        insert("emails",  "email" to "johny@domain.org", "userId" to 1)
        insert("emails",  "email" to "vasiliy@domain.org", "userId" to 2)

        select("emails").exec {
            moveToNext()
            assertEquals("johny@domain.org", getString(1))
        }

        select("users").exec {
            moveToNext()
            assertEquals("John", getString(1))
        }


        delete("users", "id = {userId}", "userId" to 1)


        select("emails").exec {
            moveToNext()
            assertEquals("vasiliy@domain.org", getString(1))
        }

        select("users").exec {
            moveToNext()
            assertEquals("Vasya", getString(1))
        }
    }

    private fun databaseTest(f: SQLiteDatabase.() -> Unit) =
            databaseHelper!!.writableDatabase.let(f)
}

class DbHelper(
        private val context: Context,
        private val dbName: String = "test_db"
) : SQLiteOpenHelper(
        context,
        dbName,
        null ,
        1
) {
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun deleteDatabase() {
        context.deleteDatabase(dbName)
    }
}

