@file:JvmName("Sdk15PropertiesKt")
package org.jetbrains.anko

import org.jetbrains.anko.*

import org.jetbrains.anko.internals.AnkoInternals
import kotlin.DeprecationLevel

var android.view.View.backgroundColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBackgroundColor(v)

var android.view.View.backgroundResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBackgroundResource(v)

var android.view.View.minimumHeight: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMinimumHeight(v)

var android.view.View.minimumWidth: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMinimumWidth(v)

var android.widget.TextView.textColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

var android.widget.TextView.highlightColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHighlightColor(v)

var android.widget.TextView.hintTextColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHintTextColor(v)

var android.widget.TextView.linkTextColor: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setLinkTextColor(v)

var android.widget.TextView.minLines: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMinLines(v)

var android.widget.TextView.maxLines: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMaxLines(v)

var android.widget.TextView.lines: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setLines(v)

var android.widget.TextView.minEms: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMinEms(v)

var android.widget.TextView.maxEms: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMaxEms(v)

var android.widget.TextView.singleLine: Boolean
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setSingleLine(v)

var android.widget.TextView.marqueeRepeatLimit: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMarqueeRepeatLimit(v)

var android.widget.TextView.cursorVisible: Boolean
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setCursorVisible(v)

var android.widget.ImageView.imageResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setImageResource(v)

var android.widget.ImageView.imageURI: android.net.Uri?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setImageURI(v)

var android.widget.ImageView.imageBitmap: android.graphics.Bitmap?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setImageBitmap(v)

var android.widget.RelativeLayout.gravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setGravity(v)

var android.widget.RelativeLayout.horizontalGravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHorizontalGravity(v)

var android.widget.RelativeLayout.verticalGravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setVerticalGravity(v)

var android.widget.LinearLayout.dividerDrawable: android.graphics.drawable.Drawable?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setDividerDrawable(v)

var android.widget.LinearLayout.gravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setGravity(v)

var android.widget.LinearLayout.horizontalGravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHorizontalGravity(v)

var android.widget.LinearLayout.verticalGravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setVerticalGravity(v)

var android.widget.Gallery.gravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setGravity(v)

var android.widget.Spinner.gravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setGravity(v)

var android.widget.GridView.gravity: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setGravity(v)

var android.widget.AbsListView.selectorResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setSelector(v)

var android.widget.TextView.hintResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHint(v)

var android.widget.TextView.textResource: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setText(v)

