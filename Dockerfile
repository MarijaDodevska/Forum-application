FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/forum_app-0.0.1-SNAPSHOT.jar /app/forum_app-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/app/forum_app-0.0.1-SNAPSHOT.jar"]
