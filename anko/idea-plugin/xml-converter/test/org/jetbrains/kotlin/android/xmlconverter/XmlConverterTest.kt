package org.jetbrains.kotlin.android.xmlconverter

import org.junit.Test

class XmlConverterTest : BaseXmlConverterTest() {

    @Test fun testSimple() = doLayoutTest()
    @Test fun testLinearLayout() = doLayoutTest()
    @Test fun testRelativeLayout() = doLayoutTest()
    @Test fun testDimensions() = doLayoutTest()
    @Test fun testAttributes() = doLayoutTest()

}