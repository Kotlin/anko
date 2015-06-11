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

import org.jetbrains.android.anko.isInterface
import org.jetbrains.android.anko.isProtected
import org.jetbrains.android.anko.isPublic

class InterfaceWorkaroundsGenerator : Generator<InterfaceWorkaroundElement> {

    override fun generate(state: GenerationState): Iterable<InterfaceWorkaroundElement> {
        return state.availableClasses.filter {
            it.isPublic && it.innerClasses != null && it.fields != null && it.fields.notEmpty &&
                    it.innerClasses.any { inner -> inner.isProtected && inner.isInterface && inner.name == it.name }
        }.map {
            // We're looking for a public ancestor for this interface, but the ancestor also may be protected inner one
            val ancestor = state.classTree.filter {
                clazz -> clazz.isPublic && clazz.interfaces.any { itf -> itf == it.name } && (
                    clazz.innerClasses == null ||
                            clazz.innerClasses.isEmpty() ||
                            !clazz.innerClasses.any { it.name == clazz.name && it.isProtected }
                    )
            }.firstOrNull()
            val innerClass = it.innerClasses.firstOrNull {
                inner -> inner.isProtected && inner.isInterface && inner.name == it.name
            }

            if (ancestor != null && innerClass != null)
                InterfaceWorkaroundElement(it, ancestor, innerClass)
            else null
        }.filterNotNull()
    }
}