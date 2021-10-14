FROM openjdk:8-jdk-alpine
EXPOSE 9090
COPY target/docker-devices-service-0.0.1-SNAPSHOT.jar devices-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/devices-service-0.0.1-SNAPSHOT.jar"]