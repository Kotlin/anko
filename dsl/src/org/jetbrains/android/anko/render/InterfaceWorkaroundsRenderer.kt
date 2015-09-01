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

package org.jetbrains.android.anko.render

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationOption
import org.jetbrains.android.anko.generator.GenerationState
import org.jetbrains.android.anko.generator.InterfaceWorkaroundsGenerator
import org.objectweb.asm.Type

class InterfaceWorkaroundsRenderer(config: AnkoConfiguration) : Renderer(config) {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.INTERFACE_WORKAROUNDS_JAVA)

    override fun processElements(state: GenerationState) = StringBuilder {
        val interfaces = state[InterfaceWorkaroundsGenerator::class.java].toList()

        append(render("interface_workarounds") {
            "interfaces" % seq(interfaces) {
                val (mainClass, ancestor, innerClass) = it
                val probInterfaceName = innerClass.innerName
                val conflict = interfaces.count { it.inner.innerName == probInterfaceName } > 1
                val interfaceName = (if (conflict) innerClass.outerName.substringAfterLast("/") + "_" else "") + probInterfaceName

                "name" % interfaceName
                "ancestor" % ancestor.fqName

                val acceptableFields = mainClass.fields.filter { it.isPublic && it.isStatic && it.isFinal }
                "fields" % seq(acceptableFields) { field ->
                    "type" % Type.getType(field.desc).asJavaString()
                    "name" % field.name
                }
            }
        })

    }.toString()
}