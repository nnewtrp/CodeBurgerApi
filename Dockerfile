# ---------- Build stage ----------
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Copy only Maven wrapper & pom first to leverage Docker layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw -B -DskipTests dependency:go-offline

# Now copy the rest of the source code
COPY src src

# Build jar
RUN ./mvnw -B -DskipTests clean package


# ---------- Run stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Railway injects PORT; your app already uses server.port=${PORT:8080}
EXPOSE 8080

# Optional: better container memory behavior
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0 -XX:+UseContainerSupport"

CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]