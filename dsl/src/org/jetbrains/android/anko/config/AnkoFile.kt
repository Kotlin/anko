package org.jetbrains.android.anko.config

public enum class AnkoFile(val filename: String) {
    ASYNC : AnkoFile("Async.kt")
    CONTEXT_UTILS : AnkoFile("ContextUtils.kt")
    CUSTOM : AnkoFile("Custom.kt")
    DATABASE : AnkoFile("Database.kt")
    DIALOGS : AnkoFile("Dialogs.kt")
    HELPERS : AnkoFile("Helpers.kt")
    INTERFACE_WORKAROUNDS : AnkoFile("InterfaceWorkarounds.java")
    INTERNALS : AnkoFile("Internals.kt")
    LAYOUTS : AnkoFile("Layouts.kt")
    LISTENERS : AnkoFile("Listeners.kt")
    LOGGER : AnkoFile("Logger.kt")
    OTHER : AnkoFile("Other.kt")
    PROPERTIES : AnkoFile("Properties.kt")
    SERVICES : AnkoFile("Services.kt")
    SQL_PARSER_HELPERS : AnkoFile("SqlParserHelpers.kt")
    SQL_PARSERS : AnkoFile("SqlParsers.kt")
    SUPPORT : AnkoFile("Support.kt")
    VIEWS : AnkoFile("Views.kt")
}