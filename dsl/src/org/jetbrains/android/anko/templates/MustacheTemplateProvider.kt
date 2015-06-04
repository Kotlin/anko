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

package org.jetbrains.android.anko.templates

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import java.io.File

public class MustacheTemplateProvider(private val baseDir: File) : TemplateProvider {
    private val templateCache = hashMapOf<String, Template>()

    override fun render(templateName: String, args: Map<String, Any>): String {
        return getTemplate(templateName).execute(args)
    }

    private fun getTemplate(templateName: String) = templateCache.getOrPut(templateName) {
        val templateText = File(baseDir, "$templateName.mustache").readText()
        Mustache.compiler().escapeHTML(false).compile(templateText)
    }
}