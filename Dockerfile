FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml
COPY src ./src
RUN mvn clean install


FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/WebTest-0.0.1-SNAPSHOT.jar ./webtest.jar
EXPOSE 8089
CMD ["java", "-jar", "webtest.jar"]