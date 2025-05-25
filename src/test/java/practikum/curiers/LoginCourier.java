package practikum.curiers;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.couriers.Courier;
import praktikum.couriers.CourierClient;
import praktikum.couriers.CouriersChecks;
import praktikum.couriers.LoginCurier;

import static org.junit.Assert.assertNotEquals;

public class LoginCourier {
    CourierClient courierClient = new CourierClient();
    CouriersChecks couriersChecks = new CouriersChecks();
    private Courier courier;
    @Before
    public void setUp() {
        courier = Courier.random();
        ValidatableResponse createResponse = courierClient.creatCurier(courier);
        couriersChecks.createdSuccessfully(createResponse);
    }

    @Test
    public void loginCourier(){
        var cread = LoginCurier.fromCourier(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        int id = couriersChecks.loginCourier(loginResponse);
        assertNotEquals(0, id);
    }
    @Test
    public void loginCourierWithoutLogin(){
        var cread = LoginCurier.courierWithoutLogin(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        couriersChecks.loginBadRequest(loginResponse);
    }
    @Test
    public void loginCourierWithoutPassword(){
        var cread = LoginCurier.courierWithoutPassword(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        couriersChecks.loginBadRequest(loginResponse);
    }
    @Test
    public void loginCourierWrongLogin(){
        var cread = LoginCurier.courierWrongLogin(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        couriersChecks.loginNotFound(loginResponse);
    }
    @Test
    public void loginCourierWrongPassword(){

        var cread = LoginCurier.courierWrongPassword(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        couriersChecks.loginNotFound(loginResponse);
    }
    @After
    public void deleateCourrier(){
        var cread = LoginCurier.fromCourier(courier);
        ValidatableResponse loginResponse = courierClient.loginCurier(cread);
        int id = couriersChecks.loginCourier(loginResponse);
        courierClient.delete(id);
    }

}
