package practikum.curiers;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.couriers.CourierClient;
import praktikum.couriers.CouriersChecks;
import praktikum.couriers.CreateOrder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CreatOrder {
    CourierClient courierClient = new CourierClient();
    CouriersChecks couriersChecks = new CouriersChecks();
    private final List<String> colors;
    public CreatOrder(List<String> colors) {
        this.colors = colors;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Arrays.asList("BLACK")},
                {Arrays.asList("GREY")},
                {Arrays.asList("BLACK", "GREY")},
                {null}  // Тест без цвета
        });
    }
@Test
    public void creatOrder(){
    var order = CreateOrder.order(colors);
    ValidatableResponse createRespons = courierClient.creatOrder(order);
    couriersChecks.creatingOrder(createRespons);
}


}
