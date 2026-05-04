# AI Planning Session — Stack Selection

**Огноо:** 2025-05-04  
**Зорилго:** Mini Library-д тохирох stack сонгох

---

## Хийсэн зүйл
Claude-тай 3 stack харьцуулсан:
- Spring Boot + PostgreSQL
- Node.js + Express + PostgreSQL
- Django + PostgreSQL

## Гол шийдвэр
**Spring Boot сонгосон** — JPA entity relationship,
layered architecture, JUnit 5 тест бичихэд хамгийн тохиромжтой.

## AI санал болгосон зүйлс
- FetchType.EAGER ашиглахгүй байхыг анхааруулсан (N+1 проблем)
- DTO pattern заавал хэрэглэхийг зөвлөсөн
- CLAUDE.md-д no-go zones нэмэхийг санал болгосон

## Өөрөө шийдсэн зүйлс
- Spring Boot-г эцэст нь өөрөө баталгаажуулсан
- CLAUDE.md-ийн AI Collaboration Rules хэсгийг өөрөө нэмсэн