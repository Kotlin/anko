import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.content.ActivityNotFoundException
import android.preference.PreferenceManager
import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.net.Uri
import java.io.Serializable

public val LDPI: Int = android.util.DisplayMetrics.DENSITY_LOW
public val MDPI: Int = android.util.DisplayMetrics.DENSITY_MEDIUM
public val HDPI: Int = android.util.DisplayMetrics.DENSITY_HIGH

//May not be available on older Android versions
public val TVDPI: Int = 213
public val XHDPI: Int = 320
public val XXHDPI: Int = 480
public val XXXHDPI: Int = 640

public val Activity.intent: Intent
  get() = getIntent()!!

public val Context.defaultSharedPreferences: SharedPreferences
  get() = PreferenceManager.getDefaultSharedPreferences(this)!!

public val Fragment.defaultSharedPreferences: SharedPreferences
  get() = PreferenceManager.getDefaultSharedPreferences(getActivity()!!)!!

public val Fragment.act: Activity
  get() = getActivity()!!

public val Fragment.ctx: Context
  get() = getActivity()!!

public val Context.ctx: Context
  get() = this

public val Activity.act: Activity
  get() = this

public fun Fragment.browse(url: String): Boolean = ctx.browse(url)
public fun Context.browse(url: String): Boolean {
  try {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setData(Uri.parse(url))
    startActivity(intent)
    return true
  } catch (e: ActivityNotFoundException) {
    e.printStackTrace()
    return false
  }
}

public fun Fragment.share(text: String, subject: String = ""): Boolean = ctx.share(text, subject)
public fun Context.share(text: String, subject: String = ""): Boolean {
  try {
    val intent = Intent(android.content.Intent.ACTION_SEND)
    intent.setType("text/plain")
    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject)
    intent.putExtra(android.content.Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(intent, null))
    return true
  } catch (e: ActivityNotFoundException) {
    e.printStackTrace()
    return false
  }
}

public fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean = ctx.email(email, subject, text)
public fun Context.email(email: String, subject: String = "", text: String = ""): Boolean {
  try {
    val intent = Intent(Intent.ACTION_SEND)
    intent.setType("text/html")
    intent.putExtra(Intent.EXTRA_EMAIL, email)
    if (subject.length > 0)
      intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.length > 0)
      intent.putExtra(Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(intent, null))
    return true
  } catch (e: ActivityNotFoundException) {
    e.printStackTrace()
    return false
  }
}

public fun Fragment.makeCall(number: String): Boolean = ctx.makeCall(number)
public fun Context.makeCall(number: String): Boolean {
  try {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
    startActivity(intent)
    return true
  } catch (e: Exception) {
    e.printStackTrace()
    return false
  }
}

public fun Fragment.startActivity(activity: Class<out Activity>, vararg params: Pair<String, Any>): Unit
  = ctx.internalStartActivity(activity, params)
public fun Context.startActivity(activity: Class<out Activity>, vararg params: Pair<String, Any>): Unit
  = internalStartActivity(activity, params)

private fun Context.internalStartActivity(activity: Class<out Activity>, params: Array<Pair<String, Any>>) {
  val intent = Intent(this, activity)
  params.forEach {
    when (it.second) {
      is Int -> intent.putExtra(it.first, it.second as Int)
      is Long -> intent.putExtra(it.first, it.second as Long)
      is CharSequence -> intent.putExtra(it.first, it.second as CharSequence)
      is String -> intent.putExtra(it.first, it.second as String)
      is Float -> intent.putExtra(it.first, it.second as Float)
      is Double -> intent.putExtra(it.first, it.second as Double)
      is Char -> intent.putExtra(it.first, it.second as Char)
      is Short -> intent.putExtra(it.first, it.second as Short)
      is Boolean -> intent.putExtra(it.first, it.second as Boolean)
      is Long -> intent.putExtra(it.first, it.second as Long)
      is Serializable -> intent.putExtra(it.first, it.second as Serializable)
      is Bundle -> intent.putExtra(it.first, it.second as Bundle)
      else -> throw Error("Argument ${it.first} has wrong type: ${it.second.javaClass.getName()}")
    }
  }
  startActivity(intent)
}

public val Context.displayMetrics: android.util.DisplayMetrics
  get() = getResources()!!.getDisplayMetrics()!!

public val Context.conf: android.content.res.Configuration
  get() = getResources()!!.getConfiguration()!!

public val android.content.res.Configuration.portrait: Boolean
  get() = orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

public val android.content.res.Configuration.landscape: Boolean
  get() = orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

public val android.content.res.Configuration.long: Boolean
  get() = (screenLayout and android.content.res.Configuration.SCREENLAYOUT_LONG_YES) != 0