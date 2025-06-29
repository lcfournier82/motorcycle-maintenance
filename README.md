
# 🏍️ Motorcycle Maintenance API

API REST desenvolvida com **Java 21 + Spring Boot** para controle de manutenções de motocicletas.  
Inclui cache com Redis, logs estruturados no Elasticsearch, mensageria com RabbitMQ e documentação com Swagger UI.

## 📦 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA + PostgreSQL
- Redis (Cache)
- RabbitMQ (Mensageria)
- Elasticsearch + Logstash (Logs)
- Swagger UI (Documentação)
- Clean Code + SOLID + Clean Architecture

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos

- Java 21
- Docker (recomendado para Redis, RabbitMQ, Elasticsearch)
- PostgreSQL rodando em `localhost:5432`

### 📥 Clonando o projeto

```bash
git clone https://github.com/seu-usuario/motorcycle-maintenance-api.git
cd motorcycle-maintenance-api
```

### 🔧 Configure o banco e tabelas

Crie o banco com o script:

```sql
CREATE DATABASE motorcycle_maintenance;
```

Em seguida, execute o script de criação de tabelas em `scripts/create_motorcycle_maintenance_db.sql`.

### ▶️ Inicie a aplicação

```bash
./mvnw spring-boot:run
```

## 🧪 Testando a API

- Acesse o Swagger UI:  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

- Endpoints principais:
  - `GET /api/maintenances/upcoming` — Lista manutenções próximas
  - `POST /api/maintenances` — Cadastra nova manutenção

## 📁 Estrutura de Pastas (Clean Architecture)

```
motorcycle-maintenance/
├── domain/
│   ├── model/
│   └── repository/
├── application/
│   └── service/
├── infrastructure/
│   ├── controller/
│   ├── persistence/
│   ├── messaging/
│   ├── config/
│   ├── cache/
│   └── logging/
```

## 📚 Documentação

- Swagger UI: `/swagger-ui.html`
- Documentação OpenAPI gerada automaticamente

## 🧰 Serviços externos (usando Docker)

```bash
docker run -d -p 6379:6379 redis
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3-management
docker run -d -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.17.0
docker run -d -p 5000:5000 logstash
```

## 📝 Autor

**Leonardo Fournier**  
Tech Lead & Desenvolvedor Backend

## ✅ Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
