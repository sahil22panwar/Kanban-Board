FROM openjdk:11-jre-slim
EXPOSE 8086
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/kanbanBoard
ADD ./target/KanbanService-0.0.1-SNAPSHOT.jar /usr/src/KanbanService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","KanbanService-0.0.1-SNAPSHOT.jar"]
