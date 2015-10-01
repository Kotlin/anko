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

package org.jetbrains.kotlin.android.dslpreview

import com.google.gson.Gson

class Pack(
        val xml: String,
        val error_code: Int,
        val error: String,
        val stacktrace: String,
        val alive: Boolean,
        var port: Int = -1
) {

    fun toJson(): String {
        return gson.toJson(this)
    }

    companion object {
        private val gson = Gson()
    }
}