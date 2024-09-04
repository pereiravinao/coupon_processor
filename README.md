# Coupon Processor

**Coupon Processor** é um serviço para processamento de cupons de compras, desenvolvido com Spring Boot, RabbitMQ e PostgreSQL.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Hibernate/JPA**
- **RabbitMQ**
- **PostgreSQL**
- **Docker**

## Funcionalidades

- Processamento e gerenciamento de cupons.
- Integração com RabbitMQ para comunicação assíncrona.
- Persistência de dados com PostgreSQL.
- Migração e validação do esquema do banco de dados com Hibernate.

## Pré-requisitos

Antes de executar o projeto, você precisará ter instalados:

- **Docker**
- **Docker Compose**
- **Maven**
- **Java 17**

## Como Executar o Projeto

### 1. Clonar o Repositório

Clone o repositório do projeto:

```bash
git clone https://github.com/seu-usuario/coupon-processor.git
cd coupon-processor
```

### 2. Compilar o Projeto
Utilize o Maven para compilar o projeto:

```bash
mvn clean package
```

### 3. Executar com Docker
O projeto está configurado para rodar com Docker e Docker Compose, incluindo RabbitMQ e PostgreSQL. Execute o seguinte comando para subir os containers:

```bash
docker-compose up --build
```

Isso irá:
- Subir o RabbitMQ na porta 5672 (painel de gerenciamento: http://localhost:15672, credenciais: guest/guest).
- Subir o PostgreSQL na porta 5432 com o banco de dados coupondb.
= Subir a aplicação na porta 8080.

### 4. Variáveis de Ambiente
As variáveis de ambiente podem ser configuradas diretamente no docker-compose.yml ou no Dockerfile. As principais são:
- **SPRING_DATASOURCE_URL**: URL do banco de dados.
- **SPRING_DATASOURCE_USERNAME**: Usuário do banco de dados.
- **SPRING_DATASOURCE_PASSWORD**: Senha do banco de dados.
- **SPRING_JPA_HIBERNATE_DDL_AUTO**: Controle do esquema do banco de dados.

### 5. Acessar o Aplicativo
Após iniciar os containers, o serviço estará disponível em:
```bash
http://localhost:8080
```

### 6. Acessar o RabbitMQ
O painel de controle do RabbitMQ estará disponível em:
```bash
http://localhost:15672
```

### 7. Executar Testes
Para rodar os testes automatizados do projeto, utilize o Maven:
```bash
mvn test
```

