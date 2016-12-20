[ ![Download](https://api.bintray.com/packages/jetbrains/anko/anko/images/download.svg) ](https://bintray.com/jetbrains/anko/anko/_latestVersion)
[![TeamCity (simple build status)](https://img.shields.io/teamcity/http/teamcity.jetbrains.com/s/ProjectsWrittenInKotlin_Anko.svg)](https://teamcity.jetbrains.com/viewType.html?buildTypeId=ProjectsWrittenInKotlin_Anko&tab=buildTypeStatusDiv)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

<img src="doc/logo.png" alt="Anko logo" height="101" width="220" />

Anko is a library which makes Android application development faster and easier. It makes your code clean and easy to read, and lets you forget about rough edges of Android SDK for Java.

Just a brief example. Here is a "hello world" written with Anko:
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

* [Why Anko?](#why-anko)
	* [Why DSL?](#why-dsl)
	* [Supporting existing code](#supporting-existing-code)
	* [How it works](#how-it-works)
	* [Is it extensible?](#is-it-extensible)
	* [Using with Gradle](#using-with-gradle)
	* [Using as Jar library](#using-as-jar-library)
	* [Which Anko libraries are available and which do I need?](#which-anko-libraries-are-available-and-which-do-i-need)
	* [Building Anko](#building-anko)
* [Understanding Anko](#understanding-anko)
	* [Basics](#basics)
	* [Helper methods](#helper-methods)
	* [Layouts and LayoutParams](#layouts-and-layoutparams)
	* [Listeners](#listeners)
	* [Resources, colors and dimensions](#resources-colors-and-dimensions)
	* [Instance shorthands](#instance-shorthands)
	* [UI wrapper](#ui-wrapper)
	* [Include tag](#include-tag)
	* [Styles](#styles)
* [Anko Preview Plugin](doc/PREVIEW.md)
* [Advanced topics](doc/ADVANCED.md)
	* [Intents](doc/ADVANCED.md#intents)
	* [Services](doc/ADVANCED.md#services)
	* [Configuration qualifiers](doc/ADVANCED.md#configuration-qualifiers)
	* [Dialogs and toasts](doc/ADVANCED.md#dialogs-and-toasts)
	* [Asynchronous tasks](doc/ADVANCED.md#asynchronous-tasks)
	* [Logging](doc/ADVANCED.md#logging)
	* [Using SQLite](doc/ADVANCED.md#using-sqlite)
	* [Extending Anko](doc/ADVANCED.md#extending-anko)
* [Using SQLite](doc/SQLITE.md)

## Why Anko?

### Why DSL?

By default, UI in Android is written using XML. That is inconvenient in the following ways:

* It is not typesafe
* It is not null-safe
* It forces you to write almost *the same code* for every layout you make
* XML is parsed on the device wasting CPU time and battery
* Most of all, it allows no code reuse.

While you can create UI programmatically, it's hardly done because it's somewhat ugly and hard to maintain. Here's a plain Kotlin version (one in Java is even longer):

```kotlin
val act = this
val layout = LinearLayout(act)
layout.orientation = LinearLayout.VERTICAL
val name = EditText(act)
val button = Button(act)
button.text = "Say Hello"
button.setOnClickListener {
    Toast.makeText(act, "Hello, ${name.text}!", Toast.LENGTH_SHORT).show()
}
layout.addView(name)
layout.addView(button)
```

A DSL makes the same logic easy to read, easy to write and there is no runtime overhead. Here it is again:

```kotlin
verticalLayout {
    val name = editText()
    button("Say Hello") {
        onClick { toast("Hello, ${name.text}!") }
    }
}
```

### Supporting existing code

You don't have to rewrite all your UI with Anko. You can keep your old classes written in Java.
Moreover, if you still want (or have) to write a Kotlin activity class and inflate an XML layout for some reason, you can use View properties, which would make things easier:

```kotlin
// Same as findViewById(), simpler to use
val name = find<TextView>(R.id.name)
name.hint = "Enter your name"
name.onClick { /*do something*/ }
```

You can make your code even more compact by using [Kotlin Android Extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html).

### How it works

There is no :tophat:. Anko consists of some Kotlin [extension functions and properties](http://kotlinlang.org/docs/reference/extensions.html) arranged into *type-safe builders*, as described [under Type Safe Builders](http://kotlinlang.org/docs/reference/type-safe-builders.html).

Since it's somewhat tedious to write all these extensions by hand, they're generated automatically using *android.jar* files from Android SDK as sources.

### Is it extensible?

Short answer: **yes**.

For example, you might want to use a `MapView` in the DSL. Then just write this in any Kotlin file from where you could import it:
```kotlin
public inline fun ViewManager.mapView(theme: Int = 0) = mapView(theme) {}
public inline fun ViewManager.mapView(theme: Int = 0, init: MapView.() -> Unit) = ankoView({ MapView(it) }, theme, init)
```

``{ MapView(it) }`` is a factory function for your custom `View`. It accepts a `Context` instance.

So now you can write this:

```kotlin
frameLayout {
    val mapView = mapView().lparams(width = matchParent)
}
```

Also see [Extending Anko](doc/ADVANCED.md#extending-anko) if you need to create top-level DSL views.

### Using with Gradle

There's a [template project](https://github.com/yanex/anko-template-project) showing how to include Anko library into your Android Gradle project.

Basically, all you have to do is to add an additional repository and a compile dependency:

```gradle
dependencies {
    compile 'org.jetbrains.anko:anko-sdk15:0.9' // sdk19, sdk21, sdk23 are also available
    compile 'org.jetbrains.anko:anko-support-v4:0.9' // In case you need support-v4 bindings
    compile 'org.jetbrains.anko:anko-appcompat-v7:0.9' // For appcompat-v7 bindings
}
```

### Using as Jar library

If your project is not based on Gradle, just attach jars from the [releases page](https://github.com/JetBrains/anko/releases) or from the [jcenter repository](https://jcenter.bintray.com/org/jetbrains/anko/) as project library dependencies and that's it.

### Which Anko libraries are available and which do I need?

If you don't need the DSL features of Anko, you can just reference `org.jetbrains.anko:anko-common`, and that's all you have to do.

If you need the DSL features of Anko, you need to reference different libraries.

First, you need to reference a main library based on which `minSdkVersion` you target.
`anko-common` is referenced by those libraries, so you don't need to specify it yourself.
Here are the available libraries:
* `org.jetbrains.anko:anko-sdk15` for 15 <= `minSdkVersion` < 19
* `org.jetbrains.anko:anko-sdk19` for 19 <= `minSdkVersion` < 21
* `org.jetbrains.anko:anko-sdk21` for 21 <= `minSdkVersion` < 23
* `org.jetbrains.anko:anko-sdk23` for 23 <= `minSdkVersion`

Then, for any Android Support library you referenced in your `build.gradle`, you need to add the matching Anko library, if you want some more Anko magic for those specific Android Support libraries. Here are all available Anko Android Support libraries:
* `org.jetbrains.anko:anko-support-v4`
* `org.jetbrains.anko:anko-appcompat-v7`
* `org.jetbrains.anko:anko-cardview-v7`
* `org.jetbrains.anko:anko-gridlayout-v7`
* `org.jetbrains.anko:anko-recyclerview-v7`
* `org.jetbrains.anko:anko-design`
* `org.jetbrains.anko:anko-percent`

Here is an example:
````gradle
android {
    ...
    defaultConfig {
        ...
        minSdkVersion 15 // Min SDK version is 15 in this example
        targetSdkVersion 23
        ...
    }
    ...
}

dependencies {
    ...
    // Note the used support libs
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.android.support:design:23.1.1'
    compile 'com.android.support:recyclerview-v7:23.1.1'

    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin-version"
    compile "org.jetbrains.anko:anko-sdk15:$anko-version" // So here it's 15 too

    // Anko libs matching support libs
    compile "org.jetbrains.anko:anko-appcompat-v7:$anko-version"
    compile "org.jetbrains.anko:anko-design:$anko-version"
    compile "org.jetbrains.anko:anko-recyclerview-v7:$anko-version"
}
````

### Building Anko

Instructions for building Anko are located [under Building](doc/BUILDING.md).

## Understanding Anko

As mentioned above, Anko is written in Kotlin. 
In case you are not familiar with Kotlin, please refer to [kotlinlang.org](http://kotlinlang.org/docs/reference/). 
Kotlin is similar enough to Java, so learning it will be easy.

### Basics

In Anko, you don't need to inherit from any special classes: just use standard `Activity`, `Fragment`, `FragmentActivity` or whatever you want.

First of all, import `org.jetbrains.anko.*` to use Anko DSL in your classes.

DSL is available in `onCreate()`:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
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
<i>There's no explicit call to <code>setContentView(R.layout.something)</code>: Anko sets content views automatically for <code>Activities</code> (and only for them).</i>
</td>
</tr>
</table>

`hint` and `textSize` are [synthetic extension properties](https://kotlinlang.org/docs/reference/java-interop.html#getters-and-setters) bound to JavaBean-style getters and setters, `padding` is an [extension property](http://kotlinlang.org/docs/reference/extensions.html#extension-properties) from Anko. Either of these exists for most `View` properties allowing
you to write `text = "Some text"` instead of `setText("Some text")`.

`verticalLayout` (a `LinearLayout` but already with a `LinearLayout.VERTICAL` orientation), `editText` and `button` are
[extension functions](http://kotlinlang.org/docs/reference/extensions.html). Such functions also exist for almost every `View` in Android
framework, and they work in `Activities`, `Fragments` (both default and that from `android.support` package) and even for `Context`.

If you have a `Context` instance, you can write DSL constructs like this:

```kotlin
val name: EditText = with(myContext) {
    editText {
        hint = "Name"
    }
}
```

### AnkoComponent

Although you can use the DSL directly (in `onCreate()` or everywhere else), without creating any extra classes, it is often convenient to have UI in the separate class. If you use the provided `AnkoComponent` interface, you also you get a DSL [layout preview](doc/PREVIEW.md) feature for free.

```kotlin
class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        MyActivityUI().setContentView(this)
    }
}

class MyActivityUI : AnkoComponent<MyActivity> {
    override fun createView(ui: AnkoContext<MyActivity>) = with(ui) {
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }
}
```

### Helper methods

As you probably noticed earlier, the `button()` function in the previous section accepts a `String` parameter. Such helper methods exist for some views such
as `TextView`, `EditText`, `Button` or `ImageView`.

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
    android:layout_marginLeft="5dip"
    android:layout_marginTop="10dip"
    android:src="@drawable/something" />
```

In Anko, you specify `LayoutParams` right after a `View` description using `lparams()`:

```kotlin
linearLayout {
    button("Login") {
        textSize = 26f
    }.lparams(width = wrapContent) {
        horizontalMargin = dip(5)
        topMargin = dip(10)
    }
}
```

If you specify `lparams()`, but omit `width` and/or `height`, their default values are both `WRAP_CONTENT`. But you always can pass them explicitly: use [named arguments](http://kotlinlang.org/docs/reference/functions.html#named-arguments).

Some convenient helper properties to notice:

- `horizontalMargin` sets both left and right margins, 
- `verticalMargin` set top and bottom ones, and 
- `margin` sets all four margins simultaneously.

Note that `lparams()` are different for different layouts, for example, in the case of `RelativeLayout`:

```kotlin
val ID_OK = 1

relativeLayout {
    button("Ok") {
        id = ID_OK
    }.lparams { alignParentTop() }
  
    button("Cancel").lparams { below(ID_OK) }
}
```

### Listeners

You can set listeners from Anko code:

```kotlin
button("Login") {
    onClick {
        login(name, password)
    }
}
```

It would be the same as this:

```kotlin
button.setOnClickListener(object : OnClickListener {
    override fun onClick(v: View) {
        login(name, password)
    }
})
```

Anko is very helpful when you have listeners with lots of methods. Consider the following code written without using Anko:

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

And now with Anko:

```kotlin
seekBar {
    onSeekBarChangeListener {
        onProgressChanged { seekBar, progress, fromUser ->
            // Something
        }
    }
}
```

If you set `onProgressChanged()` and `onStartTrackingTouch()` for the same `View`, these two "partially defined" listeners will be merged. For the same listener method, last wins.

### Resources, Colors and Dimensions

#### Using resource identifiers

All examples in the previous chapters used raw Java strings, but it is hardly a good practice. Typically you put all your string data into `res/values/` directory and access it at runtime calling, for example, `getString(R.string.login)`.

Fortunately, in Anko you can pass resource identifiers both to helper methods (`button(R.string.login)`) and to extension properties (`button { textResource = R.string.login }`).

Note that the property name is not the same: instead of `text`, `hint`, `image`, we now use `textResource`, `hintResource` and `imageResource`.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>Resource properties always throw <code>AnkoException</code> when read.</i>
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

You can specify dimension values in **dip** (density-independent pixels) or in **sp** (scale-independent pixels): `dip(dipValue)` or `sp(spValue)`. Note that the `textSize`
property already accepts **sp** (`textSize = 16f`). Use `px2dip` and `px2sp` to convert backwards.

### Instance shorthands

Sometimes you need to pass a `Context` instance to some Android SDK method from your `Activity` code.
Usually you can just use `this`, but what if you're inside the inner class? You would probably write `SomeActivity.this` in case of Java
and `this@SomeActivity` if you're writing in Kotlin.

With Anko you can just write `ctx`. It is an extension property which works both inside `Activity` and `Service` and is even
accessible from `Fragment` (it uses `getActivity()` method under the hood). You can also get an `Activity` instance using `act` extension property.

### UI wrapper

Before the Beginning of Time Anko always used `UI` tag as a top-level DSL element:

```kotlin
UI {
    editText {
        hint = "Name"
    }
}
```

You can still use this tag if you want. And it would be much easier to extend DSL as you have to declare only one `ViewManager.customView` function.
See [Extending Anko](doc/ADVANCED.md#extending-anko) for more information.

### Include tag

It is easy to insert an XML layout into DSL. Use the `include()` function:

```kotlin
include<View>(R.layout.something) {
    backgroundColor = Color.RED
}.lparams(width = matchParent) { margin = dip(12) }
```

You can use `lparams()` as usual, and if you provide a specific type instead of `View`, you can also use this type inside `{}`:

```kotlin
include<TextView>(R.layout.textfield) {
    text = "Hello, world!"
}
```

### Styles

Anko supports styling: `applyRecursively()` is simply a function that accepts `View`, is applied for the `View` itself, and then recursively to each child of a `View` if it is a `ViewGroup`:

```kotlin
verticalLayout {
    editText {
        hint = "Name"
    }
    editText {
        hint = "Password"
    }
}.applyRecursively { view -> when(view) {
    is EditText -> view.textSize = 20f
}}
```
