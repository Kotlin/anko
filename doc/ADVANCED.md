Kōan Advanced topics
===========

## Contents

* [Intents](#intents)
* [Services](#services)
* [Dialogs and toasts](#dialogs-and-toasts)
* [Asynchronous tasks](#asynchronous-tasks)
* [Logging](#logging)
* [Using SQLite](#using-sqlite)
* [Extending Koan](#extending-koan)

## Intents

Even if you won't use the DSL to create UIs, Koan still has something to make your life easier. For example, it has call wrappers for some widely used `Intents`:

Goal                | Solution
--------------------|--------- 
Make a call         | `makeCall(number)` without **tel:**
Browse the web      | `browse(url)`
Share some text     | `share(text, [subject])`
Send a email        | `email(email, [subject], [text])`

Arguments surrounded with `[]` are optional. Methods return true if the intent was sent.

Also, this is how you can start an activity:
```kotlin
startActivity(javaClass<SomeActivity>())
```

Or with arguments bundle:
```kotlin
startActivity(javaClass<SomeActivity>(),
  "id" to 5,
  "name" to "John",
  "data" to someSerializable
)
```

## Services

With Koan you can get handy access to many Android services.

E.g. that's the Java way for obtaining an Android service instance:
```java
(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)
```

In Kotlin, it's just `notificationService`. The same as for `displayManager`, `sensorManager`, `locationManager` — bindings are available to all services, just try it out!

## Dialogs and toasts

Koan provides an easy way to make toast notifications, alerts and selectors. All the functions desribed below can be executed from any thread.

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
  view {
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

Also, as mentioned above, Koan toasts and dialogs are always executed in main thread, so there's no need in `uiThread {}`:

```kotlin
async {
  // Another long background task
  toast("Done!")
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

## Logging

Android SDK provides `android.util.Log` class which has some logging methods. Usage is pretty straightforward though the methods require you to pass a `tag` argument. You can elimintate this with using `KoanLogger` trait:

```kotlin
class SomeActivity : Activity(), KoanLogger {
  private fun someMethod() {
    info("London is the capital of Great Britain")
    debug(5) // .toString() method will be executed
    warn(null) // "null" will be printed
  }
}
```

android.util.Log  | KoanLogger
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

## Extending Koan

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

…or this (see the [UI wrapper](#ui-wrapper) chapter):

```kotlin
UI {
  customView()
}
```

But if you really want to use your view as a top-level widget without a UI wrapper, add this:

```kotlin
fun Activity.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

fun Fragment.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

fun Context.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

// Only if you use android.support.v4
fun android.support.v4.app.Fragment.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)
```
