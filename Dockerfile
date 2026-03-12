FROM eclipse-temurin:25-jdkmvnw -B -DskipTests clean package

# Make a stable jar name (avoids wildcard selecting wrong jar)
RUN cp target/*.jar app.jar

EXPOSE 8080

CMD ["sh","-c","java -Dserver.port=$PORT -jar app.jar"]
WORKDIR /app

COPY . .

RUN chmod +x mvnw
