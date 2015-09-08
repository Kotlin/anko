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

import org.jetbrains.android.anko.utils.fqName
import org.objectweb.asm.tree.ClassNode

interface SupportUtils {
    protected val ClassNode.supportSuffix: String
        get() = if (fromSupportPackage) "Support" else ""

    private val ClassNode.fromSupportPackage: Boolean
        get() = fqName.startsWith("android.support")
}