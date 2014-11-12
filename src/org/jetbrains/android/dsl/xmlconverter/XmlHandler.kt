/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl.xmlconverter

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.HashMap
import org.jetbrains.android.dsl.Context

class XmlHandler(val buffer: StringBuffer, val controlsXmlBuffer: StringBuffer, val settings: BaseConverterSettings): DefaultHandler() {

    val globalCtx = Context(buffer)
    val importsCtx = globalCtx.fork()
    val headerCtx = globalCtx.fork()
    val widgetsDeclCtx = globalCtx.fork(newIndentDepth = globalCtx.indentDepth + 1)
    val widgetsBodyCtx = globalCtx.fork(newIndentDepth = globalCtx.indentDepth + 1)

    val controlsBuffer = Context(controlsXmlBuffer)
    var lastLayout = ""

    override fun startElement(uri: String, localName: String, qName_: String, attributes: Attributes) {
        val attrs = attributes.toMap()
        val ctx: WidgetContext
        val qName = qName_
        widgetsBodyCtx.incIndent()
        if (qName.endsWith("Layout")) {
            lastLayout = qName
            ctx = widgetsBodyCtx.adopt(LayoutContext())
        } else {
            ctx = widgetsBodyCtx.adopt(WidgetContext())
        }
        val id = produceId(attrs, qName)
        if (id != null) {
            ctx.writeNoIndent(buildCons(qName, attrs) + " {\n")
            ctx.incIndent()
            ctx.setId(id)
            ctx.decIndent()
        }
        else
            ctx.writeln(buildCons(qName, attrs) + " {")
        ctx.incIndent()
        for (attr in attrs) {
            if (isSkippableAttr(attr.key)) continue
            ctx.addProperty(attr.key, attr.value)
        }
        widgetsBodyCtx.absorbChildren(true)
    }

    private fun produceId(attributes: HashMap<String, String>?, widgetClass: String): String? {
        if (attributes == null) return null
        val id = attributes["id"]
        attributes.remove("id")
        if (id == null) return null
        val idValue = id.substring(id.indexOf("/") + 1)
        controlsBuffer writeln "<item name=\"$idValue\" type=\"id\"/>"
        widgetsBodyCtx write "$idValue = "
        widgetsDeclCtx writeln "val $idValue: $widgetClass by Delegates.notNull();"
        return idValue
    }

    private fun isSkippableAttr(name: String?): Boolean {
        return name in settings.ignoredProperties
    }

    private fun quote(key: String, value: String?): String? {
        return if (key in settings.quotedKeys) "\"$value\"" else value
    }

    private fun buildCons(qName: String, attrs: HashMap<String, String>?): String {
        if(attrs == null)
            return qName.decapitalize()
        //FIXME: how to deal with name clashes?
        val classInternalName = settings.helperConProps.keySet().firstOrNull { it.endsWith("." + qName) }
        val constructors = settings.helperConProps[classInternalName]
        //no helper constructors at all
        if (constructors == null)
            return qName.decapitalize()
        //else find constructor with as many matching arguments as possible
        val attrKeys = attrs.keySet()
        var bestMatchingCons: Set<String>? = null
        for (cons in constructors) {
            if (cons.all { it in attrKeys }) {
                if (bestMatchingCons != null) {
                    if (cons.size > bestMatchingCons!!.size)
                        bestMatchingCons = cons
                } else {
                    bestMatchingCons = cons
                }
            }
        }
        //no matching constructor found
        if (bestMatchingCons == null)
            return qName.decapitalize()
        val res = StringBuffer()
        res append "${qName.decapitalize()}("
        for (arg in bestMatchingCons!!) {
            res append "$arg = ${quote(arg, attrs[arg])}, "
            attrs.remove(arg)
        }
        res.trim(2)
        res append ")"
        return res.toString()
    }

    override fun endElement(uri: String?, localName: String, qName: String) {
        widgetsBodyCtx.writeln("}")
        widgetsBodyCtx.decIndent()
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {

    }

    override fun startDocument() {
        importsCtx writeln "import android.view.ViewGroup.LayoutParams.*"
        importsCtx writeln "import android.widget.*"
        importsCtx writeln "import ${settings.dslPackage}.*"
        importsCtx writeln "import kotlin.properties.Delegates"
        headerCtx writeln "\nclass ${settings.className}(val act: android.app.Activity) {"
        widgetsDeclCtx.newLine()
        widgetsBodyCtx writeln "{"
        widgetsBodyCtx.incIndent()
        widgetsBodyCtx writeln "act.UI {"
        controlsBuffer writeln "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
        controlsBuffer writeln "<resources>"
        controlsBuffer.incIndent()
    }

    override fun endDocument() {
        widgetsBodyCtx.writeln("}")
        widgetsBodyCtx.decIndent()
        widgetsBodyCtx.writeln("}")
        controlsBuffer.decIndent()
        controlsBuffer writeln "</resources>"
        widgetsDeclCtx.newLine()
        widgetsBodyCtx.decIndent()
        widgetsBodyCtx.writeln("}")
        globalCtx.absorbChildren()
    }

    private fun processAttribute(name: String?, value: String?, layoutFunc: (String?, String?) -> Unit) {
        when (name) {
            "layout_width" -> layoutFunc(name, value)
            "layout_height" -> layoutFunc(name, value)
            "text" -> widgetsBodyCtx.writeln("$name = \"$value\"")
            "caption" -> widgetsBodyCtx.writeln("$name = \"$value\"")
            else -> widgetsBodyCtx.writeln("$name = $value")
        }
    }
}
