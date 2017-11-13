import android.app.Activity
import org.jetbrains.anko.internals.AnkoInternals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import test.BuildConfig

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class CreateIntentTest {
    @Test
    fun test() {
        val intent1 = AnkoInternals.createIntent(RuntimeEnvironment.application, Activity::class.java, arrayOf())
        assert(intent1.extras == null)

        val intent2 = AnkoInternals.createIntent(RuntimeEnvironment.application, Activity::class.java, arrayOf(
                "one" to 1,
                "abc" to "ABC",
                "null" to null
        ))

        assert(intent2.extras.size() == 3)
        assert(intent2.extras.get("one") == 1)
        assert(intent2.extras.get("abc") == "ABC")
        assert(intent2.extras.get("null") == null)
    }
}