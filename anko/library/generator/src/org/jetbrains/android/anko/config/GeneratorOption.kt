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

package org.jetbrains.android.anko.config

sealed class GeneratorOption {
    class LogLevel(val arg: String) : GeneratorOption()

    companion object {
        private val OPTIONS = mapOf<String, (String?) -> GeneratorOption>(
                "level" to { a -> LogLevel(a!!) })

        fun parse(s: String): GeneratorOption? {
            val parts = s.split(':')
            if (parts.size != 1 && parts.size != 2) {
                throw IllegalArgumentException("Invalid option format: need 'key:value' or 'key'")
            }

            return (OPTIONS[parts[0]] ?: throw IllegalArgumentException("Invalid key: ${parts[0]}"))(parts[1])
        }
    }
}