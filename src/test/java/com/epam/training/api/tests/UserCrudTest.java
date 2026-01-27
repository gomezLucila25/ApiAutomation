package com.epam.training.api.tests;

import com.epam.training.api.config.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserCrudTest extends BaseTest {

    private static final String USERS_ENDPOINT = "/users";
    private static final int CREATED_STATUS_CODE = 201;
    private static final int SUCCESS_STATUS_CODE = 200;
    private static final int EXISTING_USER_ID = 1;

    @Test
    public void createNewUser() {
        String requestBody = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"username\": \"johndoe\",\n" +
                "  \"email\": \"john.doe@example.com\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(USERS_ENDPOINT)
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, CREATED_STATUS_CODE);

        String name = response.jsonPath().getString("name");
        assertEquals(name, "John Doe");

        Object userId = response.jsonPath().get("id");
        assertNotNull(userId);
    }

    @Test
    public void readSpecificUser() {
        Response response = given()
                .when()
                .get(USERS_ENDPOINT + "/" + EXISTING_USER_ID)
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SUCCESS_STATUS_CODE);

        int userId = response.jsonPath().getInt("id");
        assertEquals(userId, EXISTING_USER_ID);

        String name = response.jsonPath().getString("name");
        assertNotNull(name);
    }

    @Test
    public void updateExistingUser() {
        String requestBody = "{\n" +
                "  \"id\": " + EXISTING_USER_ID + ",\n" +
                "  \"name\": \"Jane Smith\",\n" +
                "  \"username\": \"janesmith\",\n" +
                "  \"email\": \"jane.smith@example.com\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(USERS_ENDPOINT + "/" + EXISTING_USER_ID)
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SUCCESS_STATUS_CODE);

        String updatedName = response.jsonPath().getString("name");
        assertEquals(updatedName, "Jane Smith");

        int userId = response.jsonPath().getInt("id");
        assertEquals(userId, EXISTING_USER_ID);
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .when()
                .delete(USERS_ENDPOINT + "/" + EXISTING_USER_ID)
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SUCCESS_STATUS_CODE);
    }
}