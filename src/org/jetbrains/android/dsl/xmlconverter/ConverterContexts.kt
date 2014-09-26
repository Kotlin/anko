package org.jetbrains.android.dsl.xmlconverter

import java.util.ArrayList
import org.jetbrains.android.dsl.Context

open class WidgetContext(): Context() {
    val layoutParams = ArrayList<String>()

    private fun layoutFunc(key: String, value: String) {
        layoutParams.add(value.toUpperCase())
    }

    public open fun addProperty(key: String, value: String, keyPrefix: String = "") {
        when (key) {
            "layout_width" -> layoutFunc(key, value)
            "layout_height" -> layoutFunc(key, value)
            "text" -> writeln("$keyPrefix$key = \"$value\"")
            "caption" -> writeln("$keyPrefix$key = \"$value\"")
            else -> writeln("$keyPrefix$key = $value")
        }
    }

    public open fun setId(id: String) {
        writeln("id = R.id.$id")
    }

    public override fun toString(): String {
         if (!layoutParams.isEmpty())
            writeln("layoutParams(${layoutParams.makeString()})")
        return buffer.toString()
    }
}

class LayoutContext(): WidgetContext() {

    public override fun setId(id: String) {
        writeln("id = R.id.$id")
    }

    public override fun addProperty(key: String, value: String, keyPrefix: String) {
        super<WidgetContext>.addProperty(key, value, "")
    }
}