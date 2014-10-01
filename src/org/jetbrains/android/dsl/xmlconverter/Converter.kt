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

import javax.xml.parsers.SAXParserFactory
import java.io.File

class Converter {
    val buffer = StringBuffer()
    val controlsXmlBuffer = StringBuffer()
    fun run(ifn: String) {
        val spf = SAXParserFactory.newInstance()
        spf?.setNamespaceAware(true)
        val parser = spf?.newSAXParser()
        val reader = parser?.getXMLReader()
        reader?.setContentHandler(XmlHandler(buffer, controlsXmlBuffer, ConverterSettings()))
        reader?.parse(convertToFileURL(ifn))
    }

    public override fun toString(): String {
        return buffer.toString()
    }
}

fun convertToFileURL(filename: String): String {
    var path = File(filename).getAbsolutePath();
    if (File.separatorChar != '/') {
        path = path.replace(File.separatorChar, '/');
    }
    if (!path.startsWith("/")) {
        path = "/" + path;
    }
    return "file:" + path;
}

fun main(args: Array<String>) {
    val c = Converter()
    c.run(args[0])
    println(c.toString())
}