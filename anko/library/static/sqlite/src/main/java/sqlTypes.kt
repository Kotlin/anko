/*
 * Copyright 2016 JetBrains s.r.o.
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

@file:Suppress("unused")
package org.jetbrains.anko.db

interface SqlType {
    val name: String

    fun render(): String
    operator fun plus(m: SqlTypeModifier): SqlType

    companion object {
        fun create(name: String): SqlType = SqlTypeImpl(name)
    }
}

interface SqlTypeModifier {
    val modifier: String

    companion object {
        fun create(modifier: String): SqlTypeModifier = SqlTypeModifierImpl(modifier)
    }
}

val NULL: SqlType = SqlTypeImpl("NULL")
val INTEGER: SqlType = SqlTypeImpl("INTEGER")
val REAL: SqlType = SqlTypeImpl("REAL")
val TEXT: SqlType = SqlTypeImpl("TEXT")
val BLOB: SqlType = SqlTypeImpl("BLOB")

enum class ConstraintActions {
    SET_NULL,
    SET_DEFAULT,
    SET_RESTRICT,
    CASCADE,
    NO_ACTION;

    override fun toString(): String {
        return super.toString().replace("_", " ")
    }
}

fun ON_UPDATE(constraintActions: ConstraintActions): SqlTypeModifier {
    return SqlTypeModifierImpl("ON UPDATE $constraintActions")
}

fun ON_DELETE(constraintActions: ConstraintActions): SqlTypeModifier {
    return SqlTypeModifierImpl("ON DELETE $constraintActions")
}

fun FOREIGN_KEY(columnName: String, referenceTable: String, referenceColumn: String, vararg actions: SqlTypeModifier): Pair<String, SqlType> {
    return "" to SqlTypeImpl("FOREIGN KEY($columnName) REFERENCES $referenceTable($referenceColumn)${actions.map { it.modifier }.joinToString("") { " $it" }}")
}

val PRIMARY_KEY: SqlTypeModifier = SqlTypeModifierImpl("PRIMARY KEY")
val NOT_NULL: SqlTypeModifier = SqlTypeModifierImpl("NOT NULL")
val AUTOINCREMENT: SqlTypeModifier = SqlTypeModifierImpl("AUTOINCREMENT")
val UNIQUE: SqlTypeModifier = SqlTypeModifierImpl("UNIQUE")

fun UNIQUE(conflictClause: ConflictClause): SqlTypeModifier {
    return SqlTypeModifierImpl("UNIQUE ON CONFLICT $conflictClause")
}

enum class ConflictClause {
    ROLLBACK,
    ABORT,
    FAIL,
    IGNORE,
    REPLACE
}

fun DEFAULT(value: String): SqlTypeModifier = SqlTypeModifierImpl("DEFAULT $value")

private open class SqlTypeImpl(override val name: String, val modifiers: String? = null) : SqlType {
    override fun render() = if (modifiers == null) name else "$name $modifiers"

    override fun plus(m: SqlTypeModifier): SqlType {
        return SqlTypeImpl(name, if (modifiers == null) m.modifier else "$modifiers ${m.modifier}")
    }
}

private open class SqlTypeModifierImpl(override val modifier: String) : SqlTypeModifier
