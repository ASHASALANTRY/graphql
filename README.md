# 🔗 GraphQL Java with Spring Boot Example

This project demonstrates the use of **GraphQL** in a **Spring Boot** application. It provides a simple setup with schema definitions, resolver implementations, and GraphQL query handling using the `graphql-java` and `graphql-java-tools` libraries.

---

## ✨ Features

- Spring Boot integration with GraphQL
- Schema-first GraphQL setup (`.graphqls` file)
- Query resolvers using `GraphQLQueryResolver` interface
- Simple domain-driven structure using model, service, and resolver layers
- Easy to extend with mutations and real database integration

---

## 🌱 What is GraphQL with Spring Boot?

**GraphQL** is a query language for APIs and a runtime for executing those queries. Unlike REST, which exposes multiple endpoints for different resources, GraphQL provides a single endpoint where clients specify exactly what data they need.

When combined with **Spring Boot**, GraphQL enables:

- 🚀 Schema-first development with `.graphqls` files
- 🧹 Strong type-safety with Java models and DTOs
- ⚙️ Simple and clean resolver logic using interfaces like `GraphQLQueryResolver`, `GraphQLMutationResolver`
- 🔍 Precise data fetching to avoid over-fetching/under-fetching common in REST

### How Spring Boot GraphQL Works in This Project

| Component               | Description                                                               |
| ----------------------- | ------------------------------------------------------------------------- |
| `schema.graphqls`       | Defines types (`Employee`) and query entry points (`getEmployee`)         |
| `Employee` model        | Maps to GraphQL type `Employee`                                           |
| `EmployeeQueryResolver` | Implements `GraphQLQueryResolver` to handle `getEmployee` queries         |
| `EmployeeService`       | Contains logic to return mocked data                                      |
| `/graphql` endpoint     | Automatically configured GraphQL HTTP endpoint by Spring Boot integration |

---

## 📂 Project Structure

```
graphql/
├── src/
│   └── main/
│       ├── java/com/example/graphql/
│       │   ├── controller/              # (Optional) REST controllers
│       │   ├── model/                   # Java model for GraphQL types
│       │   ├── resolver/                # Query resolver classes
│       │   └── service/                 # Business logic layer
│       └── resources/
│           ├── schema.graphqls          # GraphQL schema definition
│           └── application.properties   # Spring Boot app config
├── pom.xml                              # Maven dependencies and plugins
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven
- IntelliJ / Eclipse (optional)

### Run the App

```bash
git clone https://github.com/ASHASALANTRY/graphql.git
cd graphql
mvn spring-boot:run
```

Access GraphQL at:\
👉 `http://localhost:8080/graphql`

You can test queries using:

- [Altair](https://altair.sirmuel.design/)
- [GraphQL Playground](https://github.com/graphql/graphql-playground)
- Postman

---

## 📘 Sample Query

```graphql
query {
  getEmployee(id: 1) {
    id
    name
    department
  }
}
```

### Schema Snippet

```graphql
type Query {
  getEmployee(id: Int!): Employee
}

type Employee {
  id: Int
  name: String
  department: String
}
```

---

## 📖 How the Query is Handled

1. **Schema Definition**\
   The schema file (`schema.graphqls`) defines the `getEmployee` query.

2. **Query Resolver**\
   The `EmployeeQueryResolver` class implements `GraphQLQueryResolver` and maps the `getEmployee` query to a Java method.

3. **Service Layer**\
   The resolver delegates logic to `EmployeeService`, which returns a mock `Employee` object.

4. **Response**\
   The GraphQL server serializes the returned object and sends a structured JSON response.

---

