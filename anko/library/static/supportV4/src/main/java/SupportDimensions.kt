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
package org.jetbrains.anko.support.v4

import android.support.v4.app.Fragment
import org.jetbrains.anko.dimen
import org.jetbrains.anko.dip
import org.jetbrains.anko.px2dip
import org.jetbrains.anko.px2sp
import org.jetbrains.anko.sp

inline fun Fragment.dip(value: Int): Int = requireActivity().dip(value)

inline fun Fragment.dip(value: Float): Int = requireActivity().dip(value)

inline fun Fragment.sp(value: Int): Int = requireActivity().sp(value)

inline fun Fragment.sp(value: Float): Int = requireActivity().sp(value)

inline fun Fragment.px2dip(px: Int): Float = requireActivity().px2dip(px)

inline fun Fragment.px2sp(px: Int): Float = requireActivity().px2sp(px)

inline fun Fragment.dimen(resource: Int): Int = requireActivity().dimen(resource)
