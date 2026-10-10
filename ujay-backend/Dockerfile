# Step 1: build the application
FROM docker.io/library/maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

ARG MAVEN_OPTS=""
ENV MAVEN_OPTS=${MAVEN_OPTS}

COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY src ./src
RUN mvn -q package -DskipTests


# Step 2: run the application
FROM docker.io/library/eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/ujay-backend-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_TOOL_OPTIONS="-Xmx300m"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]