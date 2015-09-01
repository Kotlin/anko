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

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.AnkoException

public class UpdateQueryBuilder(
        val db: SQLiteDatabase,
        val tableName: String,
        val values: Array<out Pair<String, Any>>
) {

    private var selectionApplied = false
    private var useNativeSelection = false
    private var selection: String? = null
    private var nativeSelectionArgs: Array<out String>? = null

    public fun where(select: String, vararg args: Pair<String, Any>): UpdateQueryBuilder {
        if (selectionApplied) {
            throw AnkoException("Query selection was already applied.")
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
            throw AnkoException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = false
        selection = select
        return this
    }

    public fun `where?`(select: String, vararg args: String): UpdateQueryBuilder {
        if (selectionApplied)
            throw AnkoException("Query selection was already applied.")

        selectionApplied = true
        useNativeSelection = true
        selection = select
        nativeSelectionArgs = args
        return this
    }

    @deprecated("Use `where?`() instead", replaceWith = ReplaceWith("`where?`(select, *args)"))
    public fun whereSupport(select: String, vararg args: String): UpdateQueryBuilder {
        return `where?`(select, *args)
    }

    public fun exec(): Int {
        val finalSelection = if (selectionApplied) selection else null
        val finalSelectionArgs = if (selectionApplied && useNativeSelection) nativeSelectionArgs else null
        return db.update(tableName, values.toContentValues(), finalSelection, finalSelectionArgs)
    }
}
