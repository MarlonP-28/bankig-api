# API Bancaria

# Estructura del Proyecto
banking-api/  (Root of the project)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/bankingapi/  (Package root)
│   │   │       ├── model/          // Entities
│   │   │       │   ├── Persona.java
│   │   │       │   ├── Cliente.java
│   │   │       │   ├── Cuenta.java
│   │   │       │   ├── Movimiento.java
│   │   │       ├── repository/     // JPA Repositories
│   │   │       │   ├── ClienteRepository.java
│   │   │       │   ├── CuentaRepository.java
│   │   │       │   ├── MovimientoRepository.java
│   │   │       ├── service/        // Service Layer
│   │   │       │   ├── ClienteService.java
│   │   │       │   ├── CuentaService.java
│   │   │       │   ├── MovimientoService.java
│   │   │       ├── controller/     // REST Controllers
│   │   │       │   ├── ClienteController.java
│   │   │       │   ├── CuentaController.java
│   │   │       │   ├── MovimientoController.java
│   │   │       │   ├── ReporteController.java  // For F4
│   │   │       ├── exception/      // Custom Exceptions
│   │   │       │   ├── InsufficientFundsException.java
│   │   │       │   ├── ResourceNotFoundException.java
│   │   │       │   ├── GlobalExceptionHandler.java  // @ControllerAdvice
│   │   │       ├── dto/            // Data Transfer Objects (Optional, but good practice)
│   │   │       │   ├── MovimientoDTO.java // Example for Reporte
│   │   │       ├── config/         // Configuration classes (e.g., for async)
│   │   │       │   ├── AsyncConfig.java  // If using @Async
│   │   │       ├── messaging/      //  For Async (SemiSenior/Senior)
│   │   │       │   ├── MessageSender.java
│   │   │       │   ├── MessageReceiver.java
│   │   │       ├── BankingApiApplication.java  // Main Spring Boot app
│   │   ├── resources/
│   │   │   ├── application.properties  // Configuration
│   │   │   └── data.sql              // Initial data (Optional)
│   ├── test/
│   │   ├── java/
│   │   │   └── com/example/bankingapi/
│   │   │       ├── controller/   // Controller tests
│   │   │       │   ├── ClienteControllerTest.java
│   │   │       ├── repository/   // Repository tests
│   │   │       │   ├── ClienteRepositoryTest.java
│   │   │       ├── service/      // Service tests (Optional)
│   │   │           ├── ClienteServiceTest.java
│   ├── docker/         // Docker related files
│   │   ├── Dockerfile          // To containerize the app
│   │   └── docker-compose.yml  // (Optional, for multiple services)
├── pom.xml           // Maven build file (or build.gradle for Gradle)
└── README.md         // Project documentation

Este proyecto implementa una API RESTful para un sistema bancario simple. Permite gestionar clientes, cuentas y transacciones.

## Características

La API ofrece las siguientes funcionalidades:

* **F1: Operaciones CRUD:** Crea, lee, actualiza y elimina operaciones para clientes, cuentas y transacciones. 
* **F2: Gestión de Transacciones:** Registra depósitos y retiros, actualizando los saldos de las cuentas según corresponda. 
* **F3: Manejo de Fondos Insuficientes:** Devuelve un mensaje de error cuando un retiro excede el saldo disponible ("Saldo no disponible"). 
* **F4: Estados de Cuenta:** Genera informes de la actividad de la cuenta dentro de un rango de fechas específico para un cliente determinado. 
* **F5: Pruebas Unitarias:** Incluye pruebas unitarias para la entidad de dominio "Cliente".
* **F6: Pruebas de integración:** Incluye pruebas de integración para validar la interacción de diferentes componentes.
* **F7: Contenerización:** La aplicación se puede implementar usando Docker.

## Tecnologías utilizadas

* Java Spring Boot
* JPA / Hibernate
* Maven
* Base de datos H2 (para desarrollo) / PostgreSQL (para producción)
* Docker
* Postman (para pruebas de API)

## Introducción

### Requisitos previos

* Java JDK 11 o 17
* Maven o Gradle
* Docker (si desea usar Docker)
* PostgreSQL (si desea usar PostgreSQL)
* Postman

### Instalación

1. Clonar el repositorio:

```bash
git clone <repository_url>
cd banking-api
```

2. Configurar la base de datos:

* **H2 (Desarrollo):** No requiere configuración.
* **PostgreSQL:**
* Crear una base de datos.
* Actualiza `src/main/resources/application.properties` con las credenciales de tu base de datos.

3. Crea la aplicación:

```bash
mvn clean install # O 'gradle clean build'
```

### Ejecutando la aplicación

* **Desde tu IDE:**
* Ejecuta la clase `BankingApiApplication.java`.

* **Desde la línea de comandos:**

```bash
java -jar target/banking-api-0.0.1-SNAPSHOT.jar # O el nombre del archivo jar correspondiente
```

### Ejecución con Docker

1. Construir la imagen de Docker:

```bash
docker build -t banking-api ./docker
```

2. Ejecutar el contenedor de Docker:

```bash
docker run -p 8080:8080 banking-api
```

### Puntos de conexión de la API

Los puntos de conexión de la API están disponibles en `http://localhost:8080` (o en el host y puerto correspondientes).

* `/clientes` - Gestionar clientes
* `/cuentas` - Gestionar cuentas
* `/movimientos` - Gestionar transacciones
* `/reportes` - Generar estados de cuenta 

### Configuración de la base de datos

El esquema de la base de datos lo crea Spring Data JPA. También puede encontrar el archivo `BaseDatos.sql` (o `data.sql`) para la configuración inicial de los datos o del esquema. 

### Postman

Se incluye una colección de Postman para facilitar las pruebas de los endpoints de la API. 

### Notas

* Este proyecto sigue las mejores prácticas, incluyendo el uso del patrón Repositorio y la gestión de excepciones. 
* Los mensajes de error se gestionan para proporcionar información útil. 
* La solución está diseñada para ser escalable y resiliente.