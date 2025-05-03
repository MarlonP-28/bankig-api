# Banking API

This project implements a RESTful API for a simple banking system. It allows managing customers, accounts, and transactions.

## Features

The API provides the following functionalities:

* **F1: CRUD Operations:** Create, Read, Update, and Delete operations for Customers, Accounts, and Transactions. [cite: 15, 16]
* **F2: Transaction Management:** Records both deposits and withdrawals, updating account balances accordingly. [cite: 16, 17, 18]
* **F3: Insufficient Funds Handling:** Returns an error message when a withdrawal exceeds the available balance ("Saldo no disponible"). [cite: 18]
* **F4: Account Statements:** Generates reports of account activity within a specified date range for a given customer. [cite: 19, 20]
* **F5: Unit Testing:** Includes unit tests for the Customer domain entity. [cite: 21]
* **F6: Integration Testing:** Includes integration tests to validate the interaction of different components. [cite: 22]
* **F7: Containerization:** The application can be deployed using Docker. [cite: 3, 10]

## Technologies Used

* Java Spring Boot [cite: 5]
* JPA / Hibernate [cite: 2]
* Maven
* H2 Database (for development) / PostgreSQL (for production)
* Docker
* Postman (for API testing) [cite: 5]

## Getting Started

### Prerequisites

* Java JDK 11 or 17
* Maven or Gradle
* Docker (if you want to use Docker)
* PostgreSQL (if you want to use PostgreSQL)
* Postman

### Installation

1.  Clone the repository:

    ```bash
    git clone <repository_url>
    cd banking-api
    ```

2.  Configure the database:

    * **H2 (Development):** No configuration needed.
    * **PostgreSQL:**
        * Create a database.
        * Update `src/main/resources/application.properties` with your database credentials.

3.  Build the application:

    ```bash
    mvn clean install   #  Or 'gradle clean build'
    ```

### Running the Application

* **From your IDE:**
    * Run the `BankingApiApplication.java` class.
* **From the command line:**

    ```bash
    java -jar target/banking-api-0.0.1-SNAPSHOT.jar  # Or the appropriate jar name
    ```

### Running with Docker

1.  Build the Docker image:

    ```bash
    docker build -t banking-api ./docker
    ```

2.  Run the Docker container:

    ```bash
    docker run -p 8080:8080 banking-api
    ```

### API Endpoints

The API endpoints are available at `http://localhost:8080` (or the appropriate host and port).

* `/clientes` -  Manage customers
* `/cuentas` - Manage accounts
* `/movimientos` - Manage transactions
* `/reportes` -  Generate account statements [cite: 16]

### Database Setup

The database schema is created by Spring Data JPA.  You may also find a `BaseDatos.sql` file (or `data.sql`) for initial data or schema setup. [cite: 33, 34]

### Postman

A Postman collection is included for easy testing of the API endpoints. [cite: 34, 35]

### Notes

* This project follows best practices, including the use of the Repository pattern and exception handling. [cite: 1, 2]
* Error messages are handled to provide informative feedback. [cite: 2]
* The solution is designed to be scalable and resilient. [cite: 10]