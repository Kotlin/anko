## Change Log

### Anko 0.10.5 *(2018-04-28)*

- [DSL for ConstraintLayout](https://github.com/Kotlin/anko/wiki/ConstraintLayout)
- Preview plugin compatibility with Android Studio 3.1 C6

### Anko 0.10.3 *(2017-11-22)*

#### Bugfixes
- Anko support plugin compatibility with Kotlin 1.1.60+
- Fix Xml to Dsl converter ([#370](https://github.com/Kotlin/anko/issues/370))
- `lparams` for `CollapsingToolbarLayout`, now returns correct LayoutParams ([#275](https://github.com/Kotlin/anko/issues/275), [#269](https://github.com/Kotlin/anko/issues/269))
- `Context.clipboardManager` now returns new `ClipboardManager` instead of deprecated one ([#180](https://github.com/Kotlin/anko/issues/180))
- Generate layout wrapper for `CardView` ([#269](https://github.com/Kotlin/anko/issues/269), [#357](https://github.com/Kotlin/anko/issues/357))
- Fix ClassParser's Boolean parser when type is Long ([#464](https://github.com/Kotlin/anko/issues/464))

#### Breaking Changes
- Removed Dsl for classes from `android.support.design.internal.*` as they shouldn't be used outside of support library

#### Other Changes
- `TextInputEditText` added to anko-design ([#205](https://github.com/Kotlin/anko/issues/205))
- Anko commons dialog extensions now accept `CharSequence` instead of `String` ([#422](https://github.com/Kotlin/anko/issues/422))
- Add start and end rules to RelativeLayout.LayoutParams extensions ([#497](https://github.com/Kotlin/anko/pull/497))
- Add `allCaps` and `ems` properties to TextView ([#459](https://github.com/Kotlin/anko/pull/459))
- Add snackbar helpers with indefinite duration [(#454](https://github.com/Kotlin/anko/pull/454))
- Allow nullable values in `createIntent` and `startActivity` ([#465](https://github.com/Kotlin/anko/pull/465))
- Add extensions for `View::backgroundColorResource` and `TextView::textColorResource` ([#254](https://github.com/Kotlin/anko/pull/254))
- Return `ComponentName` from `startService` methods ([#435](https://github.com/Kotlin/anko/issues/435))
- Allow alerts to be cancelable ([#405](https://github.com/Kotlin/anko/pull/405))
- Add intent helpers for stopping services ([#509](https://github.com/Kotlin/anko/pull/509))
- Return toast object in toast helper functions ([#512](https://github.com/Kotlin/anko/pull/512))

### Anko 0.10.2 *(2017-10-17)*

- Fixed Anko Support IDE plugin compatibility with Android Studio 3.0 RC1
- `Fragment.indeterminateProgressDialog` now shows indeterminate progress dialog instead of classic ([#487](https://github.com/Kotlin/anko/pull/487))
- Added methods for creating and dropping a index for SQLiteDatabase ([#472](https://github.com/Kotlin/anko/pull/472))

### Anko 0.10.1 *(2017-05-31)*

#### Bugfixes

- Fix assertion in the Anko Support IDE plugin ([#387](https://github.com/Kotlin/anko/issues/387));
- Update `kotlinx.coroutines.android` dependency (the old one fails to resolve in Android Studio 3.0) )[#381](https://github.com/Kotlin/anko/issues/381));
- Fix inconsistency between `hasNext()` and `next()` in `childrenRecursiveSequence()` ([#388](https://github.com/Kotlin/anko/pull/388)).

### Anko 0.10 *(2017-05-17)*

#### 🐧 Notable changes:

- Coroutines and `DslMarker` annotation support;
- Anko Support IDE plugin updated for Android Studio 2.4.

#### Breaking changes:

- `DslMarker` annotation support (calling `lparams()` inside View blocks is finally forbidden);
- DSL listeners moved to `anko-<platformName>-listeners` artifacts (e.g. `anko-sdk25-listeners`);
- View blocks with the `theme` parameter renamed to `themed…()` to avoid disambiguation;
- Removed `AnkoLogger(clazz: KClass<*>)` and `AnkoLogger(obj: Any)`.

#### New API:

- `anko-<platformName>-coroutines` (e.g. `anko-sdk25-coroutines`) artifacts with the new listener helpers with coroutines support;
- `bg()` function that executes code in background (wrapper on top of [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines));
- `AlertBuilder` interface with *core* and *appcompat* implementations. `AlertDialogBuilder` is deprecated;
- `Snackbar` helpers #203;
- `Dialog.find()` method #351;
- `foreach()` extensions for `SparseArray` #255;
- Reified version for `AnkoLogger` (`AnkoLogger<MyClass>()`);
- `isError` and `hasValue` to `AttemptResult`.

#### Other changes:

- Anko Support IDE plugin upated in order to support Android Studio 2.4;
- Added meta-artifact `org.jetbrains.anko:anko`;
- Added *Anko Commons* artifacts for Android support libraries (`anko-support-v4-commons`, `anko-appcompat-v7-commons`) #158;
- New Android SDK target: `sdk-25`;
- Updated Android Support library dependencies;
- `anko-common` artifact renamed to `anko-commons` to reflect the naming changes. `anko-common` is deprecated;
- `ClassParser` now accepts all primitive types #320;
- Synthetic properties (such as `act` or `ctx`) are now `inline`;
- `lparams` functions are now `inline` #338;
- Removed `TextView.enabled` generated property #245;
- Accessing setter-only property values is now forbidden.

#### Bugfixes:

- Fix `NoSuchMethodError` on accessing `act` property from the support Fragment #311;
- Fix compatibility with Proguard #235;
- Require the relative view `id` to be set in `RelativeView` helpers #363.

### Anko 0.10 Beta 2 *(2017-03-22)*

#### Breaking changes:

- DSL listeners moved to `anko-<platformName>-listeners` (e.g. `anko-sdk15-listeners`) artifacts;
- The custom `async()` function introduced in 0.10.0-beta1 was removed (use `async()` from [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines));
- `AnkoLogger(clazz: KClass<*>)` and `AnkoLogger(obj: Any)` functions are removed;

#### Other changes:

- `anko-<platformName>-coroutines` (e.g. `anko-sdk15-coroutines`) artifacts with the new listener helpers with coroutines support;
- `lparams` functions are now `inline` #338;
- `bg()` function that executes code in a background thread and returns `Deferred<T>`;
- `AnkoLogger` now has the reified version: `AnkoLogger<MyClass>()`;

### Anko 0.10 Beta 1 *(2017-03-06)*

**Anko 0.10 requires Kotlin 1.1.**

#### Breaking changes:

- View DSL functions that accept the `theme` parameter are renamed to `themed…()` to avoid disambiguation;
- `DslMarker` support (`lparams` inside the View lambda are now forbidden);

#### Other changes:

- Add `anko-coroutines` artifact with the Kotlin 1.1 coroutines support (`async` / `bg`);
- New Android SDK target: `sdk-25`;
- Android Support library dependencies updated;
- `AlertBuilder` interface with core and app-compat implementations. `AlertDialogBuilder` is deprecated;
- `ClassParser` now accepts all primitive types #320;
- New artifacts: `anko-support-v4-common` and `anko-appcompat-v7-common` (with basic helpers, without the DSL functionality) #158;
- Synthetic properties (such as `act` or `ctx`) are now `inline`;
- `TextView.enabled` generated property is removed #245;
- Accessing setter-only property values is forbidden;
- SAM View listener setter functions are now `inline`;
- Add `isError` and `hasValue` to `AttemptResult`;
- Fix `NoSuchMethodError` on accessing `act` property from the support Fragment #311.

### Anko 0.9.1 *(2016-12-14)*

- Allow to use `AnkoLogger` as an instance #262;
- `FOREIGN_KEY` now returns `Pair<String, SqlType>` #258 #219;
- Fix `SparseArray` as sequence returns list which doesn't match its size #243 #240;
- Allow ManagedSQLiteOpenHelper to accept null for database name #228;
- Fix ProGuard warning (can't find referenced method 'int getThemeResId()' in library class android.view.ContextThemeWrapper). #206;
- Add `LayoutParams.baselineOf()` #213;
- Allow nullable values in `intentFor` #211;
- Migrate Anko build to Gradle.

### Anko 0.9 *(2016-06-07)*

- Update to Kotlin 1.0.2 and IDEA 2016.1 #161 #177;
- Support styles in DSL #16 #143;
- Add KDoc comments for most of Anko utilities #168;
- Rename `async()` to `doAsync()`, `onUiThread()` to `runOnUiThread()` for `Fragment` and `Context`;
- Add `AnkoAsyncContext.onComplete()` #181;
- `uiThread()` now returns `false` if code was not executed;
- Ability to add an exception handler to `doAsync()` #182;
- Add `newTask` parameter to `browse()` #186;
- Add `sendSMS()` #171;
- Add `makeStyle()` #132;
- Add `Activity.contentView` property #157;
- Add `horizontalProgressBar()` #23;
- Add `doFromSdk()` and `doIfSdk()` #118;
- Add `alignStart()` and `alignEnd()` to `RelativeLayout.LayoutParams` extensions;
- `AlertDialogBuilder`: make the `dialog` property public #140;
- Add `okButton()`, `yesButton()`, `cancelButton()`, `noButton()` to `AlertDialogBuilder`;
- Add nullable values to SQLite helpers #154;
- Add `editText()` with input constraints #25;
- Add `attempt()` #182;
- Change semantics of `Intent.clearTask()` and similar functions, now add flags, not set (replace old) #173;
- Rename `forEachReversed` to `forEachReversedByIndex()`;
- Rename `style()` to `applyRecursively()`;
- Allow the database to be pluggable for query builders #187;
- Fix `NOT_NULL` SQL type modifier #175;
- Fix `startActivityForResult` called on wrong object (for Fragments) #76;
- Fix `include` doesn't set LayoutParams from the XML #149;
- `View.backgroundDrawable` is nullable now #169;
- `classParser` has always not accessible constructor #136 #145.

### Anko 0.8.3 *(2016-03-02)*

Built for Kotlin 1.0.

* Remove deprecated `android.support.v4.Fragment.addView()` function.

### Anko 0.8.2 *(2016-02-04)*

Built for Kotlin 1.0 RC.

* `forEachChild()`, `forEachChildWithIndex()`, `firstChild()`, `firstChildOrNull()` are inlined now [#134](https://github.com/Kotlin/anko/pull/134);
* `Int.withAlpha` [#125](https://github.com/Kotlin/anko/pull/125);
* `ContextWrapper` is now supported by `AnkoContext`;
* Anko library size and method count was slightly reduced.

### Anko 0.8.1 *(2015-12-09)*

Built for Koltin Beta 3 (1.0.0-beta-3595).

* SQLite helpers are moved to `anko-sqlite` artifact;
* Fixed "Implicit setContentView in onCreate doesn't work in 0.8" [#114](https://github.com/Kotlin/anko/issues/114);
* Fixed "Anko DSL Preview plugin 0.8 crashes" [#115](https://github.com/Kotlin/anko/issues/115);
* Add intention: `0xffefefef.toInt()` → `0xef.gray.opaque`;
* Add `forEachChild()`, `firstChild()`, `firstChildOrNull()` helpers.

### Anko 0.8 *(2015-12-01)*

Built for Kotlin Beta 2 (1.0.0-beta-2423).

* `AnkoComponent` interface for writing reusable components;
* New DSL preview plugin: much more fast and stable :rocket:;
* Add `TextView.gravity` [#96](https://github.com/JetBrains/anko/issues/96) and `ImageView.imageResource` [#102](https://github.com/JetBrains/anko/issues/102) properties;
* `Cancel` is the default negative button name [#112](https://github.com/JetBrains/anko/issues/112);
* Fix `AnkoLogger.wtf`;
* Remove deprecated `__dslAddView` functions.

### Anko 0.7.3 *(2015-11-02)*

Built for Kotlin **Beta Candidate** (`1.0.0-beta-1103`).

### Anko 0.7.2 *(2015-10-22)*

Built for Kotlin **Beta Candidate**.

### Anko 0.7.1 *(2015-10-01)*

Built for Kotlin M14 (0.14.449).

 * [#86](https://github.com/JetBrains/anko/pull/86) New: Allow getting MenuItems as a Sequence.
 * New: Added `findOptional<T>` for `View`, `Activity` and `Fragment`.
 * Fix: An exception in DSL Preview plugin in Android Studio 1.4.

### Anko 0.7 *(2015-09-17)*

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

### Anko 0.6.3 *(2015-07-10)*

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

### Anko 0.6.2 *(2015-05-29)*

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

### Anko 0.6.1 *(2015-05-06)*

Built for Kotlin M11 (0.11.91.4).

 * [#30](https://github.com/JetBrains/anko/issues/30) Fix: Arguments in `intentFor`.
 * [#29](https://github.com/JetBrains/anko/issues/29) New: `android.support.v4.app.Fragment.withArguments` function.
 * [#26](https://github.com/JetBrains/anko/issues/26) New: More extension properties (including `emptyView` for `AdapterView`).
 * [#21](https://github.com/JetBrains/anko/issues/21) Fix: Supported String resources with `progressDialog` and `indeterminateProgressDialog`.

### Anko 0.6 *(2015-04-29)*

Built for Kotlin M11 (0.11.91.2).

 * **Breaking:** package name change (kotlinx.android.anko → org.jetbrains.anko).
 * **Breaking:** [new syntax](https://github.com/JetBrains/anko#listeners) for multi-method listeners.
 * New: Supported Configuration qualifiers.
 * New: Custom views creation.
 * New: Supported `appcompat.v7` views and properties.
 * Top-level DSL functions for simple views are removed.
 * New: `startActivityForResult`, `dimen` extension functions.
 * New: `uiThread` property for `Context` and `Fragment`.

### Anko 0.5 *(2015-04-02)*

Built for Koltin M11 (0.11.91.1).

 * Rebranding: Koan → Anko! :sparkles:
 * **Preview plugin** is available for IntelliJ IDEA and Android Studio.
