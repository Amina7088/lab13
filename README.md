# Бие даалт 13 — AI-Assisted Software Construction

## Оюутан
МХТС — F.CSM311 Программ хангамжийн бүтээлт

## Сонгосон сэдэв
Mini Library System — номын сан удирдах REST API

## Бүтэц
- `partA/` — Төлөвлөлт (stack, архитектур, ADR)
- `partB/` — Хэрэгжилт (Spring Boot + H2)
- `partC/` — Эргэцүүлэл (AI usage report)

## Хэрэгсэл
- Claude (Anthropic) — AI assistant
- Java 17, Spring Boot 3.2.0
- H2 in-memory database
- JUnit 5 + Mockito

## Хурдан эхлүүлэх
```bash
cd partB
mvn spring-boot:run
```

API: http://localhost:8080

## API Test Example

### 1. Ном нэмэх (H2 Console-р)
H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:librarydb

```sql
INSERT INTO BOOK_INVENTORY (title, author, isbn, available) 
VALUES ('Clean Code', 'Robert Martin', '978-0132350884', true);
```
<img width="1163" height="509" alt="image" src="https://github.com/user-attachments/assets/394497b4-9b94-464e-8774-ee3d038a53ff" />


### 2. Номын жагсаалт харах
GET http://localhost:8080/api/books

Хариу:
```json
[{"id":1,"title":"Clean Code","author":"Robert Martin","isbn":"978-0132350884","available":true}]
```
<img width="1083" height="353" alt="image" src="https://github.com/user-attachments/assets/9de46568-7935-4156-84fa-ad207a4c9ece" />
