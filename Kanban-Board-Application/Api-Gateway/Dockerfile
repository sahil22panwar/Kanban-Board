FROM openjdk:11-jre-slim
WORKDIR usr/src
EXPOSE 9000
ADD ./target/Api-Gateway-0.0.1-SNAPSHOT.jar /usr/src/Api-Gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Api-Gateway-0.0.1-SNAPSHOT.jar"]