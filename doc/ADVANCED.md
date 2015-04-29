Anko Advanced topics
===========

## Contents

* [Intents](#intents)
* [Fragments](#fragments)
* [Services](#services)
* [Configuration qualifiers](#configuration-qualifiers)
* [Dialogs and toasts](#dialogs-and-toasts)
* [Asynchronous tasks](#asynchronous-tasks)
* [Logging](#logging)
* [Using SQLite](#using-sqlite)
* [Extending Anko](#extending-anko)

## Intents

### Useful intent callers

Even if you won't use the DSL to create UI, Anko still has something to make your life easier. For example, it has call wrappers for some widely used `Intents`:

Goal                | Solution
--------------------|--------- 
Make a call         | `makeCall(number)` without **tel:**
Browse the web      | `browse(url)`
Share some text     | `share(text, [subject])`
Send a email        | `email(email, [subject], [text])`

Arguments in square brackets (`[]`) are optional. Methods return true if the intent was sent.

### Intent builder functions

In general, you have to write a couple of lines to start a new `Activity`. And it requires you to write an additional line for each value you pass as an extra. For example, this is a code for starting an `Activity` with extra `(id, 5)` and a special flag:

```kotlin
val intent = Intent(this, javaClass<SomeOtherActivity>())
intent.putExtra("id", 5)
intent.setFlag(Intent.FLAG_ACTIVITY_SINGLE_TOP)
startActivity(intent)
```

Four lines is too much for this. Anko offers you an easier way:

```kotlin
startActivity(Intent<SomeOtherActivity>("id" to 5).singleTop())
```

If you don't need to pass any flags, the solution is even easier:

```kotlin
startActivity<SomeOtherActivity>("id" to 5)
```

## Fragments

There's also a convenient arguments setter for a `Fragment` class:

```kotlin
class SomeFragment : Fragment()

// On the call site:
SomeFragment().withArguments(
    "id" to 5,
    "name" to "John")
```

## Services

With Anko you can get handy access to many Android services.

E.g. that's the Java way for obtaining an Android service instance:
```java
(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)
```

In Kotlin, it's just `notificationService`. The same as for `displayManager`, `sensorManager`, `vibrator`, `layoutInflater` — bindings are available for all services, just try it out!

## Configuration qualifiers

[Qualifiers](http://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources) are used to support different resources for different screens, device configurations etc.

Anko supports the `configuration()` function that specifies qualifiers the code is meant for:

```kotlin
configuration(screenSize = ScreenSize.LARGE, orientation = Orientation.LANDSCAPE) {
    /* 
      This code will be only executed
      if the screen is large and its orientation is landscape
    */
}
```

It is implemented through checking the specified qualifiers and only executing the code inside the `configuration()` if their values match. Therefore, usages of `configuration()` are not limited to DSL only: for example, you can safely call Android SDK functions which are not present in older versions of system using `configuration(fromSdk = <version>) { /* code  */ }`.

Here is the full list of supported qualifiers:

Qualifier         | Value type         | Description
------------------|--------------------|-------------------------------------
`screenSize`      | `ScreenSize`       | Device screen size (e.g. `SMALL`, `LARGE`)
`density`         | `Range<Int>`       | Device screen density
`language`        | `String`           | System language (`en` or `en_US` format)
`orientation`     | `Orientation`      | Screen orientation
`long`            | `Boolean`          | Screen aspect
`fromSdk`         | `Int`              | Minimal Android SDK version code
`sdk`             | `Int`              | Target Android SDK version code
`uiMode`          | `UiMode`           | Target UI mode (e.g. `CAR`, `WATCH`)
`nightMode`       | `Boolean`          | Screen night mode value
`rightToLeft`     | `Boolean`          | Is RTL mode enabled
`smallestWidth`   | `Int`              | Shortest dimension of the available screen

## Dialogs and toasts

Anko provides an easy way to make `Toast` notifications, alerts and selectors.

### Toasts

```kotlin
toast("Hi there!")
toast(R.string.message)
longToast("Wow, such a duration")
```

### Alerts

```kotlin
alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
    positiveButton("Yes") {toast("Oh…")}
    negativeButton("No") {}
}.show()
```

Alerts seamlessly support DSL as custom views:

```kotlin
alert {
    customView {
        editText()
    }
}.show()
```

### Selector alerts

```kotlin
val countries = listOf("Russia", "USA", "Japan", "Australia")
selector("Where are you from?", countries) { i ->
    toast("So you're living in ${countries[i]}, right?")
}
```

## Asynchronous tasks

`AsyncTask` is a jumbo. Wait, no, it is sometimes a  
`Jumbo<OneElementWhichWillBeConvertedToArray, SomethingNotReallyUseful, Result>`. It's twice as awful as hell.

There's a better way:

```kotlin
async {
    // Long background task
    uiThread {
        result.text = "Done"
    }
}
```

You can even execute tasks using your own `ExecutorService`:

```kotlin
val executor = Executors.newScheduledThreadPool(4)
async(executor) {
    // Some task
}
```

`asyncResult` is similar to `async` but this one accepts a function that returns something. Both `asyncResult` and `async` return Java `Future`s.

```kotlin
fun apiCall(): Result {
    // Something
}
val future: Future<Result> = asyncResult(::apiCall)
```

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i><code>uiThread()</code> acts quite differently for different classes. When called on <code>Activity</code>, code in lambda would not be executed if <code>isFinishing()</code> is <code>true</code>. Use <code>ctx.uiThread { }</code> if this is an unwanted result.</i>
</td>
</tr>
</table>

## Logging

Android SDK provides `android.util.Log` class which has some logging methods. Usage is pretty straightforward though the methods require you to pass a `tag` argument. You can elimintate this with using `AnkoLogger` trait:

```kotlin
class SomeActivity : Activity(), AnkoLogger {
    private fun someMethod() {
        info("London is the capital of Great Britain")
        debug(5) // .toString() method will be executed
        warn(null) // "null" will be printed
    }
}
```

android.util.Log  | AnkoLogger
------------------|------------
`v()`             | `verbose()`
`d()`             | `debug()`
`i()`             | `info()`
`w()`             | `warn()`
`e()`             | `error()`
`wtf()`           | `wtf()`

The default tag name is a class name (`SomeActivity` in this case) but you can easily change it by overriding the `loggerTag` property.

Each method has two versions: plain and lazy (inlined):

```kotlin
info("String " + "concatenation")
info { "String " + "concatenation" }
```

Lambda result will be calculated only if `Log.isLoggable(tag, Log.INFO)` is `true`.

## Using SQLite

Please refer to [Using SQLite](SQLITE.md) document for details.

## Extending Anko

Let's say, `CustomView` is your custom `View` class name, and `customView` is what you want to write in the DSL.

If you only plan to use your custom `View` in the DSL surrounded by some other `View`:

```kotlin
fun ViewManager.customView(init: CustomView.() -> Unit = {}) =
    __dslAddView({CustomView(it)}, init, this)
```

So now you can write this:

```kotlin
frameLayout {
    customView()
}
```

…or this (see the [UI wrapper](../README.md#ui-wrapper) chapter):

```kotlin
UI {
    customView()
}
```

But if you really want to use your view as a top-level widget without a UI wrapper, add this:

```kotlin
fun Activity.customView(init: View.() -> Unit = {}) =
    __dslAddView({View(it)}, init, this)

fun Context.customView(init: View.() -> Unit = {}) =
    __dslAddView({View(it)}, init, this)

// Only if you use android.support.v4
fun android.support.v4.app.Fragment.customView(init: View.() -> Unit = {}) =
    __dslAddView({View(it)}, init, this)
```
