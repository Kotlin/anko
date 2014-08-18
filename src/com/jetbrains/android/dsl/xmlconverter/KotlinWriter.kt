package com.jetbrains.android.dsl.xmlconverter

import com.jetbrains.android.dsl.Context

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

