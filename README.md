# 🍔 CodeBurger API

A simple **Fast-Food Restaurant Backend API** built with **Java Spring Boot** and **MongoDB**.
This project simulates a **burger shop ordering system** with menus, ingredients, and order calculations.

---

## ✨ Features

- **Ingredient Management**
  - Store ingredients with category and price
  - Retrieve ingredient list from MongoDB

- **Menu Management**
  - Create menus containing multiple ingredients
  - Each ingredient has a specific amount

- **Menu Price Calculation**
  - Automatically calculates total menu cost from ingredient prices
  - Uses MongoDB aggregation

- **Order API**
  - Accepts menu orders
  - Calculates total order price

- **Swagger API Documentation**
  - Interactive API testing UI

---

## 🛠️ Tech Stack
- **Java 25** – Backend language
- **Spring Boot** – REST API framework
- **MongoDB** – NoSQL database
- **Maven** – Dependency management
- **Swagger** / OpenAPI – API documentation
- **Docker** – Containerized deployment

---

## 📂 Project Structure

```bash
src/main/java/com/codeburger/codeburgerapi

├── controller      # REST API endpoints
├── service         # Business logic
├── repository      # MongoDB repositories
├── entity          # Database models
├── dto             # Request / Response objects
└── CodeBurgerApiApplication.java
```

---

## 🚀 Getting Started

### 1️⃣ Clone the repository
```bash
git clone https://github.com/nnewtrp/CodeBurgerApi.git
cd CodeBurgerApi
```

### 2️⃣ Install Dependencies
```bash
./mvnw clean install
```

### 3️⃣ Configure MongoDB
Create `application.properties` inside:
```bash
src/main/resources/
```

Example configuration:
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/codeburger
server.port=5000
server.servlet.contextPath=/api
```

### 4️⃣ Run the Application
```bash
./mvnw spring-boot:run
```

or

```bash
java -jar target/CodeBurgerApi-0.0.1-SNAPSHOT.jar
```

---

## 📖 API Documentation

Swagger UI will be available at:

```bash
http://localhost:5000/api/swagger-ui.html
```

You can test all API endpoints directly from the browser.

---

## 🐳 Docker Deployment

Build the image:
```bash
docker build -t codeburger-api .
```

Run the container:
```bash
docker run -p 5000:5000 codeburger-api
```

---

## ☁️ Cloud Deployment

This project can be deployed on platforms like:
- Railway
- Render
- Amazon Web Services

Example Railway configuration:

Build command:
```bash
./mvnw clean package -DskipTests
```

Start command:
```bash
java -jar target/*.jar
```

---

## 📜 Learn More  

For more information about the technologies used:
- Spring Boot – [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- MongoDB – [https://www.mongodb.com/docs/](https://www.mongodb.com/docs/)
- Swagger / OpenAPI – [https://swagger.io/docs/](https://swagger.io/docs/)
- Docker – [https://docs.docker.com/](https://docs.docker.com/)

---

⭐ If you find this project useful, feel free to **star the repository!**
