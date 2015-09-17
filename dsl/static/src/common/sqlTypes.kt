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

@file:JvmMultifileClass
@file:JvmName("SqlTypesKt")
package org.jetbrains.anko.db

public interface SqlType {
    open val name: String
    open val modifier: String?
}

public interface SqlTypeModifier {
    open val modifier: String
}

public fun SqlType.plus(m: SqlTypeModifier) : SqlType {
    return SqlTypeImpl(name, if (modifier == null) m.toString() else "$modifier $m")
}

public val NULL: SqlType = SqlTypeImpl("NULL")
public val INTEGER: SqlType = SqlTypeImpl("INTEGER")
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
