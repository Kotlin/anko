Anko Preview Plugin
===================

Anko Preview plugin is available for IntelliJ IDEA and Android Studio. It allows you to preview Kotlin `Activity` and `Fragment` classes written with Anko directly in the IDE tool window, just as for the traditional XML layouts.

## Using Anko Preview Plugin

### Installing the Plugin

You can download Anko Preview plugin [here](https://plugins.jetbrains.com/update/index?pr=&updateId=19242). It can be installed to both IntelliJ IDEA 14 and Android Studio.

### Preview

Suppose you have this class written with Anko:

```kotlin
public class MyActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		verticalLayout {
			val name = editText()
			button("Say Hello") {
				onClick { toast("Hello, ${name.text}!") }
			}
		}
	}

}
```

Put the cursor somewhere inside the `MyActivity` class declaration, open the *DSL Preview* tool window ("View" → "Tool Windows" → "DSL Preview") and press *Refresh*.

Module make is required, so it could take some time before the image will be actually shown.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i>Some dependencies (around 30 MB) are loaded during the first refresh.</i>
</td>
</tr>
</table>

## XML to DSL Converter

Plugin also supports converting layouts from the XML format to Anko DSL code. Open an XML file and select "Code" → "Convert to Anko DSL". You can also convert several XML layout files simultaneously.

## Known Problems

- support-v7 is not supported yet (see [1446](https://github.com/robolectric/robolectric/issues/1446) in Robolectric project).
- ActionBarSherlock is not supported yet.
