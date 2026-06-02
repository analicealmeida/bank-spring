
# Bank Spring API

Sistema bancário desenvolvido com Spring Boot para gerenciamento de clientes, contas, agências e movimentações financeiras.

## Funcionalidades
- Cadastro de clientes
- Cadastro de funcionários
- Cadastro de agências
- Criação de contas correntes
- Criação de contas poupança
- Transferências entre contas
- Pagamentos
- Histórico de movimentações
- Autenticação JWT
- Controle de acesso por perfil

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

## Estrutura do Projeto

```text
src/main/java
├── controller
├── dto
├── exception
├── model
├── repository
├── security
├── service
└── service/impl
```

## Rodando Localmente

Clone o projeto:

```bash
git clone https://github.com/analicealmeida/bank-spring.git
```

Entre na pasta:

```bash
cd bank-spring
```

Execute:

```bash
mvn spring-boot:run
```

## Segurança

- JWT Authentication
- Spring Security
- BCrypt Password Encoder
- Controle de permissões por Roles

## Regras de Negócio

- Transferência entre contas
- Pagamento de contas
- Controle de saldo
- Registro de movimentações
- Herança entre Conta Corrente e Conta Poupança

## Próximas Melhorias

- [ ] Swagger/OpenAPI EM ANDAMENTO
- [ ] Testes Unitários (JUnit + Mockito) EM ANDAMENTO
- [ ] Docker - EM ANDAMENTO
- [ ] Deploy na Nuvem
- [ ] Testcontainers
