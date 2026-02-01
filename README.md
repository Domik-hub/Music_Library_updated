# 🎵 Music Library Management System

## 📋 Project Overview
A robust information system for managing a personal music library (Songs and Podcasts). The project follows a strict **N-tier architecture** with a clear separation of concerns between UI, Business Logic, and Data Access layers.

---

## 🛠 Implemented Requirements

### 1. Object-Oriented Programming (OOP)
* **Inheritance & Abstraction**: Utilizes an abstract base class `Media` with specialized subclasses `Song` and `Podcast`.
* **Interfaces**: Implements `Playable` and `Validatable` to define consistent object behaviors.
* **Polymorphism**: Unified processing of different media types within the service layer.

### 2. SOLID Architecture
* **Controller**: Manages user interaction and console I/O.
* **Service**: Handles business logic, duplicate resource checks, and data validation.
* **Repository**: Direct data access via JDBC to a PostgreSQL database.
* **Dependency Injection**: Dependencies are injected through constructors to follow the Dependency Inversion Principle (DIP).

### 3. Advanced Java Features
* **Generics**: Implementation of generic methods in utility classes and repository patterns.
* **Lambdas**: List sorting implemented via lambda expressions in `SortingUtils`.
* **Reflection API**: Dynamic metadata analysis of classes performed in `ReflectionUtils`.
* **Custom Exception Handling**: A specialized hierarchy of exceptions for validation and database errors.

---

## 🗄 Database Schema (PostgreSQL)
The system persists data using the following `media` table structure:

```sql
CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE media (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(100), 
    type VARCHAR(50) NOT NULL, 
    playlist_id INTEGER, 
    CONSTRAINT fk_playlist
      FOREIGN KEY(playlist_id) 
      REFERENCES playlists(id)
      ON DELETE SET NULL
);