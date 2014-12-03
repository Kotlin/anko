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

import org.objectweb.asm.*
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.util.LinkedHashMap
import java.util.ArrayList
import java.io.File
import java.io.PrintWriter
import kotlin.platform.platformName

fun Type.isVoid(): Boolean = getSort() == Type.VOID

fun typeMap(str: String): String {
    return when (str) {
        "java.lang.CharSequence" -> "CharSequence"
        "java.lang.String" -> "String"
        "java.lang.Integer" -> "Int"
        "java.lang.Object" -> "Any"
        else -> str
    }
}

fun Type.toStr(nullable: Boolean = true): String {
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
        Type.ARRAY -> {
            val innerType = getElementType()
            if (innerType != null) {
                when (getElementType()?.getSort()) {
                    Type.INT -> "IntArray?"
                    Type.FLOAT -> "FloatArray?"
                    Type.DOUBLE -> "DoubleArray?"
                    Type.LONG -> "LongArray?"
                    else -> {
                        "Array<" + typeMap(innerType.toStr(nullable = false)) + ">?"
                    }
                }
            } else {
                throw RuntimeException("Type is of ArrayType, but element type is null")
            }
        }
        else -> {
            try {
                typeMap(cleanInternalName(getInternalName())) + if (nullable) "?" else ""
            } catch (e: NullPointerException) {
                "INVALID"
            }
        }
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
        Type.ARRAY -> {
            val innerType = getElementType()
            if (innerType != null) {
                when (getElementType()?.getSort()) {
                    Type.INT -> "IntArray()"
                    Type.FLOAT -> "FloatArray()"
                    Type.DOUBLE -> "DoubleArray()"
                    Type.LONG -> "LongArray()"
                    else -> {
                        "Array<" + typeMap(innerType.toStr(nullable = false)) + ">()"
                    }
                }
            } else {
                throw RuntimeException("Type is of ArrayType, but element type is null")
            }
        }
        else -> {
            try {
                typeMap(cleanInternalName(getInternalName())) + "()"
            } catch (e: NullPointerException) {
                "INVALID"
            }
        }
    }
}
fun updateIfNotNull<T>(old: T, new: T): T {
    return old ?: new
}

fun writeFile(fileName: String, text: String) {
    val writer = PrintWriter(File(fileName))
    writer.write(text)
    writer.close()
}

public fun <K, V, M: MutableMap<K, V>> Iterator<Pair<K, V>>.toMutableMap(map: M): M {
    for ((k, v) in this) {
        map.put(k, v)
    }
    return map
}

public fun <K, V> Iterator<Pair<K, V>>.toMutableMap(): MutableMap<K, V> = toMutableMap(LinkedHashMap<K, V>())

public fun <K, V> Iterator<Pair<K, V>>.toMap(): Map<K, V> = toMutableMap()

public fun <K, V> Iterable<Pair<K, V>>.toMap(): Map<K, V> = iterator().toMap()

public fun <K, V> Iterable<Pair<K, V>>.toMutableMap(): Map<K, V> = iterator().toMutableMap()

public fun <T, K, V, M: MutableMap<K, V>> Iterable<T>.toMutableMap(map: M, mapper: (T) -> Pair<K, V>): M =
        iterator().map(mapper).toMutableMap(map)
public fun <T, K, V> Iterable<T>.toMap(mapper: (T) -> Pair<K, V>): Map<K, V> = iterator().map(mapper).toMap()

//join two lists
fun <T> List<T>.join(another: List<T>): List<T> {
    val list = ArrayList(this)
    list.addAll(another)
    return list
}

fun <T> Configurable.generate(vararg file: KoanFile, init: () -> Collection<T>) : Collection<T> {
    return if (file.any { config[it] }) init() else listOf()
}

fun <T> Configurable.generate(vararg tune: ConfigurationTune, init: () -> Collection<T>) : Collection<T> {
    return if (tune.any { config[it] }) init() else listOf()
}

public fun readFile(filename: String): String = File(filename).readText()

//drop last n characters
private fun String.dropLast(n: Int) = if (n >= length) "" else substring(0, length-n)