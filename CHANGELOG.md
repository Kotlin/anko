Change Log
==========

Version 0.7.2 *(2015-10-22)*
----------------------------

Built for Kotlin **Beta Candidate**.

Version 0.7.1 *(2015-10-01)*
----------------------------

Built for Kotlin M14 (0.14.449).

Changes:

 * [Pull 86](https://github.com/JetBrains/anko/pull/86) Allow getting MenuItems as a Sequence;
 * findOptional<T>();
 * An exception in DSL Preview plugin is fixed (Android Studio 1.4).

Version 0.7 *(2015-09-17)*
----------------------------

Built for Kotlin M13 (0.13.1513).

Changes:

 * Anko is now split to several components:
    * `anko-common` contains some basic helpers (such as `async`, `toast` or SQLite parsers). Does not contain any of view DSL);
    * `anko-sdk15` (also `19`, `21`, `23`) contains DSL bindings for the corresponding Android SDK version;
    * `anko-support-v4`, `anko-appcompat-v7` and others: additional DSL bindings for the Android support library widgets.
 * [Issue 78](https://github.com/JetBrains/anko/issues/78) New async;
 * Most of extension properties for Views are removed (Kotlin now supports this seamlessly);
 * [Issue 74](https://github.com/JetBrains/anko/issues/74) Ability to iterate children views lazily using sequences;
 * [Issue 77](https://github.com/JetBrains/anko/issues/77) Extension functions for the optimized Android collections and arrays;
 * `layoutParams()` is renamed to `lparams()` (due to the clash with `View.getLayoutParams()`).

Version 0.6.3 *(2015-07-10)*
----------------------------

Built for Kotlin M12.1 (0.12.613).

Changes:

 * Tinted (appcompat) widget support;
 * Deprecated extension properties for `RSSurfaceView`, `RSTextureView`, `WebView` are removed;
 * Intentions for `Toast.makeText().show()` and `findViewById()` in IDEA plugin.

Bugfixes:

 * [Issue 54](https://github.com/JetBrains/anko/issues/54) Fix LayoutParams resolving for some widgets;
 * [Issue 60](https://github.com/JetBrains/anko/issues/60) Support more types in `intentFor`;
 * [Issue 65](https://github.com/JetBrains/anko/issues/65) `AnkoLogger` can't now be used as a delegate;
 * `InterfaceWorkarounds` fields are fixed.

Other:

 * DSL Preview plugin is updated to Robolectric 3.0 rc3;
 * DSL generator refactoring.

Version 0.6.2 *(2015-05-29)*
----------------------------

Built for Kotlin M12 (0.12.200).

Changes:

 * Sensible listener argument names;
 * Some listener arguments and properties are now not-null;
 * `bundleOf()` function;
 * `getBuilder()` in `AlertDialogBuilder`;
 * [Pull 42](https://github.com/JetBrains/anko/pull/42) `startService()` function;

Bugfixes:

 * [Pull 46](https://github.com/JetBrains/anko/pull/46) `IllegalArgumentException` in `AnkoLogger`;
 * [Pull 44](https://github.com/JetBrains/anko/pull/44) Wrong return type for `include()`;
 * [Pull 42](https://github.com/JetBrains/anko/pull/42) `INTEGER` `SqlType` instead of `INT`;
 * [Issue 31](https://github.com/JetBrains/anko/issues/31) `withArguments()` for `android.support.v4.fragment`;
 * [Issue 45](https://github.com/JetBrains/anko/issues/45) `SingleColumnParser` and `ScalarColumnParser` fixed;
 * [Issue 38](https://github.com/JetBrains/anko/issues/38) `SQLiteDatabase.dropTable()` signature fixed.

Version 0.6.1 *(2015-05-06)*
----------------------------

Built for Kotlin M11 (0.11.91.4).

Bugfixes:

 * [Issue 30](https://github.com/JetBrains/anko/issues/30) Arguments in `intentFor()`
 * [Issue 29](https://github.com/JetBrains/anko/issues/29) `android.support.v4.app.Fragment.withArguments()` function
 * [Issue 26](https://github.com/JetBrains/anko/issues/26) More extension properties (including `emptyView` for `AdapterView`)
 * [Issue 21](https://github.com/JetBrains/anko/issues/21) String resources with `progressDialog()` and `indeterminateProgressDialog()`

Version 0.6 *(2015-04-29)*
----------------------------

Built for Kotlin M11 (0.11.91.2).

 * **Breaking:** package name change (kotlinx.android.anko → org.jetbrains.anko)
 * **Breaking:** [new syntax](https://github.com/JetBrains/anko#listeners) for multi-method listeners
 * Configuration qualifiers supported
 * Custom views creation
 * `appcompat.v7` views and properties supported
 * Top-level DSL functions for simple views are removed
 * `startActivityForResult()`, `dimen()` extension functions
 * `uiThread` property for `Context` and `Fragment`


Version 0.5 *(2015-04-02)*
----------------------------

Built for Koltin M11 (0.11.91.1).

 * Rebranding: Koan → Anko! :sparkles:
 * **Preview plugin** is available for IntelliJ IDEA and Android Studio.