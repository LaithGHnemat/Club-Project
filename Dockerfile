FROM openjdk:17-jdk-alpine

# Define a build argument (optional)
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Set the entrdy point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]

