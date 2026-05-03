# CLAUDE.md - Mini Library Project Guide

## Build & Test Commands
- Install dependencies: `mvn install`
- Build project: `mvn clean package`
- Run tests: `mvn test`
- Run application: `mvn spring-boot:run`

## Code Style & Conventions
- **Language**: Java 17+
- **Framework**: Spring Boot
- **Architecture**: Layered (Controller -> Service -> Repository -> Entity)
- **Naming**: 
  - Classes: PascalCase (e.g., BookService)
  - Variables/Methods: camelCase (e.g., loanDate)
  - Tables: snake_case (e.g., book_inventory)
- **Documentation**: Use JSDoc style for public methods.

## Project Rules (No-Go Zones)
- NEVER hardcode database credentials.
- DO NOT use `@Data` from Lombok on Entities (use `@Getter`, `@Setter` instead for JPA stability).
- ALL business logic must reside in the Service layer, not in Controllers.
- Ensure all 10+ unit tests pass before suggesting a commit.