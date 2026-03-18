# 차쟁이 🚗

드라이브 스팟의 위치 정보와 현재 인원수를 실시간으로 제공하는 웹 서비스

## 기술 스택

| 분류 | 기술 |
|------|------|
| Backend | Spring Boot 4.0.3, Java 17 |
| DB | MySQL 8.0 (JPA / Hibernate) |
| View | JSP + JSTL |
| Map | Leaflet.js 1.9.4 |
| Build | Maven |

## 주요 기능

- 서울 · 경기도 지도 시각화 (Leaflet.js + GeoJSON)
- 서울을 한강 기준 4개 섹션으로 색상 구분 (NW / NE / SW / SE)
- 줌 레벨에 따라 구 단위 ↔ 동 단위 레이어 전환
- 드라이브 스팟 마커 표시 (클릭 시 현재 인원수 팝업, 3초 후 자동 닫힘)

## 실행 방법

### 사전 요구사항
- Java 17
- MySQL 8.0
- Maven

### DB 설정

```sql
CREATE DATABASE anyoneheredb;
```

`src/main/resources/application.properties`에서 DB 접속 정보를 수정하세요.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/anyoneheredb
spring.datasource.username=root
spring.datasource.password=1234
```

### 테이블 구조

```sql
CREATE TABLE spots (
    spot_id   BIGINT PRIMARY KEY,
    spot_name VARCHAR(100),
    latitude  DOUBLE,
    longitude DOUBLE,
    radius_m  INT
);

CREATE TABLE spot_presence (
    spot_id            BIGINT PRIMARY KEY,
    active_user_count  INT,
    calculated_at      DATETIME
);
```

### 서버 실행

```bash
mvn spring-boot:run
```

브라우저에서 `http://localhost:8080` 접속

## API

| Method | URL | 설명 |
|--------|-----|------|
| GET | `/` | 메인 지도 화면 |
| GET | `/api/spots` | 전체 스팟 목록 + 현재 인원수 JSON |

## 패키지 구조

```
com.anyonehere.chajjaengi
├── ChajjaengiApplication.java
├── HomeController.java
├── controller/
│   └── SpotController.java
├── entity/
│   ├── Spot.java
│   └── SpotPresence.java
├── repository/
│   ├── SpotRepository.java
│   └── SpotPresenceRepository.java
└── service/
    └── SpotService.java
```
