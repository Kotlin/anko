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

package org.jetbrains.android.dsl.functional
import org.jetbrains.android.dsl.*
import org.testng.annotations.Test
public class SimpleListenerTest : AbstractFunctionalTest() {
    private val testDataFile = "SimpleListenerTest.kt"
    override fun initSettings(settings: BaseGeneratorConfiguration) {
        settings.files.add(KoanFile.LISTENERS)
        settings.tunes.add(ConfigurationTune.SIMPLE_LISTENERS)
    }
    [Test] public fun testSimpleListenerTestFor21() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21")
    }
    [Test] public fun testSimpleListenerTestFor21s() {
        runFunctionalTest(testDataFile, KoanFile.LISTENERS, "21s")
    }
}
