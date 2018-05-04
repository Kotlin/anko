@file:JvmName("DesignPropertiesKt")
package org.jetbrains.anko.design

import org.jetbrains.anko.*

import org.jetbrains.anko.internals.AnkoInternals
import kotlin.DeprecationLevel

var android.support.design.widget.TextInputLayout.passwordVisibilityToggleContentDescriptionResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setPasswordVisibilityToggleContentDescription(v)

var android.support.design.widget.TextInputLayout.passwordVisibilityToggleDrawableResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setPasswordVisibilityToggleDrawable(v)

