# CLAUDE.md — Mini Library Project Guide

## Build & Test Commands
- Install dependencies: `mvn install`
- Build project: `mvn clean package`
- Run tests: `mvn test`
- Run single test: `mvn test -Dtest=BookServiceTest`
- Run application: `mvn spring-boot:run`

## Project Structure
partB/src/
├── main/java/com/library/
│   ├── controller/   # REST endpoints only
│   ├── service/      # All business logic
│   ├── repository/   # JPA interfaces
│   ├── entity/       # DB entities
│   └── dto/          # Request/Response objects
└── test/java/com/library/
└── service/      # Unit tests (JUnit 5 + Mockito)

## Code Style & Conventions
- Language: Java 17+
- Framework: Spring Boot 3.x
- Architecture: Layered (Controller → Service → Repository → Entity)
- Naming:
  - Classes: PascalCase (`BookService`, `LoanRepository`)
  - Variables/Methods: camelCase (`loanDate`, `findByMemberId`)
  - Tables/Columns: snake_case (`book_inventory`, `loan_date`)
  - REST endpoints: kebab-case (`/api/book-inventory`)
- Documentation: Javadoc on all public service methods

## No-Go Zones
- NEVER hardcode database credentials — use `application.properties` + env vars
- DO NOT use `@Data` on Entities — use `@Getter`, `@Setter` separately (JPA proxy issue)
- ALL business logic in Service layer — Controllers only handle HTTP
- DO NOT generate `@OneToMany` with `FetchType.EAGER` — causes N+1 problems
- NEVER expose Entity objects directly from Controllers — always use DTOs
- DO NOT skip input validation — use `@Valid` + Bean Validation annotations
- DO NOT generate SQL with string concatenation — use JPA query methods or `@Query`

## AI Collaboration Rules
- Before generating code, confirm the target layer (Controller / Service / Repository)
- Always run `mvn test` mentally — suggest code only if ≥10 tests would pass
- Flag any dependency added to `pom.xml` for human review (license + security check)
- Do not auto-generate migration scripts — ask first
- When refactoring, preserve existing method signatures unless told otherwise
