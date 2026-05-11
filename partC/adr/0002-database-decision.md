# ADR-002: H2 Database сонголт

**Огноо:** 2026-05-10
**Статус:** Accepted

## Нөхцөл байдал
PostgreSQL тохируулахад localhost:5432 холболт
татгалзсан. PostgreSQL суулгаагүй байсан.

## Авч үзсэн хувилбарууд
1. PostgreSQL суулгах
2. H2 in-memory database ашиглах
3. SQLite ашиглах

## Шийдвэр
**H2 in-memory database** сонгосон.

## Үндэслэл
- Суулгах шаардлагагүй — dependency нэмэхэд л болно
- Spring Boot-тэй автоматаар интеграцчилагдана
- Тест болон development-д хангалттай
- H2 Console-р browser-с database харах боломжтой

## Үр дагавар
- Production-д PostgreSQL руу шилжих шаардлагатай
- App дахин эхлүүлэхэд өгөгдөл устдаг
- application.properties-д credential хадгалах шаардлагагүй