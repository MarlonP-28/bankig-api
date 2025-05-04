# Etapa 1: Compilación del proyecto con Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todos los archivos del proyecto
COPY . .

# Ejecuta Maven para compilar y empaquetar el .jar (sin correr tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final ligera para ejecutar el .jar
FROM eclipse-temurin:17-jre-alpine

# Crea el directorio donde irá la app
WORKDIR /app

# Copia el .jar generado desde la imagen anterior
COPY --from=build /app/target/banking-api-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto donde se ejecuta Spring Boot
EXPOSE 8080

# Comando para iniciar la app
CMD ["java", "-jar", "app.jar"]
