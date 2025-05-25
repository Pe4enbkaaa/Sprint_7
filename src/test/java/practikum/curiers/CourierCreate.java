package practikum.curiers;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import praktikum.couriers.Courier;
import praktikum.couriers.CourierClient;
import praktikum.couriers.CouriersChecks;
import praktikum.couriers.LoginCurier;


public class CourierCreate {
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
    public void conflictCreatDoubleCourier(){
        var courier = Courier.random();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdSuccessfully(createResponse);
        ValidatableResponse createResponse1 = courierClient.creatCurier(courier);
        couriersChecks.createdDoubleCourier(createResponse1);
    }
    @Test
    public void conflictCreatWithoutLogin(){
        var courier = Courier.withoutLogin();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }
    @Test
    public void conflictCreatWithoutPassword(){
        var courier = Courier.withoutPassword();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }
    @Test
    public void conflictCreatWithoutFirstName(){
        var courier = Courier.withoutFirstName();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdWithoutField(createResponse);
    }


}
