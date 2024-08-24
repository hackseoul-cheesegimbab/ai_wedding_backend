# 1. Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# 2. Set the working directory in the container
WORKDIR /app

# 3. Copy Gradle Wrapper, Gradle files, and source code
COPY gradlew /app/
COPY gradle /app/gradle
COPY build.gradle settings.gradle /app/
COPY src /app/src

# 4. Set up the Gradle user home (caching dependencies)
ENV GRADLE_USER_HOME /cache

# 5. Download dependencies (this will cache the dependencies)
RUN ./gradlew --no-daemon build --stacktrace || return 0

# 6. Build the application
RUN ./gradlew --no-daemon bootJar

# 7. Expose the port the app runs on
EXPOSE 8080

# 8. Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/build/libs/aiwedding-0.0.1-SNAPSHOT.jar"]
