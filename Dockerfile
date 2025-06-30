# Etapa 1: build (multi-stage)
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copia o projeto para dentro da imagem
COPY . .

# Executa o build do jar (necessário mvnw + wrapper configurado)
RUN ./mvnw clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia o jar da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão da aplicação Spring Boot
EXPOSE 8081

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]