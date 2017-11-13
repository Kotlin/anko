package org.jetbrains.kotlin.android.dslpreview

import org.jetbrains.android.uipreview.ViewLoaderExtension
import org.jetbrains.org.objectweb.asm.ClassWriter
import org.jetbrains.org.objectweb.asm.Opcodes
import java.net.URL
import java.net.URLClassLoader

class AnkoViewLoaderExtension : ViewLoaderExtension {
    internal var description: PreviewClassDescription? = null

    override fun loadClass(className: String, delegateClassLoader: ClassLoader): Class<*>? {
        val description = this.description
        if (className == "__anko.preview.View" && description != null) {
            val clazz = generateStubViewClass(delegateClassLoader, description)
            if (clazz != null) return clazz
        }

        return null
    }

    private fun generateStubViewClass(delegateClassLoader: ClassLoader, description: PreviewClassDescription): Class<*>? {
        val uiInternalName = description.internalName
        val viewFqName = "__anko.preview.View"
        val viewInternalName = viewFqName.replace('.', '/')
        val superClassInternalName = "android/widget/FrameLayout"

        val bytes = with (ClassWriter(0)) {
            visit(49, Opcodes.ACC_PUBLIC, viewInternalName, null, superClassInternalName, null)
            visitSource(null, null)

            fun visitConstructor(vararg params: String) {
                val signature = "(${params.joinToString("")})V"

                with (visitMethod(Opcodes.ACC_PUBLIC, "<init>", signature, null, null)) {
                    visitVarInsn(Opcodes.ALOAD, 0)
                    params.forEachIndexed { i, param ->
                        when (param) {
                            "I" -> visitVarInsn(Opcodes.ILOAD, i + 1)
                            else -> visitVarInsn(Opcodes.ALOAD, i + 1)
                        }
                    }

                    visitMethodInsn(Opcodes.INVOKESPECIAL, superClassInternalName, "<init>", signature)
                    visitVarInsn(Opcodes.ALOAD, 0)
                    visitMethodInsn(Opcodes.INVOKEVIRTUAL, viewInternalName, "init", "()V")
                    visitInsn(Opcodes.RETURN)
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

            with (visitMethod(Opcodes.ACC_PRIVATE, "init", "()V", null, null)) {
                visitVarInsn(Opcodes.ALOAD, 0)
                visitTypeInsn(Opcodes.NEW, uiInternalName)
                visitInsn(Opcodes.DUP)
                visitMethodInsn(Opcodes.INVOKESPECIAL, uiInternalName, "<init>", "()V")
                visitFieldInsn(Opcodes.GETSTATIC, "org/jetbrains/anko/AnkoContext", "Companion",
                        "Lorg/jetbrains/anko/AnkoContext" + '$' + "Companion;")
                visitVarInsn(Opcodes.ALOAD, 0)
                visitMethodInsn(Opcodes.INVOKEVIRTUAL, viewInternalName, "getContext", "()Landroid/content/Context;")

                visitInsn(Opcodes.ICONST_0)
                visitMethodInsn(Opcodes.INVOKEVIRTUAL, "org/jetbrains/anko/AnkoContext" + '$' + "Companion", "create",
                        "(Landroid/content/Context;Z)Lorg/jetbrains/anko/AnkoContext;")

                visitMethodInsn(Opcodes.INVOKEVIRTUAL, uiInternalName, "createView",
                        "(Lorg/jetbrains/anko/AnkoContext;)Landroid/view/View;")
                visitMethodInsn(Opcodes.INVOKEVIRTUAL, viewInternalName, "addView", "(Landroid/view/View;)V")

                visitInsn(Opcodes.RETURN)
                visitMaxs(5 /*max stack*/, 1 /*max locals*/)
                visitEnd()
            }

            visitEnd()
            toByteArray()
        }

        return loadClass(viewFqName, bytes, delegateClassLoader)
    }

    private fun loadClass(fqName: String, bytes: ByteArray, delegateClassLoader: ClassLoader): Class<*>? {
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
            val classLoader = ByteClassLoader(emptyArray(), delegateClassLoader, hashMapOf(fqName to bytes))
            return Class.forName(fqName, false, classLoader)
        } catch (e: Throwable) {
            return null
        }
    }
}