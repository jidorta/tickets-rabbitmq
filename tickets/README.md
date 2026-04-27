# 🎫 Ticket Management System

Aplicación backend desarrollada en Java con Spring Boot para la gestión de tickets, implementando comunicación asíncrona mediante RabbitMQ y persistencia en PostgreSQL.

---

## 🚀 Tecnologías utilizadas

- Java 11+
- Spring Boot
- Spring Data JPA
- RabbitMQ
- PostgreSQL
- Maven
- Docker (opcional)

---

## 📖 Descripción

Este proyecto simula un sistema de gestión de tickets donde los eventos se procesan de forma asíncrona utilizando un sistema de mensajería (RabbitMQ).

Permite:
- Crear tickets
- Consultar tickets
- Procesar eventos mediante colas
- Persistir la información en base de datos PostgreSQL

---

## ⚙️ Arquitectura

El sistema se basa en una arquitectura desacoplada mediante mensajería:

- **API REST (Producer)**: expone endpoints para crear y consultar tickets
- **RabbitMQ**: gestiona la comunicación asíncrona
- **Consumer**: procesa los mensajes de la cola
- **PostgreSQL**: almacenamiento persistente de datos

---

## 🔌 Endpoints principales

### Crear ticket
```http
POST /tickets