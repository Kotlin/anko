@file:JvmName("AppcompatV7PropertiesKt")
package org.jetbrains.anko.appcompat.v7

import org.jetbrains.anko.*

import org.jetbrains.anko.internals.AnkoInternals
import kotlin.DeprecationLevel

var android.support.v7.widget.Toolbar.logoResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setLogo(v)

var android.support.v7.widget.Toolbar.logoDescriptionResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setLogoDescription(v)

var android.support.v7.widget.Toolbar.navigationContentDescriptionResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setNavigationContentDescription(v)

var android.support.v7.widget.Toolbar.navigationIconResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setNavigationIcon(v)

var android.support.v7.widget.Toolbar.subtitleResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setSubtitle(v)

var android.support.v7.widget.Toolbar.titleResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTitle(v)

