# Stage 1: Construiește fișierul JAR
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Creează imaginea finală
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/notification-api-0.0.1-SNAPSHOT.jar notification-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "notification-service.jar"]