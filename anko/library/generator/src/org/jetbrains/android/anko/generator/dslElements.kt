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

import org.jetbrains.android.anko.utils.MethodNodeWithClass
import org.jetbrains.android.anko.utils.fqName
import org.jetbrains.android.anko.utils.simpleName
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

class ViewElement(val clazz: ClassNode, val isContainer: Boolean, allMethods: () -> List<MethodNode>) {
    val allMethods: List<MethodNode> by lazy {
        allMethods()
    }

    val fqName: String
        get() = clazz.fqName
}

class LayoutElement(val layout: ClassNode, val layoutParams: ClassNode, val constructors: List<MethodNode>)

class ServiceElement(val service: ClassNode, val constantName: String) {
    val simpleName: String
        get() = service.simpleName.decapitalize()

    val fqName: String
        get() = service.fqName
}

class PropertyElement(val name: String, val getter: MethodNodeWithClass?, val setters: List<MethodNodeWithClass>)

class ListenerMethod(val methodWithClass: MethodNodeWithClass, val name: String, val returnType: Type)

abstract class ListenerElement(val setter: MethodNodeWithClass, val clazz: ClassNode) {
    abstract val id: String
}

class SimpleListenerElement(
        setter: MethodNodeWithClass,
        clazz: ClassNode,
        val method: ListenerMethod
) : ListenerElement(setter, clazz) {
    override val id: String
        get() = "${clazz.name}#${method.name}"
}

class ComplexListenerElement(
        setter: MethodNodeWithClass,
        clazz: ClassNode,
        val name: String,
        val methods: List<ListenerMethod>
) : ListenerElement(setter, clazz) {
    override val id: String
        get() = "${clazz.name}#$name"
}