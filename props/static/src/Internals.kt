package kotlinx.android.koan.internals

import android.content.Context
import android.app.Activity
import android.content.Intent
import java.io.Serializable
import android.os.Bundle
import kotlinx.android.koan.*

public fun Context.__internalStartActivity(activity: Class<out Activity>, params: Array<Pair<String, Any>>) {
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
            else -> throw KoanException("Intent extra ${it.first} has wrong type ${it.second.javaClass.getName()}")
        }
    }
    startActivity(intent)
}