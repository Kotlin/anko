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

package org.jetbrains.android.anko.utils

internal interface ReflectionUtils {

    fun <T> initializeClass(clazz: Class<out T>): T {
        try {
            val constructor = clazz.getConstructor()
            return constructor.newInstance()
        } catch (e: NoSuchMethodException) {
            throw RuntimeException("Can't initialize class ${clazz.name}, no <init>()", e)
        }
    }

    fun <T> initializeClassWithArgs(clazz: Class<out T>, vararg args: Pair<Any, Class<*>>): T {
        val (argList, argTypes) = args.unzip()

        try {
            val constructor = clazz.getConstructor(*argTypes.toTypedArray())
            return constructor.newInstance(*argList.toTypedArray())
        } catch (e: NoSuchMethodException) {
            throw RuntimeException("Can't initialize class ${clazz.name}, no <init>(${argTypes.joinToString()})", e)
        }
    }


}