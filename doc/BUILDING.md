Building Anko
===========

Required tools:

* JDK 1.6
* Android SDK (with platforms 15, 19, 21 installed)
* IntelliJ IDEA 14.0+
* Maven
* Gradle

***

**1.** Firstly, make a clone of Anko repository:

```bash
git clone git://github.com/JetBrains/anko.git && cd anko
```

**2.** Then get all required dependencies (this could take several minutes):

```bash
ant -f update_dependencies.xml
ant -f download_android_sdk.xml
```

**3.** Now it's time to open Anko project in IntelliJ IDEA (both Community and Ultimate editions are ok).

Execute a run configuration named `Collect android.jar` and then `Generate`.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i><code>ANDROID_HOME</code> variable must be set before launching <code>Collect android.jar</code>.</i>
</td>
</tr>
</table>

**4.** After doing this a number of directories with generated sources must be present in `workdir/gen` directory.

**5.** You can build them all together by launching `build_artifacts.xml` Ant script. Script creates a zip file with artifact for each Android SDK version in `workdir/gen/zip` directory.