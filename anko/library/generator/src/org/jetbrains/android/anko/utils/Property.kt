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

internal class Property(val node: MethodNodeWithClass) {

    val name: String

    val setterName: String
        get() = "set" + name.capitalize()

    val setterIdentifier: String
        get() = node.clazz.fqName + "#" + setterName

    val propertyFqName: String
        get() = node.clazz.fqName + "." + name

    init {
        val methodName = node.method.name
        if (methodName.startsWith("get") || methodName.startsWith("set")) {
            name = methodName.substring(3).decapitalize()
        } else if (methodName.startsWith("is")) {
            name = methodName.substring(2).decapitalize()
        } else throw IllegalArgumentException("Method $methodName is not a property")
    }

}

internal fun MethodNodeWithClass.toProperty() = Property(this)