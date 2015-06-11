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

import org.jetbrains.android.anko.*

class ListenerGenerator : Generator<ListenerElement> {

    override fun generate(state: GenerationState) = with (state) {
        return state.availableMethods
                .filter { it.clazz.isView && it.method.isPublic && it.method.isListenerSetter }
                .map { makeListener(it) }
                .sortBy { it.setter.identifier }
    }

    //suppose "setter" is a correct setOn*Listener method
    private fun GenerationState.makeListener(setter: MethodNodeWithClass): ListenerElement {
        val listener = classTree.findNode(setter.method.args[0].internalName)!!.data

        val methods = listener.methods?.filter { !it.isConstructor }

        val rawName = setter.method.name
        //delete "set" ("add") end "Listener" parts of String
        val name = rawName.substring("set".length()).dropLast("Listener".length()).decapitalize()

        return when (methods?.size() ?: 0) {
            1 -> { // It is a simple listener, with just one method
                val method = methods!![0]
                val methodWithClass = MethodNodeWithClass(listener, method)
                val returnType = method.returnType.asString()
                SimpleListenerElement(setter, listener, ListenerMethod(methodWithClass, name, returnType))
            }
            0 -> // Something weird
                throw RuntimeException("Listener ${listener.name} contains no methods.")
            else -> { // A complex listener (with more than one method)
                val listenerMethods = methods?.map { method ->
                    val methodName = method.name
                    val methodWithClass = MethodNodeWithClass(listener, method)
                    val returnType = method.returnType.asString()
                    ListenerMethod(methodWithClass, methodName, returnType)
                }!!
                ComplexListenerElement(setter, listener, name, listenerMethods)
            }
        }
    }

    private fun String.dropLast(n: Int) = if (n >= length()) "" else substring(0, length() - n)
}