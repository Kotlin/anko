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

public interface TemplateProvider {
    fun render(templateName: String, args: Map<String, Any>): String
}

public class TemplateManager(private val templateProvider: TemplateProvider) {

    public fun render(templateName: String, body: TemplateContext.() -> Unit): String {
        val context = TemplateContext()
        context.body()
        return templateProvider.render(templateName, context.getArguments())
    }
}

public class TemplateContext {
    private val args: MutableMap<String, Any> = hashMapOf()

    public fun getArguments(): Map<String, Any> = args

    public fun <T> String.mod(v: T): T {
        args.put(this, v)
        return v
    }
}