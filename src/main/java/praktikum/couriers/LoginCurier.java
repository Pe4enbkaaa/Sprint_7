package praktikum.couriers;

import java.util.Random;

public class LoginCurier {
    private final String login;
    private final String password;

    public LoginCurier(String login, String password){
        this.login = login;
        this.password = password;
    }
    public static LoginCurier fromCourier(Courier courier){
        return new LoginCurier(courier.getLogin(), courier.getPassword());
    }
    public static LoginCurier courierWithoutLogin(Courier courier){
        return new LoginCurier("", courier.getPassword());
    }
    public static LoginCurier courierWithoutPassword(Courier courier){
        return new LoginCurier(courier.getLogin(), "");
    }
    public static LoginCurier courierWrongLogin(Courier courier){
        return new LoginCurier(courier.getLogin() , "1234");
    }
    public static LoginCurier courierWrongPassword(Courier courier){
        return new LoginCurier("KoliaTest" , courier.getPassword());
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
