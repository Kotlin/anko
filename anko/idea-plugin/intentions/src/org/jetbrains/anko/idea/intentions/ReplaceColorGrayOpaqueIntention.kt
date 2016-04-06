package org.jetbrains.anko.idea.intentions

import org.jetbrains.kotlin.psi.*

class ReplaceColorGrayOpaqueIntention : AnkoIntention<KtExpression>(
        KtExpression::class.java,
        "Simplify color numeric literal with Anko"
) {
    override fun isApplicable(element: KtExpression, caretOffset: Int): Boolean {
        return element.require<KtDotQualifiedExpression> {
            receiver.require<KtConstantExpression> { text.matches(COLOR_REGEX) } && selector.requireCall("toInt", 0)
        } || element.require<KtConstantExpression> {
            text.matches(COLOR_REGEX) && (this != (parent as? KtDotQualifiedExpression)?.receiver)
        }
    }

    override fun replaceWith(element: KtExpression, psiFactory: KtPsiFactory): NewElement? {
        fun createNewElement(colorText: String): NewElement? {
            val color = ARGB(colorText)

            if (color.isOpaque) {
                return if (color.isTransparent) {
                    NewElement(psiFactory.createExpression("Color.TRANSPARENT"), ANDROID_GRAPHICS_COLOR)
                } else if (color.color in COLORS) {
                    NewElement(psiFactory.createExpression("Color.${COLORS[color.color]}"), ANDROID_GRAPHICS_COLOR)
                } else if (color.isGray) {
                    NewElement(psiFactory.createExpression(color.getGrayOpaque()), GRAY, OPAQUE)
                } else {
                    return NewElement(psiFactory.createExpression(color.getOpaque()), OPAQUE)
                }
            }
            return null
        }

        element.require<KtDotQualifiedExpression> {
            receiver.require<KtConstantExpression> { text.matches(COLOR_REGEX) } && selector.requireCall("toInt", 0) {
                return createNewElement(receiver!!.text)
            }
        } || element.require<KtConstantExpression> {
            require(text.matches(COLOR_REGEX) && (this != (parent as? KtDotQualifiedExpression)?.receiver)) {
                return createNewElement(text)
            }
        }

        return null
    }

    private data class ARGB(val color: String, val a: String, val r: String, val g: String, val b: String) {
        @JvmField val A = a.toUpperCase()
        @JvmField val R = r.toUpperCase()
        @JvmField val G = g.toUpperCase()
        @JvmField val B = b.toUpperCase()

        constructor(color: String) : this(color.drop(2).toUpperCase(), color.substring(2, 4), color.substring(4, 6),
                                          color.substring(6, 8), color.substring(8, 10))

        val isGray: Boolean
            get() = R == G && G == B

        val isTransparent: Boolean
            get() = A == "00"

        val isOpaque: Boolean
            get() = A == "FF"

        fun getGrayOpaque() = "0x$r.gray.opaque"
        fun getOpaque() = "0x$r$g$b.opaque"
    }

    private companion object {
        val COLOR_REGEX = "^0x[0-9A-Fa-f]{8}$".toRegex()
        val GRAY = "gray"
        val OPAQUE = "opaque"
        val ANDROID_GRAPHICS_COLOR = "android.graphics.Color"

        val COLORS = mapOf(
                "FFFFFFFF" to "WHITE",
                "FF000000" to "BLACK",
                "FF888888" to "GRAY",
                "FFCCCCCC" to "LTGRAY",
                "FFFF0000" to "RED",
                "FF00FF00" to "GREEN",
                "FF0000FF" to "BLUE",
                "FFFFFF00" to "YELLOW",
                "FF00FFFF" to "CYAN",
                "FFFF00FF" to "MAGENTA")
    }
}