# Mini Library System — Build & Run Guide

REST API for managing books, members, and loans.

## Tech Stack
- Java 17
- Spring Boot 3.2.0
- H2 in-memory database
- JUnit 5 + Mockito

## Build
```bash
mvn clean package
```

## Run
```bash
mvn spring-boot:run
```

App starts at: http://localhost:8080

## Test
```bash
mvn test
```

11 tests, all passing.

## API Endpoints

### Books
- GET    /api/books
- GET    /api/books/{id}
- POST   /api/books
- PUT    /api/books/{id}
- DELETE /api/books/{id}

### Members
- GET    /api/members
- GET    /api/members/{id}
- POST   /api/members
- PUT    /api/members/{id}
- DELETE /api/members/{id}

### Loans
- POST   /api/loans
- PUT    /api/loans/{id}/return
- GET    /api/loans/overdue
- GET    /api/loans/member/{memberId}

## Project Structure