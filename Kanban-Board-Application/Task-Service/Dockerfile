#g
FROM openjdk
#inside the image
WORKDIR usr/lib
#
#
ENV MONGO_DATABASE=taskService
ENV MONGO_URL=mongodb://localhost:27017/taskService
#
#
ADD ./target/Task-Service-0.0.1-SNAPSHOT.jar /usr/lib/Task-Service-0.0.1-SNAPSHOT.jar
#run the jar
ENTRYPOINT ["java","-jar","Task-Service-0.0.1-SNAPSHOT.jar"]