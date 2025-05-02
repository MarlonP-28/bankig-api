# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper files (if using Gradle)
COPY gradle/ .
COPY gradlew .
COPY gradlew.bat .

# Copy the project's source code
COPY . /app

# Build the application using Gradle (or Maven)
RUN ./gradlew build -x test  #  Or "mvn clean install -DskipTests" for Maven

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "build/libs/banking-api-0.0.1-SNAPSHOT.jar"] # Adjust the jar name as needed