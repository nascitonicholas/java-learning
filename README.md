# 📝 Task Manager Microservice

## Descrição

Este repositório contém o desenvolvimento de um **microserviço de gerenciamento de tarefas pessoais**, implementado em **Java** com **Spring Boot**.

O sistema permite que usuários criem, atualizem, consultem e excluam tarefas, servindo como base para o aprendizado e aplicação de boas práticas de desenvolvimento em Java e seus principais frameworks.

Este projeto será evoluído gradualmente, aplicando práticas como **Dockerização**, **CI/CD** e **deploy em cloud** (AWS).

---

## 📚 Funcionalidades

- ✅ Criar nova tarefa
- ✅ Listar tarefas cadastradas
- ✅ Atualizar status da tarefa
- ✅ Remover tarefa
- ✅ Documentação automática da API (Swagger/OpenAPI)
- ✅ Validação de dados de entrada

**Próximos passos:**

- 🚧 Autenticação com Spring Security
- 🚧 Deploy com Docker
- 🚧 Pipeline de CI/CD
- 🚧 Deploy em ambiente AWS

---

## 🛠️ Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
    - Spring Validation
- **Banco de Dados:** H2 (em memória)
- **Documentação:** Springdoc OpenAPI (Swagger)
- **Build Tool:** Maven
- **Versionamento:** Git
- **Containerização:** Docker (em breve)
- **Cloud:** AWS (em breve)

---

## 📦 Estrutura de Pastas

```
src/
└── main/
├── java/
│ └── br/
│ └── com/
│ └── taskmanager/
│ ├── TaskManagerApplication.java
│ │
│ ├── domain/ # Regra de negócio pura (Entidades, Use Cases)
│ │ ├── model/
│ │ └── service/
│ │
│ ├── application/ # Serviços de aplicação, orquestração de casos de uso
│ │ └── port/
│ │ ├── in/ # Interfaces para entrada (Use Cases)
│ │ └── out/ # Interfaces para saída (Persistence, External Systems)
│ │
│ ├── adapter/ # Implementações das interfaces
│ │ ├── in/ # Entradas (Controller REST, Mensageria, etc.)
│ │ │ └── web/
│ │ │ └── controller/
│ │ │
│ │ └── out/ # Saídas (Repositórios, APIs, etc.)
│ │ └── persistence/
│ │
│ └── config/ # Configurações específicas (Beans, Swagger, etc.)
│
└── resources/
├── application.properties # Configurações da aplicação
└── schema.sql # Scripts de banco (opcional)
```

---

## 🚀 Como Executar Localmente

### Pré-requisitos

- Java 21+
- Maven 3.8+
- IDE (IntelliJ, Eclipse, VSCode) ou terminal

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/task-manager-microservice.git
cd task-manager-microservice
```

2. Compile o projeto:

```bash
mvn clean install
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

4. Acesse a aplicação:
http://localhost:8080

---

5. Acesse a documentação Swagger:
http://localhost:8080/swagger-ui.html

---

## 🧪 Executando os Testes
```bash
mvn test
```

---

## 📝 API Endpoints
| Método | Endpoint           | Descrição                   |
|:------:| ------------------ | --------------------------- |
|  POST  | /api/v1/tasks      | Criar uma nova tarefa       |
|  GET   | /api/v1/tasks      | Listar todas as tarefas     |
|  GET   | /api/v1/tasks/{id} | Obter uma tarefa específica |
|  PUT   | /api/v1/tasks/{id} | Atualizar uma tarefa        |
| DELETE | /api/v1/tasks/{id} | Remover uma tarefa          |

---

## 🧱 Princípios Adotados
- Arquitetura Hexagonal by Tom Hombergs
- RESTful APIs
- Boas práticas de código limpo (Clean Code)
- Testes automatizados
- Validações de dados robustas

---

## 📈 Evolução do Projeto
| Etapa                | Status            |
| -------------------- |-------------------|
| CRUD básico          | ✅ Concluído       |
| Validações           | ✅ Concluído       |
| Documentação Swagger | ✅ Concluído       |
| Dockerização         | ✅ Concluído       |
| CI/CD                | ✅ Concluído       |
| Deploy AWS           | ✅ Concluído       |
| Autenticação JWT     | ✅ Concluído       |

---

## 📝 Licença
Este projeto está licenciado sob a BSD 3-Clause License.

---

## 📬 Contato
- Nome: Nicholas Nascimento
- LinkedIn: https://www.linkedin.com/in/nascito-nicholas/
- E-mail: nascito.nicholas@gmail.com