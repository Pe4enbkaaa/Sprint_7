package praktikum.couriers;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CouriersChecks {
    @Step("Проверка на создения заказа (201) и получении ok: true")
    public void createdSuccessfully(ValidatableResponse response) {
        boolean creted = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");
        ;
        Assert.assertTrue(creted);

    }
    @Step("Проверка на ошибку 409 и получении сообщения: Этот логин уже используется")
    public void createdDoubleCourier(ValidatableResponse response) {
        String message = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CONFLICT)
                .extract()
                .path("message");
        ;
        String text = "Этот логин уже используется";
        assertEquals(text, message);
    }
    @Step("Проверка на ошибку плохого запроса (400) " +
            "и получении сообщения: Недостаточно данных для создания учетной записи")
    public void createdWithoutField(ValidatableResponse response) {
        String message = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message");
        ;
        String text = "Недостаточно данных для создания учетной записи";
        assertEquals(text, message);
    }

    @Step("Проверка на получение id (200) и получении id и номер")
    public int loginCourier(ValidatableResponse response) {
        int id = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");
        ;
        return id;
    }
    @Step("Проверка на ошибку плохого запроса (400) " +
            "и получении сообщения: Недостаточно данных для входа")
    public void loginBadRequest(ValidatableResponse response) {
        String message = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message");
        ;
        String text = "Недостаточно данных для входа";
        assertEquals(text, message);
    }

    @Step("Проверка на ошибку Не найдено (404) " +
            "и получении сообщения: Учетная запись не найдена")
    public void loginNotFound(ValidatableResponse response) {
        String message = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND)
                .extract()
                .path("message");
        ;
        String text = "Учетная запись не найдена";
        assertEquals(text, message);
    }
    @Step("Проверка успешное создания (201) и получении номера track")
    public void creatingOrder(ValidatableResponse response) {
    int track = response
            .assertThat()
            .statusCode(HttpURLConnection.HTTP_CREATED)
            .extract()
            .path("track");
    ;
        assertNotEquals(0, track);
}

}
