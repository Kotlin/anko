import java.util.concurrent.Executor
import java.util.concurrent.Executors
import android.content.Context
import android.app.Fragment
import android.os.Handler
import android.os.Looper

public fun Fragment.uiThread(f: () -> Unit) {
  getActivity()!!.uiThread(f)
}

public fun Context.uiThread(f: () -> Unit) {
  if (ContextHelper.uiThread == Thread.currentThread()) {
    f()
  } else {
    ContextHelper.handler.post(Runnable(f))
  }
}

public fun Fragment.async(task: () -> Unit) {
  getActivity()!!.async(task)
}

public fun Context.async(task: () -> Unit) {
  BackgroundExecutor.execute(task)
}

object BackgroundExecutor {

  var executor: Executor =
    Executors.newScheduledThreadPool(2 * Runtime.getRuntime().availableProcessors())

  fun execute(task: () -> Unit) {
    executor.execute(task)
  }

}

private object ContextHelper {
  val handler = Handler(Looper.getMainLooper()!!)
  val uiThread = Looper.getMainLooper()!!.getThread()
}