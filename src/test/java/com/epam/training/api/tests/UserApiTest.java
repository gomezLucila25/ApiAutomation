package com.epam.training.api.tests;

import com.epam.training.api.config.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserApiTest extends BaseTest {

    private static final String USERS_ENDPOINT = "/users";
    private static final int EXPECTED_STATUS_CODE = 200;
    private static final String EXPECTED_CONTENT_TYPE = "application/json; charset=utf-8";
    private static final int EXPECTED_USERS_COUNT = 10;

    @Test
    public void verifyStatusCodeIs200() {
        Response response = given()
                .when()
                .get(USERS_ENDPOINT)
                .then()
                .extract()
                .response();

        int actualStatusCode = response.getStatusCode();
        assertEquals(actualStatusCode, EXPECTED_STATUS_CODE);
    }

    @Test
    public void verifyContentTypeHeader() {
        Response response = given()
                .when()
                .get(USERS_ENDPOINT)
                .then()
                .extract()
                .response();

        String contentType = response.getHeader("Content-Type");
        assertNotNull(contentType);
        assertEquals(contentType, EXPECTED_CONTENT_TYPE);
    }

    @Test
    public void verifyResponseBodyContainsTenUsers() {
        Response response = given()
                .when()
                .get(USERS_ENDPOINT)
                .then()
                .extract()
                .response();

        int usersCount = response.jsonPath().getList("$").size();
        assertEquals(usersCount, EXPECTED_USERS_COUNT);
    }
}