#!/bin/bash

clear

echo "Starting the installation of paradox jdbc driver to local repository"
echo "*************************************************************************"

URL="$PWD/Paradox_JDBC30.jar"
GROUP_ID="com.shengtian.paradox"
ARTIFACT_ID="paradox"
VERSION="1.0"
PACKAGING="jar"

# mvn -X install:install-file -Dfile=/Users/nliu/Development/random/tmcs/demo/lib/Paradox_JDBC30.jar -DgroupId=com.paradox -DartifactId=paradox -Dversion=1 -Dpackaging=jar

if [ -z "$1" ]
then
  # install the jar when no parameter passed in the command
  echo "mvn install:install-file -Dfile=$URL -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dpackaging=$PACKAGING"
  mvn install:install-file -Dfile=$URL -DgroupId=$GROUP_ID -DartifactId=$ARTIFACT_ID -Dversion=$VERSION -Dpackaging=$PACKAGING
else 
  echo "not null"
fi


echo "*************************************************************************"
echo "Installation of paradox driver is done"


echo "Add the following maven dependency to your pom.xml file, then you are good to go!"
echo "
<dependency>
  <groupId>com.shengtian.paradox</groupId>
  <artifactId>paradox</artifactId>
  <version>1.0</version>
</dependency>
"