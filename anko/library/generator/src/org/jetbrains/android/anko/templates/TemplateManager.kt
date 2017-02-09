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

package org.jetbrains.android.anko.templates

import org.jetbrains.android.anko.utils.ImportList
import java.io.File

interface TemplateProvider {
    val extension: String
    fun render(templateFile: File, importList: ImportList, args: Map<String, Any?>): String
}

class TemplateManager(val baseDir: File, vararg val templateProviders: TemplateProvider) {
    fun render(templateName: String, importList: ImportList, body: TemplateContext.() -> Unit): String {
        val context = TemplateContext()
        context.body()

        for (provider in templateProviders) {
            val templateFile = File(baseDir, "$templateName.${provider.extension}")
            if (templateFile.exists()) {
                return provider.render(templateFile, importList, context.getArguments())
            }
        }

        error("TemplateProvider was not found for $templateName")
    }
}

class TemplateContext {
    private val args: MutableMap<String, Any?> = hashMapOf()

    fun getArguments(): Map<String, Any?> = args

    operator fun <T: Any?> String.rem(v: T): T {
        args.put(this, v)
        return v
    }

    operator fun String.rem(v: TemplateContext.() -> Unit) {
        val innerContext = TemplateContext()
        innerContext.v()
        args.put(this, innerContext.getArguments())
    }

    fun <T> seq(items: Iterable<T>, v: TemplateContext.(item: T) -> Unit): List<Map<String, Any?>> {
        return items.map {
            val itemContext = TemplateContext()
            itemContext.v(it)
            itemContext.getArguments()
        }
    }
}