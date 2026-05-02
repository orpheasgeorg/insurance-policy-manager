# Insurance Policy Manager
A REST API for managing insurance policies, customers, and claims.

## Technologies
- Java, Spring Boot 3, Spring Data JPA, PostgreSQL, Maven

## How to run
1. Start PostgreSQL
2. Configure `application.properties` with your DB credentials
3. Run `InsurancePolicyManagerApplication.java`

## Endpoints

### Customers
- `POST /api/customers` — Create a new customer

### Policies
- `POST /api/policies` — Create a new policy
- `GET /api/policies` — Get all policies
- `GET /api/policies/{id}` — Get policy by id
- `PATCH /api/policies/{status}/{id}` — Update policy status

### Claims
- `POST /api/claims` — Submit a claim
- `GET /api/claims` — Get all claims
- `GET /api/claims/{customer_id}` — Get claims by customer
