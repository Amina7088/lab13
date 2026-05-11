# AI Usage Report — Mini Library Project

## 1. Юуг AI хийсэн, юуг өөрөө хийсэн?

### AI хийсэн зүйлс:
**А хэсэг:**
- STACK-COMPARISON.md-ийн гол агуулга, харьцуулалтын
  хүснэгт
- ARCHITECTURE.md-ийн Mermaid diagram
- ADR-001-ийн template болон агуулга
- CLAUDE.md-ийн no-go zones, AI collaboration rules

**Б хэсэг:**
- Book, Member, Loan entity, DTO, repository, service,
  controller-ийн бүх код
- Slash command-уудын агуулга
- Unit test-үүдийн бүтэц болон test case-үүд
- application.properties тохиргоо
- pom.xml dependency тохиргоо

### Өөрөө хийсэн зүйлс:
- Бүх файлуудыг үүсгэж зөв folder-т байрлуулсан
- Package болон import алдаануудыг олж засварласан
- Lombok-г орхиж гараар getter/setter бичих шийдвэр
  гаргасан
- H2 database ашиглах шийдвэр гаргасан
- Commit message-үүдийг Conventional Commits format-аар
  бичсэн
- AI санал болгосон бүх кодыг review хийж, буруу
  зүйлсийг засварласан

---

## 2. Hallucination 2+ жишээ

### Жишээ 1: Lombok Java 17-тэй ажиллана гэсэн
AI нь Lombok 1.18.30, дараа нь 1.18.32 хувилбарыг
Java 17-тэй ажиллана гэж баталсан. Гэвч хоёулаа
`ExceptionInInitializerError: com.sun.tools.javac.code.TypeTag :: UNKNOWN`
алдаа өгсөн. AI annotationprocessor нэмэх, version
өөрчлөх гэх мэт олон шийдэл санал болгосон — бүгд
амжилтгүй болсон.

**Яаж олж засварласан:** Maven-ий алдааны мессежийг
өөрөө уншиж, Lombok-г бүрэн хасаж гараар
getter/setter бичих шийдвэр гаргасан. Энэ нь
CLAUDE.md-ийн "DO NOT use @Data on Entities" дүрмийг
өргөтгөн Lombok-г бүрэн орхих болсон.

### Жишээ 2: Package нэр буруу санал болгосон
AI import-уудыг нэмэхдээ зарим файлд
`main.java.com.library.entity` гэж буруу package
санал болгосон. Энэ нь Maven-ий source directory
бүтэцтэй зөрчилдөж `duplicate class` алдаа үүсгэсэн.

**Яаж олж засварласан:** Maven-ий алдааны мессежт
`main.java.com.library.entity` гэж буруу namespace
харагдсан. Файл бүрийн эхний мөрийг шалгаж
`package com.library.entity` болгон засварласан.

---

## 3. Security/license-ийн анхаарал

### Security жишээ: FetchType.EAGER санал болгосон
AI анх Loan entity-д `@ManyToOne(fetch = FetchType.EAGER)`
ашиглахыг санал болгосон. Энэ нь N+1 query проблем
үүсгэдэг — нэг loan-г унших бүрт бүх холбоотой
entity-г дуудна, их тооны loan байхад performance
асуудал үүсгэнэ. Мөн хэрэглэгчийн мэдээллийг
шаардлагагүй байхад ачааллах нь аюулгүй байдлын
зарчмыг зөрчинө.

**Яаж засварласан:** CLAUDE.md-д урьдаас
`DO NOT generate @OneToMany with FetchType.EAGER`
гэж no-go zone болгосон байсан тул AI-ын санал
болгосон кодыг `FetchType.LAZY` болгон засварласан.

### License анхаарал:
H2 database нь EPL-2.0 лицензтэй — commercial
project-д ашиглахад зарим хязгаарлалт байдаг.
Production-д PostgreSQL (PostgreSQL License —
илүү чөлөөт) руу шилжих шаардлагатай.

---

## 4. Юуг AI-аар хурдан хийсэн?

### Boilerplate код үүсгэх
Spring Boot-ийн layered architecture дагуу entity,
DTO, repository, service, controller бичих нь маш
цаг авдаг боловч AI-тай хамтран хийхэд хурдан
болсон. Ялангуяа 3 feature (Book, Member, Loan)-ийн
CRUD код, unit test-үүдийг богино хугацаанд
үүсгэсэн.

### Documentation
ARCHITECTURE.md-ийн Mermaid diagram, ADR template,
STACK-COMPARISON.md-ийн харьцуулалтын хүснэгт зэргийг
AI-тай хамтран бичсэн нь цаг хэмнэсэн.

### Debug туслалцаа
Compile алдааны мессежийг AI-д өгөхөд шалтгааныг
тайлбарлаж, засах арга санал болгосон нь хэрэгтэй
байсан — зарим нь ажиллаагүй ч алдааны шалтгааныг
ойлгоход тусалсан.

---

## 5. Юуг AI-аар удаан хийсэн?

### Lombok асуудал
AI Lombok-тэй холбоотой асуудлыг шийдэхдээ олон
удаа буруу шийдэл санал болгосон. Version өөрчлөх,
annotationprocessor нэмэх, settings.json өөрчлөх
гэх мэт 5+ шийдэл туршиж цаг алдсан. Эцэст нь
Lombok-г бүрэн хасах шийдвэрийг өөрөө гаргасан.

### Package/import алдаа
AI import-уудыг нэмэхдээ буруу package нэр
ашигласан. Файл бүрийг гараар шалгаж засварлахад
нэмэлт цаг зарцуулсан.

### VS Code кэш асуудал
AI VS Code-ын дохиог Maven-ы алдаатай хольж
тайлбарласан. VS Code warning байгаа ч Maven
compile хийж чадна гэдгийг ойлгоход цаг зарцуулсан.

---

## 6. Skill atrophy эрсдэлийг яаж зохицуулсан?

Энэ проектод AI-ын үүсгэсэн кодыг шууд ашиглахгүйгээр
дараах зарчмуудыг баримталсан:

**Кодыг ойлгож засварлах:** AI санал болгосон
Lombok-тэй код ажиллаагүй үед өөрөө Java-ийн
getter/setter механизмыг ашиглаж засварласан.
Энэ нь Java-ийн үндсэн ойлголтыг хэрэглэх
боломж болсон.

**Алдааг өөрөө унших:** Maven-ий compile алдааг
AI-д хуулж өгөхийн өмнө өөрөө уншиж ойлгохыг
хичээсэн. `duplicate class`, `cannot find symbol`
гэх мэт алдааны утгыг ойлгосон.

**Шийдвэр өөрөө гаргах:** H2 database ашиглах,
Lombok орхих зэрэг архитектурын шийдвэрүүдийг
AI-ын санал биш өөрөө гаргасан.

**"AI байхгүй" цаг:** Commit message бичих,
folder бүтэц зохион байгуулах, файл нэрлэх зэрэг
ажлуудыг AI-гүйгээр хийсэн. Мөн алдааны мессежийг
эхлээд өөрөө уншиж ойлгохыг хичээсэн.

Ирээдүйд skill atrophy эрсдэлийг бууруулахын тулд
AI үүсгэсэн кодын тал бүрийг тайлбарлаж чадах
байх зорилго тавьсан. Шалгалт AI байхгүйгээр
явагддаг тул практик ойлголт чухал.