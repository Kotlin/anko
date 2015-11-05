Change Log
==========

Version 0.7.2 *(2015-10-22)*
----------------------------

Built for Kotlin **Beta Candidate**.

Version 0.7.1 *(2015-10-01)*
----------------------------

Built for Kotlin M14 (0.14.449).

 * [#86](https://github.com/JetBrains/anko/pull/86) New: Allow getting MenuItems as a Sequence.
 * New: Added `findOptional<T>` for `View`, `Activity` and `Fragment`.
 * Fix: An exception in DSL Preview plugin in Android Studio 1.4.

Version 0.7 *(2015-09-17)*
----------------------------

Built for Kotlin M13 (0.13.1513).

 * Anko is now split to several components:
    * `anko-common` contains some basic helpers (such as `async`, `toast` or SQLite parsers). Does not contain any of view DSL).
    * `anko-sdk15` (also `19`, `21`, `23`) contains DSL bindings for the corresponding Android SDK version.
    * `anko-support-v4`, `anko-appcompat-v7` and others - additional DSL bindings for the Android support library widgets.
 * [#78](https://github.com/JetBrains/anko/issues/78) Changed `async` logic.
 * Most of extension properties for Views are removed because Kotlin now supports this seamlessly.
 * [#74](https://github.com/JetBrains/anko/issues/74) New: Ability to iterate children views lazily using sequences.
 * [#77](https://github.com/JetBrains/anko/issues/77) New: Extension functions for the optimized Android collections and arrays.
 * `layoutParams` property is renamed to `lparams` (due to the clash with `View.getLayoutParams`).

Version 0.6.3 *(2015-07-10)*
----------------------------

Built for Kotlin M12.1 (0.12.613).

 * New: Tinted (appcompat) widgets support.
 * Deprecated extension properties for `RSSurfaceView`, `RSTextureView`, `WebView` are removed.
 * Intentions for `Toast.makeText(...).show()` and `findViewById()` in IDEA plugin.
 * [#54](https://github.com/JetBrains/anko/issues/54) Fix: LayoutParams resolving for some widgets.
 * [#60](https://github.com/JetBrains/anko/issues/60) Support more types in `intentFor`.
 * [#65](https://github.com/JetBrains/anko/issues/65) Fix: `AnkoLogger` can't now be used as a delegate.
 * Fix: `InterfaceWorkarounds` fields.
 * DSL Preview plugin is updated to Robolectric 3.0 rc3.
 * DSL generator refactoring.

Version 0.6.2 *(2015-05-29)*
----------------------------

Built for Kotlin M12 (0.12.200).

 * Sensible listener argument names.
 * Some listener arguments and properties are now not-null.
 * New: Added `bundleOf` function.
 * New: Added `getBuilder` in `AlertDialogBuilder`.
 * [#42](https://github.com/JetBrains/anko/pull/42) New: Added `Context.startService` extension.
 * [#46](https://github.com/JetBrains/anko/pull/46) Fix: `IllegalArgumentException` in `AnkoLogger`.
 * [#44](https://github.com/JetBrains/anko/pull/44) Fix: Wrong return type for `include`.
 * [#42](https://github.com/JetBrains/anko/pull/42) Fix: `INTEGER` `SqlType` instead of `INT`.
 * [#31](https://github.com/JetBrains/anko/issues/31) Fix: Added `withArguments` for `android.support.v4.Fragment`.
 * [#45](https://github.com/JetBrains/anko/issues/45) Fix: `SingleColumnParser` and `ScalarColumnParser`.
 * [#38](https://github.com/JetBrains/anko/issues/38) Fix: `SQLiteDatabase.dropTable` signature.

Version 0.6.1 *(2015-05-06)*
----------------------------

Built for Kotlin M11 (0.11.91.4).

 * [#30](https://github.com/JetBrains/anko/issues/30) Fix: Arguments in `intentFor`.
 * [#29](https://github.com/JetBrains/anko/issues/29) New: `android.support.v4.app.Fragment.withArguments` function.
 * [#26](https://github.com/JetBrains/anko/issues/26) New: More extension properties (including `emptyView` for `AdapterView`).
 * [#21](https://github.com/JetBrains/anko/issues/21) Fix: Supported String resources with `progressDialog` and `indeterminateProgressDialog`.

Version 0.6 *(2015-04-29)*
----------------------------

Built for Kotlin M11 (0.11.91.2).

 * **Breaking:** package name change (kotlinx.android.anko → org.jetbrains.anko).
 * **Breaking:** [new syntax](https://github.com/JetBrains/anko#listeners) for multi-method listeners.
 * New: Supported Configuration qualifiers.
 * New: Custom views creation.
 * New: Supported `appcompat.v7` views and properties.
 * Top-level DSL functions for simple views are removed.
 * New: `startActivityForResult`, `dimen` extension functions.
 * New: `uiThread` property for `Context` and `Fragment`.

Version 0.5 *(2015-04-02)*
----------------------------

Built for Koltin M11 (0.11.91.1).

 * Rebranding: Koan → Anko! :sparkles:
 * **Preview plugin** is available for IntelliJ IDEA and Android Studio.