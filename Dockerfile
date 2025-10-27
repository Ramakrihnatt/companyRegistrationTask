# 1️⃣ Use OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src

# 4️⃣ Give execute permission for mvnw
RUN chmod +x mvnw

# 5️⃣ Build the Spring Boot jar
RUN ./mvnw clean package -DskipTests

# 6️⃣ Expose port
EXPOSE 8080

# 7️⃣ Run the Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
