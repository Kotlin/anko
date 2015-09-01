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

package org.jetbrains.kotlin.android.robowrapper

import org.robolectric.internal.bytecode.InstrumentingClassLoader
import java.net.URLClassLoader

public class ClassLoaderManager {

    public fun replaceClassLoader(packageName: String) {
        // Context ClassLoader is set in RobolectricTestRunner
        val currentClassLoader = Thread.currentThread().contextClassLoader
        if (currentClassLoader !is InstrumentingClassLoader) {
            throw RuntimeException("Not an InstrumentingClassLoader")
        }

        val parentClassLoader = Thread.currentThread().contextClassLoader.parent
        val asmClazz = parentClassLoader.loadClass("org.robolectric.internal.bytecode.InstrumentingClassLoader")

        val configField = asmClazz.getDeclaredField("config")
        val urlsField = asmClazz.getDeclaredField("urls")
        val classesField = asmClazz.getDeclaredField("classes")

        configField.isAccessible = true
        urlsField.isAccessible = true
        classesField.isAccessible = true

        val setup = configField.get(currentClassLoader)
        val urlClassLoader = urlsField.get(currentClassLoader) as URLClassLoader
        @suppress("UNCHECKED_CAST")
        val oldClasses = classesField.get(currentClassLoader) as Map<String, Class<Any>>
        val urls = urlClassLoader.urLs

        // Create new ClassLoader instance
        val newClassLoader = asmClazz.constructors[0].newInstance(setup, urls) as InstrumentingClassLoader

        // Copy all Map entries from the old AsmInstrumentingClassLoader
        @suppress("UNCHECKED_CAST")
        val classes = classesField.get(newClassLoader) as MutableMap<String, Class<Any>>
        replicateCache(packageName, oldClasses, classes)

        // We're now able to get newClassLoader using Thread.currentThread().getContextClassLoader()
        Thread.currentThread().contextClassLoader = newClassLoader

        System.gc()
    }

    private fun replicateCache(
            removePackage: String,
            oldClasses: Map<String, Class<Any>>,
            newClasses: MutableMap<String, Class<Any>>
    ) {
        if (removePackage.isEmpty()) return

        val oldClassesList = oldClasses.toList()
        val checkPackageName = removePackage.isNotEmpty()
        for (clazz in oldClassesList) {
            val key = clazz.first
            if (checkPackageName && !key.startsWith(removePackage)) {
                newClasses.put(key, clazz.second)
            }
        }
    }

}
