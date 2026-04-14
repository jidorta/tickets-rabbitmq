Ticket System - Spring Boot + RabbitMQ
🚀 Descripción

Proyecto backend desarrollado con Java + Spring Boot, que implementa un sistema de gestión de tickets con arquitectura asíncrona utilizando RabbitMQ.

El objetivo es simular un flujo real de procesamiento desacoplado como en sistemas distribuidos modernos.

🧱 Arquitectura

El flujo del sistema es el siguiente:

Cliente (POST API)
        ↓
Controller
        ↓
RabbitMQ (Queue)
        ↓
Consumer
        ↓
Service
        ↓
Base de datos
⚙️ Tecnologías utilizadas
Java 23+
Spring Boot
Spring Web
Spring Data JPA
RabbitMQ
H2 Database / PostgreSQL (según entorno)
JUnit 5
Mockito
📡 Endpoints
Crear ticket
POST /api/tickets
Body
{
  "title": "Example ticket",
  "description": "Ticket description"
}
🧠 Características principales

✔️ Arquitectura asíncrona con RabbitMQ
✔️ Consumer para procesamiento de mensajes
✔️ Persistencia en base de datos
✔️ Validación de datos con Bean Validation
✔️ Tests unitarios e integración

🧪 Testing

El proyecto incluye:

Tests unitarios con Mockito
Tests de integración con MockMvc
Validación del flujo completo (API → RabbitMQ → BD)

📌 Estado del proyecto

🟡 En desarrollo continuo
Se irán añadiendo mejoras como:

Dockerización
H2
Manejo de errores en consumidores
Reintentos de mensajes