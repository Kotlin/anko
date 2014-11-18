import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import android.app.Fragment
import android.app.Activity
import android.graphics.drawable.Drawable

/* SECTION VIEWS */
//type casting is now under the hood
public fun <T : View> View.find(id: Int): T = findViewById(id) as T
/* END SECTION */

/* SECTION COLORS */
//returns 0xC0C0C0 for 0xC0
public val Int.gray: Int
    get() = this or (this shl 8) or (this shl 16)

//returns 0xFFABCDEF for 0xABCDEF
public val Int.opaque: Int
    get() = this or 0xff000000.toInt()
/* END SECTION */


/* SECTION DIMENSIONS */
//returns dip(dp) dimension value in pixels
public fun Context.dip(value: Int): Int =
    (value * (getResources()?.getDisplayMetrics()?.density ?: 0f)).toInt()
public fun Context.dip(value: Float): Int =
    (value * (getResources()?.getDisplayMetrics()?.density ?: 0f)).toInt()

//return sp dimension value in pixels
public fun Context.sp(value: Int): Int =
    (value * (getResources()?.getDisplayMetrics()?.scaledDensity ?: 0f)).toInt()
public fun Context.sp(value: Float): Int =
    (value * (getResources()?.getDisplayMetrics()?.scaledDensity ?: 0f)).toInt()

//converts px value into dip or sp
public fun Context.px2dip(px: Int): Float =
    (px.toFloat() / (getResources()?.getDisplayMetrics()?.density ?: 1f)).toFloat()
public fun Context.px2sp(px: Int): Float =
    (px.toFloat() / (getResources()?.getDisplayMetrics()?.scaledDensity ?: 1f)).toFloat()

//the same for nested DSL components
public fun UiHelper.dip(value: Int): Int = ctx.dip(value)
public fun UiHelper.dip(value: Float): Int = ctx.dip(value)
public fun UiHelper.sp(value: Int): Int = ctx.sp(value)
public fun UiHelper.sp(value: Float): Int = ctx.sp(value)
public fun UiHelper.px2dip(px: Int): Float = ctx.px2dip(px)
public fun UiHelper.px2sp(px: Int): Float = ctx.px2sp(px)

//the same for Fragments
public fun Fragment.dip(value: Int): Int = ctx.dip(value)
public fun Fragment.dip(value: Float): Int = ctx.dip(value)
public fun Fragment.sp(value: Int): Int = ctx.sp(value)
public fun Fragment.sp(value: Float): Int = ctx.sp(value)
public fun Fragment.px2dip(px: Int): Float = ctx.px2dip(px)
public fun Fragment.px2sp(px: Int): Float = ctx.px2sp(px)
/* END SECTION */


/* SECTION CUSTOM VIEWS */
private val verticalLayoutFactory = { (ctx: Context) ->
    val v = _LinearLayout(ctx)
    v.setOrientation(LinearLayout.VERTICAL)
    v
}

public fun ViewManager.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout =
    __dslAddView(verticalLayoutFactory, init, this): LinearLayout

public fun Activity.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout =
    __dslAddView(verticalLayoutFactory, init, this): LinearLayout

public fun Fragment.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout =
    __dslAddView(verticalLayoutFactory, init, this): LinearLayout

public fun Context.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout =
    __dslAddView(verticalLayoutFactory, init, this): LinearLayout
/* END SECTION */


/* SECTION CUSTOM VIEW PROPERTIES */
public var View.backgroundColor: Int
    get() = 0
    set(value) {this.setBackgroundColor(value)}

public var View.backgroundResource: Int
    get() = 0
    set(value) {
        this.setBackgroundResource(value)
    }

public var View.paddingLeft: Int
    get() = this.getPaddingLeft()
    set(value) {
        this.setPadding(value, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom())
    }

public var View.paddingTop: Int
    get() = this.getPaddingTop()
    set(value) {
        this.setPadding(this.getPaddingLeft(), value, this.getPaddingRight(), this.getPaddingBottom())
    }

public var View.paddingRight: Int
    get() = this.getPaddingRight()
    set(value) {
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), value, this.getPaddingBottom())
    }

public var View.paddingBottom: Int
    get() = this.getPaddingBottom()
    set(value) {
        this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), value)
    }

public var View.padding: Int
    get() = throw KoanException("'padding' property doesn't have a getter")
    set(value) {
        this.setPadding(value, value, value, value)
    }

public var LinearLayout.gravity: Int
    get() = throw KoanException("'gravity' property doesn't have a getter")
    set(value) {
        this.setGravity(value)
    }

public var TextView.textColor: Int
    get() = throw KoanException("'textColor' property doesn't have a getter")
    set(value) {
        this.setTextColor(value)
    }

public var ImageView.image: Drawable?
    get() = this.getDrawable()
    set(value) {
        this.setImageDrawable(value)
    }

public var ImageView.imageResource: Int
    get() = 0
    set(value) {
        this.setImageResource(value)
    }
/* END SECTION */


/* SECTION CUSTOM LAYOUT PROPERTIES */
public val matchParent: Int = android.view.ViewGroup.LayoutParams.MATCH_PARENT
public val wrapContent: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT

public var LinearLayout.LayoutParams.margin: Int
    get() = throw KoanException("'LinearLayout.LayoutParams.margin' property doesn't have a getter")
    set(v) {
        leftMargin = v
        rightMargin = v
        topMargin = v
        bottomMargin = v
    }

public var LinearLayout.LayoutParams.verticalMargin: Int
    get() = throw KoanException("'LinearLayout.LayoutParams.verticalMargin' property doesn't have a getter")
    set(v) {
        topMargin = v
        bottomMargin = v
    }

public var LinearLayout.LayoutParams.horizontalMargin: Int
    get() = throw KoanException("'LinearLayout.LayoutParams.horizontalMargin' property doesn't have a getter")
    set(v) {
        leftMargin = v; rightMargin = v
    }

public fun android.widget.RelativeLayout.LayoutParams.topOf(id: Int): Unit = addRule(android.widget.RelativeLayout.ABOVE, id)
public fun android.widget.RelativeLayout.LayoutParams.above(id: Int): Unit = addRule(android.widget.RelativeLayout.ABOVE, id)
public fun android.widget.RelativeLayout.LayoutParams.below(id: Int): Unit = addRule(android.widget.RelativeLayout.BELOW, id)
public fun android.widget.RelativeLayout.LayoutParams.bottomOf(id: Int): Unit = addRule(android.widget.RelativeLayout.BELOW, id)
public fun android.widget.RelativeLayout.LayoutParams.leftOf(id: Int): Unit = addRule(android.widget.RelativeLayout.LEFT_OF, id)
public fun android.widget.RelativeLayout.LayoutParams.rightOf(id: Int): Unit = addRule(android.widget.RelativeLayout.RIGHT_OF, id)
public fun android.widget.RelativeLayout.LayoutParams.sameLeft(id: Int): Unit = addRule(android.widget.RelativeLayout.ALIGN_LEFT, id)
public fun android.widget.RelativeLayout.LayoutParams.sameTop(id: Int): Unit = addRule(android.widget.RelativeLayout.ALIGN_TOP, id)
public fun android.widget.RelativeLayout.LayoutParams.sameRight(id: Int): Unit = addRule(android.widget.RelativeLayout.ALIGN_RIGHT, id)
public fun android.widget.RelativeLayout.LayoutParams.sameBottom(id: Int): Unit = addRule(android.widget.RelativeLayout.ALIGN_BOTTOM, id)
public fun android.widget.RelativeLayout.LayoutParams.alignParentTop(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_TOP)
public fun android.widget.RelativeLayout.LayoutParams.alignParentLeft(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_LEFT)
public fun android.widget.RelativeLayout.LayoutParams.alignParentBottom(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM)
public fun android.widget.RelativeLayout.LayoutParams.alignParentRight(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_RIGHT)
public fun android.widget.RelativeLayout.LayoutParams.alignParentStart(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_START)
public fun android.widget.RelativeLayout.LayoutParams.alignParentEnd(): Unit = addRule(android.widget.RelativeLayout.ALIGN_PARENT_END)
public fun android.widget.RelativeLayout.LayoutParams.centerHorizontally(): Unit = addRule(android.widget.RelativeLayout.CENTER_HORIZONTAL)
public fun android.widget.RelativeLayout.LayoutParams.centerVertically(): Unit = addRule(android.widget.RelativeLayout.CENTER_VERTICAL)
public fun android.widget.RelativeLayout.LayoutParams.centerInParent(): Unit = addRule(android.widget.RelativeLayout.CENTER_IN_PARENT)
/* END SECTION */

/* SECTION SERVICES */
public val Context.vibrator: android.os.Vibrator
    get() = getSystemService(Context.VIBRATOR_SERVICE) as android.os.Vibrator
public val Context.layoutInflater: android.view.LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater
/* END SECTION */