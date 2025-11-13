
# 📚 Library Management System API (Backend)

## 📌 Project Overview

This is a **RESTful API** for a Library Management System. It's built with Spring Boot to demonstrate proficiency in **backend development**, relational database usage (MySQL), and the implementation of a standard layered architecture.

| Project Status | Version |
| :--- | :--- |
| **Complete** | `v1.0.0` |

---

## 🚀 Technology Stack

| Component | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 17+ | Core programming language. |
| **Framework** | Spring Boot 3+ | Rapid API development and dependency management. |
| **Base de Datos** | MySQL | Relational data persistence. |
| **Persistencia** | Spring Data JPA / Hibernate | Object-Relational Mapping (ORM). |
| **Build Tool** | Maven | Dependency management and build automation. |
| **Utilities** | Lombok | Reduces boilerplate code (getters/setters). |

---

## 📐 Architecture and Design

The project follows a standard enterprise backend application architecture:

* **Layered Pattern:** Implements the **Controller-Service-Repository** pattern for clear separation of concerns:
    * **`Controller`**: Handles HTTP requests and returns responses.
    * **`Service`**: Contains all **business logic** (borrowing rules, validation, etc.).
    * **`Repository`**: Communicates exclusively with the database via JPA.
* **Error Handling:** Uses **Custom Exceptions** (`BookNotFoundException`, etc.) mapped to appropriate **HTTP Status Codes** (e.g., **404 Not Found** or **400 Bad Request**), ensuring clean API responses.
* **Entities:** **`Book`** and **`User`** are mapped to MySQL tables using JPA annotations.

---

## 🛠️ Local Setup and Execution

Follow these steps to get the API backend running on your local environment.

### Prerequisites

You must have the following installed:

* **JDK (Java Development Kit)** 17 or higher.
* **Maven** 3.x.
* An active **MySQL** server instance.

### 1. Clone the Repository

```bash
git clone [Your GitHub Repository URL]
cd LibraryPOO-Ex
````

### 2\. Database Configuration

1.  Create a schema (database) in your MySQL server named **`library_db`**.

2.  Open `src/main/resources/**application.properties**` and update the connection credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=[your_mysql_username]
    spring.datasource.password=[your_mysql_password]
    ```

### 3\. Run the Application

Execute the project either from your IDE (by running the main class `LibraryPooApplication.java`) or via the terminal:

```bash
# Package and compile the project
mvn clean install

# Execute the generated JAR file
java -jar target/backend-library-0.0.1-SNAPSHOT.jar 
```

The server will be running at: `http://localhost:8080`.

-----

## 🌐 API Endpoints Documentation

The API exposes the following main resources under the base path `/api/books`:

| Method | Endpoint | Description | Path Parameters | HTTP Codes |
| :--- | :--- | :--- | :--- | :--- |
| **`GET`** | `/api/books` | Retrieves the complete list of all books. | N/A | 200 OK |
| **`POST`** | `/api/books` | Adds a new book to the catalog. | Requires JSON `Book` body. | 201 Created |
| **`POST`** | `/api/books/{isbn}/borrow/{userId}` | Borrows a book for the specified user ID. | `isbn`, `userId` | 200 OK, 404 Not Found, 400 Bad Request |
| **`POST`** | `/api/books/{isbn}/return` | Processes the return of a book. | `isbn` | 200 OK |
| **`DELETE`** | `/api/books/{isbn}` | Deletes a book from the catalog. | `isbn` | 204 No Content |

-----

## 🙋 Contact

Feel free to reach out if you have any questions about the implementation or design choices.

* **Author:** Ignacio Casares
* **LinkedIn:** https://www.linkedin.com/in/ignacio-casares-546b1387/

<!-- end list -->

```

