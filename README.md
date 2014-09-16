Kōan
===========

```
Both this page and Koan are in deep conctruction now.
It should be completed in a week. Stay tuned!
```

Koan is a library for [Kotlin](http://kotlinlang.org) which makes Android application development faster and easier. It allows to write clean and readable code, and lets you forget about sharp angles of Android SDK for Java.

Just a brief example. Here is a "hello world" written with Koan.
```kotlin
verticalLayout {
  val name = editText()
  button {
    text = "Say Hello"
    onClick { toast("Hello, ${name.text}!") }
  }
}
```

## Contents

* Reason for existence
	* [Why DSL?](#why-dsl)
	* [Why not Scaloid?](#why-not-scaloid)
	* [Supporting existing code](#supporting-existing-code)
	* [How does it work?](#how-is-it-work)
	* [Is it extendable?](#is-it-extendable)
* Understanding Koan
	* Basics
	* Helper "constructors"
	* Layouts and LayoutParams
	* Listeners
	* Resources and dimensions
	* UI tag
	* Styles
* Advanced topics
	* Convenient shorthands
	* Asynchronous tasks
	* Dialogs and toasts
	* Easy adapters
	* Intents
	* Working with SQLite

### Why DSL?

By default, UI in Android is written in XML. That is incredibly insane, and that's why:

* It is not typesafe;
* And not null-safe;
* It forces you to write *the same code* for every layout;
* XML is parsed on runtime wasting CPU time;
* Above all, it allows almost no code reusing.

Well, you can create UI programmatically but nobody does that because it looks ugly and extremely hard to maintain:
```kotlin
val act = this
val layout = LinearLayout(act)
layout.setOrientation(LinearLayout.VERTICAL)
val name = EditText(act)
val button = Button(act)
button.setText("Say Hello")
button.setOnClickListener(object: View.OnClickListener {
  override fun onClick(v: View) {
    Toast.makeText(act, "Hello, ${name.getText()}!", Toast.LENGTH_SHORT).show()  
  }
})
layout.addView(name)
layout.addView(button)
```

Here comes DSL. It is easy to read, easy to write and there're actually no runtime overhead. Just try it!

### Why not Scaloid?

[Scaloid](https://github.com/pocorall/scaloid) is a similar library for Scala, with lots of interesting stuff.
But Android and Scala are not good friends: Scala compiler is dreadfully slow, Android sbt plugin is full of bugs, and because Scala library is huge you have to use tools like ProGuard even when debugging.
Finally, Scaloid manages a subclass for every single View, so it is not really easy to make new DSL entries for your own Views. Also, this consumes lots of memory without a particular reason.

### Supporting existing code

You don't have to rewrite all your UI into Koan DSL. Moreover, you can keep your old Activity classes written in Java.
But if you want to write a Kotlin activity class and inflate a layout from XML, you still can use View properties, which would make your life better:

```kotlin
//Same as findViewById(), simpler to use
val name = find<TextView>(R.id.name)
name.hint = "Enter your name"
name.onClick { /*do something*/ }
```

### How does it work?

There is no :tophat: actually, just number of Kotlin [extension methods](http://kotlinlang.org/docs/reference/extensions.html), extension properties and mechanism similar to type-safe builders described [here](http://kotlinlang.org/docs/reference/type-safe-builders.html).

### Is it extendable?

Short answer: **yes**.

For example, you want to be able to use a MapView in DSL. Then just write this in any Kotlin file from where you could import it:
```kotlin
fun ViewManager.mapView(init: MapView.() -> Unit = {}) =
  __dslAddView({MapView(it)}, init, this)
```

``{MapView(it)}`` is a builder function for your custom View. It accepts a Context instance.

So from now you can write this:
```kotlin
frameLayout {
  val mapView = mapView().layoutParams(width = matchParent)
}
```