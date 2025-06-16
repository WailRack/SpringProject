# 🎓 Educational Spring Microservices Backend

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.3.2.RELEASE-brightgreen.svg)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Used-orange.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## 📚 Описание

Этот проект представляет собой **обучающую микросервисную архитектуру**, реализованную с использованием **Java** и **Spring Boot**. Цель — закрепить знания в построении масштабируемых, отказоустойчивых и слабо связанных микросервисов.

Микросервисы обмениваются сообщениями через **RabbitMQ**, используют **REST API**, реализуют изолированные бизнес-домены и имеют независимые хранилища данных.


---

## 🔧 Стек технологий

- **Java 17**
- **Spring Boot 2.3.2.RELEASE**
- **Spring Cloud Hoxton.SR1**
- **RabbitMQ**
- **Spring Web / WebFlux**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **MapStruct**
- **Docker / Docker Compose**
- **JUnit 5 / Testcontainers**


---

## 🏗 Архитектура

```
[Frontend / Postman]
        ↓
  [API Gateway] --REST--> [Service A] <--→ [Service B]
                                 ↑            ↑
                               RabbitMQ      RabbitMQ
                                 ↓            ↓
                           [Service C]     [Service D]
```
Каждый сервис:
- автономен и запускается независимо
- взаимодействует с другими через **RabbitMQ** (pub/sub и point-to-point)
- подключён к своей базе данных


---


### ✅ Требования

- Docker и Docker Compose
- Java 17+
- Gradle 6.6+
### 🚀 Запуск

```bash
# Сборка проекта
gradle clean install

# Запуск всех микросервисов и брокера сообщений
docker-compose up --build
```


Swagger UI доступен на:  
```
http://localhost:{порт-сервиса}/swagger-ui.html
```


---

## 📁 Структура проекта

```
educational-microservices/
│
├── api-gateway/           # Общий входной шлюз
├── service-user/          # Работа с пользователями
├── service-order/         # Управление заказами
├── service-notification/  # Уведомления через RabbitMQ
├── common-lib/            # Общие DTO, утилиты, мапперы
├── docker-compose.yml     # Инфраструктура
└── README.md
```


---

## ✅ Реализованные возможности

- Асинхронное взаимодействие через RabbitMQ
- Обработка событий (event-driven)
- Изоляция данных между сервисами
- Swagger-документация каждого сервиса
- Unit и интеграционные тесты


---


## 👤 Автор 
**[Ivan]**
🔗 [GitHub](https://github.com/твоя-ссылка)


---

## 📄 Лицензия

Проект распространяется под лицензией MIT. Подробности в файле [LICENSE](LICENSE).
