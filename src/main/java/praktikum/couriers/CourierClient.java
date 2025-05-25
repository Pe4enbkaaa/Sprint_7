package praktikum.couriers;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CourierClient {
    public  ValidatableResponse creatCurier(Courier courier){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then().log().all();
    }
    public  ValidatableResponse loginCurier(LoginCurier cread){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(cread)
                .when()
                .post("/api/v1/courier/login")
                .then().log().all();
    }
    public ValidatableResponse delete(int id){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(Map.of("id", id))
                .when()
                .post("/api/v1/courier/" +id)
                .then().log().all();
    }
    public ValidatableResponse creatOrder(CreateOrder order){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(order)
                .when()
                .post("/api/v1/orders")
                .then().log().all();
    }
}
