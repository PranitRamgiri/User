# User Service Application

User Service is a **Spring Boot RESTful application** responsible for **user registration (signup)** and **user
authentication (login)**.  
It follows clean Spring Boot layered architecture.

---

## 📌 Overview

This service exposes REST APIs to:

- Create new users
- Authenticate existing users
- Handle errors consistently using global exception handling

The application is built using Spring Boot and follows industry best practices such as:

- Controller → Service → Repository layering
- DTO-based request/response handling
- Centralized exception management

---

## 🚀 Features

- User Signup API
- User Login API
- RESTful architecture
- Global exception handling
- JSON request & response
- Clean and maintainable code structure
- Easily extensible for security and microservices integration

---

## 🛠 Tech Stack

- **Java** 17+
- **Spring Boot** - 3.5.10
- **Spring Web (REST)**
- **Spring Data JPA**
- **Maven**
- **PostgreSQL / H2 Database**

---

## 📂 Project Structure

Diagram of the project structure:

```html
📂 Project Structure

User
│
├── controller
│   └── UserController.java
│
├── service
│   ├── UserService.java
│   └── UserServiceImpl.java
│
├── repository
│   └── UserRepository.java
│
├── entity
│   └── User.java
│
├── dto
│   ├── SignupRequest.java
│   ├── LoginRequest.java
│   ├── UserResponse.java
│   └── ErrorResponse.java
│
├── exception
│   ├── UserException.java
│   └── GlobalExceptionHandler.java
│
├── constants
│   └── UserConstants.java
│
├── UserServiceApplication.java
│
└── resources
├── application.properties
└── messages.properties


### 📌 Package Description

- controller – REST controllers exposing API endpoints
- service – Business logic interfaces and implementations
- repository – Data access layer using Spring Data JPA
- entity – JPA entity classes mapped to database tables
- dto – Request and response objects for APIs
- exception – Custom exceptions and global exception handling
- constants – Application-wide constant values
- resources – Configuration and message properties


- Current Version: 1.0.0
```

## Features

- REST API for user operations (CRUD)
- JPA / Hibernate for persistence
- Configurable via `src/main/resources/application.properties`

## Prerequisites

- Java JDK 17 or later
- Maven 3.5+
- PostgreSQL database
- (Optional) Docker / Docker Compose

## API Endpoints

1. **User Signup**
    - **Endpoint:** `POST /users/signup`
    - **Request Body:**
      ```json
      {
        "username": "string",
        "password": "string",
        "email": "string"
      }
      ```
    - **Response:**
        - `201 Created` on success

2. **User Login**
    - **Endpoint:** `POST /users/login`
    - **Request Body:**
      ```json
      {
        "emailOrUsername": "string",
        "password": "string"
      }
         ```
    - **Response:**
        - `200 OK` on success

---

## Quick start

1. Clone the repository
    - git clone https://github.com/PranitRamgiri/User.git
    - cd User

2. Configure the database
    - Edit `src/main/resources/application.properties` to point to your PostgreSQL instance (URL, username, password).
    - Ensure the database exists and is reachable.

3. Build the application
    - Using Maven
      ```
      mvn clean package
      ```
    - This will create a JAR file in the `target/` directory.
4. Run
    - Using Maven
      ```
      mvn spring-boot:run
      ```
    - Or run the packaged JAR
      ```
      java -jar target/*.jar
      ```

   The application default server port is `8081` (can be changed in `application.properties` or overridden with
   `-Dserver.port=XXXX`).
5. Use Postman or curl to test the API endpoints.

---

## Developers:

This project is developed and maintained by !404-REST In Peace! group:

- Pranit Ramgiri - [GitHub](https://github.com/PranitRamgiri)
- Sagar Karampuri - [GitHub](https://github.com/sagarkarampuri)
- Sharvari Narale - [GitHub]()
- Akanksha Mirgaonkar - [GitHub]()

---

## Copyright

© 2026 !404-REST In Peace! group. All rights reserved. Copy and use it. If it breaks, you own the bug!.

