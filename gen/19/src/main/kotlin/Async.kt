package kotlinx.android.koan

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import android.content.Context
import android.app.Fragment
import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

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

public fun Fragment.async(task: () -> Unit): Future<Unit> {
  return getActivity()!!.async(task)
}

public fun Fragment.async(executorService: ExecutorService, task: () -> Unit): Future<Unit> {
  return executorService.submit<Unit> { task() }
}

public fun Context.async(task: () -> Unit): Future<Unit> {
  return BackgroundExecutor.execute(task)
}

public fun Context.async(executorService: ExecutorService, task: () -> Unit): Future<Unit> {
  return executorService.submit<Unit> { task() }
}

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> {
  return getActivity()!!.asyncResult(task)
}

public fun <T> Fragment.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> {
  return executorService.submit(task)
}

public fun <T> Context.asyncResult(task: () -> T): Future<T> {
  return BackgroundExecutor.submit(task)
}

public fun <T> Context.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> {
  return executorService.submit(task)
}

object BackgroundExecutor {

  var executor: ExecutorService =
    Executors.newScheduledThreadPool(2 * Runtime.getRuntime().availableProcessors())

  fun execute(task: () -> Unit): Future<Unit> {
    return executor.submit<Unit> { task() }
  }

  fun <T> submit(task: () -> T): Future<T> {
    return executor.submit(task)
  }

}

private object ContextHelper {
  val handler = Handler(Looper.getMainLooper()!!)
  val uiThread = Looper.getMainLooper()!!.getThread()
}
