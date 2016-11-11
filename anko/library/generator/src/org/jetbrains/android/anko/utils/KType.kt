package org.jetbrains.android.anko.utils

data class KType(
        val fqName: String,
        val isNullable: Boolean = false,
        val variance: Variance = KType.Variance.INVARIANT,
        val arguments: List<KType> = emptyList()
) {
    init {
        assert(!fqName.endsWith("?"))
    }

    companion object {
        val STAR_TYPE = KType("*", isNullable = false)
        val ANY_TYPE = KType("Any")
    }

    enum class Variance {
        INVARIANT, COVARIANT, CONTRAVARIANT
    }

    override fun toString(): String = buildString {
        val variance = when (variance) {
            KType.Variance.INVARIANT -> ""
            KType.Variance.COVARIANT -> "out "
            KType.Variance.CONTRAVARIANT -> "in "
        }
        if (variance.isNotEmpty()) {
            append(variance)
        }

        append(fqName)

        if (arguments.isNotEmpty()) {
            append('<')
            arguments.forEach { append(it.toString()) }
            append('>')
        }

        if (isNullable) {
            append('?')
        }
    }

    val className: String
        get() = fqName.split('.').dropWhile { it.all(Char::isPackageSymbol) }.joinToString(".")

    val packageName: String
        get() = fqName.split('.').takeWhile { it.all(Char::isPackageSymbol) }.joinToString(".")
}