#!/bin/sh

cd workdir
mkdir -p zip
cd gen
for ver in $(ls | grep -E "^[0-9]+s?$")
do
	echo ":: Deploying version $ver"
	cd $ver
	chmod u+x ./gradlew

	./gradlew publish publishToMavenLocal

	cd build/repo
	rm -f org/jetbrains/kotlin/anko-$ver/maven-metadata.*
	zip -r $ver.zip org
	cp $ver.zip ../../../../zip/$ver.zip
	cd ../..

	cd ..
done
cd ../..