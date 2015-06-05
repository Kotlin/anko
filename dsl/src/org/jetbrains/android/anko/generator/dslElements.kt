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

import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.InnerClassNode
import org.objectweb.asm.tree.MethodNode

public data class ViewElement(val view: ClassNode, val isContainer: Boolean)

public data class LayoutElement(val layout: ClassNode, val layoutParams: ClassNode, val constructors: List<MethodNode>)

public data class ServiceElement(val service: ClassNode, val name: String)

public data class InterfaceWorkaroundElement(val baseClass: ClassNode, val ancestor: ClassNode, val inner: InnerClassNode)