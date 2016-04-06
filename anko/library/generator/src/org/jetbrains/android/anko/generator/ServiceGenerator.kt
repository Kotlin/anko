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

package org.jetbrains.android.anko.generator

import org.objectweb.asm.tree.FieldNode

class ServiceGenerator : Generator<ServiceElement> {

    override fun generate(state: GenerationState): Iterable<ServiceElement> {
        return state.classTree.findNode("android/content/Context")?.data?.fields
                ?.filter { it.name.endsWith("_SERVICE") }
                ?.map {
                    val service = state.classTree.findNode("android", it.toServiceClassName())?.data
                    if (service != null && service in state.availableClasses) {
                        ServiceElement(service, it.name)
                    } else null
                }
                ?.filterNotNull()
                ?.sortedBy { it.name }
                ?: listOf()
    }

    private fun FieldNode.toServiceClassName(): String {
        var nextCapital = true
        val builder = StringBuilder()
        for (char in name.replace("_SERVICE", "_MANAGER").toCharArray()) when (char) {
            '_' -> nextCapital = true
            else -> builder.append(
                    if (nextCapital) {
                        nextCapital = false; char
                    } else Character.toLowerCase(char)
            )
        }
        return builder.toString()
    }
}