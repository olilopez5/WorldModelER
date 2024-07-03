FROM openjdk:17-jdk-slim-buster

WORKDIR /app
COPY ./target/WorldModelER-0.0.1-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "WorldModelER-0.0.1-SNAPSHOT.jar"]