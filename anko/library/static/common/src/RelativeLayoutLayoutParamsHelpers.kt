/*
 * Copyright 2016 JetBrains s.r.o.
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

@file:Suppress("NOTHING_TO_INLINE", "unused")
package org.jetbrains.anko

import android.view.View
import android.widget.RelativeLayout.*

/**
 * Place the current View above [view].
 * It is an alias for [above].
 */
inline fun LayoutParams.topOf(view: View): Unit = addRule(ABOVE, view.id)

/**
 * Place the current View above [view].
 */
inline fun LayoutParams.above(view: View): Unit = addRule(ABOVE, view.id)

/**
 * Place the current View below [view].
 * It is an alias for [below].
 */
inline fun LayoutParams.bottomOf(view: View): Unit = addRule(BELOW, view.id)

/**
 * Place the current View below [view].
 */
inline fun LayoutParams.below(view: View): Unit = addRule(BELOW, view.id)

/**
 * Place the current View to the left of [view].
 */
inline fun LayoutParams.leftOf(view: View): Unit = addRule(LEFT_OF, view.id)

/**
 * Place the current View to the right of [view].
 */
inline fun LayoutParams.rightOf(view: View): Unit = addRule(RIGHT_OF, view.id)

/**
 * Set the current View left attribute the same as for [view].
 */
inline fun LayoutParams.sameLeft(view: View): Unit = addRule(ALIGN_LEFT, view.id)

/**
 * Set the current View top attribute the same as for [view].
 */
inline fun LayoutParams.sameTop(view: View): Unit = addRule(ALIGN_TOP, view.id)

/**
 * Set the current View right attribute the same as for [view].
 */
inline fun LayoutParams.sameRight(view: View): Unit = addRule(ALIGN_RIGHT, view.id)

/**
 * Set the current View bottom attribute the same as for [view].
 */
inline fun LayoutParams.sameBottom(view: View): Unit = addRule(ALIGN_BOTTOM, view.id)

/**
 * Place the current View above the View with a given [id].
 * It is an alias for [above].
 */
inline fun LayoutParams.topOf(id: Int): Unit = addRule(ABOVE, id)

/**
 * Place the current View above the View with a given [id].
 */
inline fun LayoutParams.above(id: Int): Unit = addRule(ABOVE, id)

/**
 * Place the current View below the View with a given [id].
 */
inline fun LayoutParams.below(id: Int): Unit = addRule(BELOW, id)

/**
 * Place the current View below the View with a given [id].
 * It is an alias for [below].
 */
inline fun LayoutParams.bottomOf(id: Int): Unit = addRule(BELOW, id)

/**
 * Place the current View to the left of the View with a given [id].
 */
inline fun LayoutParams.leftOf(id: Int): Unit = addRule(LEFT_OF, id)

/**
 * Place the current View to the left of the View with a given [id].
 */
inline fun LayoutParams.rightOf(id: Int): Unit = addRule(RIGHT_OF, id)

/**
 * Set the current View left attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameLeft(id: Int): Unit = addRule(ALIGN_LEFT, id)

/**
 * Set the current View top attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameTop(id: Int): Unit = addRule(ALIGN_TOP, id)

/**
 * Set the current View right attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameRight(id: Int): Unit = addRule(ALIGN_RIGHT, id)

/**
 * Set the current View bottom attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameBottom(id: Int): Unit = addRule(ALIGN_BOTTOM, id)

/**
 * Align the current View's start edge with another child's start edge.
 */
inline fun LayoutParams.alignStart(id: Int): Unit = addRule(18, id) // ALIGN_END

/**
 * Align the current View's end edge with another child's end edge.
 */
inline fun LayoutParams.alignEnd(id: Int): Unit = addRule(19, id) // ALIGN_END

/**
 * Align the current View's top edge with its parent's top edge.
 */
inline fun LayoutParams.alignParentTop(): Unit = addRule(ALIGN_PARENT_TOP)

/**
 * Align the current View's right edge with its parent's right edge.
 */
inline fun LayoutParams.alignParentRight(): Unit = addRule(ALIGN_PARENT_RIGHT)

/**
 * Align the current View's bottom edge with its parent's bottom edge.
 */
inline fun LayoutParams.alignParentBottom(): Unit = addRule(ALIGN_PARENT_BOTTOM)

/**
 * Align the current View's left edge with its parent's left edge.
 */
inline fun LayoutParams.alignParentLeft(): Unit = addRule(ALIGN_PARENT_LEFT)

/**
 * Center the child horizontally in its parent.
 */
inline fun LayoutParams.centerHorizontally(): Unit = addRule(CENTER_HORIZONTAL)

/**
 * Center the child vertically in its parent.
 */
inline fun LayoutParams.centerVertically(): Unit = addRule(CENTER_VERTICAL)

/**
 * Center the child horizontally and vertically in its parent.
 */
inline fun LayoutParams.centerInParent(): Unit = addRule(CENTER_IN_PARENT)

/**
 * Align the current View's start edge with its parent's start edge.
 */
inline fun LayoutParams.alignParentStart(): Unit = addRule(20) // ALIGN_PARENT_START

/**
 * Align the current View's end edge with its parent's end edge.
 */
inline fun LayoutParams.alignParentEnd(): Unit = addRule(21) // ALIGN_PARENT_END

/**
 * Positions the baseline of this view on the baseline of the given anchor [view].
 */
inline fun LayoutParams.baselineOf(view: View): Unit = addRule(ALIGN_BASELINE, view.id)

/**
 * Positions the baseline of this view on the baseline of the anchor View with a given [id].
 */
inline fun LayoutParams.baselineOf(id: Int): Unit = addRule(ALIGN_BASELINE, id)
