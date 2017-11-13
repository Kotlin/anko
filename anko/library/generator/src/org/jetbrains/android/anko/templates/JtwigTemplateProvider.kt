package org.jetbrains.android.anko.templates

import org.jetbrains.android.anko.utils.ImportList
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.jtwig.environment.EnvironmentConfigurationBuilder
import org.jtwig.functions.FunctionRequest
import org.jtwig.functions.SimpleJtwigFunction
import org.jtwig.spaceless.SpacelessExtension
import org.jtwig.spaceless.configuration.DefaultSpacelessConfiguration
import java.io.File
import java.math.BigDecimal

class JtwigTemplateProvider : TemplateProvider {
    override val extension = "twig"

    override fun render(templateFile: File, importList: ImportList, args: Map<String, Any?>): String {
        val model = JtwigModel.newModel(args)
        return getTemplate(templateFile, importList).render(model)
    }

    private fun getTemplate(templateFile: File, importList: ImportList): JtwigTemplate {
        val configuration = EnvironmentConfigurationBuilder.configuration()
        configuration.extensions().add(SpacelessExtension(DefaultSpacelessConfiguration()))
        configuration.functions().add(object : SimpleJtwigFunction() {
            override fun name() = "range"

            override fun execute(request: FunctionRequest): Any {
                request.minimumNumberOfArguments(2).maximumNumberOfArguments(2)

                val min = parseInt(request.arguments[0])
                val max = parseInt(request.arguments[1])

                return min..max
            }

            private fun parseInt(o: Any) = when (o) {
                is BigDecimal -> o.toInt()
                is Int -> o
                else -> throw IllegalArgumentException(
                        "Illegal argument type: ${o.javaClass.canonicalName}, expected Integer or BigDecimal")
            }
        })

        configuration.functions().add(object : SimpleJtwigFunction() {
            override fun name() = "imported"

            override fun execute(request: FunctionRequest): Any {
                request.minimumNumberOfArguments(1).maximumNumberOfArguments(1)
                return importList[request.arguments[0].toString()]
            }
        })

        return JtwigTemplate.fileTemplate(templateFile, configuration.build())
    }
}