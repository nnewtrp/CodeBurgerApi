# ---- Build stage (JDK 25) ----
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Copy Maven wrapper & pom first (better caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw -B -DskipTests dependency:go-offline

# Copy source and build
COPY src src
RUN ./mvnw -B -DskipTests clean package

# ---- Run stage (still JDK 25 as you want) ----
FROM eclipse-temurin:25-jdk
WORKDIR /app

# Copy jar to a stable name
COPY --from=build /app/target/*.jar /app/app.jar

# Railway uses PORT; expose 8080 is fine for documentation, not mandatory
EXPOSE 8080

# Force Spring Boot to bind to Railway's port
CMD ["sh","-c","java -Dserver.port=$PORT -jar /app/app.jar"]