FROM node:20-alpine AS frontend
WORKDIR /app
COPY frontend/package.json ./
RUN npm install --cache /root/.npm
COPY frontend/ .
RUN npm run build

FROM gradle:jdk23 AS backend
WORKDIR /app
COPY backend/ .
COPY --from=frontend /app/dist ./src/main/resources/static
RUN ./gradlew clean build -x test

FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=backend /app/build/libs/backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
