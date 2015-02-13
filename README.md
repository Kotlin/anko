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

<img src="doc/helloworld.png" alt="Hello world" height="90" width="373" />

As you might have guessed, it's a DSL for Android. It is written in [Kotlin](http://kotlinlang.org).

## Contents

* [Why Koan?](#why-koan)
	* [Why DSL?](#why-dsl)
	* [Why not Scaloid?](#why-not-scaloid)
	* [Supporting existing code](#supporting-existing-code)
	* [How it works](#how-it-works)
	* [Is it extendable?](#is-it-extendable)
	* [Using with Gradle](#using-with-gradle)
	* [Using as Jar library](#using-as-jar-library)
* [Understanding Koan](#understanding-koan)
	* [Basics](#basics)
	* [Helper methods](#helper-methods)
	* [Layouts and LayoutParams](#layouts-and-layoutparams)
	* [Listeners](#listeners)
	* [Resources, colors and dimensions](#resources-and-dimensions)
	* [Instance shorthands](#instance-shorthands)
	* [UI wrapper](#ui-wrapper)
	* [Include tag](#include-tag)
	* [Styles](#styles)
* [Advanced topics](doc/ADVANCED.md)
	* [Intents](doc/ADVANCED.md#intents)
	* [Services](doc/ADVANCED.md#services)
	* [Dialogs and toasts](doc/ADVANCED.md#dialogs-and-toasts)
	* [Asynchronous tasks](doc/ADVANCED.md#asynchronous-tasks)
	* [Logging](doc/ADVANCED.md#logging)
	* [Using SQLite](doc/ADVANCED.md#using-sqlite)
	* [Extending Koan](doc/ADVANCED.md#extending-koan)
* [Using SQLite](doc/SQLITE.md)

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
// Same as findViewById(), simpler to use
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

``{MapView(it)}`` is a factory function for your custom `View`. It accepts a `Context` instance.

So now you can write this:
```kotlin
frameLayout {
  val mapView = mapView().layoutParams(width = matchParent)
}
```

Also see [Extending Koan](#extending-koan) if you need to create top-level DSL views.

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
  compile 'org.jetbrains.kotlin:koan-15:0.2.1'
}
```

This loads Koan for Android SDK v. 15 (Android 4.0.3) without `support.v4` package bindings. If you use `support.v4`, replace `15` with `15s`.  
There are also builds for Android SDK v. 19 and v. 21.

### Using as Jar library

If your project is not based on Gradle, you don't have to jump around with Maven artifacts. Just attach the **jar** from the [releases page](https://github.com/yanex/koan/releases) as a project library and that's it.

## Understanding Koan

As mentioned above, Koan is written in Kotlin. 
In case you are not familiar with Kotlin, please refer to [kotlinlang.org](http://kotlinlang.org/docs/reference/). 
Kotlin is similar enough to Java (but much better), so learning it will be easy.

### Basics

In Koan, you don't need to inherit from any special classes: just use standard `Activity`, `Fragment`, `FragmentActivity` or whatever you want.

First of all, import `kotlinx.android.koan.*` to use Koan DSL in your classes.

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

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>There's no explicit call to <code>setContentView(R.layout.something)</code>: Koan sets content views automatically for <code>Activities</code> (and only for them).</i>
</td>
</tr>
</table>

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

As you probably noticed, the `button` function in the previous section accepts a `String` parameter. Such helper methods exist for some views such as `TextView`, `EditText`, `Button` or `ImageView`.

If you don't need to set any properties for some particular `View`, you can omit `{}` and write `button("Ok")` or even just `button()`:

```kotlin
verticalLayout {
  button("Ok")
  button("Cancel")
}
```

### Layouts and LayoutParams

Positioning of widgets inside parent containers can be tuned using `LayoutParams`. In XML it looks like this:

```xml
<ImageView 
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android_layout_marginLeft="5dip"
  android_layout_marginTop="10dip"
  android:src="@drawable/something" />
```

In Koan, you specify `LayoutParams` right after a `View` description:

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

If you specify `layoutParams`, but omit `width` and/or `height`, their default values are both `WRAP_CONTENT`. But you always can pass them explicitly, for sure. Use [named arguments](http://kotlinlang.org/docs/reference/functions.html#named-arguments), it's convenient.

Some convenient helper properties to notice:
- `horizontalMargin` sets both left and right margins, 
- `verticalMargin` set top and bottom ones, and 
- `margin` sets all for margins simultaneously.

Note that `layoutParams` are different for different layouts, for example, in the case of `RelativeLayout`:

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

You can set listeners from the Koan code:

```kotlin
button("Login") {
  onClick {
    login(name, password)
  }
}
```

It would be the same as this:
```kotlinm
button.setOnClickListener(object : OnClickListener {
  override fun onClick(v: View) {
    login(name, password)
  }
})
```

Koan is very helpful when you have listeners with lots of methods. Consider the following code written without using Koan:

```kotlin
seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
  override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
    // Something
  }
  override fun onStartTrackingTouch(seekBar: SeekBar?) {
    // Just an empty method
  }
  override fun onStopTrackingTouch(seekBar: SeekBar) {
    // Another empty method
  }
})
```

And now with Koan:
```kotlin
seekBar {
  onProgressChanged { (seekBar, progress, fromUser) ->
    // Something
  }
}
```

If you set `onProgressChanged` and `onStartTrackingTouch` for the same `View`, these two "partially defined" listeners will be merged. For the same listener method, last wins.

### Resources, Colors and Dimensions

#### Using resource identifiers

All examples in the previous chapters used raw Java strings, but it is hardly a good practice. Typically you put all your string data into `res/values/` directory and access it at runtime calling, for example, `getString(R.string.login)`.

Fortunately, in Koan you can pass resource identifiers both to helper methods (`button(R.string.login)`) and to extension properties (`button { textResource = R.string.login }`).

Note that the property name is not the same: instead of `text`, `hint`, `image`, we now use `textResource`, `hintResource` and `imageResource`.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>Resource properties always throw <code>KoanException</code> when read.</i>
</td>
</tr>
</table>

#### Colors

Two simple extension functions to make the code more readable.

Function             | Result
---------------------|--------- 
`0xff0000.opaque`    | <span style="color:#ff0000">non-transparent red</span>
`0x99.gray.opaque`   | <span style="color:#999">non-transparent #999999 gray</span>

#### Dimensions

Also, you can specify dimension values in **dip** (density-independent pixels) or in **sp** (scale-independent pixels): `dip(dipValue)` or `sp(spValue)`. Note that the `textSize` property already accepts **sp** (`textSize = 16f`). Use `px2dip` and `px2sp` to convert backwards.

### Instance shorthands

Sometimes you need to pass a `Context` instance to some Android SDK method from your `Activity` code. Usually you can just use `this`, but what if you're inside the inner class? You would probably write `SomeActivity.this` in case of Java and `this@SomeActivity` if you're writing in Kotlin.

With Koan you can just write `ctx`. It is an extension property which works both inside `Activity` and `Service` and is even accessible from `Fragment` (it uses `getActivity()` method under the hood). You can also get an `Activity` instance using `act` extension property.

### UI wrapper

Before the Beginning of Time Koan always used `UI` tag as a top-level DSL element:

```kotlin
UI {
  editText {
    hint = "Name"
  }
}
```

You can still use this tag if you want. And it would be much easier to extend DSL as you have to declare only one `ViewManager.customView` function. See [Extending Koan](#extending-koan) for more information.

### Include tag

It is easy to insert an XML layout into DSL. Use the `include` tag:

```kotlin
include<View>(R.layout.something) {
  backgroundColor = Color.RED
}.layoutParams(width = matchParent) { margin = dip(12) }
```

You can use `layoutParams` as usual, and if you provide a specific type instead of `View`, you could also use this type inside `{}`:

```kotlin
include<TextView>(R.layout.textfield) {
  text = "Hello, world!"
}
```

### Styles

Koan supports styling: `style` is simply a function that accepts `View`, is applied for the `View` itself, and then recursively to each child of a `View` if it is a `ViewGroup`:

```kotlin
verticalLayout {
  editText {
    hint = "Name"
  }
  editText {
    hint = "Password"
  }
}.style { view -> when(view) {
  is EditText -> v.textSize = 20f
}}
```
