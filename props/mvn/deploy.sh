#!/bin/sh

for ver in $(ls | grep -E "^[0-9]+s?$")
do
	echo ":: Deploying version $ver"
	cd $ver
	./gradlew publishToMavenLocal
	cd ..
done