FROM openjdk:22-jdk-slim as build

WORKDIR /app
COPY . .
RUN ./mvnw clean package

FROM openjdk:22-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/tasks-0.0.1-SNAPSHOT.jar ./tasks.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./tasks.jar"]
