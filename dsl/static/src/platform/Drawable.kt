package org.jetbrains.anko

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.*
import android.graphics.drawable.shapes.ArcShape
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RoundRectShape
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.internals.AnkoInternals
import java.io.InputStream
import java.util.*

/**
 * Created by benny on 12/10/15.
 */

interface DrawableProvider<T: Drawable> {
    val drawable: T
    var drawableState: IntArray
    var drawableLevel: Int
}

interface RawDrawableProvider<T: Drawable> : DrawableProvider<T> {
    override val drawable: T
        get() = this as T
    override var drawableState: IntArray
        set(value) {
            (this as T).setState(value)
        }
        get() = (this as T).state

    override var drawableLevel: Int
        set(value) {
            (this as T).setLevel(value)
        }
        get() = (this as T).level
}

interface DrawableManager {
    val ctx: Context
    fun addDrawable(drawable: Drawable, params: Any?)
}

fun AnkoInternals.getContext(manager: DrawableManager): Context = manager.ctx

fun AnkoInternals.addDrawable(manager: DrawableManager, drawable: Drawable) {
    when(manager) {
        is _StateListManager -> manager.apply { addDrawable(drawable, drawable.state) }
        is _LevelListManager -> manager.apply { addDrawable(drawable, drawable.level) }
        else -> manager.addDrawable(drawable, null)
    }
}
fun AnkoInternals.addDrawable(manager: AnkoContext<*>, drawable: Drawable) {}
fun AnkoInternals.addDrawable(manager: Context, drawable: Drawable) {}

inline fun <R: Drawable, T : DrawableProvider<R>> DrawableManager.ankoDrawable(factory: (ctx: Context) -> T, init: T.() -> Unit): R {
    val ctx = AnkoInternals.getContext(this)
    val manager = factory(ctx)
    manager.init()
    val drawable = manager.drawable
    AnkoInternals.addDrawable(this, drawable)
    return drawable
}

inline fun <R: Drawable, T : DrawableProvider<R>> AnkoContext<*>.ankoDrawable(factory: (ctx: Context) -> T, init: T.() -> Unit): R {
    val manager = factory(this.ctx)
    manager.init()
    val drawable = manager.drawable
    AnkoInternals.addDrawable(this, drawable)
    return drawable
}

inline fun <R: Drawable, T : DrawableProvider<R>> Context.ankoDrawable(factory: (ctx: Context) -> T, init: T.() -> Unit): R {
    val manager = factory(this)
    manager.init()
    val drawable = manager.drawable
    AnkoInternals.addDrawable(this, drawable)
    return drawable
}

inline fun DrawableManager.layer(init: _LayerManager.() -> Unit): Drawable {
    return ankoDrawable({_LayerManager(ctx)}, init)
}
inline fun AnkoContext<*>.layer(init: _LayerManager.() -> Unit): Drawable {
    return ankoDrawable({_LayerManager(ctx)}, init)
}
inline fun Context.layer(init: _LayerManager.() -> Unit): Drawable {
    return ankoDrawable({_LayerManager(this)}, init)
}



inline fun DrawableManager.stateList(init: _StateListManager.() -> Unit): Drawable {
    return ankoDrawable({_StateListManager(ctx)}, init)
}
inline fun AnkoContext<*>.stateList(init: _StateListManager.() -> Unit): Drawable {
    return ankoDrawable({_StateListManager(ctx)}, init)
}
inline fun Context.stateList(init: _StateListManager.() -> Unit): Drawable {
    return ankoDrawable({_StateListManager(this)}, init)
}



inline fun DrawableManager.levelList(init: _LevelListManager.() -> Unit): Drawable {
    return ankoDrawable({_LevelListManager(ctx)}, init)
}
inline fun AnkoContext<*>.levelList(init: _LevelListManager.() -> Unit): Drawable {
    return ankoDrawable({_LevelListManager(ctx)}, init)
}
inline fun Context.levelList(init: _LevelListManager.() -> Unit): Drawable {
    return ankoDrawable({_LevelListManager(this)}, init)
}



inline fun DrawableManager.roundRect(init: _RoundRectManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_RoundRectManager(ctx)}, init)
}
inline fun AnkoContext<*>.roundRect(init: _RoundRectManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_RoundRectManager(ctx)}, init)
}
inline fun Context.roundRect(init: _RoundRectManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_RoundRectManager(this)}, init)
}



inline fun DrawableManager.oval(init: _OvalManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_OvalManager(ctx)}, init)
}
inline fun AnkoContext<*>.oval(init: _OvalManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_OvalManager(ctx)}, init)
}
inline fun Context.oval(init: _OvalManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_OvalManager(this)}, init)
}



inline fun DrawableManager.arc(init: _ArcManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_ArcManager(ctx)}, init)
}
inline fun AnkoContext<*>.arc(init: _ArcManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_ArcManager(ctx)}, init)
}
inline fun Context.arc(init: _ArcManager.() -> Unit): ShapeDrawable {
    return ankoDrawable({_ArcManager(this)}, init)
}



inline fun DrawableManager.bitmap(init: _BitmapManager.() -> Unit): BitmapDrawable {
    return ankoDrawable({_BitmapManager(ctx)}, init)
}
inline fun AnkoContext<*>.bitmap(init: _BitmapManager.() -> Unit): BitmapDrawable {
    return ankoDrawable({_BitmapManager(ctx)}, init)
}
inline fun Context.bitmap(init: _BitmapManager.() -> Unit): BitmapDrawable {
    return ankoDrawable({_BitmapManager(this)}, init)
}



inline fun DrawableManager.color(init: _ColorManager.() -> Unit): ColorDrawable {
    return ankoDrawable({_ColorManager(ctx)}, init)
}
inline fun AnkoContext<*>.color(init: _ColorManager.() -> Unit): ColorDrawable {
    return ankoDrawable({_ColorManager(ctx)}, init)
}
inline fun Context.color(init: _ColorManager.() -> Unit): ColorDrawable {
    return ankoDrawable({_ColorManager(this)}, init)
}



class _LevelListManager(override val ctx: Context) : LevelListDrawable(), DrawableManager, RawDrawableProvider<StateListDrawable> {
    private var minLevel = level

    override fun addDrawable(drawable: Drawable, params: Any?) {
        if(params == null) return
        if(params is Int) addLevel(params, drawable)
    }

    fun addLevel(level: Int, drawable: Drawable) {
        if(level <= minLevel) throw RuntimeException("drawableLevel less than minLevel $minLevel")
        addLevel(minLevel, level, drawable)
        minLevel = level
    }
}

class _StateListManager(override val ctx: Context) : StateListDrawable(), DrawableManager, RawDrawableProvider<StateListDrawable> {
    override fun addDrawable(drawable: Drawable, params: Any?) {
        if(params == null) return
        if(params is IntArray) addState(params, drawable)
    }
}

class _LayerManager(override val ctx: Context): DrawableManager, DrawableProvider<LayerDrawable> {
    override var drawableState: IntArray = intArrayOf()
    override var drawableLevel: Int = 0

    val layers: MutableList<Drawable> = ArrayList()

    override val drawable: LayerDrawable get() = LayerDrawable(layers.toTypedArray()).apply { setState(drawableState); setLevel(drawableLevel) }

    override fun addDrawable(drawable: Drawable, params: Any?) {
        layers.add(drawable)
    }
}

class _ColorManager(val ctx: Context) : ColorDrawable(), RawDrawableProvider<ColorDrawable> {
    public var colorResource: Int = 0
        set(value) {
            if(value == 0) return
            color = ctx.getColor(value)
        }
}

class _BitmapManager(val ctx: Context) : DrawableProvider<BitmapDrawable> {
    override var drawableState: IntArray = intArrayOf()
    override var drawableLevel: Int = 0

    var bitmap: Bitmap? = null
    var filePath: String? = null
    var stream: InputStream? = null

    override val drawable: BitmapDrawable
        get() = when {
            bitmap != null -> BitmapDrawable(ctx.resources, bitmap)
            filePath != null -> BitmapDrawable(ctx.resources, filePath)
            stream != null -> BitmapDrawable(ctx.resources, stream)
            else -> throw RuntimeException("must set one of bitmap, filePath or stream")
        }.apply {
            setState(drawableState); setLevel(drawableLevel)
        }
}

abstract class _ShapeManager(val ctx: Context) : DrawableProvider<ShapeDrawable> {
    override var drawableState: IntArray = intArrayOf()
    override var drawableLevel: Int = 0

    public var color: Int = Color.TRANSPARENT
    public var colorResource: Int = 0
        set(value) {
            if(value == 0) return
            color = ctx.getColor(value)
        }

    public var leftPadding: Int = 0
    public var topPadding: Int = 0
    public var rightPadding: Int = 0
    public var bottomPadding: Int = 0
    public var padding: Int = 0
        set(value) {
            leftPadding = value
            rightPadding = value
            topPadding = value
            bottomPadding = value
        }
}

class _RoundRectManager(ctx: Context) : _ShapeManager(ctx) {
    override var drawableState: IntArray = intArrayOf()

    public var radius: Float = 0f
    public var bottomLeftRadius: Float = 0f
    public var bottomRightRadius: Float = 0f
    public var topLeftRadius: Float = 0f
    public var topRightRadius: Float = 0f

    override val drawable: ShapeDrawable
        get() {
            val outerRadii: FloatArray = if(radius != 0f) floatArrayOf(radius, radius, radius, radius, radius, radius, radius, radius)
            else floatArrayOf(topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius)
            return ShapeDrawable(RoundRectShape(outerRadii, null, null)).apply {
                paint.color = color
                setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
                setState(drawableState)
                setLevel(drawableLevel)
            }
        }
}

class _OvalManager(ctx: Context) : _ShapeManager(ctx) {
    override val drawable: ShapeDrawable
        get() {
            return ShapeDrawable(OvalShape()).apply {
                paint.color = color
                setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
                setState(drawableState)
                setLevel(drawableLevel)
            }
        }
}

class _ArcManager(ctx: Context) : _ShapeManager(ctx) {
    public var start: Float = 0f
    public var sweep: Float = 360f

    override val drawable: ShapeDrawable
        get() {
            return ShapeDrawable(ArcShape(start, sweep)).apply {
                paint.color = color
                setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
                setState(drawableState)
                setLevel(drawableLevel)
            }
        }
}


/*helper method*/
/*----------------------------*/
inline fun DrawableManager.borderRoundRect(radius: Float, color: Int, init: _LayerManager.() -> Unit) : Drawable {
    return borderRoundRect(radius, color, 0f, Color.TRANSPARENT, init)
}

inline fun DrawableManager.borderRoundRect(radius: Float, color: Int, strokeWidth: Float, strokeColor: Int, init: _LayerManager.() -> Unit) : Drawable {
    return layer {
        roundRect {
            padding = strokeWidth.toInt()
            this.radius = radius
            this.color = strokeColor
        }
        roundRect {
            this.radius = if(radius >= strokeWidth) radius - strokeWidth else 0f
            this.color = color
        }
        init()
    }
}
/*----------------------------*/




