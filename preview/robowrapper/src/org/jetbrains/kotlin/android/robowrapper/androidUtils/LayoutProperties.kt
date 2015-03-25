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

import android.widget.RelativeLayout.*

val relativeLayoutProperties = mapOf(
        "above" to ABOVE,
        "alignBaseline" to ALIGN_BASELINE,
        "alignBottom" to ALIGN_BOTTOM,
        "alignLeft" to ALIGN_LEFT,
        "alignParentBottom" to ALIGN_PARENT_BOTTOM,
        "alignParentLeft" to ALIGN_PARENT_LEFT,
        "alignParentRight" to ALIGN_PARENT_RIGHT,
        "alignParentTop" to ALIGN_PARENT_TOP,
        "alignRight" to ALIGN_RIGHT,
        "alignTop" to ALIGN_TOP,
        "below" to BELOW,
        "centerHorizontal" to CENTER_HORIZONTAL,
        "center" to CENTER_IN_PARENT,
        "centerVertical" to CENTER_VERTICAL,
        "leftOf" to LEFT_OF,
        "rightOf" to RIGHT_OF,
        "alignStart" to ALIGN_START,
        "alignEnd" to ALIGN_END,
        "alignParentStart" to ALIGN_PARENT_START,
        "alignParentEnd" to ALIGN_PARENT_END,
        "startOf" to START_OF,
        "endOf" to END_OF
)