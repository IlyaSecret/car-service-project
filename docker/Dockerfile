# select parent image
FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

CMD cd ..

#copy the source tree and the pom.xml to our new container
#COPY ./ ./

CMD cd server

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/server-0.0.1-SNAPSHOT.jar /server.jar

#package application code
RUN mvn clean package

# set the startup command to execute the jar
CMD ["java", "-jar", "/server.jar"]
