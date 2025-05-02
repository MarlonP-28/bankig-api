# Banking API

This project implements a RESTful API for a simple banking system. It allows managing customers, accounts, and transactions.

## Features

The API provides the following functionalities:

* **F1: CRUD Operations:** Create, Read, Update, and Delete operations for Customers, Accounts, and Transactions.
* **F2: Transaction Management:** Records both deposits and withdrawals, updating account balances accordingly.
* **F3: Insufficient Funds Handling:** Returns an error message when a withdrawal exceeds the available balance ("Saldo no disponible").
* **F4: Account Statements:** Generates reports of account activity within a specified date range for a given customer.
* **F5: Unit Testing:** Includes unit tests for the Customer domain entity.
* **F6: Integration Testing:** Includes integration tests to validate the interaction of different components.
* **F7: Containerization:** The application can be deployed using Docker.

## Technologies Used

* Java Spring Boot
* JPA / Hibernate
* Maven
* H2 Database (for development) / PostgreSQL (for production)
* Docker
* Postman (for API testing)

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