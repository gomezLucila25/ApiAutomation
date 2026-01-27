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