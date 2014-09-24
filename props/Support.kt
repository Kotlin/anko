import android.content.Context
import android.view.ViewGroup
import android.view.ViewManager
import android.view.View
import android.app.Activity
import android.app.Fragment
import java.util.HashMap

private fun <T: View> android.support.v4.app.Fragment.addFragmentTopLevelView(v: T, init: T.() -> Unit): T {
  UI { addView(v, init, this) }
  return v
}

public fun android.support.v4.app.Fragment.UI(init: UiHelper.() -> Unit): UiHelper = getActivity()!!.UI(false, init)
