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
# API Automation Testing Project

## Assignment

### What should be done

*If mentee's project has something to do with REST web-services, the tasks that are described below should be done using a mentee's REST web-service. Mentor is allowed to tailor given tasks to mentee's REST web-service without losing a sense of the given tasks. Otherwise, it should be done using the provided REST web-service.*

**Create a test to verify an http status code:**
* Send the http request by using the GET method.
* The URL is https://jsonplaceholder.typicode.com/users
* Validation: status code of the obtained response is 200 OK

**Create a test to verify an http response header:**
* Send the http request by using the GET method.
* The URL is https://jsonplaceholder.typicode.com/users
* Validation:
    - the content-type header exists in the obtained response
    - the value of the content-type header is application/json; charset=utf-8

**Create a test to verify an http response body:**
* Send the http request by using the GET method:
* The URL is https://jsonplaceholder.typicode.com/users
* Validation: the content of the response body is the array of 10 users

### Acceptance criteria

1. Tests should be created using either Rest Assured or Spring Rest Template.
2. Tests have to include validations that are given.
3. Implemented tests should be readable.
4. Tests must be implemented so that they could be launched in parallel.
5. Naming and Code Conventions should be followed.
6. As for tests of the bonus task, they should be created to test CRUD operations of the given resource.

---

## Project Summary

This project implements automated API testing using **Rest Assured** and **TestNG** frameworks.

### Technologies Used

- **Java 11**
- **Maven 3.x**
- **Rest Assured 5.3.2** - REST API testing framework
- **TestNG 7.8.0** - Testing framework with parallel execution support
- **Jackson 2.15.3** - JSON processing


### Implemented Tests

**UserApiTest (3 tests):**
- `verifyStatusCodeIs200` - Validates HTTP 200 status code
- `verifyContentTypeHeader` - Validates Content-Type header existence and value
- `verifyResponseBodyContainsTenUsers` - Validates response contains 10 users

**UserCrudTest (4 tests - Bonus Task):**
- `createNewUser` - POST operation to create user
- `readSpecificUser` - GET operation to retrieve specific user
- `updateExistingUser` - PUT operation to update user data
- `deleteUser` - DELETE operation to remove user

### Key Features

- All validations implemented as required
- Parallel execution enabled (3 threads)
- Thread-safe and independent tests
- Clean code with proper naming conventions
- Readable test structure using given-when-then pattern
- CRUD operations fully tested (bonus task completed)

### API Endpoint

- **Base URL:** https://jsonplaceholder.typicode.com
- **Resource:** /users
- **Type:** JSONPlaceholder fake REST API

---

## Author

Lucila Gomez - EPAM Training Program

## Notes

All tests use the JSONPlaceholder fake API which simulates REST operations without persisting data. Tests are idempotent and can be executed multiple times safely.
