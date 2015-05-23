#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy guitarApp
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/guitarApp.war
