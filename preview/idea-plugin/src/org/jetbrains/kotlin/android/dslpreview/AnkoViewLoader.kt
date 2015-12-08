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

package org.jetbrains.kotlin.android.dslpreview

import org.jetbrains.android.facet.AndroidFacet
import org.jetbrains.android.uipreview.ViewLoader
import org.objectweb.asm.ClassWriter
import org.jetbrains.org.objectweb.asm.*
import org.jetbrains.org.objectweb.asm.Opcodes.*
import java.net.URL
import java.net.URLClassLoader

class AnkoViewLoader : ViewLoader {
    private val description: PreviewClassDescription
    private val delegate: ViewLoader

    constructor(facet: AndroidFacet, delegate: ViewLoader, description: PreviewClassDescription) : super(
            delegate.prop("myLayoutLibrary"),
            facet,
            delegate.prop("myLogger"),
            delegate.prop("myCredential")) {
        this.description = description
        this.delegate = delegate
    }

    override fun loadView(className: String?, constructorSignature: Array<out Class<Any>>?, constructorArgs: Array<out Any>?): Any? {
        if (className == "__anko.preview.View") {
            try {
                val clazz = generateStubViewClass()
                val createNewInstanceMethod = ViewLoader::class.java.declaredMethods.first { it.name == "createNewInstance" }
                createNewInstanceMethod.isAccessible = true
                return createNewInstanceMethod(this, clazz, constructorSignature, constructorArgs, true)
            } catch (ignored: Exception) { }
        }
        return super.loadView(className, constructorSignature, constructorArgs)
    }

    override fun loadClass(className: String): Class<*>? {
        if (className == "__anko.preview.View") {
            val clazz = generateStubViewClass()
            if (clazz != null) return clazz
        }
        return super.loadClass(className)
    }

    private fun generateStubViewClass(): Class<*>? {
        val uiInternalName = description.internalName
        val viewFqName = "__anko.preview.View"
        val viewInternalName = viewFqName.replace('.', '/')
        val superClassInternalName = "android/widget/FrameLayout"

        val bytes = with (ClassWriter(0)) {
            visit(49, ACC_PUBLIC, viewInternalName, null, superClassInternalName, null)
            visitSource(null, null)

            fun visitConstructor(vararg params: String) {
                val signature = "(${params.joinToString("")})V"

                with (visitMethod(ACC_PUBLIC, "<init>", signature, null, null)) {
                    visitVarInsn(ALOAD, 0)
                    params.forEachIndexed { i, param ->
                        when (param) {
                            "I" -> visitVarInsn(ILOAD, i + 1)
                            else -> visitVarInsn(ALOAD, i + 1)
                        }
                    }

                    visitMethodInsn(INVOKESPECIAL, superClassInternalName, "<init>", signature)
                    visitVarInsn(ALOAD, 0)
                    visitMethodInsn(INVOKEVIRTUAL, viewInternalName, "init", "()V")
                    visitInsn(RETURN)
                    visitMaxs(1 + params.size /*max stack*/, 1 + params.size /*max locals*/)
                    visitEnd()
                }
            }

            visitConstructor("Landroid/content/Context;")
            visitConstructor("Landroid/content/Context;", "Landroid/util/AttributeSet;")
            visitConstructor("Landroid/content/Context;", "Landroid/util/AttributeSet;", "I")

            /*
            private fun init() {
                addView(MainActivityUi().createView(AnkoContext.create(getContext())))
            }
             */

            with (visitMethod(ACC_PRIVATE, "init", "()V", null, null)) {
                visitVarInsn(ALOAD, 0)
                visitTypeInsn(NEW, uiInternalName)
                visitInsn(Opcodes.DUP)
                visitMethodInsn(INVOKESPECIAL, uiInternalName, "<init>", "()V")
                visitFieldInsn(GETSTATIC, "org/jetbrains/anko/AnkoContext", "Companion",
                        "Lorg/jetbrains/anko/AnkoContext" + '$' + "Companion;")
                visitVarInsn(ALOAD, 0)
                visitMethodInsn(INVOKEVIRTUAL, viewInternalName, "getContext", "()Landroid/content/Context;")
                visitMethodInsn(INVOKEVIRTUAL, "org/jetbrains/anko/AnkoContext" + '$' + "Companion", "create",
                        "(Landroid/content/Context;)Lorg/jetbrains/anko/AnkoContext;")
                visitMethodInsn(INVOKEVIRTUAL, uiInternalName, "createView",
                        "(Lorg/jetbrains/anko/AnkoContext;)Landroid/view/View;")
                visitMethodInsn(INVOKEVIRTUAL, viewInternalName, "addView", "(Landroid/view/View;)V")

                visitInsn(RETURN)
                visitMaxs(4 /*max stack*/, 1 /*max locals*/)
                visitEnd()
            }

            visitEnd()
            toByteArray()
        }

        return loadClass(viewFqName, bytes)
    }

    private fun getDelegateClassLoader(): ClassLoader {
        val method = ViewLoader::class.java.getDeclaredMethod("getModuleClassLoader")
        method.isAccessible = true
        return method(delegate) as ClassLoader
    }

    private fun loadClass(fqName: String, bytes: ByteArray): Class<*>? {
        class ByteClassLoader(
                urls: Array<out URL>?,
                parent: ClassLoader?,
                private var extraClasses: MutableMap<String, ByteArray>
        ) : URLClassLoader(urls, parent) {
            override fun findClass(name: String): Class<*>? {
                return extraClasses.remove(name)?.let {
                    defineClass(name, it, 0, it.size)
                } ?: super.findClass(name)
            }
        }

        try {
            val classLoader = ByteClassLoader(emptyArray(), getDelegateClassLoader(), hashMapOf(fqName to bytes))
            return Class.forName(fqName, false, classLoader)
        } catch (e: Throwable) {
            return null
        }
    }

    private companion object {
        fun <T> ViewLoader.prop(name: String): T {
            val field = ViewLoader::class.java.getDeclaredField(name)
            field.isAccessible = true
            @Suppress("UNCHECKED_CAST")
            return field.get(this) as T
        }
    }
}