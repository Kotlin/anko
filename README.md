Kōan
===========

```
Both this page and Koan are in deep construction now.
It should be completed in a week. Stay tuned!
```

Koan is a [Kotlin](http://kotlinlang.org) library for Android which makes application development faster and easier. It could make your code clean and easy to read, and lets you forget about sharp angles of Android SDK for Java.

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
	* Intents
  * Dialogs and toasts
  * Asynchronous tasks

## Reason for existence

### Why DSL?

By default, UI in Android is written in XML. That is incredibly insane, and that's why:

* It is not typesafe;
* And not null-safe;
* It forces you to write almost *the same Java code* for every layout you made;
* XML is parsed when displayed wasting CPU time;
* Above all, it allows no code reusing.

Well, you may create UI programmatically but nobody does that because it looks ugly and extremely hard to maintain. Here's the Kotlin version (Java one is even longer).
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

[Scaloid](https://github.com/pocorall/scaloid) is a similar library for Scala, with lots of amusing stuff.
But Android and Scala are not good friends: Scala compiler is dreadfully slow, Android sbt plugin is full of bugs, and because Scala library is enormous you have to use tools such as ProGuard even when debugging your app.
Finally, Scaloid manages a subclass for every single View in Android widget hierarchy so it is not easy to make new DSL entries for your own Views. Also, that consumes lots of memory without a particular reason.

### Supporting existing code

You don't have to rewrite all your UI with Koan. Moreover, you can keep your old classes written in Java.
Moreover, if you want to write a Kotlin activity class and inflate a layout from XML, you still can use View properties, which would make your life better:

```kotlin
//Same as findViewById(), simpler to use
val name = find<TextView>(R.id.name)
name.hint = "Enter your name"
name.onClick { /*do something*/ }
```

### How does it work?

There is no :tophat: actually, just some Kotlin [extension functions](http://kotlinlang.org/docs/reference/extensions.html), extension properties and mechanism similar to type-safe builders described [here](http://kotlinlang.org/docs/reference/type-safe-builders.html).

### Is it extendable?

Short answer: **yes**.

For example, you might want to use a MapView in DSL. Then just write this in any Kotlin file from where you could import it:
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

If you have a context instance, write DSL like this:

```kotlin
val name = with(myContext) {
  editText {
    hint = "Name"
  }
}
```

Variable ``name`` now has a type of EditText.

``padding``, ``hint`` and ``textSize`` are extension properties. They also exist for most of View properties allowing you to write ``text = "Some text"`` instead of ``setText("Some text")``.

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

For RelativeLayout ``layoutParams`` are quite different.

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

You can define listener methods directly in DSL.

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
And this is much more helpful when you have listeners with bunch of methods. The next code is written without using Koan:

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

### Resources and dimensions

All examples in the previous chapters used raw Java strings, but it is not a good practice. Typically you have all your string data into res/values/ directory and access it in runtime calling ``getString(R.string.login)`` or something.

Fortunately, you could both write ``button(R.string.login)`` (a helper method) or ``button { textResource = R.string.login }`` (extension property) in Koan DSL.

Kotlin properties can have only one setter so the property name is quite different. Instead of ``text``, ``hint``, ``image`` write ``textResource``, ``hintResource`` and ``imageResource``. This kind of properties always returns 0 when read.

Also, you can specify dimension values in dip (density-independent pixels) or in sp (scale-independent pixels): `dip(dipValue)` or `sp(spValue)`. Note that textSize property already accepts **sp**. Use ``px2dip`` and ``px2sp`` to convert backwards.

**Warning:** these functions throws an Exception if executed before onCreate(). Do not execute it in class constructor.

### UI tag

Before the Beginning of Time Koan used UI tag as a top-level DSL element:

```kotlin
UI {
  editText {
    hint = "Name"
  }
}
```

You can still use this tag if you want. And it would be much easier to extend DSL as you have to declare only one `ViewManager.customView` extension function.

### Styles

Koan supports styling. Style is simply a function that accepts Any (object base type in Kotlin), and this function is applied for the View itself, and then recursively to each child of a View if it is a ViewGroup.

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

Even if you won't use DSL, Koan still has something to make your life easier. For example, it has Intent call wrappers for some Intents used widely.

Goal                | Solution
--------------------|--------- 
Make a call         | `makeCall(number)` without **tel:**
Browse the web      | `browse(url)`
Share some text     | `share(text, [subject])`
Send a email        | `email(email, [subject], [text])`

Methods return true if intent was sent.

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

#### Toasts

```kotlin
toast("Hi there!")
toast(R.string.message)
longToast("I'm so long")
```

#### Alerts

```kotlin
alert("Oh well", "Have you tried turning it off and on again?") {
  positiveButton("Yes") {toast("Well…")}
  negativeButton("No") {}
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

AsyncTask is a jumbo class. Wait, no, it is sometimes a jumbo<JustOneElementWhichWouldBeConvertedIntoArray, SomethingNotReallyUseful, Result>. It's twice as awful as hell.

There's a way better.

```kotlin
async {
  //long background task
  uiThread {
    result.text = "Completed"
  }
}
```

Also, Koan toasts and dialogs are always executed in main thread, so `uiThread {}` is unneeded:

```kotlin
async {
  //long background task
  toast("Completed!")
}
```

You can even execute tasks using your own ExecutorService:

```kotlin
val executor = Executors.newScheduledThreadPool(4)
async(executor) {
  //some task
}
```