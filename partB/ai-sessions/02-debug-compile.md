# AI Session 02 — Compile Error Debug

**Огноо:** 2026-05-06
**Зорилго:** Package болон import алдаануудыг засах

## Тулгарсан бэрхшээл
- `duplicate class` алдаа — package буруу байсан
- Lombok Java 17-тэй нийцэхгүй байсан

## AI санал болгосон зүйлс
- Lombok annotation processor нэмэх — ажиллаагүй
- Lombok version өөрчлөх — ажиллаагүй

## Hallucination жишээ
AI Lombok-г Java 17-тэй ажиллана гэж баталсан
(1.18.30, 1.18.32 хувилбар санал болгосон) — бүгд
амжилтгүй болсон. Эцэст нь Lombok-г бүрэн хасаж
гараар getter/setter бичсэн.