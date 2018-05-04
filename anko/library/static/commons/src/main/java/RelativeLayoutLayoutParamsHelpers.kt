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

import android.os.Build
import android.support.annotation.IdRes
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.RelativeLayout.*

/**
 * Place the current View above [view].
 * It is an alias for [above].
 */
fun LayoutParams.topOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ABOVE, id)
}

/**
 * Place the current View above [view].
 */
fun LayoutParams.above(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ABOVE, id)
}

/**
 * Place the current View below [view].
 * It is an alias for [below].
 */
fun LayoutParams.bottomOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(BELOW, id)
}

/**
 * Place the current View below [view].
 */
fun LayoutParams.below(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(BELOW, id)
}

/**
 * Place the current View to the left of [view].
 */
inline fun LayoutParams.leftOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(LEFT_OF, id)
}

/**
 * Place the current View to the start of [view].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.startOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(START_OF, id)
}

/**
 * Place the current View to the right of [view].
 */
inline fun LayoutParams.rightOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(RIGHT_OF, id)
}

/**
 * Place the current View to the end of [view].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.endOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(END_OF, id)
}

/**
 * Set the current View left attribute the same as for [view].
 */
inline fun LayoutParams.sameLeft(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_LEFT, id)
}

/**
 * Set the current View start attribute the same as for [view].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.sameStart(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_START, id)
}

/**
 * Set the current View top attribute the same as for [view].
 */
inline fun LayoutParams.sameTop(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_TOP, id)
}

/**
 * Set the current View right attribute the same as for [view].
 */
inline fun LayoutParams.sameRight(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_RIGHT, id)
}

/**
 * Set the current View end attribute the same as for [view].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.sameEnd(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_END, id)
}

/**
 * Set the current View bottom attribute the same as for [view].
 */
inline fun LayoutParams.sameBottom(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_BOTTOM, id)
}

/**
 * Place the current View above the View with a given [id].
 * It is an alias for [above].
 */
inline fun LayoutParams.topOf(@IdRes id: Int) = addRule(ABOVE, id)

/**
 * Place the current View above the View with a given [id].
 */
inline fun LayoutParams.above(@IdRes id: Int) = addRule(ABOVE, id)

/**
 * Place the current View below the View with a given [id].
 */
inline fun LayoutParams.below(@IdRes id: Int) = addRule(BELOW, id)

/**
 * Place the current View below the View with a given [id].
 * It is an alias for [below].
 */
inline fun LayoutParams.bottomOf(@IdRes id: Int) = addRule(BELOW, id)

/**
 * Place the current View to the left of the View with a given [id].
 */
inline fun LayoutParams.leftOf(@IdRes id: Int) = addRule(LEFT_OF, id)

/**
 * Place the current View to the start of the View with a given [id].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.startOf(@IdRes id: Int): Unit = addRule(START_OF, id)

/**
 * Place the current View to the left of the View with a given [id].
 */
inline fun LayoutParams.rightOf(@IdRes id: Int) = addRule(RIGHT_OF, id)

/**
 * Place the current View to the end of the View with a given [id].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.endOf(@IdRes id: Int): Unit = addRule(END_OF, id)

/**
 * Set the current View left attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameLeft(@IdRes id: Int) = addRule(ALIGN_LEFT, id)

/**
 * Set the current View start attribute the same as for View with a given [id].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.sameStart(@IdRes id: Int): Unit = addRule(ALIGN_START, id)

/**
 * Set the current View top attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameTop(@IdRes id: Int) = addRule(ALIGN_TOP, id)

/**
 * Set the current View right attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameRight(@IdRes id: Int) = addRule(ALIGN_RIGHT, id)

/**
 * Set the current View end attribute the same as for View with a given [id].
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.sameEnd(@IdRes id: Int): Unit = addRule(ALIGN_END, id)

/**
 * Set the current View bottom attribute the same as for View with a given [id].
 */
inline fun LayoutParams.sameBottom(@IdRes id: Int) = addRule(ALIGN_BOTTOM, id)

/**
 * Align the current View's start edge with another child's start edge.
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.alignStart(@IdRes id: Int): Unit = addRule(ALIGN_START, id)

/**
 * Align the current View's end edge with another child's end edge.
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.alignEnd(@IdRes id: Int): Unit = addRule(ALIGN_END, id)

/**
 * Align the current View's top edge with its parent's top edge.
 */
inline fun LayoutParams.alignParentTop() = addRule(ALIGN_PARENT_TOP)

/**
 * Align the current View's right edge with its parent's right edge.
 */
inline fun LayoutParams.alignParentRight() = addRule(ALIGN_PARENT_RIGHT)

/**
 * Align the current View's bottom edge with its parent's bottom edge.
 */
inline fun LayoutParams.alignParentBottom() = addRule(ALIGN_PARENT_BOTTOM)

/**
 * Align the current View's left edge with its parent's left edge.
 */
inline fun LayoutParams.alignParentLeft() = addRule(ALIGN_PARENT_LEFT)

/**
 * Center the child horizontally in its parent.
 */
inline fun LayoutParams.centerHorizontally() = addRule(CENTER_HORIZONTAL)

/**
 * Center the child vertically in its parent.
 */
inline fun LayoutParams.centerVertically() = addRule(CENTER_VERTICAL)

/**
 * Center the child horizontally and vertically in its parent.
 */
inline fun LayoutParams.centerInParent() = addRule(CENTER_IN_PARENT)

/**
 * Align the current View's start edge with its parent's start edge.
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.alignParentStart(): Unit = addRule(ALIGN_PARENT_START)

/**
 * Align the current View's end edge with its parent's end edge.
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun LayoutParams.alignParentEnd(): Unit = addRule(ALIGN_PARENT_END)

/**
 * Positions the baseline of this view on the baseline of the given anchor [view].
 */
inline fun LayoutParams.baselineOf(view: View) {
    val id = view.id
    if (id == View.NO_ID) throw AnkoException("Id is not set for $view")
    addRule(ALIGN_BASELINE, id)
}

/**
 * Positions the baseline of this view on the baseline of the anchor View with a given [id].
 */
inline fun LayoutParams.baselineOf(@IdRes id: Int) = addRule(ALIGN_BASELINE, id)
