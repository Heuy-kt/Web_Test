FROM maven:maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:21-jdk-slim
COPY --from=build /target/WebTest-0.0.1-SNAPSHOT.jar WebTest.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "WebTest.jar"]
