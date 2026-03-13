package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Day27 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://example.com";

        String requestBody = "{ \"productName\": \"Laptop\", \"quantity\": 2 }";

        Response createResponse =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                .when()
                        .post("/api/orders")
                .then()
                        .statusCode(201)
                        .time(lessThan(5000L))
                        .extract()
                        .response();

        String orderId = createResponse.jsonPath().getString("orderId");

        Gson gson = new Gson();
        JsonObject createJson = gson.fromJson(createResponse.asString(), JsonObject.class);
        String extractedOrderId = createJson.get("orderId").getAsString();

        Response getResponse =
                given()
                        .pathParam("orderId", orderId)
                        .queryParam("includeDetails", true)
                .when()
                        .get("/api/orders/{orderId}")
                .then()
                        .statusCode(200)
                        .body("productName", equalTo("Laptop"))
                        .body("quantity", equalTo(2))
                        .extract()
                        .response();

        Gson gson2 = new Gson();
        JsonObject getJson = gson2.fromJson(getResponse.asString(), JsonObject.class);

        String productName = getJson.get("productName").getAsString();
        int quantity = getJson.get("quantity").getAsInt();

        System.out.println("Order ID: " + extractedOrderId);
        System.out.println("Product Name: " + productName);
        System.out.println("Quantity: " + quantity);
    }
}