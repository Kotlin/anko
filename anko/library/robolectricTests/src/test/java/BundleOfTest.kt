package test

import org.jetbrains.anko.bundleOf
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
class BundleOfTest {

    @Test
    fun test() {
        val bundle1 = bundleOf()
        assert(bundle1.isEmpty)

        val bundle2 = bundleOf(
            "one" to 1,
            "abc" to "ABC",
            "null" to null
        )

        assert(bundle2.size() == 3)
        assert(bundle2.get("one") == 1)
        assert(bundle2.get("abc") == "ABC")
        assert(bundle2.get("null") == null)

        println("[COMPLETE]")
    }

}
