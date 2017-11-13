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

package org.jetbrains.android.anko.generator

import org.jetbrains.android.anko.utils.isAbstract
import org.jetbrains.android.anko.utils.isInterface
import org.jetbrains.android.anko.utils.isPublic
import org.objectweb.asm.tree.ClassNode

abstract class AbstractViewGenerator(private val forLayouts: Boolean) : Generator<ViewElement> {

    override fun generate(state: GenerationState) = with (state) {
        fun ClassNode.isViewGroupWithParams() = isViewGroup && hasLayoutParams(this)

        state.availableClasses
                .filter { it.isPublic && it.isView && forLayouts == it.isViewGroupWithParams() }
                .map { ViewElement(it, if (forLayouts) true else it.isViewGroup, { it.resolveAllMethods() }) }
                .sortedBy { it.clazz.name }
    }

    private fun GenerationState.hasLayoutParams(viewGroup: ClassNode): Boolean {
        return !viewGroup.isAbstract && extractLayoutParams(viewGroup) != null
    }
}

class ViewGenerator : AbstractViewGenerator(forLayouts = false)

class ViewGroupGenerator : AbstractViewGenerator(forLayouts = true)