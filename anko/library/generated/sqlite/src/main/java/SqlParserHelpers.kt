@file:JvmMultifileClass
@file:JvmName("SQLiteParserHelpersKt")
package org.jetbrains.anko.db

import android.database.sqlite.SQLiteException

fun <T1, R> rowParser(parser: (T1) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 1) {
                throw SQLiteException("Invalid row: 1 column required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1)
        }
    }
}

fun <T1, T2, R> rowParser(parser: (T1, T2) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 2) {
                throw SQLiteException("Invalid row: 2 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2)
        }
    }
}

fun <T1, T2, T3, R> rowParser(parser: (T1, T2, T3) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 3) {
                throw SQLiteException("Invalid row: 3 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3)
        }
    }
}

fun <T1, T2, T3, T4, R> rowParser(parser: (T1, T2, T3, T4) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 4) {
                throw SQLiteException("Invalid row: 4 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4)
        }
    }
}

fun <T1, T2, T3, T4, T5, R> rowParser(parser: (T1, T2, T3, T4, T5) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 5) {
                throw SQLiteException("Invalid row: 5 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, R> rowParser(parser: (T1, T2, T3, T4, T5, T6) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 6) {
                throw SQLiteException("Invalid row: 6 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 7) {
                throw SQLiteException("Invalid row: 7 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 8) {
                throw SQLiteException("Invalid row: 8 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 9) {
                throw SQLiteException("Invalid row: 9 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 10) {
                throw SQLiteException("Invalid row: 10 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 11) {
                throw SQLiteException("Invalid row: 11 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 12) {
                throw SQLiteException("Invalid row: 12 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 13) {
                throw SQLiteException("Invalid row: 13 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 14) {
                throw SQLiteException("Invalid row: 14 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 15) {
                throw SQLiteException("Invalid row: 15 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 16) {
                throw SQLiteException("Invalid row: 16 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 17) {
                throw SQLiteException("Invalid row: 17 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 18) {
                throw SQLiteException("Invalid row: 18 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17, columns[17] as T18)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 19) {
                throw SQLiteException("Invalid row: 19 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17, columns[17] as T18, columns[18] as T19)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 20) {
                throw SQLiteException("Invalid row: 20 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17, columns[17] as T18, columns[18] as T19, columns[19] as T20)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 21) {
                throw SQLiteException("Invalid row: 21 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17, columns[17] as T18, columns[18] as T19, columns[19] as T20, columns[20] as T21)
        }
    }
}

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> rowParser(parser: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R): RowParser<R> {
    return object : RowParser<R> {
        override fun parseRow(columns: Array<Any?>): R {
            if (columns.size != 22) {
                throw SQLiteException("Invalid row: 22 columns required")
            }

            @Suppress("UNCHECKED_CAST")
            return parser(columns[0] as T1, columns[1] as T2, columns[2] as T3, columns[3] as T4, columns[4] as T5, columns[5] as T6, columns[6] as T7, columns[7] as T8, columns[8] as T9, columns[9] as T10, columns[10] as T11, columns[11] as T12, columns[12] as T13, columns[13] as T14, columns[14] as T15, columns[15] as T16, columns[16] as T17, columns[17] as T18, columns[18] as T19, columns[19] as T20, columns[20] as T21, columns[21] as T22)
        }
    }
}

