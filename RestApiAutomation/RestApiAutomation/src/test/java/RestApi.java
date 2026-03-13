import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestApi {

    @Test(priority = 1)
    public void getAllProducts() {

        get("https://dummyjson.com/products")
        .then()
            .statusCode(200)
            .body("products[0].title", equalTo("Essence Mascara Lash Princess"));
    }

    @Test(priority = 2)
    public void getSingleProduct() {

        get("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .log().body();
    }

    @Test(priority = 3)
    public void createProduct() {

        Response response =
            given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"Table\",\"price\":1000,\"stock\":50}")
            .when()
                .post("https://dummyjson.com/products/add");

        response.then()
            .statusCode(201)
            .log().body();
    }

    @Test(priority = 4)
    public void updateProduct() {

        given()
            .header("Content-Type", "application/json")
            .body("{\"title\":\"Updated Laptop\"}")
        .when()
            .put("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .log().body();
    }

    @Test(priority = 5)
    public void deleteProduct() {

        delete("https://dummyjson.com/products/1")
        .then()
            .statusCode(200)
            .log().body();
    }
}