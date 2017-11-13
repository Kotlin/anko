@file:JvmName("AppcompatV7PropertiesKt")
package org.jetbrains.anko.appcompat.v7

import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
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

var android.support.v7.widget.Toolbar.overflowIconResources: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setOverflowIcon(AppCompatResources.getDrawable(context, v))

var android.support.v7.widget.Toolbar.subtitleTextColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setSubtitleTextColor(v)

var android.support.v7.widget.Toolbar.subtitleTextColorResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setSubtitleTextColor(ContextCompat.getColor(context, v))

var android.support.v7.widget.Toolbar.titleTextColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTitleTextColor(v)

var android.support.v7.widget.Toolbar.titleTextColorResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTitleTextColor(ContextCompat.getColor(context, v))

