package test

import android.app.Activity
import android.os.Looper
import org.jetbrains.anko.async.async
import org.jetbrains.anko.async.bg
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

class AsyncTestActivity : Activity() {
    val result = ThreadLocal<String>()

    fun loadData() = async {
        assertSame(MAIN_THREAD, Thread.currentThread())
        val data = bg {
            assertNotSame(MAIN_THREAD, Thread.currentThread())
            loadDataSync()
        }
        assertSame(MAIN_THREAD, Thread.currentThread())
        assertEquals(HELLO_WORLD, data)

        result.set(data)
    }
}

private val DELAY = 500L
private val MAIN_THREAD = Looper.getMainLooper().thread

private val HELLO_WORLD = "Hello, world!"

private fun loadDataSync(): String {
    Thread.sleep(DELAY)
    return HELLO_WORLD
}

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
class AsyncTest {
    @Test
    fun test() {
        val activity = Robolectric.buildActivity(AsyncTestActivity::class.java).create().get()

        activity.loadData()

        val time = System.currentTimeMillis() + DELAY * 2 + 1000
        while (System.currentTimeMillis() < time) {
            ShadowLooper.idleMainLooper()
            Thread.yield()
        }

        assertEquals(HELLO_WORLD, activity.result.get())
    }
}