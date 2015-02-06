#!/bin/sh

cd ./gen
mkdir -p zip
for ver in $(ls | grep -E "^[0-9]+s?$")
do
	echo ":: Deploying version $ver"
	cd $ver
	chmod u+x ./gradlew

	./gradlew publish

	cd build/repo
	rm -f org/jetbrains/kotlin/koan-15/maven-metadata.*
	zip -r $ver.zip org
	cp $ver.zip ../../../zip/$ver.zip
	cd ../..

	cd ..
done
cd ..