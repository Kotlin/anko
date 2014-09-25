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

* [Reason for existence](#reason-for-existence)
	* [Why DSL?](#why-dsl)
	* [Why not Scaloid?](#why-not-scaloid)
	* [Supporting existing code](#supporting-existing-code)
	* [How does it work?](#how-is-it-work)
	* [Is it extendable?](#is-it-extendable)
* [Understanding Koan](#understanding-koan)
	* [Basics](#basics)
	* [Helper methods](#helper-methods)
	* [Layouts and LayoutParams](#layouts-and-layoutparams)
	* [Listeners](#listeners)
	* [Resources and dimensions](#resources-and-dimensions)
	* [UI tag](#ui-tag)
	* [Styles](#styles)
* Advanced topics
	* Convenient shorthands
	* Asynchronous tasks
	* Dialogs and toasts
	* Easy adapters
	* Intents
	* Working with SQLite

## Reason for existence

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

There is no :tophat: actually, just number of Kotlin [extension functions](http://kotlinlang.org/docs/reference/extensions.html), extension properties and mechanism similar to type-safe builders described [here](http://kotlinlang.org/docs/reference/type-safe-builders.html).

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

## Understanding Koan

If you came from Java world right now and know nothing about Kotlin syntax, you can use [this](http://kotlinlang.org/docs/reference/) reference. Kotlin is easy and similar to Java (but much better), so studying would be easy.

### Basics

Koan doesn't require you to inherit from its classes. Just use standard Activity, Fragment, FragmentActivity or whatever you want.

DSL is loaded in ``onCreate()``:

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

Note this doesn't invoke ``setContentView(R.layout.something)`` explicitly. Koan does this automatically for Activities (and only for them).

``verticalLayout`` (a LinearLayout but already with a ``LinearLayout.VERTICAL`` orientation), ``editText`` and ``button`` are [extension functions](http://kotlinlang.org/docs/reference/extensions.html). Such extension functions exist for almost every View in Android framework, and they work in Activities, Fragments (both default and that from android.support package) and even for Context.

If you have a context instance, you can write DSL like this:

```kotlin
val name = with(myContext) {
  editText {
    hint = "Name"
  }
}
```

Variable ``name`` now has a type of EditText.

``padding``, ``hint`` and ``textSize`` are extension properties. They also exist for most of View properties allowing you to write ``text = "Some text"`` instead of ``setText("Some text")``. If you want pass a String resource instead of String, use ``textResource`` property.

### Helper methods

You probably noticed that ``button`` function in the previous chapter accepts a String parameter. Helper methods exist for some views such as TextView, EditText, Button, ImageView.

If you have nothing to set for the View, you can omit ``{}`` and write just this: ``button("Ok")`` or this: ``button()``.

```kotlin
verticalLayout {
  button("Ok")
  button("Cancel")
}
```

### Layouts and LayoutParams

Position of widgets inside a ViewGroup can be set using LayoutParams. In XML it looks like this:

```xml
<ImageView 
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
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

``margin``, ``horizontalMargin`` and ``verticalMargin`` are convenient helper properties. ``horizontalMargin`` sets both left and right margins, ``verticalMargin`` set top and bottom ones, and ``margin`` sets all for margins simultaneously.

If you use RelativeLayout, ``layoutParams`` are different.

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

### Resources and dimensions

### UI tag

### Styles

