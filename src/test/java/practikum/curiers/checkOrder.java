package practikum.curiers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class checkOrder {
    @Test
    public void whenGetOrders_thenReturnsValidOrderStructure() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .when()
                .get("/api/v1/orders")
                .then().log().all()
                .statusCode(200)
                .extract().response();
        String body = response.getBody().asString();
        assertFalse(body.isEmpty());
        }
}
