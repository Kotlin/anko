Building Anko
===========

Required tools:

* JDK 1.6, 1.8
* IntelliJ IDEA 14.0+
* Maven
* Gradle

***

**1.** Make a clone of the Anko repository:

```bash
git clone git://github.com/JetBrains/anko.git && cd anko
```

**2.** Then fetch the all required dependencies (this usually takes several minutes):

```bash
./gradlew collectDependencies
ant -f update_dependencies.xml
```

**3.** Now it's time to open Anko project in IntelliJ IDEA (both Community and Ultimate editions are ok).

Execute a run configuration named `Collect android.jar` and then `Generate`.

**4.** After doing this a number of directories with generated Kotlin source files should be present in `workdir/gen` directory.

**5.** You can build them all together by running `build_artifacts.xml` Ant script. This script creates a number of zip files with Maven artifacts inside in the `workdir/gen/zip` directory.