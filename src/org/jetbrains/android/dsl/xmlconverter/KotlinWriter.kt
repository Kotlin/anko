package org.jetbrains.android.dsl.xmlconverter

import org.jetbrains.android.dsl.Context

class KotlinWriter {
    private var depth = 0
    val buffer = StringBuffer()
    val ctx = Context(buffer)

    public fun handleAttribute(parentName: String, name: String, value:String) {

    }

    public fun handleElement(name: String) {

    }

    public override fun toString(): String {
        return buffer.toString()
    }

}

