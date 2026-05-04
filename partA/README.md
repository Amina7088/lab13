# Mini Library System

REST API for managing books, members, and loans.

## Build & Run
```bash
mvn clean package
mvn spring-boot:run
```

## Test
```bash
mvn test
```

## Structure
- `partA/` — Planning docs
- `partB/` — Source code & tests
- `partC/` — Reflection

## API Endpoints (draft)
- `GET/POST /api/books`
- `GET/POST /api/members`  
- `POST /api/loans` — зээл авах
- `PUT /api/loans/{id}/return` — буцаах