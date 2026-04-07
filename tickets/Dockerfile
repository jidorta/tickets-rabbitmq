# Usa una imagen base de Java 21
FROM eclipse-temurin:21-jdk-alpine

# Carpeta de la app dentro del contenedor
WORKDIR /app

# Copia el pom y el src
COPY pom.xml .
COPY src ./src

# Construye la app
RUN ./mvnw clean package -DskipTests

# Expone el puerto que usa tu app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "target/tickets-rabbitmq-0.0.1-SNAPSHOT.jar"]