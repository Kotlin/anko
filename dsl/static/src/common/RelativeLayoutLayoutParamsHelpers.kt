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

@file:Suppress("NOTHING_TO_INLINE")
@file:JvmMultifileClass
@file:JvmName("RelativeLayoutLayoutParamsHelpersKt")
package org.jetbrains.anko

import android.view.View
import android.widget.RelativeLayout.*

public inline fun LayoutParams.topOf(v: View): Unit = addRule(ABOVE, v.id)

public inline fun LayoutParams.above(v: View): Unit = addRule(ABOVE, v.id)

public inline fun LayoutParams.below(v: View): Unit = addRule(BELOW, v.id)

public inline fun LayoutParams.bottomOf(v: View): Unit = addRule(BELOW, v.id)

public inline fun LayoutParams.leftOf(v: View): Unit = addRule(LEFT_OF, v.id)

public inline fun LayoutParams.rightOf(v: View): Unit = addRule(RIGHT_OF, v.id)

public inline fun LayoutParams.sameLeft(v: View): Unit = addRule(ALIGN_LEFT, v.id)

public inline fun LayoutParams.sameTop(v: View): Unit = addRule(ALIGN_TOP, v.id)

public inline fun LayoutParams.sameRight(v: View): Unit = addRule(ALIGN_RIGHT, v.id)

public inline fun LayoutParams.sameBottom(v: View): Unit = addRule(ALIGN_BOTTOM, v.id)

public inline fun LayoutParams.topOf(id: Int): Unit = addRule(ABOVE, id)

public inline fun LayoutParams.above(id: Int): Unit = addRule(ABOVE, id)

public inline fun LayoutParams.below(id: Int): Unit = addRule(BELOW, id)

public inline fun LayoutParams.bottomOf(id: Int): Unit = addRule(BELOW, id)

public inline fun LayoutParams.leftOf(id: Int): Unit = addRule(LEFT_OF, id)

public inline fun LayoutParams.rightOf(id: Int): Unit = addRule(RIGHT_OF, id)

public inline fun LayoutParams.sameLeft(id: Int): Unit = addRule(ALIGN_LEFT, id)

public inline fun LayoutParams.sameTop(id: Int): Unit = addRule(ALIGN_TOP, id)

public inline fun LayoutParams.sameRight(id: Int): Unit = addRule(ALIGN_RIGHT, id)

public inline fun LayoutParams.sameBottom(id: Int): Unit = addRule(ALIGN_BOTTOM, id)

public inline fun LayoutParams.alignParentTop(): Unit = addRule(ALIGN_PARENT_TOP)

public inline fun LayoutParams.alignParentLeft(): Unit = addRule(ALIGN_PARENT_LEFT)

public inline fun LayoutParams.alignParentBottom(): Unit = addRule(ALIGN_PARENT_BOTTOM)

public inline fun LayoutParams.alignParentRight(): Unit = addRule(ALIGN_PARENT_RIGHT)

public inline fun LayoutParams.centerHorizontally(): Unit = addRule(CENTER_HORIZONTAL)

public inline fun LayoutParams.centerVertically(): Unit = addRule(CENTER_VERTICAL)

public inline fun LayoutParams.centerInParent(): Unit = addRule(CENTER_IN_PARENT)

// Unavailable in older versions of SDK
public inline fun LayoutParams.alignParentStart(): Unit = addRule(20) // ALIGN_PARENT_START

public inline fun LayoutParams.alignParentEnd(): Unit = addRule(21) // ALIGN_PARENT_END
