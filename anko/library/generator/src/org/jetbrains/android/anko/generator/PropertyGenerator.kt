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

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.utils.MethodNodeWithClass
import org.jetbrains.android.anko.utils.fqName
import org.jetbrains.android.anko.utils.toProperty
import org.jetbrains.android.anko.utils.unique
import org.objectweb.asm.tree.MethodNode

class PropertyGenerator : Generator<PropertyElement> {

    override fun generate(state: GenerationState) = with (state) {
        val propertyGetters = availableMethods
                .filter {
                    it.clazz.isView &&
                            it.method.isGetter() && !it.method.isOverridden && !it.method.isListenerGetter &&
                            !config.excludedProperties.contains(it.clazz.fqName + "#" + it.method.name) &&
                            !config.excludedProperties.contains(it.clazz.fqName + "#*")
                }
                .sortedBy { it.identifier }

        val propertySetters = availableMethods
                .filter {
                    it.clazz.isView && it.method.isNonListenerSetter() && !it.method.isOverridden &&
                            !config.excludedProperties.contains(it.clazz.fqName + "#" + it.method.name) &&
                            !config.excludedProperties.contains(it.clazz.fqName + "#*")
                }
                .groupBy { it.identifier }

        genProperties(propertyGetters, propertySetters)
    }

    private fun GenerationState.genProperties(
            getters: Collection<MethodNodeWithClass>,
            setters: Map<String, List<MethodNodeWithClass>>): List<PropertyElement> {
        val existingProperties = hashSetOf<String>()

        val propertyWithGetters = getters.map { getter ->
            val property = getter.toProperty()
            val settersList = setters[property.setterIdentifier] ?: emptyList()

            val (best, others) = settersList.partition {
                it.method.parameterRawTypes.unique == getter.method.returnType
            }

            existingProperties.add(property.setterIdentifier)
            PropertyElement(property.name, getter, best + others)
        }
        val propertyWithoutGetters = setters.values.map { s ->
            val property = s.first().toProperty()

            val id = property.setterIdentifier
            if (id !in existingProperties) {
                if (property.propertyFqName in config.propertiesWithoutGetters) {
                    PropertyElement(property.name, null, s)
                } else {
                    logger.d("PropertyGenerator # Property was not generated for $id")
                    null
                }
            } else null
        }.filterNotNull()
        return propertyWithoutGetters + propertyWithGetters
    }

    private val MethodNode.isListenerGetter: Boolean
        get() = name.startsWith("get") && name.endsWith("Listener")
}