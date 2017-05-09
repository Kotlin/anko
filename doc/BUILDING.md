Building Anko
===========

Required tools:

* JDK 1.6, 1.8
* IntelliJ IDEA 2016.2+
* Maven
* Gradle

***

**1.** Make a clone of the Anko repository:

```bash
git clone git://github.com/JetBrains/anko.git && cd anko
```

**2.** Fetch the required dependencies (usually takes several minutes):

```bash
ant -f update_dependencies.xml
```

**3.** Build the project using Gradle:

```bash
./gradlew clean dist
```