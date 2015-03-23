Building Anko
===========

Build instructions described here are for Linux or OS X. If you're building Anko using Windows, some steps may differ.

Required tools:

* Android SDK (with platforms 15, 19, 21 installed)
* IntelliJ IDEA
* Maven
* Gradle

***

**1.** Firstly, make a clone of Anko repository:

```bash
git clone git@github.com:yanex/anko.git && cd anko
```

**2.** Then get all required dependencies (this could take minute or two):

```bash
ant -f update_dependencies.xml
```

**3.** Now it's time to open Anko project in IntelliJ IDEA (14 version is recommended, both Community and Ultimate edition are ok).

Execute a run configuration named `Collect android.jar` and then `Generate`.

<table>
<tr><td width="50px" align="center">:penguin:</td>
<td>
<i><code>ANDROID_HOME</code> variable must be set before launching <code>Collect android.jar</code>.</i>
</td>
</tr>
</table>

**4.** After doing this a number of directories with generated sources must be present in `gen` directory. You can build them all together by launching a `build-jar.sh` script. Script publishes all Anko versions in the local Maven repository and creates a zip files in `gen/zip` directory.