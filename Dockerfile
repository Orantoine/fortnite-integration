FROM openjdk:8-jdk-alpine

MAINTAINER antoine.godeau@sfr.fr

VOLUME /tmp
COPY target/*.jar fortnite-integration.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/fortnite-integration.jar"]