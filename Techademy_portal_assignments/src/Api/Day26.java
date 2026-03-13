package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day26 {

    public static void main(String[] args) {

        try {

            RestAssured.baseURI = "https://example.com";

            String registerBody = "{\n" +
                    "  \"name\": \"Roshni\",\n" +
                    "  \"email\": \"Roshni" + System.currentTimeMillis() + "@mail.com\",\n" +
                    "  \"password\": \"Password123\"\n" +
                    "}";

            Response registerResponse =
                    given()
                            .header("Content-Type", "application/json")
                            .body(registerBody)
                    .when()
                            .post("/api/register")
                    .then()
                            .assertThat()
                            .statusCode(201)
                            .time(lessThan(3000L))
                            .body("accessToken", notNullValue())
                            .body("userId", notNullValue())
                            .extract()
                            .response();

            String responseString = registerResponse.asString();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseString);

            String accessToken = jsonNode.get("accessToken").asText();
            String userId = jsonNode.get("userId").asText();

            System.out.println("User Registered Successfully!");
            System.out.println("User ID: " + userId);
            System.out.println("Access Token: " + accessToken);

            Response profileResponse =
                    given()
                            .header("Authorization", "Bearer " + accessToken)
                    .when()
                            .get("/api/profile")
                    .then()
                            .assertThat()
                            .statusCode(200)
                            .body("name", notNullValue())
                            .body("email", notNullValue())
                            .body("userId", notNullValue())
                            .extract()
                            .response();

            System.out.println("Profile fetched successfully!");

            String updateBody = "{\n" +
                    "  \"name\": \"Updated Roshni\"\n" +
                    "}";

            Response updateResponse =
                    given()
                            .header("Authorization", "Bearer " + accessToken)
                            .header("Content-Type", "application/json")
                            .body(updateBody)
                    .when()
                            .put("/api/profile")
                    .then()
                            .assertThat()
                            .statusCode(200)
                            .body("name", equalTo("Updated Roshni"))
                            .extract()
                            .response();

            System.out.println("Profile updated successfully!");

            System.out.println("\n✅ ALL API TESTS PASSED SUCCESSFULLY!");

        } catch (Exception e) {

            System.out.println("❌ Test Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}