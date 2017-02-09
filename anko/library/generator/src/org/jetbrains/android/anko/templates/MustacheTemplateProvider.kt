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

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import org.jetbrains.android.anko.utils.ImportList
import java.io.File

class MustacheTemplateProvider : TemplateProvider {
    override val extension = "mustache"

    private val templateCache = hashMapOf<File, Template>()

    override fun render(templateFile: File, importList: ImportList, args: Map<String, Any?>): String {
        return getTemplate(templateFile).execute(args)
    }

    private fun getTemplate(templateFile: File) = templateCache.getOrPut(templateFile) {
        val templateText = templateFile.readText()
        Mustache.compiler().escapeHTML(false).emptyStringIsFalse(true).compile(templateText)
    }
}