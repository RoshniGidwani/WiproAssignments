package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day28 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://example.com";

        Response tokenResponse =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("clientId", "yourClientId")
                        .formParam("clientSecret", "yourClientSecret")
                .when()
                        .post("/oauth/token")
                .then()
                        .statusCode(200)
                        .time(lessThan(3000L))
                        .extract()
                        .response();

        String accessToken = tokenResponse.jsonPath().getString("access_token");

        Response reportsResponse =
                given()
                        .header("Authorization", "Bearer " + accessToken)
                .when()
                        .get("/api/reports")
                .then()
                        .statusCode(200)
                        .time(lessThan(3000L))
                        .body("$", not(empty()))
                        .body("[0].id", notNullValue())
                        .body("[0].name", notNullValue())
                        .extract()
                        .response();

        reportsResponse.then().body("$", instanceOf(java.util.List.class));
    }
}