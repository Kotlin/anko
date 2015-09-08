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

package org.jetbrains.android.anko.utils

import org.objectweb.asm.Type

val Type.isVoid: Boolean
    get() = sort == Type.VOID

val Type.isSimpleType: Boolean
    get() = when (sort) {
        Type.BOOLEAN, Type.INT, Type.FLOAT, Type.DOUBLE, Type.LONG, Type.BYTE, Type.CHAR, Type.SHORT -> true
        Type.VOID -> true
        else -> false
    }

val Type.fqName: String
    get() = className.replace('/', '.').replace('$', '.')

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
    return when (sort) {
        Type.BOOLEAN -> "Boolean"
        Type.INT -> "Int"
        Type.FLOAT -> "Float"
        Type.DOUBLE -> "Double"
        Type.LONG -> "Long"
        Type.BYTE -> "Byte"
        Type.CHAR -> "Char"
        Type.SHORT -> "Short"
        Type.VOID -> "Unit"
        Type.ARRAY -> when (elementType.sort) {
            Type.INT -> "IntArray$nullability"
            Type.FLOAT -> "FloatArray$nullability"
            Type.DOUBLE -> "DoubleArray$nullability"
            Type.LONG -> "LongArray$nullability"
            else -> "Array<" + mapJavaToKotlinType(elementType.asString(nullable = false)) + ">$nullability"
        }
        else -> mapJavaToKotlinType(fqName) + nullability
    }
}

fun Type.asJavaString(): String {
    return when (sort) {
        Type.BOOLEAN -> "boolean"
        Type.INT -> "int"
        Type.FLOAT -> "float"
        Type.DOUBLE -> "double"
        Type.LONG -> "long"
        Type.BYTE -> "byte"
        Type.CHAR -> "char"
        Type.SHORT -> "short"
        Type.VOID -> "void"
        Type.ARRAY -> elementType.asJavaString() + "[]"
        else -> fqName
    }
}

fun Type.getDefaultValue() : String {
    return when (sort) {
        Type.BOOLEAN -> "false"
        Type.INT -> "0"
        Type.FLOAT -> "0.0"
        Type.DOUBLE -> "0.0"
        Type.LONG -> "0"
        Type.BYTE -> "0"
        Type.CHAR -> "\'\\u0000\'" //default value of a char
        Type.SHORT -> "0"
        Type.VOID -> ""
        Type.ARRAY -> when (elementType.sort) {
            Type.INT -> "IntArray()"
            Type.FLOAT -> "FloatArray()"
            Type.DOUBLE -> "DoubleArray()"
            Type.LONG -> "LongArray()"
            else -> "Array<" + mapJavaToKotlinType(elementType.asString(nullable = false)) + ">()"
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

fun getPackageName(fqName: String): String {
    val indexOfFirstCapital = fqName.indexOfFirst { it.isUpperCase() }
    return fqName.substring(0, indexOfFirstCapital).substringBeforeLast('.')
}

fun getJavaClassName(fqName: String): String {
    return fqName.substring(getPackageName(fqName).length() + 1)
}