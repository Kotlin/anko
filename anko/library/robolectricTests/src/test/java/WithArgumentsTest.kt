package test

import android.app.Fragment
import org.jetbrains.anko.withArguments
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
class WithArgumentsTest {

    @Test
    fun test() {
        val fragment1 = Fragment().withArguments()
        assert(fragment1.arguments.isEmpty)

        val fragment2 = Fragment().withArguments(
            "one" to 1,
            "abc" to "ABC",
            "null" to null
        )

        val arguments = fragment2.arguments
        assert(arguments.size() == 3)
        assert(arguments.get("one") == 1)
        assert(arguments.get("abc") == "ABC")
        assert(arguments.get("null") == null)

        println("[COMPLETE]")
    }

}
