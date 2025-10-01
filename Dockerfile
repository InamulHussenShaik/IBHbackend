# Build stage
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
# package app (adjust if you use Gradle)
RUN mvn -B clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# copy the jar built in previous stage (update filename if different)
COPY --from=build /app/target/*.jar app.jar

# optional: expose a default port (Render uses PORT env var at runtime anyway)
EXPOSE 8080

# Use server.port from environment (application.properties above will read $PORT)
ENTRYPOINT ["java","-jar","/app/app.jar"]
