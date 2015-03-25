/*
 * Copyright 2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.android.robowrapper

import android.app.Activity
import android.view.Gravity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.*
import android.text.TextUtils.TruncateAt
import android.widget.ImageView.ScaleType
import android.widget.TextView
import android.view.View
import android.widget.LinearLayout
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.Button
import java.io.ByteArrayInputStream
import kotlin.dom.parseXml
import org.w3c.dom.Element

Config(manifest = Config.NONE, emulateSdk = 18)
RunWith(javaClass<RobolectricTestRunner>())
public class XmlBuilderTest {

  Test
  public fun testXml() {
    val a = Robolectric.setupActivity<Activity>(javaClass<Activity>())

    val frameLayout = FrameLayout(a)
    val linearLayout = LinearLayout(a)
    linearLayout.setOrientation(LinearLayout.VERTICAL)

    val textView = TextView(a)
    textView.setPadding(10, 20, 30, 40)
    val textViewLP = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    textViewLP.gravity = Gravity.CENTER

    val button = Button(a)
    button.setText("Button text")

    linearLayout.addView(textView, textViewLP)
    linearLayout.addView(button)
    frameLayout.addView(linearLayout)

    val xml = toXml(parseView(frameLayout))
    val inputStream = ByteArrayInputStream(xml.toByteArray("UTF-8"))
    val document = parseXml(inputStream)

    val rootElement = document.getDocumentElement()!!
    assertEquals("FrameLayout", rootElement.getTagName())

    val linearLayoutElement = rootElement.getElementsByTagName("LinearLayout")?.item(0) as Element
    assertEquals("LinearLayout", linearLayoutElement.getTagName())
    assertEquals("vertical", linearLayoutElement.getAttribute("android:orientation"))

    val textViewElement = linearLayoutElement.getElementsByTagName("TextView")?.item(0) as Element
    assertEquals("TextView", textViewElement.getTagName())
    assertEquals("10dp", textViewElement.getAttribute("android:paddingLeft"))
    assertEquals("20dp", textViewElement.getAttribute("android:paddingTop"))
    assertEquals("30dp", textViewElement.getAttribute("android:paddingRight"))
    assertEquals("40dp", textViewElement.getAttribute("android:paddingBottom"))
    assertEquals("match_parent", textViewElement.getAttribute("android:layout_width"))
    assertEquals("wrap_content", textViewElement.getAttribute("android:layout_height"))
    assertEquals("center_vertical|center_horizontal", textViewElement.getAttribute("android:layout_gravity"))

    val buttonElement = linearLayoutElement.getElementsByTagName("Button")?.item(0) as Element
    assertEquals("Button", buttonElement.getTagName())
    assertEquals("Button text", buttonElement.getAttribute("android:text"))
  }

  Test
  public fun testGravity() {
    Robolectric.setupActivity<Activity>(javaClass<Activity>())
    assertEquals("center_vertical|center_horizontal", resolveGravity(Gravity.CENTER))
    assertEquals("left|right", resolveGravity(Gravity.FILL_HORIZONTAL))
    assertEquals("top|bottom", resolveGravity(Gravity.FILL_VERTICAL))
    assertEquals("top", resolveGravity(Gravity.TOP))
    assertEquals("right", resolveGravity(Gravity.RIGHT))
    assertEquals("start", resolveGravity(Gravity.START))
    assertEquals("end", resolveGravity(Gravity.END))
    assertEquals("center_horizontal", resolveGravity(Gravity.CENTER_HORIZONTAL))
    assertEquals("right|bottom", resolveGravity(Gravity.RIGHT or Gravity.BOTTOM))
    assertEquals("left|top|right|bottom", resolveGravity(Gravity.FILL))
  }

  Test
  public fun testBasicRenderAttr() {
    Robolectric.setupActivity<Activity>(javaClass<Activity>())
    val key = "someKey" //used only for debug print

    assertEquals("1", basicRenderAttr(key, 1))
    assertEquals("-5", basicRenderAttr(key, -5))
    assertEquals("0", basicRenderAttr(key, 0))
    assertEquals("0", basicRenderAttr(key, 0.0))
    assertEquals("2", basicRenderAttr(key, 1.9999999999999999999999999999.toFloat()))
    assertEquals("2.5", basicRenderAttr(key, 2.5))
    assertEquals("2.5", basicRenderAttr(key, 2.5.toFloat()))
    assertEquals("SomeText", basicRenderAttr(key, "SomeText"))
    assertEquals("true", basicRenderAttr(key, true))
    assertEquals("false", basicRenderAttr(key, false))
  }

  Test
  public fun testResolveEllipsize() {
    Robolectric.setupActivity<Activity>(javaClass<Activity>())

    assertEquals("end", convertEllipsize(TruncateAt.END))
    assertEquals("marquee", convertEllipsize(TruncateAt.MARQUEE))
    assertEquals("middle", convertEllipsize(TruncateAt.MIDDLE))
    assertEquals("start", convertEllipsize(TruncateAt.START))
  }

  Test
  public fun testResolveScaleType() {
    assertEquals("center", convertScaleType(ScaleType.CENTER))
    assertEquals("centerCrop", convertScaleType(ScaleType.CENTER_CROP))
    assertEquals("fitInside", convertScaleType(ScaleType.CENTER_INSIDE))
    assertEquals("fitCenter", convertScaleType(ScaleType.FIT_CENTER))
    assertEquals("fitEnd", convertScaleType(ScaleType.FIT_END))
    assertEquals("fitStart", convertScaleType(ScaleType.FIT_START))
    assertEquals("fitXY", convertScaleType(ScaleType.FIT_XY))
    assertEquals("matrix", convertScaleType(ScaleType.MATRIX))
  }

  Test
  public fun testresolveDimension() {
    val a = Robolectric.setupActivity<Activity>(javaClass<Activity>())
    val v = View(a)

    assertEquals("17sp", resolveDimension(TextView(a), "textSize", "17"))
    assertEquals("4dp", resolveDimension(v, "paddingRight", "4")) //density=1
  }

  Test
  public fun testParseEnumFlagValue() {
    assertEquals(-1L, "-1".parseEnumFlagValue())
    assertEquals(0L, "0".parseEnumFlagValue())
    assertEquals(1L, "1".parseEnumFlagValue())
    assertEquals(1L, "0x1".parseEnumFlagValue())
    assertEquals(0L, "0x0".parseEnumFlagValue())
    assertEquals(255L, "0xfF".parseEnumFlagValue())
  }

}
