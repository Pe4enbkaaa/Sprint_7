package praktikum.couriers;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CourierClient {
    @Step("Вызвать метод Post в создании курьера /api/v1/courier")
    public  ValidatableResponse creatCurier(Courier courier){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then().log().all();
    }
    @Step("Вызвать метод Post в залогинивании курьера /api/v1/courier/login")
    public  ValidatableResponse loginCurier(LoginCurier cread){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(cread)
                .when()
                .post("/api/v1/courier/login")
                .then().log().all();
    }
    @Step("Вызвать метод DELETE в удалении курьера /api/v1/courier/ +id")
    public ValidatableResponse delete(int id){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru/")
                .body(Map.of("id", id))
                .when()
                .delete("/api/v1/courier/" +id)
                .then().log().all();
    }
    @Step("Вызвать метод POST в создании заказа /api/v1/orders")
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
