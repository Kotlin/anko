Kōan
===========

Koan is a library which makes Android application development faster and easier. It makes your code clean and easy to read, and lets you forget about rough edges of Android SDK for Java.

Just a brief example. Here is a "hello world" written with Koan:
```kotlin
verticalLayout {
  val name = editText()
  button("Say Hello") {
    onClick { toast("Hello, ${name.text}!") }
  }
}
```

Code above creates a button inside a `LinearLayout` and attaches an `OnClickListener` to that button.

As you might have guessed, it's a DSL for Android. It is written in [Kotlin](http://kotlinlang.org).

## Contents

* [Why Koan?](#why-koan)
	* [Why DSL?](#why-dsl)
	* [Why not Scaloid?](#why-not-scaloid)
	* [Supporting existing code](#supporting-existing-code)
	* [How it works](#how-it-works)
	* [Is it extendable?](#is-it-extendable)
	* [Using with Gradle](#using-with-gradle)
* [Understanding Koan](#understanding-koan)
	* [Basics](#basics)
	* [Helper methods](#helper-methods)
	* [Layouts and LayoutParams](#layouts-and-layoutparams)
	* [Listeners](#listeners)
	* [Resources, colors and dimensions](#resources-and-dimensions)
	* [UI wrapper](#ui-wrapper)
	* [Styles](#styles)
* [Advanced topics](#advanced-topics)
	* [Intents](#intents)
	* [Dialogs and toasts](#dialogs-and-toasts)
	* [Asynchronous tasks](#asynchronous-tasks)
	* [Extending Koan](#extending-koan)

## Why Koan?

### Why DSL?

By default, UI in Android is written using XML. That is inconvenient in the following ways:

* It is not typesafe;
* And not null-safe;
* It forces you to write almost *the same code* for every layout you made;
* XML is parsed on device wasting CPU time and battery;
* Above all, it allows no code reuse.

Well, you can create UI programmatically but nobody does that because it looks ugly and is extremely hard to maintain. Here's a plain Kotlin version (one in Java is even longer):

```kotlin
val act = this
val layout = LinearLayout(act)
layout.setOrientation(LinearLayout.VERTICAL)
val name = EditText(act)
val button = Button(act)
button.setText("Say Hello")
button.setOnClickListener {
  Toast.makeText(act, "Hello, ${name.getText()}!", Toast.LENGTH_SHORT).show()  
}
layout.addView(name)
layout.addView(button)
```

A DSL makes the same logic easy to read, easy to write and there're no runtime overhead. Just try it!

### Why not Scaloid?

[Scaloid](https://github.com/pocorall/scaloid) is a similar library for Scala, with lots of cool stuff supported.
But Android and Scala are not very good friends: Scala compiler is dreadfully slow, Android sbt plugin is full of bugs, and because Scala library is enormous you have to use tools such as ProGuard even when debugging your app.

Finally, **Scaloid manages a subclass for every single `View` in Android widget hierarchy** so it is not easy to make new DSL constructs for your own `View`s. Also, it consumes lots of memory without no good reason.

### Supporting existing code

You don't have to rewrite all your UI with Koan. You can keep your old classes written in Java.
Moreover, if you still want (or have) to write a Kotlin activity class and inflate an XML layout for some reason, you can use View properties, which would make your life better:

```kotlin
//Same as findViewById(), simpler to use
val name = find<TextView>(R.id.name)
name.hint = "Enter your name"
name.onClick { /*do something*/ }
```

### How it works

There is no :tophat: actually, Koan consists of some Kotlin [extension functions and properties](http://kotlinlang.org/docs/reference/extensions.html) arranged into *type-safe builders*, as described [here](http://kotlinlang.org/docs/reference/type-safe-builders.html).

It's a depressing job to write all these extensions by hand so they're generated automatically using *android.jar* files from Android SDK as sources.

### Is it extensible?

Short answer: **yes**.

For example, you might want to use a `MapView` in the DSL. Then just write this in any Kotlin file from where you could import it:
```kotlin
fun ViewManager.mapView(init: MapView.() -> Unit = {}) =
  __dslAddView({MapView(it)}, init, this)
```

``{MapView(it)}`` is a builder function for your custom View. It accepts a Context instance.

So now you can write this:
```kotlin
frameLayout {
  val mapView = mapView().layoutParams(width = matchParent)
}
```

Also see [Extending Koan](#extending-koan) if you need an to create top-level DSL views.

### Using with Gradle

There's a [small sample project](https://github.com/yanex/koan-demo-gradle) to show how to include Koan library into your Android Gradle project.

Basically, all you have to do is to add an additional repository and a compile dependency:

```gradle
repositories {
  ...
  maven { url "http://dl.bintray.com/yanex/kotlin" }
}

dependencies {
  ...
  compile 'org.jetbrains.kotlin:koan:19-0.1@aar'
}
```

This loads Koan for Android SDK `v. 19` without `support.v4` package bindings. If you use `support.v4`, replace `19` with `19s`.

## Understanding Koan

As mentioned above, Koan is written in Kotlin. 
In case you are not familiar with Kotlin, please refer to [kotlinlang.org](http://kotlinlang.org/docs/reference/). 
Kotlin is similar enough to Java (but much better), so learning it will be easy.

### Basics

In Koan, you don't need to inherit from any special classes: just use standard `Activity`, `Fragment`, `FragmentActivity` or whatever you want.

DSL is available in `onCreate()`:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
  super<Activity>.onCreate(savedInstanceState)

  verticalLayout {
    padding = dip(30)
    editText {
      hint = "Name"
      textSize = 24f
    }
    editText {
      hint = "Password"
      textSize = 24f
    }
    button("Login") {
      textSize = 26f
    }
  }
}
```

Note that there's no explicit call to `setContentView(R.layout.something)`: Koan sets content views automatically for `Activities` (and only for them).

`padding`, `hint` and `textSize` are [extension properties](http://kotlinlang.org/docs/reference/extensions.html#extension-properties). They exist for most `View` properties allowing you to write `text = "Some text"` instead of `setText("Some text")`.

`verticalLayout` (a `LinearLayout` but already with a `LinearLayout.VERTICAL` orientation), `editText` and `button` are [extension functions](http://kotlinlang.org/docs/reference/extensions.html). Such functions also exist for almost every `View` in Android framework, and they work in `Activities`, `Fragments` (both default and that from `android.support` package) and even for `Context`.

If you have a `Context` instance, you can write DSL constructs like this:

```kotlin
val name = with(myContext) {
  editText {
    hint = "Name"
  }
}
```

Variable `name` has type `EditText`.

### Helper methods

You probably noticed that `button` function in the previous chapter accepts a String parameter. Helper methods exist for some views such as TextView, EditText, Button or ImageView.

If you have nothing to set for the particular View, you can omit `{}` and write just this: `button("Ok")` or this: `button()`.

```kotlin
verticalLayout {
  button("Ok")
  button("Cancel")
}
```

### Layouts and LayoutParams

Position of widgets inside a parent can be set using LayoutParams. In XML it looks like this:

```xml
<ImageView 
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android_layout_marginLeft="5dip"
  android_layout_marginTop="10dip"
  android:src="@drawable/something" />
```

In Koan you set LayoutParams just after View description:

```kotlin
linearLayout {
  button("Login") {
    textSize = 26f
  }.layoutParams(width = wrapContent) {
    horizontalMargin = dip(5)
    topMargin = dip(10)
  }
}
```

If you specify layoutParams, both width and height defaults are WRAP_CONTENT. But you always can set it explicitly for sure. Use named arguments, it's convenient.

`margin`, `horizontalMargin` and `verticalMargin` are convenient helper properties. `horizontalMargin` sets both left and right margins, `verticalMargin` set top and bottom ones, and `margin` sets all for margins simultaneously.

In case of RelativeLayout, ``layoutParams`` are quite different.

```kotlin
val ID_OK = 1

relativeLayout {
  button("Ok") {
    id = ID_OK
  }.layoutParams { alignParentTop() }

  button("Cancel").layoutParams { below(ID_OK) }
}
```

### Listeners

You can set listeners from DSL.

```kotlin
button("Login") {
  onClick {
    login(name, password)
  }
}
```

It would be the same as this:
```kotlinm
button.setOnClickListener(object: OnClickListener {
  override fun onClick(v: View) {
    login(name, password)
  }
})
```
And this is much more helpful when you have listeners with lots of methods. The next code is written without using Koan:

```kotlin
seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
  override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
    //something
  }
  override fun onStartTrackingTouch(seekBar: SeekBar?) {
    //just an empty method
  }
  override fun onStopTrackingTouch(seekBar: SeekBar) {
    //another empty method
  }
})
```

And now with Koan:
```kotlin
seekBar {
  onProgressChanged { (seekBar, i, b) ->
    //something
  }
}
```

### Resources, colors and dimensions

#### Using resource identifiers

All examples in the previous chapters used raw Java strings, but it is not a good practice. Typically you put all your string data into res/values/ directory and access it in runtime calling, for example, `getString(R.string.login)`.

Fortunately, in Koan you could pass the resource identifier both to helper method (`button(R.string.login)`) or to extension property (`button { textResource = R.string.login }`).

Note that the property name is quite different. Instead of setting `text`, `hint`, `image`, write `textResource`, `hintResource` and `imageResource`. This kind of properties always returns 0 when read.

#### Colors

Two simple extension functions to make the code more readable.

Function             | Result
---------------------|--------- 
`0xff0000.opaque`    | <span style="color:#ff0000">non-transparent red</span>
`0x99.gray.opaque`   | <span style="color:#999">non-transparent #999999 gray</span>

#### Dimensions

Also, you can specify dimension values in **dip** (density-independent pixels) or in **sp** (scale-independent pixels): `dip(dipValue)` or `sp(spValue)`. Note that textSize property already accepts **sp** (`textSize = 16f`). Use `px2dip` and `px2sp` to convert backwards.

### UI wrapper

Before the Beginning of Time Koan used UI tag as a top-level DSL element:

```kotlin
UI {
  editText {
    hint = "Name"
  }
}
```

You can still use this tag if you want. And it would be much easier to extend DSL as you have to declare only one `ViewManager.customView` function. See [Extending Koan](#extending-koan) for the futher information.

### Styles

Koan supports styling. Style is simply a function that accepts View, and this function is applied for the View itself, and then recursively to each child of a View if it is a ViewGroup.

```kotlin
verticalLayout {
  editText {
    hint = "Name"
  }
  editText {
    hint = "Password"
  }
}.style { v -> when(v) {
  is EditText -> v.textSize = 20f
}}
```

## Advanced topics

### Intents

Even if you won't use DSL, Koan still has something to make your life easier.

For example, it has call wrappers for some Intents used widely.

Goal                | Solution
--------------------|--------- 
Make a call         | `makeCall(number)` without **tel:**
Browse the web      | `browse(url)`
Share some text     | `share(text, [subject])`
Send a email        | `email(email, [subject], [text])`

Arguments surrounded with `[]` are optional. Methods return true if intent was sent.

Also, that is how you can start an activity:
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

### Dialogs and toasts

An easy way to make toast notifications, alerts and selectors. All these functions could be executed from any thread.

#### Toasts

```kotlin
toast("Hi there!")
toast(R.string.message)
longToast("Wow, such long")
```

#### Alerts

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

#### Selector alerts

```kotlin
val countries = listOf("Russia", "USA", "Japan", "Australia")
selector("Where are you from?", countries) { i ->
  toast("So you're living in ${countries[i]}, right?")
}
```

### Asynchronous tasks

AsyncTask is a jumbo. Wait, no, it is sometimes a  
Jumbo\<OneElementWhichWillBeConvertedToArray, SomethingNotReallyUseful, Result\>.  
It's twice as awful as hell.

There's a way better.

```kotlin
async {
  //long background task
  uiThread {
    result.text = "Done"
  }
}
```

Also, as written in the previous chapter, Koan toasts and dialogs are always executed in main thread, so there's no need in `uiThread {}`:

```kotlin
async {
  //long background task
  toast("Done!")
}
```

You can even execute tasks using your own ExecutorService:

```kotlin
val executor = Executors.newScheduledThreadPool(4)
async(executor) {
  //some task
}
```

`asyncResult` is similar to `async` but this one accepts function that returns something of particular type. Both `asyncResult` and `async` returns Java Future.

```kotlin
fun apiCall(): Result {
  //something
}
val future: Future<Result> = asyncResult(::apiCall)
```

### Extending Koan

Assuming `CustomView` would be your custom View class name, and `customView` is what you want to write in DSL.

If you just plan to use your custom View in DSL surrounded by some other View:

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

…or this (see the [UI wrapper](UI wrapper) chapter):

```kotlin
UI {
  customView()
}
```

But if you really want to use your view as a top-level child without a UI wrapper, add this:

```kotlin
fun Activity.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

fun Fragment.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

fun Context.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)

//Only if you use android.support.v4
fun android.support.v4.app.Fragment.customView(init: View.() -> Unit = {}) =
  __dslAddView({View(it)}, init, this)
```
