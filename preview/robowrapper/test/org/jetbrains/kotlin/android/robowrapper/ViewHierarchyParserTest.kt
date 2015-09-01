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
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import android.view.ViewGroup.LayoutParams.*
import android.content.Context
import android.view.View
import org.jetbrains.kotlin.android.robowrapper.test.SomeView
import android.widget.ImageView
import kotlin.test.*
import android.view.ViewGroup
import org.jetbrains.kotlin.android.attrs.Attr

Config(manifest = Config.NONE)
RunWith(RobolectricTestRunner::class)
public class ViewHierarchyParserTest() {

  Test
  public fun testGetViewHierarchy() {
    val a = Robolectric.setupActivity(Activity::class.java)

    val frameLayout = FrameLayout(a)
    val linearLayout = LinearLayout(a)
    val textView = TextView(a)
    textView.setPadding(10, 20, 30, 40)
    val button = Button(a)
    button.text = "Button text"

    linearLayout.addView(textView)
    linearLayout.addView(button)
    frameLayout.addView(linearLayout)

    val viewNode = parseView(frameLayout)
    assertTrue(viewNode.view is FrameLayout)
    assertEquals(1, viewNode.children.size())
    assertTrue(viewNode.children[0].view is LinearLayout)
    assertTrue(viewNode.children[0].children[0].view is TextView)
    assertTrue(viewNode.children[0].children[1].view is Button)

    val t = viewNode.children[0].children[0]
    val b = viewNode.children[0].children[1]

    with (t.attrs.fetch("paddingLeft")) {
      assertEquals("paddingLeft", first)
      assertNotNull(second.first)
      assertEquals(1, second.first!!.format.size())
      assertEquals("dimension", second.first!!.format[0])
      assertEquals(10, second.second)
    }

    with (b.attrs.fetch("text")) {
      assertEquals("text", first)
      assertNotNull(second.first)
      assertEquals(1, second.first!!.format.size())
      assertEquals("string", second.first!!.format[0])
      assertEquals("Button text", second.second)
    }
  }

  Test
  public fun testLayoutParams() {
    val a = Robolectric.setupActivity(Activity::class.java)

    val linearLayout = LinearLayout(a)
    val textView = TextView(a)

    val textViewLP = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    textViewLP.gravity = Gravity.CENTER

    linearLayout.addView(textView, textViewLP)

    val viewNode = parseView(linearLayout)
    assertEquals(1, viewNode.children.size())
    assertTrue(viewNode.children[0].view is TextView)
    val t = viewNode.children[0]

    with (t.attrs.fetch("layoutParams")) {
      assertEquals("layoutParams", first)
      assertNull(second.first)
      assertTrue(second.second is LinearLayout.LayoutParams)
      val lp = second.second as LinearLayout.LayoutParams
      assertEquals(MATCH_PARENT, lp.width)
      assertEquals(WRAP_CONTENT, lp.height)
      assertEquals(Gravity.CENTER, lp.gravity)
    }
  }

  Test
  public fun testSpecialProperty() {
    val a = Robolectric.setupActivity(Activity::class.java)

    val textView = TextView(a)
    val imageView = ImageView(a)

    //special
    assertEquals("src", resolveSpecialProperty(imageView, "drawable"))

    //nothing special
    assertEquals("text", resolveSpecialProperty(textView, "text"))
    assertEquals("paddingRight", resolveSpecialProperty(imageView, "paddingRight"))
  }

  Test
  public fun testXmlName() {
    val a = Robolectric.setupActivity(Activity::class.java)

    val linearLayout = LinearLayout(a)
    val view = View(a)
    val textView = TextView(a)
    val someView = SomeView(a)

    assertEquals("LinearLayout", parseView(linearLayout).getXmlName())
    assertEquals("View", parseView(view).getXmlName())
    assertEquals("TextView", parseView(textView).getXmlName())
    assertEquals("org.jetbrains.kotlin.android.robowrapper.test.SomeView", parseView(someView).getXmlName())
  }

  Test
  public fun testStyleableNames() {
    Robolectric.setupActivity(Activity::class.java)

    assertEquals(listOf("TextView"), TextView::class.java.getStyleableNames())
    assertEquals(listOf("View"), View::class.java.getStyleableNames())
    assertEquals(listOf("ViewGroup"), ViewGroup::class.java.getStyleableNames())
    assertEquals(listOf("LinearLayout_Layout"),
      LinearLayout.LayoutParams::class.java.getStyleableNames())
    assertEquals(listOf("ViewGroup_Layout", "ViewGroup_MarginLayout"),
      ViewGroup.LayoutParams::class.java.getStyleableNames())
  }

  Test
  public fun testUnwrapClass() {
    Robolectric.setupActivity(Activity::class.java)

    assertEquals("android.widget.LinearLayout",
      unwrapClass(_LinearLayout::class.java).name)

    assertEquals("org.jetbrains.kotlin.android.robowrapper._NonWrapper1Class",
      unwrapClass(_NonWrapper1Class::class.java).name)

    assertEquals("org.jetbrains.kotlin.android.robowrapper._NonWrapper2Class",
      unwrapClass(_NonWrapper2Class::class.java).name)
  }

  private fun Set<Pair<String, Pair<Attr?, Any>>>.fetch(name: String): Pair<String, Pair<Attr?, Any>> {
    for (item in this) {
      if (item.first == name)
        return item;
    }
    throw Exception("Can't find property $name")
  }

}

public class _LinearLayout(ctx: Context?): LinearLayout(ctx)
public class _NonWrapper1Class(ctx: Context?): View(ctx)
//has strange name (not _LinearLayout)
public class _NonWrapper2Class(ctx: Context?): LinearLayout(ctx)