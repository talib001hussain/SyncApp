# Legacy Sync Bridge

## Overview

**Legacy Sync Bridge** is a middleware service built with **Java Spring Boot**, designed to bridge data between a legacy SQL Server database and modern microservices. The application streams data change events to **Apache Kafka**, while a **PostgreSQL Kafka Sink Connector** is responsible for pushing those changes into the microservices' databases.

This system is ideal for gradual modernization efforts, allowing existing systems to co-exist with a new microservice architecture during migration.

---

## Features

- 📡 **Real-time Data Sync**: Detects and streams INSERT, UPDATE, DELETE events from legacy tables.
- 🔁 **Kafka Event Streaming**: Publishes structured JSON payloads to dedicated Kafka topics.
- 🧩 **PostgreSQL Sink Connector**: Automatically writes Kafka topic data into microservices’ PostgreSQL tables.
- 🛠 **Decoupled Architecture**: Sync logic is separate from storage concerns, improving maintainability.
- 🗃️ **Entity Mapping**: Uses MapStruct for converting legacy table rows to Kafka-friendly formats.
- 🛡️ **Scalable & Fault-Tolerant**: Supports retries, logging, and Kafka-based backpressure handling.

---

## Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Apache Kafka**
- **Kafka Connect + PostgreSQL Sink Connector**
- **MapStruct**
- **SQL Server (Legacy DB)**
- **PostgreSQL (Modern DBs)**
- **Lombok**
- **Spring Data JPA**

---

## Architecture

```text
┌────────────┐     Change Detection     ┌────────────┐     Kafka Topics     ┌──────────────────────┐
│ Legacy DB  │ ───────────────────────▶ │ Sync App   │ ───────────────────▶ │ Kafka Sink Connector │
└────────────┘                         └────────────┘                       └──────────────────────┘
     (SQL Server)                          (Spring Boot)                         |
                                                                                 ▼
                                                                       ┌────────────────────┐
                                                                       │ PostgreSQL DBs     │
                                                                       │ (Microservices)    │
                                                                       └────────────────────┘
