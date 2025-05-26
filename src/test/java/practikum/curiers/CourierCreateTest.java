package practikum.curiers;

import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.Test;
import praktikum.couriers.Courier;
import praktikum.couriers.CourierClient;
import praktikum.couriers.CouriersChecks;
import praktikum.couriers.LoginCurier;


public class CourierCreateTest {
    CourierClient courierClient = new CourierClient();
    CouriersChecks couriersChecks = new CouriersChecks();
    @Test
    public void creatCourier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdSuccessfully(createResponse);
        var cread = LoginCurier.fromCourier(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        int id = couriersChecks.loginCourier(loginResponse);
        courierClient.delete(id);
    }
    @Test
    @Description("Ошибка при создании двух одинаковых курьеров")
    public void conflictCreatDoubleCourier(){
        var courier = Courier.random();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdSuccessfully(createResponse);
        ValidatableResponse createResponse1 = courierClient.creatCurier(courier);
        couriersChecks.createdDoubleCourier(createResponse1);
    }
    @Test
    @Description("Ошибка при создании курьера без логина")
    public void conflictCreatWithoutLogin(){
        var courier = Courier.withoutLogin();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }
    @Test
    @Description("Ошибка при создании курьера без пароля")
    public void conflictCreatWithoutPassword(){
        var courier = Courier.withoutPassword();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }
    @Test
    @Description("Ошибка при создании курьера без имени")
    public void conflictCreatWithoutFirstName(){
        var courier = Courier.withoutFirstName();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }


}
