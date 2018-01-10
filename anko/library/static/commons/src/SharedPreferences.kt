
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

package org.jetbrains.anko

import android.content.SharedPreferences

/**
 * Opens the [SharedPreferences.Editor], applies the [modifer] to it and then applies the changes asynchronously
 */
inline fun SharedPreferences.apply(modifier: SharedPreferences.Editor.() -> Unit) {
    val editor = this.edit()
    editor.modifier()
    editor.apply()
}

/**
 * Opens the [SharedPreferences.Editor], applies the [modifer] to it and then applies the changes synchronously
 */
inline fun SharedPreferences.commit(modifier: SharedPreferences.Editor.() -> Unit) {
    val editor = this.edit()
    editor.modifier()
    editor.commit()
}