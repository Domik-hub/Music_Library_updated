# Music Library Management System

## 1. OOP Implementation 
The project demonstrates core Object-Oriented Programming principles:
* **Abstract Class & Inheritance**: 
* The `Media` abstract class serves as a template for `Song` and `Podcast` classes, sharing common attributes like `id` and `title`.
* **Interfaces & Polymorphism**: 
* Implemented `Playable` and `Validatable` interfaces. Polymorphism is used in the`Playlist` class to process different media types through a single `playAll()` method.
* **Encapsulation**: Fields are kept `protected` or `private`, and access is managed via public getters and setters to ensure data integrity.
* **Composition**: The `Playlist` class manages a `List<Media>`, demonstrating a "has-a" relationship.



## 2. JDBC & Database Layer
* **Working JDBC Connection**: The system connects to a PostgreSQL database named `musicdb` using the `DriverManager`.
* **CRUD with PreparedStatement**: Database interactions use `PreparedStatement` to prevent SQL injection and ensure secure data handling.
* **SQL Schema**: The database uses a `SERIAL` primary key for automated ID management.

## 3. API & Business Logic 
* **Layered Architecture**: The code is organized into Controller, Service, and Repository layers to separate concerns.
* **Validation & Business Rules**: The `Validatable` interface triggers checks before any data is sent to the repository.



## 4. Exception Handling 
* **Custom Exception Hierarchy**: The project uses custom exceptions like `InvalidInputException` to handle specific runtime errors.

## 5. Setup Instructions
1. Create the table in **pgAdmin**:
```sql
CREATE TABLE media (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);