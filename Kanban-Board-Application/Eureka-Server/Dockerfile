FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/Eureka-Server-0.0.1-SNAPSHOT.jar /usr/src/Eureka-Server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Eureka-Server-0.0.1-SNAPSHOT.jar"]