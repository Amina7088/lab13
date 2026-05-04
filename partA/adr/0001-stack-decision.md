# ADR-001: Stack Selection

**Огноо:** 2025-05-04  
**Статус:** Accepted

## Нөхцөл байдал
Mini Library системд Book, Member, Loan entity-үүдийн
хоорондын relationship зохицуулах шаардлагатай.

## Авч үзсэн хувилбарууд
1. Spring Boot + PostgreSQL
2. Node.js + Express + PostgreSQL
3. Django + PostgreSQL

## Шийдвэр
**Spring Boot + PostgreSQL** сонгосон.

## Үндэслэл
- JPA/Hibernate — entity relationship хамгийн цэвэр
- Layered architecture framework-ийн дизайнд суурилсан
- JUnit 5 + Mockito — тест бичихэд хамгийн тохиромжтой

## Үр дагавар
- Java verbose байдлыг хүлээн зөвшөөрнө
- CLAUDE.md-д JPA-тай холбоотой no-go zones тодорхойлсон