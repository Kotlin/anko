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

package org.jetbrains.android.generator.test

import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationTune
import java.io.File

fun Context.generate() {

    functionalDslTests {
        functionalDslTest("ComplexListenerClassTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.COMPLEX_LISTENER_CLASSES)
        }

        functionalDslTest("ComplexListenerSetterTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.COMPLEX_LISTENER_SETTERS)
        }

        functionalDslTest("LayoutsTest", AnkoFile.LAYOUTS) {
            file(AnkoFile.LAYOUTS)
        }

        functionalDslTest("ViewTest", AnkoFile.VIEWS) {
            file(AnkoFile.VIEWS)
            tune(ConfigurationTune.TOP_LEVEL_DSL_ITEMS)
            tune(ConfigurationTune.HELPER_CONSTRUCTORS)
        }

        functionalDslTest("PropertyTest", AnkoFile.PROPERTIES) {
            file(AnkoFile.PROPERTIES)
        }

        functionalDslTest("ServicesTest", AnkoFile.SERVICES) {
            file(AnkoFile.SERVICES)
        }

        functionalDslTest("SimpleListenerTest", AnkoFile.LISTENERS) {
            file(AnkoFile.LISTENERS)
            tune(ConfigurationTune.SIMPLE_LISTENERS)
        }

        functionalDslTest("InterfaceWorkaroundsTest", AnkoFile.INTERFACE_WORKAROUNDS_JAVA) {
            file(AnkoFile.INTERFACE_WORKAROUNDS_JAVA)
        }

        functionalDslTest("SqlParserHelpersTest", AnkoFile.SQL_PARSER_HELPERS) {
            file(AnkoFile.SQL_PARSER_HELPERS)
        }
    }

    dslCompileTests(ktFiles("robolectric"), "Robolectric")

    dslCompileTests(ktFiles("compile"), "Compile")
}

private fun ktFiles(category: String) = File("dsl/testData/$category")
        .listFiles { file -> file.name.endsWith(".kt") }?.map { it.name.replace(".kt", "") } ?: listOf()