package praktikum.couriers;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CouriersChecks {
    public void createdSuccessfully(ValidatableResponse response) {
        boolean creted = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");
        ;
        Assert.assertTrue(creted);

    }

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

    public int loginCourier(ValidatableResponse response) {
        int id = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");
        ;
        return id;
    }

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
