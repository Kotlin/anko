package org.jetbrains.kotlin.android.xmlconverter

import org.junit.Test
import org.junit.rules.TestName
import org.junit.Rule
import java.io.File
import sun.plugin.dom.exception.InvalidStateException
import kotlin.test.assertEquals

public class XmlConverterTest : BaseXmlConverterTest() {

    Test fun testSimple() = doLayoutTest()
    Test fun testLinearLayout() = doLayoutTest()
    Test fun testRelativeLayout() = doLayoutTest()
    Test fun testDimensions() = doLayoutTest()
    Test fun testAttributes() = doLayoutTest()

}