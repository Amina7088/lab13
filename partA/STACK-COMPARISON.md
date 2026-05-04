# STACK-COMPARISON.md

## Судалсан хувилбарууд

### 1. Spring Boot + PostgreSQL (Java 17)
**Давуу тал:**
- Layered architecture (Controller → Service → Repository) нь Mini Library-д
  төгс тохирно
- JPA/Hibernate ORM — SQL бичихгүйгээр entity relationship зохицуулна
- Spring Security, Bean Validation built-in
- Маш өргөн баримт бичиг, community

**Сул тал:**
- Boilerplate код их (Java verbose)
- JVM startup удаан

---

### 2. Node.js + Express + PostgreSQL (TypeScript)
**Давуу тал:**
- Хурдан prototype хийх боломжтой
- npm ecosystem маш том
- JSON-first — REST API-д хялбар

**Сул тал:**
- ORM (Prisma/TypeORM) тохиргоо нэмэлт цаг зарна
- Type safety Java-тай харьцуулахад сул (TypeScript ч гэсэн)
- Layered architecture enforcing хийхэд extra discipline шаардана

---

### 3. Django + PostgreSQL (Python)
**Давуу тал:**
- Admin panel автоматаар гарна — library management-д тустай
- ORM хүчтэй, migration автомат
- Rapid development

**Сул тал:**
- Python GIL — concurrent request-д хязгаартай
- REST API-д DRF (Django REST Framework) нэмж суулгах шаардлагатай
- Java-тай харьцуулахад enterprise pattern сул

---

## Харьцуулалтын хүснэгт

| Шалгуур      | Spring Boot | Node.js + Express | Django |
|--------------|-------------|-------------------|--------|
| ORM чанар    | ★★★★★ | ★★★☆☆ | ★★★★☆ |
| Type safety  | ★★★★★ | ★★★★☆ | ★★★☆☆ |
| Layered arch | ★★★★★ | ★★★☆☆ | ★★★★☆ |
| Хурдан эхлэх | ★★★☆☆ | ★★★★★ | ★★★★☆ |
| Баримт бичиг | ★★★★★ | ★★★★☆ | ★★★★★ |

---

## Сонголт: Spring Boot + PostgreSQL

**Үндэслэл:**
Mini Library системд дараах 3 шаардлага голлоно:

1. **Entity relationship** — Book, Member, Loan хоорондын холбоо
   JPA/Hibernate-р хамгийн цэвэр илэрхийлэгдэнэ
2. **Business logic тусгаарлалт** — Service layer pattern
   Spring Boot-д энэ нь framework-ийн дизайны нэг хэсэг
3. **Тест бичих хялбар** — JUnit 5 + Mockito Spring-тэй нягт
   интеграцитай, @MockBean, @WebMvcTest built-in

AI-тай хийсэн харьцуулалтын чат → `ai-sessions/plan.md`