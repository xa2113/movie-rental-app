#!/usr/bin/env bash

address="18.216.17.101/MovieRental-1.0-SNAPSHOT"

echo "Deploying to remote tomcat: " $address

#mv ./build/libs/MovieRental-1.0-SNAPSHOT.war ./build/libs/ROOT.war


scp -i ~/Downloads/sotobabikey.pem ./build/libs/MovieRental-1.0-SNAPSHOT.war bitnami@ec2-18-216-17-101.us-east-2.compute.amazonaws.com:/opt/bitnami/apache-tomcat/webapps
