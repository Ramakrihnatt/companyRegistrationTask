# 1️⃣ Use OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy Maven wrapper and build files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 4️⃣ Copy source code
COPY src ./src

# 5️⃣ Give execute permission for mvnw
RUN chmod +x mvnw

# 6️⃣ Package the Spring Boot application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# 7️⃣ Copy the generated jar
COPY target/*.jar app.jar

# 8️⃣ Expose default port (will be overridden by Render or cloud env)
EXPOSE 8080

# 9️⃣ Run Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
