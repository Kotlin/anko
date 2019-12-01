# Discontinuing Anko

Over the last few months, we have received quite a few questions from our users regarding the future of Anko. So today, we are going to make things clear and officially deprecate the library.

## Why are you deprecating Anko?

Anko was born as a type-safe DSL for building Android layouts. It not only allowed creating layouts in a type-safe way, but it made the layouts more adaptable, dynamic, reusable, and also performant, as there was no need for expensive layout inflation.

During the evolution of Anko, it became clear that not only the layout part of the Android framework could benefit from providing Kotlin extensions. That is why we created Anko Commons, a toolbox of utility functions and classes for different parts of the Android framework.

While Anko was quite popular among Kotlin users, we have to admit that the experience was not 100% perfect. Until recently, Android View APIs were highly optimized for inflation, and sometimes it wasn't possible to set some of the attributes programmatically. As a result, the DSL had to rely on hacks or workarounds. Also, it was non-trivial to emulate the reflective approach of widget loading needed for supporting AppCompat. We didn't have enough resources to fix all corner cases in a timely manner.

However, things have changed substantially during the last few years. Google officially supported Kotlin, and later even made Kotlin the preferred language for Android application development. Thanks to JetPack, an extensive set of libraries, the rough edges of the SDK were smoothed over.

Anko is a successful project, and it has played its role in establishing a better Android developer experience with Kotlin. However, there are modern alternatives today, and we feel it's time to say goodbye to Anko.

## What should I use instead of Anko?

### Layout DSL
- Jetpack Compose. A reactive View DSL for Kotlin, backed by Google.
- Splitties – [Views DSL](https://github.com/LouisCAD/Splitties/tree/master/modules/views-dsl). An extensible View DSL which resembles Anko.
### Generic utilities
- [Android KTX](https://developer.android.com/kotlin/ktx). A set of Kotlin extensions for different purposes, backed by Google.
- [Splitties](https://github.com/LouisCAD/Splitties). A lot of micro-libraries for all occasions.
### SQLite helpers
- [Room](https://developer.android.com/topic/libraries/architecture/room). An annotation-based framework for SQLite database access, backed by Google.
- [SQLDelight](https://github.com/cashapp/sqldelight) A type-safe API generator for SQL queries.

* * *

We would like to thank you for your support throughout these years. If you have any questions, please contact us on Slack or via the forum. You can find the links on our [community overview](https://kotlinlang.org/community/) page.
