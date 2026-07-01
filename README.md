# Insurance Policy Manager

A mini REST API project simulating basic functionality for an insurance company. It has 3 core entities: Customer, Policy, and Claim. A Customer can have multiple Policies, and each Policy can have multiple Claims. The project follows a standard Controller → Service → Repository architecture.

## Live Demo

- Swagger UI (used for testing the API): https://insurance-policy-manager-9xcg.onrender.com/swagger-ui/index.html

> The first request may take 30-60 seconds as the server spins up on the free tier.

## Tech Stack

- Java 17 + Spring Boot 4.0
- Spring Security + JWT (stateless authentication)
- Spring Data JPA + PostgreSQL (Supabase)
- Swagger UI
- Maven

## Authentication

When a user registers, their details are saved in the database with a BCrypt-hashed password. On login, a JWT token is generated and returned to the user. This token must be included in every subsequent request to access any protected endpoint.

## Run Locally
git clone https://github.com/orpheasgeorg/insurance-policy-manager.git

Set environment variables: `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET`
./mvnw spring-boot:run

Open: `http://localhost:8080/swagger-ui/index.html`