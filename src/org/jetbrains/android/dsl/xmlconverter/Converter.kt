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