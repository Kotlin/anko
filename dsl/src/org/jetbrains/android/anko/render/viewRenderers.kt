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

import org.jetbrains.android.anko.*
import org.jetbrains.android.anko.config.AnkoConfiguration
import org.jetbrains.android.anko.config.AnkoFile
import org.jetbrains.android.anko.config.ConfigurationOption
import org.jetbrains.android.anko.config.ConfigurationTune
import org.jetbrains.android.anko.generator.ViewElement
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.util.*

public class ViewRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(elements: Iterable<ViewElement>) = generateViews(elements) { it.fqName }
}

public class ViewGroupRenderer(config: AnkoConfiguration) : AbstractViewRenderer(config) {
    override fun processElements(elements: Iterable<ViewElement>) = generateViews(elements) { "_" + it.simpleName + it.supportSuffix }
}

private abstract class AbstractViewRenderer(
        config: AnkoConfiguration
) : Renderer<ViewElement>(config), ViewConstructorUtils, SupportUtils {

    override val renderIf: Array<ConfigurationOption> = arrayOf(AnkoFile.VIEWS)

    protected fun generateViews(views: Iterable<ViewElement>, nameResolver: (ClassNode) -> String): String {
        val stringBuilder = StringBuilder()

        for ((view, isContainer) in views.filter { !it.view.isAbstract }) {
            val constructors = ViewConstructorUtils.AVAILABLE_VIEW_CONSTRUCTORS.map { constructor ->
                view.getConstructors().firstOrNull() { Arrays.equals(it.args, constructor) }
            }

            fun renderView(receiver: String) = render("view") {
                "receiver" % receiver
                "functionName" % (view.simpleName.decapitalize() + view.supportSuffix)
                "className" % nameResolver(view)
                "returnType" % view.fqName
                "additionalArgs" % ""
                "constructorArgs" % renderConstructorArgs(view, constructors, "ctx")
            }

            stringBuilder.append(renderView("ViewManager"))
            if (config[ConfigurationTune.TOP_LEVEL_DSL_ITEMS] && isContainer) {
                stringBuilder.append(renderView("Context"))
                stringBuilder.append(renderView("Activity"))
            }
        }

        return stringBuilder.toString()
    }

}