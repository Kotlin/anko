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

package org.jetbrains.android.anko

import org.objectweb.asm.*
import java.nio.ByteBuffer
import java.io.File
import java.io.PrintWriter
import kotlin.platform.platformName
import java.util.*

val Type.isVoid: Boolean
    get() = getSort() == Type.VOID

val Type.isSimpleType: Boolean
    get() = when (getSort()) {
        Type.BOOLEAN, Type.INT, Type.FLOAT, Type.DOUBLE, Type.LONG, Type.BYTE, Type.CHAR, Type.SHORT -> true
        Type.VOID -> true
        else -> false
    }

val Type.fqName: String
    get() = getClassName().replace('/', '.').replace('$', '.')

private fun mapJavaToKotlinType(str: String): String {
    return when (str) {
        "java.lang.CharSequence" -> "CharSequence"
        "java.lang.String" -> "String"
        "java.lang.Integer" -> "Int"
        "java.lang.Object" -> "Any"
        else -> str
    }
}

fun Type.asString(nullable: Boolean = true): String {
    val nullability = if (nullable) "?" else ""
    return when (getSort()) {
        Type.BOOLEAN -> "Boolean"
        Type.INT -> "Int"
        Type.FLOAT -> "Float"
        Type.DOUBLE -> "Double"
        Type.LONG -> "Long"
        Type.BYTE -> "Byte"
        Type.CHAR -> "Char"
        Type.SHORT -> "Short"
        Type.VOID -> "Unit"
        Type.ARRAY -> when (getElementType().getSort()) {
            Type.INT -> "IntArray$nullability"
            Type.FLOAT -> "FloatArray$nullability"
            Type.DOUBLE -> "DoubleArray$nullability"
            Type.LONG -> "LongArray$nullability"
            else -> "Array<" + mapJavaToKotlinType(getElementType().asString(nullable = false)) + ">$nullability"
        }
        else -> mapJavaToKotlinType(fqName) + nullability
    }
}

fun Type.asJavaString(): String {
    return when (getSort()) {
        Type.BOOLEAN -> "boolean"
        Type.INT -> "int"
        Type.FLOAT -> "float"
        Type.DOUBLE -> "double"
        Type.LONG -> "long"
        Type.BYTE -> "byte"
        Type.CHAR -> "char"
        Type.SHORT -> "short"
        Type.VOID -> "void"
        Type.ARRAY -> getElementType().asJavaString() + "[]"
        else -> fqName
    }
}

fun Type.getDefaultValue() : String {
    return when (getSort()) {
        Type.BOOLEAN -> "false"
        Type.INT -> "0"
        Type.FLOAT -> "0.0"
        Type.DOUBLE -> "0.0"
        Type.LONG -> "0"
        Type.BYTE -> "0"
        Type.CHAR -> "\'\\u0000\'" //default value of a char
        Type.SHORT -> "0"
        Type.VOID -> ""
        Type.ARRAY -> when (getElementType().getSort()) {
            Type.INT -> "IntArray()"
            Type.FLOAT -> "FloatArray()"
            Type.DOUBLE -> "DoubleArray()"
            Type.LONG -> "LongArray()"
            else -> "Array<" + mapJavaToKotlinType(getElementType().asString(nullable = false)) + ">()"
        }
        else -> mapJavaToKotlinType(fqName) + "()"
    }
}

fun genericTypeToStr(param: GenericType, nullable: Boolean = true): String {
    var res = StringBuilder()

    val classifier = param.classifier

    res append when(classifier) {
        is TopLevelClass -> classifier.internalName.replace('/', '.').replace('$', '.')
        is BaseType -> Type.getType(classifier.descriptor.toString()).asString(nullable)
        else -> return ""
    }

    if (param.arguments.size() > 0) {
        res.append("<")
        for (arg in param.arguments) {
            res append when(arg) {
                is UnboundedWildcard -> "*"
                is NoWildcard -> genericTypeToStr(arg.genericType)
                is BoundedWildcard ->
                    return when(arg.wildcard) {
                        Wildcard.EXTENDS -> "out ${genericTypeToStr(arg.bound)}"
                        Wildcard.SUPER -> "in ${genericTypeToStr(arg.bound)}"
                    }
                else -> throw RuntimeException("Unexpected generic argument type: $arg")
            }
            res.append(", ")
        }
        res.delete(res.length() - 2, res.length())
        res.append(">")
    }
    if (classifier is TopLevelClass && nullable) res.append("?")
    return res.toString()
}

val Type.internalName: String
    get() = this.getInternalName()