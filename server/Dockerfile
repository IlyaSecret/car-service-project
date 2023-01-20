#
# Build stage
#
FROM maven:3.5-jdk-8 AS build
# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package

#
# Package stage
#
FROM openjdk:8
COPY --from=build /app/target/server-0.0.1-SNAPSHOT.jar /usr/local/lib/server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/server.jar"]