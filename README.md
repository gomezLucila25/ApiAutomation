# REST API Test Automation — Rest Assured · TestNG

![Java](https://img.shields.io/badge/Java-11-orange) ![Rest Assured](https://img.shields.io/badge/Rest%20Assured-5.3-green) ![TestNG](https://img.shields.io/badge/TestNG-7.8-red)

Automated API tests for a REST `/users` resource ([JSONPlaceholder](https://jsonplaceholder.typicode.com)), written during the EPAM Test Automation program.

## What it covers

| Test class | Checks |
|---|---|
| `UserApiTest` | Status code `200`, `Content-Type` header present and equal to `application/json; charset=utf-8`, body is an array of 10 users |
| `UserCrudTest` | Full **CRUD**: `POST` create (201 + returned id), `GET` by id, `PUT` update, `DELETE` |

## Design choices

- **given / when / then** structure with Rest Assured, so each test reads like a spec.
- A **shared base config** (`BaseTest`) sets the base URI once. Tests stay short and focused on the assertion.
- **Parallel execution** (3 threads). Tests are independent and idempotent, so they can run in any order.
- Named constants for endpoints and expected codes, with no magic numbers.

## Run

```bash
mvn clean test
```

## Stack

Java 11 · Rest Assured · TestNG · Jackson · Maven

---
Part of my QA automation portfolio → see the full UI framework: [selenium-framework-patterns](https://github.com/gomezLucila25/selenium-framework-patterns)
