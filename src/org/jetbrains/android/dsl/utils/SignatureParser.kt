/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl

import org.objectweb.asm.signature.SignatureVisitor
import java.util.ArrayList
import org.objectweb.asm.Opcodes
import org.objectweb.asm.signature.SignatureReader

trait Classifier
data class BaseType(val descriptor: Char) : Classifier
trait NamedClass : Classifier
data class ToplevelClass(val internalName: String) : NamedClass
data class InnerClass(val outer: GenericType, val name: String) : NamedClass
data class TypeVariable(val name: String) : Classifier
object ArrayC : Classifier

enum class Wildcard {
    SUPER   // ? super X
    EXTENDS // ? extends X
}

trait TypeArgument
data class BoundedWildcard(val wildcard: Wildcard, val bound: GenericType) : TypeArgument
object UnBoundedWildcard : TypeArgument
data class NoWildcard(val genericType: GenericType) : TypeArgument

trait GenericType {
    val classifier: Classifier
    val arguments: List<TypeArgument>
}

data class ImmutableGenericType(
        override val classifier: Classifier,
        override val arguments: List<TypeArgument>
) : GenericType

val GenericType.arrayElementType: GenericType
    get() {
        assert(arguments.size == 1)
        assert(classifier == ArrayC)
        return (arguments[0] as NoWildcard).genericType
    }

class GenericTypeImpl : GenericType {
    var classifierVar: Classifier? = null
    override val arguments: MutableList<TypeArgument> = ArrayList()
    override val classifier: Classifier
        get() = classifierVar!!

    override fun toString(): String = "$classifier<${arguments.joinToString(separator = ", ")}>"
}

class TypeParameter(val name: String, val upperBounds: List<GenericType>)
class ValueParameter(val index: Int, val genericType: GenericType)

class GenericMethodSignature(
    val typeParameters: List<TypeParameter>,
    val returnType: GenericType,
    val valueParameters: List<ValueParameter>
)

fun TypeParameter.hasNontrivialBounds(): Boolean {
    assert(upperBounds.size > 0)
    if (upperBounds.size > 1) return true
    val bound = upperBounds[0].classifier
    return !(bound is ToplevelClass && bound.internalName == "java/lang/Object")
}

fun parseGenericMethodSignature(signature: String): GenericMethodSignature {
    val typeParameters = ArrayList<TypeParameter>()
    val returnType = GenericTypeImpl()
    val valueParameters = ArrayList<ValueParameter>()

    SignatureReader(signature).accept(
        object : SignatureVisitor(Opcodes.ASM4) {
            var bounds = ArrayList<GenericType>()

            public override fun visitFormalTypeParameter(name: String?) {
                bounds = ArrayList<GenericType>()
                var param = TypeParameter(name!!, bounds)
                typeParameters.add(param)
            }

            public override fun visitClassBound(): SignatureVisitor {
                val bound = GenericTypeImpl()
                bounds.add(bound)
                return GenericTypeParser(bound)
            }

            public override fun visitInterfaceBound(): SignatureVisitor {
                val bound = GenericTypeImpl()
                bounds.add(bound)
                return GenericTypeParser(bound)
            }

            public override fun visitParameterType(): SignatureVisitor {
                val parameterType = GenericTypeImpl()
                val param = ValueParameter(valueParameters.size(), parameterType)
                valueParameters.add(param)
                return GenericTypeParser(parameterType)
            }

            public override fun visitReturnType(): SignatureVisitor {
                return GenericTypeParser(returnType)
            }
        }
    )
    return GenericMethodSignature(typeParameters, returnType, valueParameters)
}

private class GenericTypeParser(val result: GenericTypeImpl) : SignatureVisitor(Opcodes.ASM4) {

    override fun visitBaseType(descriptor: Char) {
        result.classifierVar = BaseType(descriptor)
    }

    override fun visitTypeVariable(name: String?) {
        result.classifierVar = TypeVariable(name!!)
    }

    override fun visitArrayType(): SignatureVisitor {
        result.classifierVar = ArrayC
        val argument = GenericTypeImpl()
        result.arguments.add(NoWildcard(argument))
        return GenericTypeParser(argument)
    }

    override fun visitClassType(name: String?) {
        result.classifierVar = ToplevelClass(name!!)
    }

    override fun visitInnerClassType(name: String?) {
        val outer = GenericTypeImpl()
        outer.classifierVar = result.classifier
        outer.arguments.addAll(result.arguments)
        result.classifierVar = InnerClass(outer, name!!)
        result.arguments.clear()
    }

    override fun visitTypeArgument() {
        result.arguments.add(UnBoundedWildcard)
    }

    override fun visitTypeArgument(wildcard: Char): SignatureVisitor {
        val argument = GenericTypeImpl()
        result.arguments.add(when (wildcard) {
            SignatureVisitor.EXTENDS -> BoundedWildcard(Wildcard.EXTENDS, argument)
            SignatureVisitor.SUPER -> BoundedWildcard(Wildcard.SUPER, argument)
            SignatureVisitor.INSTANCEOF -> NoWildcard(argument)
            else -> throw IllegalArgumentException("Unkonown wildcard: $wildcard")
        })
        return GenericTypeParser(argument)
    }
}

