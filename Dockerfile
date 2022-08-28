FROM openjdk:8u191-jre-alpine3.9
WORKDIR /usr/poorna
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs 						libs
ADD testng.xml 							testng.xml
ADD bookflight.xml 							bookflight.xml
ADD healthcheck.sh   healthcheck.sh
RUN apk add curl jq
ENTRYPOINT sh healthcheck.sh
