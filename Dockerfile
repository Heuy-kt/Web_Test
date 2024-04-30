# stage 1 BUILDING THE APPLICATION
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


# stage 2 RUNNING THE APPLICATION
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/WebTest-0.0.1-SNAPSHOT.jar webtest.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "webtest.jar"]