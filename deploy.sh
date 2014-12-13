#!/bin/sh

cd ./gen
for ver in $(ls | grep -E "^[0-9]+s?$")
do
	echo ":: Deploying version $ver"
	cd $ver
	chmod u+x ./gradlew
	./gradlew publishToMavenLocal
	cd ..
done
cd ..