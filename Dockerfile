FROM openjdk:11
EXPOSE 9095
COPY target/devices-service-0.0.1-SNAPSHOT.jar devices-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/devices-service-0.0.1-SNAPSHOT.jar"]
